package jorgeortiz.sistemaasistencia.fulltime.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BiometricoPersonaSQL {
	
	private String cedula;
	
	@Id
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
