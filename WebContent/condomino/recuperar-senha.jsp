<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:layout titulo="Recuperar Senha" tituloPage="Jampa Palace">
	<div class="login">
		<form id="form" class="vertical" action=<c:url value="/condomino/recuperar-senha"/> method="post">
		    <c:if test="${type eq 0}">
                <div class="notice success">
                    <i class="icon-ok icon-large"></i> ${message} <a href="#close" class="icon-remove"></a>
                </div>
            </c:if>
            <c:if test="${type eq 1}">
                <div class="notice error">
                    <i class="icon-remove-sign icon-large"></i> ${message} <a href="#close" class="icon-remove"></a>
                </div>
            </c:if>
			<label for="email">E-mail</label>
            <input name="email" id="email" type="text" placeholder="Informe seu e-mail" required/> 
			<button type="submit" class="blue">Recuperar</button>
			<a class="button" href="<c:url value="/"/>">Voltar</a> 
		</form>
	</div>
</my:layout>