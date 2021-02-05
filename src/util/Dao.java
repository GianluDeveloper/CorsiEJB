package util;

public interface Dao<T> {
	
	public void insert(T o);

	public void update(T o);

	public void delete(T o);

	public void find(T o);

	public void findAll(T o);

	public void findById(int id);
	
}
