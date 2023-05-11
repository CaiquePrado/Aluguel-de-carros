import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    private Font f = new Font("Poppins",Font.BOLD,15);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    private JButton veiculos = new JButton();
    private JButton cadastrar_veiculos = new JButton();
    private JButton clientes = new JButton();
    private JButton cadastrar_clientes = new JButton();

    public Menu(){

        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

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


        veiculos.setText("Ver veículos");
        veiculos.setBounds(110,120,140,60);
        veiculos.setFont(f);
        veiculos.setForeground(Color.white);
        veiculos.setBackground(Color.GRAY);
        add(veiculos);

        veiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Veiculos veiculos = new Veiculos();
                
                dispose();
            }
        });

        cadastrar_veiculos.setText("Cadastrar veiculos");
        cadastrar_veiculos.setBounds(310,120,170,60);
        cadastrar_veiculos.setFont(f);
        cadastrar_veiculos.setForeground(Color.white);
        cadastrar_veiculos.setBackground(Color.gray);
        add(cadastrar_veiculos);

        cadastrar_veiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroVeiculos cadastroVeiculos = new CadastroVeiculos();
                
                dispose();
            }
        });

        clientes.setText("Ver clientes");
        clientes.setBounds(110,220,140,60);
        clientes.setFont(f);
        clientes.setForeground(Color.white);
        clientes.setBackground(Color.GRAY);
        add(clientes);

        clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Clientes clientes = new Clientes();
                
                dispose();
            }
        });

        cadastrar_clientes.setText("Cadastrar clientes");
        cadastrar_clientes.setBounds(310,220,170,60);
        cadastrar_clientes.setFont(f);
        cadastrar_clientes.setForeground(Color.white);
        cadastrar_clientes.setBackground(Color.gray);
        add(cadastrar_clientes);

        cadastrar_clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CadastroClientes cadastroClientes = new CadastroClientes();
                
                dispose();
            }
        });


    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        
    }
}


