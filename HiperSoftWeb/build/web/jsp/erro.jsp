<%@page isErrorPage="true" %>
<html>
<head>
    <title>JSP - P�gina de Erro</title>
</head>
<body>
    <p>1) Essa � uma p�gina de erro.</p>
    
    <p>2) Esta p�gina de erro foi chamada pelo container, pois uma 
        <b><%= exception.getClass().getName() %></b> foi gerada.</p>
    
    <p>3) A mensagem de erro gerado foi: 
        <b><%= exception.getMessage() %></b></p>
</body>
</html>
