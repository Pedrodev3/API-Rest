package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.connection.Conexao;
import br.com.fiap.to.LinguagemProgTO;

public class LinguagemProgDAO implements IDAO{

	private Connection con = null;
	private LinguagemProgTO linProg;
	
	public LinguagemProgDAO() {
		this.con = new Conexao().abrirConexao();
	}
	
	public String insert(Object obj) {

		linProg = (LinguagemProgTO) obj;

		String sql = "INSERT INTO T_CHALL_LINGUAGEM_PROG (ID_LINGUAGEM_PROG, TP_LINGUAGEM) "
				+ "VALUES (SQ_T_CHALL_LINGUAGEM_PROG.NEXTVAL, ?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, linProg.getTpLinguagem());

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
		linProg = (LinguagemProgTO) obj;

		String sql = "UPDATE T_CHALL_LINGUAGEM_PROG SET TP_LINGUAGEM = ?"
				+ " WHERE ID_LINGUAGEM_PROG = ?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(2, linProg.getIdLinguagemProg());
			ps.setString(1, linProg.getTpLinguagem());

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
		String sql = "DELETE FROM T_CHALL_LINGUAGEM_PROG WHERE ID_LINGUAGEM_PROG = ? ";

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
	
	public ArrayList<LinguagemProgTO> select(Integer id) {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_PROG";
		sql += " WHERE ID_LINGUAGEM_PROG= ?";
		ArrayList<LinguagemProgTO> resul = new ArrayList<LinguagemProgTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				LinguagemProgTO lpto = new LinguagemProgTO();
				lpto.setIdLinguagemProg(rs.getInt(1));
				lpto.setTpLinguagem(rs.getString(2));
				resul.add(lpto);

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
	
	public ArrayList<LinguagemProgTO> selectAll() {

		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_PROG";
		ArrayList<LinguagemProgTO> resul = new ArrayList<LinguagemProgTO>();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LinguagemProgTO lpto = new LinguagemProgTO();
					lpto.setIdLinguagemProg(rs.getInt(1));
					lpto.setTpLinguagem(rs.getString(2));
					resul.add(lpto);
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