package jorgeortiz.sistemaasistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.gimnasiosoliz.model.TablaImageness;

@Stateless
public class TablaImagenessDAO {

	@PersistenceContext(unitName = "gym")
	private EntityManager emG;
	
	
	public List<TablaImageness> getImagenes(){
		
		Query query=emG.createQuery("select r from TablaImageness r",TablaImageness.class);
		List<TablaImageness> items = query.getResultList();
		
		return items;
		
	}
	
}
