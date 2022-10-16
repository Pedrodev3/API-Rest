package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CidadeTO {
	private int idCidade;
	private int idRegistroGeral;
	private int idEstado;
	private String nmCidade;

	public CidadeTO() {

	}

	public CidadeTO(int idCidade, int idRegistroGeral, int idEstado, String nmCidade) {
		this.idCidade = idCidade;
		this.idRegistroGeral = idRegistroGeral;
		this.idEstado = idEstado;
		this.nmCidade = nmCidade;
	}

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNmCidade() {
		return nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

}
