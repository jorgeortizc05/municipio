package jorgeortiz.sistemaasistencia.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.CIUDAD;
import jorgeortiz.sistemaasistencia.fulltime.model.DEPARTAMENTO;
import jorgeortiz.sistemaasistencia.fulltime.model.DETALLE_GRUPO_CONTRATADO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO_GRUPO;
import jorgeortiz.sistemaasistencia.fulltime.model.GRUPO_CONTRATADO;
import jorgeortiz.sistemaasistencia.fulltime.model.PROVINCIA;
import jorgeortiz.sistemaasistencia.fulltime.model.REGION;
import jorgeortiz.sistemaasistencia.fulltime.model.RELOJ;
import jorgeortiz.sistemaasistencia.fulltime.model.TIMBRE;
import jorgeortiz.sistemaasistencia.fulltime.model.TIPO_CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.USUARIOS;

@ManagedBean
@ViewScoped
public class MainReportView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private SesionController sesionController;
	@Inject
	private MainReporteDAO dao;

	private String codigo;
	private String cedula;
	private String apellido;

	private List<CIUDAD> ciudades;
	private List<PROVINCIA> provincias;
	private List<REGION> regiones;
	private List<DEPARTAMENTO> departamentos;
	private List<RELOJ> relojes;
	private List<CARGO> cargos;
	private List<TIPO_CARGO> tiposCargos;

	private List<EMPLEADO_GRUPO> empleados_grupos;
	private List<DETALLE_GRUPO_CONTRATADO> detalle_g_contratados;
	private List<TIMBRE> timbres;
	private List<GRUPO_CONTRATADO> grupo_contratados;
	private List<USUARIOS> usuarios;
	private List<EMPLEADO> navEmpleados;

	@PostConstruct
	public void init() {
//		empleados=dao.getEmpleados();
//		ciudades=dao.getCiudades();
//		provincias=dao.getProvincias();
//		regiones=dao.getRegiones();
//		departamentos=dao.getDepartamentos();
//		relojes=dao.getRelojes();
//		cargos=dao.getCargos();
//		tiposCargos=dao.getTipoCargos();
//		empleados_grupos=dao.getEmpleadogrupos();
//		detalle_g_contratados=dao.getDetalleGruposContratados();
//		timbres=dao.getTimbres();
//		grupo_contratados=dao.getGruposcontratados();
//		usuarios=dao.getUsuarios();
	}

	public void busqNavEmpleado(ActionEvent actionEvent) throws IOException {
		int cont = 0;
		try {
			if (!this.getCodigo().isEmpty())
				cont = cont + 1;
			if (!this.getCedula().isEmpty())
				cont = cont + 1;
			if (!this.getApellido().isEmpty())
				cont = cont + 1;
			if (sesionController.isEstado()) {
				if (cont == 1) {
					navEmpleados = null;
					if (!this.getCodigo().isEmpty()) {
						// navEmpleados=dao.getEmpleadosNav(this.getCodigo(), 1);
						this.setNavEmpleados(dao.getEmpleadosNav(this.getCodigo(), 1));
						if (!navEmpleados.isEmpty()) {
//							for(EMPLEADO e:this.getNavEmpleados()){
//								System.out.println("emp> "+e.getCEDULA());
//								System.out.println("emp> "+e.getNOMBRE());
//							}
						} else
							addMessage("Sin resultados!!");
					}
					if (!this.getCedula().isEmpty()) {
						// navEmpleados=dao.getEmpleadosNav(this.getCedula(), 2);
						this.setNavEmpleados(dao.getEmpleadosNav(this.getCedula(), 2));
						if (!navEmpleados.isEmpty()) {
//							for(EMPLEADO e:this.getNavEmpleados()){
//								System.out.println("emp> "+e.getCEDULA());
//								System.out.println("emp> "+e.getNOMBRE());
//							}
						} else
							addMessage("Sin resultados!!");

					}
					if (!this.getApellido().isEmpty()) {
						// navEmpleados=dao.getEmpleadosNav(this.getApellido().toUpperCase(), 3);
						this.setNavEmpleados(dao.getEmpleadosNav(this.getApellido().toUpperCase(), 3));
						if (!navEmpleados.isEmpty()) {
//							for(EMPLEADO e:this.getNavEmpleados()){
//								System.out.println("emp> "+e.getCEDULA());
//								System.out.println("emp> "+e.getNOMBRE());
//							}
						} else
							addMessage("Sin resultados!!");
					}

				} else
					addMessage("Admite solo un criterio de busqueda!!");

			} else
				addMessage("No logueado!!");
		} catch (Exception e) {
			addMessage("No logueado!!");
			throw e;
		}

	}

	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void doProcess() {
//		System.out.println("Entro a doProcess");
//		int a1=0;
//		for(EMPLEADO e:empleados){
//			System.out.print(e.getEMPL_ID());
//			System.out.print(e.getCEDULA());
//			System.out.print(e.getAPELLIDO());
//			System.out.print(e.getNOMBRE());
//			System.out.print(e.getCORREO());
//			System.out.println("Biometrico>> "+e.getCODIGO_EMPLEADO());
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);
//		
//		System.out.println("Entro a doProcess");
//		int a=0;
//		for(CIUDAD e:ciudades){
//			System.out.print(e.getCODIGO()+" ");
//			System.out.println(e.getNIVEL());
//			a++;
//			
//		}
//		System.out.println("Registros>>>>>>>> "+a);
//		 a=0;
//		for(PROVINCIA e:provincias){
//			System.out.print(e.getCODIGO()+" ");
//			System.out.println(e.getDESCRIPCION());
//			a++;
//			
//		}
//		System.out.println("Registros>>>>>>>> "+a);
//		 a=0;
//			for(REGION e:regiones){
//				System.out.print(e.getCODIGO()+" ");
//				System.out.println(e.getDESCRIPCION());
//				a++;
//				
//			}
//			System.out.println("Registros>>>>>>>> "+a);
//		

