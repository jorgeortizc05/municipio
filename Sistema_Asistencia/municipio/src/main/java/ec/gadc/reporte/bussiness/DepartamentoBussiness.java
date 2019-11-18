package ec.gadc.reporte.bussiness;

import java.util.List;

import ec.gadc.reporte.dao.DepartamentoDAO;
import ec.muni.fulltime.model.Departamento;

public class DepartamentoBussiness {
	
	DepartamentoDAO depDAO = new DepartamentoDAO();
	
	public List<Departamento> getDepartamento(String descripcion){
		return depDAO.getDepartamento(descripcion);
	}

}
