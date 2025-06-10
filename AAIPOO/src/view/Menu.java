package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import design.GradientePanel;
import design.MostrarComp;
import design.RoundButton;
import design.RoundedPanel;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu window = new Menu();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Menu() {
        initialize();
    }

    private void initialize() {
        setTitle("Menu");
        setBounds(100, 100, 600, 410);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        GradientePanel contentPanel = new GradientePanel();
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        RoundedPanel panel = new RoundedPanel();
        panel.setBounds(22, 84, 531, 263);
        panel.setLayout(null);
        panel.setBackgroundColor(Color.WHITE);
        panel.setCornerRadius(30);
        contentPanel.add(panel);

        MostrarImagem painelImagem = new MostrarImagem();
        painelImagem.setBounds(32, -18, 144, 144);
        painelImagem.setBackground(new Color(166, 180, 255));
        contentPanel.add(painelImagem);

        MostrarComp painelImagem1 = new MostrarComp();
        painelImagem1.setBounds(245, 0, 276, 263);
        painelImagem1.setBackground(new Color(166, 180, 255));
        panel.add(painelImagem1);

        JLabel lblSeuComputadorEm = new JLabel("SEU COMPUTADOR");
        lblSeuComputadorEm.setBounds(36, 42, 185, 46);
        lblSeuComputadorEm.setForeground(Color.BLACK);
        lblSeuComputadorEm.setFont(new Font("Sitka Small", Font.BOLD, 18));
        panel.add(lblSeuComputadorEm);

        JLabel lblEmBoasMos = new JLabel("EM BOAS MÃOS");
        lblEmBoasMos.setBounds(50, 69, 163, 46);
        lblEmBoasMos.setForeground(Color.BLACK);
        lblEmBoasMos.setFont(new Font("Sitka Small", Font.BOLD, 18));
        panel.add(lblEmBoasMos);

        JLabel lblConsertoRpidoSeguro = new JLabel("Conserto rápido, seguro, e com");
        lblConsertoRpidoSeguro.setBounds(36, 111, 203, 16);
        lblConsertoRpidoSeguro.setForeground(Color.BLACK);
        lblConsertoRpidoSeguro.setFont(new Font("Sitka Small", Font.PLAIN, 12));
        panel.add(lblConsertoRpidoSeguro);

        JLabel lblGarantiaDeQualidade = new JLabel("garantia de qualidade!");
        lblGarantiaDeQualidade.setBounds(56, 127, 138, 16);
        lblGarantiaDeQualidade.setForeground(Color.BLACK);
        lblGarantiaDeQualidade.setFont(new Font("Sitka Small", Font.PLAIN, 12));
        panel.add(lblGarantiaDeQualidade);

        RoundButton btnCadastrar = new RoundButton("Cadastrar");
        btnCadastrar.setBounds(86, 166, 120, 30);
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBackground(Color.BLACK);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroEmpresa cadastro = new CadastroEmpresa(); // sua outra tela
                cadastro.setVisible(true);
                System.out.println("Botão 'Cadastrar' clicado.");
                setVisible(false);
            }
        });

        panel.add(btnCadastrar);
    }
}
