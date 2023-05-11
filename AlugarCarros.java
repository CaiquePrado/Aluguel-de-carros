import javax.swing.*;
import java.awt.*;

public class AlugarCarros extends JFrame {

    private Font f = new Font("Poppins",Font.BOLD,10);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    private JTextField nome_cliente = new JTextField();
    private JLabel nome_cliente_text = new JLabel();
    private JTextField cpf = new JTextField();
    private JLabel cpf_text = new JLabel();
    private JTextField placa = new JTextField();
    private JLabel placa_text = new JLabel();
    private JTextField diarias = new JTextField();
    private JLabel diarias_text = new JLabel();
    private JTextField nome_consultor = new JTextField();
    private JLabel nome_consultor_text = new JLabel();
    private JTextField senha_consultor = new JTextField();
    private JLabel senha_consultor_text = new JLabel();

    private JButton registrar = new JButton();
    private JButton voltar = new JButton();
    
    public AlugarCarros(){

        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        
        subtitulo.setText("ALUGAR CARROS");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Informe os dados para realizar o aluguel");
        titulo.setBounds(20,40,350,30);
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.GRAY);
        add(titulo);

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

        nome_cliente_text.setBounds(50, 90,150,25);
        nome_cliente_text.setText("Nome do cliente: ");
        nome_cliente_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        nome_cliente_text.setForeground(Color.darkGray);
        add(nome_cliente_text);

        nome_cliente.setBounds(180, 90, 150, 25);
        nome_cliente.setForeground(Color.darkGray);
        add(nome_cliente);


        cpf_text.setBounds(50, 120, 150, 25);
        cpf_text.setText("CPF: ");
        cpf_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cpf_text.setForeground(Color.darkGray);
        add(cpf_text);

        cpf.setBounds(180, 120, 150, 25);
        cpf.setForeground(Color.darkGray);
        add(cpf);


        placa_text.setBounds(50, 150, 150, 25);
        placa_text.setText("Placa do veículo: ");
        placa_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        placa_text.setForeground(Color.darkGray);
        add(placa_text);

        placa.setBounds(180, 150, 150, 25);
        placa.setForeground(Color.darkGray);
        add(placa);


        diarias_text.setBounds(50, 180, 150, 25);
        diarias_text.setText("Endereço: ");
        diarias_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        diarias_text.setForeground(Color.darkGray);
        add(diarias_text);

        diarias.setBounds(180, 180, 150, 25);
        diarias.setForeground(Color.darkGray);
        add(diarias);


        nome_consultor_text.setBounds(50, 210, 150, 25);
        nome_consultor_text.setText("Nome do consultor: ");
        nome_consultor_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        nome_consultor_text.setForeground(Color.darkGray);
        add(nome_consultor_text);

        nome_consultor.setBounds(180, 210, 150, 25);
        nome_consultor.setForeground(Color.darkGray);
        add(nome_consultor);


        senha_consultor_text.setBounds(50, 240, 150, 25);
        senha_consultor_text.setText("Senha do consultor: ");
        senha_consultor_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        senha_consultor_text.setForeground(Color.darkGray);
        add(senha_consultor_text);

        senha_consultor.setBounds(180, 240, 150, 25);
        senha_consultor.setForeground(Color.darkGray);
        add(senha_consultor);


        registrar.setText("Realizar aluguel");
        registrar.setBounds(300,330,130,30);
        registrar.setFont(f);
        registrar.setForeground(Color.white);
        registrar.setBackground(Color.GRAY);
        add(registrar);

        voltar.setText("Voltar");
        voltar.setBounds(165,330,120,30);
        voltar.setFont(f);
        voltar.setForeground(Color.white);
        voltar.setBackground(Color.gray);
        add(voltar);


        
    }

    public static void main(String[] args) {
        AlugarCarros tela1 = new AlugarCarros();
        
    }
}
