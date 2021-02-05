package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.Iscrizioni;
import util.Dao;

/**
 * Session Bean implementation class EJBIscrizioni
 */
@Stateless
@LocalBean
public class EJBIscrizioni implements EJBIscrizioniRemote, EJBIscrizioniLocal, Dao<Iscrizioni> {

    /**
     * Default constructor. 
     */
    public EJBIscrizioni() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Iscrizioni o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Iscrizioni o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iscrizioni o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Iscrizioni o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll(Iscrizioni o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
		
	}

}
