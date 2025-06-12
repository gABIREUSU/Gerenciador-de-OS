package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.EmpresaController;
import design.GradientePanel;
import design.RoundButton;
import design.RoundedPanel;
import model.Conexao;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TabelaEmpresa extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable tabela;
    private DefaultTableModel modelo;
    private int linha;
    EmpresaController controller = new EmpresaController();

    public TabelaEmpresa() {
        setTitle("Empresas Cadastradas");
        setSize(600, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        
        GradientePanel contentPanel = new GradientePanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        
        RoundedPanel scrollContainer = new RoundedPanel();
        scrollContainer.setBounds(79, 65, 430, 250);
        scrollContainer.setBackgroundColor(new Color(255, 255, 255));
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
        scroll.setBackground(new Color(255, 255, 255));
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scrollContainer.add(scroll);

      
        btnAtualizar = new RoundButton("Atualizar");
        btnAtualizar.setBounds(89, 333, 100, 25);
        btnAtualizar.setVisible(false);
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.addActionListener(e -> atualizarDados(tabela));
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
            new CadastroEmpresa();
            setVisible(false);
        });
        contentPanel.add(btnVoltar);

        carregarDados();
        setVisible(true);

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
        
        MostrarImagem painelImagem = new MostrarImagem();
        painelImagem.setBounds(10, -14, 100, 104);
        painelImagem.setBackground(new Color(166, 180, 255));
        contentPanel.add(painelImagem);
        
        txtEmpresasCadastradas = new JTextField();
        txtEmpresasCadastradas.setText("EMPRESAS CADASTRADAS");
        txtEmpresasCadastradas.setFont(new Font("Sitka Small", Font.BOLD, 17));
        txtEmpresasCadastradas.setBounds(172, 22, 244, 32);
        txtEmpresasCadastradas.setForeground(Color.WHITE); 
        txtEmpresasCadastradas.setOpaque(false);          
        txtEmpresasCadastradas.setBorder(null);            
        txtEmpresasCadastradas.setEditable(false);         
        contentPanel.add(txtEmpresasCadastradas);

    }

    private RoundButton btnAtualizar;
    private RoundButton btnExcluir;
    private JTextField txtEmpresasCadastradas;

    private void carregarDados() {
        Conexao.conectar();
        String sql = "SELECT Cod_Emp, Nome, CNPJ, Endereco, Telefone FROM Empresas";

        try (
            Connection conn = Conexao.Conexao;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nome", "CNPJ", "Endereço", "Telefone"});
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("Cod_Emp"),
                    rs.getString("Nome"),
                    rs.getString("CNPJ"),
                    rs.getString("Endereco"),
                    rs.getString("Telefone")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }

    public void atualizarDados(JTable tabela) {
        linha = tabela.getSelectedRow();
        if (linha != -1) {
            int cod = Integer.parseInt((String) tabela.getValueAt(linha, 0));
            String nome = (String) tabela.getValueAt(linha, 1);
            String cnpj = (String) tabela.getValueAt(linha, 2);
            String end = (String) tabela.getValueAt(linha, 3);
            String tel = (String) tabela.getValueAt(linha, 4);

            new AtualizarEmpresa(cod, nome, cnpj, end, tel);
            setVisible(false);
        }
    }

    public void excluirDados(JTable tabela) throws SQLException {
        linha = tabela.getSelectedRow();
        if (linha != -1) {
            int cod = Integer.parseInt((String) tabela.getValueAt(linha, 0));
            String nome = (String) tabela.getValueAt(linha, 1);
            String cnpj = (String) tabela.getValueAt(linha, 2);
            String end = (String) tabela.getValueAt(linha, 3);
            String tel = (String) tabela.getValueAt(linha, 4);

            controller.excluir(cod, nome, cnpj, end, tel);
            new TabelaEmpresa();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TabelaEmpresa::new);
    }
}
