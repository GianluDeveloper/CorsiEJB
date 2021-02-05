package ejb;

import javax.ejb.Local;

import model.Iscrizioni;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Local
public interface EJBIscrizioniLocal {
	
	public Response insert(Iscrizioni o);

	public Response update(Iscrizioni o);

	public Response delete(Iscrizioni o);

	public ResponseDao<Iscrizioni> find(RicercaDb o);

	public ResponseDao<Iscrizioni> findAll(Boolean reverse);

	public ResponseDao<Iscrizioni> findById(Integer id);
	
}
