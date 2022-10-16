package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IdiomaCandidatoTO {
	private int idIdiomaCandidato;
	private int idRegistroGeral;
	private int idIdiomas;
	private String dtInicio;
	private String flProficiencia;

	public IdiomaCandidatoTO() {
		// TODO Auto-generated constructor stub
	}

	public IdiomaCandidatoTO(int idIdiomaCandidato, int idRegistroGeral, int idIdiomas, String dtInicio,
			String flProficiencia) {
		this.dtInicio = dtInicio;
		this.flProficiencia = flProficiencia;
		this.idIdiomaCandidato = idIdiomaCandidato;
		this.idIdiomas = idIdiomas;
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdIdiomaCandidato() {
		return idIdiomaCandidato;
	}

	public void setIdIdiomaCandidato(int idIdiomaCandidato) {
		this.idIdiomaCandidato = idIdiomaCandidato;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdIdiomas() {
		return idIdiomas;
	}

	public void setIdIdiomas(int idIdiomas) {
		this.idIdiomas = idIdiomas;
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
