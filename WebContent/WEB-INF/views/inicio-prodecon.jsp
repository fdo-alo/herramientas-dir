<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />


<h1>Prodecon</h1>

<c:if test='${resultado!="" && resultado!=null && resultado!="Error"}'>
	<div class="alert alert-success">${resultado}</div>
</c:if>

<c:if test='${resultado!="" && resultado!=null && resultado=="Error"}'>
	<div class="alert alert-error">Error desconocido no se guardo el registro</div>
</c:if>

<table class="table table-striped table-bordered">
<tr>
	<th>Id</th>
	<th>Queja</th>
	<th>Promovente</th>
	<th>Asunto</th>
	<th>Estado</th>
	<th>Modificar</th>
	<th>Archivos</th>
	<th>Visor queja</th>
</tr>

<c:forEach var="prodecon" items="${prodecon}">
<tr>
	<td>${prodecon.numero}</td>
	<td>${prodecon.queja}</td>
	<td>${prodecon.promovente}</td>
	<td>${prodecon.tercerNivel}</td>	
	<td>${prodecon.estado }</td>	
	
	<td><a href="${pageContext.request.contextPath}/prodecon/${prodecon.numero}/modificar">Modificar</a></td>
	<td><a href="${pageContext.request.contextPath}/prodecon/${prodecon.numero}/subir">Subir archivos</a></td>
	<td><a href="${pageContext.request.contextPath}/prodecon/${prodecon.numero}/archivos">Ver queja</a></td>
</tr>	
</c:forEach>

</table>

<jsp:include page="footer.jsp" />