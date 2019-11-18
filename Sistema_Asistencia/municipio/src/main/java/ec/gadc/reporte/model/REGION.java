package ec.gadc.reporte.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "REGION", schema = "fulltime", catalog = "REGION")
public class REGION {
	@Id
	@NotNull
	private Integer REGI_ID;
	@NotNull
	@Size(min = 1, max = 30)
	private String CODIGO;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	public Integer getREGI_ID() {
		return REGI_ID;
	}
	public void setREGI_ID(Integer rEGI_ID) {
		REGI_ID = rEGI_ID;
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
	@Override
	public String toString() {
		return "REGION [REGI_ID=" + REGI_ID + ", CODIGO=" + CODIGO + ", DESCRIPCION=" + DESCRIPCION + "]";
	}
	
}
