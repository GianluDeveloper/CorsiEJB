package com;

import javax.ejb.Local;

@Local
public interface TestLocal {
	public String pippo(String msg);
	public String pluto();
}
