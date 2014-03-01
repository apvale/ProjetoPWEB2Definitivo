<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<my:layout titulo="Jampa Palace" tituloPage="Jampa Palace">
    <div class="container">
        <h4>Olá, seja bem-vindo!</h4>
        <div class="col_12">
            <p style="color: blue; font-size: 15px; text-align: center">Jampa
                Palace é um dos melhores lugares em que você poderia morar. Através
                deste site, você poderá organizar a sua vida.
            </p>
        </div>
        <div class="botoesprincipais">
            <a class="button blue pop" href="<c:url value="/entrar"/>"> Entrar</a>
            <a class="button pop" href="<c:url value="/condomino/cadastro"/>"> Cadastro - Condômino</a>
        </div>
        <!-- Slideshow -->
        <ul class="slideshow">
            <li><img src="<c:url value="/design/images/predio.jpg"/>" width="550" height="500" /></li>
            <li><img src="<c:url value="/design/images/predio2.jpg"/>" width="550" height="500" /></li>
            <li><img src="<c:url value="/design/images/familia.jpg"/>" width="550" height="500" /></li>
        </ul>
    </div>
</my:layout>