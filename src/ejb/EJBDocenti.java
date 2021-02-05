package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.Docenti;
import util.Dao;

/**
 * Session Bean implementation class EJBDocenti
 */
@Stateless
@LocalBean
public class EJBDocenti implements EJBDocentiRemote, EJBDocentiLocal,Dao<Docenti> {

    /**
     * Default constructor. 
     */
    public EJBDocenti() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Docenti o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Docenti o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Docenti o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Docenti o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll(Docenti o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
		
	}

}
