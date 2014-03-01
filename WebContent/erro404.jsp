<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<my:layout titulo="Arquivo não encontrado" tituloPage="Jampa Palace">
	<div class="erro">
		<div class="col_8">
			<p style="font-size: 30px;">Desculpe o transtorno, mas esta página não existe em nosso sistema.</p>
			${pageContext.exception}
		</div>
		<div class="col_4">
			<img class="imgerror" src="<c:url value="/design/images/error.png"/>">       
		</div>  
	</div>
	<a style="text-align: center;" class="button" href="<c:url value="/"/>">Voltar</a>
</my:layout>

