package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.IdiomaCandidatoTO;

public class IdiomaCandidatoDAO implements IDAO{

	private Connection con = null;
	private IdiomaCandidatoTO IdiomaCandidato;

	public IdiomaCandidatoDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {
		IdiomaCandidato = (IdiomaCandidatoTO) obj;
		String sql = "INSERT INTO T_CHALL_IDIOMA_CANDIDATO (ID_IDIOMA_CANDIDATO, ID_REGISTRO_GERAL, ID_IDIOMAS, DT_INICIO,FL_PROFICIENCIA) "
				+ "VALUES (SQ_T_CHALL_IDIOMA_CANDIDATO.NEXTVAL, '?', ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";

		PreparedStatement ps = null;

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String dataInicio = IdiomaCandidato.getDtInicio().format(formatter);

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, IdiomaCandidato.getIdRegistroGeral());
			ps.setInt(2, IdiomaCandidato.getIdIdiomas());
			ps.setString(3, IdiomaCandidato.getDtInicio());
			ps.setString(4, IdiomaCandidato.getFlProficiencia());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String update(Object obj) {
		IdiomaCandidato = (IdiomaCandidatoTO) obj;
		String sql = "UPDATE T_CHALL_IDIOMA_CANDIDATO SET ID_REGISTRO_GERAL = ?, ID_IDIOMAS = ?, DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), FL_PROFICIENCIA = ? "
				+ "WHERE ID_IDIOMA_CANDIDATO = ?";

		PreparedStatement ps = null;
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String dataInicio = IdiomaCandidato.getDtInicio().format(formatter);

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, IdiomaCandidato.getIdRegistroGeral());
			ps.setInt(2, IdiomaCandidato.getIdIdiomas());
			ps.setString(3, IdiomaCandidato.getDtInicio());
			ps.setString(4, IdiomaCandidato.getFlProficiencia());
			ps.setInt(5, IdiomaCandidato.getIdIdiomaCandidato());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String delete(Integer id) {
		String sql = "DELETE FROM T_CHALL_IDIOMA_CANDIDATO WHERE ID_IDIOMA_CANDIDATO = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<IdiomaCandidatoTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_IDIOMA_CANDIDATO";
		sql += " WHERE ID_IDIOMAS= ?";
		ArrayList<IdiomaCandidatoTO> resul = new ArrayList<IdiomaCandidatoTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				IdiomaCandidatoTO et = new IdiomaCandidatoTO();
				et.setIdIdiomaCandidato(rs.getInt(1));
				et.setIdRegistroGeral(rs.getInt(2));
				et.setIdIdiomas(rs.getInt(3));
				et.setDtInicio(rs.getString(4));
				et.setFlProficiencia(rs.getString(5));
				resul.add(et);

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

	public ArrayList<IdiomaCandidatoTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_IDIOMA_CANDIDATO";

		ArrayList<IdiomaCandidatoTO> listaRegistroCandidato = new ArrayList<IdiomaCandidatoTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					IdiomaCandidatoTO rc = new IdiomaCandidatoTO();
					rc.setIdIdiomaCandidato(rs.getInt(1));
					rc.setIdRegistroGeral(rs.getInt(2));
					rc.setIdIdiomas(rs.getInt(3));
					rc.setDtInicio(rs.getString(4));
					rc.setFlProficiencia(rs.getString(5));
					listaRegistroCandidato.add(rc);
				}
				con.close();
				return listaRegistroCandidato;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
