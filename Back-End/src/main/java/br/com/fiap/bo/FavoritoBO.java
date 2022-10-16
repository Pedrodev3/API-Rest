package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.FavoritoDAO;
import br.com.fiap.to.FavoritoTO;

public class FavoritoBO {

	private FavoritoDAO fd = new FavoritoDAO();
	
	public String cadastrar(FavoritoTO ft) {
		if (fd != null) {
			return fd.insert(ft);
		}
		return null;
	}
	
	public void atualizar(FavoritoTO ft) {
		fd.update(ft);
	}
	
	public void remover(Integer id) {
		fd.delete(id);
	}
	
	public ArrayList<FavoritoTO> listar(Integer id){
		ArrayList<FavoritoTO> resultado = null;
		if (id != null) {
			resultado = fd.select(id);
		}
		return resultado;
	}
	
	public ArrayList<FavoritoTO> listarTodos() {
		return fd.selectAll();
	}
}