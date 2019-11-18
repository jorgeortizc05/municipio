package ec.muni.nomina.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class ACC_PER implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer CODIGO;
	private Date FECHA_EXPEDICION;
	private String ACCION;
	private Date FECHA_VIGENCIA;
	private String EXPLICACION;
	private String PUESTO_ACTUAL;
	private Double SUELDO_ACTUAL;
	private Date FECHA_SOLICITUD;
	private String OFICIO_SOLICITUD;
	private String REGISTRO;
	private String USUARIO;
	private String INSUBSISTENTE;
	private String ACT_CARG_CODIGO;
	private Integer SER_CODIGO;
	private String ACT_CARG_L_T_CODIGO;
	private String ACT_CARG_L_T_PROG_CODIGO;
	private String ACT_CARG_L_T_PROG_FUN_CODIGO;
	private String CREATED_BY;
	private Date CREATION_DATE;
	private String LAST_UPDATED_BY;
	private Date LAST_UPDATE_DATE;
	private String PARTIDA;
	private String DIRECCION;
	private Date FECHA_TERMINO;
	private Integer ID_ACC_PER;
	public Integer getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(Integer cODIGO) {
		CODIGO = cODIGO;
	}
	public Date getFECHA_EXPEDICION() {
		return FECHA_EXPEDICION;
	}
	public void setFECHA_EXPEDICION(Date fECHA_EXPEDICION) {
		FECHA_EXPEDICION = fECHA_EXPEDICION;
	}
	public String getACCION() {
		return ACCION;
	}
	public void setACCION(String aCCION) {
		ACCION = aCCION;
	}
	public Date getFECHA_VIGENCIA() {
		return FECHA_VIGENCIA;
	}
	public void setFECHA_VIGENCIA(Date fECHA_VIGENCIA) {
		FECHA_VIGENCIA = fECHA_VIGENCIA;
	}
	public String getEXPLICACION() {
		return EXPLICACION;
	}
	public void setEXPLICACION(String eXPLICACION) {
		EXPLICACION = eXPLICACION;
	}
	public String getPUESTO_ACTUAL() {
		return PUESTO_ACTUAL;
	}
	public void setPUESTO_ACTUAL(String pUESTO_ACTUAL) {
		PUESTO_ACTUAL = pUESTO_ACTUAL;
	}
	public Double getSUELDO_ACTUAL() {
		return SUELDO_ACTUAL;
	}
	public void setSUELDO_ACTUAL(Double sUELDO_ACTUAL) {
		SUELDO_ACTUAL = sUELDO_ACTUAL;
	}
	public Date getFECHA_SOLICITUD() {
		return FECHA_SOLICITUD;
	}
	public void setFECHA_SOLICITUD(Date fECHA_SOLICITUD) {
		FECHA_SOLICITUD = fECHA_SOLICITUD;
	}
	public String getOFICIO_SOLICITUD() {
		return OFICIO_SOLICITUD;
	}
	public void setOFICIO_SOLICITUD(String oFICIO_SOLICITUD) {
		OFICIO_SOLICITUD = oFICIO_SOLICITUD;
	}
	public String getREGISTRO() {
		return REGISTRO;
	}
	public void setREGISTRO(String rEGISTRO) {
		REGISTRO = rEGISTRO;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getINSUBSISTENTE() {
		return INSUBSISTENTE;
	}
	public void setINSUBSISTENTE(String iNSUBSISTENTE) {
		INSUBSISTENTE = iNSUBSISTENTE;
	}
	public String getACT_CARG_CODIGO() {
		return ACT_CARG_CODIGO;
	}
	public void setACT_CARG_CODIGO(String aCT_CARG_CODIGO) {
		ACT_CARG_CODIGO = aCT_CARG_CODIGO;
	}
	public Integer getSER_CODIGO() {
		return SER_CODIGO;
	}
	public void setSER_CODIGO(Integer sER_CODIGO) {
		SER_CODIGO = sER_CODIGO;
	}
	public String getACT_CARG_L_T_CODIGO() {
		return ACT_CARG_L_T_CODIGO;
	}
	public void setACT_CARG_L_T_CODIGO(String aCT_CARG_L_T_CODIGO) {
		ACT_CARG_L_T_CODIGO = aCT_CARG_L_T_CODIGO;
	}
	public String getACT_CARG_L_T_PROG_CODIGO() {
		return ACT_CARG_L_T_PROG_CODIGO;
	}
	public void setACT_CARG_L_T_PROG_CODIGO(String aCT_CARG_L_T_PROG_CODIGO) {
		ACT_CARG_L_T_PROG_CODIGO = aCT_CARG_L_T_PROG_CODIGO;
	}
	public String getACT_CARG_L_T_PROG_FUN_CODIGO() {
		return ACT_CARG_L_T_PROG_FUN_CODIGO;
	}
	public void setACT_CARG_L_T_PROG_FUN_CODIGO(String aCT_CARG_L_T_PROG_FUN_CODIGO) {
		ACT_CARG_L_T_PROG_FUN_CODIGO = aCT_CARG_L_T_PROG_FUN_CODIGO;
	}
	public String getCREATED_BY() {
		return CREATED_BY;
	}
	public void setCREATED_BY(String cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}
	public Date getCREATION_DATE() {
		return CREATION_DATE;
	}
	public void setCREATION_DATE(Date cREATION_DATE) {
		CREATION_DATE = cREATION_DATE;
	}
	public String getLAST_UPDATED_BY() {
		return LAST_UPDATED_BY;
	}
	public void setLAST_UPDATED_BY(String lAST_UPDATED_BY) {
		LAST_UPDATED_BY = lAST_UPDATED_BY;
	}
	public Date getLAST_UPDATE_DATE() {
		return LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Date lAST_UPDATE_DATE) {
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public String getPARTIDA() {
		return PARTIDA;
	}
	public void setPARTIDA(String pARTIDA) {
		PARTIDA = pARTIDA;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public Date getFECHA_TERMINO() {
		return FECHA_TERMINO;
	}
	public void setFECHA_TERMINO(Date fECHA_TERMINO) {
		FECHA_TERMINO = fECHA_TERMINO;
	}
	public Integer getID_ACC_PER() {
		return ID_ACC_PER;
	}
	public void setID_ACC_PER(Integer iD_ACC_PER) {
		ID_ACC_PER = iD_ACC_PER;
	}
	
}
