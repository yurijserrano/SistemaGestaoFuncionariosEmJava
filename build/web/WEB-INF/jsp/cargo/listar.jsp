<%-- 
    Document   : listar
    Created on : 18/09/2014, 09:34:01
    Author     : 1146322
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAM's</title>
    </head>
    <body>

        <a href="/empresa/controller?command=cargo.formulario">novo</a> |
        <a href="/empresa/controller?command=cargo.alterar">editar</a> |
        <a href="/empresa/controller?command=cargo.remover">remover</a> |

        <h1>Cargo: listar</h1>
        <c:forEach var="cargo" items="${cargos}">
            <c:out value="${cargo.codigo}"/> <c:out value="${cargo.nome}"/><br> 
        </c:forEach>
    </body>
</html>
