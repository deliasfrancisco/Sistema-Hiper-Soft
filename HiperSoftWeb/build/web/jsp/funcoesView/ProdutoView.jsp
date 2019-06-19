<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.fatecpp.hiper_soft.controller.ProdutoController"%>
<%@page import="br.com.fatecpp.hiper_soft.model.domain.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hiper Soft - PRODUTOS</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cadastro.css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
    <c:set var="produtos" scope="request" value="${ProdutoController.getUnicaInstancia().consultar('','')}" />
    <jsp:useBean id="c" class="br.com.fatecpp.hiper_soft.model.domain.Produto"/>
    <jsp:setProperty name="p" property="*"/>
    <jsp:setProperty name="p" property="idProduto" value="${id}"/>
    <jsp:setProperty name="p" property="nome" value="${nome}"/>
    <jsp:setProperty name="p" property="qtdAtual" value="${qtdAtual}"/>
    
    <c:set var="action" scope="request" value="${action}"/>
    
    <form action = "${pageContext.request.contextPath}/Produto" method = "POST">
    <fieldset>
        <h3>Cadastro de Produtos</h3>

        <div class="campo">
            <label for="idProduto">Código</label>
            <input type="text" id="idProduto" name="id" style="width: 5em" value="${p.idProduto}" readonly>
        </div>

        <div class="campo">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" style="width: 30em" value="${p.nome}" >
        </div>

        <div class="campo">
            <label for="sexo">Quantidade</label>
            <input type="text" id="qtdAtual" name="qtdAtual" style="width: 40em" value="${p.qtdAtual}" >
        </div>

        <br />
        <c:if test="${action == null}">
            <input type="hidden" name="action" value="add">
            <button class="botao" type="submit" name="incluir">Incluir</button> 
        </c:if>
        <c:if test="${action == 'editU'}">
            <input type="hidden" name="action" value="update">
            <button class="botao" type="submit" name="salvar">Salvar</button> 
        </c:if>      
        <c:if test="${action == 'editD'}">
            <input type="hidden" name="action" value="delete">
            <button class="botao" type="submit" name="excluir">Excluir</button> 
        </c:if>
    </fieldset>
    </form>    
        <center>
    <fieldset id="msg">
        ${msg}<br/>
    </fieldset>
        </center>
        <c:if test="${produtos.size() > 0}">
    <fieldset>    
        <center>
        <h3>Lista de Produtos</h3>
        <table id="listTable">
            <thead>
                <tr>
                    <th width="5%"></th>
                    <th width="35%">Nome</th>
                    <th width="50%">Quantidade</th>
                    <th width="5%"></th>
                    <th width="5%"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.getIdProduto()}</td>
                    <td>${produto.getNome()}</td>
                    <td>${produto.getQtdAtual()}</td>
                    <td><a href="${pageContext.request.contextPath}/Produto?action=editU&id=${produto.getIdProduto()}"><img border="0" alt="Editar produto" src="${pageContext.request.contextPath}/images/ico_edit.png" width="16" height="16"></a></td>
                    <td><a href="${pageContext.request.contextPath}/Produto?action=editD&id=${produto.getIdProduto()}"><img border="0" alt="Excluir produto" src="${pageContext.request.contextPath}/images/ico_delete.png" width="16" height="16"></a></td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">Total de produtos ${produtos.size()}</td>
                </tr>
            </tfoot>
        </table>
    </fieldset>      
        </center>
                </c:if>
    <script type="text/javascript">
        setTimeout(function(){ 
             document.getElementById("msg").innerHTML = "<br/>";
        }, 5000);
    </script>
    </body>
</html>
