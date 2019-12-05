package jorgeortiz.sistemaasistencia.nomina.model;

import java.util.Date;

/*
 * Desarrollado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripción: Recupera Servidor datos de DB Nomina sobre el departamento y su cargo.
 * Script oracle:
 * select i.codigo, i.cedula, i.apellido_paterno ||' '|| i.apellido_materno as APELLIDO, i.primer_nombre ||' '||i.segundo_nombre as NOMBRE, 
       i.email, i.email_personal, i.fecha_nacimiento, i.estado_civil, i.sexo, 'CUENCA' as Ciudad, 'A' as estado, i.nuevaFoto nuevaFoto
			nomina.da_secretaria (i.codigo,2) direccion, 
			nomina.sacacargo(i.codigo) cargo 
			from nomina.servidor i
			where i.codigo = 307 //codigo del servidor(Empleado del municipio)
 */

public class ServidorAreaSQL {
	
	private Integer codigoServidor;
	
	private String cedulaServidor;
	
	private String apellidos;
	
	private String nombres;
	
	private String email;
	
	private String email_personal;
	
	private Date fechaNacimiento;
	
	private String estadoCivil;
	
	private String sexo;
	
	private String ciudad;
	
	private String estado;
	
	private byte[] nuevaFoto;
	
	private String direccion; //Direccion general del talento humano
	
	private String cargo;

	public Integer getCodigoServidor() {
		return codigoServidor;
	}

	public void setCodigoServidor(Integer codigoServidor) {
		this.codigoServidor = codigoServidor;
	}

	public String getCedulaServidor() {
		return cedulaServidor;
	}

	public void setCedulaServidor(String cedulaServidor) {
		this.cedulaServidor = cedulaServidor;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail_personal() {
		return email_personal;
	}

	public void setEmail_personal(String email_personal) {
		this.email_personal = email_personal;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

	public byte[] getNuevaFoto() {
		return nuevaFoto;
	}

	public void setNuevaFoto(byte[] nuevaFoto) {
		this.nuevaFoto = nuevaFoto;
	}

	@Override
	public String toString() {
		return "ServidorAreaSQL [codigoServidor=" + codigoServidor + ", cedulaServidor=" + cedulaServidor
				+ ", apellidos=" + apellidos + ", nombres=" + nombres + ", email=" + email + ", email_personal="
				+ email_personal + ", fechaNacimiento=" + fechaNacimiento + ", estadoCivil=" + estadoCivil + ", sexo="
				+ sexo + ", ciudad=" + ciudad + ", estado=" + estado + ", direccion=" + direccion + ", cargo=" + cargo
				+ "]";
	}
}
