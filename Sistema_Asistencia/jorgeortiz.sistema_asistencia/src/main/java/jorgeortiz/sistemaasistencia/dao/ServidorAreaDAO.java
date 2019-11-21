package jorgeortiz.sistemaasistencia.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;
import jorgeortiz.sistemaasistencia.nomina.model.ServidorAreaSQL;
import jorgeortiz.sistemaasistencia.util.DbConexionNomina;

/*
 * Realizado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripcion: Sentencias sql para recuperar el servidor con sus cargos y sus departamentos
 * DB: nomina
 */

@Stateless
public class ServidorAreaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "nomina")
	private EntityManager emN;
	
	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	//Obtiene servidor con sus cargos y departamentos getServidor(codigo servidor)
	public ServidorAreaSQL recuperarServidorArea(int codigoServidor){
		
		ServidorAreaSQL item = null;
		List<ServidorAreaSQL> items = new ArrayList<>();
		
		Connection con = null;
		ResultSet rs;
		//List<ServidorCargo> sc= em.createNativeQuery("select i.codigo, i.cedula,i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres, nomina.da_secretaria (i.codigo,2) direccion, nomina.sacacargo(i.codigo) cargo from nomina.servidor i where i.codigo= 713").getResultList();
		List<ServidorAreaSQL> servidorCargos = new ArrayList<ServidorAreaSQL>();
		con = DbConexionNomina.getConexion();
		try {
			String sentencia = ("select i.codigo, i.cedula, i.apellido_paterno ||' '|| i.apellido_materno as APELLIDO, i.primer_nombre ||' '||i.segundo_nombre as NOMBRE, \n" + 
					"       i.email, i.email_personal, i.fecha_nacimiento, i.estado_civil, i.sexo, 'CUENCA' as Ciudad, 'A' as estado,\n" + 
					"			nomina.da_secretaria (i.codigo,2) direccion, \n" + 
					"			nomina.sacacargo(i.codigo) cargo \n" + 
					"			from nomina.servidor i\n" + 
					"			where i.codigo ="+codigoServidor);
			
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sentencia);
			while(rs.next()) {
				item = new ServidorAreaSQL();
				item.setCodigoServidor(rs.getInt(1));
				item.setCedulaServidor(rs.getString(2));
				item.setApellidos(rs.getString(3));
				item.setNombres(rs.getString(4));
				item.setEmail(rs.getString(5));
				item.setEmail_personal(rs.getString(6));
				item.setFechaNacimiento(rs.getDate(7));
				item.setEstado(rs.getString(8));
				item.setSexo(rs.getString(9));
				item.setCiudad(rs.getString(10));
				item.setEstado(rs.getString(11));
				item.setDireccion(rs.getString(12));
				item.setCargo(rs.getString(5));
			}
			

			DbConexionNomina.liberaConexion(con);
			return item;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getLocalizedMessage());
			DbConexionNomina.liberaConexion(con);
			return null;
		}
						
	}
	
	public SERVIDOR recuperarServidor(String cedula)throws NullPointerException{
		try{
			Query query=emN.createQuery("select s from SERVIDOR s where s.CEDULA = :cedula",SERVIDOR.class);
			query.setParameter("cedula", cedula);
			SERVIDOR servidor=(SERVIDOR) query.getSingleResult();
			return servidor;
		}catch(Exception e){
			System.out.println("nulo");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	public void insertEmpleado(EMPLEADO empleado) {
		emF.persist(empleado);
	}
	
	public List<SERVIDOR> recuperarServidores()throws NullPointerException{
		try{
			Query query=emN.createQuery("select s from SERVIDOR s",SERVIDOR.class);
			List<SERVIDOR> empleados=query.getResultList();
			return empleados;
		}catch(Exception e){
			System.out.println("nulo");
			return null;
		}
	}
}
