package jorgeortiz.sistemaasistencia.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.EmpleadoDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;

@Stateless
public class EmpleadoBussiness {

	@Inject
	private EmpleadoDAO empDAO;
	
	public EMPLEADO getEmpleadoCodigo(String codigo) throws Exception {
		EMPLEADO empleado = empDAO.getEmpleadoCodigo(codigo);
		
		if(!(empleado == null)) {
			return empleado;
		}else
			throw new Exception("No hay datos de empleado");
	}
	
	public List<EMPLEADO> getListEmp(){
		List<EMPLEADO> items = empDAO.getListEmp();
		
		return items;
	}
}
