<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<c:choose>
	<c:when test="${empty condominos}">
        Nenhum condomino cadastrado
    </c:when>
	<c:otherwise>
		<table class="striped tight sortable">
			<thead>
				<tr>
					<th>Data</th>
					<th>Condomino</th>
					<th>Apto</th>
					<th>E-mail</th>
					<th>Ativação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${condominos}" var="c">
					<tr id="condomino-lista-condomino-${c.id}">
						<td><fmt:formatDate value="${c.data}" pattern="dd/MM/yyyy"/></td>
						<td>${c.nome}</td>
						<td>${c.apto}</td>
						<td>${c.email}</td>
						<td id="condomino-lista-acoes-${c.id}">
                            <c:choose>
								<c:when test="${!c.ativado}">
									<button class="small square green condomino-lista-aceitar" data-id="${c.id}"><i class="icon-ok"></i> Aceitar</button><button class="small square red condomino-lista-negar" data-id="${c.id}"><i class="icon-remove"></i> Negar</button>
								</c:when>
								<c:otherwise>
									<button class="small square green condomino-lista-editar" data-id="${c.id}"><i class="icon-pencil"></i> Editar</button>
								</c:otherwise>
							</c:choose>
					    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
		    $(function() {
		    	$('.condomino-lista-aceitar').click(function() {
		    		var id = $(this).attr('data-id');
		    		$.post(base_url + 'admin/condominos', { acao: 'aceitar', id: id }, function() {
		    			$('#condomino-lista-acoes-' + id).html('<button class="small square green condomino-lista-editar" data-id="'+id+'"><i class="icon-pencil"></i> Editar</button>');
		    		});
		    	});
		    	
                $('.condomino-lista-negar').click(function() {
                    var id = $(this).attr('data-id');
                    $.post(base_url + 'admin/condominos', { acao: 'negar', id: id }, function() {
                    	$('#condomino-lista-condomino-' + id).fadeOut('slow', function() {
                    		$(this).remove();
                    	});
                    });
                });
		    });
		</script>
	</c:otherwise>
</c:choose>

