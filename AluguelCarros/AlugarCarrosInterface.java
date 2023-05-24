import javax.swing.*;                      // IMPORTAÇÕES NECESSÁRIAS //    
import java.awt.Font;            // JAVA SWING, JAVA.AWT CORES, FONTES E EVENTOS //
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class AlugarCarrosInterface extends JFrame {

        // INSTANCIANDO AS FONTES DAS LOGOS E TEXTOS //
    private Font f = new Font("Poppins",Font.BOLD,10);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

        // INSTANCIANDO UMA JLABEL PARA POR OS TITULOS E TEXTOS //
    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

        // INSTANCIANDO OS CAMPOS E TEXTOS DE CADA ENTRADA DA INTERFACE //
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

        // INSTANCIANDO OS BOTÕES //
    private JButton registrar = new JButton();
    private JButton voltar = new JButton();
    
        // CONSTRUTOR DA CLASSE AlugarCarros //
    public AlugarCarrosInterface(){
        
        // CONFIGURANDO A JANELA JFRAME //
        setTitle("SiCars - Aluguel de Carros"); // TITULO DA JANELA // 
        setSize(600, 450); // TAMANHO DA JANELA //
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // OPERAÇÃO PARA QUANDO APERTAR EM FECHAR //
        setResizable(false); // NÃO REDIMENSIONAR //
        setLocationRelativeTo(null); // APARECER NO MEIO DA TELA //
        setLayout(null); // SEM GERENCIADOR DE LAYOUT // 
        setVisible(true); // VISIBILIDADE // 

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                VeiculosInterace veiculos = new VeiculosInterace();
            }
        });

        
        // CONFIGURAÇÃO DO SUBTITULO // 
        subtitulo.setText("ALUGAR CARROS");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        //CONFIGURAÇÃO DO TITULO // 
        titulo.setText("Informe os dados para realizar o aluguel");
        titulo.setBounds(20,40,350,30);
        titulo.setFont(tituloFont);
        titulo.setForeground(Color.GRAY);
        add(titulo);

        //CONFIGURAÇÃO DA LOGO//
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

        // CONFIGURAÇÃO TEXTO DO CAMPO NOME CLIENTE // 
        nome_cliente_text.setBounds(50, 90,150,25);
        nome_cliente_text.setText("Nome do cliente: ");
        nome_cliente_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        nome_cliente_text.setForeground(Color.darkGray);
        add(nome_cliente_text);

        // CONFIGURAÇÃO DO CAMPO NOME CLIENTE // 
        nome_cliente.setBounds(180, 90, 150, 25);
        nome_cliente.setForeground(Color.darkGray);
        add(nome_cliente);

        // CONFIGURAÇÃO DO TEXTO DO CAMPO CPF //
        cpf_text.setBounds(50, 120, 150, 25);
        cpf_text.setText("CPF: ");
        cpf_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cpf_text.setForeground(Color.darkGray);
        add(cpf_text);

        // CONFIGURAÇÃO DO CAMPO CPF //
        cpf.setBounds(180, 120, 150, 25);
        cpf.setForeground(Color.darkGray);
        add(cpf);

        // CONFIGURAÇÃO DO TEXTO DO CAMPO PLACA // 
        placa_text.setBounds(50, 150, 150, 25);
        placa_text.setText("Placa do veículo: ");
        placa_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        placa_text.setForeground(Color.darkGray);
        add(placa_text);

        // CONFIGURAÇÃO DO CAMPO PLACA //
        placa.setBounds(180, 150, 150, 25);
        placa.setForeground(Color.darkGray);
        add(placa);

        // CONFIGURAÇÃO DO TEXTO ANTES DO CAMPO DIARIAS //
        diarias_text.setBounds(50, 180, 150, 25);
        diarias_text.setText("Endereço: ");
        diarias_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        diarias_text.setForeground(Color.darkGray);
        add(diarias_text);

        // CONFIGURAÇÃO DO CAMPO DIARIAS //
        diarias.setBounds(180, 180, 150, 25);
        diarias.setForeground(Color.darkGray);
        add(diarias);

        // CONFIGURAÇÃO DO TEXTO ANTES DO CAMPO NOME DO CONSULTOR // 
        nome_consultor_text.setBounds(50, 210, 150, 25);
        nome_consultor_text.setText("Nome do consultor: ");
        nome_consultor_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        nome_consultor_text.setForeground(Color.darkGray);
        add(nome_consultor_text);

        // CONFIGURAÇÃO DO CAMPO NOME DO CONSULTOR //
        nome_consultor.setBounds(180, 210, 150, 25);
        nome_consultor.setForeground(Color.darkGray);
        add(nome_consultor);

        // CONFIGURAÇÃO DO TEXTO ANTES DO CAMPO SENHA DO CONSULTOR //
        senha_consultor_text.setBounds(50, 240, 150, 25);
        senha_consultor_text.setText("Senha do consultor: ");
        senha_consultor_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        senha_consultor_text.setForeground(Color.darkGray);
        add(senha_consultor_text);
        
        // CONFIGURAÇÃO DO CAMPO SENHA DO CONSULTOR //
        senha_consultor.setBounds(180, 240, 150, 25);
        senha_consultor.setForeground(Color.darkGray);
        add(senha_consultor);

        // CONFIGURAÇÃO DO BOTÃO REGISTRAR // 
        registrar.setText("Realizar aluguel");
        registrar.setBounds(300,330,130,30);
        registrar.setFont(f);
        registrar.setForeground(Color.white);
        registrar.setBackground(Color.GRAY);

        // ADICIONANDO AÇÃO AO BOTÃO //
        registrar.addActionListener(new ActionListener() { // USA O MÉTODO DA BIBLIOTECA AWT, PASSANDO actionPerformed, //
            public void actionPerformed(ActionEvent e){   // COMO PARÂMETRO.                                           //
                JOptionPane.showMessageDialog(AlugarCarrosInterface.this, "Aluguel Registrado!"); // POP-UP PARA CONFIRMAR QUE O REGISTRO //
                                                                                                // FOI SALVO                            //
                dispose(); // FECHA A JANELA ATUAL // 

                MenuInterface menu = new MenuInterface(); // INSTÂNCIA DE MENU, PARA ABRIR COMO NOVA TELA //
            }
        });

        add(registrar);
        
        // CONFIGURAÇÃO DO BOTÃO VOLTAR //
        voltar.setText("Voltar");
        voltar.setBounds(165,330,120,30);
        voltar.setFont(f);
        voltar.setForeground(Color.white);
        voltar.setBackground(Color.gray);
        
        // ADICIONANDO AÇÃO AO BOTÃO //
        voltar.addActionListener(new ActionListener() {  // USA O MÉTODO DA BIBLIOTECA AWT, PASSANDO actionPerformed, //
            public void actionPerformed(ActionEvent e){ // COMO PARÂMETRO.                                           //
               
                MenuInterface menu1 = new MenuInterface(); // INSTÂNCIA DE MENU, PARA ABRIR COMO UMA NOVA TELA. //
                
                dispose(); // FECHA A JANELA ATUAL // 
            }
        });

        add(voltar);
        
    }

    public static void main(String[] args) {
        AlugarCarrosInterface tela1 = new AlugarCarrosInterface();
        
    }
}


    