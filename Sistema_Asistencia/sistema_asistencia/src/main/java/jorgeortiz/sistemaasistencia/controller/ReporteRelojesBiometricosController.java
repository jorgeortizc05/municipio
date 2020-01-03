package jorgeortiz.sistemaasistencia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.DefaultStreamedContent;

import jorgeortiz.sistemaasistencia.bussiness.ReporteRelojesBiometricosBussiness;
import jorgeortiz.sistemaasistencia.bussiness.EmpleadoBussiness;
import jorgeortiz.sistemaasistencia.bussiness.ServidorAreaBussiness;
import jorgeortiz.sistemaasistencia.dao.MainJustDAO;
import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoDepartamentoSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoPersonaSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.DEPARTAMENTO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.fulltime.model.NumPersonaPorBiometricoSQL;
import jorgeortiz.sistemaasistencia.nomina.model.ACC_PER;
import jorgeortiz.sistemaasistencia.nomina.model.BJUSTIF;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;
import jorgeortiz.sistemaasistencia.util.FormatterDate;
import jorgeortiz.sistemaasistencia.util.Mensajes;

@ManagedBean
@ViewScoped
public class ReporteRelojesBiometricosController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ReporteRelojesBiometricosBussiness rbBuss;
	
	@Inject
	private ServidorAreaBussiness seraBuss;
	
	@Inject
	private EmpleadoBussiness empBuss;
	
	@Inject
	private MainJustDAO justDAO;
	
	@Inject
	private MainReporteDAO mdao;
	
	private List<BiometricoPersonaSQL> biometricoPersonas;
	
	private List<BiometricoDepartamentoSQL> biometricoDepartamentos;
	
	private List<DEPARTAMENTO> departamentos;
	
	private List<EMPLEADO> empleados;
	
	private List<BJUSTIF> justificaciones;
	
	private List<ACC_PER> acciones;
	
	private List<CARGO> cargos;
	
	private List<NumPersonaPorBiometricoSQL> listNumPersPorBiometricos;
	
	private SERVIDOR newServidor;
	
	private EMPLEADO newEmpleado;
	
	//Varibles
	private String vCodigoBiometrico;
	private Date vFechaDesde;
	private Date vFechaHasta;
	private String nombresServidor;
	private DefaultStreamedContent myImage;
	private int vCodigoDepartamento;
	private String vMotivoPermiso;
	
	@PostConstruct
	public void init() {
		
		newServidor = new SERVIDOR();
		
		departamentos = mdao.getDepartamentos();
		
		cargos = mdao.getCargos();
		
		try {
			empleados = rbBuss.getEmpleados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "No hay empleados");
            facesContext.addMessage(null, m);
		}
	}
	
	public String recuperarBiometricoPersonas() {
		myImage=new DefaultStreamedContent();
		try {
			System.out.println("Fecha Desde controller: "+vFechaDesde);
			System.out.println("Fecha Hasta controller: "+vFechaHasta);
			biometricoPersonas = rbBuss.getBiometricoPersonas(vCodigoBiometrico, vFechaDesde, vFechaHasta);
			newEmpleado = empBuss.getEmpleadoCodigo(vCodigoBiometrico);
			newServidor = seraBuss.getServidor(newEmpleado.getCEDULA());
			nombresServidor = newServidor.getAPELLIDO_PATERNO()+" "+newServidor.getAPELLIDO_MATERNO()+" "+newServidor.getPRIMER_NOMBRE()+" "+newServidor.getSEGUNDO_NOMBRE();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String fd = FormatterDate.formatearFecha(vFechaDesde);
			String fh = FormatterDate.formatearFecha(vFechaHasta);
			Date sdate = formatter.parse(fd);
			Date rdate1 = formatter.parse(fh);
			justificaciones = justDAO.getBjustPersona(newServidor.getCEDULA(), vFechaDesde, vFechaHasta);
			
			acciones = justDAO.getAccPer(newServidor.getCEDULA(), sdate, rdate1);
			checkMotivoPermiso(acciones);
			Mensajes.addMessage("Solicitud Procesada");
			
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		
		return null;
	}
	
	public String recuperarBiometricoDepartamentos() {
		
		try {
			biometricoDepartamentos = rbBuss.getBiometricoDepartamentos(vCodigoDepartamento, vFechaDesde, vFechaHasta);
			Mensajes.addMessage("Solicitud Procesada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		
		
		return null;
	}
	
	public String recuperarNumPersPorBiometrico() {
		
		try {
			listNumPersPorBiometricos = rbBuss.getListNumPersonaPorBiometrico(vFechaDesde, vFechaHasta);
			for(NumPersonaPorBiometricoSQL npb : listNumPersPorBiometricos) {
				System.out.println(npb);
			}
			Mensajes.addMessage("Solicitud Procesada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		
		
		return null;
	}
	
	public String recuperarTodosDepartamentos() {
		
		try {
			biometricoDepartamentos = rbBuss.getFechaDepartamentos(vFechaDesde, vFechaHasta);
			Mensajes.addMessage("Solicitud Procesada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		
		
		return null;
	}
	
	
	public void checkMotivoPermiso(List<ACC_PER> items) {
		for (ACC_PER a : items) {
			if (a.getACCION().equals("LSM")) {
				a.setACCION("AP LICENCIA CON MATERNIDAD");
			}
			if (a.getACCION().equals("TC1")) {
				a.setACCION("TERMINACION DEL CONTRATO OCASIONAL");
			}
			if (a.getACCION().equals("TN1")) {
				a.setACCION("TERMINACION DE NOMBRAMIENTO PROVISIONAL A PRUEBA");
			}
			if (a.getACCION().equals("TA6")) {
				a.setACCION("TERMINACION ANTICIPADA DE COMISION DE SERVICIOS CON REMUNERACIONES");
			}
			if (a.getACCION().equals("TNR")) {
				a.setACCION("TERMINACION DE NOMBRAMIENTO REGULAR");
			}
			if (a.getACCION().equals("TAC")) {
				a.setACCION("TERMINACION ANTICIPADA DE COMISION DE SERVICIOS SIN REMUNERACION");
			}
			if (a.getACCION().equals("PCF")) {
				a.setACCION("PERMISO PARA EL CUIDADO DE FAMILIARES");
			}
			if (a.getACCION().equals("TSE")) {
				a.setACCION("TERMINACION DE SUBROGACION O ENCARGO");
			}
			if (a.getACCION().equals("CNP")) {
				a.setACCION("TERMINACION DEL NOMBRAMIENTO PROVISIONAL");
			}
			if (a.getACCION().equals("FIN")) {
				a.setACCION("REINTEGRO/CONCLUSION DE COMISION DE SERVICIOS");
			}
			if (a.getACCION().equals("RNL")) {
				a.setACCION("TERMINACION DE NOMBRAMIENTO DE LIBRE REMOCION");
			}
			if (a.getACCION().equals("LAL")) {
				a.setACCION("PERMISO PARA EL CUIDADO DEL RECIEN NACIDO");
			}
			if (a.getACCION().equals("ACR")) {
				a.setACCION("ACEPTACION DE LA RENUNCIA");
			}
			if (a.getACCION().equals("VBU")) {
				a.setACCION("TERMINACION DE RELACION LABORAL");
			}
			if (a.getACCION().equals("A_R")) {
				a.setACCION("ACEPTAR LA RENUNCIA");
			}
			if (a.getACCION().equals("LSP")) {
				a.setACCION("AP LICENCIA CON PATERNIDAD");
			}
			if (a.getACCION().equals("VAC")) {
				a.setACCION("AP VACACIONES");
			}
			if (a.getACCION().equals("CAP")) {
				a.setACCION("CAPACITACION");
			}
			if (a.getACCION().equals("LSL")) {
				a.setACCION("LICENCIA CON REMUNERACION");
			}
			if (a.getACCION().equals("LSS")) {
				a.setACCION("LICENCIA SIN REMUNERACION");
			}
			if (a.getACCION().equals("Z")) {
				a.setACCION("OTRAS");
			}
			if (a.getACCION().equals("DCS")) {
				a.setACCION("DECLARAR EN COMISION DE SERVICIO");
			}
			if (a.getACCION().equals("CCR")) {
				a.setACCION("COMISION DE SERVICIOS CON REMUNERACION");
			}
			if (a.getACCION().equals("CSR")) {
				a.setACCION("COMISION DE SERVICIOS SIN REMUNERACION");
			}
		}
	}
	
	public String checkCargo(Integer cod_servidor) {
		Integer cargo = null;
		for (EMPLEADO e : this.getEmpleados()) {
			if (e.getCEDULA().equals(newServidor.getCEDULA())) {
				cargo = e.getCARG_ID();
			}
		}

		for (CARGO c : cargos) {
			if (c.getCARG_ID().equals(cargo)) {
				return c.getDESCRIPCION();
			}
		}
		return "Sin cargo";
	}
	
	public String checkNombresYapellidosServidor(Integer cod_servidor) {
		if (newServidor.getCODIGO().equals(cod_servidor)) {
			String n = newServidor.getAPELLIDO_PATERNO() + " " + newServidor.getAPELLIDO_MATERNO() + " " + newServidor.getPRIMER_NOMBRE() + " "
					+ newServidor.getSEGUNDO_NOMBRE();
			return n;
		}
		
		return "Sin código servidor";
	}
	
	public String checkTiempo(Date fecha) throws ParseException {
		if (fecha != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dates = fecha;
			return formatter.format(dates);
		} else
			return "sin fecha";

	}


	public String getvCodigoBiometrico() {
		return vCodigoBiometrico;
	}


	public void setvCodigoBiometrico(String vCodigoBiometrico) {
		this.vCodigoBiometrico = vCodigoBiometrico;
	}


	public Date getvFechaDesde() {
		return vFechaDesde;
	}


	public void setvFechaDesde(Date vFechaDesde) {
		this.vFechaDesde = vFechaDesde;
	}


	public Date getvFechaHasta() {
		return vFechaHasta;
	}


	public void setvFechaHasta(Date vFechaHasta) {
		this.vFechaHasta = vFechaHasta;
	}


	public List<EMPLEADO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EMPLEADO> empleados) {
		this.empleados = empleados;
	}

	public List<BiometricoPersonaSQL> getBiometricoPersonas() {
		return biometricoPersonas;
	}


	public void setBiometricoPersonas(List<BiometricoPersonaSQL> biometricoPersonas) {
		this.biometricoPersonas = biometricoPersonas;
	}

	public SERVIDOR getNewServidor() {
		return newServidor;
	}

	public void setNewServidor(SERVIDOR newServidor) {
		this.newServidor = newServidor;
	}

	public String getNombresServidor() {
		return nombresServidor;
	}

	public void setNombresServidor(String nombresServidor) {
		this.nombresServidor = nombresServidor;
	}

	public DefaultStreamedContent getMyImage() {
		return myImage;
	}

	public void setMyImage(DefaultStreamedContent myImage) {
		this.myImage = myImage;
	}

	public List<DEPARTAMENTO> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DEPARTAMENTO> departamentos) {
		this.departamentos = departamentos;
	}

	public List<BiometricoDepartamentoSQL> getBiometricoDepartamentos() {
		return biometricoDepartamentos;
	}

	public void setBiometricoDepartamentos(List<BiometricoDepartamentoSQL> biometricoDepartamentos) {
		this.biometricoDepartamentos = biometricoDepartamentos;
	}

	public int getvCodigoDepartamento() {
		return vCodigoDepartamento;
	}

	public void setvCodigoDepartamento(int vCodigoDepartamento) {
		this.vCodigoDepartamento = vCodigoDepartamento;
	}

	public List<BJUSTIF> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(List<BJUSTIF> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public List<ACC_PER> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<ACC_PER> acciones) {
		this.acciones = acciones;
	}

	public String getvMotivoPermiso() {
		return vMotivoPermiso;
	}

	public void setvMotivoPermiso(String vMotivoPermiso) {
		this.vMotivoPermiso = vMotivoPermiso;
	}

	public List<NumPersonaPorBiometricoSQL> getListNumPersPorBiometricos() {
		return listNumPersPorBiometricos;
	}
	
	
	
	
	
}
