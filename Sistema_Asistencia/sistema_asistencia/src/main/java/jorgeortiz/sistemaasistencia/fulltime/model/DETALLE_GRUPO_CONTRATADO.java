package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DETALLE_GRUPO_CONTRATADO {
	@Id	
	@NotNull
	private Integer DGCO_ID;
	private Integer GRCO_ID;
	@NotNull
	@Size(min = 1, max = 255)
	private String DESCRIPCION;
	@NotNull
	private Integer HORAS_VACACION;
	@NotNull
	@Digits(fraction = 2, integer = 38)
	private Double DIAS_INCREMENTO;
	@NotNull
	private Integer ANIOS;
	private float TOTAL_HORAS;
	@NotNull
	private float MAXIMO_HORAS;
	@NotNull
	private Integer MESES_PERIODO;
	private Integer HORAS_ADICIONAL;
	private Integer HORAS_ADICIONAL1;
	private Integer HORAS_EXTRAORDINARIAS;
	private Integer HORAS_LABORABLES;
	private Integer HORAS_SUPLEMENTARIAS;
	private Integer NIVEL;
	private Integer PORCENTAJE;
	private Integer PORCENTAJE1;
	private Integer PORCENTAJE2;
	private Integer PORCENTAJE3;
	private Integer PORCENTAJE4;
	private Integer ACTIVAR_REGLA;
	private Integer ACTIVAR_RECUPERABLE;
	private Integer SOLICITUD_VACACION;
	private Integer PERMISO_CARGO;
	private Integer MAXIMO_HORAS_EXTRA;
	private Integer MAXIMO_HORAS_SEMANAL;
	private Integer HORAS_AVISO;
	public Integer getDGCO_ID() {
		return DGCO_ID;
	}
	public void setDGCO_ID(Integer dGCO_ID) {
		DGCO_ID = dGCO_ID;
	}
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
	public Integer getHORAS_VACACION() {
		return HORAS_VACACION;
	}
	public void setHORAS_VACACION(Integer hORAS_VACACION) {
		HORAS_VACACION = hORAS_VACACION;
	}
	public Double getDIAS_INCREMENTO() {
		return DIAS_INCREMENTO;
	}
	public void setDIAS_INCREMENTO(Double dIAS_INCREMENTO) {
		DIAS_INCREMENTO = dIAS_INCREMENTO;
	}
	public Integer getANIOS() {
		return ANIOS;
	}
	public void setANIOS(Integer aNIOS) {
		ANIOS = aNIOS;
	}
	public float getTOTAL_HORAS() {
		return TOTAL_HORAS;
	}
	public void setTOTAL_HORAS(float tOTAL_HORAS) {
		TOTAL_HORAS = tOTAL_HORAS;
	}
	public float getMAXIMO_HORAS() {
		return MAXIMO_HORAS;
	}
	public void setMAXIMO_HORAS(float mAXIMO_HORAS) {
		MAXIMO_HORAS = mAXIMO_HORAS;
	}
	public Integer getMESES_PERIODO() {
		return MESES_PERIODO;
	}
	public void setMESES_PERIODO(Integer mESES_PERIODO) {
		MESES_PERIODO = mESES_PERIODO;
	}
	public Integer getHORAS_ADICIONAL() {
		return HORAS_ADICIONAL;
	}
	public void setHORAS_ADICIONAL(Integer hORAS_ADICIONAL) {
		HORAS_ADICIONAL = hORAS_ADICIONAL;
	}
	public Integer getHORAS_ADICIONAL1() {
		return HORAS_ADICIONAL1;
	}
	public void setHORAS_ADICIONAL1(Integer hORAS_ADICIONAL1) {
		HORAS_ADICIONAL1 = hORAS_ADICIONAL1;
	}
	public Integer getHORAS_EXTRAORDINARIAS() {
		return HORAS_EXTRAORDINARIAS;
	}
	public void setHORAS_EXTRAORDINARIAS(Integer hORAS_EXTRAORDINARIAS) {
		HORAS_EXTRAORDINARIAS = hORAS_EXTRAORDINARIAS;
	}
	public Integer getHORAS_LABORABLES() {
		return HORAS_LABORABLES;
	}
	public void setHORAS_LABORABLES(Integer hORAS_LABORABLES) {
		HORAS_LABORABLES = hORAS_LABORABLES;
	}
	public Integer getHORAS_SUPLEMENTARIAS() {
		return HORAS_SUPLEMENTARIAS;
	}
	public void setHORAS_SUPLEMENTARIAS(Integer hORAS_SUPLEMENTARIAS) {
		HORAS_SUPLEMENTARIAS = hORAS_SUPLEMENTARIAS;
	}
	public Integer getNIVEL() {
		return NIVEL;
	}
	public void setNIVEL(Integer nIVEL) {
		NIVEL = nIVEL;
	}
	public Integer getPORCENTAJE() {
		return PORCENTAJE;
	}
	public void setPORCENTAJE(Integer pORCENTAJE) {
		PORCENTAJE = pORCENTAJE;
	}
	public Integer getPORCENTAJE1() {
		return PORCENTAJE1;
	}
	public void setPORCENTAJE1(Integer pORCENTAJE1) {
		PORCENTAJE1 = pORCENTAJE1;
	}
	public Integer getPORCENTAJE2() {
		return PORCENTAJE2;
	}
	public void setPORCENTAJE2(Integer pORCENTAJE2) {
		PORCENTAJE2 = pORCENTAJE2;
	}
	public Integer getPORCENTAJE3() {
		return PORCENTAJE3;
	}
	public void setPORCENTAJE3(Integer pORCENTAJE3) {
		PORCENTAJE3 = pORCENTAJE3;
	}
	public Integer getPORCENTAJE4() {
		return PORCENTAJE4;
	}
	public void setPORCENTAJE4(Integer pORCENTAJE4) {
		PORCENTAJE4 = pORCENTAJE4;
	}
	public Integer getACTIVAR_REGLA() {
		return ACTIVAR_REGLA;
	}
	public void setACTIVAR_REGLA(Integer aCTIVAR_REGLA) {
		ACTIVAR_REGLA = aCTIVAR_REGLA;
	}
	public Integer getACTIVAR_RECUPERABLE() {
		return ACTIVAR_RECUPERABLE;
	}
	public void setACTIVAR_RECUPERABLE(Integer aCTIVAR_RECUPERABLE) {
		ACTIVAR_RECUPERABLE = aCTIVAR_RECUPERABLE;
	}
	public Integer getSOLICITUD_VACACION() {
		return SOLICITUD_VACACION;
	}
	public void setSOLICITUD_VACACION(Integer sOLICITUD_VACACION) {
		SOLICITUD_VACACION = sOLICITUD_VACACION;
	}
	public Integer getPERMISO_CARGO() {
		return PERMISO_CARGO;
	}
	public void setPERMISO_CARGO(Integer pERMISO_CARGO) {
		PERMISO_CARGO = pERMISO_CARGO;
	}
	public Integer getMAXIMO_HORAS_EXTRA() {
		return MAXIMO_HORAS_EXTRA;
	}
	public void setMAXIMO_HORAS_EXTRA(Integer mAXIMO_HORAS_EXTRA) {
		MAXIMO_HORAS_EXTRA = mAXIMO_HORAS_EXTRA;
	}
	public Integer getMAXIMO_HORAS_SEMANAL() {
		return MAXIMO_HORAS_SEMANAL;
	}
	public void setMAXIMO_HORAS_SEMANAL(Integer mAXIMO_HORAS_SEMANAL) {
		MAXIMO_HORAS_SEMANAL = mAXIMO_HORAS_SEMANAL;
	}
	public Integer getHORAS_AVISO() {
		return HORAS_AVISO;
	}
	public void setHORAS_AVISO(Integer hORAS_AVISO) {
		HORAS_AVISO = hORAS_AVISO;
	}
	@Override
	public String toString() {
		return "DETALLE_GRUPO_CONTRATADO [DGCO_ID=" + DGCO_ID + ", GRCO_ID=" + GRCO_ID + ", DESCRIPCION=" + DESCRIPCION
				+ ", HORAS_VACACION=" + HORAS_VACACION + ", DIAS_INCREMENTO=" + DIAS_INCREMENTO + ", ANIOS=" + ANIOS
				+ ", TOTAL_HORAS=" + TOTAL_HORAS + ", MAXIMO_HORAS=" + MAXIMO_HORAS + ", MESES_PERIODO=" + MESES_PERIODO
				+ ", HORAS_ADICIONAL=" + HORAS_ADICIONAL + ", HORAS_ADICIONAL1=" + HORAS_ADICIONAL1
				+ ", HORAS_EXTRAORDINARIAS=" + HORAS_EXTRAORDINARIAS + ", HORAS_LABORABLES=" + HORAS_LABORABLES
				+ ", HORAS_SUPLEMENTARIAS=" + HORAS_SUPLEMENTARIAS + ", NIVEL=" + NIVEL + ", PORCENTAJE=" + PORCENTAJE
				+ ", PORCENTAJE1=" + PORCENTAJE1 + ", PORCENTAJE2=" + PORCENTAJE2 + ", PORCENTAJE3=" + PORCENTAJE3
				+ ", PORCENTAJE4=" + PORCENTAJE4 + ", ACTIVAR_REGLA=" + ACTIVAR_REGLA + ", ACTIVAR_RECUPERABLE="
				+ ACTIVAR_RECUPERABLE + ", SOLICITUD_VACACION=" + SOLICITUD_VACACION + ", PERMISO_CARGO="
				+ PERMISO_CARGO + ", MAXIMO_HORAS_EXTRA=" + MAXIMO_HORAS_EXTRA + ", MAXIMO_HORAS_SEMANAL="
				+ MAXIMO_HORAS_SEMANAL + ", HORAS_AVISO=" + HORAS_AVISO + "]";
	}
	
	
	
	
	
}
