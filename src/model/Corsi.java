package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the corsi database table.
 * 
 */
@Entity
@Table(name="corsi")
@NamedQuery(name="Corsi.findAll", query="SELECT c FROM Corsi c")
public class Corsi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCorso;

	@Temporal(TemporalType.DATE)
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	private Date dataInizio;

	private String nomeCorso;

	//bi-directional many-to-one association to Docenti
	@OneToMany(mappedBy="corsi")
	private List<Docenti> docentis;

	//bi-directional many-to-one association to Iscrizioni
	@OneToMany(mappedBy="corsi")
	private List<Iscrizioni> iscrizionis;

	public Corsi() {
	}

	public int getIdCorso() {
		return this.idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getNomeCorso() {
		return this.nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public List<Docenti> getDocentis() {
		return this.docentis;
	}

	public void setDocentis(List<Docenti> docentis) {
		this.docentis = docentis;
	}

	public Docenti addDocenti(Docenti docenti) {
		getDocentis().add(docenti);
		docenti.setCorsi(this);

		return docenti;
	}

	public Docenti removeDocenti(Docenti docenti) {
		getDocentis().remove(docenti);
		docenti.setCorsi(null);

		return docenti;
	}

	public List<Iscrizioni> getIscrizionis() {
		return this.iscrizionis;
	}

	public void setIscrizionis(List<Iscrizioni> iscrizionis) {
		this.iscrizionis = iscrizionis;
	}

	public Iscrizioni addIscrizioni(Iscrizioni iscrizioni) {
		getIscrizionis().add(iscrizioni);
		iscrizioni.setCorsi(this);

		return iscrizioni;
	}

	public Iscrizioni removeIscrizioni(Iscrizioni iscrizioni) {
		getIscrizionis().remove(iscrizioni);
		iscrizioni.setCorsi(null);

		return iscrizioni;
	}

	public Corsi(int idCorso, Date dataFine, Date dataInizio, String nomeCorso, List<Docenti> docentis,
			List<Iscrizioni> iscrizionis) {
		super();
		this.idCorso = idCorso;
		this.dataFine = dataFine;
		this.dataInizio = dataInizio;
		this.nomeCorso = nomeCorso;
		this.docentis = docentis;
		this.iscrizionis = iscrizionis;
	}

}