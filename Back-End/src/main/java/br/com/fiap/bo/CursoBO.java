package br.com.fiap.bo;

import java.util.ArrayList;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.to.CursoTO;

public class CursoBO {

	private CursoDAO cd = new CursoDAO();
	
	public String cadastrar(CursoTO ct) {
		
		if (cd != null) {
			return cd.insert(ct);
		}
		return null;
	}
	
	public void atualizar(CursoTO ct) {
		cd.update(ct);
	}
	
	public void remover(Integer id) {
		cd.delete(id);
	}
	
	public ArrayList<CursoTO> listar(Integer id){
		ArrayList<CursoTO> resultado = null;
		if (id != null) {
			resultado = cd.select(id);
		}
		return resultado;
	}
	
	public ArrayList<CursoTO> listarTodos() {
		return cd.selectAll();
	}
}