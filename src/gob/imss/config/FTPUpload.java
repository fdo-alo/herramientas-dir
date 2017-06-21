package gob.imss.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUpload {

	String server = SpringConfig.direccionIP;
	int port = 21;
	String user = "anonymous";
	String pass = "";
	FTPClient ftpClient = new FTPClient();
	int returnCode;

	public FTPUpload(String hostDirectory) {
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();

			System.out.println("Is connected?: " + ftpClient.isConnected());

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			if (!checkDirectoryExists(hostDirectory)) {
				createDirectory(hostDirectory);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public FTPUpload() {

	}

	boolean checkFileExists(String filePath) throws IOException {
		boolean exists = true;
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			InputStream inputStream = ftpClient.retrieveFileStream(filePath);
			returnCode = ftpClient.getReplyCode();
			if (inputStream == null || returnCode == 550)
				exists = false;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return exists;
	}

	boolean checkDirectoryExists(String dirPath) throws IOException {

		boolean exists = true;
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(dirPath);
			returnCode = ftpClient.getReplyCode();
			if (returnCode == 550)
				exists = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return exists;
	}

	void createDirectory(String directory) throws IOException {
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			boolean success = ftpClient.makeDirectory(directory);
			showServerReply(ftpClient);
			if (success) {
				System.out.println("Successfully created directory: " + directory);
			} else {
				System.out.println("Failed to create directory. See server's reply.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public void uploadFiles(String hostDirectory, String localFile, InputStream is) {
		hostDirectory = hostDirectory.replace("ftp://" + server + "/", "").replace("%20", " ");

		System.out.println("hostdirectory after replace: " + hostDirectory);

		try {

			// APPROACH #1: uploads first file using an InputStream
			//localFile = "c:/Test/poliza.txt";
			File firstLocalFile = new File(localFile);			
			String firstRemoteFile = firstLocalFile.getName();	

			String completeRemoteFilePath = (hostDirectory.equals("") || hostDirectory == null) ? firstRemoteFile
					: hostDirectory + firstRemoteFile;
			

			if (!(checkFileExists(completeRemoteFilePath))) {
				ftpClient.connect(server, port);
				ftpClient.login(user, pass);
				ftpClient.enterLocalPassiveMode();

				System.out.println("Is connected?: " + ftpClient.isConnected());

				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

				
				//InputStream inputStream = new FileInputStream(firstLocalFile);

				System.out.println("Start uploading first file");

				boolean done = ftpClient.storeFile(completeRemoteFilePath, is);
				
				//ftpClient.completePendingCommand();
				System.out.println("done: " + done);
				//inputStream.close();
				if (done) {
					System.out.println("The first file is uploaded successfully.");
				}
			} else {
				System.out.println("El archivo ya existe");
			}

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
					is.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
