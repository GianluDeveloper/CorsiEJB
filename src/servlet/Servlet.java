package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EJBCorsi;
import model.Corsi;
import response.Response;

@WebServlet("TestingEJB")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = -114790016222926240L;
	@Resource(mappedName="java:jboss/exported/Corsi/EJBCorsi!ejb.EJBCorsiRemote")
	private EJBCorsi bs;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//		String msg = request.getParameter("m");
		//		String resp = bs.pippo(msg);
		//		Corso corso = new Corso(1,"Java Enterprise");
		//		
		//		Corso attivato =bs.nuovoCorso(corso);
		//		
		//		response.getWriter().append(resp).append(" \n"+bs.pluto()).append("\nE' attivo il corso "+attivato.getNome());
		// int idCorso, String nomeCorso, String dataInizio, String dataFine
		Corsi corso = new Corsi(23,"Nuovo Corso Java EE","11/12/2020","11/04/2021");
		
		Response r = bs.insert(corso);
		
		response.getWriter().append("Inserted with error message: "+r.getDescription());
	}


}
