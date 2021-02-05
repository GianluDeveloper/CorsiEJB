package ejb;

import javax.ejb.Remote;

import model.Corsi;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Remote
public interface EJBCorsiRemote {

	public Response insert(Corsi o);

	public Response update(Corsi o);

	public Response delete(Corsi o);

	public ResponseDao<Corsi> find(RicercaDb o);

	public ResponseDao<Corsi> findAll(Boolean reverse);
	
	public ResponseDao<Corsi> findById(Integer id);
	
}
