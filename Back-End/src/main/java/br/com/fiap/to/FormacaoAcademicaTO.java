package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormacaoAcademicaTO {
	private int idFormacaoAcademica;
	private int idRegistroGeral;
	private String nmInstituicao;
	private String dsAtividadeExtra;
	private String dtInicio;
	private String dtTermino;
	private String nmCurso;
	private String dsStatusCurso;
	private String dsEscolaridade;
	private String dsSemestre;
	private String flCurso;

	public FormacaoAcademicaTO() {
		// TODO Auto-generated constructor stub
	}

	public FormacaoAcademicaTO(int idFormacaoAcademica, int idRegistroGeral, String nmInstituicao,
			String dsAtividadeExtra, String dtInicio, String dtTermino, String nmCurso, String dsStatusCurso,
			String dsEscolaridade, String dsSemestre,String flCurso) {
		this.dsAtividadeExtra = dsAtividadeExtra;
		this.dsEscolaridade = dsEscolaridade;
		this.dsSemestre = dsSemestre;
		this.dsStatusCurso = dsStatusCurso;
		this.dtInicio = dtInicio;
		this.dtTermino = dtTermino;
		this.flCurso = flCurso;
		this.idFormacaoAcademica = idFormacaoAcademica;
		this.idRegistroGeral = idRegistroGeral;
		this.nmCurso = nmCurso;
		this.nmInstituicao = nmInstituicao;
	}

	public int getIdFormacaoAcademica() {
		return idFormacaoAcademica;
	}

	public void setIdFormacaoAcademica(int idFormacaoAcademica) {
		this.idFormacaoAcademica = idFormacaoAcademica;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getNmInstituicao() {
		return nmInstituicao;
	}

	public void setNmInstituicao(String nmInstituicao) {
		this.nmInstituicao = nmInstituicao;
	}

	public String getDsAtividadeExtra() {
		return dsAtividadeExtra;
	}

	public void setDsAtividadeExtra(String dsAtividadeExtra) {
		this.dsAtividadeExtra = dsAtividadeExtra;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(String dtTermino) {
		this.dtTermino = dtTermino;
	}

	public String getNmCurso() {
		return nmCurso;
	}

	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}

	public String getDsStatusCurso() {
		return dsStatusCurso;
	}

	public void setDsStatusCurso(String dsStatusCurso) {
		this.dsStatusCurso = dsStatusCurso;
	}

	public String getDsEscolaridade() {
		return dsEscolaridade;
	}

	public void setDsEscolaridade(String dsEscolaridade) {
		this.dsEscolaridade = dsEscolaridade;
	}

	public String getDsSemestre() {
		return dsSemestre;
	}

	public void setDsSemestre(String dsSemestre) {
		this.dsSemestre = dsSemestre;
	}

	public String getFlCurso() {
		return flCurso;
	}

	public void setFlCurso(String flCurso) {
		this.flCurso = flCurso;
	}
	
}
