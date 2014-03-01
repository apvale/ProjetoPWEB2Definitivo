<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:layout titulo="Recuperar Senha" tituloPage="Jampa Palace">
	<div class="login">
		<form id="form" class="vertical" action=<c:url value="/condomino/alterar-senha?codigo=${codigo}"/> method="post">
		    <c:choose>
		        <c:when test="${type eq 0}">
		            <div class="notice success">
	                    <i class="icon-ok icon-large"></i> ${message} <a href="#close" class="icon-remove"></a>
	                </div>
	                <a class="button" href="<c:url value="/entrar"/>">Entrar</a> 
		        </c:when>
                <c:when test="${type eq 1}">
                    <div class="notice error">
                        <i class="icon-remove-sign icon-large"></i> ${message} <a href="#close" class="icon-remove"></a>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:if test="${type eq 2}">
	                    <div class="notice error">
	                        <i class="icon-remove-sign icon-large"></i> ${message} <a href="#close" class="icon-remove"></a>
	                    </div>
                    </c:if>
                
		            <label for="senha_1">Senha</label>
		            <input name="senha_1" id="senha_1" type="password" required/>
		            
                    <label for="senha_2">Repita a Senha</label>
                    <input name="senha_2" id="senha_2" type="password" required/>
		            
		            <input name="codigo" type="hidden" value="${codigo}"/>
		            
		            <button type="submit" class="blue">Alterar</button>
                </c:otherwise>
		    </c:choose>
		</form>
	</div>
</my:layout>