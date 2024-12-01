<%@ page import="java.util.*, com.mycompany.crudprodutos.dao.ProdutoDAO, com.mycompany.crudprodutos.model.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produto</title>
    <!-- Vincula o arquivo CSS -->
    <link rel="stylesheet" href="styles.css">
</head>
<body>
        <div class="menu">
        <a href="index.html">Página Inicial</a>
        <a href="index.jsp">Produtos</a>
        <a href="produto.jsp">Cadastro</a>
        
    </div>
    
    <h2>Cadastro de Produto</h2>
    <form action="ControladorServlet" method="post">
        <input type="text" name="nome" placeholder="Nome" required>
        <input type="number" name="preco" placeholder="Preço" step="0.01" required>
        <textarea name="descricao" placeholder="Descrição" required></textarea>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
