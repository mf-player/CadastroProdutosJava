/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudprodutos.dao;

import com.mycompany.crudprodutos.model.Produto;
import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            // Registra o driver MySQL (caso necessário)
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/loja?useUnicode=true&characterEncoding=UTF-8";
            String usuario = "admin";
            String senha = "admin"; 

            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }

    public static List<Produto> getAllProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produto");

            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"), rs.getString("descricao"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
    
        // Método para recuperar um produto pelo ID
    public static Produto getProdutoById(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("descricao")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public static void addProduto(Produto produto) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO produto (nome, preco, descricao) VALUES (?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProduto(Produto produto) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE produto SET nome=?, preco=?, descricao=? WHERE id=?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduto(int id) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM produto WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