//		System.out.println("Entro a doProcess");
//		int a1=0;
//		for(DEPARTAMENTO e:departamentos){
//			System.out.print(e.getDEPA_ID()+" ");
//			System.out.println(e.getDESCRIPCION());
//
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);
//		a1=0;
//		for(RELOJ e:relojes){
//			System.out.print(e.getRELO_ID()+" ");
//			System.out.println(e.getDESCRIPCION());
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);
//		a1=0;
//		for(CARGO e:cargos){
//			System.out.print(e.getCARG_ID()+" ");
//			System.out.println(e.getDESCRIPCION());
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);
//		a1=0;
//		for(TIPO_CARGO e:tiposCargos){
//			System.out.print(e.getTICA_ID()+" ");
//			System.out.println(e.getDESCRIPCION());
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);

//		System.out.println("Entro a doProcess");
//		int a1=0;
//		for(EMPLEADO_GRUPO e:empleados_grupos){
//			System.out.print(e.getEMGR_ID()+" ");
//			System.out.println(e.getDESCRIPCION());
//
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);
//
//		a1=0;
//		for(DETALLE_GRUPO_CONTRATADO e:detalle_g_contratados){
//			System.out.print(e.getDESCRIPCION()+" ");
//			System.out.println(e.getHORAS_VACACION());
//
//			a1++;
//			
//		}

//		int a1=0;
//		for(USUARIOS e:usuarios){
//			System.out.print(e.getUSUARIO()+" ");
//			System.out.println(e.getCONTRASENA());
//
//			a1++;
//			
//		}
//		System.out.println("Registros>>>> "+a1);

	}

	public String checkDepartamento(String id) {
		Integer aux = new Integer(id);
		String dep = dao.getDepartamento(aux);
		return dep;
	}

	public List<EMPLEADO> getEmpleados() {
		return dao.getEmpleados();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<CIUDAD> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CIUDAD> ciudades) {
		this.ciudades = ciudades;
	}

	public List<PROVINCIA> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<PROVINCIA> provincias) {
		this.provincias = provincias;
	}

	public List<REGION> getRegiones() {
		return regiones;
	}

	public void setRegiones(List<REGION> regiones) {
		this.regiones = regiones;
	}

	public List<DEPARTAMENTO> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DEPARTAMENTO> departamentos) {
		this.departamentos = departamentos;
	}

	public List<RELOJ> getRelojes() {
		return relojes;
	}

	public void setRelojes(List<RELOJ> relojes) {
		this.relojes = relojes;
	}

	public List<CARGO> getCargos() {
		return cargos;
	}

	public void setCargos(List<CARGO> cargos) {
		this.cargos = cargos;
	}

	public List<TIPO_CARGO> getTiposCargos() {
		return tiposCargos;
	}

	public void setTiposCargos(List<TIPO_CARGO> tiposCargos) {
		this.tiposCargos = tiposCargos;
	}

	public List<EMPLEADO_GRUPO> getEmpleados_grupos() {
		return empleados_grupos;
	}

	public void setEmpleados_grupos(List<EMPLEADO_GRUPO> empleados_grupos) {
		this.empleados_grupos = empleados_grupos;
	}

	public List<DETALLE_GRUPO_CONTRATADO> getDetalle_g_contratados() {
		return detalle_g_contratados;
	}

	public void setDetalle_g_contratados(List<DETALLE_GRUPO_CONTRATADO> detalle_g_contratados) {
		this.detalle_g_contratados = detalle_g_contratados;
	}

	public List<TIMBRE> getTimbres() {
		return timbres;
	}

	public void setTimbres(List<TIMBRE> timbres) {
		this.timbres = timbres;
	}

	public List<GRUPO_CONTRATADO> getGrupo_contratados() {
		return grupo_contratados;
	}

	public void setGrupo_contratados(List<GRUPO_CONTRATADO> grupo_contratados) {
		this.grupo_contratados = grupo_contratados;
	}

	public List<USUARIOS> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<USUARIOS> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<EMPLEADO> getNavEmpleados() {
		return navEmpleados;
	}

	public void setNavEmpleados(List<EMPLEADO> navEmpleados) {
		this.navEmpleados = navEmpleados;
	}

	public SesionController getSesionController() {
		return sesionController;
	}

	public void setSesionController(SesionController sesionController) {
		this.sesionController = sesionController;
	}

	public MainReporteDAO getDao() {
		return dao;
	}

	public void setDao(MainReporteDAO dao) {
		this.dao = dao;
	}

}
