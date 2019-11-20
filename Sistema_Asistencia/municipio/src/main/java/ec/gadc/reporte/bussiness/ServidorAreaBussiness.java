package ec.gadc.reporte.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.gadc.reporte.dao.ServidorAreaDAO;
import ec.gadc.reporte.dao.mainReporteDAO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.SERVIDOR;
import ec.muni.nomina.model.ServidorArea;


/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Servidor de areas de DB nomina
 */

@Stateless
public class ServidorAreaBussiness {
	
	private ServidorAreaDAO seraDAO = new ServidorAreaDAO();
	
	public ServidorArea recuperarServidorArea(int codigoServidor) throws Exception{
		ServidorArea servidorArea = seraDAO.recuperarServidorArea(codigoServidor);
		
		if(!(servidorArea == null)) {
			return servidorArea;
		}else 
			throw new Exception("Sin datos de Servidor");
		
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
