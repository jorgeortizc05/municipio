package ec.gadc.reporte.bussiness;

import java.util.List;

import ec.gadc.reporte.dao.ServidorAreaDAO;
import ec.muni.nomina.model.ServidorArea;


public class ServidorAreaBussiness {
	
	private ServidorAreaDAO serc = new ServidorAreaDAO();
	
	public List<ServidorArea> getServidorCargo(int codigo){
		
		return serc.getServidor(codigo);
	}

}
