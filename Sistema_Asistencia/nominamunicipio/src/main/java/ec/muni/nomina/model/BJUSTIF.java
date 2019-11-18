package ec.muni.nomina.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class BJUSTIF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	
	@NotNull
	private Integer ID_BJUSTIF;
	@NotNull
	private Date FECHA;
	@Size(min = 1, max = 9)
	private String MANENT;
	@Size(min = 1, max = 9)
	private String MANSAL;
	@Size(min = 1, max = 9)
	private String TARENT;
	@Size(min = 1, max = 9)
	private String TARSAL;
	@Size(min = 1, max = 1)
	private String DIA;
	@Size(min = 1, max = 250)
	private String OBSERVACIONES;
	@NotNull
	private Integer SER_CODIGO;
	public Integer getID_BJUSTIF() {
		return ID_BJUSTIF;
	}
	public void setID_BJUSTIF(Integer iD_BJUSTIF) {
		ID_BJUSTIF = iD_BJUSTIF;
	}
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public String getMANENT() {
		return MANENT;
	}
	public void setMANENT(String mANENT) {
		MANENT = mANENT;
	}
	public String getMANSAL() {
		return MANSAL;
	}
	public void setMANSAL(String mANSAL) {
		MANSAL = mANSAL;
	}
	public String getTARENT() {
		return TARENT;
	}
	public void setTARENT(String tARENT) {
		TARENT = tARENT;
	}
	public String getTARSAL() {
		return TARSAL;
	}
	public void setTARSAL(String tARSAL) {
		TARSAL = tARSAL;
	}
	public String getDIA() {
		return DIA;
	}
	public void setDIA(String dIA) {
		DIA = dIA;
	}
	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}
	public void setOBSERVACIONES(String oBSERVACIONES) {
		OBSERVACIONES = oBSERVACIONES;
	}
	public Integer getSER_CODIGO() {
		return SER_CODIGO;
	}
	public void setSER_CODIGO(Integer sER_CODIGO) {
		SER_CODIGO = sER_CODIGO;
	}
	
}
