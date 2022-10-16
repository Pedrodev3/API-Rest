package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.TelefoneTO;

public class TelefoneDAO implements IDAO {

	private Connection con = null;
	private TelefoneTO telefone;

	public TelefoneDAO() {
		this.con = new Conexao().abrirConexao();
	}

	public String insert(Object obj) {
		telefone = (TelefoneTO) obj;
		String sql = "INSERT INTO T_CHALL_TELEFONE (ID_TELEFONE, NR_DDD, NR_TELEFONE, ST_TELEFONE) "
				+ "VALUES (SQ_T_CHALL_TELEFONE.NEXTVAL, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, telefone.getNrDDD());
			ps.setInt(2, telefone.getNrTelefone());
			ps.setString(3, telefone.getStTelefone());
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
		telefone = (TelefoneTO) obj;
		String sql = "UPDATE T_CHALL_TELEFONE SET NR_DDD = ?, NR_TELEFONE = ?, ST_TELEFONE = ?"
				+ "WHERE ID_TELEFONE = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, telefone.getNrDDD());
			ps.setInt(2, telefone.getNrTelefone());
			ps.setString(1, telefone.getStTelefone());
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
		String sql = "DELETE FROM T_CHALL_TELEFONE WHERE ID_TELEFONE = ?";

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

	public ArrayList<TelefoneTO> select(Integer id) {
		String sql = "SELECT TEL.T_CHALL_TELEFONE, RG.TP_USUARIO, RG.NM_NOME_COMPLETO," + " RG.DS_EMAIL, RG.NR_CPF,"
				+ " TEL.NR_DDD, TEL.NR_TELEFONE, TEL.ST_TELEFONE"
				+ " FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_TELEFONE TEL"
				+ " ON(RG.ID_REGISTRO_GERAL = TEL.T_CHALL_TELEFONE)" + " WHERE TEL.T_CHALL_TELEFONE = ?";

		ArrayList<TelefoneTO> resul = new ArrayList<TelefoneTO>();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				TelefoneTO tt = new TelefoneTO();
				tt.setIdRegistroGeral((rs.getInt(1)));
				tt.setTipoUsuario(rs.getString(2));
				tt.setNomeCompleto(rs.getString(3));
				tt.setEmail(rs.getString(4));
				tt.setCpf(rs.getString(5));
				tt.setNrDDD(rs.getInt(6));
				tt.setNrTelefone(rs.getInt(7));
				tt.setStTelefone(rs.getString(8));
				resul.add(tt);

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

	public ArrayList<TelefoneTO> selectAll() {
		String sql = "SELECT TEL.T_CHALL_TELEFONE, RG.TP_USUARIO, RG.NM_NOME_COMPLETO," + " RG.DS_EMAIL, RG.NR_CPF,"
				+ " TEL.NR_DDD, TEL.NR_TELEFONE, TEL.ST_TELEFONE"
				+ " FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_TELEFONE TEL"
				+ " ON(RG.ID_REGISTRO_GERAL = TEL.T_CHALL_TELEFONE)" + " WHERE TEL.T_CHALL_TELEFONE = ?";

		ArrayList<TelefoneTO> resul = new ArrayList<TelefoneTO>();
		PreparedStatement ps = null;

		try {

			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					TelefoneTO tt = new TelefoneTO();
					tt.setIdRegistroGeral((rs.getInt(1)));
					tt.setTipoUsuario(rs.getString(2));
					tt.setNomeCompleto(rs.getString(3));
					tt.setEmail(rs.getString(4));
					tt.setCpf(rs.getString(5));
					tt.setNrDDD(rs.getInt(6));
					tt.setNrTelefone(rs.getInt(7));
					tt.setStTelefone(rs.getString(8));
					resul.add(tt);
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