package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class GRUPO_CONTRATADO {
	@Id	
	@NotNull
	private Integer GRCO_ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	public Integer getGRCO_ID() {
		return GRCO_ID;
	}
	public void setGRCO_ID(Integer gRCO_ID) {
		GRCO_ID = gRCO_ID;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	@Override
	public String toString() {
		return "GRUPO_CONTRATADO [GRCO_ID=" + GRCO_ID + ", DESCRIPCION=" + DESCRIPCION + "]";
	}
	
	
}
