package br.com.fiap.bo;

import java.util.ArrayList; 
import br.com.fiap.dao.IdiomaDAO;
import br.com.fiap.to.IdiomaTO;

public class IdiomaBO {
	private IdiomaDAO ed;

	public String cadastrar(IdiomaTO et) {

		ed = new IdiomaDAO();

		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}

	public void atualizar(IdiomaTO et) {

		ed = new IdiomaDAO();

		// Regras de negócio
		ed.update(et);
	}

	public void remover(Integer id) {

		ed = new IdiomaDAO();

		// Regras de negócio
		ed.delete(id);
	}

	public ArrayList<IdiomaTO> listar(Integer id) {

		ArrayList<IdiomaTO> resultado = null;

		ed = new IdiomaDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}

	public ArrayList<IdiomaTO> listarTodos() {

		ed = new IdiomaDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}
