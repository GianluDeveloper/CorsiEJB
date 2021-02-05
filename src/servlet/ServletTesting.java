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
import response.ResponseDao;
import util.RicercaDb;

@WebServlet("TestingEJB")
public class ServletTesting extends HttpServlet {

	private static final long serialVersionUID = -114790016222926240L;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBCorsi!ejb.EJBCorsiRemote")
	private EJBCorsiRemote bs;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBDocenti!ejb.EJBDocentiRemote")
	private EJBDocentiRemote bs2;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBIscrizioni!ejb.EJBIscrizioniRemote")
	private EJBIscrizioniRemote bs3;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// String msg = request.getParameter("m");
		// String resp = bs.pippo(msg);
		// Corso corso = new Corso(1,"Java Enterprise");
		//
		// Corso attivato =bs.nuovoCorso(corso);
		//
		// response.getWriter().append(resp).append(" \n"+bs.pluto()).append("\nE'
		// attivo il corso "+attivato.getNome());
		// int idCorso, String nomeCorso, String dataInizio, String dataFine
		Corsi c = new Corsi(1, "Nuovo Corso Java EE2", "11/12/2020", "11/04/2021");

		Response r = bs.insert(c);
		// int idDocente, int idCorso, String nomeDocente
		Docenti d = new Docenti(1, 1, "Srand");

		Response r2 = bs2.insert(d);

		// int idIscrizione, int idDipendente, int idDocente, int idCorso
		Iscrizioni i = new Iscrizioni(1, 1, 1, 1);

		Response r3 = bs3.insert(i);

		response.getWriter().append("\nInserted corso with error: " + r.getDescription())
				.append("\nInserted docente with error: " + r2.getDescription())
				.append("\nInserted iscrizone with error: " + r3.getDescription());

		c.setNomeCorso("il corso è cambiato");
		d.setNomeDocente("qualcuno nuovo");
		i.setIdDipendente(69);

		r = bs.update(c);
		r2 = bs2.update(d);
		r3 = bs3.update(i);

		response.getWriter().append("\nUpdated corso with error: " + r.getDescription())
				.append("\nUpdated docente with error: " + r2.getDescription())
				.append("\nUpdated iscrizone with error: " + r3.getDescription());
		
		

		c.setIdCorso(2);
		d.setIdDocente(2);
		i.setIdIscrizione(2);

		r3 = bs3.delete(i);
		r2 = bs2.delete(d);
		r = bs.delete(c);

		response.getWriter().append("\nDELETED 2 corso with error: " + r.getDescription())
				.append("\nDELETED 2 docente with error: " + r2.getDescription())
				.append("\nDELETED 2 iscrizone with error: " + r3.getDescription());

		String liste = "\n";

		ResponseDao<Corsi> corsi = bs.findAll(false);
		for (Corsi corso : corsi.getList()) {
			liste += "\n Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizioni = bs3.findAll(false);
		for (Iscrizioni corso : iscrizioni.getList()) {
			liste += "\n Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docenti = bs2.findAll(false);
		for (Docenti corso : docenti.getList()) {
			liste += "\n Docente: " + corso.getNomeDocente() + "\n";
		}

		// find libero

		ResponseDao<Corsi> corsif = bs.find(new RicercaDb("idCorso", "3"));
		for (Corsi corso : corsif.getList()) {
			liste += "\n trovato Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizionif = bs3.find(new RicercaDb("idIscrizione", "3"));
		for (Iscrizioni corso : iscrizionif.getList()) {
			liste += "\n trovato Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docentif = bs2.find(new RicercaDb("idDocente", "3"));
		for (Docenti corso : docentif.getList()) {
			liste += "\n trovato Docente: " + corso.getNomeDocente() + "\n";
		}

		// find by id

		ResponseDao<Corsi> corsid = bs.findById(3);
		for (Corsi corso : corsid.getList()) {
			liste += "\n trovato per id Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizionid = bs3.findById(3);
		for (Iscrizioni corso : iscrizionid.getList()) {
			liste += "\n trovato per id Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docentid = bs2.findById(3);
		for (Docenti corso : docentid.getList()) {
			liste += "\n trovato per id Docente: " + corso.getNomeDocente() + "\n";
		}
		
		
		response.getWriter().append(liste);
	}

}
