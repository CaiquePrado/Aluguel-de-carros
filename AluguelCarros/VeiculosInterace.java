import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;  // IMPORTAÇÕES NECESSÁRIAS
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VeiculosInterace extends JFrame {

    // FONTES
    private Font f = new Font("Poppins",Font.BOLD,15);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    // TITULOS, SUBTITULO E LOGO
    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    // BOTÕES
    private JButton voltar = new JButton();
    private JButton cadastrar_veiculo = new JButton();
    private JButton aluguel = new JButton();
    private JButton tabela = new JButton();
    
    // CONSTRUTOR
    public VeiculosInterace(){

        // JFRAME
        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 450);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                MenuInterface menu = new MenuInterface();
            }
        });


        // LOGOS, SUBTITULOS E TITULOS
        logo.setText("Si");
        logoDois.setText("Cars");
        logo.setBounds(425,10,250,30);
        logoDois.setBounds(458,10,250,30);
        logo.setFont(logoFont);
        logoDois.setFont(logoFont);
        logo.setForeground(Color.RED);
        logoDois.setForeground(Color.DARK_GRAY);
        add(logo);
        add(logoDois);

        subtitulo.setText("VEÍCULOS");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Veículos Cadastrados");
        titulo.setBounds(20,40,350,30);
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.GRAY);
        add(titulo);

        //Botão de tabela
        tabela.setText("Tabela completa");
        tabela.setBounds(120, 300, 350, 30);
        tabela.setFont(tituloFont);
        tabela.setForeground(Color.GRAY);
        add(tabela);
        // AÇÃO 
        tabela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VeiculosTableInterface veiculostable = new VeiculosTableInterface();
                
                dispose();
            }
        });

        
        // BOTÃO VOLTAR
        voltar.setText("Voltar");
        voltar.setBounds(70,350,100,30);
        voltar.setFont(f);
        voltar.setForeground(Color.white);
        voltar.setBackground(Color.gray);
        add(voltar);
        // AÇÃO 
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                MenuInterface menu = new MenuInterface();
                
                dispose();
            }
        });

        aluguel.setText("Criar Aluguel");
        aluguel.setBounds(180, 350, 130, 30);
        aluguel.setFont(f);
        aluguel.setForeground(Color.white);
        aluguel.setBackground(Color.gray);
        add(aluguel);
        // AÇÃO
        cadastrar_veiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                AlugarCarrosInterface alugarcarros = new AlugarCarrosInterface();
                
                dispose();
            }
        });


        // BOTÃO CADASTRAR VEICULO
        cadastrar_veiculo.setText("Cadastrar novo veículo");
        cadastrar_veiculo.setBounds(320,350,200,30);
        cadastrar_veiculo.setFont(f);
        cadastrar_veiculo.setForeground(Color.white);
        cadastrar_veiculo.setBackground(Color.gray);
        add(cadastrar_veiculo);
        // AÇÃO
        cadastrar_veiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                CadastroVeiculosInterface cadastroVeiculos = new CadastroVeiculosInterface();
                
                dispose();
            }
        });

    }
    
    public static void main(String[] args) {
        VeiculosInterace tela1 = new VeiculosInterace();
        
    }
}
