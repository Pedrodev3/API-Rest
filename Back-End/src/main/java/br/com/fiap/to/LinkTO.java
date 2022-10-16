package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LinkTO {
	private int idLink;
	private int idRegistroGeral;
	private String dsLink;
	private String tpLink;
	
	public LinkTO() {
		
	}
	
	public LinkTO(int idLink,int idRegistroGeral,String dsLink,String tpLink){
		this.idLink = idLink;
		this.dsLink = dsLink;
		this.idRegistroGeral = idRegistroGeral;
		this.tpLink = tpLink;
	}

	public int getIdLink() {
		return idLink;
	}

	public void setIdLink(int idLink) {
		this.idLink = idLink;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getDsLink() {
		return dsLink;
	}

	public void setDsLink(String dsLink) {
		this.dsLink = dsLink;
	}

	public String getTpLink() {
		return tpLink;
	}

	public void setTpLink(String tpLink) {
		this.tpLink = tpLink;
	}
}
