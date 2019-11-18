package ec.gadc.reporte.main;

import java.util.List;

import javax.inject.Inject;

import ec.gadc.reporte.dao.ServidorCargoDAO;
import ec.muni.nomina.model.ServidorCargo;

public class main {

	
	private static ServidorCargoDAO servcDAO = new ServidorCargoDAO();
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		servcDAO.getServidor(713);

	}

}
