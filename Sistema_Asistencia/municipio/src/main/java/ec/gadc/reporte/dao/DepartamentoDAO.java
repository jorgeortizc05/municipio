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

/*
 * Realizado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripcion: SQL para departamentos
 * DB: fullitme
 */
public class DepartamentoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Devuelve una lista de departamentos(Busqueda por descripcion)
	public List<Departamento> recuperarDatosDepartamento(String buscarDescripcion){
		
		Departamento item;
		List<Departamento> items = new ArrayList<Departamento>();
		
		Connection con = null;
		ResultSet rs;
		con = DbConexionFulltime.getConexion();
		try {
			String sentencia = ("SELECT dep.depa_id as codigo, dep.descripcion FROM departamento dep WHERE dep.descripcion LIKE '%"+buscarDescripcion+"%'");
			System.out.println(sentencia);
			
			Statement stmt = null;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sentencia);
			
			while(rs.next()) {
				item = new Departamento();
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
