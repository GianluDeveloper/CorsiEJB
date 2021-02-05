package ejb;

import java.sql.SQLException;
import java.text.ParseException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import dao.DocentiDao;
import exceptions.NotHandledTypeException;
import model.Docenti;
import response.Response;
import response.ResponseDao;
import util.EJB;
import util.RicercaDb;

/**
 * Session Bean implementation class EJBDocenti
 */
@Stateless
@LocalBean
public class EJBDocenti implements EJBDocentiRemote, EJBDocentiLocal,EJB<Docenti> {

	DocentiDao dao = new DocentiDao();

	@Override
	public Response insert(Docenti o) {
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
	public Response update(Docenti o) {
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
	public Response delete(Docenti o) {
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
	public ResponseDao<Docenti> find(RicercaDb o) {
		// TODO Auto-generated method stub
		ResponseDao<Docenti> r = new ResponseDao<>();
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
	public ResponseDao<Docenti> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		ResponseDao<Docenti> r = new ResponseDao<>();
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
