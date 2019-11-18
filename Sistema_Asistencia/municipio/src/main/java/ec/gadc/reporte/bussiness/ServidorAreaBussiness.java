package ec.gadc.reporte.bussiness;

import java.util.ArrayList;
import java.util.List;

import ec.gadc.reporte.dao.ServidorAreaDAO;
import ec.muni.nomina.model.ServidorArea;


/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Servidor de areas de DB nomina
 */

public class ServidorAreaBussiness {
	
	private ServidorAreaDAO serc = new ServidorAreaDAO();
	
	public List<ServidorArea> recuperarDatosServidor(int codigoServidor){
		List<ServidorArea> servidorAreas = new ArrayList<>();
		
		try {
			servidorAreas = serc.recuperarDatosServidor(codigoServidor);
			return servidorAreas;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Sin datos "+e.getMessage());
			return null;
		}
		
		
	}

}
