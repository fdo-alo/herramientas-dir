<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />


<h1>${numero} - ${promovente} - ${queja}</h1>
<h2>${digital}</h2>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<label class="control-label">Select File</label>
<input id="input-44" name="input44[]" type="file" multiple class="file-loading">
<div id="errorBlock" class="help-block"></div>
<script>



$(document).on('ready', function() {
	
	
	$(document).ajaxSend(function(elm, xhr, s){
	    if (s.type == "POST") {
	        xhr.setRequestHeader('x-csrf-token', "${_csrf.token}");
	    }
	});
	
	
    $("#input-44").fileinput({
    	//language: "es",
    	//uploadUrl: '/file-upload-batch/2',    	
        uploadUrl: '${pageContext.request.contextPath}/prodecon/${numero}/upload',        
       uploadAsync: true,       
        maxFileCount: 10,
       
        maxFilePreviewSize: 10240
    });
    
    $('#input-es').on('fileuploaded', function(event, data, previewId, index) {
        $("#input-es").fileinput('clear');
    });

});
</script>

<jsp:include page="footer.jsp" />