package jorgeortiz.sistemaasistencia.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.CargoDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;

@Stateless
public class CargoBussiness {

	@Inject
	private CargoDAO cargDAO;

	public List<CARGO> recuperarCargos() throws Exception {
		List<CARGO> cargos = cargDAO.recuperarCargos();

		if (!(cargos == null)) {
			return cargos;
		} else
			throw new Exception("No hay cargos");
	}

}
