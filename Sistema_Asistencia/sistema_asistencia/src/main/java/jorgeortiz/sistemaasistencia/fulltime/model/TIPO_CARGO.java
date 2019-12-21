package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TIPO_CARGO {
	@Id	
	@NotNull
	private Integer TICA_ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	public Integer getTICA_ID() {
		return TICA_ID;
	}
	public void setTICA_ID(Integer tICA_ID) {
		TICA_ID = tICA_ID;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	@Override
	public String toString() {
		return "TIPO_CARGO [TICA_ID=" + TICA_ID + ", DESCRIPCION=" + DESCRIPCION + "]";
	}
	
	
}
