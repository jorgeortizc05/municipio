package jorgeortiz.sistemaasistencia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import jorgeortiz.sistemaasistencia.bussiness.CargoBussiness;
import jorgeortiz.sistemaasistencia.bussiness.DepartamentoBussiness;
import jorgeortiz.sistemaasistencia.bussiness.ServidorAreaBussiness;
import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.DepartamentoSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;
import jorgeortiz.sistemaasistencia.nomina.model.ServidorAreaSQL;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class ServidorAreaController {

	@Inject
	private CargoBussiness cargBuss;
	
	@Inject
	private FacesContext facesContext;

	// Servidor, cargo y departamentos
	private ServidorAreaBussiness sercBuss;
	private List<ServidorAreaSQL> servidorAreas;
	private List<ServidorAreaSQL> filterServidorArea; // Para filtrar cservidorAreas
	private ServidorAreaSQL servidorAreaSQL;
	private SERVIDOR servidor;
	private List<SERVIDOR> servidores;

	private DepartamentoBussiness depBuss;
	private List<DepartamentoSQL> departamentos;
	private List<DepartamentoSQL> filterDepartamentos;

	private List<CARGO> cargos;

	private EMPLEADO empleado;

	// Variables
	private int vCodigoServidor;
	private String vDescripcion;
	private int vCodigoDepartamento;
	private int vCodigoCargo;

	@PostConstruct
	public void init() {
		vCodigoServidor = 0;
		sercBuss = new ServidorAreaBussiness();
		depBuss = new DepartamentoBussiness();
		servidorAreaSQL = new ServidorAreaSQL();
		servidor = new SERVIDOR();
		empleado = new EMPLEADO();

		try {
			cargos = cargBuss.recuperarCargos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);

		}

	}

	public String loadServidorCargo() {

		try {
			servidorAreaSQL = sercBuss.recuperarServidorArea(vCodigoServidor);
			departamentos = depBuss
					.recuperarDatosDepartamento((servidorAreaSQL.getDireccion().substring(0, 7)).toUpperCase());
			// servidor = sercBuss.recuperarServidor(servidorAreaSQL.getCedulaServidor());
			System.out.println(servidor);

			// System.out.println(servidorArea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getLocalizedMessage());
		}

		return null;
	}

	public String enviarFullTime() {
		List<SERVIDOR> aux = new ArrayList<SERVIDOR>();
		SERVIDOR auxs = new SERVIDOR();
		EMPLEADO auxe = new EMPLEADO();

		System.out.println("Boton enviarFullTime");
		System.out.println(servidorAreaSQL);

		try {
			// auxs = sercBuss.recuperarServidor(servidorAreaSQL.getCedulaServidor());
			auxe.setEMPL_ID(10000);
			auxe.setNOMBRE(auxs.getPRIMER_NOMBRE());
			auxe.setAPELLIDO(auxs.getAPELLIDO_PATERNO() + " " + auxs.getAPELLIDO_MATERNO());
			auxe.setCIUD_ID(2);
			if (auxs.getSEXO().equals("M")) {
				auxe.setSEXO(1);
			} else {
				auxe.setSEXO(2);
			}

			auxe.setHORAS_TRABAJA(0);
			auxe.setCEDULA(auxs.getCEDULA());
			auxe.setDEPA_ID(vCodigoDepartamento);
			auxe.setCORREO("rrhh@cuenca.gob.ec");
			auxe.setFECHA_NACIMIENTO(auxs.getFECHA_NACIMIENTO());
			auxe.setID(auxs.getBIOMETRICO()); // Codigo del reloj biometrico
			auxe.setCARG_ID(vCodigoCargo); // codigo de cargo
			auxe.setESTADO(5);
			auxe.setESTADO_CIVIL(8); //
			auxe.setDGCO_ID(1);

			System.out.println("EMPLEADO>>>>>>>>>>>>");
			System.out.println(auxe);
			// sercBuss.guardarEmpleado(auxe);

			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return null;
	}

	public int getvCodigoServidor() {
		return vCodigoServidor;
	}

	public void setvCodigoServidor(int vCodigoServidor) {
		this.vCodigoServidor = vCodigoServidor;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public List<CARGO> getCargos() {
		return cargos;
	}

	public void setCargos(List<CARGO> cargos) {
		this.cargos = cargos;
	}

	public int getvCodigoDepartamento() {
		return vCodigoDepartamento;
	}

	public void setvCodigoDepartamento(int vCodigoDepartamento) {
		this.vCodigoDepartamento = vCodigoDepartamento;
	}

	public int getvCodigoCargo() {
		return vCodigoCargo;
	}

	public void setvCodigoCargo(int vCodigoCargo) {
		this.vCodigoCargo = vCodigoCargo;
	}

	public ServidorAreaSQL getServidorAreaSQL() {
		return servidorAreaSQL;
	}

	public void setServidorAreaSQL(ServidorAreaSQL servidorAreaSQL) {
		this.servidorAreaSQL = servidorAreaSQL;
	}

	public List<DepartamentoSQL> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DepartamentoSQL> departamentos) {
		this.departamentos = departamentos;
	}

	public SERVIDOR getServidor() {
		return servidor;
	}

	public void setServidor(SERVIDOR servidor) {
		this.servidor = servidor;
	}

	public List<SERVIDOR> getServidores() {
		return servidores;
	}

	public void setServidores(List<SERVIDOR> servidores) {
		this.servidores = servidores;
	}

}
