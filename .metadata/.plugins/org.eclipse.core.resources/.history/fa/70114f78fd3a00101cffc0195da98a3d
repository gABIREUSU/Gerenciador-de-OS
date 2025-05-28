package Controller;

import java.sql.SQLException;

import Model.Empresa;
import Model.EmpresaDAO;

public class EmpresaController {
	EmpresaDAO dao = new EmpresaDAO();
	
	public void salvar (String nome, String cnpj, String endereco, String tel) throws SQLException {
		Empresa empresa = new Empresa(nome, cnpj, endereco, tel);
		dao.salvar(empresa);
	}
}