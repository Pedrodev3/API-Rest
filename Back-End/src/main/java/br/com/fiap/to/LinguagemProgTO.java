package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LinguagemProgTO {

	private int idLinguagemProg;
	private String tpLinguagem;
	
	public LinguagemProgTO() {
		
	}

	public LinguagemProgTO(int idLinguagemProg, String tpLinguagem) {
		super();
		this.idLinguagemProg = idLinguagemProg;
		this.tpLinguagem = tpLinguagem;
	}

	public int getIdLinguagemProg() {
		return idLinguagemProg;
	}

	public void setIdLinguagemProg(int idLinguagemProg) {
		this.idLinguagemProg = idLinguagemProg;
	}

	public String getTpLinguagem() {
		return tpLinguagem;
	}

	public void setTpLinguagem(String tpLinguagem) {
		this.tpLinguagem = tpLinguagem;
	}
	
}