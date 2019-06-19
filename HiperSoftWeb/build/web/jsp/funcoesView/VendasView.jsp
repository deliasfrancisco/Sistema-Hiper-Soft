<%@page import="br.com.fatecpp.hiper_soft.model.domain.Venda"%>
<%@page import="br.com.fatecpp.hiper_soft.controller.VendaController" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Hiper Soft - Vendas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cadastro.css" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <h1>Hello World!</h1>
        
        <jsp:useBean id="c" class="br.com.fatecpp.hiper_soft.model.domain.Venda" />
        <jsp:setProperty property="*" name="v" />
        <jsp:setProperty name="v" property="idVenda" value="${venda_cod}" />
        <jsp:setProperty name="v" property="totalVenda" value="${ven_total}" />
        <jsp:setProperty name="v" property="caixaVenda" value="${caixa_cx_cod}" />
    
    <c:set var="vendas" scope="request" value="${VendaController.getUnicaInstancia().consultar(opcao, parametro)}" />
    
    <form action = "${pageContext.request.contextPath}/Venda" method = "POST">
    <fieldset>
        <h3>Vendas Realizadas</h3>

        <div class="campo">
            <label for="idVenda">Numero venda</label>
            <input type="text" id="idVenda" name="venda_cod" style="width: 5em" value="${v.venda_cod}" readonly>
        </div>

        <div class="campo">
            <label for="nome">Valor</label>
            <input type="text" id="totalVenda" name="ven_total" style="width: 30em" value="${v.ven_total}" readonly>
        </div>

        <div class="campo">
            <label for="caixaVenda">Nº Caixa</label>
            <input type="text" id="email" name="caixa_cx_cod" style="width: 40em" value="${v.caixa_cx_cod}" readonly>
        </div>

        <br />
        
    </fieldset>
    </form>    
    <fieldset id="msg">
        ${msg}<br/>
    </fieldset>
    
    <form action = "${pageContext.request.contextPath}/jsp/Venda" method = "POST">
    <fieldset>
        <legend>Pesquisa:</legend>
        <div class="pesquisa">
            <select name="opcao" id="opcao">
                <option value="ven_total" selected>Total Venda</option>
                <option value="caixa_cx_cod">Nº Caixa</option>
                <option value="venda_cod">Venda Nº</option>
            </select>
            <input type="text" id="parametro" name="parametro" style="width: 20em" value="">
            <input type="hidden" name="action" value="find">
            <button type="submit" name="pesquisa">Pesquisar</button>
        </div>
    </fieldset>
    </form>
    <c:if test="${vendas.size() > 0}">
    <fieldset>               
        <h3>Lista de Vendas</h3>
        <table id="listTable">
            <thead>
                <tr>
                    <th width="5%"></th>
                    <th width="35%">Total Venda</th>
                    <th width="50%">Nº Caixa</th>
                    <th width="5%"></th>
                    <th width="5%"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="venda" items="${vendas}">
                <tr>
                    <td>${venda.getVenTotal()}</td>
                    <td>${venda.getCaixaCxCod()}</td>
                    <td>${venda.getVendaCod()}</td>
                    <td><a href="${pageContext.request.contextPath}/jsp/Venda?action=editU&id=${cliente.getVendaCod()}"><img border="0" alt="Editar venda" src="${pageContext.request.contextPath}/images/ico_edit.png" width="16" height="16"></a></td>
                    <td><a href="${pageContext.request.contextPath}/jsp/Venda?action=editD&id=${cliente.getVendaCod()}"><img border="0" alt="Excluir venda" src="${pageContext.request.contextPath}/images/ico_delete.png" width="16" height="16"></a></td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">Total de vendas: ${vendas.size()}</td>
                </tr>
            </tfoot>
        </table>
    </fieldset>             
    </c:if>   
    <script type="text/javascript">
        setTimeout(function(){ 
             document.getElementById("msg").innerHTML = "<br/>";
        }, 5000);
    </script>
    </body>
</html>
