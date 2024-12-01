/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crudprodutos.controller;


import com.mycompany.crudprodutos.dao.ProdutoDAO;
import com.mycompany.crudprodutos.model.Produto;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.logging.Logger;

@WebServlet("/ControladorServlet")
public class ControladorServlet extends HttpServlet {

    // Método que trata requisições POST (para cadastrar e editar)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String precoParam = request.getParameter("preco");
        String descricao = request.getParameter("descricao");
        String idParam = request.getParameter("id");

        // Verificar se os parâmetros obrigatórios não são nulos ou vazios
        if (nome == null || nome.isEmpty() || precoParam == null || precoParam.isEmpty() || descricao == null || descricao.isEmpty()) {
            // Se algum parâmetro estiver vazio, redireciona para a página com uma mensagem de erro
            response.sendRedirect("produto.jsp?erro=Campos obrigatórios não preenchidos.");
            return;
        }

        // Converter preco e id apenas se forem válidos
        double preco = 0.0;
        int id = 0;

        try {
            preco = Double.parseDouble(precoParam);  // Tentar converter preço
        } catch (NumberFormatException e) {
            response.sendRedirect("produto.jsp?erro=Valor de preço inválido.");
            return;
        }

        try {
            id = Integer.parseInt(idParam);  // Tentar converter id
        } catch (NumberFormatException e) {
            // Se o ID não for numérico, assumir como 0 (novo produto)
            id = 0;
        }

        // Se o ID for 0, significa que estamos criando um novo produto
        if (id == 0) {
            Produto produto = new Produto(id, nome, preco, descricao);
            ProdutoDAO.addProduto(produto);
        } else {
            // Caso contrário, estamos editando um produto existente
            Produto produto = new Produto(id, nome, preco, descricao);
            ProdutoDAO.updateProduto(produto);
        }

        // Redireciona para a lista de produtos após o cadastro ou edição
        response.sendRedirect("index.jsp");
    }

    // Método que trata requisições GET (para editar e excluir)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        // Se a ação for excluir, realiza a exclusão
        if ("excluir".equals(acao)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                ProdutoDAO.deleteProduto(id);  // Exclui o produto no banco de dados
                response.sendRedirect("index.jsp");  // Redireciona para a lista de produtos após excluir
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("index.jsp");  // Redireciona em caso de erro
            }
        }
    }
}


