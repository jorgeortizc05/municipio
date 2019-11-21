package jorgeortiz.sistemaasistencia.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.CARGO;
import jorgeortiz.sistemaasistencia.fulltime.model.CIUDAD;
import jorgeortiz.sistemaasistencia.fulltime.model.DEPARTAMENTO;
import jorgeortiz.sistemaasistencia.fulltime.model.DETALLE_GRUPO_CONTRATADO;
import jorgeortiz.sistemaasistencia.fulltime.model.ROLES;

@ManagedBean
@ViewScoped
public class NewUSRController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SesionController sesionController;
	@Inject
	private MainReporteDAO mainDao;
	private String codigo_reloj;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fecha_nacimiento;
	private Integer estado_civil;
	private Integer sexo;
	private Integer filtro_ciudad;
	private Integer filtro_dep;
	private Integer filtro_cargo;
	private Integer filtro_regimen;
	private Integer filtro_rol;
	private Integer horas_trabaja;
	private Double sueldo;
	private Integer cont_vacacion;
	private String usuario;
	private String clave;
	private List<DEPARTAMENTO> departamentos;
	private List<CIUDAD> ciudades;
	private List<CARGO> cargos;
	private List<DETALLE_GRUPO_CONTRATADO> regimenes;
	private List<ROLES> roles;

	@PostConstruct
	public void init() {
		departamentos = mainDao.getDepartamentos();
		ciudades = mainDao.getCiudades();
		cargos = mainDao.getCargos();
		regimenes = mainDao.getDetalleGruposContratados();
		roles = mainDao.getRoles();
	}

	public MuestraOptionMenu[] mostrarMenuRol;

	public MuestraOptionMenu[] sendRoles() {
		int cont = 0;
		mostrarMenuRol = new MuestraOptionMenu[this.getRoles().size()];
		for (ROLES r : this.getRoles()) {
			mostrarMenuRol[cont] = new MuestraOptionMenu(r.getDESCRIPCION(), r.getID());
			cont++;
		}
		return mostrarMenuRol;
	}

	public MuestraOptionMenu[] mostrarMenuRegim;

	public MuestraOptionMenu[] sendRegimenes() {
		int cont = 0;
		mostrarMenuRegim = new MuestraOptionMenu[this.getRegimenes().size()];
		for (DETALLE_GRUPO_CONTRATADO det : this.getRegimenes()) {
			mostrarMenuRegim[cont] = new MuestraOptionMenu(det.getDESCRIPCION(), det.getDGCO_ID());
			cont++;
		}
		return mostrarMenuRegim;
	}

	public MuestraOptionMenu[] mostrarMenuCarg;

	public MuestraOptionMenu[] sendCargos() {
		int cont = 0;
		mostrarMenuCarg = new MuestraOptionMenu[this.getCargos().size()];
		for (CARGO c : this.getCargos()) {
			mostrarMenuCarg[cont] = new MuestraOptionMenu(c.getDESCRIPCION(), c.getCARG_ID());
			cont++;
		}
		return mostrarMenuCarg;
	}

	public MuestraOptionMenu[] mostrarMenuDep;

	public MuestraOptionMenu[] sendDepartamentos() {
		int cont = 0;
		mostrarMenuDep = new MuestraOptionMenu[this.getDepartamentos().size()];
		for (DEPARTAMENTO de : this.getDepartamentos()) {
			mostrarMenuDep[cont] = new MuestraOptionMenu(de.getDESCRIPCION(), de.getDEPA_ID());
			cont++;
		}
		return mostrarMenuDep;
	}

	public getCiudad[] mostrarMenuCiu;

	public getCiudad[] sendCiudades() {
		int cont = 0;
		mostrarMenuCiu = new getCiudad[this.ciudades.size()];
		for (CIUDAD ci : this.getCiudades()) {
			mostrarMenuCiu[cont] = new getCiudad(ci.getDESCRIPCION(), ci.getCIUD_ID());
			cont++;
		}
		return mostrarMenuCiu;
	}

	public static class getCiudad {
		public String etiqueta_ciudad;
		public Integer id_ciudad;

		public getCiudad(String etiqueta_ciudad, Integer id_ciudad) {
			this.etiqueta_ciudad = etiqueta_ciudad;
			this.id_ciudad = id_ciudad;
		}

		public String getEtiqueta_ciudad() {
			return etiqueta_ciudad;
		}

		public void setEtiqueta_ciudad(String etiqueta_ciudad) {
			this.etiqueta_ciudad = etiqueta_ciudad;
		}

		public Integer getId_ciudad() {
			return id_ciudad;
		}

		public void setId_ciudad(Integer id_ciudad) {
			this.id_ciudad = id_ciudad;
		}

	}

	public String getCodigo_reloj() {
		return codigo_reloj;
	}

	public void setCodigo_reloj(String codigo_reloj) {
		this.codigo_reloj = codigo_reloj;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(Integer estado_civil) {
		this.estado_civil = estado_civil;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getFiltro_ciudad() {
		return filtro_ciudad;
	}

	public void setFiltro_ciudad(Integer filtro_ciudad) {
		this.filtro_ciudad = filtro_ciudad;
	}

	public List<DEPARTAMENTO> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DEPARTAMENTO> departamentos) {
		this.departamentos = departamentos;
	}

	public List<CIUDAD> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CIUDAD> ciudades) {
		this.ciudades = ciudades;
	}

	public Integer getFiltro_dep() {
		return filtro_dep;
	}

	public void setFiltro_dep(Integer filtro_dep) {
		this.filtro_dep = filtro_dep;
	}

	public Integer getFiltro_cargo() {
		return filtro_cargo;
	}

	public void setFiltro_cargo(Integer filtro_cargo) {
		this.filtro_cargo = filtro_cargo;
	}

	public List<CARGO> getCargos() {
		return cargos;
	}

	public void setCargos(List<CARGO> cargos) {
		this.cargos = cargos;
	}

	public List<DETALLE_GRUPO_CONTRATADO> getRegimenes() {
		return regimenes;
	}

	public void setRegimenes(List<DETALLE_GRUPO_CONTRATADO> regimenes) {
		this.regimenes = regimenes;
	}

	public Integer getFiltro_regimen() {
		return filtro_regimen;
	}

	public void setFiltro_regimen(Integer filtro_regimen) {
		this.filtro_regimen = filtro_regimen;
	}

	public Integer getHoras_trabaja() {
		return horas_trabaja;
	}

	public void setHoras_trabaja(Integer horas_trabaja) {
		this.horas_trabaja = horas_trabaja;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getCont_vacacion() {
		return cont_vacacion;
	}

	public void setCont_vacacion(Integer cont_vacacion) {
		this.cont_vacacion = cont_vacacion;
	}

	public Integer getFiltro_rol() {
		return filtro_rol;
	}

	public void setFiltro_rol(Integer filtro_rol) {
		this.filtro_rol = filtro_rol;
	}

	public List<ROLES> getRoles() {
		return roles;
	}

	public void setRoles(List<ROLES> roles) {
		this.roles = roles;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public SesionController getSesionController() {
		return sesionController;
	}

	public void setSesionController(SesionController sesionController) {
		this.sesionController = sesionController;
	}

	public MainReporteDAO getMainDao() {
		return mainDao;
	}

	public void setMainDao(MainReporteDAO mainDao) {
		this.mainDao = mainDao;
	}

	public MuestraOptionMenu[] getMostrarMenuRol() {
		return mostrarMenuRol;
	}

	public void setMostrarMenuRol(MuestraOptionMenu[] mostrarMenuRol) {
		this.mostrarMenuRol = mostrarMenuRol;
	}

	public MuestraOptionMenu[] getMostrarMenuRegim() {
		return mostrarMenuRegim;
	}

	public void setMostrarMenuRegim(MuestraOptionMenu[] mostrarMenuRegim) {
		this.mostrarMenuRegim = mostrarMenuRegim;
	}

	public MuestraOptionMenu[] getMostrarMenuCarg() {
		return mostrarMenuCarg;
	}

	public void setMostrarMenuCarg(MuestraOptionMenu[] mostrarMenuCarg) {
		this.mostrarMenuCarg = mostrarMenuCarg;
	}

	public MuestraOptionMenu[] getMostrarMenuDep() {
		return mostrarMenuDep;
	}

	public void setMostrarMenuDep(MuestraOptionMenu[] mostrarMenuDep) {
		this.mostrarMenuDep = mostrarMenuDep;
	}

	public getCiudad[] getMostrarMenuCiu() {
		return mostrarMenuCiu;
	}

	public void setMostrarMenuCiu(getCiudad[] mostrarMenuCiu) {
		this.mostrarMenuCiu = mostrarMenuCiu;
	}

}
