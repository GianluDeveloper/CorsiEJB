package ejb;

import java.sql.SQLException;
import java.text.ParseException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import dao.IscrizioniDao;
import exceptions.NotHandledTypeException;
import model.Iscrizioni;
import response.Response;
import response.ResponseDao;
import util.EJB;
import util.RicercaDb;

/**
 * Session Bean implementation class EJBIscrizioni
 */
@Stateless
@LocalBean
public class EJBIscrizioni implements EJBIscrizioniRemote, EJBIscrizioniLocal, EJB<Iscrizioni> {

	IscrizioniDao dao = new IscrizioniDao();

	@Override
	public Response insert(Iscrizioni o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.insert(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.getStackTrace().toString());
		}
		return r;
	}

	@Override
	public Response update(Iscrizioni o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.update(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.getStackTrace().toString());
		}
		return r;
	}

	@Override
	public Response delete(Iscrizioni o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.delete(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.getStackTrace().toString());
		}
		return r;
	}

	@Override
	public ResponseDao<Iscrizioni> find(RicercaDb o) {
		// TODO Auto-generated method stub
		ResponseDao<Iscrizioni> r = new ResponseDao<>();
		try {
			r.setList(dao.find(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.getStackTrace().toString());
		}
		return r;
	}

	@Override
	public ResponseDao<Iscrizioni> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		ResponseDao<Iscrizioni> r = new ResponseDao<>();
		try {
			r.setList(dao.findAll(reverse));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.getStackTrace().toString());
		}
		return r;
	}

}
