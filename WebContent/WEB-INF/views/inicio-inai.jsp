<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<%@page session="false"%>
<h1>Inai</h1>

<c:if test='${resultado!="" && resultado!=null}'>
	<div class="alert ${alert}">${resultado}</div>
</c:if>

<table class="table table-striped table-bordered">
<tr>
	<th>Id</th>
	<th>Folio</th>
	<th>Contenido</th>	
	<th>Respuesta</th>
	<th>Documento</th>
	<th>Modificar</th>
	<th>Archivos</th>
	<th>Visor inai</th>
</tr>

<c:forEach var="inai" items="${inai}">
<tr>
	<td>${inai.id}</td>
	<td>${inai.folio}</td>
	<td>${inai.contenido}</td>
	<td>${inai.respuesta}</td>
	<td>${inai.documento}</td>	
	
	<td><a href="${pageContext.request.contextPath}/inai/${inai.id}/modificar">Modificar</a></td>
	<td><a href="${pageContext.request.contextPath}/inai/${inai.id}/subir">Subir archivos</a></td>
	<td><a href="${pageContext.request.contextPath}/inai/${inai.id}/archivos">Ver inai</a></td>
</tr>	
</c:forEach>

</table>

<jsp:include page="footer.jsp" />