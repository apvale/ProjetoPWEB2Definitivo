<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags"%>

<h:header titulo="Lugar errado" tituloPage="Jampa Palace"></h:header>

<div class="erro">
	<div class="col_8">
		<p style="font-size: 30px;">Desculpe o transtorno, mas voc� n�o tem permiss�o para acessar esta p�gina.</p>
	</div>
	
	<div class="col_4">
		<img class="imgerror" src="<c:url value="/design/images/error.png"/>">       
	</div>  
</div>

<a style="text-align: center;" class="button" href="<c:url value="/inicio.jsp"/>">Voltar</a>
