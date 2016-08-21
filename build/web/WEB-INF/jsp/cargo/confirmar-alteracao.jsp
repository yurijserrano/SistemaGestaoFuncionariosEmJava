<%-- 
    Document   : confirmar-alteracao
    Created on : 13/10/2014, 11:31:15
    Author     : 1146322
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Alteração</title>
    </head>
    <body>
        <h1>Cargo:Confirmar alteração</h1>
        <form method="POST" action="${pageContext.request.contextPath}/controller?command=cargo.confirmar-alteracao">
           <label for="codigo">código: </label>
           <input type="text" size="6" readonly="true" name="codigo" value="${cargo.codigo}"/>
           <br/>
           <label for="nome">nome: </label>
           <input type="text" size="40" name="nome" value="${cargo.nome}"/>
           <br/>
           <input type="submit" value="Alterar"/>
           <input type="button" onclick="location.href = 
                '${pageContext.request.contextPath}/controller?command=cargo.listar'" value='Cancelar'/>
           
        </form>
          
    </body>
</html>








