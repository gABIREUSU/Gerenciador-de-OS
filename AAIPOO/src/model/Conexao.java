package Model;

import java.sql.*;
import javax.swing.*;

public class Conexao {
	//private static String Url = "jdbc:sqlserver://10.109.8.9:1433;databaseName=DA123_Exerc_G07;user=DA123_Exerc_G07;password=;encrypt=false;trustServerCertificate=true;loginTimeout=30;";
	private static String Url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DA123_Exerc_G07;user=DA123_Exerc_G07;password=;encrypt=false;trustServerCertificate=true;";
	public static Connection Conexao;

	public static void conectar() { // Efetua a conexão
		try {
			// Conexãocom o banco
			Conexao = DriverManager.getConnection(Url);
			JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage());
		}

	}

	public static void desconectar() { // Fecha a conexão
		try {
			Conexao.close(); // Fecharconexão
			JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage());
		}
	}

}
