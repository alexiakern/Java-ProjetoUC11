
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class ConectaDAO {
    private static Connection connection;
    private static void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "root");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Não localizou a classe de conexão");
        }
        System.out.println("Conectado");
    }

    public static void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
                System.out.println("Desconectado");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar");
        }
    }

    public static Connection getConexao() {
        if (connection == null) {
            connectDB();
        }
        return connection;
    }
}
