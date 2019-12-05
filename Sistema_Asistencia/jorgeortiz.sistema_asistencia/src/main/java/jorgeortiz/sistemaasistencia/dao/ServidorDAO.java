package jorgeortiz.sistemaasistencia.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;

@Stateless
public class ServidorDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "nomina")
	private EntityManager emN;
	
	public SERVIDOR getServidor(String cedula, String pass) {
		
		System.out.println(cedula+" "+pass);
		Query query=emN.createQuery("select s from SERVIDOR s where s.CEDULA = :cedula and s.CLAVE = :pass",SERVIDOR.class);
		query.setParameter("cedula", cedula);
		query.setParameter("pass", pass);
		
		List<SERVIDOR> items = query.getResultList();
		
		if(!items.isEmpty()) {
			SERVIDOR item = items.get(0);
			return item;
		}
		
		return null;
	}

}
