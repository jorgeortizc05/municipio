package ec.gadc.reporte.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.muni.nomina.model.ACC_PER;
import ec.muni.nomina.model.BJUSTIF;
import ec.muni.nomina.model.SERVIDOR;
@Stateless

/*
 * Realizado por: Maicoly Guerrero
 * Edita por: Jorge Ortiz
 * Fecha ediccion: 19/11/2019
 * Descripcion: Dao para obtener justificaciones y el servidor.
 * Descripcion modificacion: Correccion de ingreso de parametros
 * DB: nomina
 */
public class mainJustDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	
	public List<BJUSTIF> getBjust() throws NullPointerException{
		Query query=em.createQuery("select r from BJUSTIF r",BJUSTIF.class);
		List<BJUSTIF> justificaciones=query.getResultList();
		return justificaciones;
		
	}
	public List<SERVIDOR> getServidor(String cedula)throws NullPointerException{
		try{
		Query query=em.createQuery("select s from SERVIDOR s where s.CEDULA = :cedula",SERVIDOR.class);
		query.setParameter("cedula", cedula);
		List<SERVIDOR> empleados=query.getResultList();
		return empleados;
		}catch(Exception e){
			System.out.println("nulo");
			return null;
		}
	}
	public List<SERVIDOR> getEmpleadosServidor(String cedula)throws NullPointerException{
		try{
		Query query=em.createQuery("select s from SERVIDOR s where s.CEDULA = :cedula",SERVIDOR.class);
		query.setParameter("cedula", cedula);
		List<SERVIDOR> empleados=query.getResultList();
		return empleados;
		}catch(Exception e){
			System.out.println("nulo");
			return null;
		}
	}
	public List<BJUSTIF> getBjustPersona(String cedula,Date fecha1, Date fecha2) throws NullPointerException{
//		System.out.println("cedula> "+cedula);
//		System.out.println("fecha1> "+fecha1+" ---- "+fecha1.toString()+" ----- "+fecha1.getTime());
//		System.out.println("fecha2> "+fecha2+" ---- "+fecha2.toString()+" ----- "+fecha2.getTime());
		Query query=em.createQuery("select r from BJUSTIF r, SERVIDOR s where s.CEDULA = :cedula and r.FECHA > :fecha1 and r.FECHA < :fecha2 and r.SER_CODIGO = s.CODIGO order by r.FECHA DESC",BJUSTIF.class);
		query.setParameter("cedula", cedula);
		query.setParameter("fecha1", fecha1);
		query.setParameter("fecha2", fecha2);
		List<BJUSTIF> justificaciones=query.getResultList();
//		for(BJUSTIF b:justificaciones){
//			System.out.println(">> "+b.getOBSERVACIONES());
//			System.out.println(">> "+b.getSER_CODIGO());
//		}
		return justificaciones;
		
	}
	public List<ACC_PER> getAccPer(String cedula,Date fecha1, Date fecha2) throws NullPointerException{
		Query query=em.createQuery("select a from ACC_PER a, SERVIDOR b where b.CEDULA = :cedula and a.SER_CODIGO = b.CODIGO and a.ACCION IN ("+"'LSM','LSP','VAC','LSL','LSS','Z','DCS','CCR','CSR'"+") AND a.FECHA_VIGENCIA > :fecha1 and a.FECHA_VIGENCIA < :fecha2",ACC_PER.class);
		query.setParameter("cedula", cedula);
		query.setParameter("fecha1", fecha1);
		query.setParameter("fecha2", fecha2);
		List<ACC_PER> acciones=query.getResultList();
		for(ACC_PER b:acciones){
			System.out.println(">>... "+b.getSER_CODIGO());
			System.out.println(">> "+b.getACCION());
			System.out.println(">> "+b.getFECHA_VIGENCIA());
			System.out.println(">>... "+b.getEXPLICACION());
		}
		return acciones;
	}
}
