package ec.gadc.reporte.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.gadc.reporte.bussiness.CargoBussiness;
import ec.gadc.reporte.bussiness.DepartamentoBussiness;
import ec.gadc.reporte.bussiness.ServidorAreaBussiness;
import ec.gadc.reporte.model.CARGO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.SERVIDOR;
import ec.muni.fulltime.model.Departamento;
import ec.muni.nomina.model.ServidorArea;

@ManagedBean
@ViewScoped
public class ServidorAreaController {
	
	@Inject
	private CargoBussiness cargBuss;
	
	//Servidor, cargo y departamentos
	private ServidorAreaBussiness sercBuss;
	private List<ServidorArea> servidorAreas;
	private List<ServidorArea> filterServidorArea; //Para filtrar cservidorAreas
	private ServidorArea servidorArea;
	private SERVIDOR servidor;
	private List<SERVIDOR> servidores;
	
	private DepartamentoBussiness depBuss;
	private List<Departamento> departamentos;
	private List<Departamento> filterDepartamentos;
	
	private List<CARGO> cargos;
	
	private EMPLEADO empleado;
	
	
	//Variables
	private int vCodigoServidor;
	private String vDescripcion;
	private int vCodigoDepartamento;
	private int vCodigoCargo;
	
	@PostConstruct
	public void init() {
		vCodigoServidor = 0;
		sercBuss = new ServidorAreaBussiness();
		depBuss = new DepartamentoBussiness();
		servidorArea = new ServidorArea();
		servidor = new SERVIDOR();
		empleado = new EMPLEADO();
		
		try {
			cargos = cargBuss.recuperarCargos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			
		}
		
	}

	public String loadServidorCargo() {
		
		try {
			servidorArea = sercBuss.recuperarServidorArea(vCodigoServidor);
			departamentos = depBuss.recuperarDatosDepartamento((servidorArea.getDireccion().substring(0,7)).toUpperCase());
			//System.out.println(servidorArea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getLocalizedMessage());
		}
		
		
		return null;
	}
	
	public String recuperarServidores() {
		servidores = sercBuss.recuperarServidores();
		
		for(SERVIDOR ser : servidores) {
			System.out.println(ser);
		}
		
		return null;
	}
	
	 
	
	public String enviarFullTime() {
		List<SERVIDOR> aux = new ArrayList<SERVIDOR>();
		SERVIDOR auxs = new SERVIDOR();
		EMPLEADO auxe = new EMPLEADO();
		
		System.out.println("Boton enviarFullTime");
		System.out.println(servidorArea);
		
		
		try {
			auxs = sercBuss.recuperarServidor(servidorArea.getCedulaServidor());
			auxe.setEMPL_ID(10000);
			auxe.setNOMBRE(auxs.getPRIMER_NOMBRE());
			auxe.setAPELLIDO(auxs.getAPELLIDO_PATERNO()+" "+auxs.getAPELLIDO_MATERNO());
			auxe.setCIUD_ID(2);
			if(auxs.getSEXO().equals("M")) {
				auxe.setSEXO(1);
			}
			else {
				auxe.setSEXO(2);
			}
			
			auxe.setHORAS_TRABAJA(0);
			auxe.setCEDULA(auxs.getCEDULA());
			auxe.setDEPA_ID(vCodigoDepartamento);
			auxe.setCORREO("rrhh@cuenca.gob.ec");
			auxe.setFECHA_NACIMIENTO(auxs.getFECHA_NACIMIENTO());
			auxe.setID(auxs.getBIOMETRICO()); //Codigo del reloj biometrico
			auxe.setCARG_ID(vCodigoCargo); // codigo de cargo
			auxe.setESTADO(5);
			auxe.setESTADO_CIVIL(8); //
			auxe.setDGCO_ID(1);
			
			System.out.println("EMPLEADO>>>>>>>>>>>>");
			System.out.println(auxe);
			//sercBuss.guardarEmpleado(auxe);
			
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return null;
	}
	

	public List<ServidorArea> getServidorAreas() {
		return servidorAreas;
	}

	public void setServidorAreas(List<ServidorArea> servidorAreas) {
		this.servidorAreas = servidorAreas;
	}

	public int getvCodigoServidor() {
		return vCodigoServidor;
	}

	public void setvCodigoServidor(int vCodigoServidor) {
		this.vCodigoServidor = vCodigoServidor;
	}

	public List<ServidorArea> getFilterServidorArea() {
		return filterServidorArea;
	}

	public void setFilterServidorArea(List<ServidorArea> filterServidorArea) {
		this.filterServidorArea = filterServidorArea;
	}
	
	//Departamentos set and get
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public List<Departamento> getFilterDepartamentos() {
		return filterDepartamentos;
	}

	public void setFilterDepartamentos(List<Departamento> filterDepartamentos) {
		this.filterDepartamentos = filterDepartamentos;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public ServidorArea getServidorArea() {
		return servidorArea;
	}

	public void setServidorArea(ServidorArea servidorArea) {
		this.servidorArea = servidorArea;
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
	
}
