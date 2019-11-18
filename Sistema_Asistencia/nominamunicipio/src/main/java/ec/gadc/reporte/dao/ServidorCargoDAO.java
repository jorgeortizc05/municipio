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
import ec.muni.nomina.model.ServidorCargo;

public class ServidorCargoDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public void getServidor(int codigo){
		Connection con = null;
		ResultSet rs;
		//List<ServidorCargo> sc= em.createNativeQuery("select i.codigo, i.cedula,i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres, nomina.da_secretaria (i.codigo,2) direccion, nomina.sacacargo(i.codigo) cargo from nomina.servidor i where i.codigo= 713").getResultList();
		List<ServidorCargo> servidorCargos = new ArrayList<ServidorCargo>();
		con = DbConexion.getConexion();
		try {
			String sentencia = ("select i.codigo, i.cedula,\r\n" + 
					"       i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres,\r\n" + 
					"       nomina.da_secretaria (i.codigo,2) direccion,\r\n" + 
					"       nomina.sacacargo(i.codigo) cargo\r\n" + 
					"from nomina.servidor i\r\n" + 
					"where i.codigo= 713 ");
			
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sentencia);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
			DbConexion.liberaConexion(con);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getLocalizedMessage());
			DbConexion.liberaConexion(con);
		}
		
				
	}
	
	
	

}
