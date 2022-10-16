package br.com.fiap.connection;

import java.sql.*;

public class Conexao {
	
	public Connection abrirConexao() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94051";
			final String PASS = "010903";
			con = DriverManager.getConnection(url,USER,PASS);
			System.out.println("Conexão Aberta!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public void fecharConexao(Connection con) {
        try {
            con.close();
            System.out.println("Conexão fechada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
