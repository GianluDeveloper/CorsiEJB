package com;

import javax.ejb.Remote;

@Remote
public interface TestRemote {
	public String pippo(String msg);
	public String pluto();
	public Corso nuovoCorso(Corso c);
}
