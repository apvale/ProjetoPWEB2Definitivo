<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<my:layout titulo="Painel do Usuário" tituloPage="Jampa Palace" >
	<div class="container">
		<p id="instrucaocadastro">Olá, ${usuario.nome}!</p>
		<div class="col_3 column">
			<ul class="menu vertical">
				<li class="current"><a href="#" class="abrir-programa" data-url="<c:url value="/"/>">Início</a></li>
				<li><a href="#" class="abrir-programa" data-url="<c:url value="perfil"/>">Perfil</a></li>
				<li><a href="#" class="abrir-programa" data-url="<c:url value="admin/pagamentos"/>">Pagamentos</a></li>
				<li><a href="#" class="abrir-programa" data-url="<c:url value="admin/condominos"/>">Condominos</a></li>
				<li>
				    <a href="#">Colaborador</a>
					<ul>
						<li><a href="#" class="abrir-programa" data-url="<c:url value="admin/colaboradores"/>">Listar</a></li>
						<li><a href="#" class="abrir-programa" data-url="<c:url value="admin/colaboradores/cadastrar"/>">Cadastrar</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="col_9 column" id="programas"></div>
	</div>
	<script>
	var base_url = <c:url value="/"/>;
	
	   $(function() {
		    $('.abrir-programa').click(function() {
		    	$.get(base_url+'admin/condominos', function(html) {
	                $('#programas').html(html);
	            }, 'html');
		    });
	   });
	</script>
</my:layout>

