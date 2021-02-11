package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import exceptions.NotHandledTypeException;
import model.Iscrizioni;
import util.Dao;
import util.RicercaDb;

public class IscrizioniDao implements Dao<Iscrizioni> {

	EntityManager em;

	public IscrizioniDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(Iscrizioni o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
//		Object[] campi = { o.getIdDipendente(), o.getIdDocente(), o.getIdCorso() };
//		String sql = "INSERT INTO `iscrizioni`(`idIscrizione`, `idDipendente`, `idDocente`, `idCorso`) VALUES ( NULL, ?, ?, ? )";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
		em.persist(o);
	}

	@Override
	public void update(Iscrizioni o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		em.merge(o);
//		Object[] campi = { o.getIdDipendente(), o.getIdDocente(), o.getIdCorso(), o.getIdIscrizione() };
//		String sql = "UPDATE `iscrizioni` SET `idDipendente`=?,`idDocente`=?,`idCorso`=? WHERE `idIscrizione`=?";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
	}

	@Override
	public void delete(Iscrizioni o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Iscrizioni i = em.find(Iscrizioni.class, o.getIdIscrizione());
		em.remove(i);
//		Object[] campi = { o.getIdIscrizione() };
//		String sql = "DELETE FROM `iscrizioni` WHERE `idIscrizione` = ?  ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Iscrizioni> find(RicercaDb o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		String key = o.getKey();
		String value = o.getValue();

		List<Iscrizioni> res = new ArrayList<>();
		String[] allowed = { "idCorso", "idDipendente", "idDocente", "idIscrizione" };
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
		int intValue = Integer.parseInt(value);
		Query q = em.createQuery("FROM c WHERE `" + key + "` = :value");
		q.setParameter("value", intValue);

		res = q.getResultList();
//		Object[] campi = { value };
//		String sql = "SELECT * FROM `iscrizioni` WHERE `" + key + "`=?  ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			Iscrizioni c = new Iscrizioni((int) tmp[0],(int) tmp[1], (int) tmp[2], (int) tmp[3]);
//			res.add(c);
//		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Iscrizioni> findAll(Boolean reverse)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		return em.createNamedQuery("Iscrizioni.findAll").getResultList();
//		
//		List<Iscrizioni> res = new ArrayList<>();
//
//		Object[] campi = { 1 };
//
//		String sql = "SELECT * FROM `iscrizioni` WHERE ? ORDER BY `idIscrizione` ";
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
//			Iscrizioni c = new Iscrizioni((int) tmp[0],(int) tmp[1], (int) tmp[2], (int) tmp[3]);
//			res.add(c);
//		}
//		return res;
	}

	@Override
	public Iscrizioni findById(Integer id)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		return em.find(Iscrizioni.class, id);
//		Iscrizioni corso = new Iscrizioni();
//
//		Object[] campi = { id };
//
//		String sql = "SELECT * FROM `iscrizioni` WHERE `idIscrizione` = ? ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			corso = new Iscrizioni((int) tmp[0],(int) tmp[1], (int) tmp[2], (int) tmp[3]);
//		}
//		return corso;
	}

}
