package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;

import exceptions.NotHandledTypeException;
import model.Corsi;
//import model.CorsiJpa;
import util.Dao;
import util.DateHandler;
import util.RicercaDb;

public class CorsiDao implements Dao<Corsi> {

	private EntityManager em;

	public CorsiDao(EntityManager em) {
		this.em = em;
	}

	public CorsiDao() {
	}

	@Override
	public void insert(Corsi o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// Object[] campi = { o.getNomeCorso(), DateHandler.toSql(o.getDataInizio()),
		// DateHandler.toSql(o.getDataFine()) };
		// String sql = "INSERT INTO `corsi`(`idCorso`, `nomeCorso`, `dataInizio`,
		// `dataFine`) VALUES ( NULL, ?, ?, ? )";
		// DBHandler dbHandler = new DBHandler();
		// dbHandler.sql(sql, campi);
		// o.setDataInizio(DateHandler.toSql(o.getDataInizio()));
		
		//CorsiJpa c = new CorsiJpa(o.getIdCorso(), o.getNomeCorso(), o.getDataInizio(), o.getDataFine());
		this.em.persist(o);

	}

	@Override
	public void update(Corsi o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
//		CorsiJpa c = new CorsiJpa(o.getIdCorso(), o.getNomeCorso(), o.getDataInizio(), o.getDataFine());

		this.em.merge(o);
		// Object[] campi = { o.getNomeCorso(), DateHandler.toSql(o.getDataInizio()),
		// DateHandler.toSql(o.getDataFine()),
		// o.getIdCorso() };
		// String sql = "UPDATE `corsi` SET `nomeCorso`=?,`dataInizio`=?,`dataFine`=?
		// WHERE `idCorso`=?";
		// DBHandler dbHandler = new DBHandler();
		// dbHandler.sql(sql, campi);
	}

	@Override
	public void delete(Corsi o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		Corsi p = em.find(Corsi.class, o.getIdCorso());
		em.remove(p);
		// Object[] campi = { o.getIdCorso() };
		// String sql = "DELETE FROM `corsi` WHERE `idCorso`=?";
		// DBHandler dbHandler = new DBHandler();
		// dbHandler.sql(sql, campi);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Corsi> find(RicercaDb rdb)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		String key = rdb.getKey();
		String value = rdb.getValue();

		//List<Corsi> res = new ArrayList<>();
		String[] allowed = { "idCorso", "nomeCorso", "dataInizio", "dataFine" };
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
		
		// funzioni di conversione per JPA
		List<Corsi> listaCorsi = new ArrayList<>();
		switch(key) {
			case "idCorso":
				int valueConverted = Integer.parseInt(value);
				listaCorsi = (List<Corsi>) em.createQuery("SELECT c FROM Corsi c WHERE " + key + " = :value ")
				.setParameter("value", valueConverted).getResultList();
				break;
			case "dataInizio":
				java.sql.Date dateConverted1 = DateHandler.toSql(value);
				listaCorsi = (List<Corsi>) em.createQuery("SELECT c FROM Corsi c WHERE " + key + " = :value ")
				.setParameter("value", dateConverted1).getResultList();
				break;
			case "dataFine":
				java.sql.Date dateConverted2 = DateHandler.toSql(value);
				listaCorsi = (List<Corsi>) em.createQuery("SELECT c FROM Corsi c WHERE " + key + " = :value ")
				.setParameter("value", dateConverted2).getResultList();
				break;
			default:
				listaCorsi = (List<Corsi>) em.createQuery("SELECT c FROM Corsi c WHERE " + key + " = :value ")
				.setParameter("value", value).getResultList();
		}
		
//		for (Corsi o : listaCorsi) {
//			Corsi c = new Corsi(o.getIdCorso(), o.getNomeCorso(), DateHandler.fromSql(o.getDataInizio()),
//					DateHandler.fromSql(o.getDataFine()));
//			res.add(c);
//		}
//		Object[] campi = { value };
//		String sql = "SELECT * FROM `corsi` WHERE `" + key + "`=?  ";
//		DBHandler dbHandler = new DBHandler();
//		dbHandler.sql(sql, campi);
//		List<Object> objs = dbHandler.getResponse();
//		for (Object obj : objs) {
//			Object[] tmp = (Object[]) obj;
//			Corsi c = new Corsi((Integer) tmp[0], (String) tmp[1], DateHandler.fromSql((java.sql.Date) tmp[2]),
//					DateHandler.fromSql((java.sql.Date) tmp[3]));
//			res.add(c);
//		}
		return listaCorsi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Corsi> findAll(Boolean reverse)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {

//		Corsi c = (Corsi) em.createQuery("SELECT c FROM Corsi c").getSingleResult();
//		System.out.println("molto "+c.getIdCorso());
		List<Corsi> listaCorsi = em.createQuery("SELECT c FROM Corsi c").getResultList();
		System.out.print(listaCorsi.size());
//		List<Corsi> res = new ArrayList<>();
//		for (CorsiJpa o : listaCorsi) {
//			Corsi c = new Corsi(o.getIdCorso(), o.getNomeCorso(), DateHandler.fromSql(o.getDataInizio()),
//					DateHandler.fromSql(o.getDataFine()));
//			res.add(c);
//		}

		return listaCorsi;
		//
		// List<Corsi> res = new ArrayList<>();
		//
		// Object[] campi = { 1 };
		//
		// String sql = "SELECT * FROM `corsi` WHERE ? ORDER BY `idCorso` ";
		// if (reverse)
		// sql += "DESC";
		//
		// else
		// sql += "ASC";
		//
		// DBHandler dbHandler = new DBHandler();
		// dbHandler.sql(sql, campi);
		// List<Object> objs = dbHandler.getResponse();
		// for (Object obj : objs) {
		// Object[] tmp = (Object[]) obj;
		// Corsi c = new Corsi((Integer) tmp[0], (String) tmp[1],
		// DateHandler.fromSql((java.sql.Date) tmp[2]),
		// DateHandler.fromSql((java.sql.Date) tmp[3]));
		// res.add(c);
		// }
		// return res;
	}

	@Override
	public Corsi findById(Integer id)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		Corsi p = em.find(Corsi.class, id);
//		Corsi r = new Corsi(p.getIdCorso(), p.getNomeCorso(), DateHandler.fromSql(p.getDataInizio()),
//				DateHandler.fromSql(p.getDataFine()));
		return p;

		// Corsi corso = new Corsi();
		//
		// Object[] campi = { id };
		//
		// String sql = "SELECT * FROM `corsi` WHERE idCorso = ? ";
		// DBHandler dbHandler = new DBHandler();
		// dbHandler.sql(sql, campi);
		// List<Object> objs = dbHandler.getResponse();
		// for (Object obj : objs) {
		// Object[] tmp = (Object[]) obj;
		// corso = new Corsi((Integer) tmp[0], (String) tmp[1],
		// DateHandler.fromSql((java.sql.Date) tmp[2]),
		// DateHandler.fromSql((java.sql.Date) tmp[3]));
		// }
		// return corso;
	}

}
