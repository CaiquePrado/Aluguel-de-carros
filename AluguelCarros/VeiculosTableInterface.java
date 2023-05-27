import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VeiculosTableInterface extends JFrame {
    private JTable veiculosTable;
    private DefaultTableModel tableModel;

    public VeiculosTableInterface() {
        // Configurações básicas da janela
        setTitle("Veículos Cadastrados");
        setSize(600, 500);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                MenuInterface menu = new MenuInterface();
            }
        });

        // Cria o modelo da tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("FABRICANTE");
        tableModel.addColumn("MODELO");
        tableModel.addColumn("COR");
        tableModel.addColumn("PLACA");
        tableModel.addColumn("CHASSI");
        tableModel.addColumn("SITUAÇÃO");
        tableModel.addColumn("ANO DE FABRICAÇÃO");

        // Cria a JTable com o modelo
        veiculosTable = new JTable(tableModel);

        // Adiciona a tabela a um JScrollPane para torná-la rolável
        JScrollPane scrollPane = new JScrollPane(veiculosTable);
        add(scrollPane);

        // Preenche a tabela com os dados dos veículos
        preencherTabelaComVeiculos();

        // Ajusta o tamanho das colunas da tabela
        resizeTableColumns();

        // Exibe a janela
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherTabelaComVeiculos() {
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");

            // Cria uma declaração SQL
            Statement statement = conexao.createStatement();

            // Executa a consulta SQL para obter os veículos cadastrados
            String query = "SELECT * FROM Veiculo";
            ResultSet resultSet = statement.executeQuery(query);

            // Limpa os dados existentes na tabela
            tableModel.setRowCount(0);

            // Itera sobre os resultados e adiciona cada veículo como uma linha na tabela
            while (resultSet.next()) {
                String fabricante = resultSet.getString("fabricante");
                String modelo = resultSet.getString("modelo");
                String cor = resultSet.getString("cor");
                String placa = resultSet.getString("placa");
                String chassi = resultSet.getString("chassi");
                String situacao = resultSet.getString("situacao");
                int anoFabricacao = resultSet.getInt("anoFabricacao");

                Object[] rowData = {fabricante, modelo, cor, placa, chassi, situacao, anoFabricacao};
                tableModel.addRow(rowData);
            }

            // Fecha a conexão e os recursos relacionados
            resultSet.close();
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao preencher a tabela: " + e.getMessage());
        }
    }

    private void resizeTableColumns() {
        for (int column = 0; column < veiculosTable.getColumnCount(); column++) {
            veiculosTable.getColumnModel().getColumn(column).setPreferredWidth(150);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VeiculosTableInterface::new);
    }
}
