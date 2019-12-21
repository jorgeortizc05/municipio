package jorgeortiz.sistemaasistencia.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.ServidorDAO;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;

@Stateless
public class SessionBussiness {
	
	@Inject
	private ServidorDAO servDAO;

	public SERVIDOR getServidor(String cedula, String pass) throws Exception {
		
		SERVIDOR item = servDAO.getServidor(cedula, pass);
		
		if(!(item == null)) {
			return item;
		}
		else
			throw new Exception("No hay datos de SERVIDOR");
	}
}
