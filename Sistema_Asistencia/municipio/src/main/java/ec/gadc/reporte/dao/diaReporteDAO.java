package ec.gadc.reporte.dao;

/*
 * Realizado por: Maicoly Guerrero
 * Edita por: Jorge Ortiz
 * Fecha ediccion: 19/11/2019
 * Descripcion: Dao para obtener timbres, departamentos, empleados.
 * Descripcion modificacion: Correccion de ingreso de parametros
 * DB: fulltime
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.gadc.reporte.model.DEPARTAMENTO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.TIMBRE;
@Stateless
public class diaReporteDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "fulltime")
	private EntityManager em;
	
	public List<TIMBRE> getTimbres(Date fecha) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA = :fecha order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter("fecha", fecha);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;
		}catch(Exception e){
			return null;
		}
	}
	public List<EMPLEADO> getNoHanTimbrado(Date fecha1, Date fecha2) throws NullPointerException{
		try{
			System.out.println("f1> "+fecha1);
			System.out.println("f2> "+fecha2);
			Query query=em.createQuery("select r from EMPLEADO r, DEPARTAMENTO d where r.CODIGO_EMPLEADO not in (select t.CODIGO_EMPLEADO from TIMBRE t, EMPLEADO e,DEPARTAMENTO de where de.DEPA_ID = e.DEPA_ID and t.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO and t.FECHA_HORA_TIMBRE > :fecha1 and t.FECHA_HORA_TIMBRE < :fecha2) and r.DEPA_ID = d.DEPA_ID",EMPLEADO.class);
			query.setParameter("fecha1", fecha1);
			query.setParameter("fecha2", fecha2);
			List<EMPLEADO> emps=query.getResultList();
			return emps;
		}catch(Exception e){
			return null;
		}
	}
	public List<TIMBRE> getTimbresTemp(Date fecha1, Date fecha2) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA_HORA_TIMBRE > :fecha1 and r.FECHA_HORA_TIMBRE< :fecha2 order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter("fecha1", fecha1);
			query.setParameter("fecha2", fecha2);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;

		}catch(Exception e){
			return null;
		}
		
		
	}
	public List<TIMBRE> getTimbresEmpleado(Date fecha1, Date fecha2, String clave) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA_HORA_TIMBRE > :fecha1 and r.FECHA_HORA_TIMBRE< :fecha2 and r.CODIGO_EMPLEADO = :clave order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter("fecha1", fecha1);
			query.setParameter("fecha2", fecha2);
			query.setParameter("clave", clave);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;

		}catch(Exception e){
			System.out.println("nulo");
			return null;
		}
		
		
	}
//	public List<TIMBRE> getTimbresTemp(String clave) throws NullPointerException{
//		System.out.println("entrando al DAOTemp");
//		try{
//			Query query=em.createQuery("select r from TIMBRE r where r.CODIGO_EMPLEADO=?",TIMBRE.class);
//			System.out.println("1");
//			query.setParameter(1, clave);
//			System.out.println("2");
//			List<TIMBRE> timbres=query.getResultList();
//			return	timbres;
//		}catch(Exception e){
//			return null;
//		}
//		
//		
//	}
	public String getRazonSocialEmpApellido(String cod_bio) throws NullPointerException{
		//System.out.println("Leyendo Empleado con id "+cod_bio);
		try{
		Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = :cod_bio",EMPLEADO.class);
		query.setParameter("cod_bio", cod_bio);
		EMPLEADO e= (EMPLEADO) query.getSingleResult();
		String rztotal=e.getAPELLIDO();
		return rztotal;
		}catch(Exception e){
			return null;
		}
	}
	public String getRazonSocialEmpNombre(String cod_bio) throws NullPointerException{
	//	System.out.println("Leyendo Empleado con id "+cod_bio);
		try{
		Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = :cod_bio",EMPLEADO.class);
		query.setParameter("cod_bio", cod_bio);
		EMPLEADO e= (EMPLEADO) query.getSingleResult();
		String rztotal=e.getNOMBRE();
		return rztotal;
		}catch(Exception e){
			return null;
		}
	}
	public String getDepartamento(String cod_bio) throws NullPointerException{
		//	System.out.println("Leyendo Empleado con id "+cod_bio);
			try{
			Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = :cod_bio",EMPLEADO.class);
			query.setParameter("cod_bio", cod_bio);
			EMPLEADO emp= (EMPLEADO) query.getSingleResult();
			Query queryDep=em.createQuery("select d FROM DEPARTAMENTO d where d.DEPA_ID = "+emp.getDEPA_ID(),DEPARTAMENTO.class);
			DEPARTAMENTO dep=(DEPARTAMENTO)queryDep.getSingleResult();
			String desc_dep=dep.getDESCRIPCION();
			return desc_dep;
			}catch(Exception e){
				return null;
			}
		}

}
