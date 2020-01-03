package jorgeortiz.sistemaasistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;

@Stateless
public class EmpleadoDAO {

	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	
	public EMPLEADO getEmpleadoCodigo(String codigo) {
		
		try{
			Query query=emF.createQuery("select s from EMPLEADO s where s.CODIGO_EMPLEADO = :codigo",EMPLEADO.class);
			System.out.println("Codigo empleado:"+codigo);
			query.setParameter("codigo", codigo);
			EMPLEADO empleado= (EMPLEADO) query.getSingleResult();
			return empleado;
			}catch(Exception e){
				System.out.println("nulo");
				return null;
			}
	}
	
	public List<EMPLEADO> getListEmp(){
		Query query = emF.createQuery("select r FROM EMPLEADO r ", EMPLEADO.class);
		
		List<EMPLEADO> items = query.getResultList();
		
		return items;
	}
}
