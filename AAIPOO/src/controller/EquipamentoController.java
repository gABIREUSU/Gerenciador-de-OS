package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import model.Equipamento;
import model.EquipamentoDAO;

public class EquipamentoController {
	EquipamentoDAO dao = new EquipamentoDAO();
	
	public void salvar(String nome, int codEmp) throws SQLException {
	    Equipamento equipamento = new Equipamento(codEmp, nome);
	    dao.salvar(equipamento);
	}

	public void atualizar(int codEquip, String nome, int codEmp) throws SQLException {
	    Equipamento equipamento = new Equipamento(codEquip, codEmp, nome);
	    dao.atualizar(equipamento);
	}

	public void excluir(int codEquip, String nome, int codEmp) throws SQLException {
	    if (confirmarExclusao()) {
	        Equipamento equipamento = new Equipamento(codEquip, codEmp, nome);
	        dao.excluir(equipamento);
	    }
	}

	public static boolean confirmarExclusao() {
	    JCheckBox checkBox = new JCheckBox("Tenho certeza que desejo excluir");
	    Object[] options = {"Excluir", "Cancelar"};

	    int resultado = JOptionPane.showOptionDialog(
	        null,
	        checkBox,
	        "Confirmar Exclusão",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );

	    return resultado == 0 && checkBox.isSelected();
	}
	
	public List<String> carregarEmpresas() {
		try {
			return dao.carregarEmpresas();
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar empresas: " + e.getMessage());
		}
	}
	public int getCodEmp(String Empresa) {
		return dao.getCodEmp(Empresa);
	}

}