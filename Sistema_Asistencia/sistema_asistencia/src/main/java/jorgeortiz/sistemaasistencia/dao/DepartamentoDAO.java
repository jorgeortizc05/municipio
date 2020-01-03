package jorgeortiz.sistemaasistencia.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import jorgeortiz.sistemaasistencia.fulltime.model.DepartamentoSQL;
import jorgeortiz.sistemaasistencia.util.DbConexionFulltime;


/*
 * Realizado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripcion: SQL para departamentos
 * DB: fullitme
 */
@Stateless
public class DepartamentoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Devuelve una lista de departamentos(Busqueda por descripcion)
	public List<DepartamentoSQL> recuperarDatosDepartamento(String buscarDescripcion){
		
		DepartamentoSQL item;
		List<DepartamentoSQL> items = new ArrayList<DepartamentoSQL>();
		
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
				item = new DepartamentoSQL();
				item.setCodigoDepartamento(rs.getInt(1));
				item.setDescripcion(rs.getString(2));
				items.add(item);
			}
			DbConexionFulltime.liberaConexion(con);
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
