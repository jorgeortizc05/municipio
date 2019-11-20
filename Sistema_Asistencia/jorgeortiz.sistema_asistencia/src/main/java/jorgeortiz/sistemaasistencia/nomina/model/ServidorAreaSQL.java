package jorgeortiz.sistemaasistencia.nomina.model;

/*
 * Desarrollado por: Jorge Ortiz
 * Fecha inicio: 14/11/2019
 * Descripción: Recupera Servidor datos de DB Nomina sobre el departamento y su cargo.
 * Script oracle:
 * select i.codigo, i.cedula,
       i.apellido_paterno ||' '|| i.apellido_materno ||' '|| i.primer_nombre ||' '|| i.segundo_nombre nombres,
       nomina.da_secretaria (i.codigo,2) direccion,
       nomina.sacacargo(i.codigo) cargo
	from nomina.servidor i
	where i.codigo= 713 //codigo del servidor(Empleado del municipio)
 */

public class ServidorAreaSQL {
	
	private Integer codigoServidor;
	
	private String cedulaServidor;
	
	private String nombres;
	
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Override
	public String toString() {
		return "ServidorCargo [codigoServidor=" + codigoServidor + ", cedulaServidor=" + cedulaServidor + ", direccion="
				+ direccion + ", cargo=" + cargo + "]";
	}

}
