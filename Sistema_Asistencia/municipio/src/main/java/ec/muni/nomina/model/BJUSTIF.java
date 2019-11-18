package ec.muni.nomina.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class BJUSTIF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ID_BJUSTIF;
	private Date FECHA;
	private String MANENT;
	private String MANSAL;
	private String TARENT;
	private String TARSAL;
	private String DIA;
	private String OBSERVACIONES;
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
