import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VeiculoDAO {
    private static final String URL = "jdbc:mysql://db4free.net:3306/sicars";
    private static final String USERNAME = "dovani";
    private static final String PASSWORD = "flamengo";
    private Connection conexao;
    
    public VeiculoDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado.");
        }
    }
    
    public static void cadastrarVeiculo(Veiculo veiculo) {
        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Veiculo (fabricante, modelo, cor, placa, chassi, situacao, anoFabricacao) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, veiculo.getFabricante());
            statement.setString(2, veiculo.getModelo());
            statement.setString(3, veiculo.getCor());
            statement.setString(4, veiculo.getPlaca());
            statement.setString(5, veiculo.getChassi());
            statement.setString(6, veiculo.getSituacao());
            statement.setInt(7, veiculo.getAnoFabricacao());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Veículo cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO!! Ao cadastrar veiculo.: " + e.getMessage());
        }
    }

    public Veiculo buscarPorPlaca(String placa) {
        Veiculo veiculo = null;
        String query = "SELECT * FROM Veiculo WHERE placa = ?";
    
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            statement.setString(1, placa);
    
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    veiculo = new Veiculo();
                    veiculo.setFabricante(resultSet.getString("fabricante"));
                    veiculo.setModelo(resultSet.getString("modelo"));
                    veiculo.setCor(resultSet.getString("cor"));
                    veiculo.setPlaca(resultSet.getString("placa"));
                    veiculo.setChassi(resultSet.getString("chassi"));
                    veiculo.setAnoFabricacao(resultSet.getInt("anoFabricacao"));
                    veiculo.setSituacao(resultSet.getString("situacao"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    
        return veiculo;
    }

    public static void atualizarVeiculo(Veiculo veiculo) {
        try {
            // Cria a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");
    
            // Cria a consulta SQL para atualizar o veículo
            String sql = "UPDATE Veiculo SET fabricante = ?, modelo = ?, cor = ?, placa = ?, situacao = ?, anoFabricacao = ?, chassi = ? WHERE placa = ?";
    
            // Cria o PreparedStatement com a consulta SQL
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
    
            // Define os valores dos parâmetros da consulta
            preparedStatement.setString(1, veiculo.getFabricante());
            preparedStatement.setString(2, veiculo.getModelo());
            preparedStatement.setString(3, veiculo.getCor());
            preparedStatement.setString(4, veiculo.getPlaca());
            preparedStatement.setString(5, veiculo.getSituacao());
            preparedStatement.setInt(6, veiculo.getAnoFabricacao());
            preparedStatement.setString(7, veiculo.getChassi());
            preparedStatement.setString(8, veiculo.getPlaca());
           
    
            // Executa a consulta de atualização
            preparedStatement.executeUpdate();
    
            // Fecha a conexão com o banco de dados
            conexao.close();
    
            System.out.println("Veículo atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
        }
    }
    
    
}
