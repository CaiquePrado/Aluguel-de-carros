import javax.swing.*;
import java.awt.*;

public class CadastroClientes extends JFrame {

    private Font f = new Font("Poppins",Font.BOLD,10);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    private JTextField nome = new JTextField();
    private JLabel nome_text = new JLabel();
    private JTextField cpf = new JTextField();
    private JLabel cpf_text = new JLabel();
    private JTextField cnh = new JTextField();
    private JLabel cnh_text = new JLabel();
    private JTextField endereco = new JTextField();
    private JLabel endereco_text = new JLabel();
    private JTextField bairro = new JTextField();
    private JLabel bairro_text = new JLabel();
    private JTextField cep = new JTextField();
    private JLabel cep_text = new JLabel();
    private JTextField telefone = new JTextField();
    private JLabel telefone_text = new JLabel();

    private JButton registrar = new JButton();
    private JButton voltar = new JButton();


    public CadastroClientes(){

        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        
        subtitulo.setText("CADASTRO DE CLIENTES");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Informe os dados do cliente a ser cadastrado");
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

        nome_text.setBounds(50, 90,150,25);
        nome_text.setText("Nome: ");
        nome_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        nome_text.setForeground(Color.darkGray);
        add(nome_text);

        nome.setBounds(120, 90, 150, 25);
        nome.setForeground(Color.darkGray);
        add(nome);


        cpf_text.setBounds(50, 120, 150, 25);
        cpf_text.setText("CPF: ");
        cpf_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cpf_text.setForeground(Color.darkGray);
        add(cpf_text);

        cpf.setBounds(120, 120, 150, 25);
        cpf.setForeground(Color.darkGray);
        add(cpf);


        cnh_text.setBounds(50, 150, 150, 25);
        cnh_text.setText("CNH: ");
        cnh_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cnh_text.setForeground(Color.darkGray);
        add(cnh_text);

        cnh.setBounds(120, 150, 150, 25);
        cnh.setForeground(Color.darkGray);
        add(cnh);


        endereco_text.setBounds(50, 180, 150, 25);
        endereco_text.setText("Endereço: ");
        endereco_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        endereco_text.setForeground(Color.darkGray);
        add(endereco_text);

        endereco.setBounds(120, 180, 150, 25);
        endereco.setForeground(Color.darkGray);
        add(endereco);


        bairro_text.setBounds(50, 210, 150, 25);
        bairro_text.setText("Bairro: ");
        bairro_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        bairro_text.setForeground(Color.darkGray);
        add(bairro_text);

        bairro.setBounds(120, 210, 150, 25);
        bairro.setForeground(Color.darkGray);
        add(bairro);


        cep_text.setBounds(50, 240, 150, 25);
        cep_text.setText("CEP: ");
        cep_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cep_text.setForeground(Color.darkGray);
        add(cep_text);

        cep.setBounds(120, 240, 150, 25);
        cep.setForeground(Color.darkGray);
        add(cep);


        telefone_text.setBounds(50, 270, 150,25);
        telefone_text.setText("Telefone: ");
        telefone_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        telefone_text.setForeground(Color.darkGray);
        add(telefone_text);

        telefone.setBounds(120,270,150,25);
        telefone.setForeground(Color.darkGray);
        add(telefone);


        registrar.setText("Cadastrar cliente");
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
        CadastroClientes tela1 = new CadastroClientes();
        
    }
}
