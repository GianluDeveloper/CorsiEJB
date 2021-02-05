package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import exceptions.NotHandledTypeException;
import model.Docenti;
import util.DBHandler;
import util.Dao;
import util.RicercaDb;

public class DocentiDao implements Dao<Docenti> {

	@Override
	public void insert(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Object[] campi = { o.getIdDocente(), o.getIdCorso(), o.getNomeDocente() };
		String sql = "INSERT INTO `docenti`(`idDocente`, `idCorso`, `nomeDocente`) VALUES ( NULL, ?, ? )";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	@Override
	public void update(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub

		Object[] campi = { o.getIdCorso(), o.getNomeDocente(), o.getIdDocente() };
		String sql = "UPDATE `docenti` SET `idCorso`=?,`nomeDocente`=? WHERE `idDocente`=?";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
	}

	@Override
	public void delete(Docenti o)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Object[] campi = { o.getIdDocente() };
		String sql = "DELETE `docenti WHERE `idDocente`=?";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
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

		Object[] campi = { value };
		String sql = "SELECT * FROM `docenti` WHERE `" + key + "`=?  ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			Docenti c = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
			res.add(c);
		}
		return res;
	}

	@Override
	public List<Docenti> findAll(Boolean reverse)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {

		List<Docenti> res = new ArrayList<>();

		Object[] campi = { 1 };

		String sql = "SELECT * FROM `docenti` WHERE ? ORDER BY `idDocente` ";
		if (reverse)
			sql += "DESC";

		else
			sql += "ASC";

		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			Docenti c = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
			res.add(c);
		}
		return res;
	}

	@Override
	public Docenti findById(int id)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException, ParseException {
		// TODO Auto-generated method stub
		Docenti corso = new Docenti();

		Object[] campi = { 1 };

		String sql = "SELECT * FROM `docenti` WHERE idDocente = ? ";
		DBHandler dbHandler = new DBHandler();
		dbHandler.sql(sql, campi);
		List<Object> objs = dbHandler.getResponse();
		for (Object obj : objs) {
			Object[] tmp = (Object[]) obj;
			corso = new Docenti((int) tmp[0],(int) tmp[1], (String) tmp[2]);
		}
		return corso;
	}

}
