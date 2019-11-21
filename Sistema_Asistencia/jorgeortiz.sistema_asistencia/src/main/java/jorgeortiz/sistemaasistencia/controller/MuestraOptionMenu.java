package jorgeortiz.sistemaasistencia.controller;

public class MuestraOptionMenu {

	public String etiqueta_dep;
	public Integer id_dep;

	public MuestraOptionMenu(String etiqueta, Integer id) {
		this.etiqueta_dep = etiqueta;
		this.id_dep = id;
	}

	public String getEtiqueta_dep() {
		return etiqueta_dep;
	}

	public void setEtiqueta_dep(String etiqueta_dep) {
		this.etiqueta_dep = etiqueta_dep;
	}

	public Integer getId_dep() {
		return id_dep;
	}

	public void setId_dep(Integer id_dep) {
		this.id_dep = id_dep;
	}
}
