package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docenti database table.
 * 
 */
@Entity
@Table(name="docenti")
@NamedQuery(name="Docenti.findAll", query="SELECT d FROM Docenti d")
public class Docenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDocente;

	private String nomeDocente;

	//bi-directional many-to-one association to Corsi
	@ManyToOne
	@JoinColumn(name="idCorso")
	private Corsi corsi;

	//bi-directional many-to-one association to Iscrizioni
	@OneToMany(mappedBy="docenti")
	private List<Iscrizioni> iscrizionis;

	public Docenti() {
	}

	public int getIdDocente() {
		return this.idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNomeDocente() {
		return this.nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public Corsi getCorsi() {
		return this.corsi;
	}

	public void setCorsi(Corsi corsi) {
		this.corsi = corsi;
	}

	public List<Iscrizioni> getIscrizionis() {
		return this.iscrizionis;
	}

	public void setIscrizionis(List<Iscrizioni> iscrizionis) {
		this.iscrizionis = iscrizionis;
	}

	public Iscrizioni addIscrizioni(Iscrizioni iscrizioni) {
		getIscrizionis().add(iscrizioni);
		iscrizioni.setDocenti(this);

		return iscrizioni;
	}

	public Iscrizioni removeIscrizioni(Iscrizioni iscrizioni) {
		getIscrizionis().remove(iscrizioni);
		iscrizioni.setDocenti(null);

		return iscrizioni;
	}

	public Docenti(int idDocente, String nomeDocente, Corsi corsi, List<Iscrizioni> iscrizionis) {
		super();
		this.idDocente = idDocente;
		this.nomeDocente = nomeDocente;
		this.corsi = corsi;
		this.iscrizionis = iscrizionis;
	}

}