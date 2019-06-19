<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.fatecpp.hiper_soft.controller.FornecedorController"%>
<%@page import="br.com.fatecpp.hiper_soft.model.domain.Fornecedor" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hiper Soft - FORNECEDORES</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cadastro.css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
    <c:set var="fornecedores" scope="request" value="${FornecedorController.getUnicaInstancia().consultar('','')}" />
    <jsp:useBean id="c" class="br.com.fatecpp.hiper_soft.model.domain.Fornecedor"/>
    <jsp:setProperty name="c" property="*"/>
    <jsp:setProperty name="c" property="idFornecedor" value="${id}"/>
    <jsp:setProperty name="c" property="razaoSocial" value="${razaoSocial}"/>
    <jsp:setProperty name="c" property="nomeFantasia" value="${nomeFantasia}"/>
    <jsp:setProperty name="c" property="cnpj" value="${cnpj}"/>
    
    <c:set var="action" scope="request" value="${action}"/>
    
    <form action = "${pageContext.request.contextPath}/Fornecedor" method = "POST">
    <fieldset>
        <center><h3>Cadastro de Fornecedores</h3></center>
        <div class="campo">
            <label for="idFornecedor">ID</label>
            <input type="text" id="idFornecedor" name="id" style="width: 5em" value="${f.idFornecedor}" readonly>
        </div>

        <div class="campo">
            <label for="razaoSocial">Razão Social</label>
            <input type="text" id="razaoSocial" name="razaoSocial" style="width: 30em" value="${f.razaoSocial}" >
        </div>

        <div class="campo">
            <label for="nomeFantasia">Nome Fantasia</label>
            <input type="text" id="nomeFantasia" name="nomeFantasia" style="width: 40em" value="${f.nomeFantasia}" >
        </div>
        
        <div class="campo">
            <label for="cnpj">CNPJ</label>
            <input type="text" id="cnpj" name="cnpj" style="width: 40em" value="${f.cnpj}" >
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
        <c:if test="${fornecedores.size() > 0}">
    <fieldset>       
    <center>

            <h3>Lista de Fornecedores</h3>
        <table id="listTable">
            <thead>
                <tr>
                    <th width="5%"></th>
                    <th width="25%">Razão Social</th>
                    <th width="20%">CNPJ</th>
                    <th width="5%"></th>
                    <th width="5%"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="fornecedor" items="${fornecedores}">
                <tr>
                    <td>${fornecedor.getIdFornecedor()}</td>
                    <td>${fornecedor.getRazaoSocial()}</td>
                    <td>${fornecedor.getCnpj()}</td>
                    <td><a href="${pageContext.request.contextPath}/Fornecedor?action=editU&id=${fornecedor.getIdFornecedor()}"><img border="0" alt="Editar fornecedor" src="${pageContext.request.contextPath}/images/ico_edit.png" width="16" height="16"></a></td>
                    <td><a href="${pageContext.request.contextPath}/Fornecedor?action=editD&id=${fornecedor.getIdFornecedor()}"><img border="0" alt="Excluir fornecedor" src="${pageContext.request.contextPath}/images/ico_delete.png" width="16" height="16"></a></td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">Total de fornecedores ${fornecedores.size()}</td>
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
