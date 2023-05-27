import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;

public class AluguelTableInterface extends JFrame {
    private JTable aluguelTable;
    private DefaultTableModel tableModel;

    public AluguelTableInterface() {
        // Configurações básicas da janela
        setTitle("-- ALUGUÉIS --");
        setSize(800, 600);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                MenuInterface menu = new MenuInterface();
            }
        });

        // Cria o CPFCLIENTE da tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CLIENTE");
        tableModel.addColumn("CPF CLIENTE");
        tableModel.addColumn("PLACA");
        tableModel.addColumn("DIARIAS");
        tableModel.addColumn("CONSULTOR");

        // Cria a JTable com o CPFCLIENTE
        aluguelTable = new JTable(tableModel);
        aluguelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Adiciona a tabela a um JScrollPane para torná-la rolável
        JScrollPane scrollPane = new JScrollPane(aluguelTable);
        add(scrollPane);

        // Preenche a tabela com os dados dos veículos
        preencherTabelaComaluguel();

        

        // Ajusta o tamanho das colunas da tabela
        resizeTableColumns();

        // Exibe a janela
    
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        
        
    }

    private void preencherTabelaComaluguel() {
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");

            // Cria uma declaração SQL
            Statement statement = conexao.createStatement();

            // Executa a consulta SQL para obter os veículos cadastrados
            String query = "SELECT * FROM Aluguel";
            ResultSet resultSet = statement.executeQuery(query);

            // Limpa os dados existentes na tabela
            tableModel.setRowCount(0);

            // Itera sobre os resultados e adiciona cada veículo como uma linha na tabela
            while (resultSet.next()) {
                String CLIENTE = resultSet.getString("CLIENTE");
                String CPF_CLIENTE = resultSet.getString("CPF_CLIENTE");
                String PLACA = resultSet.getString("PLACA");
                String DIARIAS = resultSet.getString("DIARIAS");
                String CONSULTOR = resultSet.getString("CONSULTOR");

                Object[] dados = {CLIENTE, CPF_CLIENTE, PLACA, DIARIAS, CONSULTOR};
                tableModel.addRow(dados);
            }

    
            // Fecha a conexão e os recursos relacionados
            resultSet.close();
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados dos aluguel!: " + e.getMessage());
        }
    }

    // Percorre a tabela, coluna por coluna e aciona o metodo PreferredWidht, deixando todas com mesmo tamanho
    private void resizeTableColumns() {
        for (int column = 0; column < aluguelTable.getColumnCount(); column++) {
            aluguelTable.getColumnModel().getColumn(column).setPreferredWidth(200);
        }
    }

    public static void main(String[] args) {
        AluguelTableInterface AluguelTableInterface = new AluguelTableInterface();

    }
}
