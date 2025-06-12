package view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.EquipamentoController;
import design.DJTextField;
import design.GradientePanel;
import design.MostrarPanda;
import design.MostrarSeta;
import design.RoundButton;
import design.RoundedComboBoxUI;

public class CadastroEquipamento extends JFrame {
    private static final long serialVersionUID = 1L;

    private DJTextField txtNome;
    private JComboBox<String> comboEmpresas;
    private EquipamentoController controller = new EquipamentoController();

    public CadastroEquipamento() {
        getContentPane().setBackground(new Color(255, 255, 255));
        setTitle("Cadastro de Equipamento");
        setSize(595, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        getContentPane().setLayout(null);

        GradientePanel painel = new GradientePanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 199, 361);
        getContentPane().add(painel);

        MostrarPanda painelImagem = new MostrarPanda();
        painelImagem.setBounds(-22, 158, 232, 256);
        painelImagem.setBackground(new Color(166, 180, 255));
        painel.add(painelImagem);
        
        MostrarImagem painelImagem1 = new MostrarImagem();
        painelImagem1.setBounds(42, 11, 115, 113);
        painelImagem1.setBackground(new Color(166, 180, 255));
        painel.add(painelImagem1);

        JLabel lblHoraDeCadastrar = new JLabel("Hora de cadastrar");
        lblHoraDeCadastrar.setForeground(Color.WHITE);
        lblHoraDeCadastrar.setFont(new Font("Sitka Small", Font.BOLD, 15));
        lblHoraDeCadastrar.setBounds(27, 97, 152, 27);
        painel.add(lblHoraDeCadastrar);

        JLabel lblOEquipamento = new JLabel("o equipamento");
        lblOEquipamento.setForeground(Color.WHITE);
        lblOEquipamento.setFont(new Font("Sitka Small", Font.BOLD, 15));
        lblOEquipamento.setBounds(37, 120, 120, 27);
        painel.add(lblOEquipamento);

        txtNome = new DJTextField("       Equipamento");
        txtNome.setBounds(267, 188, 240, 30);
        getContentPane().add(txtNome);
        addFocus(txtNome);

        RoundButton btnListar = new RoundButton("Listar Equipamentos");
        btnListar.setBounds(301, 315, 175, 20);
        getContentPane().add(btnListar);
        btnListar.setText("Lista de equipamentos");
        btnListar.setForeground(Color.WHITE);
        btnListar.setBackground(Color.BLACK);

        comboEmpresas = new JComboBox<>();
        comboEmpresas.setBounds(267, 147, 240, 30);
        getContentPane().add(comboEmpresas);
        comboEmpresas.setBackground(Color.WHITE);
        comboEmpresas.setForeground(Color.BLACK);
        comboEmpresas.setUI(new RoundedComboBoxUI());
        comboEmpresas.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        comboEmpresas.addItem("Selecionar empresa");
        comboEmpresas.setSelectedIndex(0);

        comboEmpresas.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if ("Selecionar empresa".equals(value)) {
                    label.setForeground(Color.LIGHT_GRAY);
                } else {
                    label.setForeground(Color.BLACK);
                }
                label.setBackground(Color.WHITE);
                label.setOpaque(true);
                label.setBorder(new EmptyBorder(2, 8, 2, 2));
                return label;
            }
        });

        RoundButton btnLimpar = new RoundButton("Limpar");
        btnLimpar.setBounds(252, 284, 86, 20);
        getContentPane().add(btnLimpar);
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setBackground(Color.BLACK);

        RoundButton btnSalvar = new RoundButton("Salvar");
        btnSalvar.setBounds(439, 284, 86, 20);
        getContentPane().add(btnSalvar);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setBackground(Color.BLACK);

        JLabel lblSelecioneAEmpresa = new JLabel("Selecione a empresa");
        lblSelecioneAEmpresa.setForeground(Color.BLACK);
        lblSelecioneAEmpresa.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblSelecioneAEmpresa.setBounds(301, 60, 175, 27);
        getContentPane().add(lblSelecioneAEmpresa);

        JLabel lblEEscrevaSeu = new JLabel("e escreva seu tipo de equipamento");
        lblEEscrevaSeu.setForeground(Color.BLACK);
        lblEEscrevaSeu.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblEEscrevaSeu.setBounds(242, 81, 298, 27);
        getContentPane().add(lblEEscrevaSeu);

        MostrarSeta painelImagem11 = new MostrarSeta();
        painelImagem11.setBounds(528, 11, 30, 27);
        getContentPane().add(painelImagem11);
        painelImagem11.setBackground(new Color(166, 180, 255));

        JLabel lblEmpresasCadastradas = new JLabel("Empresas cadastradas");
        lblEmpresasCadastradas.setForeground(Color.GRAY);
        lblEmpresasCadastradas.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmpresasCadastradas.setBounds(273, 122, 128, 27);
        getContentPane().add(lblEmpresasCadastradas);

        painelImagem11.addActionListener(e -> {
            new Menu().setVisible(true);
            dispose();
        });

        btnSalvar.addActionListener(e -> salvarEquipamento());

        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            comboEmpresas.setSelectedIndex(0);
        });

        btnListar.addActionListener(e -> {
            new TabelaEquipamento();
            setVisible(false);
        });

        txtNome.setTxPadrao();
        carregarEmpresas(); 
        setVisible(true);   
    }

    private void carregarEmpresas() {
        try {
            List<String> empresas = controller.carregarEmpresas();
            for (String empresa : empresas) {
                comboEmpresas.addItem(empresa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar empresas: " + e.getMessage());
        }
    }

    private void addFocus(DJTextField txt) {
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txt.DfocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                txt.DfocusLost();
            }
        });
    }

    private void salvarEquipamento() {
        String nome = txtNome.getText().trim();
        String nomeEmpresa = (String) comboEmpresas.getSelectedItem();

        if (nome.isEmpty() || nomeEmpresa == null || nomeEmpresa.equals("Selecionar empresa")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        try {
            int codEmp = controller.getCodEmp(nomeEmpresa);
            if (codEmp == -1) {
                JOptionPane.showMessageDialog(null, "Empresa não encontrada.");
                return;
            }

            controller.salvar(nome, codEmp);
            JOptionPane.showMessageDialog(null, "Equipamento salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroEquipamento());
    }
}