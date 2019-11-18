package ec.gadc.reporte.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.gadc.reporte.model.CARGO;
import ec.gadc.reporte.model.CIUDAD;
import ec.gadc.reporte.model.DEPARTAMENTO;
import ec.gadc.reporte.model.DETALLE_GRUPO_CONTRATADO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.EMPLEADO_GRUPO;
import ec.gadc.reporte.model.GRUPO_CONTRATADO;
import ec.gadc.reporte.model.PROVINCIA;
import ec.gadc.reporte.model.REGION;
import ec.gadc.reporte.model.RELOJ;
import ec.gadc.reporte.model.ROLES;
import ec.gadc.reporte.model.TIMBRE;
import ec.gadc.reporte.model.TIPO_CARGO;
import ec.gadc.reporte.model.USUARIOS;

@Stateless
public class mainReporteDAO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	public List<ROLES> getRoles(){
		Query query=em.createQuery("select r from ROLES r",ROLES.class);
		List<ROLES> roles=query.getResultList();
		return	roles;
	}
	
	public void insertEmpleado(EMPLEADO empleado) {
		em.persist(empleado);
	}
	
	public List<EMPLEADO> getEmpleados(){
		Query query=em.createQuery("select r from EMPLEADO r",EMPLEADO.class);
		List<EMPLEADO> empleados=query.getResultList();
		return	empleados;
	}
	public List<CIUDAD> getCiudades(){
		Query query=em.createQuery("select r from CIUDAD r order by r.DESCRIPCION",CIUDAD.class);
		List<CIUDAD> ciudades=query.getResultList();
		return	ciudades;
	}
	public List<PROVINCIA> getProvincias(){
		Query query=em.createQuery("select r from PROVINCIA r",PROVINCIA.class);
		List<PROVINCIA> provincias=query.getResultList();
		return	provincias;
	}
	public List<REGION> getRegiones(){
		Query query=em.createQuery("select r from REGION r",REGION.class);
		List<REGION> regiones=query.getResultList();
		return	regiones;
	}
	public List<DEPARTAMENTO> getDepartamentos(){
		Query query=em.createQuery("select r from DEPARTAMENTO r",DEPARTAMENTO.class);
		List<DEPARTAMENTO> departamentos=query.getResultList();
		return	departamentos;
	}
	public List<RELOJ> getRelojes(){
		Query query=em.createQuery("select r from RELOJ r",RELOJ.class);
		List<RELOJ> relojes=query.getResultList();
		return	relojes;
	}
	public List<CARGO> getCargos(){
		Query query=em.createQuery("select r from CARGO r order by r.DESCRIPCION",CARGO.class);
		List<CARGO> cargos=query.getResultList();
		return	cargos;
	}
	public List<TIPO_CARGO> getTipoCargos(){
		Query query=em.createQuery("select r from TIPO_CARGO r",TIPO_CARGO.class);
		List<TIPO_CARGO> tipoCargos=query.getResultList();
		return	tipoCargos;
	}
	
	
	
	public List<EMPLEADO_GRUPO> getEmpleadogrupos(){
		Query query=em.createQuery("select r from EMPLEADO_GRUPO r",EMPLEADO_GRUPO.class);
		List<EMPLEADO_GRUPO> empleadogrupos=query.getResultList();
		return	empleadogrupos;
	}
	public List<DETALLE_GRUPO_CONTRATADO> getDetalleGruposContratados(){
		Query query=em.createQuery("select r from DETALLE_GRUPO_CONTRATADO r",DETALLE_GRUPO_CONTRATADO.class);
		List<DETALLE_GRUPO_CONTRATADO> detalle_g_contratados=query.getResultList();
		return	detalle_g_contratados;
	}
	public List<TIMBRE> getTimbres(){
		Query query=em.createQuery("select r from TIMBRE r",TIMBRE.class);
		List<TIMBRE> timbres=query.getResultList();
		return	timbres;
	}
	public List<GRUPO_CONTRATADO> getGruposcontratados(){
		Query query=em.createQuery("select r from GRUPO_CONTRATADO r",GRUPO_CONTRATADO.class);
		List<GRUPO_CONTRATADO> grupos_contratados=query.getResultList();
		return	grupos_contratados;
	}
	public List<USUARIOS> getUsuarios(){
		Query query=em.createQuery("select r from USUARIOS r",USUARIOS.class);
		List<USUARIOS> usuarios=query.getResultList();
		return	usuarios;
	}
	public List<EMPLEADO> getEmpleadosNav(String filtro, int opcion) throws NullPointerException{
		List<EMPLEADO> empleados=null;
		try{
			if (opcion==1){
				
				Query query=em.createQuery("select r from EMPLEADO r where "+ "r.CODIGO_EMPLEADO = ?",EMPLEADO.class);
				query.setParameter(1, filtro);
				empleados=query.getResultList();
				return empleados;
			}else{
				if (opcion==2){
					Query query=em.createQuery("select r from EMPLEADO r where r.CEDULA = ?",EMPLEADO.class);
					query.setParameter(1, filtro);
					empleados=query.getResultList();
					return empleados;
				}
				else{
					if (opcion==3){
						Query query=em.createQuery("select r from EMPLEADO r where r.APELLIDO like CONCAT(?,'%')",EMPLEADO.class);
						query.setParameter(1, filtro);
						empleados=query.getResultList();
						return empleados;
					}
				}
			}
		}catch(Exception e){
			throw e;
		}
		return	empleados;
	}
	public String getDepartamento(Integer id){
		DEPARTAMENTO dep= em.find(DEPARTAMENTO.class, id);
		String depa=dep.getDESCRIPCION();
		return depa;
	}
	
	
	public List<TIMBRE> getTimbresDepartamento(Date fecha1, Date fecha2, Integer cod_dep) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r, EMPLEADO e, DEPARTAMENTO d where r.FECHA_HORA_TIMBRE > ? and r.FECHA_HORA_TIMBRE<? and r.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO  and e.DEPA_ID = :cod_dep and d.DEPA_ID = e.DEPA_ID order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
			query.setParameter("cod_dep", cod_dep);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;

		}catch(Exception e){
			return null;
		}
		
		
	}
	public List<TIMBRE> getTimbresPeriodoVeces(Date fecha1, Date fecha2) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r, EMPLEADO e, DEPARTAMENTO d where d.DEPA_ID = e.DEPA_ID and e.CODIGO_EMPLEADO = r.CODIGO_EMPLEADO  and r.FECHA_HORA_TIMBRE > ? and r.FECHA_HORA_TIMBRE < ? and "
					+ "FUNCTION('TO_CHAR',r.FECHA_HORA_TIMBRE,'HH:MI') < "+"'08:00' and "
							+ "FUNCTION('TO_CHAR',r.FECHA_HORA_TIMBRE,'AM') = "+"'AM' order by r.CODIGO_EMPLEADO",TIMBRE.class);
//			query.setParameter(1, mes_anio);
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;

		}catch(Exception e){
			System.out.println("nulo");
			return null;
		}
		
		
	}
	

}
