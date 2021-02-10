package model;

import java.io.Serializable;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import util.DateHandler;

@Entity(name="corsi")
@Table(name="corsi")

public class CorsiJpa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980956984399067851L;
	@Id
	private Integer idCorso;
	private String nomeCorso;
	java.sql.Date dataInizio, dataFine;

	public CorsiJpa(Integer idCorso, String nomeCorso,String dataInizio, String dataFine) throws ParseException {
		this.idCorso = idCorso;
		this.nomeCorso = nomeCorso;
		this.setDataFine(dataFine);
		this.setDataInizio(dataInizio);
	}

	public CorsiJpa() {

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

	public java.sql.Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) throws ParseException {
		this.dataInizio = DateHandler.toSql(dataInizio);
	}

	public java.sql.Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) throws ParseException {
		this.dataFine = DateHandler.toSql(dataFine);
	}
}
