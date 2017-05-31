<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />


<h1>${numero} - ${promovente} - ${queja}</h1>
<h2>${digital}</h2>

<!-- label class="control-label">Select File</label>
<input id="input-44" name="input44[]" type="file" multiple class="file-loading">
<div id="errorBlock" class="help-block"></div>
<script>
$(document).on('ready', function() {
    $("#input-44").fileinput({
    	//language: "es",
    	//uploadUrl: '/file-upload-batch/2',    	
        uploadUrl: '${pageContext.request.contextPath}/prodecon/${numero}/upload',       
        maxFilePreviewSize: 10240
    });
    
    $('#input-es').on('fileuploaded', function(event, data, previewId, index) {
        $("#input-es").fileinput('clear');
    });

});
</script-->

<script>
$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        done: function (e, data) {
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo(document.body);
            });
        }
    });
});
</script>

<h1>Spring MVC - jQuery File Upload</h1>
<div style="width:500px;padding:20px">
 
    <input id="fileupload" type="file" name="files[]" data-url="/prodecon/{numero}/upload" multiple>
 
    <div id="dropzone">Drop files here</div>
 
    <div id="progress">
        <div style="width: 0%;"></div>
    </div>
 
    <table id="uploaded-files">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
        </tr>
    </table>

<jsp:include page="footer.jsp" />