package com;

import java.io.Serializable;

public class Corso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3619342311926762149L;
	private int id;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Corso(int id,String nome) {
		super();
		this.nome = nome;
		this.id = id;
	}
	public Corso() {
		
	}
}
