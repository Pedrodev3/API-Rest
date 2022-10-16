package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.CursoTO;

public class CursoDAO implements IDAO {

	private Connection con = null;
	private CursoTO curso;

	public CursoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {

		curso = (CursoTO) obj;

		String sql = "INSERT INTO T_CHALL_CURSOS (ID_CURSO, NR_CURSO, SG_CURSO, NM_CURSO) "
				+ "VALUES (SQ_T_CHALL_CURSOS.NEXTVAL, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, curso.getNrCurso());
			ps.setString(2, curso.getSgCurso());
			ps.setString(3, curso.getNmCurso());

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
		curso = (CursoTO) obj;

		String sql = "UPDATE T_CHALL_CURSOS SET NR_CURSO = ?, SG_CURSO = ?, "
				+ "NM_CURSO = ? WHERE ID_CURSO = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, curso.getNrCurso());
			ps.setString(2, curso.getSgCurso());
			ps.setString(3, curso.getNmCurso());
			ps.setInt(4, curso.getIdCurso());

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
		String sql = "DELETE FROM T_CHALL_CURSOS WHERE ID_CURSO = ? ";

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

	public ArrayList<CursoTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_CURSOS";
		sql += " WHERE ID_CURSO= ?";
		ArrayList<CursoTO> resul = new ArrayList<CursoTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CursoTO cto = new CursoTO();
				cto.setIdCurso(rs.getInt(1));
				cto.setNrCurso(rs.getInt(2));
				cto.setSgCurso(rs.getString(3));
				cto.setNmCurso(rs.getString(4));
				resul.add(cto);

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

	public ArrayList<CursoTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_CURSOS";
		ArrayList<CursoTO> resul = new ArrayList<CursoTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CursoTO cto = new CursoTO();
					cto.setIdCurso(rs.getInt(1));
					cto.setNrCurso(rs.getInt(2));
					cto.setSgCurso(rs.getString(3));
					cto.setNmCurso(rs.getString(4));
					resul.add(cto);
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