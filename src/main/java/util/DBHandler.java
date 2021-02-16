package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exceptions.NotHandledTypeException;

public class DBHandler {

	private List<Object> res = new ArrayList<>();
	private String dataSource = "java:/CorsiDS";

	public List<Object> getResponse() {
		return this.res;
	}

	public DBHandler() {

	}

	public DBHandler(String dataSource) {
		this.dataSource = dataSource;
	}

	public boolean sql(String sql, Object[] objs)
			throws ClassNotFoundException, SQLException, NotHandledTypeException, NamingException {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;

		DataSource ds = (DataSource) new InitialContext().lookup(this.dataSource);
		conn = ds.getConnection();

		stmt = conn.prepareStatement(sql);

		int counter = 1;
		for (Object obj : objs) {
			if (obj.getClass().getTypeName().toString().matches(".*String.*")) {
				stmt.setString(counter++, (String) obj);
			} else if (obj.getClass().getTypeName().toString().matches(".*Integer.*")) {
				stmt.setInt(counter++, (Integer) obj);
			} else if (obj.getClass().getTypeName().toString().matches(".*Boolean.*")) {
				stmt.setBoolean(counter++, (Boolean) obj);
			} else if (obj.getClass().getTypeName().toString().matches(".*Float.*")) {
				stmt.setFloat(counter++, (Float) obj);
			} else if (obj.getClass().getTypeName().toString().matches(".*java\\.sql\\.Date.*")) {
				stmt.setDate(counter++, (java.sql.Date) obj);
			} else {
				throw new NotHandledTypeException(obj.getClass().getTypeName().toString());
			}
		}

		stmt.execute();
		ResultSet rs = stmt.getResultSet();

		if (rs != null) {
			ResultSetMetaData md = rs.getMetaData();
			Integer colonne = md.getColumnCount();
			while (rs.next()) {
				Object[] oggetto = new Object[colonne];
				for (int i = 1; i <= colonne; i++) {
					oggetto[i - 1] = rs.getObject(i);
				}
				res.add(oggetto);
			}
			rs.close();
		}

		stmt.close();
		conn.close();
		success = true;

		if (stmt != null) {
			stmt.close();
		}

		return success;
	}
}
