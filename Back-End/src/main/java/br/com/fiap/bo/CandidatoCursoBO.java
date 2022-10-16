package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.CandidatoCursoDAO;
import br.com.fiap.to.CandidatoCursoTO;

public class CandidatoCursoBO {

	private CandidatoCursoDAO ccd = new CandidatoCursoDAO();
	
	public String cadastrar(CandidatoCursoTO cct) {
		if (ccd != null) {
			return ccd.insert(cct);
		}
		return null;
	}
	
	public void atualizar(CandidatoCursoTO cct) {
		ccd.update(cct);
	}
	
	public void remover(Integer id) {
		ccd.delete(id);
	}
	
	public ArrayList<CandidatoCursoTO> listar(Integer id){
		ArrayList<CandidatoCursoTO> resultado = null;
		if (id != null) {
			resultado = ccd.select(id);
		}
		return resultado;
	}
	
	public ArrayList<CandidatoCursoTO> listarTodos() {
		return ccd.selectAll();
	}
}