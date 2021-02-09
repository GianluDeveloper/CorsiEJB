package ejb;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import dao.DocentiDao;
import dto.DocentiDto;
import dto.builder.DocentiBuilder;
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
public class EJBDocenti implements EJBDocentiRemote, EJBDocentiLocal, EJB<DocentiDto> {

	DocentiDao dao = new DocentiDao();

	@Override
	public Response insert(DocentiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.insert(DocentiBuilder.fromDocentiDtoToDocenti(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public Response update(DocentiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.update(DocentiBuilder.fromDocentiDtoToDocenti(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public Response delete(DocentiDto o) {
		// TODO Auto-generated method stub
		Response r = new Response();
		try {
			dao.delete(DocentiBuilder.fromDocentiDtoToDocenti(o));
		} catch (ClassNotFoundException | SQLException | NotHandledTypeException | NamingException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setErrorCode(1000);
			r.setDescription(e.toString());
		}
		return r;
	}

	@Override
	public ResponseDao<DocentiDto> find(RicercaDb o) {
		// TODO Auto-generated method stub
		ResponseDao<DocentiDto> r = new ResponseDao<>();
		try {
			List<DocentiDto> lista = new ArrayList<>();
			for (Docenti c : dao.find(o)) {
				lista.add(DocentiBuilder.fromDocentiToDocentiDto(c));
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
	public ResponseDao<DocentiDto> findAll(Boolean reverse) {
		// TODO Auto-generated method stub
		ResponseDao<DocentiDto> r = new ResponseDao<DocentiDto>();
		try {
			List<DocentiDto> lista = new ArrayList<>();
			for (Docenti c : dao.findAll(reverse)) {
				lista.add(DocentiBuilder.fromDocentiToDocentiDto(c));
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
	public ResponseDao<DocentiDto> findById(Integer id) {
		// TODO Auto-generated method stub
		ResponseDao<DocentiDto> r = new ResponseDao<>();
		try {
			List<DocentiDto> iscrizioni = new ArrayList<>();
			Docenti c = dao.findById(id);
			iscrizioni.add(DocentiBuilder.fromDocentiToDocentiDto(c));
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
