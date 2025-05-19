package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpresaDAO {
	public void salvar(Empresa Empresa) throws SQLException {
		String sql = "INSER INTO Usuario (nome,cnpj,endereco,tel)" + "VALUES (?,?,?,?)";
		Conexao.conectar();
		
		try(	Connection conn = Conexao.conexao;
				PreparedStatement stmt = conn.prepareStatement(sql)){
				
				stmt.setString(1, Empresa.getNome());
				stmt.setString(2, Empresa.getCnpj());
				stmt.setString(3, Empresa.getEndereco());
				stmt.setString(4, Empresa.getTel());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
