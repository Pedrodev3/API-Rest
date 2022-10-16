package br.com.fiap.dao;

import java.sql.*;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.CidadeTO;

public class CidadeDAO implements IDAO {

	private Connection con = null;
	private CidadeTO cidade;

	public CidadeDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {

		cidade = (CidadeTO) obj;

		String sql = "INSERT INTO T_CHALL_CIDADE (ID_CIDADE, ID_REGISTRO_GERAL, ID_ESTADO, NM_CIDADE) "
				+ "VALUES (SQ_T_CHALL_CIDADE.NEXTVAL, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cidade.getIdRegistroGeral());
			ps.setInt(2, cidade.getIdEstado());
			ps.setString(3, cidade.getNmCidade());

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

		cidade = (CidadeTO) obj;

		String sql = "UPDATE T_CHALL_CIDADE SET ID_REGISTRO_GERAL = ?, ID_ESTADO = ?,NM_CIDADE = ? WHERE ID_CIDADE = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cidade.getIdRegistroGeral());
			ps.setInt(2, cidade.getIdEstado());
			ps.setString(3, cidade.getNmCidade());
			ps.setInt(4, cidade.getIdCidade());

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
		String sql = "DELETE FROM T_CHALL_CIDADE WHERE ID_CIDADE = ? ";

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

	public ArrayList<CidadeTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_CIDADE";
		sql += " WHERE ID_CIDADE = ?";
		ArrayList<CidadeTO> resul = new ArrayList<CidadeTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CidadeTO et = new CidadeTO();
				et.setIdCidade(rs.getInt(1));
				et.setIdRegistroGeral(rs.getInt(2));
				et.setIdEstado(rs.getInt(3));
				et.setNmCidade(rs.getString(4));
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

	public ArrayList<CidadeTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_CIDADE";
		ArrayList<CidadeTO> listaCidade = new ArrayList<CidadeTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CidadeTO et = new CidadeTO();

					et.setIdCidade(rs.getInt(1));
					et.setIdRegistroGeral(rs.getInt(2));
					et.setIdEstado(rs.getInt(3));
					et.setNmCidade(rs.getString(4));
					listaCidade.add(et);
				}

				con.close();
				return listaCidade;
			} else {
				con.close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}