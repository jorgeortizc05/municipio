package jorgeortiz.sistemaasistencia.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.bussiness.EmpleadoBussiness;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;

@ManagedBean
@SessionScoped
public class EmpleadoController {

	@Inject
	private EmpleadoBussiness empBuss;
	
	private List<EMPLEADO> listEmp;
	
	@PostConstruct
	public void init() {
		loadEmpleados();
	}
	
	
	public void loadEmpleados() {
		listEmp = empBuss.getListEmp();
	}


	public List<EMPLEADO> getListEmp() {
		return listEmp;
	}


	public void setListEmp(List<EMPLEADO> listEmp) {
		this.listEmp = listEmp;
	}
	
	
}
