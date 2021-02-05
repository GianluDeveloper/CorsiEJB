package ejb;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import dao.CorsiDao;
import exceptions.NotHandledTypeException;
import model.Corsi;
import response.Response;
import response.ResponseDao;
import util.EJB;
import util.RicercaDb;

/**
 * Session Bean implementation class EJBCorsi
 */
@Stateless
@LocalBean
public class EJBCorsi implements EJBCorsiRemote, EJBCorsiLocal, EJB<Corsi> {


	CorsiDao dao = new CorsiDao();


	public Response insert(Corsi o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.insert(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	public Response update(Corsi o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.update(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	
	public Response delete(Corsi o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.delete(o);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	public ResponseDao<Corsi> find(RicercaDb o) {
		// TODO Auto-generated method stub
		ResponseDao<Corsi> r = new ResponseDao<>();
		try {
			r.setList(dao.find(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	public ResponseDao<Corsi> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		ResponseDao<Corsi> r = new ResponseDao<>();
		try {
			r.setList(dao.findAll(reverse));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<Corsi> findById(Integer id) {
		// TODO Auto-generated method stub
		ResponseDao<Corsi> r = new ResponseDao<>();
		try {
			List<Corsi> iscrizioni = new ArrayList<>();
			iscrizioni.add(dao.findById(id));
			r.setList(iscrizioni);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

}
