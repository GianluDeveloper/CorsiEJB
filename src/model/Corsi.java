package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="corsi")
public class Corsi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980956984399067851L;
	@Id
	private Integer idCorso;
	private String nomeCorso, dataInizio, dataFine;

	public Corsi(Integer idCorso, String nomeCorso, String dataInizio, String dataFine) {
		this.idCorso = idCorso;
		this.nomeCorso = nomeCorso;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Corsi() {

	}

	public Integer getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
}
