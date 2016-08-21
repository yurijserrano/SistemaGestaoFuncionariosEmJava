<%-- 
    Document   : listar
    Created on : 18/09/2014, 09:34:01
    Author     : 1146322
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAM's</title>
    </head>
    <body>

        <a href="/empresa/controller?command=funcionario.formulario">novo</a> |
        <a href="/empresa/controller?command=funcionario.alterar">editar</a> |
        <a href="/empresa/controller?command=funcionario.remover">remover</a> |
        <h1>Funcionários</h1>

        <c:forEach var="funcionario" items="${funcionarios}">
            <c:out value="${funcionario.codigo}"/> 
            <c:out value="${funcionario.nome}"/> - 
            <c:out value="${funcionario.cargo.nome}"/><br/>
        </c:forEach>

    </body>
</html>
