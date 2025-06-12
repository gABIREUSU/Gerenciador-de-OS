package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EquipamentoController;
import design.DJTextField;
import design.GradientePanel;
import design.RoundButton;


public class AtualizarEquipamento extends JFrame {
    private static final long serialVersionUID = 1L;

    private DJTextField txtNome;
    private DJTextField txtCodEmp;
    private int codEquipGlobal;

    private EquipamentoController controller = new EquipamentoController();

    public AtualizarEquipamento(int codEquip, String nome, int codEmp) {
        setTitle("Atualizar Equipamento");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);

        codEquipGlobal = codEquip;

        GradientePanel contentPanel = new GradientePanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(235, 0, 368, 371);
        contentPanel.add(panel);
        panel.setLayout(null);

        txtNome = new DJTextField(nome);
        txtNome.setBounds(38, 102, 269, 20);
        panel.add(txtNome);
        addFocus(txtNome);

        txtCodEmp = new DJTextField(String.valueOf(codEmp));
        txtCodEmp.setBounds(38, 157, 269, 20);
        panel.add(txtCodEmp);
        addFocus(txtCodEmp);

        RoundButton btnSalvar = new RoundButton("Atualizar");
        btnSalvar.setBounds(195, 297, 86, 20);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setBackground(Color.BLACK);
        panel.add(btnSalvar);
        btnSalvar.addActionListener(e -> {
            try {
                atualizar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        RoundButton btnLimpar = new RoundButton("Limpar");
        btnLimpar.setBounds(62, 297, 86, 20);
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setBackground(Color.BLACK);
        panel.add(btnLimpar);
        btnLimpar.addActionListener(e -> limpar(contentPanel));

        RoundButton btnVoltar = new RoundButton("Voltar");
        btnVoltar.setBounds(62, 328, 219, 20);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBackground(Color.BLACK);
        panel.add(btnVoltar);
        btnVoltar.addActionListener(e -> {
            new TabelaEquipamento();
            setVisible(false);
        });

        JLabel lblNome = new JLabel("Nome");
        lblNome.setForeground(Color.GRAY);
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNome.setBounds(38, 78, 53, 27);
        panel.add(lblNome);

        JLabel lblCodEmp = new JLabel("Código da Empresa");
        lblCodEmp.setForeground(Color.GRAY);
        lblCodEmp.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCodEmp.setBounds(38, 133, 150, 27);
        panel.add(lblCodEmp);

        JLabel lblTitulo = new JLabel("Vamos atualizar");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblTitulo.setBounds(38, 40, 200, 27);
        panel.add(lblTitulo);

        // Lado Esquerdo
        JLabel lblBemVindo = new JLabel("Bem-Vindo, ");
        lblBemVindo.setBounds(44, 116, 159, 27);
        lblBemVindo.setForeground(Color.WHITE);
        lblBemVindo.setFont(new Font("Sitka Small", Font.BOLD, 23));
        contentPanel.add(lblBemVindo);

        JLabel lblMensagem1 = new JLabel("Altere os dados ao lado");
        lblMensagem1.setBounds(10, 143, 215, 27);
        lblMensagem1.setForeground(Color.WHITE);
        lblMensagem1.setFont(new Font("Sitka Small", Font.BOLD, 15));
        contentPanel.add(lblMensagem1);

        JLabel lblMensagem2 = new JLabel("e clique em atualizar.");
        lblMensagem2.setBounds(20, 164, 185, 27);
        lblMensagem2.setForeground(Color.WHITE);
        lblMensagem2.setFont(new Font("Sitka Small", Font.BOLD, 15));
        contentPanel.add(lblMensagem2);

        MostrarImagem painelImagem = new MostrarImagem();
        painelImagem.setBounds(44, 0, 144, 144);
        painelImagem.setBackground(new Color(166, 180, 255));
        contentPanel.add(painelImagem);
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

    void limpar(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof DJTextField) {
                ((DJTextField) component).setTxPadrao();
            } else if (component instanceof Container) {
                limpar((Container) component);
            }
        }
    }

    boolean validarNome() {
        String nome = txtNome.getText().trim();
        return !nome.isEmpty();
    }

    boolean validarCodigoEmpresa() {
        try {
            int codigo = Integer.parseInt(txtCodEmp.getText().trim());
            return codigo > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void atualizar() throws SQLException {
        if (!validarNome()) {
            JOptionPane.showMessageDialog(this, "O nome do equipamento não pode estar vazio.");
            return;
        }

        if (!validarCodigoEmpresa()) {
            JOptionPane.showMessageDialog(this, "Código da empresa inválido.");
            return;
        }

        controller.atualizar(codEquipGlobal, txtNome.getText(), Integer.parseInt(txtCodEmp.getText()));
        JOptionPane.showMessageDialog(this, "Equipamento atualizado com sucesso!");
        new TabelaEquipamento();
        setVisible(false);
    }
}