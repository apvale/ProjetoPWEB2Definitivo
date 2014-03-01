<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h:header titulo="Área do Condômino" tituloPage="Jampa Palace"/>


	<div class="areacondomino">
            <p id="instrucaocadastro">Olá, ${usuario.nome}</p>
            
            <div class="col_2">
                <img class="imgcondomino" src="<c:url value="/design/images/condomino.png"/>">       
            </div> 
         	
         	<div class="col_4">
         		<a class="button blue pop" href="<c:url value="/condomino/alterarcadastro.jsp"/>"> Alterar Cadastro</a>
            	<br> <br>
            	<a class="button blue pop" href="<c:url value="/condomino/historicopagamentos.jsp"/>"> Histório de Pagamentos</a>
         	</div>
         	
      	 	 
      	 	
    </div>
    
        
        <h:footer/>

</body>
</html>