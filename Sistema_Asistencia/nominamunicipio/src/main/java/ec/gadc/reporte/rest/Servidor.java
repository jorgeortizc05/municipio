package ec.gadc.reporte.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.gadc.reporte.dao.mainJustDAO;
import ec.muni.nomina.model.SERVIDOR;

@Path("servidor")
public class Servidor {
	
	@Inject
	private mainJustDAO mdao;
	
	@GET
	@Path("get_servidor")
	@Produces("application/xml")
	public List <SERVIDOR> sendFoto(@QueryParam("cedula") String cedula){
		List<SERVIDOR> empleados=mdao.getServidor(cedula);
		return empleados;
	}

}
