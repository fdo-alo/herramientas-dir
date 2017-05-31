package gob.imss.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUpload {

	String server = "localhost";
	int port = 21;
	String user = "Fernando";
	String pass = "password";
	FTPClient ftpClient = new FTPClient();
	int returnCode;
	
	public FTPUpload(String hostDirectory)
	{
		try {
			
			ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            
            System.out.println("Is connected?: " + ftpClient.isConnected());
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			
			if(!checkDirectoryExists(hostDirectory))
			{
				createDirectory(hostDirectory);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

	public FTPUpload()
	{
		
       
	}
	
	boolean checkFileExists(String filePath) throws IOException
	{
		InputStream inputStream = ftpClient.retrieveFileStream(filePath);
		returnCode = ftpClient.getReplyCode();
		if(inputStream == null || returnCode == 550)
			return false;
		
		return true;
	}
	
	boolean checkDirectoryExists(String dirPath) throws IOException
	{
		ftpClient.changeWorkingDirectory(dirPath);
		returnCode = ftpClient.getReplyCode();
		if(returnCode == 550)
			return false;
		
		return true;
	}
	
	void createDirectory(String directory) throws IOException
	{
		 // Creates a directory       
        boolean success = ftpClient.makeDirectory(directory);
        showServerReply(ftpClient);
        if (success) {
            System.out.println("Successfully created directory: " + directory);
        } else {
            System.out.println("Failed to create directory. See server's reply.");
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
	
	void uploadFiles(String hostDirectory, String localFile)
	{
		hostDirectory = hostDirectory.replace("ftp://" + server +"/" , "");
		
		 try {
			 
	            ftpClient.connect(server, port);
	            ftpClient.login(user, pass);
	            ftpClient.enterLocalPassiveMode();
	            
	            System.out.println("Is connected?: " + ftpClient.isConnected());
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: uploads first file using an InputStream
	            
	            localFile = "c:/Test/poliza.txt";
	            File firstLocalFile = new File(localFile);
	 
	            String firstRemoteFile =  firstLocalFile.getName();	            
	            
	            
	            String completeRemoteFilePath = (hostDirectory.equals("") || hostDirectory == null) ? firstRemoteFile :  hostDirectory + firstRemoteFile;
	            System.out.println("completeRemoteFilePath: " + completeRemoteFilePath);
	            
	            if(!checkFileExists(completeRemoteFilePath))
	            {
	            	InputStream inputStream = new FileInputStream(firstLocalFile);
	            	 
	                System.out.println("Start uploading first file");
	                
	                
	                boolean done = ftpClient.storeFile(completeRemoteFilePath, inputStream);
	                inputStream.close();
	                if (done) {
	                    System.out.println("The first file is uploaded successfully.");
	                }
	            }else
	            {
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
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	}
}
