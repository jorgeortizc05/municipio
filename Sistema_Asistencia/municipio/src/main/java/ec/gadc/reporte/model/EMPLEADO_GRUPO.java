package ec.gadc.reporte.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EMPLEADO_GRUPO {
	@Id	
	@NotNull
	private Integer EMGR_ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	public Integer getEMGR_ID() {
		return EMGR_ID;
	}
	public void setEMGR_ID(Integer eMGR_ID) {
		EMGR_ID = eMGR_ID;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	@Override
	public String toString() {
		return "EMPLEADO_GRUPO [EMGR_ID=" + EMGR_ID + ", DESCRIPCION=" + DESCRIPCION + "]";
	}
	
	
}
