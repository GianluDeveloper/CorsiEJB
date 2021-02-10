package ejb;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CorsiDao;
import dto.CorsiDto;
import dto.builder.CorsiBuilder;
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
public class EJBCorsi implements EJBCorsiRemote, EJBCorsiLocal, EJB<CorsiDto> {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
	CorsiDao dao = new CorsiDao(em);

	@Override
	public Response insert(CorsiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.insert(CorsiBuilder.fromCorsiDtoToCorsi(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}
	
	@Override
	public Response update(CorsiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.update(CorsiBuilder.fromCorsiDtoToCorsi(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	
	@Override
	public Response delete(CorsiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.delete(CorsiBuilder.fromCorsiDtoToCorsi(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<CorsiDto> find(RicercaDb o) {
		// TODO Auto-generated method stub
		ResponseDao<CorsiDto> r = new ResponseDao<>();
		try {
			List<CorsiDto> dtos = new ArrayList<>();
			for(Corsi c : dao.find(o)) {
				dtos.add(CorsiBuilder.fromCorsiToCorsiDto(c));
			}
			r.setList(dtos);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<CorsiDto> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		ResponseDao<CorsiDto> r = new ResponseDao<>();
		try {
			List<CorsiDto> dtos = new ArrayList<>();
			for(Corsi c : dao.findAll(reverse)) {
				dtos.add(CorsiBuilder.fromCorsiToCorsiDto(c));
			}
			r.setList(dtos);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<CorsiDto> findById(Integer id) {
		// TODO Auto-generated method stub
		ResponseDao<CorsiDto> r = new ResponseDao<>();
		try {
			List<CorsiDto> iscrizioni = new ArrayList<>();
			iscrizioni.add(CorsiBuilder.fromCorsiToCorsiDto(dao.findById(id)));
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
