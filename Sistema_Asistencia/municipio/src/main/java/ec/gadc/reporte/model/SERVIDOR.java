package ec.gadc.reporte.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class SERVIDOR implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@NotNull
	private Integer CODIGO;
	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp="/^[0-9]+$/", message="Cedula numerica con 10 digitos")
	private String CEDULA;
	@NotNull
	private Date FECHA_EMISION;
	@NotNull
	@Size(min = 1, max = 20)
	private String APELLIDO_PATERNO;
	@Size(min = 1, max = 20)
	private String APELLIDO_MATERNO;
	@NotNull
	@Size(min = 1, max = 20)
	private String PRIMER_NOMBRE;
	@Size(min = 1, max = 20)
	private String SEGUNDO_NOMBRE;
	private byte[]  FOTOGRAFIA;
	@Size(min = 1, max = 1)
	private String SEXO;
	private Date FECHA_NACIMIENTO;
	@Size(min = 1, max = 250)
	private String LUGAR;
	@NotNull
	@Size(min = 1, max = 25)
	private String NACIONALIDAD;
	@NotNull
	@Size(min = 1, max = 3)
	private String ESTADO_CIVIL;
	@Size(min = 1, max = 20)
	private String LIBRETA_MILITAR;
	@Size(min = 1, max = 15)
	private String CARNET_IESS;
	@Size(min = 1, max = 5)
	private String TIPO_SANGRE;
	private Integer ESTATURA;
	@Size(min = 1, max = 20)
	private String PELO;
	@Size(min = 1, max = 15)
	private String TEZ;
	@NotNull
	@Size(min = 1, max = 240)
	private String DOMICILIO;
	@Size(min = 1, max = 13)
	private String TELEFONO;
	@Size(min = 1, max = 13)
	private String TELEFONO2;
	@Size(min = 1, max = 50)
	private String EMAIL;
	@NotNull
	@Size(min = 1, max = 1)
	private String VIVO;
	@NotNull
	private Date FECHA_INGRESO;
	@NotNull
	@Size(min = 1, max = 1)
	private String ACTIVO;
	@NotNull
	@Size(min = 1, max = 1)
	private String AFILIADO_COLEGIO;
	private Integer BIOMETRICO;
	@Size(min = 1, max = 3)
	private String PRR_CODIGO_PERTENECE_A;
	@Size(min = 1, max = 2)
	private String PRR_CAT_CODIGO_PERTENECE_A;
	@Size(min = 1, max = 2)
	private String PRR_CAT_PRV_CODIGO_PERTENECE_A;
	@Size(min = 1, max = 3)
	private String PRR_CODIGO;
	@Size(min = 1, max = 2)
	private String PRR_CAT_CODIGO;
	@Size(min = 1, max = 2)
	private String PRR_CAT_PRV_CODIGO;
	private Integer PRO_CODIGO;
	private Integer SER_CODIGO;
	@NotNull
	@Size(min = 1, max = 30)
	private String CREATED_BY;
	@NotNull
	private Date CREATION_DATE;
	@NotNull
	@Size(min = 1, max = 30)
	private String LAST_UPDATED_BY;
	@NotNull
	private Date LAST_UPDATE_DATE;
	private Date FECHA_PRIMER_INGRESO;
	@Size(min = 1, max = 30)
	private String TIPO_DISCAPACIDAD;
	private Integer PORC_DISCAPACIDAD;
	@Size(min = 1, max = 4)
	private String CLAVE;
	private byte[]  NUEVA_FOTO;
	@Digits(fraction = 2, integer = 12)
	private Double TALLA_CALZADO;
	@Digits(fraction = 2, integer = 12)
	private Double TALLA_GUANTE_MANOS;
	@Size(min = 1, max = 12)
	private String TALLA_CINTURA;
	@Size(min = 1, max = 12)
	private String TALLA_IMPERMEABLE;
	@Size(min = 1, max = 20)
	private String TALLA_CASACA;
	@Size(min = 1, max = 20)
	private String TALLA_CHALECO_ESPE;
	@Digits(fraction = 2, integer = 12)
	private Double TALLA_MANDIL;
	@Size(min = 1, max = 50)
	private String PARTIDA_ANTICIPO;
	@Size(min = 1, max = 30)
	private String ID_DISCAPACIDAD;
	private Integer NUMERO_HORAS_CURSO;
	private Integer NUMERO_CURSOS;
	@Size(min = 1, max = 150)
	private String CALLE_SECUNDARIA;
	@Size(min = 1, max = 20)
	private String CALLE_NUMERO;
	@Size(min = 1, max = 20)
	private String EXTENSION_TELEFONICA;
	@Size(min = 1, max = 25)
	private String AUTOIDENTIFICACION;
	@Size(min = 1, max = 25)
	private String AUTOPUEBLO;
	@Size(min = 1, max = 50)
	private String EMAIL_PERSONAL;
	@Size(min = 1, max = 2)
	private String SUSTITUTO_DISCAPACIDAD;
	@Size(min = 1, max = 250)
	private String SUSTITUTO_NOMBRES;
	@Size(min = 1, max = 2)
	private String CONDIC_DISCAPACIDAD;
	@Size(min = 1, max = 1)
	private String TIPO_IDENT_DISCAPACIDAD;
	@Size(min = 1, max = 1)
	private String TIPO_IDENT_TRABAJ;
	@Size(min = 1, max = 2)
	private String RESIDENCIA_TRABAJ;
	@Size(min = 1, max = 10)
	private String CEDULA_DISCAPACIDAD;
	private Integer ANIO_ACTUALIZACION_DISC;
	private Date FECHA_ACTUALIZACION_DISC;
	@Size(min = 1, max = 400)
	private String NOMBRE_HOJA_VIDA;
	private byte[]  HOJA_VIDA;
	@Size(min = 1, max = 500)
	private String REFERENCIA_PERSONAL;
	public Integer getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(Integer cODIGO) {
		CODIGO = cODIGO;
	}
	public String getCEDULA() {
		return CEDULA;
	}
	public void setCEDULA(String cEDULA) {
		CEDULA = cEDULA;
	}
	public Date getFECHA_EMISION() {
		return FECHA_EMISION;
	}
	public void setFECHA_EMISION(Date fECHA_EMISION) {
		FECHA_EMISION = fECHA_EMISION;
	}
	public String getAPELLIDO_PATERNO() {
		return APELLIDO_PATERNO;
	}
	public void setAPELLIDO_PATERNO(String aPELLIDO_PATERNO) {
		APELLIDO_PATERNO = aPELLIDO_PATERNO;
	}
	public String getAPELLIDO_MATERNO() {
		return APELLIDO_MATERNO;
	}
	public void setAPELLIDO_MATERNO(String aPELLIDO_MATERNO) {
		APELLIDO_MATERNO = aPELLIDO_MATERNO;
	}
	public String getPRIMER_NOMBRE() {
		return PRIMER_NOMBRE;
	}
	public void setPRIMER_NOMBRE(String pRIMER_NOMBRE) {
		PRIMER_NOMBRE = pRIMER_NOMBRE;
	}
	public String getSEGUNDO_NOMBRE() {
		return SEGUNDO_NOMBRE;
	}
	public void setSEGUNDO_NOMBRE(String sEGUNDO_NOMBRE) {
		SEGUNDO_NOMBRE = sEGUNDO_NOMBRE;
	}
	
	public byte[] getFOTOGRAFIA() {
		return FOTOGRAFIA;
	}
	public void setFOTOGRAFIA(byte[] fOTOGRAFIA) {
		FOTOGRAFIA = fOTOGRAFIA;
	}
	public String getSEXO() {
		return SEXO;
	}
	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}
	public Date getFECHA_NACIMIENTO() {
		return FECHA_NACIMIENTO;
	}
	public void setFECHA_NACIMIENTO(Date fECHA_NACIMIENTO) {
		FECHA_NACIMIENTO = fECHA_NACIMIENTO;
	}
	public String getLUGAR() {
		return LUGAR;
	}
	public void setLUGAR(String lUGAR) {
		LUGAR = lUGAR;
	}
	public String getNACIONALIDAD() {
		return NACIONALIDAD;
	}
	public void setNACIONALIDAD(String nACIONALIDAD) {
		NACIONALIDAD = nACIONALIDAD;
	}
	public String getESTADO_CIVIL() {
		return ESTADO_CIVIL;
	}
	public void setESTADO_CIVIL(String eSTADO_CIVIL) {
		ESTADO_CIVIL = eSTADO_CIVIL;
	}
	public String getLIBRETA_MILITAR() {
		return LIBRETA_MILITAR;
	}
	public void setLIBRETA_MILITAR(String lIBRETA_MILITAR) {
		LIBRETA_MILITAR = lIBRETA_MILITAR;
	}
	public String getCARNET_IESS() {
		return CARNET_IESS;
	}
	public void setCARNET_IESS(String cARNET_IESS) {
		CARNET_IESS = cARNET_IESS;
	}
	public String getTIPO_SANGRE() {
		return TIPO_SANGRE;
	}
	public void setTIPO_SANGRE(String tIPO_SANGRE) {
		TIPO_SANGRE = tIPO_SANGRE;
	}
	public Integer getESTATURA() {
		return ESTATURA;
	}
	public void setESTATURA(Integer eSTATURA) {
		ESTATURA = eSTATURA;
	}
	public String getPELO() {
		return PELO;
	}
	public void setPELO(String pELO) {
		PELO = pELO;
	}
	public String getTEZ() {
		return TEZ;
	}
	public void setTEZ(String tEZ) {
		TEZ = tEZ;
	}
	public String getDOMICILIO() {
		return DOMICILIO;
	}
	public void setDOMICILIO(String dOMICILIO) {
		DOMICILIO = dOMICILIO;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public String getTELEFONO2() {
		return TELEFONO2;
	}
	public void setTELEFONO2(String tELEFONO2) {
		TELEFONO2 = tELEFONO2;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getVIVO() {
		return VIVO;
	}
	public void setVIVO(String vIVO) {
		VIVO = vIVO;
	}
	public Date getFECHA_INGRESO() {
		return FECHA_INGRESO;
	}
	public void setFECHA_INGRESO(Date fECHA_INGRESO) {
		FECHA_INGRESO = fECHA_INGRESO;
	}
	public String getACTIVO() {
		return ACTIVO;
	}
	public void setACTIVO(String aCTIVO) {
		ACTIVO = aCTIVO;
	}
	public String getAFILIADO_COLEGIO() {
		return AFILIADO_COLEGIO;
	}
	public void setAFILIADO_COLEGIO(String aFILIADO_COLEGIO) {
		AFILIADO_COLEGIO = aFILIADO_COLEGIO;
	}
	public Integer getBIOMETRICO() {
		return BIOMETRICO;
	}
	public void setBIOMETRICO(Integer bIOMETRICO) {
		BIOMETRICO = bIOMETRICO;
	}
	public String getPRR_CODIGO_PERTENECE_A() {
		return PRR_CODIGO_PERTENECE_A;
	}
	public void setPRR_CODIGO_PERTENECE_A(String pRR_CODIGO_PERTENECE_A) {
		PRR_CODIGO_PERTENECE_A = pRR_CODIGO_PERTENECE_A;
	}
	public String getPRR_CAT_CODIGO_PERTENECE_A() {
		return PRR_CAT_CODIGO_PERTENECE_A;
	}
	public void setPRR_CAT_CODIGO_PERTENECE_A(String pRR_CAT_CODIGO_PERTENECE_A) {
		PRR_CAT_CODIGO_PERTENECE_A = pRR_CAT_CODIGO_PERTENECE_A;
	}
	public String getPRR_CAT_PRV_CODIGO_PERTENECE_A() {
		return PRR_CAT_PRV_CODIGO_PERTENECE_A;
	}
	public void setPRR_CAT_PRV_CODIGO_PERTENECE_A(String pRR_CAT_PRV_CODIGO_PERTENECE_A) {
		PRR_CAT_PRV_CODIGO_PERTENECE_A = pRR_CAT_PRV_CODIGO_PERTENECE_A;
	}
	public String getPRR_CODIGO() {
		return PRR_CODIGO;
	}
	public void setPRR_CODIGO(String pRR_CODIGO) {
		PRR_CODIGO = pRR_CODIGO;
	}
	public String getPRR_CAT_CODIGO() {
		return PRR_CAT_CODIGO;
	}
	public void setPRR_CAT_CODIGO(String pRR_CAT_CODIGO) {
		PRR_CAT_CODIGO = pRR_CAT_CODIGO;
	}
	public String getPRR_CAT_PRV_CODIGO() {
		return PRR_CAT_PRV_CODIGO;
	}
	public void setPRR_CAT_PRV_CODIGO(String pRR_CAT_PRV_CODIGO) {
		PRR_CAT_PRV_CODIGO = pRR_CAT_PRV_CODIGO;
	}
	public Integer getSER_CODIGO() {
		return SER_CODIGO;
	}
	public void setSER_CODIGO(Integer sER_CODIGO) {
		SER_CODIGO = sER_CODIGO;
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
	public Date getFECHA_PRIMER_INGRESO() {
		return FECHA_PRIMER_INGRESO;
	}
	public void setFECHA_PRIMER_INGRESO(Date fECHA_PRIMER_INGRESO) {
		FECHA_PRIMER_INGRESO = fECHA_PRIMER_INGRESO;
	}
	public String getTIPO_DISCAPACIDAD() {
		return TIPO_DISCAPACIDAD;
	}
	public void setTIPO_DISCAPACIDAD(String tIPO_DISCAPACIDAD) {
		TIPO_DISCAPACIDAD = tIPO_DISCAPACIDAD;
	}
	public Integer getPORC_DISCAPACIDAD() {
		return PORC_DISCAPACIDAD;
	}
	public void setPORC_DISCAPACIDAD(Integer pORC_DISCAPACIDAD) {
		PORC_DISCAPACIDAD = pORC_DISCAPACIDAD;
	}
	public String getCLAVE() {
		return CLAVE;
	}
	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}

	
	public byte[] getNUEVA_FOTO() {
		return NUEVA_FOTO;
	}
	public void setNUEVA_FOTO(byte[] nUEVA_FOTO) {
		NUEVA_FOTO = nUEVA_FOTO;
	}
	public Double getTALLA_CALZADO() {
		return TALLA_CALZADO;
	}
	public void setTALLA_CALZADO(Double tALLA_CALZADO) {
		TALLA_CALZADO = tALLA_CALZADO;
	}
	public Double getTALLA_GUANTE_MANOS() {
		return TALLA_GUANTE_MANOS;
	}
	public void setTALLA_GUANTE_MANOS(Double tALLA_GUANTE_MANOS) {
		TALLA_GUANTE_MANOS = tALLA_GUANTE_MANOS;
	}
	public String getTALLA_CINTURA() {
		return TALLA_CINTURA;
	}
	public void setTALLA_CINTURA(String tALLA_CINTURA) {
		TALLA_CINTURA = tALLA_CINTURA;
	}
	public String getTALLA_IMPERMEABLE() {
		return TALLA_IMPERMEABLE;
	}
	public void setTALLA_IMPERMEABLE(String tALLA_IMPERMEABLE) {
		TALLA_IMPERMEABLE = tALLA_IMPERMEABLE;
	}
	public String getTALLA_CASACA() {
		return TALLA_CASACA;
	}
	public void setTALLA_CASACA(String tALLA_CASACA) {
		TALLA_CASACA = tALLA_CASACA;
	}
	public String getTALLA_CHALECO_ESPE() {
		return TALLA_CHALECO_ESPE;
	}
	public void setTALLA_CHALECO_ESPE(String tALLA_CHALECO_ESPE) {
		TALLA_CHALECO_ESPE = tALLA_CHALECO_ESPE;
	}
	public Double getTALLA_MANDIL() {
		return TALLA_MANDIL;
	}
	public void setTALLA_MANDIL(Double tALLA_MANDIL) {
		TALLA_MANDIL = tALLA_MANDIL;
	}
	public String getPARTIDA_ANTICIPO() {
		return PARTIDA_ANTICIPO;
	}
	public void setPARTIDA_ANTICIPO(String pARTIDA_ANTICIPO) {
		PARTIDA_ANTICIPO = pARTIDA_ANTICIPO;
	}
	public String getID_DISCAPACIDAD() {
		return ID_DISCAPACIDAD;
	}
	public void setID_DISCAPACIDAD(String iD_DISCAPACIDAD) {
		ID_DISCAPACIDAD = iD_DISCAPACIDAD;
	}
	public Integer getNUMERO_HORAS_CURSO() {
		return NUMERO_HORAS_CURSO;
	}
	public void setNUMERO_HORAS_CURSO(Integer nUMERO_HORAS_CURSO) {
		NUMERO_HORAS_CURSO = nUMERO_HORAS_CURSO;
	}
	public Integer getNUMERO_CURSOS() {
		return NUMERO_CURSOS;
	}
	public void setNUMERO_CURSOS(Integer nUMERO_CURSOS) {
		NUMERO_CURSOS = nUMERO_CURSOS;
	}
	public String getCALLE_SECUNDARIA() {
		return CALLE_SECUNDARIA;
	}
	public void setCALLE_SECUNDARIA(String cALLE_SECUNDARIA) {
		CALLE_SECUNDARIA = cALLE_SECUNDARIA;
	}
	public String getCALLE_NUMERO() {
		return CALLE_NUMERO;
	}
	public void setCALLE_NUMERO(String cALLE_NUMERO) {
		CALLE_NUMERO = cALLE_NUMERO;
	}
	public String getEXTENSION_TELEFONICA() {
		return EXTENSION_TELEFONICA;
	}
	public void setEXTENSION_TELEFONICA(String eXTENSION_TELEFONICA) {
		EXTENSION_TELEFONICA = eXTENSION_TELEFONICA;
	}
	public String getAUTOIDENTIFICACION() {
		return AUTOIDENTIFICACION;
	}
	public void setAUTOIDENTIFICACION(String aUTOIDENTIFICACION) {
		AUTOIDENTIFICACION = aUTOIDENTIFICACION;
	}
	public String getAUTOPUEBLO() {
		return AUTOPUEBLO;
	}
	public void setAUTOPUEBLO(String aUTOPUEBLO) {
		AUTOPUEBLO = aUTOPUEBLO;
	}
	public String getEMAIL_PERSONAL() {
		return EMAIL_PERSONAL;
	}
	public void setEMAIL_PERSONAL(String eMAIL_PERSONAL) {
		EMAIL_PERSONAL = eMAIL_PERSONAL;
	}
	public String getSUSTITUTO_DISCAPACIDAD() {
		return SUSTITUTO_DISCAPACIDAD;
	}
	public void setSUSTITUTO_DISCAPACIDAD(String sUSTITUTO_DISCAPACIDAD) {
		SUSTITUTO_DISCAPACIDAD = sUSTITUTO_DISCAPACIDAD;
	}
	public String getSUSTITUTO_NOMBRES() {
		return SUSTITUTO_NOMBRES;
	}
	public void setSUSTITUTO_NOMBRES(String sUSTITUTO_NOMBRES) {
		SUSTITUTO_NOMBRES = sUSTITUTO_NOMBRES;
	}
	public String getCONDIC_DISCAPACIDAD() {
		return CONDIC_DISCAPACIDAD;
	}
	public void setCONDIC_DISCAPACIDAD(String cONDIC_DISCAPACIDAD) {
		CONDIC_DISCAPACIDAD = cONDIC_DISCAPACIDAD;
	}
	public String getTIPO_IDENT_DISCAPACIDAD() {
		return TIPO_IDENT_DISCAPACIDAD;
	}
	public void setTIPO_IDENT_DISCAPACIDAD(String tIPO_IDENT_DISCAPACIDAD) {
		TIPO_IDENT_DISCAPACIDAD = tIPO_IDENT_DISCAPACIDAD;
	}
	public String getTIPO_IDENT_TRABAJ() {
		return TIPO_IDENT_TRABAJ;
	}
	public void setTIPO_IDENT_TRABAJ(String tIPO_IDENT_TRABAJ) {
		TIPO_IDENT_TRABAJ = tIPO_IDENT_TRABAJ;
	}
	public String getRESIDENCIA_TRABAJ() {
		return RESIDENCIA_TRABAJ;
	}
	public void setRESIDENCIA_TRABAJ(String rESIDENCIA_TRABAJ) {
		RESIDENCIA_TRABAJ = rESIDENCIA_TRABAJ;
	}
	public String getCEDULA_DISCAPACIDAD() {
		return CEDULA_DISCAPACIDAD;
	}
	public void setCEDULA_DISCAPACIDAD(String cEDULA_DISCAPACIDAD) {
		CEDULA_DISCAPACIDAD = cEDULA_DISCAPACIDAD;
	}
	public Integer getANIO_ACTUALIZACION_DISC() {
		return ANIO_ACTUALIZACION_DISC;
	}
	public void setANIO_ACTUALIZACION_DISC(Integer aNIO_ACTUALIZACION_DISC) {
		ANIO_ACTUALIZACION_DISC = aNIO_ACTUALIZACION_DISC;
	}
	public Date getFECHA_ACTUALIZACION_DISC() {
		return FECHA_ACTUALIZACION_DISC;
	}
	public void setFECHA_ACTUALIZACION_DISC(Date fECHA_ACTUALIZACION_DISC) {
		FECHA_ACTUALIZACION_DISC = fECHA_ACTUALIZACION_DISC;
	}
	public String getNOMBRE_HOJA_VIDA() {
		return NOMBRE_HOJA_VIDA;
	}
	public void setNOMBRE_HOJA_VIDA(String nOMBRE_HOJA_VIDA) {
		NOMBRE_HOJA_VIDA = nOMBRE_HOJA_VIDA;
	}
	
	public byte[] getHOJA_VIDA() {
		return HOJA_VIDA;
	}
	public void setHOJA_VIDA(byte[] hOJA_VIDA) {
		HOJA_VIDA = hOJA_VIDA;
	}
	public String getREFERENCIA_PERSONAL() {
		return REFERENCIA_PERSONAL;
	}
	public void setREFERENCIA_PERSONAL(String rEFERENCIA_PERSONAL) {
		REFERENCIA_PERSONAL = rEFERENCIA_PERSONAL;
	}
	
	
	
	public Integer getPRO_CODIGO() {
		return PRO_CODIGO;
	}
	public void setPRO_CODIGO(Integer pRO_CODIGO) {
		PRO_CODIGO = pRO_CODIGO;
	}
	@Override
	public String toString() {
		return "SERVIDOR [CODIGO=" + CODIGO + ", CEDULA=" + CEDULA + ", FECHA_EMISION=" + FECHA_EMISION
				+ ", APELLIDO_PATERNO=" + APELLIDO_PATERNO + ", APELLIDO_MATERNO=" + APELLIDO_MATERNO
				+ ", PRIMER_NOMBRE=" + PRIMER_NOMBRE + ", SEGUNDO_NOMBRE=" + SEGUNDO_NOMBRE + ", FOTOGRAFIA="
				+ Arrays.toString(FOTOGRAFIA) + ", SEXO=" + SEXO + ", FECHA_NACIMIENTO=" + FECHA_NACIMIENTO + ", LUGAR="
				+ LUGAR + ", NACIONALIDAD=" + NACIONALIDAD + ", ESTADO_CIVIL=" + ESTADO_CIVIL + ", LIBRETA_MILITAR="
				+ LIBRETA_MILITAR + ", CARNET_IESS=" + CARNET_IESS + ", TIPO_SANGRE=" + TIPO_SANGRE + ", ESTATURA="
				+ ESTATURA + ", PELO=" + PELO + ", TEZ=" + TEZ + ", DOMICILIO=" + DOMICILIO + ", TELEFONO=" + TELEFONO
				+ ", TELEFONO2=" + TELEFONO2 + ", EMAIL=" + EMAIL + ", VIVO=" + VIVO + ", FECHA_INGRESO="
				+ FECHA_INGRESO + ", ACTIVO=" + ACTIVO + ", AFILIADO_COLEGIO=" + AFILIADO_COLEGIO + ", BIOMETRICO="
				+ BIOMETRICO + ", PRR_CODIGO_PERTENECE_A=" + PRR_CODIGO_PERTENECE_A + ", PRR_CAT_CODIGO_PERTENECE_A="
				+ PRR_CAT_CODIGO_PERTENECE_A + ", PRR_CAT_PRV_CODIGO_PERTENECE_A=" + PRR_CAT_PRV_CODIGO_PERTENECE_A
				+ ", PRR_CODIGO=" + PRR_CODIGO + ", PRR_CAT_CODIGO=" + PRR_CAT_CODIGO + ", PRR_CAT_PRV_CODIGO="
				+ PRR_CAT_PRV_CODIGO + ", PRO_CODIGO=" + PRO_CODIGO + ", SER_CODIGO=" + SER_CODIGO + ", CREATED_BY="
				+ CREATED_BY + ", CREATION_DATE=" + CREATION_DATE + ", LAST_UPDATED_BY=" + LAST_UPDATED_BY
				+ ", LAST_UPDATE_DATE=" + LAST_UPDATE_DATE + ", FECHA_PRIMER_INGRESO=" + FECHA_PRIMER_INGRESO
				+ ", TIPO_DISCAPACIDAD=" + TIPO_DISCAPACIDAD + ", PORC_DISCAPACIDAD=" + PORC_DISCAPACIDAD + ", CLAVE="
				+ CLAVE + ", NUEVA_FOTO=" + Arrays.toString(NUEVA_FOTO) + ", TALLA_CALZADO=" + TALLA_CALZADO
				+ ", TALLA_GUANTE_MANOS=" + TALLA_GUANTE_MANOS + ", TALLA_CINTURA=" + TALLA_CINTURA
				+ ", TALLA_IMPERMEABLE=" + TALLA_IMPERMEABLE + ", TALLA_CASACA=" + TALLA_CASACA
				+ ", TALLA_CHALECO_ESPE=" + TALLA_CHALECO_ESPE + ", TALLA_MANDIL=" + TALLA_MANDIL
				+ ", PARTIDA_ANTICIPO=" + PARTIDA_ANTICIPO + ", ID_DISCAPACIDAD=" + ID_DISCAPACIDAD
				+ ", NUMERO_HORAS_CURSO=" + NUMERO_HORAS_CURSO + ", NUMERO_CURSOS=" + NUMERO_CURSOS
				+ ", CALLE_SECUNDARIA=" + CALLE_SECUNDARIA + ", CALLE_NUMERO=" + CALLE_NUMERO
				+ ", EXTENSION_TELEFONICA=" + EXTENSION_TELEFONICA + ", AUTOIDENTIFICACION=" + AUTOIDENTIFICACION
				+ ", AUTOPUEBLO=" + AUTOPUEBLO + ", EMAIL_PERSONAL=" + EMAIL_PERSONAL + ", SUSTITUTO_DISCAPACIDAD="
				+ SUSTITUTO_DISCAPACIDAD + ", SUSTITUTO_NOMBRES=" + SUSTITUTO_NOMBRES + ", CONDIC_DISCAPACIDAD="
				+ CONDIC_DISCAPACIDAD + ", TIPO_IDENT_DISCAPACIDAD=" + TIPO_IDENT_DISCAPACIDAD + ", TIPO_IDENT_TRABAJ="
				+ TIPO_IDENT_TRABAJ + ", RESIDENCIA_TRABAJ=" + RESIDENCIA_TRABAJ + ", CEDULA_DISCAPACIDAD="
				+ CEDULA_DISCAPACIDAD + ", ANIO_ACTUALIZACION_DISC=" + ANIO_ACTUALIZACION_DISC
				+ ", FECHA_ACTUALIZACION_DISC=" + FECHA_ACTUALIZACION_DISC + ", NOMBRE_HOJA_VIDA=" + NOMBRE_HOJA_VIDA
				+ ", HOJA_VIDA=" + Arrays.toString(HOJA_VIDA) + ", REFERENCIA_PERSONAL=" + REFERENCIA_PERSONAL + "]";
	}
	
	

	
}
