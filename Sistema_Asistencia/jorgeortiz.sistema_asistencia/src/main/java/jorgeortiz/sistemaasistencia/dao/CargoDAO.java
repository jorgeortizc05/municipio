package jorgeortiz.sistemaasistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;

@Stateless
public class CargoDAO {
	
	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	
	public List<CARGO> recuperarCargos(){
		try {
			Query query=emF.createQuery("select r FROM CARGO r ",CARGO.class);
			List<CARGO> lista= query.getResultList();
			return lista;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return null;
		}
	}
}
