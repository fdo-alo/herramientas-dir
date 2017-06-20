<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<script type="text/javascript">
$(function(){
	$(".datepicker").datepicker({dateFormat: 'yy-mm-dd'});
});
</script>


<div class="col-xs-8 col-xs-offset-2">
<h1>${titulo}</h1>

<sf:form action="${pageContext.request.contextPath}/inai/agregar" commandName="inai" method="POST">

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Consecutivo</label>
	<div class="col-xs-8">
	<sf:input type="text" readonly="true" cssClass="form-control"
		path="id" id="id" value="${consecutivo }" />
		<sf:errors path="id" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Folio</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="folio" id="folio" placeholder="Ej: 64102727011"/>
		<sf:errors path="folio" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Contenido</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="contenido" id="contenido" placeholder="Ej: Solicita copia de..."/>
		<sf:errors path="contenido" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha de recepción</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="frecepcion" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="frecepcion" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha de respuesta</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="frespuesta" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="frespuesta" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Respuesta</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="respuesta" id="respuesta">
	<sf:option value="FUERA DE COMPETENCIA" >FUERA DE COMPETENCIA</sf:option>
	<sf:option value="INFORMACIÓN PÚBLICA">INFORMACIÓN PÚBLICA</sf:option>
	<sf:option value="PENDIENTE">PENDIENTE</sf:option>
	<sf:option value="SE ATIENDE PARCIALMENTE">SE ATIENDE PARCIALMENTE</sf:option>
	<sf:option value="SE PROPORCIONA LA INFORMACIÓN">SE PROPORCIONA LA INFORMACIÓN</sf:option>
	<sf:option value="SE RECHAZA, POR TRATARSE DE INFORMACIÓN CONFIDENCIAL">SE RECHAZA, POR TRATARSE DE INFORMACIÓN CONFIDENCIAL</sf:option>
	<sf:option value="SE RECHAZA, POR TRATARSE DE INFORMACIÓN ESTRATÉGICA">SE RECHAZA, POR TRATARSE DE INFORMACIÓN ESTRATÉGICA</sf:option>
	<sf:option value="SE RECHAZA, POR TRATARSE DE INFORMACIÓN RESERVADA">SE RECHAZA, POR TRATARSE DE INFORMACIÓN RESERVADA</sf:option>
	<sf:option value="SE RECHAZA, POR TRATARSE INFORMACIÓN NO EXISTENTE">SE RECHAZA, POR TRATARSE INFORMACIÓN NO EXISTENTE</sf:option>
	<sf:option value="SE RECHAZA, PORQUE NO SE PUEDEN GENERAR INFORMES AD HOC">SE RECHAZA, PORQUE NO SE PUEDEN GENERAR INFORMES AD HOC</sf:option>
	</sf:select>
		<sf:errors path="respuesta" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Documento</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="documento" id="documento">
	<sf:option value="CORREO ELECTRÓNICO" >CORREO ELECTRÓNICO</sf:option>
	<sf:option value="NOTA INFORMATIVA">NOTA INFORMATIVA</sf:option>
	<sf:option value="OFICIO">OFICIO</sf:option>
	<sf:option value="PENDIENTE">PENDIENTE</sf:option>
	</sf:select>
		<sf:errors path="documento" cssStyle="color:red"/>
	</div>
</div>




<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Número de control</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="numcontrol" id="numcontrol" placeholder="Ej: 25/2016"/>
		<sf:errors path="numcontrol" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Ruta digital</label>
	<div class="col-xs-8">
	<sf:input type="text" readonly="true"  cssClass="form-control" path="digital" id="digital" placeholder="Ej: \\\\172.24.29.176\Normatividad\inai..."/>
		<sf:errors path="digital" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha del vencimiento</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="fvencimiento" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="fvencimiento" cssStyle="color:red"/>
	</div>
</div>



<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">RDA</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="rda" id="rda" placeholder="Ej: 3078/16"/>
		<sf:errors path="rda" cssStyle="color:red"/>
	</div>
</div>


<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Recurso</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="recurso" id="recurso" placeholder="Ej: of 3053 del 2220616"/>
		<sf:errors path="recurso" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Ubicación</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="ubicacion" id="ubicacion" placeholder="Ej: INAI 2014"/>
		<sf:errors path="ubicacion" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Observaciones</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="Observaciones" id="Observaciones" placeholder="Ej: En atención a..."/>
		<sf:errors path="ubicacion" cssStyle="color:red"/>
	</div>
</div>



<div class="pull-right">
<br>
<input class="btn btn-primary" type="submit" value="${boton}">
</div>
</sf:form>

</div>


<div class="col-xs-12">
<br>
	<p>
		<a href="${pageContext.request.contextPath}/inai/">Regresar a la lista de Inai</a>
	</p>
</div>
<jsp:include page="footer.jsp" />