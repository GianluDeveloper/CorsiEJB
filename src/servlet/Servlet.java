package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Corso;
import com.TestRemote;

@WebServlet("Prova")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = -114790016222926240L;
	@Resource(mappedName="java:jboss/exported/Corsi/Test!com.TestRemote")
	private TestRemote bs;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msg = request.getParameter("m");
		String resp = bs.pippo(msg);
		Corso corso = new Corso(1,"Java Enterprise");
		
		Corso attivato =bs.nuovoCorso(corso);
		
		response.getWriter().append(resp).append(" \n"+bs.pluto()).append("\nE' attivo il corso "+attivato.getNome());
	}


}
