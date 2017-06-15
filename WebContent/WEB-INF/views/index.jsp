<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />
<%@page session="false"%>
<h1>Inicio</h1>

<h2>Contenido del programa</h2>


<div class="list-group">
<ul>
	<li class="list-group-item list-group-item-action list-group-item-success">Prodecon
	<ul>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">Mostrar: los datos básicos de la queja como id, folio de la queja, nombre del promovente, el asunto de la queja, el estado de la queja.</li>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">Agregar: una nueva queja.</li>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">Modificar: una queja existente.</li>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">Ver: Muestra los datos de la queja.</li>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">Reporte pendientes: Muestra las quejas entre fecha, pudiendo seleccionar si se muestran todas o unicamente las pendientes.</li>
	</ul>	
	</li>
	
	<!-- <li class="list-group-item list-group-item-action list-group-item-success">INAI
	<ul>
		<li class="list-group-item list-group-item-action" style="text-align: justify;">En construcción.</li>
		</ul>
	</li>	 -->
</ul>


</div>



<jsp:include page="footer.jsp" />