package ec.gadc.reporte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CARGO", schema = "fulltime", catalog = "CARGO")
public class CARGO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@NotNull
	private Integer CARG_ID;
	@NotNull
	private Integer TICA_ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	@Digits(fraction = 2, integer = 8)
	private Double SUELDO;
	@NotNull
	private Integer HORA_EXTRA;
	public Integer getCARG_ID() {
		return CARG_ID;
	}
	public void setCARG_ID(Integer cARG_ID) {
		CARG_ID = cARG_ID;
	}
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
	public Double getSUELDO() {
		return SUELDO;
	}
	public void setSUELDO(Double sUELDO) {
		SUELDO = sUELDO;
	}
	public Integer getHORA_EXTRA() {
		return HORA_EXTRA;
	}
	public void setHORA_EXTRA(Integer hORA_EXTRA) {
		HORA_EXTRA = hORA_EXTRA;
	}
	@Override
	public String toString() {
		return "CARGO [CARG_ID=" + CARG_ID + ", TICA_ID=" + TICA_ID + ", DESCRIPCION=" + DESCRIPCION + ", SUELDO="
				+ SUELDO + ", HORA_EXTRA=" + HORA_EXTRA + "]";
	}
	
	
}
