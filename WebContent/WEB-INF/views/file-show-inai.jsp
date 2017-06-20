<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<div class="col-xs-12 col-md-6" >
 <b>Consecutivo:</b> ${inai.id}
</div>
<div class="col-xs-12 col-md-6"  >
 <b>Folio:</b> ${inai.folio}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Contenido:</b> ${inai.contenido}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha de recepción:</b> ${inai.frecepcion}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha de respuesta:</b> ${inai.frespuesta}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Respuesta:</b> ${inai.respuesta}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Documento:</b> ${inai.documento}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Número de control:</b> ${inai.numcontrol}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ubicación digital:</b> <a href=${inai.digital} target="_blank">${inai.digital}</a>
</div>
<div class="col-xs-12 col-md-6" >
 <b>Observaciones:</b> ${inai.observaciones}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha de vencimiento:</b> ${inai.fvencimiento}
</div>
<div class="col-xs-12 col-md-6" >
 <b>RDA:</b> ${inai.rda}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Recurso:</b>${inai.recurso}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Observaciones:</b> ${inai.observaciones}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ubicación:</b> ${prodecon.ultimoEdoProdecon}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ultimo oficio estado:</b> ${prodecon.ofUltimoEdoProdecon}
</div>

<div class="col-xs-12 col-md-6" >
 <b>Fecha último estado:</b> ${prodecon.fechaUltimoEdoProdecon}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Registro último estado:</b> ${prodecon.regUltimoEdoProdecon}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Registro último estado:</b> ${prodecon.regUltimoEdoProdecon}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Orden:</b> ${prodecon.orden}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Resolución:</b> ${prodecon.resolucion}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Monto:</b> ${prodecon.monto}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Acuerdos definitivos</b> ${prodecon.acuerdosDefinitivos}
</div>
<div class="col-xs-12 col-md-6" >
 <b>RFC</b> ${prodecon.rfc}
</div>
<div>
<hr>
<br><br>
</div>
<c:if test="${not empty archivos}">
<table class="table table-striped table-bordered">
<tr>
	<th>Archivo</th>
	
</tr>



</table>
</c:if>
<div class="col-xs-12">
<br>
	<p>
		<a href="${pageContext.request.contextPath}/inai/">Regresar a la lista de inai</a>
	</p>
</div>

<jsp:include page="footer.jsp" />