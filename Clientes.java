import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  // IMPORTAÇÕES NECESSÁRIAS
import java.awt.event.ActionListener;

public class Clientes extends JFrame {
    // FONTES
    private Font f = new Font("Poppins",Font.BOLD,15);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    // TITULO, SUB TITULO E LOGOS
    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    // BOTÕES
    private JButton voltar = new JButton();
    private JButton cadastrar_cliente = new JButton();

    // CONSTRUTOR
    public Clientes(){

        // JFRAME
        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        // LOGOS, SUB TITULOS E TITULOS
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

        subtitulo.setText("CLIENTES");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Clientes Cadastrados");
        titulo.setBounds(20,40,350,30);
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.GRAY);
        add(titulo);

        // BOTÃO VOLTAR
        voltar.setText("Voltar");
        voltar.setBounds(125,300,120,30);
        voltar.setFont(f);
        voltar.setForeground(Color.white);
        voltar.setBackground(Color.gray);
        add(voltar);

        // AÇÃO DO BOTÃO
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Menu menu = new Menu();
                
                dispose();
            }
        });
        
        // BOTÃO CADASTRAR NOVO CLIENTE
       cadastrar_cliente.setText("Cadastrar novo cliente");
       cadastrar_cliente.setBounds(260,300,200,30);
       cadastrar_cliente.setFont(f);
       cadastrar_cliente.setForeground(Color.white);
       cadastrar_cliente.setBackground(Color.gray);
       add(cadastrar_cliente);
        //AÇÃO DO BOTÃO
       cadastrar_cliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroClientes cadastroClientes = new CadastroClientes();
                
                dispose();
            }
        });

    }
    
    public static void main(String[] args) {
        Clientes tela1 = new Clientes();
        
    }
}