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
    private JButton editarveiculo = new JButton();
    private JButton clientes = new JButton();
    private JButton cadastrar_clientes = new JButton();
    private JButton editarcliente = new JButton();
    private JButton alugueis = new JButton();
    private JButton alugar = new JButton();
    private JButton editarAluguel = new JButton();

    

    // CONSTRUTOR
    public MenuInterface(){
        
        // JFRAME
        setTitle("SiCars - Aluguel de Carros");
        setSize(600, 450);
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
        veiculos.setBounds(50,115,130,50);
        veiculos.setFont(f);
        veiculos.setForeground(Color.white);
        veiculos.setBackground(Color.GRAY);
        add(veiculos);
        // AÇÃO
        veiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ //AÇÃO DO BOTÃO VEICULOS 
                int opcao = JOptionPane.showOptionDialog(null, "Procurar por placa? Se não lista todos os veículos.", "Confirmação:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null); //CRIAM UMA PERGUNTA EM UM JOPTION SE SIM OU NÃO

                if (opcao == JOptionPane.YES_OPTION) { // SE SIM, INFORMA A PLACA 
                    String placa = JOptionPane.showInputDialog(null, "Informe a placa do veículo:", "Procurar Placa", JOptionPane.QUESTION_MESSAGE);

                    ClienteDAO clienteDAO = new ClienteDAO(); 

                    VeiculosTableInterface veiculosTableInterface = new VeiculosTableInterface(true, placa); // PASSA A VALIDAÇÃO E A PLACA //
                    
                    dispose(); //FECHA A JANELA ATUAL

                } else {
                    JOptionPane.showMessageDialog(null, "AGUARDE... Estamos carregando os dados."); // MENSAGEM
                    dispose();
                    VeiculosTableInterface veiculosTableInterface = new VeiculosTableInterface(false, null); // INSTANCIA CASO NÃO SEJA PESQUISA, ABRE TUDO
                }
                
            }
        });

        // BOTÃO CADASTRAR VEICULOS 
        cadastrar_veiculos.setText("Cadastrar veículos");
        cadastrar_veiculos.setBounds(190,115,180,50);
        cadastrar_veiculos.setFont(f);
        cadastrar_veiculos.setForeground(Color.white);
        cadastrar_veiculos.setBackground(Color.gray);
        add(cadastrar_veiculos);
        // AÇÃO
        cadastrar_veiculos.addActionListener(new ActionListener() { // AÇÃO DO BOTÃO CADASTRAR VEICULO
            public void actionPerformed(ActionEvent e){
                dispose();
                CadastroVeiculosInterface cadastroVeiculos = new CadastroVeiculosInterface();
                
            }
        });
        
        //editar veic
        editarveiculo.setText("Editar Veículos");
        editarveiculo.setBounds(380,115,160,50);
        editarveiculo.setFont(f);
        editarveiculo.setForeground(Color.white);
        editarveiculo.setBackground(Color.gray);
        add(editarveiculo);
        // AÇÃO
        editarveiculo.addActionListener(new ActionListener() { //AÇÃO DO BOTÃO EDITAR
            public void actionPerformed(ActionEvent e){
                // PEDE A PLACA
                String placa = JOptionPane.showInputDialog(null, "Informe a placa do veículo a ser editado:", "Editar Veículo", JOptionPane.QUESTION_MESSAGE);
                //CRIA A INSTANCIA 
                VeiculoDAO veiculoDAO = new VeiculoDAO();
                Veiculo veiculo = veiculoDAO.buscarPorPlaca(placa); // PASSA A PLACA COMO PARAMETRO 
                CadastroVeiculosInterface cadastroVeiculos = new CadastroVeiculosInterface();
                cadastroVeiculos.atualizar = true; // PARAMETRO PARA ATUALIZAR 
                cadastroVeiculos.preencherCampos(veiculo); // PARAMETRO PARA PRÉ-PREENCHER 

            }
        });

        // BOTÃO VER CLIENTES
        clientes.setText("Ver clientes");
        clientes.setBounds(50,200,130,50);
        clientes.setFont(f);
        clientes.setForeground(Color.white);
        clientes.setBackground(Color.GRAY);
        add(clientes);
        // AÇÃO
        clientes.addActionListener(new ActionListener() { // AÇÃO DO BOTÃO CLIENTES
            public void actionPerformed(ActionEvent e){
                // PEDE A OPÇÃO 
                int opcao = JOptionPane.showOptionDialog(null, "Procurar por CPF? Se não lista todos os clientes.", "Confirmação:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (opcao == JOptionPane.YES_OPTION) { // SE SIM PEDE CPF
                    String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:", "Procurar Cliente", JOptionPane.QUESTION_MESSAGE);

                    ClientesTableInterface clientesTableInterface = new ClientesTableInterface(true, cpf); 
                                                                        // PASSA DE PARAMETRO O TRUE E O CPF //
                    
                    dispose(); // FECHA A JANELA ATUAL // 

                } else {
                    JOptionPane.showMessageDialog(null, "AGUARDE... Estamos carregando os dados."); //MENSAGEM
                    dispose();
                    ClientesTableInterface clientesTableInterface = new ClientesTableInterface(false, null); // ABRE A TELA NORMAL
                }
            }
        });

        // BOTÃO CADASTRAR CLIENTES
        cadastrar_clientes.setText("Cadastrar clientes");
        cadastrar_clientes.setBounds(190,200,180,50);
        cadastrar_clientes.setFont(f);
        cadastrar_clientes.setForeground(Color.white);
        cadastrar_clientes.setBackground(Color.gray);
        add(cadastrar_clientes);
        // AÇÃO
        cadastrar_clientes.addActionListener(new ActionListener() { //AÇÃO DO BOTÃO VOLTAR
            public void actionPerformed(ActionEvent e){
                dispose();
                CadastroClientesInterface cadastroClientes = new CadastroClientesInterface();
                
            }
        });

        //editar cliente
        editarcliente.setText("Editar clientes");
        editarcliente.setBounds(380,200,160,50);
        editarcliente.setFont(f);
        editarcliente.setForeground(Color.white);
        editarcliente.setBackground(Color.gray);
        add(editarcliente);
        // AÇÃO
        editarcliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ // AÇÃO DO BOTÃO EDITAR
                // PEDE CPF
                String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente a ser editado:", "Editar Cliente", JOptionPane.QUESTION_MESSAGE);
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.buscarPorCpf(cpf); // CHAMA O MÉTODO
                dispose();
                CadastroClientesInterface cadastroClientes = new CadastroClientesInterface();
                cadastroClientes.atualizar = true; // PASSA O PARAMETRO DE ATUALIZAR
                cadastroClientes.preencherCampos(cliente); // PASSA O OBJETO
                
            }
        });

        //alugar
        alugar.setText("Realizar aluguel");
        alugar.setBounds(190,285,180,50);
        alugar.setFont(f);
        alugar.setForeground(Color.white);
        alugar.setBackground(Color.gray);
        add(alugar);
        // AÇÃO
        alugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ //AÇÃO DO BOTÃO ALUGAR
                dispose();
                AlugarCarrosInterface alugarCarrosInterface = new AlugarCarrosInterface();
                
            }
        });

        //alugueis
        alugueis.setText("Ver Aluguéis");
        alugueis.setBounds(50,285,130,50);
        alugueis.setFont(f);
        alugueis.setForeground(Color.white);
        alugueis.setBackground(Color.gray);
        add(alugueis);
        // AÇÃO
        alugueis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // OPÇÃO SIM OU NÃO
                int opcao = JOptionPane.showOptionDialog(null, "Procurar por CPF? Se não lista todos os aluguéis.", "Confirmação:",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (opcao == JOptionPane.YES_OPTION) { //SE SIM
                    // PEDE CPF
                    String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:", "Procurar Cliente", JOptionPane.QUESTION_MESSAGE);

                    AluguelTableInterface aluguelTableInterface = new AluguelTableInterface(true, cpf); // PASSA O PARAMETRO E O CPF //
                    
                    
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "AGUARDE... Estamos carregando os dados.");
                    AluguelTableInterface aluguelTableInterface = new AluguelTableInterface(false, null);
                    dispose();

                }
            }
        });

        //editar aluguel
        editarAluguel.setText("Editar aluguel");
        editarAluguel.setBounds(380,285,160,50);
        editarAluguel.setFont(f);
        editarAluguel.setForeground(Color.white);
        editarAluguel.setBackground(Color.gray);
        add(editarAluguel);
        // AÇÃO
        editarAluguel.addActionListener(new ActionListener() { //AÇÃO DO BOTÃO EDITAR
            public void actionPerformed(ActionEvent e){
                //PEDE CPF
                String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente a ser editado:", "Editar Cliente", JOptionPane.QUESTION_MESSAGE);
                AluguelDAO aluguelDAO = new AluguelDAO();
                Aluguel aluguel = aluguelDAO.buscarPorCpf(cpf); //PASSA PARAMETRO CPF
                dispose();
                AlugarCarrosInterface alugarCarrosInterface = new AlugarCarrosInterface();
                alugarCarrosInterface.atualizar = true; //PASSA PARAMETRO
                alugarCarrosInterface.preencherCampos(aluguel); //PASSA OBJETO
                
                
                
            }
        });

    }
    public static void main(String[] args) {
        MenuInterface menu = new MenuInterface();
        
    }
}


