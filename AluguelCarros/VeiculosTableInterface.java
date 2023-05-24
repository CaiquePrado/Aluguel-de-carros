import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VeiculosTableInterface extends JFrame {
    
    public VeiculosTableInterface() {
        // Define o título do JFrame
        setTitle("Tabela de Veiculos Cadastrados");
        setSize(600, 500);
        setLocationRelativeTo(null);
        //setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                VeiculosInterace veiculos = new VeiculosInterace();
            }
        });

        // Cria o modelo de tabela com as colunas
        String[] colunas = {"Fabricante", "Modelo", "Cor", "Placa", "Chassi", "Ano", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // Adiciona os dados dos clientes ao modelo de tabela
        modelo.addRow(new Object[]{"Chevrolet", "S10 Executive", "Prata", "JOE-5J61", "ABCDEF12345", "2008", "Disponivel"});
        
        

        // Cria a tabela com o modelo de tabela
        JTable tabelaClientes = new JTable(modelo);
        tabelaClientes.setBounds(30, 30, 30, 40);

        // Cria um JScrollPane e adiciona a tabela de clientes nele
        //JScrollPane scrollPane = new JScrollPane(tabelaClientes);

        // Adiciona o JScrollPane ao JFrame
        add(tabelaClientes, BorderLayout.CENTER);

        // Define o tamanho do JFrame e o torna visível
        
    }

    public static void main(String[] args) {
        VeiculosTableInterface frame = new VeiculosTableInterface();
    }
}
