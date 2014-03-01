<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h:header titulo="Alterar Dados" tituloPage="Jampa Palace"/>

<div class="container">
            <form method="post" action="<c:url value="/condomino/alterarcadastro"/>" class="vertical">
                <c:if test="${type eq 0}">
                    <div class="notice success"><i class="icon-ok icon-large"></i> ${message} <a href="#close" class="icon-remove"></a></div>
                </c:if>
                <c:if test="${type eq 1}">
                    <div class="notice error"><i class="icon-remove-sign icon-large"></i> ${message} <a href="#close" class="icon-remove"></a></div>
                </c:if>
                <div class="col_4 column">
                    <p id="instrucaocadastro">Alterar Dados de Condômino</p>
                    
                    <label for="proprietario">Proprietário: </label>
                    <input id="proprietario" type="text" name="nome" required/>
                    
                    <label for="apto">Apto: </label>
                    <input id="apto" placeholder="${sessionScope.usuario.apto}" type="number" name="apto" min="1" readonly="true" required/>
                    
                    <label for="telefone">Telefone: <span>Ex: 9999-9999</span></label>
                    <input id="telefone" type="text" name="telefone" required pattern="[0-9]{4}\-[0-9]{4}"/>
                    
                    <label for="email">E-mail: </label>
                    <input id="email" type="email" name="email"  required/>
                    
                    <label for="moradores_unidade">N.º de moradores: </label>
                    <input id="moradores_unidade" type="number" name="moradores" required/>
                    
                    <hr/>
                    <p id="instrucaocadastro">Cadastro de Veiculo</p>
                    
                    <label for="placa">Placa: <span>Ex: AAA-9999</span></label>
                    <input id="placa" type="text" name="placa" required pattern="[A-Z]{3}\-[0-9]{4}"/>
                    
                    <label for="modelo">Modelo: </label>
                    <input id="modelo" type="text" name="modelo" required maxlength="30"/>
                    
                    <label for="cor">Cor: </label>
                    <input id="cor" type="text" name="cor" required maxlength="25"/>
                    
                    <label for="marca">Marca: </label>
                    <input id="marca" type="text" name="marca" required maxlength="30"/>
                    
                    <hr/>
                    <button type="submit" class="blue">Cadastrar</button>
                    <button type="reset">Limpar</button>
                    <a class="button" href="<c:url value="/"/>">Voltar</a>
                </div>
            </form>
        </div>

</body>
</html>