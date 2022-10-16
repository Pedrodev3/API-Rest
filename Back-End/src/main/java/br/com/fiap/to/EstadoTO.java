package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstadoTO {
	
	private int idEstado;
	private String sgEstado;
	private String nmEstado;
	
	public EstadoTO() {
		// TODO Auto-generated constructor stub
	}

	public EstadoTO(int idEstado, String sgEstado, String nmEstado) {
		super();
		this.idEstado = idEstado;
		this.sgEstado = sgEstado;
		this.nmEstado = nmEstado;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getSgEstado() {
		return sgEstado;
	}

	public void setSgEstado(String sgEstado) {
		this.sgEstado = sgEstado;
	}

	public String getNmEstado() {
		return nmEstado;
	}

	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}
	
}
