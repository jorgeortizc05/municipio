package jorgeortiz.sistemaasistencia.bussiness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.MainJustDAO;
import jorgeortiz.sistemaasistencia.dao.ServidorAreaDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.ServidorAreaSQL;

/*
 * Realizado por: Jorge Ortiz
 * Fecha de modificacion: 14/11/2019
 * Descripcion: Servidor de areas de DB nomina
 */

@Stateless
public class ServidorAreaBussiness implements Serializable {

	private static final long serialVersionUID = 1L;

	private ServidorAreaDAO seraDAO = new ServidorAreaDAO();

	@Inject
	private MainJustDAO justDAO;

	public ServidorAreaSQL recuperarServidorArea(int codigoServidor) throws Exception {
		ServidorAreaSQL servidorArea = seraDAO.recuperarServidorArea(codigoServidor);

		if (!(servidorArea == null)) {
			return servidorArea;
		} else
			throw new Exception("Sin datos de Servidor Area SQL");

	}

	public void guardarEmpleado(EMPLEADO empleado) throws Exception {
		if (!(empleado == null)) {
			seraDAO.insertEmpleado(empleado);
		} else
			throw new Exception("Sin datos de empleado");
	}

}
