<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/imss.png">

<title>Herramientas DIR</title>
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"
	rel="stylesheet">
<link href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap theme -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css"
	rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="${pageContext.request.contextPath}/resources/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">



<!-- link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" /-->



<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/theme.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/fileinput.min.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="${pageContext.request.contextPath}/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="${pageContext.request.contextPath}/resources/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<!-- script src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script-->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>

<!-- we code these -->
<%-- <link href="${pageContext.request.contextPath}/resources/css/dropzone.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/js/myuploadfunction.js"></script> --%>

<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jput.min.js"></script>


<!-- file uploader -->
<!-- canvas-to-blob.min.js is only needed if you wish to resize images before upload.
     This must be loaded before fileinput.min.js -->
<script
	src="${pageContext.request.contextPath}/resources/js/plugins/canvas-to-blob.min.js"
	type="text/javascript"></script>
<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview.
     This must be loaded before fileinput.min.js -->
<script
	src="${pageContext.request.contextPath}/resources/js/plugins/sortable.min.js"
	type="text/javascript"></script>
<!-- purify.min.js is only needed if you wish to purify HTML content in your preview for HTML files.
     This must be loaded before fileinput.min.js -->
<script
	src="${pageContext.request.contextPath}/resources/js/plugins/purify.min.js"
	type="text/javascript"></script>
<!-- the main fileinput plugin file -->
<script
	src="${pageContext.request.contextPath}/resources/js/fileinput.min.js"></script>
<!-- bootstrap.js below is needed if you wish to zoom and view file content 
     in a larger detailed modal dialog -->
<%-- 	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script> 	 --%>
<!-- optionally if you need translation for your language then include 
    locale file as mentioned below -->
<script
	src="${pageContext.request.contextPath}/resources/js/locales/es.js"></script>

</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<c:url value="/"/>'>Herramientas DIR</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Prodecon <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/prodecon">Mostrar</a></li>
							<li><a
								href="${pageContext.request.contextPath}/prodecon/agregar">Agregar</a></li>
							<li><a
								href="${pageContext.request.contextPath}/prodecon/reportes">Reporte pendientes</a></li>
							<!--  li> class="dropdown-header">Nav header</li-->
						</ul></li>
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Inai <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/inai">Mostrar</a></li>
							<li><a
								href="${pageContext.request.contextPath}/inai/agregar">Agregar</a></li>
							
							<!--  li> class="dropdown-header">Nav header</li-->
						</ul></li>					
						
						
					<!-- li><a href="${pageContext.request.contextPath}/admin/create">Agregar Usuario</a></li-->
					
					
						<!-- sec:authentication var="principal" property="principal" />
						<li><a>¡Bienvenido ${principal.username}!</a></li-->
					
					
					<li><a href='<c:url value="/logout"/>'>Cerrar Sesión</a></li>
				</ul>


			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">