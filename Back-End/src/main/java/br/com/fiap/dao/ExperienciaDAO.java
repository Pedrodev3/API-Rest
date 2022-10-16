package br.com.fiap.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.ExperienciaTO;

public class ExperienciaDAO implements IDAO {

	private Connection con = null;
	private ExperienciaTO experiencia;

	public ExperienciaDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {

		experiencia = (ExperienciaTO) obj;

		String sql = "INSERT INTO T_CHALL_EXPERIENCIA (ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA,DT_INICIO,DT_TERMINO,ST_STATUS,DS_SENIORIDADE) "
				+ "VALUES (SQ_T_CHALL_EXPERIENCIA.NEXTVAL, ?, ?,TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'), ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, experiencia.getIdRegistroGeral());
			ps.setString(2, experiencia.getTpExperiencia());
			ps.setString(3, experiencia.getDtInicio());
			ps.setString(4, experiencia.getDtTermino());
			ps.setString(5, experiencia.getStStatus());
			ps.setString(6, experiencia.getDsSenioridade());

			if (ps.executeUpdate() > 0) {
				con.close();
				return "Inserido com sucesso.\n" + "Conexão Fechada!";
			} else {
				con.close();
				return "Erro ao inserir.\n" + "Conexão Fechada!";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String update(Object obj) {

		experiencia = (ExperienciaTO) obj;

		String sql = "UPDATE T_CHALL_EXPERIENCIA SET ID_REGISTRO_GERAL = ?, TP_EXPERIENCIA = ?,DT_INICIO = ?,DT_TERMINO = ?,ST_STATUS = ?,DS_SENIORIDADE = ? WHERE ID_EXPERIENCIA = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, experiencia.getIdRegistroGeral());
			ps.setString(2, experiencia.getTpExperiencia());
			ps.setString(3, experiencia.getDtInicio());
			ps.setString(4, experiencia.getDtTermino());
			ps.setString(5, experiencia.getStStatus());
			ps.setString(6, experiencia.getDsSenioridade());
			ps.setInt(7, experiencia.getIdExperiencia());

			if (ps.executeUpdate() > 0) {
				con.close();
				return "Inserido com sucesso.\n" + "Conexão Fechada!";
			} else {
				con.close();
				return "Erro ao inserir.\n" + "Conexão Fechada!";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String delete(Integer id) {
		String sql = "DELETE FROM T_CHALL_EXPERIENCIA WHERE ID_EXPERIENCIA = ? ";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				con.close();
				return "Excluido com sucesso!\n" + "Conexão Fechada!";
			} else {
				con.close();
				return "Erro ao excluir!\n" + "Conexão Fechada!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	

	public ArrayList<ExperienciaTO> select(Integer id) {
		String sql = "SELECT ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA,TO_CHAR(DT_INICIO, 'YYYY/MM/DD'),"
				+ "TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'),ST_STATUS, DS_SENIORIDADE FROM T_CHALL_EXPERIENCIA " 
				+ "WHERE ID_EXPERIENCIA = ?";
		ArrayList<ExperienciaTO> resul = new ArrayList<ExperienciaTO>();
		
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ExperienciaTO et = new ExperienciaTO();
				et.setIdExperiencia(rs.getInt(1));
				et.setIdRegistroGeral(rs.getInt(2));
				et.setTpExperiencia(rs.getString(3));
				et.setDtInicio(rs.getString(4));
				et.setDtTermino(rs.getString(5));
				et.setStStatus(rs.getString(6));
				et.setDsSenioridade(rs.getString(7));
				resul.add(et);

				con.close();
				return resul;
			} 
			else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	

	public ArrayList<ExperienciaTO> selectAll() {

		String sql = "SELECT ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA,TO_CHAR(DT_INICIO, 'YYYY/MM/DD'),"
				+ "TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'), ST_STATUS, DS_SENIORIDADE FROM T_CHALL_EXPERIENCIA";
		ArrayList<ExperienciaTO> listaExperiencia = new ArrayList<ExperienciaTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					ExperienciaTO et = new ExperienciaTO();

					et.setIdExperiencia(rs.getInt(1));
					et.setIdRegistroGeral(rs.getInt(2));
					et.setTpExperiencia(rs.getString(3));
					et.setDtInicio(rs.getString(4));
					et.setDtTermino(rs.getString(5));
					et.setStStatus(rs.getString(6));
					et.setDsSenioridade(rs.getString(7));
					listaExperiencia.add(et);
				}

				con.close();
				return listaExperiencia;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}