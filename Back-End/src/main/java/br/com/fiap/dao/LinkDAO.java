package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.LinkTO;

public class LinkDAO implements IDAO{

	private Connection con = null;
	private LinkTO link;

	public LinkDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {

		link = (LinkTO) obj;

		String sql = "INSERT INTO T_CHALL_LINK (ID_LINK, ID_REGISTRO_GERAL, DS_LINK, TP_LINK) "
				+ "VALUES (SQ_T_CHALL_LINK.NEXTVAL, ?, ?,?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, link.getIdRegistroGeral());
			ps.setString(2, link.getDsLink());
			ps.setString(3, link.getTpLink());

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

		link = (LinkTO) obj;

		String sql = "UPDATE T_CHALL_LINK SET ID_REGISTRO_GERAL = ?, DS_LINK = ?, TP_LINK = ? WHERE ID_LINK = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, link.getIdRegistroGeral());
			ps.setString(2, link.getDsLink());
			ps.setString(3, link.getTpLink());
			ps.setInt(4, link.getIdLink());

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
		String sql = "DELETE FROM T_CHALL_LINK WHERE ID_LINK = ? ";

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
	
	public ArrayList<LinkTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_LINK";
		sql += " WHERE ID_LINK= ?";
		ArrayList<LinkTO> resul = new ArrayList<LinkTO>();
		
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				LinkTO et = new LinkTO();
				et.setIdLink(rs.getInt(1));
				et.setIdRegistroGeral(rs.getInt(2));
				et.setDsLink(rs.getString(3));
				et.setTpLink(rs.getString(4));
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
	
	public ArrayList<LinkTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_LINK";
		ArrayList<LinkTO> listaEstado = new ArrayList<LinkTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LinkTO et = new LinkTO();

					et.setIdLink(rs.getInt(1));
					et.setIdRegistroGeral(rs.getInt(2));
					et.setDsLink(rs.getString(3));
					et.setTpLink(rs.getString(4));
					listaEstado.add(et);
				}

				con.close();
				return listaEstado;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}