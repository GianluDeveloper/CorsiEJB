package ejb;

import javax.ejb.Local;

import model.Docenti;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Local
public interface EJBDocentiLocal {

	public Response insert(Docenti o);

	public Response update(Docenti o);

	public Response delete(Docenti o);

	public ResponseDao<Docenti> find(RicercaDb o);

	public ResponseDao<Docenti> findAll(Boolean reverse);
	
	public ResponseDao<Docenti> findById(Integer id);
	
}
