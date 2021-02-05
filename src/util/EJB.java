package util;

import response.Response;
import response.ResponseDao;

public interface EJB <T> {
	public Response insert(T o);
	public Response update(T o);
	public Response delete(T o);
	public ResponseDao<T> find(RicercaDb o);
	public ResponseDao<T> findAll(Boolean reverse);
}
