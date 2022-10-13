package br.com.fiap.dao;

public interface IDAO {
	public String insert(Object obj);

	public String update(Object obj);

	public String delete(Integer id);

	// Método "select" e "selectAll" estão sendo feitos na ClasseDAO
}
