<%@ page import="com.mycompany.crudprodutos.dao.ProdutoDAO, com.mycompany.crudprodutos.model.Produto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Produto</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    
        <div class="menu">
        <a href="index.html">Página Inicial</a>
        <a href="index.jsp">Produtos</a>
        <a href="produto.jsp">Cadastro</a>
        
    </div>
    <h2>Editar Produto</h2>

    <%
        // Recuperando o ID do produto da URL
        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = ProdutoDAO.getProdutoById(id);
    %>

    <form action="ControladorServlet" method="post">
        <input type="hidden" name="id" value="<%= produto.getId() %>">
        <input type="text" name="nome" value="<%= produto.getNome() %>" placeholder="Nome" required>
        <input type="number" name="preco" value="<%= produto.getPreco() %>" placeholder="Preço" step="0.01" required>
        <textarea name="descricao" placeholder="Descrição" required><%= produto.getDescricao() %></textarea>
        <input type="submit" value="Atualizar">
    </form>

    <a href="index.jsp">Voltar para a lista de produtos</a>
</body>
</html>
