package br.com.fiap.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TelefoneTO extends UsuarioRegistroGeralTO {

	private int idRegistroGeral, idTelefone, nrDDD, nrTelefone;
	private String stTelefone;

	public TelefoneTO() {
		
	}
	
	public TelefoneTO(int idRegistroGeral, int idTelefone, int nrDDD, int nrTelefone, String stTelefone, String tipoUsuario, 
			String nomeCompleto, String email, String senha, String cpf) {
		super.setIdRegistroGeral(idRegistroGeral);
		super.setTipoUsuario(tipoUsuario);
		super.setNomeCompleto(nomeCompleto);
		super.setEmail(email);
		super.setSenha(senha);
		super.setCpf(cpf);
		this.idRegistroGeral = idRegistroGeral;
		this.idTelefone = idTelefone;
		this.nrDDD = nrDDD;
		this.nrTelefone = nrTelefone;
		this.stTelefone = stTelefone;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getNrDDD() {
		return nrDDD;
	}

	public void setNrDDD(int nrDDD) {
		this.nrDDD = nrDDD;
	}

	public int getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(int nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getStTelefone() {
		return stTelefone;
	}

	public void setStTelefone(String stTelefone) {
		this.stTelefone = stTelefone;
	}

}