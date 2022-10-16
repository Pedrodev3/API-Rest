package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.TelefoneDAO;
import br.com.fiap.to.TelefoneTO;

public class TelefoneBO {

	private TelefoneDAO ttdao;
	
	public String cadastrar(TelefoneTO tto) {
		
		String resultado1 = null;
		String resultado2 = null;
		
		ttdao = new TelefoneDAO();
		
		resultado1 = ttdao.insert(tto);
		
		//Regra de negócio
		if(resultado1 == "Inserido com sucesso.") {
			resultado2 = "Enviado com sucesso.";
		} else {
			resultado2 = "Erro ao inserir";
		}
		
		return resultado2;
	}
	
	public String atualizar(TelefoneTO tto) {
		
		String resultado1 = null;
		String resultado2 = null;
		
		ttdao = new TelefoneDAO();
		
		resultado1 = ttdao.update(tto);
		
		//Regra de negócio
		if(resultado1 == "Atualizado com sucesso.") {
			resultado2 = "Atualizado com sucesso.";
		} else {
			resultado2 = "Erro ao inserir";
		}
		
		return resultado2;
	}
	
	public String remover(Integer id) {
		
		String resultado1 = null;
		String resultado2 = null;
		
		ttdao = new TelefoneDAO();
		
		resultado1 = ttdao.delete(id);
		
		//Regra de negócio
		if(resultado1 == "Removido com sucesso.") {
			resultado2 = "Removido com sucesso.";
		} else {
			resultado2 = "Erro ao inserir";
		}
		
		return resultado2;
	}
	
	public ArrayList<TelefoneTO> listar(Integer id) {

		ttdao = new TelefoneDAO();
		
		//Regra de negócio
		if (id != null) {
			return ttdao.select(id);
		}
		
		return null;
	}
	
	public ArrayList<TelefoneTO> listarTodos() {

		ttdao = new TelefoneDAO();

		return ttdao.selectAll();
	}

	
	
}

