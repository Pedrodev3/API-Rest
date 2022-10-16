package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.LinguagemCandidatoTO;

public class LinguagemCandidatoDAO implements IDAO{

	private Connection con = null;
	private LinguagemCandidatoTO linCand;
	
	public String insert(Object obj) {

		linCand = (LinguagemCandidatoTO) obj;

		String sql = "INSERT INTO T_CHALL_LINGUAGEM_CANDIDATO (ID_LINGUAGEM_CANDIDATO, ID_REGISTRO_GERAL,"
				+ " ID_LINGUAGEM_PROG, DT_INICIO, FL_PROFICIENCIA)"
				+ " VALUES (SQ_T_CHALL_CANDIDATO_CURSO.NEXTVAL, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?";

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            String dataInicio = linCand.getDtInicio().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, linCand.getIdRegistroGeral());
			ps.setInt(2, linCand.getIdLinguagemProg());
			ps.setString(3, linCand.getDtInicio());
			ps.setString(4, linCand.getFlProficiencia());

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
		linCand = (LinguagemCandidatoTO) obj;

		String sql = "UPDATE T_CHALL_LINGUAGEM_CANDIDATO SET ID_REGISTRO_GERAL = ?, ID_LINGUAGEM_PROG = ?, "
				+ "DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), FL_PROFICIENCIA = ? "
				+ "WHERE ID_LINGUAGEM_CANDIDATO = ?";

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            String dataInicio = linCand.getDtInicio().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, linCand.getIdRegistroGeral());
			ps.setInt(2, linCand.getIdLinguagemProg());
			ps.setString(3, linCand.getDtInicio());
			ps.setString(4, linCand.getFlProficiencia());
			ps.setInt(5, linCand.getIdLinguagemCandidato());


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
		String sql = "DELETE FROM T_CHALL_LINGUAGEM_CANDIDATO WHERE ID_LINGUAGEM_CANDIDATO = ? ";

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
	
	public ArrayList<LinguagemCandidatoTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_CANDIDATO";
		sql += " WHERE ID_LINGUAGEM_CANDIDATO= ?";
		ArrayList<LinguagemCandidatoTO> resul = new ArrayList<LinguagemCandidatoTO>();

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String dataInicio = linCand.getDtInicio().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				LinguagemCandidatoTO lcto = new LinguagemCandidatoTO();
				lcto.setIdLinguagemCandidato(rs.getInt(1));
				lcto.setIdRegistroGeral(rs.getInt(2));
				lcto.setIdLinguagemProg(rs.getInt(3));
				lcto.setDtInicio(rs.getString(4));
				ps.setString(4, linCand.getFlProficiencia());
				resul.add(lcto);

				con.close();
				return resul;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<LinguagemCandidatoTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_CANDIDATO";
		ArrayList<LinguagemCandidatoTO> resul = new ArrayList<LinguagemCandidatoTO>();

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String dataInicio = linCand.getDtInicio().format(formatter);
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LinguagemCandidatoTO lcto = new LinguagemCandidatoTO();
					lcto.setIdLinguagemCandidato(rs.getInt(1));
					lcto.setIdRegistroGeral(rs.getInt(2));
					lcto.setIdLinguagemProg(rs.getInt(3));
					lcto.setDtInicio(rs.getString(4));
					ps.setString(4, linCand.getFlProficiencia());
					resul.add(lcto);
				}

				con.close();
				return resul;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}