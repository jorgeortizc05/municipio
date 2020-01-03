package jorgeortiz.sistemaasistencia.fulltime.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(
	    name="queryBiometricoDepartamento",
	    query="select empleado.cedula cedula,\r\n" + 
	    		"		empleado.codigo_empleado codigoBiometrico,\r\n" + 
	    		"		empleado.apellido apellido,\r\n" + 
	    		"		empleado.nombre nombre, \r\n" + 
	    		"		timbre.codigo_reloj codigoReloj,\r\n" + 
	    		"		reloj.descripcion as descripcionReloj,\r\n" + 
	    		"		departamento.descripcion departamento,\r\n" + 
	    		"		timbre.fecha_hora_timbre fecha\r\n" + 
	    		"from  timbre,\r\n" + 
	    		"			empleado,\r\n" + 
	    		"			departamento, \r\n" + 
	    		"			reloj\r\n" + 
	    		"where empleado.codigo_empleado = timbre.codigo_empleado \r\n" + 
	    		"and departamento.depa_id= :codigoDepartamento \r\n" + 
	    		"and reloj.relo_id = timbre.codigo_reloj\r\n" + 
	    		"and empleado.depa_id = departamento.depa_id \r\n" + 
	    		"and timbre.fecha_hora_timbre BETWEEN TO_DATE(:fechaDesde, 'dd/MM/YYYY HH24:MI:ss') AND TO_DATE(:fechaHasta, 'dd/MM/YYYY HH24:MI:ss')\r\n" + 
	    		"order by timbre.fecha_hora_timbre desc",
	    resultClass=BiometricoDepartamentoSQL.class
	)
public class BiometricoDepartamentoSQL {
	@Id
	private String cedula;

	private String codigoBiometrico;
	
	private String apellido;
	
	private String nombre;
	
	private String codigoReloj;
	
	private String descripcionReloj;
	
	private String departamento;
	
	private Date fecha;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getCodigoBiometrico() {
		return codigoBiometrico;
	}

	public void setCodigoBiometrico(String codigoBiometrico) {
		this.codigoBiometrico = codigoBiometrico;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getCodigoReloj() {
		return codigoReloj;
	}

	public void setCodigoReloj(String codigoReloj) {
		this.codigoReloj = codigoReloj;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescripcionReloj() {
		return descripcionReloj;
	}

	public void setDescripcionReloj(String descripcionReloj) {
		this.descripcionReloj = descripcionReloj;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
