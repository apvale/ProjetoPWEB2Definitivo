<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<my:layout titulo="Painel do Usuário" tituloPage="Jampa Palace" >
	<div class="container">
		<p id="instrucaocadastro">Olá, ${usuario.nome}!</p>
		<div class="col_3 column">
			<ul class="menu vertical">
				<li class="current"><a href="<c:url value="/"/>">Início</a></li>
				<li><a href="<c:url value="/perfil"/>">Perfil</a></li>
				<li><a href="<c:url value="/"/>">Pagamentos</a></li>
				<li><a href="">Condômino</a>
					<ul>
						<li><a href="<c:url value="/condomino"/>">Listar</a></li>
						<li><a href="<c:url value="/condomino/cadastro"/>">Cadastrar</a></li>
					</ul></li>
				<li><a href="">Colaborador</a>
					<ul>
						<li><a href="<c:url value="/colaborador"/>">Listar</a></li>
						<li><a href="<c:url value="/colaborador/cadastro"/>">Cadastrar</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="col_9 column"></div>
	</div>
</my:layout>

