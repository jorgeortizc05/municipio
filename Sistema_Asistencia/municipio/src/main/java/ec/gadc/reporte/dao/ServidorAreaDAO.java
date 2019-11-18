package ec.gadc.reporte.dao;

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
import javax.persistence.Query;

import ec.gadc.reporte.utils.DbConexion;
import ec.muni.nomina.model.ServidorArea;
/*
 * Realizado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripcion: Sentencias sql para recuperar el servior con sus cargos y sus departamentos
 */

public class ServidorAreaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public List<ServidorArea> getServidor(int codigo){
		
		ServidorArea item = new ServidorArea();
		List<ServidorArea> items = new ArrayList<>();
		
		Connection con = null;
		ResultSet rs;
		//List<ServidorCargo> sc= em.createNativeQuery("select i.codigo, i.cedula,i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres, nomina.da_secretaria (i.codigo,2) direccion, nomina.sacacargo(i.codigo) cargo from nomina.servidor i where i.codigo= 713").getResultList();
		List<ServidorArea> servidorCargos = new ArrayList<ServidorArea>();
		con = DbConexion.getConexion();
		try {
			String sentencia = ("select i.codigo, i.cedula,\r\n" + 
					"       i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres,\r\n" + 
					"       nomina.da_secretaria (i.codigo,2) direccion,\r\n" + 
					"       nomina.sacacargo(i.codigo) cargo\r\n" + 
					"from nomina.servidor i\r\n" + 
					"where i.codigo="+codigo);
			
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sentencia);
			
			while(rs.next()) {
				item.setCodigoServidor(rs.getInt(1));
				item.setCedulaServidor(rs.getString(2));
				item.setNombres(rs.getString(3));
				item.setDireccion(rs.getString(4));
				item.setCargo(rs.getString(5));
				items.add(item);
			}
			DbConexion.liberaConexion(con);
			return items;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getLocalizedMessage());
			DbConexion.liberaConexion(con);
			return null;
		}
						
	}
}
