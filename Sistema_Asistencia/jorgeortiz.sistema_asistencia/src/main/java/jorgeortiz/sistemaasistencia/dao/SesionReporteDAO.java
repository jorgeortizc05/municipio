package jorgeortiz.sistemaasistencia.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.fulltime.model.USUARIOS;


@Stateless
public class SesionReporteDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	
	public USUARIOS getLoginU(String usuario,String clave) throws NullPointerException{ 
		try{
		Query query=emF.createQuery("select r FROM USUARIOS r WHERE r.USUARIO = :usuario",USUARIOS.class);
		query.setParameter("usuario", usuario);
		USUARIOS u= (USUARIOS) query.getSingleResult();
		if(u.getCONTRASENA().equals(clave)){
			return u;
		}
		return null;
		
		}catch(Exception  e){
			return null;
		}
	}
}
