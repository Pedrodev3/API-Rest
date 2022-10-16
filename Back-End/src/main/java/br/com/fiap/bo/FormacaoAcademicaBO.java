package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.FormacaoAcademicaDAO;
import br.com.fiap.to.FormacaoAcademicaTO;
public class FormacaoAcademicaBO {

	private FormacaoAcademicaDAO ed;

	public String cadastrar(FormacaoAcademicaTO et) {

		ed = new FormacaoAcademicaDAO();

		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}
	

	public void atualizar(FormacaoAcademicaTO et) {

		ed = new FormacaoAcademicaDAO();

		// Regras de negócio
		ed.update(et);
	}
	

	public void remover(Integer id) {

		ed = new FormacaoAcademicaDAO();

		// Regras de negócio
		ed.delete(id);
	}
	

	public ArrayList<FormacaoAcademicaTO> listar(Integer id) {

		ArrayList<FormacaoAcademicaTO> resultado = null;

		ed = new FormacaoAcademicaDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}
	

	public ArrayList<FormacaoAcademicaTO> listarTodos() {

		ed = new FormacaoAcademicaDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}
