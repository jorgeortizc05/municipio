package jorgeortiz.sistemaasistencia.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import jorgeortiz.sistemaasistencia.bussiness.ReporteBiometricoBussiness;
import jorgeortiz.sistemaasistencia.bussiness.EmpleadoBussiness;
import jorgeortiz.sistemaasistencia.bussiness.ServidorAreaBussiness;
import jorgeortiz.sistemaasistencia.dao.MainJustDAO;
import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoDepartamentoSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoPersonaSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.DEPARTAMENTO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.ACC_PER;
import jorgeortiz.sistemaasistencia.nomina.model.BJUSTIF;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;
import jorgeortiz.sistemaasistencia.util.FormatterDate;

@ManagedBean
@ViewScoped
public class BiometricoPersonaController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ReporteBiometricoBussiness bpBuss;
	
	@Inject
	private ServidorAreaBussiness seraBuss;
	
	@Inject
	private EmpleadoBussiness empBuss;
	
	@Inject
	private MainJustDAO justDAO;
	
	@Inject
	private MainReporteDAO mdao;
	
	
	private ParamReportController prc;
	
	private List<BiometricoPersonaSQL> biometricoPersonas;
	private BiometricoPersonaSQL newBiometricoPersona;
	
	private List<BiometricoDepartamentoSQL> biometricoDepartamentos;
	private BiometricoDepartamentoSQL newBiometricoDepartamento;
	
	private List<DEPARTAMENTO> departamentos;
	
	private List<EMPLEADO> empleados;
	
	private List<BJUSTIF> justificaciones;
	
	private List<ACC_PER> acciones;
	
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
		newBiometricoPersona = new BiometricoPersonaSQL();
		newBiometricoDepartamento = new BiometricoDepartamentoSQL();
		
		//departamentos = mdao.getDepartamentos();
		
		prc = new ParamReportController();
		
		try {
			//empleados = bpBuss.getEmpleados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
	}
	
	public String recuperarBiometricoPersonas() {
		myImage=new DefaultStreamedContent();
		try {
			System.out.println("Fecha Desde controller: "+vFechaDesde);
			System.out.println("Fecha Hasta controller: "+vFechaHasta);
			biometricoPersonas = bpBuss.getBiometricoPersonas(vCodigoBiometrico, vFechaDesde, vFechaHasta);
			
			newBiometricoPersona = biometricoPersonas.get(0);
			
			if(newBiometricoPersona == null) {
				nombresServidor = "";
			}
			
			newServidor = seraBuss.getServidor(newBiometricoPersona.getCedula());
			nombresServidor = newServidor.getAPELLIDO_PATERNO()+" "+newServidor.getAPELLIDO_MATERNO()+" "+newServidor.getPRIMER_NOMBRE()+" "+newServidor.getSEGUNDO_NOMBRE();
			
			InputStream is = new ByteArrayInputStream((byte[]) newServidor.getNUEVA_FOTO());
			System.out.println("Informacion IS:"+is);
			this.setMyImage(new DefaultStreamedContent(is, "image/jpeg"));
			System.out.println("Informacion MyImage"+myImage);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String fd = FormatterDate.formatearFecha(vFechaDesde);
			String fh = FormatterDate.formatearFecha(vFechaHasta);
			Date sdate = formatter.parse(fd);
			Date rdate1 = formatter.parse(fh);
			justificaciones = justDAO.getBjustPersona(newBiometricoPersona.getCedula(), sdate, rdate1);
			
			acciones = justDAO.getAccPer(newBiometricoPersona.getCedula(), sdate, rdate1);
			
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
			biometricoDepartamentos = bpBuss.getBiometricoDepartamentos(vCodigoDepartamento, vFechaDesde, vFechaHasta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		
		
		return null;
	}
	
	/*
	public String checkMotivoPermiso() {
		for (ACC_PER a : acciones) {
			if (a.getACCION().equals("LSM")) {
				return "AP LICENCIA CON MATERNIDAD";
			}
			if (a.getACCION().equals("LSP")) {
				return "AP LICENCIA CON PATERNIDAD";
			}
			if (a.getACCION().equals("VAC")) {
				return "AP VACACIONES";
			}
			if (a.getACCION().equals("CAP")) {
				return "CAPACITACION";
			}
			if (a.getACCION().equals("LSL")) {
				return "LICENCIA CON REMUNERACION";
			}
			if (a.getACCION().equals("LSS")) {
				return "LICENCIA SIN REMUNERACION";
			}
			if (a.getACCION().equals("Z")) {
				return "OTRAS";
			}
			if (a.getACCION().equals("DCS")) {
				return "DECLARAR EN COMISION DE SERVICIO";
			}
			if (a.getACCION().equals("CCR")) {
				return "COMISION DE SERVICIOS CON REMUNERACION";
			}
			if (a.getACCION().equals("CSR")) {
				return "COMISION DE SERVICIOS SIN REMUNERACION";
			}
		}
		return "Sin decode";
	}*/


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
	
	

	
	
	
}
