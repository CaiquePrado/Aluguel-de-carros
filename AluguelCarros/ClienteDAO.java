import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ClienteDAO {
    private static final String URL = "jdbc:mysql://db4free.net:3306/sicars";
    private static final String USERNAME = "dovani";
    private static final String PASSWORD = "flamengo";
    private Connection conexao;
    
    public ClienteDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado.");
        }
    }
    
    public static void cadastrarCliente(Cliente cliente) {
        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Cliente (nome, cpf, cnh, endereco, bairro, cep, telefone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getCnh());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getBairro());
            statement.setString(6, cliente.getCep());
            statement.setString(7, cliente.getTelefone());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Registrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao registra cliente!: " + e.getMessage());
        }
    }
}

