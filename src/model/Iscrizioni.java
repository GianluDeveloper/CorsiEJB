package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the iscrizioni database table.
 * 
 */
@Entity
@Table(name="iscrizioni")
@NamedQuery(name="Iscrizioni.findAll", query="SELECT i FROM Iscrizioni i")
public class Iscrizioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idIscrizione;

	private int idDipendente;

	//bi-directional many-to-one association to Corsi
	@ManyToOne
	@JoinColumn(name="idCorso")
	private Corsi corsi;

	public Iscrizioni(int idIscrizione, int idDipendente, Corsi corsi, Docenti docenti) {
		super();
		this.idIscrizione = idIscrizione;
		this.idDipendente = idDipendente;
		this.corsi = corsi;
		this.docenti = docenti;
	}

	//bi-directional many-to-one association to Docenti
	@ManyToOne
	@JoinColumn(name="idDocente")
	private Docenti docenti;

	public Iscrizioni() {
	}

	public int getIdIscrizione() {
		return this.idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public int getIdDipendente() {
		return this.idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public Corsi getCorsi() {
		return this.corsi;
	}

	public void setCorsi(Corsi corsi) {
		this.corsi = corsi;
	}

	public Docenti getDocenti() {
		return this.docenti;
	}

	public void setDocenti(Docenti docenti) {
		this.docenti = docenti;
	}

}