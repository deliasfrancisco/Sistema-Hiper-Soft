<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hiper Soft - Usuario</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cadastro.css" />
    </head>
    
    <body>
        <jsp:useBean id="u" class="br.com.fatecpp.hiper_soft.model.domain.Usuario" />
        <jsp:setProperty name="u" property="*" />
        
        <jsp:include page="menu.jsp" />
        <form action = "${pageContext.request.contextPath}/UsuarioView" method = "POST">
        <fieldset>
            <h3>Cadastro de Usuarios do Sistema</h3>

            <div class="campo">
                <label for="idUsuario">ID</label>
                <input type="text" id="idCliente" name="id" style="width: 5em" value="" readonly>
            </div>

            <div class="campo">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" style="width: 30em" value="" required>
            </div>

            <div class="campo">
                <label for="email">E-mail</label>
                <input type="text" id="email" name="email" style="width: 40em" value="" required>
            </div>

            <br />
            <button class="botao" type="submit" name="salvar">Salvar</button>           
        </fieldset>
        </form>    
        <fieldset id="msg">
            <br/>
        </fieldset>
        <fieldset>               
            <h3>Lista de Usuarios</h3>
            <table id="listTable">
                <thead>
                    <tr>
                        <th width="5%"></th>
                        <th width="35%">Nome</th>
                        <th width="50%">E-mail</th>
                        <th width="5%"></th>
                        <th width="5%"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><a href="${pageContext.request.contextPath}/Cliente?action=editU&id=${usuario.getUsuCod()}"><img border="0" alt="Editar usuario" src="${pageContext.request.contextPath}/images/ico_edit.png" width="16" height="16"></a></td>
                        <td><a href="${pageContext.request.contextPath}/Cliente?action=editD&id=${usuario.getUsuCod()}"><img border="0" alt="Excluir usuario" src="${pageContext.request.contextPath}/images/ico_delete.png" width="16" height="16"></a></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">Total de produtos: </td>
                    </tr>
                </tfoot>
            </table>
        </fieldset>             
        <script type="text/javascript">
            setTimeout(function(){ 
                 document.getElementById("msg").innerHTML = "<br/>";
            }, 5000);
        </script>
    </body>
</html>