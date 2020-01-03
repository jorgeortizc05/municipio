package jorgeortiz.sistemaasistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.fulltime.model.NumPersonaPorBiometricoSQL;

@Stateless
public class NumPersonaPorBiometricoDAO {

	@PersistenceContext(unitName = "fulltime")
	EntityManager emF;
	
	public List<NumPersonaPorBiometricoSQL> getListNumPersonaPorBiometrico(String fechaDesde, String fechaHasta){
		Query query = emF.createNamedQuery("queryNumPersonaPorBiometrico");
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List<NumPersonaPorBiometricoSQL> items = query.getResultList();
		
		return items;
	}
}
