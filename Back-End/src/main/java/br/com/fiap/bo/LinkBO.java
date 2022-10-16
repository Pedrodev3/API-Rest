package br.com.fiap.bo;

import java.util.ArrayList;


import br.com.fiap.dao.LinkDAO;
import br.com.fiap.to.LinkTO;

public class LinkBO {
	private LinkDAO ed;

	public String cadastrar(LinkTO et) {

		ed = new LinkDAO();

		// Regras de negócio
		if (et != null) {
			return ed.insert(et);
		}

		return null;
	}

	public void atualizar(LinkTO et) {

		ed = new LinkDAO();

		// Regras de negócio
		ed.update(et);
	}

	public void remover(Integer id) {

		ed = new LinkDAO();

		// Regras de negócio
		ed.delete(id);
	}

	public ArrayList<LinkTO> listar(Integer id) {

		ArrayList<LinkTO> resultado = null;

		ed = new LinkDAO();

		// Regras de negócio
		if (id != null) {
			resultado = ed.select(id);
		}

		return resultado;
	}

	public ArrayList<LinkTO> listarTodos() {

		ed = new LinkDAO();

		// Regras de negócio
		return ed.selectAll();
	}
}