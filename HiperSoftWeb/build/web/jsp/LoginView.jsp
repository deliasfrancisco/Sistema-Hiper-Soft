<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css" />
    </head>
    
    <body>
        <jsp:useBean id="u" class="br.com.fatecpp.hiper_soft.model.domain.Usuario" />
        
        <form action="${pageContext.request.contextPath}/Login" method="POST">
            <fieldset>
                <div id="mainWrapper">
                    <div class="login-container">
                        <center><h1><label class="text-color text-center"> Hiper Soft</label></h1></center>
                        <div class="login-card">
                            <div class="login-form">

                                    <div class="input-group input-sm">
                                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                        <input type="text" class="form-control bottom" id="username" name="username" placeholder="Usuario" required>
                                    </div>

                                    <div class="input-group input-sm bottom">
                                        <label class="input-group-addon" for="senha"><i class="fa fa-lock"></i></label> 
                                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
                                    </div>

                                    <div class="form-actions bottom">
                                        <input type="submit" class="btn btn-block btn-primary btn-default" value="login">
                                    </div>

    <!--                            <c:if test="${resposta != true}">
                                        <div class="alert alert-danger">
                                            <p>Usuário/senha inválido.</p>
                                        </div>
                                </c:if>

                                <c:if test="${resposta != true}">
                                    <div class="alert alert-success">
                                        <p>Você foi desconectado com sucesso.</p>
                                    </div>
                                </c:if>-->

                            </div>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <script type="text/javascript">
            setTimeout(function(){ 
                 document.getElementById("msg").innerHTML = "<br/>";
            }, 5000);
        </script>
    </body>
    
</html>
