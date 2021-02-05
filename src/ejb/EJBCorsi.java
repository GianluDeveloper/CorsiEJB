package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.Corsi;
import util.Dao;

/**
 * Session Bean implementation class EJBCorsi
 */
@Stateless
@LocalBean
public class EJBCorsi implements EJBCorsiRemote, EJBCorsiLocal, Dao<Corsi> {

    /**
     * Default constructor. 
     */
    public EJBCorsi() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Corsi o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Corsi o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Corsi o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Corsi o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll(Corsi o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
		
	}

}
