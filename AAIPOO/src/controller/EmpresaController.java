package controller;

import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import model.Empresa;
import model.EmpresaDAO;

public class EmpresaController {
	EmpresaDAO dao = new EmpresaDAO();

	public void salvar(String nome, String cnpj, String endereco, String tel) throws SQLException {
		Empresa empresa = new Empresa(nome, cnpj, endereco, tel);
		dao.salvar(empresa);
	}

	public void atualizar(int cod, String nome, String cnpj, String endereco, String tel) throws SQLException {
		Empresa empresa = new Empresa(cod, nome, cnpj, endereco, tel);
		dao.atualizar(empresa);
	}

	public void excluir(int cod, String nome, String cnpj, String endereco, String tel) throws SQLException {
		if (confirmarExclusao()) {
			Empresa empresa = new Empresa(cod, nome, cnpj, endereco, tel);
			dao.excluir(empresa);
		}
	}

	public static boolean confirmarExclusao() {
		JCheckBox checkBox = new JCheckBox("Tenho certeza que desejo excluir");
		Object[] options = { "Excluir", "Cancelar" };

		int resultado = JOptionPane.showOptionDialog(null, checkBox, "Confirmar Exclusão", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[1]);

		return resultado == 0 && checkBox.isSelected();
	}
}