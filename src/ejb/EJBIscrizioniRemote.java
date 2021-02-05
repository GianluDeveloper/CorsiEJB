package ejb;

import javax.ejb.Remote;

import model.Iscrizioni;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Remote
public interface EJBIscrizioniRemote {
	
	public Response insert(Iscrizioni o);

	public Response update(Iscrizioni o);

	public Response delete(Iscrizioni o);

	public ResponseDao<Iscrizioni> find(RicercaDb o);

	public ResponseDao<Iscrizioni> findAll(Boolean reverse);

	public ResponseDao<Iscrizioni> findById(Integer id);
	
}
