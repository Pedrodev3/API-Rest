package br.com.fiap.dao;

//O tipo "Connection" é trazida a partir desse import
import java.sql.*;
import java.util.ArrayList;
import br.com.fiap.connection.Conexao;
import br.com.fiap.to.IdiomaTO;

public class IdiomaDAO implements IDAO{
	private Connection con = null;
	private IdiomaTO idioma;
	
	public IdiomaDAO() {
		this.con = new Conexao().abrirConexao();
	}
	
	public String insert(Object obj) {

		idioma = (IdiomaTO) obj;

		String sql = "INSERT INTO T_CHALL_IDIOMAS (ID_IDIOMAS, TP_IDIOMAS) "
				+ "VALUES (SQ_T_CHALL_IDIOMAS.NEXTVAL, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idioma.getTpIdioma());

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

		idioma = (IdiomaTO) obj;

		String sql = "UPDATE T_CHALL_IDIOMAS SET TP_IDIOMAS = ? WHERE ID_IDIOMAS = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, idioma.getTpIdioma());
			ps.setInt(2, idioma.getIdIdioma());
			
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
		String sql = "DELETE FROM T_CHALL_IDIOMAS WHERE ID_IDIOMAS = ? ";

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
	
	public ArrayList<IdiomaTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_IDIOMAS";
		sql += " WHERE ID_IDIOMAS= ?";
		ArrayList<IdiomaTO> resul = new ArrayList<IdiomaTO>();
		
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				IdiomaTO et = new IdiomaTO();
				et.setIdIdioma(rs.getInt(1));
				et.setTpIdioma(rs.getString(2));
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
	
	public ArrayList<IdiomaTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_IDIOMAS";
		ArrayList<IdiomaTO> listaIdiomas = new ArrayList<IdiomaTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					IdiomaTO et = new IdiomaTO();

					et.setIdIdioma(rs.getInt(1));
					et.setTpIdioma(rs.getString(2));
					listaIdiomas.add(et);
				}

				con.close();
				return listaIdiomas;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}