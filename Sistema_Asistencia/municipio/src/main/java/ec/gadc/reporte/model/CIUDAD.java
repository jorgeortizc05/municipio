package ec.gadc.reporte.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class CIUDAD {

	@Id
	@NotNull
	private Integer CIUD_ID;
	@NotNull
	private Integer PROV_ID;
	@NotNull
	@Size(min = 1, max = 30)
	private String CODIGO;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	@Size(min = 1, max = 255)
	private String NIVEL;
	
	
	
	
	public Integer getCIUD_ID() {
		return CIUD_ID;
	}
	public void setCIUD_ID(Integer cIUD_ID) {
		CIUD_ID = cIUD_ID;
	}
	public Integer getPROV_ID() {
		return PROV_ID;
	}
	public void setPROV_ID(Integer pROV_ID) {
		PROV_ID = pROV_ID;
	}
	public String getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(String cODIGO) {
		CODIGO = cODIGO;
	}
	public String getNIVEL() {
		return NIVEL;
	}
	public void setNIVEL(String nIVEL) {
		NIVEL = nIVEL;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	@Override
	public String toString() {
		return "CIUDAD [CIUD_ID=" + CIUD_ID + ", PROV_ID=" + PROV_ID + ", CODIGO=" + CODIGO + ", DESCRIPCION="
				+ DESCRIPCION + ", NIVEL=" + NIVEL + "]";
	}
	
	
	
	
	
}
