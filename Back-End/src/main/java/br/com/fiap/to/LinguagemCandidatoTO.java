package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LinguagemCandidatoTO {

	private int idLinguagemCandidato, idLinguagemProg, idRegistroGeral;
	private String dtInicio;
	private String flProficiencia;

	public LinguagemCandidatoTO() {

	}

	public LinguagemCandidatoTO(int idLinguagemCandidato, int idLinguagemProg, int idRegistroGeral, String dtInicio,
			String flProficiencia) {
		super();
		this.idLinguagemCandidato = idLinguagemCandidato;
		this.idLinguagemProg = idLinguagemProg;
		this.idRegistroGeral = idRegistroGeral;
		this.dtInicio = dtInicio;
		this.flProficiencia = flProficiencia;
	}

	public int getIdLinguagemCandidato() {
		return idLinguagemCandidato;
	}

	public void setIdLinguagemCandidato(int idLinguagemCandidato) {
		this.idLinguagemCandidato = idLinguagemCandidato;
	}

	public int getIdLinguagemProg() {
		return idLinguagemProg;
	}

	public void setIdLinguagemProg(int idLinguagemProg) {
		this.idLinguagemProg = idLinguagemProg;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getFlProficiencia() {
		return flProficiencia;
	}

	public void setFlProficiencia(String flProficiencia) {
		this.flProficiencia = flProficiencia;
	}

}