package dto;

import java.io.Serializable;

public class DocentiDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2264431570213490775L;
	private int idDocente, idCorso;
	private String nomeDocente;

	public DocentiDto(int idDocente, int idCorso, String nomeDocente) {
		this.idDocente = idDocente;
		this.idCorso = idCorso;
		this.nomeDocente = nomeDocente;
	}

	public DocentiDto() {

	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

}
