package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.EquipamentoController;
import design.GradientePanel;
import design.RoundButton;
import design.RoundedPanel;
import model.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TabelaEquipamento extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable tabela;
    private DefaultTableModel modelo;
    private int linha;
    private RoundButton btnAtualizar;
    private RoundButton btnExcluir;
    private JTextField txtTitulo;

    EquipamentoController controller = new EquipamentoController();

    public TabelaEquipamento() {
        setTitle("Equipamentos Cadastrados");
        setSize(600, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        GradientePanel contentPanel = new GradientePanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        RoundedPanel scrollContainer = new RoundedPanel();
        scrollContainer.setBounds(79, 65, 430, 250);
        scrollContainer.setBackgroundColor(Color.WHITE);
        scrollContainer.setLayout(null);
        contentPanel.add(scrollContainer);

        modelo = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(modelo);
        JTableHeader header = tabela.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 12));

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                linha = tabela.getSelectedRow();
                if (linha != -1) {
                    btnAtualizar.setVisible(true);
                    btnExcluir.setVisible(true);
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 410, 230);
        scroll.setBackground(Color.WHITE);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scrollContainer.add(scroll);

        btnAtualizar = new RoundButton("Atualizar");
        btnAtualizar.setBounds(89, 333, 100, 25);
        btnAtualizar.setVisible(false);
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.addActionListener(e -> atualizarEquipamento(tabela));
        contentPanel.add(btnAtualizar);

        btnExcluir = new RoundButton("Excluir");
        btnExcluir.setBounds(398, 333, 100, 25);
        btnExcluir.setVisible(false);
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.addActionListener(e -> {
            try {
                excluirDados(tabela);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        contentPanel.add(btnExcluir);

        RoundButton btnVoltar = new RoundButton("Voltar");
        btnVoltar.setBounds(247, 333, 100, 25);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.addActionListener(e -> {
            new CadastroEquipamento();
            setVisible(false);
        });
        contentPanel.add(btnVoltar);
        
        

        MostrarImagem painelImagem = new MostrarImagem();
        painelImagem.setBounds(10, -14, 100, 104);
        painelImagem.setBackground(new Color(166, 180, 255));
        contentPanel.add(painelImagem);

        txtTitulo = new JTextField("EQUIPAMENTOS CADASTRADOS");
        txtTitulo.setFont(new Font("Sitka Small", Font.BOLD, 17));
        txtTitulo.setBounds(155, 22, 290, 32);
        txtTitulo.setForeground(Color.WHITE);
        txtTitulo.setOpaque(false);
        txtTitulo.setBorder(null);
        txtTitulo.setEditable(false);
        contentPanel.add(txtTitulo);

        carregarDados();

        contentPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component clicado = SwingUtilities.getDeepestComponentAt(contentPanel, e.getX(), e.getY());
                if (!(clicado instanceof JTable || SwingUtilities.isDescendingFrom(clicado, tabela))) {
                    tabela.clearSelection();
                    btnAtualizar.setVisible(false);
                    btnExcluir.setVisible(false);
                }
            }
        });

        setVisible(true);
    }

    private void carregarDados() {
        Conexao.conectar();
        String sql = "SELECT Cod_Equip, Nome_Equip, Cod_Emp FROM Equipamento";

        try (
            Connection conn = Conexao.Conexao;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            modelo.setColumnIdentifiers(new Object[]{"Código", "Nome", "Cod_Emp"});
            while (rs.next()) {
                modelo.addRow(new Object[] {
                    rs.getString("Cod_Equip"),
                    rs.getString("Nome_Equip"),
                    rs.getString("Cod_Emp")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }

    private void atualizarEquipamento(JTable tabela) {
        linha = tabela.getSelectedRow();
        if (linha != -1) {
            int cod_Equip = Integer.parseInt((String) tabela.getValueAt(linha, 0));
            String nome = (String) tabela.getValueAt(linha, 1);
            int cod_Emp = Integer.parseInt((String) tabela.getValueAt(linha, 2));

            new AtualizarEquipamento(cod_Equip, nome, cod_Emp);
            setVisible(false);
        }
    }

    private void excluirDados(JTable tabela) throws SQLException {
        linha = tabela.getSelectedRow();
        if (linha != -1) {
            int cod_Equip = Integer.parseInt((String) tabela.getValueAt(linha, 0));
            String nome = (String) tabela.getValueAt(linha, 1);
            int cod_Emp = Integer.parseInt((String) tabela.getValueAt(linha, 2));

            controller.excluir(cod_Equip, nome, cod_Emp);
            new TabelaEquipamento();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabelaEquipamento::new);
    }
}
