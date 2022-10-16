package br.com.fiap.bo;
import java.util.ArrayList;


import br.com.fiap.dao.ExperienciaDAO;
import br.com.fiap.to.ExperienciaTO;
public class ExperienciaBO {

private ExperienciaDAO ed;
	

	public String cadastrar(ExperienciaTO et) {

		ed = new ExperienciaDAO();

		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}
	

	public void atualizar(ExperienciaTO et) {

		ed = new ExperienciaDAO();

		// Regras de negócio
		ed.update(et);
	}
	

	public void remover(Integer id) {

		ed = new ExperienciaDAO();

		// Regras de negócio
		ed.delete(id);
	}
	

	public ArrayList<ExperienciaTO> listar(Integer id) {

		ArrayList<ExperienciaTO> resultado = null;

		ed = new ExperienciaDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}
	

	public ArrayList<ExperienciaTO> listarTodos() {

		ed = new ExperienciaDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}
