package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IdiomaTO {
	private int idIdioma;
	private String tpIdioma;
	
	public IdiomaTO() {
		
	}
	
	public IdiomaTO(int idIdioma, String tpIdioma) {
		super();
		this.idIdioma = idIdioma;
		this.tpIdioma = tpIdioma;
	}

	public int getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getTpIdioma() {
		return tpIdioma;
	}

	public void setTpIdioma(String tpIdioma) {
		this.tpIdioma = tpIdioma;
	}
}