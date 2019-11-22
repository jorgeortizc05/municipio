package jorgeortiz.sistemaasistencia.bussiness;

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
}
