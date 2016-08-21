<%-- 
    Document   : inserir
    Created on : 18/09/2014, 09:31:43
    Author     : 1146322
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo:Inserir</title>
    </head>
    <body>
        <h1>Cargo:inserir</h1>
        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>
        <form method="POST" action="${pageContext.request.contextPath}/controller?command=cargo.inserir">
            <label for="nome">nome</label>
            <input type="text" name="nome" required="true" size="55"/>
            <br/>
            <input type="submit"/>
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/controller?command=cargo.listar'" value="Cancelar"/>
        </form>
    </body>
</html>
