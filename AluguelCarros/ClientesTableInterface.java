import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientesTableInterface extends JFrame {
    private JTable clientesTable;
    private DefaultTableModel tableModel;

    public ClientesTableInterface() {
        // Configurações básicas da janela
        setTitle("Clientes Cadastrados");
        setSize(800, 600);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                MenuInterface menu = new MenuInterface();
            }
        });

        // Cria o CPF da tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("NOME");
        tableModel.addColumn("CPF");
        tableModel.addColumn("CNH");
        tableModel.addColumn("ENDEREÇO");
        tableModel.addColumn("BAIRRO");
        tableModel.addColumn("CEP");
        tableModel.addColumn("TELEFONE");

        // Cria a JTable com o CPF
        clientesTable = new JTable(tableModel);
        clientesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Adiciona a tabela a um JScrollPane para torná-la rolável
        JScrollPane scrollPane = new JScrollPane(clientesTable);
        add(scrollPane);

        // Preenche a tabela com os dados dos veículos
        preencherTabelaComclientes();

        

        // Ajusta o tamanho das colunas da tabela
        resizeTableColumns();

        // Exibe a janela
    
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        
        
    }

    private void preencherTabelaComclientes() {
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sicars", "dovani", "flamengo");

            // Cria uma declaração SQL
            Statement statement = conexao.createStatement();

            // Executa a consulta SQL para obter os veículos cadastrados
            String query = "SELECT * FROM Cliente";
            ResultSet resultSet = statement.executeQuery(query);

            // Limpa os dados existentes na tabela
            tableModel.setRowCount(0);

            // Itera sobre os resultados e adiciona cada veículo como uma linha na tabela
            while (resultSet.next()) {
                String NOME = resultSet.getString("NOME");
                String CPF = resultSet.getString("CPF");
                String CNH = resultSet.getString("CNH");
                String ENDERECO = resultSet.getString("ENDERECO");
                String BAIRRO = resultSet.getString("BAIRRO");
                String CEP = resultSet.getString("CEP");
                String TELEFONE = resultSet.getString("TELEFONE");

                Object[] dados = {NOME, CPF, CNH, ENDERECO, BAIRRO, CEP, TELEFONE};
                tableModel.addRow(dados);
            }

    
            // Fecha a conexão e os recursos relacionados
            resultSet.close();
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados dos clientes!: " + e.getMessage());
        }
    }

    // Percorre a tabela, coluna por coluna e aciona o metodo PreferredWidht, deixando todas com mesmo tamanho
    private void resizeTableColumns() {
        for (int column = 0; column < clientesTable.getColumnCount(); column++) {
            clientesTable.getColumnModel().getColumn(column).setPreferredWidth(200);
        }
    }

    public static void main(String[] args) {
        ClientesTableInterface clientesTableInterface = new ClientesTableInterface();

    }
}
