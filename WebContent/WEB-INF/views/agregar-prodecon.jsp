<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<script type="text/javascript">
$(function(){
	$(".datepicker").datepicker({dateFormat: 'yy-mm-dd'});
});
</script>

<script>
function obtainSecondLevel()
{
	$("#primerNivel").change(function() {			

		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/prodecon/second",
			data: {primero: $("#primerNivel").val()},
			dataType: 'json',
			success: function(json){
				$("#segundoNivel").empty();
				$("#tercerNivel").empty();
				$.each(json, function(i, value){
					
					$("#segundoNivel").append($('<option>').text(value).attr('value', value));
				});
				
				$.ajax({
					type: "POST",
					url: "${pageContext.request.contextPath}/prodecon/third",
					data: {segundo: $("#segundoNivel").val()},
					dataType: 'json',
					success: function(json){					
						$("#tercerNivel").empty();
						$.each(json, function(i, value){
							
							$("#tercerNivel").append($('<option>').text(value).attr('value', value));
						});
						
				        }
				});
				
				
	        }
		});			
	});
}

function obtainThirdLevel()
{
	$("#segundoNivel").change(function() {			

		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/prodecon/third",
			data: {segundo: $("#segundoNivel").val()},
			dataType: 'json',
			success: function(json){					
				$("#tercerNivel").empty();
				$.each(json, function(i, value){
					
					$("#tercerNivel").append($('<option>').text(value).attr('value', value));
				});
				
		        }
		});			
	});
}
</script> 
<script type="text/javascript">
	$(document).ready(function() {
		obtainSecondLevel();
		
	});		
</script>
 
