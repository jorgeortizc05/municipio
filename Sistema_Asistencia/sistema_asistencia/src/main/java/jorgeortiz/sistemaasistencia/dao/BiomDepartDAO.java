package jorgeortiz.sistemaasistencia.dao;

import java.sql.Connection;
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

import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoDepartamentoSQL;
import jorgeortiz.sistemaasistencia.util.DbConexionFulltime;

@Stateless
public class BiomDepartDAO {
	
	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	
	public List<BiometricoDepartamentoSQL> getBiometricoDepartamentos(int codigoDepartamento, String fechaDesde, String fechaHasta) {

		Query query = emF.createNamedQuery("queryBiometricoDepartamento", BiometricoDepartamentoSQL.class);
		query.setParameter("codigoDepartamento", codigoDepartamento);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List<BiometricoDepartamentoSQL> items = query.getResultList();
		
		return items;
	}
	
	public List<BiometricoDepartamentoSQL> getFechaDepartamentos(String fechaDesde, String fechaHasta){
		Query query = emF.createNativeQuery("select empleado.cedula cedula,\r\n" + 
				"       empleado.codigo_empleado codigoBiometrico,\r\n" + 
				"       empleado.apellido apellido,\r\n" + 
				"       empleado.nombre nombre,\r\n" + 
				"       timbre.codigo_reloj codigoReloj,\r\n" + 
				"       reloj.descripcion as descripcionReloj,\r\n" + 
				"       departamento.descripcion departamento,\r\n" + 
				"       timbre.fecha_hora_timbre fecha\r\n" + 
				"  from timbre,\r\n" + 
				"       empleado,\r\n" + 
				"       departamento,\r\n" + 
				"       reloj\r\n" + 
				" where empleado.codigo_empleado = timbre.codigo_empleado \r\n" + 
				"       and reloj.relo_id = timbre.codigo_reloj\r\n" + 
				"       and empleado.depa_id = departamento.depa_id \r\n" + 
				"       and timbre.fecha_hora_timbre BETWEEN TO_DATE(:fechaDesde, 'dd/MM/YYYY HH24:MI:ss') AND TO_DATE(:fechaHasta, 'dd/MM/YYYY HH24:MI:ss')\r\n" + 
				"order by timbre.fecha_hora_timbre desc", BiometricoDepartamentoSQL.class);
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		
		List<BiometricoDepartamentoSQL> items = query.getResultList();
		
		return items;
	}
	
	/*public List<BiometricoDepartamentoSQL> getBiometricoDepartamentos1(int codigoDepartamento, String fechaDesde, String fechaHasta) {

		BiometricoDepartamentoSQL item = null;
		List<BiometricoDepartamentoSQL> items = new ArrayList<>();

		Connection conn = null;
		ResultSet rs;
		conn = DbConexionFulltime.getConexion();
		
		System.out.println("Codigo Departamento: "+codigoDepartamento);
		try {
			String sentencia = ("select empleado.cedula,\r\n" + 
					"       empleado.codigo_empleado Biometrico,\r\n" + 
					"       empleado.apellido,\r\n" + 
					"       empleado.nombre,\r\n" + 
					"       timbre.codigo_reloj,\r\n" + 
					"       reloj.descripcion as Reloj,\r\n" + 
					"       departamento.descripcion Departamento,\r\n" + 
					"       timbre.fecha_hora_timbre fecha,\r\n" + 
					"       to_char(timbre.fecha_hora_timbre,'HH:MI AM') hora\r\n" + 
					"  from timbre,\r\n" + 
					"       empleado,\r\n" + 
					"       departamento,\r\n" + 
					"       reloj\r\n" + 
					" where empleado.codigo_empleado = timbre.codigo_empleado \r\n" + 
					"      -- and timbre.codigo_empleado= 307\r\n" + 
					"       and departamento.depa_id="+codigoDepartamento+"\r\n" + 
					"       and reloj.relo_id = timbre.codigo_reloj\r\n" + 
					"       and empleado.depa_id = departamento.depa_id \r\n" + 
					"       and timbre.fecha_hora_timbre BETWEEN TO_DATE('"+fechaDesde+"', 'dd/MM/YYYY HH24:MI:ss') AND TO_DATE('"+fechaHasta+"', 'dd/MM/YYYY HH24:MI:ss')\r\n" + 
					"order by timbre.fecha_hora_timbre desc");
			System.out.println("Departamento");
			System.out.println(sentencia);
			Statement stmt = null;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sentencia);
			while (rs.next()) {
				item = new BiometricoDepartamentoSQL();
				
				item.setCedula(rs.getString(1));
				item.setCodigoBiometrico(rs.getString(2));
				item.setApellido(rs.getString(3));
				item.setNombre(rs.getString(4));
				item.setCodigoReloj(rs.getString(5));
				item.setDescripcionReloj(rs.getString(6));
				item.setDepartamento(rs.getString(7));
				item.setFecha(rs.getDate(8));
				//item.setHora(rs.getDate(9));
				
				items.add(item);
			}

			DbConexionFulltime.liberaConexion(conn);
			return items;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getLocalizedMessage());
			DbConexionFulltime.liberaConexion(conn);
			return null;
		}

	}*/

}
