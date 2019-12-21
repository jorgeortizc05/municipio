package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DEPARTAMENTO {

	@Id	
	@NotNull
	private Integer DEPA_ID;
	private Integer DEP_DEPA_ID;
	@NotNull
	@Size(min = 1, max = 30)
	private String CODIGO;
	@NotNull
	@Size(min = 2, max = 255,message="Descripcion minima de dos caracteres")
	private String DESCRIPCION;
	private Integer NIVEL;
	private Integer EMPL_ID;
	public Integer getDEPA_ID() {
		return DEPA_ID;
	}
	public void setDEPA_ID(Integer dEPA_ID) {
		DEPA_ID = dEPA_ID;
	}
	public Integer getDEP_DEPA_ID() {
		return DEP_DEPA_ID;
	}
	public void setDEP_DEPA_ID(Integer dEP_DEPA_ID) {
		DEP_DEPA_ID = dEP_DEPA_ID;
	}
	public String getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(String cODIGO) {
		CODIGO = cODIGO;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public Integer getNIVEL() {
		return NIVEL;
	}
	public void setNIVEL(Integer nIVEL) {
		NIVEL = nIVEL;
	}
	public Integer getEMPL_ID() {
		return EMPL_ID;
	}
	public void setEMPL_ID(Integer eMPL_ID) {
		EMPL_ID = eMPL_ID;
	}
	@Override
	public String toString() {
		return "DEPARTAMENTO [DEPA_ID=" + DEPA_ID + ", DEP_DEPA_ID=" + DEP_DEPA_ID + ", CODIGO=" + CODIGO
				+ ", DESCRIPCION=" + DESCRIPCION + ", NIVEL=" + NIVEL + ", EMPL_ID=" + EMPL_ID + "]";
	}
	
	

}
