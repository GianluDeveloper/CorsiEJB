package ejb;

import javax.ejb.Local;

import dto.CorsiDto;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@Local
public interface EJBCorsiLocal {
	public Response insert(CorsiDto o);

	public Response update(CorsiDto o);

	public Response delete(CorsiDto o);

	public ResponseDao<CorsiDto> find(RicercaDb o);

	public ResponseDao<CorsiDto> findAll(Boolean reverse);

	public ResponseDao<CorsiDto> findById(Integer id);

}
