package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Test
 */
@Stateless
@LocalBean
public class Test implements TestRemote, TestLocal {

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }
    
    public String pippo(String msg) {
    	String ret = "Hai detto a Pippo \""+msg+"\"";
    	
    	return ret;
    }

    public String pluto() {
    	System.out.println("Sono Pluto");
    	return "Sono Pluto!";
    }
}
