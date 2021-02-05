package ejb;

import javax.ejb.Remote;

import model.Docenti;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Remote
public interface EJBDocentiRemote {

	public Response insert(Docenti o);

	public Response update(Docenti o);

	public Response delete(Docenti o);

	public ResponseDao<Docenti> find(RicercaDb o);

	public ResponseDao<Docenti> findAll(Boolean reverse);

}
