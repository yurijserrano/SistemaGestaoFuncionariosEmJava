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
        <title>Confirmar:Remoção</title>
    </head>
    <body onload="document.getElementById('cargos').selectedIndex = ${funcionario.cargo.codigo}">
        <a href="${pageContext.request.contextPath}">principal</a>
        <h1>Funcionário: confirmar alteração?</h1>
        <br/>
        <form method="POST" action="${pageContext.request.contextPath}/controller?command=funcionario.confirmar-remocao">
            <label for="codigo">Código: </label>
            <input type="text" name="codigo" size="6" readonly="true" value="${funcionario.codigo}"/>
            <br/>
            <label for="nome">Nome: </label>
            <input type="text" name="nome" size="60" readonly="true" value="${funcionario.nome}"/>
            <br/>
            <label for="cargo">Cargo: </label>
            <select name="cargos" id="cargos" readonly="true">
                <option value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/>
                    </option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Excluir"/>
            <input type="button" onclick="location.href = '${pageContext.request.contextPath}/controller?command=funcionario.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
