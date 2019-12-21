package jorgeortiz.sistemaasistencia.fulltime.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class EMPLEADO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@NotNull
	private Integer EMPL_ID;

	private Integer EMP_EMPL_ID;
	@NotNull
	private Integer ID;
	@NotNull
	private Integer CIUD_ID;
	@NotNull
	private Integer CARG_ID;
	@NotNull
	private Integer DGCO_ID;
	@NotNull
	private Integer DEPA_ID;
	private Integer RELO_ID;
	@NotNull
	//@Size(min = 8, max = 15)
	//@Pattern(regexp="/^[0-9]+$/", message="Cedula numerica con 10 digitos")
	private String CEDULA;
	@NotNull
	@Size(min = 2, max = 255)
    @Pattern(regexp = "[^0-9]*", message = "Apellido no debería contener numeros")
	private String APELLIDO;
	@NotNull
	@Size(min = 2, max = 255)
    @Pattern(regexp = "[^0-9]*", message = "Nombre no debería contener numeros")
	private String NOMBRE;
	@NotNull
	private Integer ESTADO_CIVIL;
	@NotNull
	private Integer SEXO;
	@NotNull
	@Email
	private String CORREO;
	@NotNull
	private Date FECHA_NACIMIENTO;
	private Date FECHA_INGRESO;
	private Date FECHA_SALIDA;
	private Date FECHA_CONTRATO;
	private Date FECHA_ULT_VACACION;
	@NotNull
	private Integer HORAS_TRABAJA;
	@Digits(fraction = 2, integer = 8)
	private Double SUELDO;
	@Size(min = 1, max = 255)
	private String PARTIDA;
	@Size(min = 1, max = 255)
	private String PARTIDA_INDIVIDUAL;
	@Size(min = 1, max = 1)
	private String ENTRADA_SALIDA;
	private Integer NUMERO_TIMBRE;
	@NotNull
	private Integer ESTADO;
	@Size(min = 1, max = 20)
	private String CODIGO_EMPLEADO;
	private Integer CONTROLA_VACACION;
	@Email
	private String CORREO_ALTERNATIVO;
	private Integer EMGR_ID;
	
	
	
	
	public Integer getEMPL_ID() {
		return EMPL_ID;
	}
	public void setEMPL_ID( Integer eMPL_ID) {
		EMPL_ID = eMPL_ID;
	}
	public Integer getEMP_EMPL_ID() {
		return EMP_EMPL_ID;
	}
	public void setEMP_EMPL_ID( Integer eMP_EMPL_ID) {
		EMP_EMPL_ID = eMP_EMPL_ID;
	}
	public Integer getID() {
		return ID;
	}
	public void setID( Integer iD) {
		ID = iD;
	}
	public Integer getCIUD_ID() {
		return CIUD_ID;
	}
	public void setCIUD_ID( Integer cIUD_ID) {
		CIUD_ID = cIUD_ID;
	}
	public Integer getCARG_ID() {
		return CARG_ID;
	}
	public void setCARG_ID( Integer cARG_ID) {
		CARG_ID = cARG_ID;
	}
	public Integer getDGCO_ID() {
		return DGCO_ID;
	}
	public void setDGCO_ID( Integer dGCO_ID) {
		DGCO_ID = dGCO_ID;
	}
	public Integer getDEPA_ID() {
		return DEPA_ID;
	}
	public void setDEPA_ID( Integer dEPA_ID) {
		DEPA_ID = dEPA_ID;
	}
	public Integer getRELO_ID() {
		return RELO_ID;
	}
	public void setRELO_ID( Integer rELO_ID) {
		RELO_ID = rELO_ID;
	}
	public String getCEDULA() {
		return CEDULA;
	}
	public void setCEDULA(String cEDULA) {
		CEDULA = cEDULA;
	}
	public String getAPELLIDO() {
		return APELLIDO;
	}
	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public Integer getESTADO_CIVIL() {
		return ESTADO_CIVIL;
	}
	public void setESTADO_CIVIL(Integer eSTADO_CIVIL) {
		ESTADO_CIVIL = eSTADO_CIVIL;
	}
	public Integer getSEXO() {
		return SEXO;
	}
	public void setSEXO(Integer sEXO) {
		SEXO = sEXO;
	}
	public String getCORREO() {
		return CORREO;
	}
	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}
	public Date getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}
	public void setFECHA_NACIMIENTO(Date fECHA_NACIMIENTO) {
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
	}
	public Date getFECHA_INGRESO() {
		return FECHA_INGRESO;
	}
	public void setFECHA_INGRESO(Date fECHA_INGRESO) {
		FECHA_INGRESO = fECHA_INGRESO;
	}
	public Date getFECHA_SALIDA() {
		return FECHA_SALIDA;
	}
	public void setFECHA_SALIDA(Date fECHA_SALIDA) {
		FECHA_SALIDA = fECHA_SALIDA;
	}
	public Date getFECHA_CONTRATO() {
		return FECHA_CONTRATO;
	}
	public void setFECHA_CONTRATO(Date fECHA_CONTRATO) {
		FECHA_CONTRATO = fECHA_CONTRATO;
	}
	public Date getFECHA_ULT_VACACION() {
		return FECHA_ULT_VACACION;
	}
	public void setFECHA_ULT_VACACION(Date fECHA_ULT_VACACION) {
		FECHA_ULT_VACACION = fECHA_ULT_VACACION;
	}
	public Integer getHORAS_TRABAJA() {
		return HORAS_TRABAJA;
	}
	public void setHORAS_TRABAJA( Integer hORAS_TRABAJA) {
		HORAS_TRABAJA = hORAS_TRABAJA;
	}
	public Double getSUELDO() {
		return SUELDO;
	}
	public void setSUELDO(Double sUELDO) {
		SUELDO = sUELDO;
	}
	public String getPARTIDA() {
		return PARTIDA;
	}
	public void setPARTIDA(String pARTIDA) {
		PARTIDA = pARTIDA;
	}
	public String getPARTIDA_INDIVIDUAL() {
		return PARTIDA_INDIVIDUAL;
	}
	public void setPARTIDA_INDIVIDUAL(String pARTIDA_INDIVIDUAL) {
		PARTIDA_INDIVIDUAL = pARTIDA_INDIVIDUAL;
	}
	public String getENTRADA_SALIDA() {
		return ENTRADA_SALIDA;
	}
	public void setENTRADA_SALIDA(String eNTRADA_SALIDA) {
		ENTRADA_SALIDA = eNTRADA_SALIDA;
	}
	public Integer getNUMERO_TIMBRE() {
		return NUMERO_TIMBRE;
	}
	public void setNUMERO_TIMBRE( Integer nUMERO_TIMBRE) {
		NUMERO_TIMBRE = nUMERO_TIMBRE;
	}
	public Integer getESTADO() {
		return ESTADO;
	}
	public void setESTADO( Integer eSTADO) {
		ESTADO = eSTADO;
	}
	public String getCODIGO_EMPLEADO() {
		return CODIGO_EMPLEADO;
	}
	public void setCODIGO_EMPLEADO(String cODIGO_EMPLEADO) {
		CODIGO_EMPLEADO = cODIGO_EMPLEADO;
	}
	public Integer getCONTROLA_VACACION() {
		return CONTROLA_VACACION;
	}
	public void setCONTROLA_VACACION( Integer cONTROLA_VACACION) {
		CONTROLA_VACACION = cONTROLA_VACACION;
	}
	public String getCORREO_ALTERNATIVO() {
		return CORREO_ALTERNATIVO;
	}
	public void setCORREO_ALTERNATIVO(String cORREO_ALTERNATIVO) {
		CORREO_ALTERNATIVO = cORREO_ALTERNATIVO;
	}
	public Integer getEMGR_ID() {
		return EMGR_ID;
	}
	public void setEMGR_ID( Integer eMGR_ID) {
		EMGR_ID = eMGR_ID;
	}
	@Override
	public String toString() {
		return "EMPLEADO [EMPL_ID=" + EMPL_ID + ", EMPL_EMPL_ID=" + EMP_EMPL_ID + ", ID=" + ID + ", CIUD_ID=" + CIUD_ID
				+ ", CARG_ID=" + CARG_ID + ", DGCO_ID=" + DGCO_ID + ", DEPA_ID=" + DEPA_ID + ", RELO_ID=" + RELO_ID
				+ ", CEDULA=" + CEDULA + ", APELLIDO=" + APELLIDO + ", NOMBRE=" + NOMBRE + ", ESTADO_CIVIL="
				+ ESTADO_CIVIL + ", SEXO=" + SEXO + ", CORREO=" + CORREO + ", FECHA_NACIMIENTO=" + FECHA_NACIMIENTO
				+ ", FECHA_INGRESO=" + FECHA_INGRESO + ", FECHA_SALIDA=" + FECHA_SALIDA + ", FECHA_CONTRATO="
				+ FECHA_CONTRATO + ", FECHA_ULT_VACACION=" + FECHA_ULT_VACACION + ", HORAS_TRABAJA=" + HORAS_TRABAJA
				+ ", SUELDO=" + SUELDO + ", PARTIDA=" + PARTIDA + ", PARTIDA_INDIVIDUAL=" + PARTIDA_INDIVIDUAL
				+ ", ENTRADA_SALIDA=" + ENTRADA_SALIDA + ", NUMERO_TIMBRE=" + NUMERO_TIMBRE + ", ESTADO=" + ESTADO
				+ ", CODIGO_EMPLEADO=" + CODIGO_EMPLEADO + ", CONTROLA_VACACION=" + CONTROLA_VACACION
				+ ", CORREO_ALTERNATIVO=" + CORREO_ALTERNATIVO + ", EMGR_ID=" + EMGR_ID + "]";
	}
	
	
	
}
