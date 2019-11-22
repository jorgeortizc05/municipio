package jorgeortiz.sistemaasistencia.fulltime.model;

import java.util.Date;

public class BiometricoPersonaSQL {
	
	private String cedula;
	
	private String codigoBiometrico;
	
	private String apellido;
	
	private String nombre;
	
	private String codigoReloj;
	
	private String descripcionReloj;
	
	private String departamento;
	
	private Date fecha;
	
	private Date hora;

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

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "BiometricoPersonaSQL [cedula=" + cedula + ", codigoBiometrico=" + codigoBiometrico + ", apellido="
				+ apellido + ", nombre=" + nombre + ", codigoReloj=" + codigoReloj + ", departamento=" + departamento
				+ ", descripcionReloj=" + descripcionReloj + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	
	
	

}
