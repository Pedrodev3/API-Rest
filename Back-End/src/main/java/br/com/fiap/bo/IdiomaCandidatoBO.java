package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.IdiomaCandidatoDAO;
import br.com.fiap.to.IdiomaCandidatoTO;



public class IdiomaCandidatoBO {
	private IdiomaCandidatoDAO ed;
	
	public String cadastrar(IdiomaCandidatoTO et) {

		ed = new IdiomaCandidatoDAO();
		
		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}
	
	public void atualizar(IdiomaCandidatoTO et) {

		ed = new IdiomaCandidatoDAO();

		// Regras de negócio
		ed.update(et);
	}

	public void remover(Integer id) {

		ed = new IdiomaCandidatoDAO();

		// Regras de negócio
		ed.delete(id);
	}

	public ArrayList<IdiomaCandidatoTO> listar(Integer id) {

		ArrayList<IdiomaCandidatoTO> resultado = null;

		ed = new IdiomaCandidatoDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}

	public ArrayList<IdiomaCandidatoTO> listarTodos() {

		ed = new IdiomaCandidatoDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}
