package dto;

import java.io.Serializable;

public class IscrizioniDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3269812542241503999L;
	private int idIscrizione, idDipendente, idDocente, idCorso;

	public IscrizioniDto(int idIscrizione, int idDipendente, int idDocente, int idCorso) {
		this.idIscrizione = idIscrizione;
		this.idDipendente = idDipendente;
		this.idDocente = idDocente;
		this.idCorso = idCorso;
	}

	public IscrizioniDto() {

	}

	public int getIdIscrizione() {
		return idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
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

}
