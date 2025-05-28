package Model;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
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
	        }
 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}