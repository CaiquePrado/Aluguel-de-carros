import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VeiculoDAO {
    private static final String URL = "jdbc:mysql://db4free.net:3306/sicars";
    private static final String USERNAME = "dovani";
    private static final String PASSWORD = "flamengo";
    private Connection conexao;
    
    public VeiculoDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado.");
        }
    }
    
    public static void cadastrarVeiculo(Veiculo veiculo) {
        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Veiculo (fabricante, modelo, cor, placa, situacao, anoFabricacao) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, veiculo.getFabricante());
            statement.setString(2, veiculo.getModelo());
            statement.setString(3, veiculo.getCor());
            statement.setString(4, veiculo.getPlaca());
            statement.setString(5, veiculo.getSituacao());
            statement.setInt(6, veiculo.getAnoFabricacao());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Veículo cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO!! Ao cadastrar veiculo.: " + e.getMessage());
        }
    }
}
