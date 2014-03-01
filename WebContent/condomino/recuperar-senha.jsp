<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:layout titulo="Recuperar Senha" tituloPage="Jampa Palace">
	<div class="login">
		<form id="form" class="vertical" action=<c:url value="/condomino/recuperar-senha"/> method="post">
			<label for="email">E-mail</label>
            <input name="email" id="email" type="text" placeholder="Informe seu e-mail" /> 
			<button type="submit" class="blue">Recuperar</button>
			<a class="button" href="<c:url value="/"/>">Voltar</a> 
		</form>
	</div>
</my:layout>