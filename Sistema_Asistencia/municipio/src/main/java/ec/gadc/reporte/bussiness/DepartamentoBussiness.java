package ec.gadc.reporte.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import ec.gadc.reporte.dao.DepartamentoDAO;
import ec.muni.fulltime.model.Departamento;

/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Departamentos de DB fulltime
 */
@Stateless
public class DepartamentoBussiness {
	
	DepartamentoDAO depDAO = new DepartamentoDAO();
	
	public List<Departamento> recuperarDatosDepartamento(String descripcion) throws Exception{
		List<Departamento> departamentos = depDAO.recuperarDatosDepartamento(descripcion);
		
		if(!(departamentos == null)){
			return departamentos;
		}else
			throw new Exception("Sin datos de departamentos");
	}

}
