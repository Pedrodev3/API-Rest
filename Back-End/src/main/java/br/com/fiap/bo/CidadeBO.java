package br.com.fiap.bo;

import java.util.ArrayList;  

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.to.CidadeTO;
public class CidadeBO {

private CidadeDAO ed;
	

	public String cadastrar(CidadeTO et) {

		ed = new CidadeDAO();

		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}
	

	public void atualizar(CidadeTO et) {

		ed = new CidadeDAO();

		// Regras de negócio
		ed.update(et);
	}
	

	public void remover(Integer id) {

		ed = new CidadeDAO();

		// Regras de negócio
		ed.delete(id);
	}
	

	public ArrayList<CidadeTO> listar(Integer id) {

		ArrayList<CidadeTO> resultado = null;

		ed = new CidadeDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}
	

	public ArrayList<CidadeTO> listarTodos() {

		ed = new CidadeDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}
