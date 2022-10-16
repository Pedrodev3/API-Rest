package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.LinguagemProgDAO;
import br.com.fiap.to.LinguagemProgTO;

public class LinguagemProgBO {

	private LinguagemProgDAO lpd = new LinguagemProgDAO();
	
	public String cadastrar(LinguagemProgTO lpt) {
		
		if (lpd != null) {
			return lpd.insert(lpt);
		}
		return null;
	}
	
	public void atualizar(LinguagemProgTO lpt) {
		lpd.update(lpt);
	}
	
	public void remover(Integer id) {
		lpd.delete(id);
	}
	
	public ArrayList<LinguagemProgTO> listar(Integer id){
		ArrayList<LinguagemProgTO> resultado = null;
		if (id != null) {
			resultado = lpd.select(id);
		}
		return resultado;
	}
	
	public ArrayList<LinguagemProgTO> listarTodos() {
		return lpd.selectAll();
	}
}