package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EJBCorsiRemote;
import ejb.EJBDocentiRemote;
import ejb.EJBIscrizioniRemote;
import model.Corsi;
import model.Docenti;
import model.Iscrizioni;
import response.Response;

@WebServlet("TestingEJB")
public class ServletTesting extends HttpServlet {
	
	private static final long serialVersionUID = -114790016222926240L;
	@Resource(mappedName="java:jboss/exported/Corsi/EJBCorsi!ejb.EJBCorsiRemote")
	private EJBCorsiRemote bs;
	@Resource(mappedName="java:jboss/exported/Corsi/EJBDocenti!ejb.EJBDocentiRemote")
	private EJBDocentiRemote bs2;
	@Resource(mappedName="java:jboss/exported/Corsi/EJBIscrizioni!ejb.EJBIscrizioniRemote")
	private EJBIscrizioniRemote bs3;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//		String msg = request.getParameter("m");
		//		String resp = bs.pippo(msg);
		//		Corso corso = new Corso(1,"Java Enterprise");
		//		
		//		Corso attivato =bs.nuovoCorso(corso);
		//		
		//		response.getWriter().append(resp).append(" \n"+bs.pluto()).append("\nE' attivo il corso "+attivato.getNome());
		// int idCorso, String nomeCorso, String dataInizio, String dataFine
		Corsi corso = new Corsi(23,"Nuovo Corso Java EE2","11/12/2020","11/04/2021");
		
		Response r = bs.insert(corso);
		//int idDocente, int idCorso, String nomeDocente
		Docenti d = new Docenti(2,1,"Srand");
		
		Response r2 = bs2.insert(d);
		
		//int idIscrizione, int idDipendente, int idDocente, int idCorso
		Iscrizioni i = new Iscrizioni(1,1,1,1);
		
		Response r3 = bs3.insert(i);
		
		
		response.getWriter()
		.append("\nInserted corso with error: "+r.getDescription())
		.append("\nInserted docente with error: "+r2.getDescription())
		.append("\nInserted iscrizone with error: "+r3.getDescription());
	}


}
