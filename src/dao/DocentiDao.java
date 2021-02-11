package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import exceptions.NotHandledTypeException;
import model2.Docenti;
import util.DBHandler;
import util.Dao;
import util.RicercaDb;

public class DocentiDao implements Dao<Docenti> {
	private EntityManager em;

	@Override
	public void insert(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		em.persist(o);
		// TODO Auto-generated method stub
//		Object[] campi = { o.getCorsi().getIdCorso(), o.getNomeDocente() };
//		String sql = "INSERT INTO `docenti`(`idDocente`, `idCorso`, `nomeDocente`) VALUES ( NULL, ?, ? )";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
	}

	@Override
	public void update(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		em.merge(o);
//		Object[] campi = { o.getCorsi().getIdCorso(), o.getNomeDocente(), o.getIdDocente() };
//		String sql = "UPDATE `docenti` SET `idCorso`=?,`nomeDocente`=? WHERE `idDocente`=?";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
	}

	@Override
	public void delete(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Docenti d =  em.find(Docenti.class, o.getIdDocente());
		em.remove(d);
//		Object[] campi = { o.getIdDocente() };
//		String sql = "DELETE FROM `docenti` WHERE `idDocente`=?";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
	}

	@Override
	public List<Docenti> find(RicercaDb o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		String key = o.getKey();
		String value = o.getValue();

		List<Docenti> res = new ArrayList<>();
		String[] allowed = { "idCorso", "idDocente", "nomeDocente" };
		boolean notAllowed = true;
		for (String allow : allowed) {
			if (key.equals(allow)) {
				notAllowed = false;
				break;
			}
		}
		if (notAllowed) {
			throw new SQLException("Chiave colonna '" + key + "' non valida");
		}
		em.createQuery("FROM c WHERE `" + key + "`= :value " )
//		Object[] campi = { value };
//		String sql = "SELECT * FROM `docenti` WHERE `" + key + "`=?  ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			Docenti c = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
//			res.add(c);
//		}
		return res;
	}

	@Override
	public List<Docenti> findAll(Boolean reverse)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		Query q = em.createQuery("Docenti.findAll");
		@SuppressWarnings("unchecked")
		List<Docenti> res = q.getResultList();
//		List<Docenti> res = new ArrayList<>();
//
//		Object[] campi = { 1 };
//
//		String sql = "SELECT * FROM `docenti` WHERE  ? ORDER BY `idDocente` ";
//		if (reverse)
//			sql += "DESC";
//
//		else
//			sql += "ASC";
//
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			Docenti c = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
//			res.add(c);
//		}
		return res;
	}

	@Override
	public Docenti findById(Integer id)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Docenti res = em.find(Docenti.class, id);
//		
//		Docenti corso = new Docenti();
//
//		Object[] campi = { id };
//
//		String sql = "SELECT * FROM `docenti` WHERE idDocente = ? ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			corso = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
//		}
		return res;
	}

}
