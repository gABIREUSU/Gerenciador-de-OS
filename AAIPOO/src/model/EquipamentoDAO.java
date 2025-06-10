package model;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class EquipamentoDAO {
	public void salvar(Equipamento equipamento) throws SQLException {
	    Conexao.conectar();
	    int novoCodigo = 1;

	    try (Connection conn = Conexao.Conexao;
	         Statement stmtMax = conn.createStatement();
	         ResultSet result = stmtMax.executeQuery("SELECT MAX(Cod_Equip) AS ultimo_id FROM Equipamento")) {

	        if (result.next()) {
	            novoCodigo = result.getInt("ultimo_id") + 1;
	        }

	        String sql = "INSERT INTO Equipamento (Cod_Equip, Cod_Emp, Nome_Equip) VALUES (?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, novoCodigo);
	            stmt.setInt(2, equipamento.getCod_Emp());
	            stmt.setString(3, equipamento.getNome());
	            stmt.executeUpdate();
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void atualizar(Equipamento equipamento) throws SQLException {
	    String sql = "UPDATE Equipamento SET Cod_Emp = ?, Nome_Equip = ? WHERE Cod_Equip = ?";

	    Conexao.conectar();

	    try (Connection conn = Conexao.Conexao;
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, equipamento.getCod_Emp());
	        stmt.setString(2, equipamento.getNome());
	        stmt.setInt(3, equipamento.getCod_Equip());
	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void excluir(Equipamento equipamento) throws SQLException {
	    String sql = "DELETE FROM Equipamento WHERE Cod_Equip = ?";

	    Conexao.conectar();

	    try (Connection conn = Conexao.Conexao;
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, equipamento.getCod_Equip());
	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
}