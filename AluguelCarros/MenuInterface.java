import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  // IMPORTAÇÕES NECESSÁRIAS
import java.awt.event.ActionListener;

public class MenuInterface extends JFrame{

    // FONTES
    private Font f = new Font("Poppins",Font.BOLD,15);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    // TITULOS, SUB TITULOS E LOGOS
    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    // BOTÕES
    private JButton veiculos = new JButton();
    private JButton cadastrar_veiculos = new JButton();
    private JButton clientes = new JButton();
    private JButton cadastrar_clientes = new JButton();

    // CONSTRUTOR
    public MenuInterface(){
        
        // JFRAME
        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

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

        
        subtitulo.setText("MENU PRINCIPAL");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Escolha uma opção");
        titulo.setBounds(20,40,350,30);
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.GRAY);
        add(titulo);

        // BOTÃO VER VEICULOS
        veiculos.setText("Ver veículos");
        veiculos.setBounds(110,120,140,60);
        veiculos.setFont(f);
        veiculos.setForeground(Color.white);
        veiculos.setBackground(Color.GRAY);
        add(veiculos);
        // AÇÃO
        veiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                VeiculosInterace veiculos = new VeiculosInterace();
                
                dispose();
            }
        });

        // BOTÃO CADASTRAR VEICULOS 
        cadastrar_veiculos.setText("Cadastrar veiculos");
        cadastrar_veiculos.setBounds(310,120,170,60);
        cadastrar_veiculos.setFont(f);
        cadastrar_veiculos.setForeground(Color.white);
        cadastrar_veiculos.setBackground(Color.gray);
        add(cadastrar_veiculos);
        // AÇÃO
        cadastrar_veiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroVeiculosInterface cadastroVeiculos = new CadastroVeiculosInterface();
                
                dispose();
            }
        });

        // BOTÃO VER CLIENTES
        clientes.setText("Ver clientes");
        clientes.setBounds(110,220,140,60);
        clientes.setFont(f);
        clientes.setForeground(Color.white);
        clientes.setBackground(Color.GRAY);
        add(clientes);
        // AÇÃO
        clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ClientesInterface clientes = new ClientesInterface();
                
                dispose();
            }
        });

        // BOTÃO CADASTRAR CLIENTES
        cadastrar_clientes.setText("Cadastrar clientes");
        cadastrar_clientes.setBounds(310,220,170,60);
        cadastrar_clientes.setFont(f);
        cadastrar_clientes.setForeground(Color.white);
        cadastrar_clientes.setBackground(Color.gray);
        add(cadastrar_clientes);
        // AÇÃO
        cadastrar_clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroClientesInterface cadastroClientes = new CadastroClientesInterface();
                
                dispose();
            }
        });


    }
    public static void main(String[] args) {
        MenuInterface menu = new MenuInterface();
        
    }
}


