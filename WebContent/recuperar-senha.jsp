<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags"%>

<h:header titulo="Recuperar Senha" tituloPage="Jampa Palace" />

<div class="login">
	<form id="form" action="RecuperarSenha" method="post" class="vertical">
		<label for="email"></label> <input id="email" type="text"
			placeholder="Informe seu e-mail" name="email" /> 

		<button type="submit">Recuperar</button>
		<a class="button" href="<c:url value="/"/>">Voltar</a> 
	</form>
</div>


<h:footer />