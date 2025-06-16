package view;

import controller.TelaConsultaController;
import design.GradientePanel;
import design.MostrarSeta;
import design.RoundButton;
import design.RoundedComboBoxUI;
import design.RoundedPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class TelaConsulta extends JFrame {
    private static final long serialVersionUID = 1L;

    private JComboBox<String> cbTabelas;
    private JComboBox<String> cbFiltros;
    private JTextField txtFiltroValor;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private TelaConsultaController controller;

    private final Map<String, String[]> filtrosPorTabela = Map.of(
        "Empresas", new String[]{"Todos", "Nome", "CNPJ"},
        "Equipamento", new String[]{"Todos", "NomeEquip", "NomeEmpresa"},
        "OS", new String[]{"Todos", "Data", "NomeEquip", "NomeEmpresa"},
        "ItensPorOS", new String[]{"CodOS"}
    );

    public TelaConsulta() {
        setTitle("Consulta com Filtros");
        setSize(650, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        controller = new TelaConsultaController();

        GradientePanel contentPanel = new GradientePanel();
        contentPanel.setLayout(null);
        setContentPane(contentPanel);

        JLabel titulo = new JLabel("CONSULTAR");
        titulo.setFont(new Font("Sitka Small", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(250, 22, 120, 30);
        contentPanel.add(titulo);

        JLabel lblTabela = new JLabel("Tabela:");
        lblTabela.setBounds(50, 70, 60, 25);
        lblTabela.setForeground(Color.WHITE);
        contentPanel.add(lblTabela);

        cbTabelas = new JComboBox<>(filtrosPorTabela.keySet().toArray(new String[0]));
        cbTabelas.setBounds(110, 70, 130, 30);
        cbTabelas.setBackground(Color.WHITE);
        cbTabelas.setForeground(Color.BLACK);
        cbTabelas.setUI(new RoundedComboBoxUI());
        cbTabelas.setBorder(new EmptyBorder(5, 10, 5, 5));
        contentPanel.add(cbTabelas);

        JLabel lblFiltro = new JLabel("Filtro:");
        lblFiltro.setBounds(260, 70, 50, 25);
        lblFiltro.setForeground(Color.WHITE);
        contentPanel.add(lblFiltro);

        cbFiltros = new JComboBox<>();
        cbFiltros.setBounds(310, 70, 120, 30);
        cbFiltros.setBackground(Color.WHITE);
        cbFiltros.setForeground(Color.BLACK);
        cbFiltros.setUI(new RoundedComboBoxUI());
        cbFiltros.setBorder(new EmptyBorder(5, 10, 5, 5));
        contentPanel.add(cbFiltros);

        txtFiltroValor = new JTextField();
        txtFiltroValor.setBounds(440, 70, 120, 30);
        txtFiltroValor.setVisible(false);
        contentPanel.add(txtFiltroValor);

        RoundButton btnBuscar = new RoundButton("Buscar");
        btnBuscar.setBounds(270, 110, 100, 30);
        btnBuscar.setForeground(Color.WHITE);
        contentPanel.add(btnBuscar);

        RoundedPanel scrollContainer = new RoundedPanel();
        scrollContainer.setBounds(50, 160, 530, 200);
        scrollContainer.setBackgroundColor(Color.WHITE);
        scrollContainer.setLayout(null);
        contentPanel.add(scrollContainer);

        tableModel = new DefaultTableModel();
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setBackground(Color.WHITE);

        JTableHeader header = tabela.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 12));

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 10, 510, 180);
        scroll.setBackground(Color.WHITE);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setBorder(null);
        scrollContainer.add(scroll);

        cbTabelas.addActionListener(e -> atualizarFiltros());

        cbFiltros.addActionListener(e -> {
            Object selectedItem = cbFiltros.getSelectedItem();
            txtFiltroValor.setVisible(selectedItem != null && !selectedItem.toString().equals("Todos"));
        });

        btnBuscar.addActionListener(e -> buscarDados());
        
        MostrarSeta setaVoltar = new MostrarSeta();
        setaVoltar.setBounds(550, 25, 30, 27); 
        setaVoltar.setBackground(new Color(166, 180, 255)); 
        setaVoltar.addActionListener(e -> {
        	new Menu().setVisible(true);
        	dispose(); 
        });
        contentPanel.add(setaVoltar);


        atualizarFiltros();
        setVisible(true);
    }

    private void atualizarFiltros() {
        Object tabelaSelecionada = cbTabelas.getSelectedItem();
        if (tabelaSelecionada == null) return;

        cbFiltros.removeAllItems();
        String[] filtros = filtrosPorTabela.getOrDefault(tabelaSelecionada.toString(), new String[0]);

        for (String filtro : filtros) cbFiltros.addItem(filtro);

        cbFiltros.setSelectedIndex(0);
        txtFiltroValor.setText("");
        txtFiltroValor.setVisible(tabelaSelecionada.toString().equals("ItensPorOS"));
    }

    private void buscarDados() {
        Object tabelaObj = cbTabelas.getSelectedItem();
        Object filtroObj = cbFiltros.getSelectedItem();

        if (tabelaObj == null || filtroObj == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma tabela e um filtro.");
            return;
        }

        String tabelaSelecionada = tabelaObj.toString();
        String campoFiltro = filtroObj.toString();
        String valorFiltro = txtFiltroValor.getText().trim();

        if (!campoFiltro.equals("Todos") && valorFiltro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe um valor para o filtro.");
            return;
        }

        try {
            List<Object[]> dados;
            String[] colunas;

            if (tabelaSelecionada.equals("ItensPorOS")) {
                int codOS = Integer.parseInt(valorFiltro);
                dados = controller.buscarItensPorOS(codOS);
                colunas = new String[]{"Cod_Item", "Descricao", "Tipo", "Preco"};
            } else {
                dados = controller.buscarDados(tabelaSelecionada, campoFiltro, valorFiltro);
                colunas = controller.getColunas(tabelaSelecionada);
            }

            atualizarTabela(colunas, dados);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "O valor informado deve ser numérico.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void atualizarTabela(String[] colunas, List<Object[]> dados) {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(colunas);
        for (Object[] linha : dados) {
            tableModel.addRow(linha);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaConsulta::new);
    }
}
