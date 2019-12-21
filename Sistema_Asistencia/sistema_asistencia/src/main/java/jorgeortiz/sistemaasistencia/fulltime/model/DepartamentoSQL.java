package jorgeortiz.sistemaasistencia.fulltime.model;

public class DepartamentoSQL {

	private Integer codigoDepartamento;
	
	private String descripcion;

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Departamento [codigoDepartamento=" + codigoDepartamento + ", descripcion=" + descripcion + "]";
	}
}
