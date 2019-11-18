package ec.gadc.reporte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ROLES implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	@NotNull
	private Integer ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	private Integer HORA_EXTRA;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Integer getHORA_EXTRA() {
		return HORA_EXTRA;
	}
	public void setHORA_EXTRA(Integer hORA_EXTRA) {
		HORA_EXTRA = hORA_EXTRA;
	}
	@Override
	public String toString() {
		return "ROLES [ID=" + ID + ", DESCRIPCION=" + DESCRIPCION + ", HORA_EXTRA=" + HORA_EXTRA + "]";
	}
	

}
