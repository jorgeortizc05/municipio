package jorgeortiz.sistemaasistencia.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.ServidorAreaDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;
import jorgeortiz.sistemaasistencia.nomina.model.ServidorAreaSQL;

/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Servidor de areas de DB nomina
 */

@Stateless
public class ServidorAreaBussiness {
	
	private ServidorAreaDAO seraDAO = new ServidorAreaDAO();
	
	public ServidorAreaSQL recuperarServidorArea(int codigoServidor) throws Exception{
		ServidorAreaSQL servidorArea = seraDAO.recuperarServidorArea(codigoServidor);
		
		if(!(servidorArea == null)) {
			return servidorArea;
		}else 
			throw new Exception("Sin datos de Servidor");
		
	}
	
	public SERVIDOR recuperarServidor(String cedula) throws Exception {
		SERVIDOR servidor = seraDAO.recuperarServidor(cedula);
		
		if(!(servidor==null)) {
			return servidor;
		}else
			throw new Exception("No se encontro datos del servidor");

	}
	
	public List<SERVIDOR> recuperarServidores() {
		List<SERVIDOR> servidores = seraDAO.recuperarServidores();
		return servidores;
	}
	
	public void guardarEmpleado(EMPLEADO empleado) throws Exception {
		if(!(empleado == null)) {
			seraDAO.insertEmpleado(empleado);
		}else
			throw new Exception("Sin datos de empleado");
	}

}
