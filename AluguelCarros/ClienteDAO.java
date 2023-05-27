import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void atualizarCliente(Cliente cliente) {
        try {
            // Cria a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");
    
            // Cria a consulta SQL para atualizar o veículo
            String sql = "UPDATE Cliente SET nome = ?, cpf = ?, cnh = ?, endereco = ?, bairro = ?, cep = ?, telefone = ? WHERE cpf = ?";
    
            // Cria o PreparedStatement com a consulta SQL
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
    
            // Define os valores dos parâmetros da consulta
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getCnh());
            preparedStatement.setString(4, cliente.getEndereco());
            preparedStatement.setString(5, cliente.getBairro());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getTelefone());
            preparedStatement.setString(8, cliente.getCpf());

           
    
            // Executa a consulta de atualização
            preparedStatement.executeUpdate();
    
            // Fecha a conexão com o banco de dados
            conexao.close();
    
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        Cliente cliente = null;
        String query = "SELECT * FROM Cliente WHERE cpf = ?";
    
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            statement.setString(1, cpf);
    
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    cliente = new Cliente();
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setCpf(resultSet.getString("cpf"));
                    cliente.setCnh(resultSet.getString("cnh"));
                    cliente.setEndereco(resultSet.getString("endereco"));
                    cliente.setBairro(resultSet.getString("bairro"));
                    cliente.setCep(resultSet.getString("cep"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    
        return cliente;
    }
}

