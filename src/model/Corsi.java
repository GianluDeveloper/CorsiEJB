package model;

public class Corsi {

	private int idCorso;
	private String nomeCorso, dataInizio, dataFine;

	public Corsi(int idCorso, String nomeCorso, String dataInizio, String dataFine) {
		this.idCorso = idCorso;
		this.nomeCorso = nomeCorso;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Corsi() {

	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
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
