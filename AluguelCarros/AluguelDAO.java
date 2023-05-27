import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AluguelDAO {
    private static final String URL = "jdbc:mysql://db4free.net:3306/sicars";
    private static final String USERNAME = "dovani";
    private static final String PASSWORD = "flamengo";
    private Connection conexao;
    
    public AluguelDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do MySQL não encontrado.");
        }
    }
    
    public static void alugar(Aluguel aluguel) {
        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Aluguel (cliente, cpf_cliente, placa, diarias, consultor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, aluguel.getNome_cliente());
            statement.setString(2, aluguel.getCpf_cliente());
            statement.setString(3, aluguel.getPlaca());
            statement.setInt(4, aluguel.getDiarias());
            statement.setString(5, aluguel.getNome_consultor());
            
            
            statement.executeUpdate();
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }
}
