<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Área Condômino</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/kickstart.js"></script> <!-- KICKSTART -->
    <link rel="stylesheet" href="design/css/kickstart.css" media="all" /> <!-- KICKSTART -->
    <link type="text/css" rel="stylesheet" href="design/css/projeto.css"/>
    </head>
    <body>
        <a style="text-decoration: none;" href="inicio.html"><h1>Palace Jampa</h1></a>
        <hr class="alt2" />
            
    
    <div class="container">
    
            <p id="instrucaocadastro">Olá, Sr(a) <% out.println(request.getParameter("usuario")); %></p>
            <div class="col_4">
                <a class="button" href="AlterarDadosCondomino.do">Alterar dados cadastrais</a><br>
            </div>
            
            <div class="col_6">
                <div class="relatoriopagamentos">
                <p>Relatório de Pagamentos por Ano</p><br>
            <label for="anos">Selecione o Ano</label>
                <select id="anos">
                <option value="0">-- Selecione --</option>
                <option value="1">2014</option>
                <option value="2">2013</option>
                <option value="3">2012</option>
                <option value="4">2011</option>
                <option value="5">2010</option>
                <option value="6">2009</option>
                </select>
            <a class="button" href="AlterarDadosCondomino.do">Gerar Relatório</a><br>
            <h6>Relatório será impresso em arquivo do tipo .pdf.</h6>
            </div>
            </div>
            
            
                
            
        
        <div class="col_4">
            <div class="footer">
                <i id="iconecafe" class="icon-coffee"></i><p id="direitos">Projeto PWEB II - Amanda e Ana Paula</p>
            </div>
        </div>
        </div>
    </body>
</html>