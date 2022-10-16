package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.to.CandidatoCursoTO;

public class CandidatoCursoDAO implements IDAO{

	private Connection con = null;
	private CandidatoCursoTO candCurso;
	
	public String insert(Object obj) {

		candCurso = (CandidatoCursoTO) obj;

		String sql = "INSERT INTO T_CHALL_CANDIDATO_CURSO (ID_CAND_CURSO, ID_REGISTRO_GERAL,"
				+ " ID_CURSO, DT_INICIO, DT_TERMINO) "
				+ "VALUES (SQ_T_CHALL_CANDIDATO_CURSO.NEXTVAL, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'))";

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            String dataInicio = candCurso.getDtInicio().format(formatter);
//            String dataTermino = candCurso.getDtTermino().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, candCurso.getIdRegistroGeral());
			ps.setInt(2, candCurso.getIdCurso());
			ps.setString(3, candCurso.getDtInicio());
			ps.setString(4, candCurso.getDtTermino());

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
		candCurso = (CandidatoCursoTO) obj;

		String sql = "UPDATE T_CHALL_CANDIDATO_CURSO SET ID_REGISTRO_GERAL = ?, ID_CURSO = ?, "
				+ "DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), DT_TERMINO = TO_DATE(?, 'DD/MM/YYYY') "
				+ "WHERE ID_CAND_CURSO = ?";

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            String dataInicio = candCurso.getDtInicio().format(formatter);
//            String dataTermino = candCurso.getDtTermino().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, candCurso.getIdRegistroGeral());
			ps.setInt(2, candCurso.getIdCurso());
			ps.setString(3, candCurso.getDtInicio());
			ps.setString(4, candCurso.getDtTermino());
			ps.setInt(5, candCurso.getIdCandCurso());

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
		String sql = "DELETE FROM T_CHALL_CANDIDATO_CURSO WHERE ID_CAND_CURSO = ? ";

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
	
	public ArrayList<CandidatoCursoTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_CANDIDATO_CURSO";
		sql += " WHERE ID_CAND_CURSO= ?";
		ArrayList<CandidatoCursoTO> resul = new ArrayList<CandidatoCursoTO>();

		PreparedStatement ps = null;

		try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String dataInicio = candCurso.getDtInicio().format(formatter);
//            String dataTermino = candCurso.getDtTermino().format(formatter);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CandidatoCursoTO ccto = new CandidatoCursoTO();
				ccto.setIdCandCurso(rs.getInt(1));
				ccto.setIdRegistroGeral(rs.getInt(2));
				ccto.setIdCurso(rs.getInt(3));
				ccto.setDtInicio(rs.getString(4));
				ccto.setDtInicio(rs.getString(5));
				resul.add(ccto);

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
	
	public ArrayList<CandidatoCursoTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_CURSOS";
		ArrayList<CandidatoCursoTO> resul = new ArrayList<CandidatoCursoTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CandidatoCursoTO ccto = new CandidatoCursoTO();
					ccto.setIdCandCurso(rs.getInt(1));
					ccto.setIdRegistroGeral(rs.getInt(2));
					ccto.setIdCurso(rs.getInt(3));
					ccto.setDtInicio(rs.getString(4));
					ccto.setDtInicio(rs.getString(5));
					resul.add(ccto);
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
