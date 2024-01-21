/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    public static void cadastrarProduto(ProdutosDTO produto){
        try { 
            String query = "INSERT INTO produtos (nome, valor) VALUES (?, ?)"; 
            PreparedStatement consulta = ConectaDAO.getConexao().prepareStatement(query);

            consulta.setString(1, produto.getNome());
            consulta.setInt(2, produto.getValor());

            consulta.execute(); 
            ConectaDAO.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto");
            System.out.println("Erro ao cadastrar" + e.getMessage());
        }
        System.out.println("Produto cadastrado");
    }
    
    public static ArrayList<ProdutosDTO> listarProdutos(){
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        try {
            String query = "SELECT id, nome, valor, status FROM produtos"; 
            PreparedStatement consulta = ConectaDAO.getConexao().prepareStatement(query);
            ResultSet resposta = consulta.executeQuery();
            while(resposta.next()) {
                ProdutosDTO prod = new ProdutosDTO();
                prod.setId(resposta.getInt("id"));
                prod.setNome(resposta.getString("nome"));
                prod.setStatus(resposta.getString("status"));
                prod.setValor(resposta.getInt("valor"));
                produtos.add(prod);
            }
            ConectaDAO.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao consultar produtos");
            System.out.println("Erro ao consultar produtos" + e.getMessage());
        }
        return produtos;
    }
    
    public static void venderProduto(int id){
        try { 
            String query = "UPDATE produtos SET status = 'Vendido' WHERE id = ?"; 
            PreparedStatement consulta = ConectaDAO.getConexao().prepareStatement(query);

            consulta.setInt(1, id);

            consulta.execute(); 
            ConectaDAO.desconectar();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto");
            System.out.println("Erro ao cadastrar" + e.getMessage());
        }
    }
}

