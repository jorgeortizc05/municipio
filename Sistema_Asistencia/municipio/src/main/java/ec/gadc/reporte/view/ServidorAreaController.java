package ec.gadc.reporte.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gadc.reporte.bussiness.DepartamentoBussiness;
import ec.gadc.reporte.bussiness.ServidorAreaBussiness;
import ec.muni.fulltime.model.Departamento;
import ec.muni.nomina.model.ServidorArea;

@ManagedBean
@ViewScoped
public class ServidorAreaController {
	
	//Servidor, cargo y departamentos
	private ServidorAreaBussiness sercBuss;
	private List<ServidorArea> servidorAreas;
	private List<ServidorArea> filterServidorArea; //Para filtrar cservidorAreas
	
	private DepartamentoBussiness depBuss;
	private List<Departamento> departamentos;
	private List<Departamento> filterDepartamentos;
	
	//Variables
	private int vCodigoServidor;
	private String vDescripcion;
	
	@PostConstruct
	public void init() {
		vCodigoServidor = 0;
		sercBuss = new ServidorAreaBussiness();
		depBuss = new DepartamentoBussiness();
	}

	public String loadServidorCargo() {
		
		servidorAreas = sercBuss.recuperarDatosServidor(vCodigoServidor);
		
		for(ServidorArea sc: servidorAreas) {
			System.out.println(sc);
		}
		
		return null;
	}
	
	public String loadDepartamentos() {
		
		departamentos = depBuss.recuperarDatosDepartamento((vDescripcion).toUpperCase());
		
		for(Departamento d: departamentos) {
			System.out.println(d);
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
	
	
	
	
	
}
