import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;  // IMPORTAÇÕES NECESSÁRIAS //
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CadastroVeiculosInterface extends JFrame {

    // FONTES
    private Font f = new Font("Poppins",Font.BOLD,10);
    private Font tituloFont = new Font("Poppins",Font.BOLD,15);  
    private Font logoFont = new Font("Poppins",Font.BOLD,35);

    // TITULOS, SUBTITULOS E LOGO
    private JLabel titulo = new JLabel();
    private JLabel subtitulo = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel logoDois = new JLabel();

    // CAMPOS E PRÉ CAMPOS
    private JTextField fabricante = new JTextField();
    private JLabel fabricante_text = new JLabel();
    private JTextField modelo = new JTextField();
    private JLabel modelo_text = new JLabel();
    private JTextField cor = new JTextField();
    private JLabel cor_text = new JLabel();
    private JTextField placa = new JTextField();
    private JLabel placa_text = new JLabel();
    private JTextField chassi = new JTextField();
    private JLabel chassi_text = new JLabel();
    private JTextField anoFabricacao = new JTextField();
    private JLabel anoFabricacao_text = new JLabel();
    private JTextField situacao = new JTextField();
    private JLabel situacao_text = new JLabel();
    private JLabel situacao_exemplo = new JLabel();
    private JLabel ano_exemplo = new JLabel();

    // BOTÕES
    private JButton registrar = new JButton();
    private JButton voltar = new JButton();

    public boolean atualizar = false;

    // CONSTRUTOR 
    public CadastroVeiculosInterface(){

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
                dispose();
                JOptionPane.showMessageDialog(null, "AGUARDE... ESTAMOS CARREGANDO OS DADOS.");
                // Ao fechar a janela principal, cria e exibe uma nova janela JFrame
                VeiculosTableInterface veiculosTableInterface = new VeiculosTableInterface();
                
                
            }
        });

        // SUBTITULOS E LOGOS
        subtitulo.setText("CADASTRO DE VEÍCULOS");
        subtitulo.setBounds(20,10,350,30);
        subtitulo.setFont(new java.awt.Font("Bahnscrift",1, 12));
        subtitulo.setForeground(Color.GRAY);
        add(subtitulo);

        titulo.setText("Informe os dados do veículo a ser cadastrado");
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

        // CAMPOS E TEXTOS PRÉ CAMPOS
        fabricante_text.setBounds(50, 90,150,25);
        fabricante_text.setText("Fabricante: ");
        fabricante_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        fabricante_text.setForeground(Color.darkGray);
        add(fabricante_text);

        fabricante.setBounds(120, 90, 150, 25);
        fabricante.setForeground(Color.darkGray);
        add(fabricante);


        modelo_text.setBounds(50, 120, 150, 25);
        modelo_text.setText("Modelo: ");
        modelo_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        modelo_text.setForeground(Color.darkGray);
        add(modelo_text);

        modelo.setBounds(120, 120, 150, 25);
        modelo.setForeground(Color.darkGray);
        add(modelo);


        cor_text.setBounds(50, 150, 150, 25);
        cor_text.setText("Cor: ");
        cor_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        cor_text.setForeground(Color.darkGray);
        add(cor_text);

        cor.setBounds(120, 150, 150, 25);
        cor.setForeground(Color.darkGray);
        add(cor);


        placa_text.setBounds(50, 180, 150, 25);
        placa_text.setText("Placa: ");
        placa_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        placa_text.setForeground(Color.darkGray);
        add(placa_text);

        placa.setBounds(120, 180, 150, 25);
        placa.setForeground(Color.darkGray);
        add(placa);


        chassi_text.setBounds(50, 210, 150, 25);
        chassi_text.setText("Chassi: ");
        chassi_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        chassi_text.setForeground(Color.darkGray);
        add(chassi_text);

        chassi.setBounds(120, 210, 150, 25);
        chassi.setForeground(Color.darkGray);
        add(chassi);


        anoFabricacao_text.setBounds(50, 240, 150, 25);
        anoFabricacao_text.setText("Ano de Fabricação: ");
        anoFabricacao_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        anoFabricacao_text.setForeground(Color.darkGray);
        add(anoFabricacao_text);

        anoFabricacao.setBounds(165, 240, 150, 25);
        anoFabricacao.setForeground(Color.darkGray);
        add(anoFabricacao);

        ano_exemplo.setBounds(330, 240, 200,25);
        ano_exemplo.setText("Ex.: 2008");
        ano_exemplo.setFont(new java.awt.Font("Banhscrift", 1, 12));
        ano_exemplo.setForeground(Color.darkGray);
        add(ano_exemplo);


        situacao_text.setBounds(50, 270, 150,25);
        situacao_text.setText("Situação do veículo: ");
        situacao_text.setFont(new java.awt.Font("Banhscrift", 1, 12));
        situacao_text.setForeground(Color.darkGray);
        add(situacao_text);

        situacao.setBounds(165,270,150,25);
        situacao.setForeground(Color.darkGray);
        add(situacao);

        situacao_exemplo.setBounds(330, 270, 200,25);
        situacao_exemplo.setText("Ex.: Disponivel/Pendencias");
        situacao_exemplo.setFont(new java.awt.Font("Banhscrift", 1, 12));
        situacao_exemplo.setForeground(Color.darkGray);
        add(situacao_exemplo);

        // BOTÃO REGISTRAR
        registrar.setText("Salvar");
        registrar.setBounds(300,330,130,30);
        registrar.setFont(f);
        registrar.setForeground(Color.white);
        registrar.setBackground(Color.GRAY);
        add(registrar);
        // AÇÃO DO BOTÃO
        registrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                if(atualizar == true){
                    
                    atualizarVeiculo();
                }else{
                    cadastrarVeiculo();
                }
                
                
                //JOptionPane.showMessageDialog(CadastroVeiculosInterface.this, "Veículo Registrado!");

                VeiculosTableInterface veiculosTableInterface = new VeiculosTableInterface();
                
                dispose();
            }
        });

        // BOTÃO VOLTAR
        voltar.setText("Voltar");
        voltar.setBounds(165,330,120,30);
        voltar.setFont(f);
        voltar.setForeground(Color.white);
        voltar.setBackground(Color.gray);
        add(voltar);
        // AÇÃO DO BOTÃO
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                MenuInterface menuInterface = new MenuInterface();
                
                dispose();
            }
        });

        
    }

    private void atualizarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante(fabricante.getText());
        veiculo.setModelo(modelo.getText());
        veiculo.setCor(cor.getText());
        veiculo.setPlaca(placa.getText());
        veiculo.setChassi(chassi.getText());
        veiculo.setSituacao(situacao.getText());
        veiculo.setAnoFabricacao(Integer.parseInt(anoFabricacao.getText()));

        VeiculoDAO.atualizarVeiculo(veiculo);
        //JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");

    }

    private void cadastrarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante(fabricante.getText());
        veiculo.setModelo(modelo.getText());
        veiculo.setCor(cor.getText());
        veiculo.setPlaca(placa.getText());
        veiculo.setChassi(chassi.getText());
        veiculo.setSituacao(situacao.getText());
        veiculo.setAnoFabricacao(Integer.parseInt(anoFabricacao.getText()));

        VeiculoDAO.cadastrarVeiculo(veiculo);
        //JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");

    }

    public void preencherCampos(Veiculo veiculo) {
        // Atribua os valores do veículo aos campos da interface
        fabricante.setText(veiculo.getFabricante());
        modelo.setText(veiculo.getModelo());
        cor.setText(veiculo.getCor());
        placa.setText(veiculo.getPlaca());
        chassi.setText(veiculo.getChassi());
        anoFabricacao.setText(String.valueOf(veiculo.getAnoFabricacao()));
        situacao.setText(veiculo.getSituacao());
    }
    
    public static void main(String[] args) {
        CadastroVeiculosInterface tela1 = new CadastroVeiculosInterface();
        
    }
}