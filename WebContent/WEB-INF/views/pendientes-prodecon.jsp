<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<script type="text/javascript">	
	$(function(){
		$(".datepicker").datepicker({dateFormat: 'yy-mm-dd'});
	});
</script> 

<script>
$(document).ready(function() {
	$("#reporte").click(function(){
				
		pend = "";
		
		if($("#pend").is(':checked')){
			pend = "pendiente";
		}else{
			pend = "";
		}
				
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/prodecon/reporte",
			data: {inicial: $("#inicial").val(), fin: $("#fin").val(), pendiente: pend},
			dataType: 'json',
			success: function(json){				
				var tr = [];
				//$('#tablaSub').html(tr);
				
				tr.push('<tr><th>Id</th><th>Queja</th><th>Promovente</th><th>Fecha Limite</th><th>Estado</th><th>Observaciones</th></tr>');
				
		        for (var i = 0; i < json.length; i++) {
		            tr.push('<tr>');
		            tr.push("<td>" + json[i].numero + "</td>");
		            tr.push("<td>" + json[i].queja + "</td>");
		            tr.push("<td>" + json[i].promovente + "</td>");
		            tr.push("<td>" + json[i].fechaLimite + "</td>");
		            tr.push("<td>" + json[i].estado + "</td>");
		            tr.push("<td>" + json[i].observaciones + "</td>");		            		            
		            tr.push("</tr>")
		        }
		        $('tbody').html($(tr.join('')));
		}
			
		});
		
	});
});
</script>

<h1>Reporte de pendientes</h1>

<div class="col-xs-12 col-md-6">
Fecha inicial
<input class="datepicker" type="text" id="inicial" >
</div>
<div class="col-xs-12 col-md-6">
Fecha final
<input class="datepicker" type="text" id="fin">

</div>

<div class="col-xs-12 col-md-6">
<input type="checkbox" name="pendiente" value="pendiente" id="pend">Solo pendientes
</div>

<br><br><br>
<input class="pull-right" type="button" id="reporte" value="Obtener datos">

<table class="table table-striped table-bordered">
<tbody>
</tbody>
</table>


<div class="col-xs-12">
<br>
	<p>
		<a href="${pageContext.request.contextPath}/prodecon/">Regresar a la lista de prodecon</a>
	</p>
</div>
<jsp:include page="footer.jsp" />