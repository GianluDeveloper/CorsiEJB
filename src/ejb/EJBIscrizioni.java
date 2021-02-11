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

import dao.IscrizioniDao;
import dto.IscrizioniDto;
import dto.builder.IscrizioniBuilder;
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
public class EJBIscrizioni implements EJBIscrizioniRemote, EJBIscrizioniLocal, EJB<IscrizioniDto> {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
	@Override
	public Response insert(IscrizioniDto o) {
		// TODO Auto-generated method stub
		IscrizioniDao dao = new IscrizioniDao(this.em);

		Response r = new Response();
		try {
			dao.insert(IscrizioniBuilder.fromIscrizioniDtoToIscrizioni(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public Response update(IscrizioniDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		IscrizioniDao dao = new IscrizioniDao(this.em);

		try {
			dao.update(IscrizioniBuilder.fromIscrizioniDtoToIscrizioni(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public Response delete(IscrizioniDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		IscrizioniDao dao = new IscrizioniDao(this.em);

		try {
			dao.delete(IscrizioniBuilder.fromIscrizioniDtoToIscrizioni(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<IscrizioniDto> find(RicercaDb o) {
		// TODO Auto-generated method stub
		IscrizioniDao dao = new IscrizioniDao(this.em);

		ResponseDao<IscrizioniDto> r = new ResponseDao<>();
		try {
			List<IscrizioniDto> lista = new ArrayList<>();
			for(Iscrizioni c:dao.find(o)) {
				lista.add(IscrizioniBuilder.fromIscrizioniToIscrizioniDto(c));
			}
			r.setList(lista);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<IscrizioniDto> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		IscrizioniDao dao = new IscrizioniDao(this.em);

		ResponseDao<IscrizioniDto> r = new ResponseDao<>();
		try {
			List<IscrizioniDto> lista = new ArrayList<>();
			for(Iscrizioni c:dao.findAll(reverse)) {
				lista.add(IscrizioniBuilder.fromIscrizioniToIscrizioniDto(c));
			}
			r.setList(lista);
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}
	
	@Override
	public ResponseDao<IscrizioniDto> findById(Integer id) {
		// TODO Auto-generated method stub
		IscrizioniDao dao = new IscrizioniDao(this.em);

		ResponseDao<IscrizioniDto> r = new ResponseDao<>();
		try {
			List<IscrizioniDto> iscrizioni = new ArrayList<>();
			Iscrizioni c = dao.findById(id);
			iscrizioni.add(IscrizioniBuilder.fromIscrizioniToIscrizioniDto(c));
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
