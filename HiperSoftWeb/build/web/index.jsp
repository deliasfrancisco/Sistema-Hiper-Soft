<%-- 
    Document   : index
    Created on : 17/06/2019, 16:09:44
    Author     : Diego Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hiper Soft</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cadastro.css" />
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="menu.jsp">Inicio</a></li>
                <li><a href="#">Gerenciar<span class="caret"></span></a>
                    <div>
                        <ul>
                            <li><a href="Cliente">Clientes</a></li>
                            <li><a href="#">Produtos</a></li>
                            <li><a href="#">Fornecedores</a></li>
                            <li><a href="#">Vendas</a></li>
                            <li><a href="UsuarioView.jsp">Usuarios</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="#">Venda<span class="caret"></span></a>
                    <div>
                        <ul>
                            <li><a href="Cliente">Nova Venda</a></li>
                            <li><a href="#">Vendas</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="#">Sobre o sistema Hiper Soft</a></li>
                <li><a href="#">Ajuda</a></li>
                <li><a href="index.jsp">Sair</a></li>
            </ul>
        </nav>
    </body>
</html>

