package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.LinguagemCandidatoDAO;
import br.com.fiap.to.LinguagemCandidatoTO;

public class LinguagemCandidatoBO {

	private LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO();
	
	public String cadastrar(LinguagemCandidatoTO lct) {
		if (lcdao != null) {
			return lcdao.insert(lct);
		}
		return null;
	}
	
	public void atualizar(LinguagemCandidatoTO lct) {
		lcdao.update(lct);
	}
	
	public void remover(Integer id) {
		lcdao.delete(id);
	}
	
	public ArrayList<LinguagemCandidatoTO> listar(Integer id){
		ArrayList<LinguagemCandidatoTO> resultado = null;
		if (id != null) {
			resultado = lcdao.select(id);
		}
		return resultado;
	}
	
	public ArrayList<LinguagemCandidatoTO> listarTodos() {
		return lcdao.selectAll();
	}
}