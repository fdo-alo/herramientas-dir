<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<div class="col-xs-8 col-xs-offset-2">
<h1>${titulo}</h1>

<sf:form action="${pageContext.request.contextPath}/admin/create" commandName="usuario" method="POST">

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Nombre del usuario</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control"
		path="username" id="username" value="${username}"  placeholder="Introduzca su nombre de usuario" />
		<sf:errors path="username" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Contraseña</label>
	<div class="col-xs-8">
	<sf:input type="password" cssClass="form-control" path="password" id="password" placeholder="Introduzca su contraseña"/>
		<sf:errors path="password" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Cuenta inicialmente activa</label>
	<div class="col-xs-8">
	<sf:checkbox cssClass="form-control" path="enabled" id="enabled" value="${enabled}" checked="checked"  disabled = "true"/>
		<sf:errors path="enabled" cssStyle="color:red"/>
	</div>
</div>


<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Rol</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="authority" id="authority">
	<sf:option value="USER" >USER</sf:option>
	<sf:option value="ADMIN">ADMIN</sf:option>	
	</sf:select>
		<sf:errors path="authority" cssStyle="color:red"/>
	</div>
</div>

<div class="pull-right">
<br>
<input class="btn btn-primary" type="submit" value="Agregar nuevo usuario">
</div>
</sf:form>

</div>


<div class="col-xs-12">
<br>
	<p>
		<a href="${pageContext.request.contextPath}/prodecon/">Regresar a la lista de prodecon</a>
	</p>
</div>
<jsp:include page="footer.jsp" />