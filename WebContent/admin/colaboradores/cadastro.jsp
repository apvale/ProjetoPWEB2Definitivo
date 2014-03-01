<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
   <h:header titulo="Cadastro de Colaboradores" tituloPage="Jampa Palace"></h:header>
            
    
    <div class="container">    
    
            <p id="instrucaocadastro">Cadastro de Colaborador</p>
            <form action="CadastraColaboradorServlet" method="post">
            <div class="col_4 column">
                <label for="nomeColaborador">Nome: </label><br>
                <input id="nomeColaborador" type="text" />
                <br><br>
                
                <label for="profissao">Profissão: </label><br>
                <input id="profissao" type="text" />
                <br><br>
                
                <label for="empresa">Empresa: </label><br>
                <input id="empresa" type="text" />
                <br><br>
                
                <label for="telefone">Telefone: </label><br>
                <input id="telefone" type="text" />
                <br><br>
                
                <label for="horario_atendimento">Horário de Atendimento: </label><br>
                <input id="horario_atendimento" type="text" /><br><br>
                
                <input type="submit" value="Cadastrar" name="cdColaborador">
                <a class="button" href="inicio.html">Voltar</a>
                
            </div>
                    
                
        
            </form>
        </div>
    <h:footer/>
    </body>
    
     <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/kickstart.js"></script> KICKSTART -->
</html>