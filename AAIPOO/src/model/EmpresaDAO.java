package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EmpresaDAO {
	public void salvar(Empresa empresa) throws SQLException {
		Conexao.conectar();
		int novoCodigo = 1;

		try (Connection conn = Conexao.Conexao;
				Statement stmtMax = conn.createStatement();
				ResultSet result = stmtMax.executeQuery("SELECT MAX(Cod_Emp) AS ultimo_id FROM Empresas")) {

			if (result.next()) {
				novoCodigo = result.getInt("ultimo_id") + 1;
			}

			String sql = "INSERT INTO Empresas (Cod_Emp, Nome, CNPJ, Endereco, Telefone) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, novoCodigo);
				stmt.setString(2, empresa.getNome());
				stmt.setString(3, empresa.getCnpj());
				stmt.setString(4, empresa.getEndereco());
				stmt.setString(5, empresa.getTelefone());
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados salvos com sucesso");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Empresa empresa) throws SQLException {
		String sql = "UPDATE Empresas SET Nome = ?, CNPJ = ?, Endereco = ?, Telefone = ? WHERE Cod_Emp = ?";

		Conexao.conectar();

		try (Connection conn = Conexao.Conexao; PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, empresa.getNome());
			stmt.setString(2, empresa.getCnpj());
			stmt.setString(3, empresa.getEndereco());
			stmt.setString(4, empresa.getTelefone());
			stmt.setInt(5, empresa.getCod());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Empresa empresa) throws SQLException {
	    String excluirItensOS = "DELETE FROM OSxItem WHERE Cod_OS IN (SELECT Cod_OS FROM OS WHERE Cod_Equip IN (SELECT Cod_Equip FROM Equipamento WHERE Cod_Emp = ?))";
	    String excluirOS = "DELETE FROM OS WHERE Cod_Equip IN (SELECT Cod_Equip FROM Equipamento WHERE Cod_Emp = ?)";
	    String excluirEquipamentos = "DELETE FROM Equipamento WHERE Cod_Emp = ?";
	    String excluirEmpresa = "DELETE FROM Empresas WHERE Cod_Emp = ?";

	    Conexao.conectar();

	    try (Connection conn = Conexao.Conexao) {
	        conn.setAutoCommit(false); // Inicia transação

	        try (
	            PreparedStatement stmtItensOS = conn.prepareStatement(excluirItensOS);
	            PreparedStatement stmtOS = conn.prepareStatement(excluirOS);
	            PreparedStatement stmtEquip = conn.prepareStatement(excluirEquipamentos);
	            PreparedStatement stmtEmp = conn.prepareStatement(excluirEmpresa)
	        ) {
	            int codEmp = empresa.getCod();

	            // 1. Excluir itens de OS vinculados às OSs dos equipamentos da empresa
	            stmtItensOS.setInt(1, codEmp);
	            stmtItensOS.executeUpdate();

	            // 2. Excluir as OSs vinculadas aos equipamentos da empresa
	            stmtOS.setInt(1, codEmp);
	            stmtOS.executeUpdate();

	            // 3. Excluir equipamentos da empresa
	            stmtEquip.setInt(1, codEmp);
	            stmtEquip.executeUpdate();

	            // 4. Excluir a empresa
	            stmtEmp.setInt(1, codEmp);
	            stmtEmp.executeUpdate();

	            conn.commit();
	            JOptionPane.showMessageDialog(null, "Empresa, OSs, equipamentos e itens vinculados foram excluídos com sucesso");

	        } catch (SQLException e) {
	            conn.rollback(); // Desfaz alterações em caso de erro
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Erro ao excluir empresa e dados vinculados");
	        } finally {
	            conn.setAutoCommit(true); // Restaura autocommit
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}