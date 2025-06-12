
package model;

import java.sql.*;
import java.util.*;

public class TelaConsultaDAO {

	public List<Object[]> consultarEmpresasFiltro(String campo, String valor) {
		Conexao.conectar();
		List<Object[]> lista = new ArrayList<>();
		String sql = "SELECT * FROM Empresas";

		if (!campo.equals("Todos")) {
			sql += " WHERE " + campo + " LIKE ?";
		}

		try (Connection conn = Conexao.Conexao; PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (!campo.equals("Todos")) {
				stmt.setString(1, "%" + valor + "%");
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new Object[] { rs.getInt("Cod_Emp"), rs.getString("Nome"), rs.getString("CNPJ"),
						rs.getString("Endereco"), rs.getString("Telefone") });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Object[]> consultarEquipamentosFiltro(String campo, String valor) {
		Conexao.conectar();
		List<Object[]> lista = new ArrayList<>();
		String sql = "SELECT e.Cod_Equip, emp.Nome as NomeEmpresa, e.Nome_Equip FROM Equipamento e JOIN Empresas emp ON e.Cod_Emp = emp.Cod_Emp";

		if (!campo.equals("Todos")) {
			if (campo.equals("NomeEmpresa"))
				campo = "emp.Nome";
			else if (campo.equals("NomeEquip"))
				campo = "e.Nome_Equip";
			sql += " WHERE " + campo + " LIKE ?";
		}

		try (Connection conn = Conexao.Conexao; PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (!campo.equals("Todos")) {
				stmt.setString(1, "%" + valor + "%");
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new Object[] { rs.getInt("Cod_Equip"), rs.getString("NomeEmpresa"),
						rs.getString("Nome_Equip") });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Object[]> consultarOSFiltro(String campo, String valor) {
		Conexao.conectar();
		List<Object[]> lista = new ArrayList<>();
		String sql = "SELECT o.Cod_OS, eq.Nome_Equip, emp.Nome as NomeEmpresa, o.Data, o.Preco " + "FROM OS o "
				+ "JOIN Equipamento eq ON o.Cod_Equip = eq.Cod_Equip "
				+ "JOIN Empresas emp ON eq.Cod_Emp = emp.Cod_Emp";

		if (!campo.equals("Todos")) {
			if (campo.equals("NomeEquip"))
				campo = "eq.Nome_Equip";
			else if (campo.equals("NomeEmpresa"))
				campo = "emp.Nome";
			else if (campo.equals("Data"))
				campo = "o.Data";
			sql += " WHERE " + campo + " LIKE ?";
		}

		try (Connection conn = Conexao.Conexao; PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (!campo.equals("Todos")) {
				stmt.setString(1, "%" + valor + "%");
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new Object[] { rs.getInt("Cod_OS"), rs.getString("Nome_Equip"), rs.getString("NomeEmpresa"),
						rs.getString("Data"), rs.getBigDecimal("Preco") });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
}
