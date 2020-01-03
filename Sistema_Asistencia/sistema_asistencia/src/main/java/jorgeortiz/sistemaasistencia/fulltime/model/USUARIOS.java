package jorgeortiz.sistemaasistencia.fulltime.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class USUARIOS implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@NotNull
	private Integer ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String USUARIO;
	@NotNull
	@Size(min = 1, max = 1024)
	private String CONTRASENA;
	@NotNull
	private Date FECHA_CREACION;
	@NotNull
	private Integer ESTADO;
	@NotNull
	private Date FECHA_VENCIMIENTO;
	
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getCONTRASENA() {
		return CONTRASENA;
	}
	public void setCONTRASENA(String cONTRASENA) {
		CONTRASENA = cONTRASENA;
	}
	public Date getFECHA_CREACION() {
		return FECHA_CREACION;
	}
	public void setFECHA_CREACION(Date fECHA_CREACION) {
		FECHA_CREACION = fECHA_CREACION;
	}
	public Integer getESTADO() {
		return ESTADO;
	}
	public void setESTADO(Integer eSTADO) {
		ESTADO = eSTADO;
	}
	public Date getFECHA_VENCIMIENTO() {
		return FECHA_VENCIMIENTO;
	}
	public void setFECHA_VENCIMIENTO(Date fECHA_VENCIMIENTO) {
		FECHA_VENCIMIENTO = fECHA_VENCIMIENTO;
	}
	@Override
	public String toString() {
		return "USUARIO [ID=" + ID + ", USUARIO=" + USUARIO + ", CONTRASENA=" + CONTRASENA + ", FECHA_CREACION="
				+ FECHA_CREACION + ", ESTADO=" + ESTADO + ", FECHA_VENCIMIENTO=" + FECHA_VENCIMIENTO + "]";
	}
	
	
	
}
