<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:layout titulo="Fazer Login" tituloPage="Realizar Login">
	<div class="login">
		<form id="form" action="<c:url value="/entrar"/>" method="post"
			class="vertical">
			<label for="login"></label> <input id="login" type="text"
				placeholder="Login" name="login" /> <label for="senha"></label> <input
				id="senha" type="password" placeholder="Senha" name="senha" />

			<button type="submit">Entrar</button>
			<a class="button" href="<c:url value="/"/>">Voltar</a>
            <a class="button" href="<c:url value="/condomino/recuperar-senha"/>">Recuperar Senha</a>
		</form>
	</div>
</my:layout>