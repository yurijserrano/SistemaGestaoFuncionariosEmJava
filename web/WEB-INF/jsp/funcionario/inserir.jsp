<%-- 
    Document   : inserir
    Created on : 18/09/2014, 09:31:43
    Author     : 1146322
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionário Inserir</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}">principal</a>
        <h1>Funcionário: Inserir</h1>
        <br/>
        <form method="POST" action="${pageContext.request.contextPath}/controller?command=funcionario.inserir">
            <label for="cargo">Cargo: </label>
            <select name="cargo">
                <option value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/>
                    </option>
                </c:forEach>
            </select>
            <br/>
            <label for="nome">Nome: </label>
            <input type="text" name="nome" size="60"/>
            <br/>
            <input type="submit" value="Enviar"/>
            <input type="button" onclick="location.href = '${pageContext.request.contextPath}/controller?command=funcionario.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
