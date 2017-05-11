<%-- 
    Document   : Login
    Created on : 13/04/2017, 10:48:45
    Author     : sala304b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Usuário</h1>
        <hr>
        <a href="javascript:history.back()">Voltar</a><br>
        <div class="erro">${msgErro}</div>
        <!-- Method = post os dados não vao ser enviados via URL
            e sim dentro do corpo da requisicao -->
        <form action="CadastrarUsuario" method="post">
            Nome: <input type="text" name="txtNome" value="${usuario.login}"><br>
            Senha: <input type="password" name="txtSenha"><br>
            <input type="submit" value="Salvar">            
        </form>
    </body>
</html>
