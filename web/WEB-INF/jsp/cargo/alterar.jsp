<%-- 
    Document   : alterar
    Created on : 18/09/2014, 09:33:40
    Author     : Yuri Serrano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo:Alterar</title>
    </head>
    <body>
        <h1>Cargo:Alterar</h1>
        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/controller?command=cargo.alterarPorId">
            <select name="cargos" onchange="this.form.submit()">
                <option id="" value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/>
                    </option>
                </c:forEach>
            </select>
        </form>

    </body>
</html>