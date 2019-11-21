package jorgeortiz.sistemaasistencia.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import jorgeortiz.sistemaasistencia.dao.DepartamentoDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.DepartamentoSQL;

/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Departamentos de DB fulltime
 */
@Stateless
public class DepartamentoBussiness {

	DepartamentoDAO depDAO = new DepartamentoDAO();

	public List<DepartamentoSQL> recuperarDatosDepartamento(String descripcion) throws Exception {
		List<DepartamentoSQL> departamentos = depDAO.recuperarDatosDepartamento(descripcion);

		if (!(departamentos == null)) {
			return departamentos;
		} else
			throw new Exception("Sin datos de departamentos");
	}

}
