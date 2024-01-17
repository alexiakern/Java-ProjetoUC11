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
    public static void cadastrarProduto (ProdutosDTO produto){
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
    
    
    
        
}

