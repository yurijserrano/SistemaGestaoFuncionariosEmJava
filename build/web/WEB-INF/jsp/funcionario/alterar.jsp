<%-- 
    Document   : alterar
    Created on : 18/09/2014, 09:33:40
    Author     : 1146322
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionario:Alterar</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}">principal</a>
        <h1>Funcionário:Alterar</h1>
        <br/>
        <form method="POST" action="${pageContext.request.contextPath}/controller?command=funcionario.alterarPorId">
            <label for="funcionarios">Funcionários: </label>
            <select name="funcionarios" onchange="this.form.submit()">
                <option value="">--selecione--</option>
                <c:forEach var="funcionario" items="${funcionarios}">
                    <option value="${funcionario.codigo}">
                        <c:out value="${funcionario.nome}"/> - 
                        <c:out value="${funcionario.cargo.nome}"/>
                    </option>
                </c:forEach>
            </select>
            <br/>
            <input type="button" onclick="location.href = '${pageContext.request.contextPath}/controller?command=funcionario.listar'" value='Cancelar'/>
        </form>
    </body>
</html>