package ec.gadc.reporte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class TIMBRE implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@NotNull
	private Integer TIMB_ID;
	@NotNull
	private Date FECHA_HORA_TIMBRE;
	@NotNull
	@Size(min = 1, max = 20)
	private String CODIGO_EMPLEADO;
	@Size(min = 1, max = 10)
	private String CODIGO_RELOJ;
	@NotNull
	@Size(min = 1, max = 3)
	private String ACCION;
	private Date FECHA;
	private Date HORA;
	@NotNull
	@Size(min = 1, max = 3)
	private String TECLA_FUNCION;
	@ManyToOne
	private EMPLEADO EMPL_ID;
	@Size(min = 1, max = 100)
	private String OBSERVACION;
	
	public Integer getTIMB_ID() {
		return TIMB_ID;
	}
	public void setTIMB_ID(Integer tIMB_ID) {
		TIMB_ID = tIMB_ID;
	}
	public Date getFECHA_HORA_TIMBRE() {
		return FECHA_HORA_TIMBRE;
	}
	public void setFECHA_HORA_TIMBRE(Date fECHA_HORA_TIMBRE) {
		FECHA_HORA_TIMBRE = fECHA_HORA_TIMBRE;
	}
	public String getCODIGO_EMPLEADO() {
		return CODIGO_EMPLEADO;
	}
	public void setCODIGO_EMPLEADO(String cODIGO_EMPLEADO) {
		CODIGO_EMPLEADO = cODIGO_EMPLEADO;
	}
	public String getCODIGO_RELOJ() {
		return CODIGO_RELOJ;
	}
	public void setCODIGO_RELOJ(String cODIGO_RELOJ) {
		CODIGO_RELOJ = cODIGO_RELOJ;
	}
	public String getACCION() {
		return ACCION;
	}
	public void setACCION(String aCCION) {
		ACCION = aCCION;
	}
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public Date getHORA() {
		return HORA;
	}
	public void setHORA(Date hORA) {
		HORA = hORA;
	}
	public String getTECLA_FUNCION() {
		return TECLA_FUNCION;
	}
	public void setTECLA_FUNCION(String tECLA_FUNCION) {
		TECLA_FUNCION = tECLA_FUNCION;
	}
	public EMPLEADO getEMPL_ID() {
		return EMPL_ID;
	}
	public void setEMPL_ID(EMPLEADO eMPL_ID) {
		EMPL_ID = eMPL_ID;
	}
	public String getOBSERVACION() {
		return OBSERVACION;
	}
	public void setOBSERVACION(String oBSERVACION) {
		OBSERVACION = oBSERVACION;
	}
	@Override
	public String toString() {
		return "TIMBRE [TIMB_ID=" + TIMB_ID + ", FECHA_HORA_TIMBRE=" + FECHA_HORA_TIMBRE + ", CODIGO_EMPLEADO="
				+ CODIGO_EMPLEADO + ", CODIGO_RELOJ=" + CODIGO_RELOJ + ", ACCION=" + ACCION + ", FECHA=" + FECHA
				+ ", HORA=" + HORA + ", TECLA_FUNCION=" + TECLA_FUNCION + ", EMPL_ID=" + EMPL_ID + ", OBSERVACION="
				+ OBSERVACION + "]";
	}
	
	
	
}
