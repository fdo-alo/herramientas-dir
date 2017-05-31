<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />

<div class="col-xs-12 col-md-6" >
 <b>Consecutivo:</b> ${prodecon.numero}
</div>
<div class="col-xs-12 col-md-6"  >
 <b>Queja:</b> ${prodecon.queja}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Promovente:</b> ${prodecon.promovente}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Asunto:</b> ${prodecon.tercerNivel}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha del correo:</b> ${prodecon.fechaCorreo}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Delegación:</b> ${prodecon.delegacion}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Subdelegación:</b> ${prodecon.subdelegacion}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha de respuesta:</b> ${prodecon.fechaRespuesta}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Fecha limite:</b> ${prodecon.fechaLimite}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ubicación física:</b> ${prodecon.ubicacionFisica}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Subcarpeta:</b> ${prodecon.subcarpeta}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Estado:</b> ${prodecon.estado}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ubicación digital:</b> <a href=${prodecon.digital} target="_blank">${prodecon.digital}</a>
</div>
<div class="col-xs-12 col-md-6" >
 <b>Observaciones:</b> ${prodecon.observaciones}
</div>
<div class="col-xs-12 col-md-6" >
 <b>Ultimo estado:</b> ${prodecon.ultimoEdoProdecon}
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
		<a href="${pageContext.request.contextPath}/prodecon/">Regresar a la lista de prodecon</a>
	</p>
</div>

<jsp:include page="footer.jsp" />