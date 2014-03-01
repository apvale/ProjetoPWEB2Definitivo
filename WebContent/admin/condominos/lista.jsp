<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<my:layout titulo="teste" tituloPage="teste">

<div class="col_9">
<table  class="striped tight sortable">
	<thead><tr>
		<th>Nome</th>
		<th>Apto</th>
		<th>Telefone</th>
	</tr></thead>
	
	<tbody>
		<c:forEach var="condomino" items="${condominos}">
			<c:out value="${condomino.nome}"></c:out>
			<c:out value="${condomino.apto}"></c:out>
			<c:out value="${condomino.telefone}"></c:out>		
		</c:forEach>
	</tbody>
</table>
</div>
</my:layout>