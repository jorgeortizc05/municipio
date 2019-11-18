package ec.gadc.reporte.bussiness;

import java.util.ArrayList;
import java.util.List;

import ec.gadc.reporte.dao.DepartamentoDAO;
import ec.muni.fulltime.model.Departamento;

/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Departamentos de DB fulltime
 */

public class DepartamentoBussiness {
	
	DepartamentoDAO depDAO = new DepartamentoDAO();
	
	public List<Departamento> recuperarDatosDepartamento(String descripcion){
		List<Departamento> departamentos = new ArrayList<>();
		try {
			departamentos = depDAO.recuperarDatosDepartamento(descripcion);
			return departamentos;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Sin datos "+e.getMessage());
			return null;
		}
		
	}

}