<script type="text/javascript">
	$(document).ready(function() {
		obtainThirdLevel();		
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {		
		$("#delegacion").change(function() {			

			$.ajax({
				type: "POST",
				url: "${pageContext.request.contextPath}/prodecon/delegaciones",
				data: {delegaciones: $("#delegacion").val()},
				dataType: 'json',
				success: function(json){					
					$("#subdelegacion").empty();
					$.each(json, function(i, value){
						
						$("#subdelegacion").append($('<option>').text(value).attr('value', value));
					});
					
			        }
			});			
		});		
	});
</script>





<div class="col-xs-8 col-xs-offset-2">
<h1>${titulo}</h1>

<sf:form action="${pageContext.request.contextPath}/prodecon/agregar" commandName="prodecon" method="POST">

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Consecutivo</label>
	<div class="col-xs-8">
	<sf:input type="text" readonly="true" cssClass="form-control"
		path="numero" id="numero" value="${consecutivo }" />
		<sf:errors path="numero" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Queja</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="queja" id="queja" placeholder="Ej: 00357-GRO-QR-148-2016"/>
		<sf:errors path="queja" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Promovente</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="promovente" id="promovente" placeholder="Ej: CONSORCIO INDUSTRIAL, S.A. DE C.V."/>
		<sf:errors path="promovente" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Primer nivel</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control"
		path="primerNivel" id="primerNivel" items="${first}"/>
		<sf:errors path="primerNivel" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Segundo nivel</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control"
		path="segundoNivel" id="segundoNivel" items="${segundoNivel}"/>
		<sf:errors path="segundoNivel" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Tercer nivel</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control"
		path="tercerNivel" id="tercerNivel" items="${tercerNivel}"/>
		<sf:errors path="tercerNivel" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha del correo</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="fechaCorreo" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="fechaCorreo" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Delegación</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" 
		path="delegacion" id="delegacion" items="${delegaciones}" />
		<sf:errors path="delegacion" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Subdelegación</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control"
		path="subdelegacion" id="subdelegacion" items="${subdelegaciones}"/>
		<sf:errors path="subdelegacion" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha de respuesta</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="fechaRespuesta" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="fechaRespuesta" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha limite</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="fechaLimite" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="fechaLimite" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Ubicación física</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="ubicacionFisica" id="ubicacionFisica">
	<sf:option value="PRODECON" >Prodecon</sf:option>
	<sf:option value="IFAI">IFAI</sf:option>
	<sf:option value="PROYECTO">Proyecto</sf:option>
	<sf:option value="SIN UBICACION">Sin ubicación</sf:option>
	</sf:select>
		<sf:errors path="ubicacionFisica" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Subcarpeta</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="subcarpeta" id="subcarpeta" placeholder="Ej: 2611-2680"/>
		<sf:errors path="subcarpeta" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Ruta digital</label>
	<div class="col-xs-8">
	<sf:input type="text" readonly="true"  cssClass="form-control" path="digital" id="digital" placeholder="Ej: \\\\172.24.29.176\Normatividad\Quejas..."/>
		<sf:errors path="digital" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Observaciones</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="observaciones" id="observaciones" placeholder="Ej: la queja no cuenta con.."/>
		<sf:errors path="observaciones" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Estado de normatividad</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="estado" id="estado">
		<sf:option value="PENDIENTE" >PENDIENTE</sf:option>
		<sf:option value="TERMINADO">TERMINADO</sf:option>	
	</sf:select>
		<sf:errors path="estado" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Último estado</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="ultimoEdoProdecon" id="ultimoEdoProdecon" >
		<sf:option value="ACUERDO DE ACCIONES DE INVESTIGACIÓN" >ACUERDO DE ACCIONES DE INVESTIGACIÓN</sf:option>
		<sf:option value="ACUERDO DE ADMISIÓN CON REQUERIMIENTO DE INFORME (ARI)">ACUERDO DE ADMISIÓN CON REQUERIMIENTO DE INFORME (ARI)</sf:option>	
	</sf:select>	
		<sf:errors path="ultimoEdoProdecon" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Acuerdos definitivos</label>
	<div class="col-xs-8">
	<sf:select type="text" cssClass="form-control" path="acuerdosDefinitivos" id="acuerdosDefinitivos" items="${tdad}" />	
		<sf:errors path="acuerdosDefinitivos" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Oficio del último estado</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="ofUltimoEdoProdecon" id="ofUltimoEdoProdecon" placeholder="Ej: 50893"/>
		<sf:errors path="ofUltimoEdoProdecon" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row " >
	<label for="example-text-input" class="col-xs-4 col-form-label">Fecha del ultimo estado</label>
	<div class="col-xs-8">
		<sf:input cssClass="form-control datepicker" path="fechaUltimoEdoProdecon" type="text" placeholder="Ej 2016-10-25" />
		<sf:errors path="fechaUltimoEdoProdecon" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Registro del último estado</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="regUltimoEdoProdecon" id="regUltimoEdoProdecon" placeholder="Ej: 4644"/>
		<sf:errors path="regUltimoEdoProdecon" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Orden</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="orden" id="orden" placeholder="Ej: 2255"/>
		<sf:errors path="orden" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Resolución de la Subdelegación</label>
	<div class="col-xs-8">
		<sf:select type="text" cssClass="form-control" path="resolucion" id="resolucion">
		<sf:option value="AUN SIN RESPUESTA" >Aún sin respuesta</sf:option>
		<sf:option value="PROCEDE">Procede</sf:option>
		<sf:option value="NO PROCEDE">No procede</sf:option>
		<sf:option value="NO ES COMPETENCIA DE COBRANZA">No es competencia de cobranza</sf:option>	
	</sf:select>
		<sf:errors path="resolucion" cssStyle="color:red"/>
	</div>
</div>
<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">Monto</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="monto" id="monto" placeholder="Ej: 2536.25"/>
		<sf:errors path="monto" cssStyle="color:red"/>
	</div>
</div>

<div class="form-group row ">
	<label for="example-text-input" class="col-xs-4 col-form-label">RFC</label>
	<div class="col-xs-8">
	<sf:input type="text" cssClass="form-control" path="rfc" id="rfc" placeholder="Ej: TOB9206236F3"/>
		<sf:errors path="rfc" cssStyle="color:red"/>
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
		<a href="${pageContext.request.contextPath}/prodecon/">Regresar a la lista de prodecon</a>
	</p>
</div>
<jsp:include page="footer.jsp" />