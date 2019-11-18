package ec.gadc.reporte.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.gadc.reporte.utils.DbConexion;
import ec.gadc.reporte.utils.DbConexionFulltime;
import ec.muni.fulltime.model.Departamento;
import ec.muni.nomina.model.ServidorArea;

public class DepartamentoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public List<Departamento> getDepartamento(String descripcion){
		
		Departamento item = new Departamento();
		List<Departamento> items = new ArrayList<>();
		
		Connection con = null;
		ResultSet rs;
		con = DbConexionFulltime.getConexion();
		try {
			String sentencia = ("SELECT dep.depa_id as codigo, dep.descripcion FROM departamento dep WHERE dep.descripcion LIKE '%"+descripcion+"%'");
			System.out.println(sentencia);
			
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sentencia);
			
			while(rs.next()) {
				item.setCodigoDepartamento(rs.getInt(1));
				item.setDescripcion(rs.getString(2));
				items.add(item);
			}
			DbConexion.liberaConexion(con);
			return items;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getLocalizedMessage());
			DbConexionFulltime.liberaConexion(con);
			return null;
		}
						
	}
}
