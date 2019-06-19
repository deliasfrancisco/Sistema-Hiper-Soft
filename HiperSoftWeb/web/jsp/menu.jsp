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
                <li><a href="jsp/menu.jsp">Inicio</a></li>
                <li><a href="#">Gerenciar<span class="caret"></span></a>
                    <div>
                        <ul>
                            <li><a href="jsp/funcoesView/ProdutoView.jsp">Produtos</a></li>
                            <li><a href="jsp/funcoesView/FornecedorView">Fornecedores</a></li>
                            <li><a href="jsp/funcoesView/VendasView">Vendas</a></li>
                            <li><a href="jsp/funcoesView/UsuarioView">Usuarios</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="#">Venda<span class="caret"></span></a>
                    <div>
                        <ul>
                            <li><a href="vendaCaixa">Nova Venda</a></li>
                            <li><a href="funcoesView/VendasView">Vendas</a></li>
                        </ul>
                    </div>
                </li>
                <li><a href="#">Sobre o sistema Hiper Soft</a></li>
                <li><a href="#">Ajuda</a></li>
                <li><a href="jsp/LoginView.jsp">Sair</a></li>
            </ul>
        </nav>
    </body>
</html>