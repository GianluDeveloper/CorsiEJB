package util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.naming.NamingException;

import exceptions.NotHandledTypeException;

public interface Dao<T> {
	
	public void insert(T o) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;

	public void update(T o) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;

	public void delete(T o) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;

	public List<T> find(RicercaDb o) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;

	public List<T> findAll(Boolean reverse) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;

	public T findById(Integer id) throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException;
	
}
