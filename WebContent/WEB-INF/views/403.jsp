

	<div class="lc-block">		
		<div class="alert-danger">
			<h3>Usted no tiene permiso para acceder a esta página!</h3>	
		</div>
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" class="button red big" value="Entrar con un usuario diferente" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>		
	</div>	
