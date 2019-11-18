package ec.gadc.reporte.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
	
	@Inject
	private EntityManager em;
	
	public List<TIMBRE> getTimbres(Date fecha) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA = ? order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter(1, fecha);
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
			Query query=em.createQuery("select r from EMPLEADO r, DEPARTAMENTO d where r.CODIGO_EMPLEADO not in (select t.CODIGO_EMPLEADO from TIMBRE t, EMPLEADO e,DEPARTAMENTO de where de.DEPA_ID = e.DEPA_ID and t.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO and t.FECHA_HORA_TIMBRE > ? and t.FECHA_HORA_TIMBRE < ?) and r.DEPA_ID = d.DEPA_ID",EMPLEADO.class);
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
			List<EMPLEADO> emps=query.getResultList();
			return emps;
		}catch(Exception e){
			return null;
		}
	}
	public List<TIMBRE> getTimbresTemp(Date fecha1, Date fecha2) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA_HORA_TIMBRE > ? and r.FECHA_HORA_TIMBRE<? order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
			List<TIMBRE> timbres=query.getResultList();
			return	timbres;

		}catch(Exception e){
			return null;
		}
		
		
	}
	public List<TIMBRE> getTimbresEmpleado(Date fecha1, Date fecha2, String clave) throws NullPointerException{
		try{
			Query query=em.createQuery("select r from TIMBRE r where r.FECHA_HORA_TIMBRE > ? and r.FECHA_HORA_TIMBRE<? and r.CODIGO_EMPLEADO = :clave order by r.FECHA_HORA_TIMBRE",TIMBRE.class);
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
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
		Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = ?",EMPLEADO.class);
		query.setParameter(1, cod_bio);
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
		Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = ?",EMPLEADO.class);
		query.setParameter(1, cod_bio);
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
			Query query=em.createQuery("select r FROM EMPLEADO r WHERE r.CODIGO_EMPLEADO = ?",EMPLEADO.class);
			query.setParameter(1, cod_bio);
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
