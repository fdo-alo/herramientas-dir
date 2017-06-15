<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #eee;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'" style="background-color: green;">

	<!--h1>Acceso</h1-->

	<div id="login-box" >

		<h2>Introduzca su nombre de usuario y contraseña</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/login" method="post">

		<div class="lc-block">
			<div>
				<input type="text" class="style-4" name="username"
					placeholder="nombre de usuario" />
			</div>
			<div>
				<input type="password" class="style-4" name="password"
					placeholder="contraseña" />
			</div>
			<div>
				<input type="submit" value="Entrar" class="button red small" />
			</div>
			<c:if test="${param.error ne null}">
				<div class="alert-danger">Nombre de usuario y/o contraseña invalidos</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div class="alert-normal">Usted ha cerrado sesión</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	</div>

</body>
</html>