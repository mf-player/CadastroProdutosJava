<%@ page import="java.util.*, com.mycompany.crudprodutos.dao.ProdutoDAO, com.mycompany.crudprodutos.model.Produto" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Produtos</title>
    <!-- Vincula o arquivo CSS -->
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    
    <div class="menu">
        <a href="index.html">Página Inicial</a>
        <a href="index.jsp">Produtos</a>
        <a href="produto.jsp">Cadastro</a>
        
    </div>

    
    <h2>Lista de Produtos</h2>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Preço</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Produto> listaProdutos = ProdutoDAO.getAllProdutos();
                for (Produto produto : listaProdutos) {
            %>
            <tr>
                <td><%= produto.getNome() %></td>
                <td><%= produto.getPreco() %></td>
                <td><%= produto.getDescricao() %></td>
                <td>
                    <!-- Link de edição -->
                    <a href="editar.jsp?id=<%= produto.getId() %>">Editar</a> |
                    <!-- Link de exclusão -->
                    <a href="ControladorServlet?acao=excluir&id=<%= produto.getId() %>" onclick="return confirm('Tem certeza que deseja excluir este produto?')">Excluir</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <a href="produto.jsp" class="button" >Cadastrar Novo Produto</a>
</body>
</html>
