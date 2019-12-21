package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RELOJ {
	@Id	
	@NotNull
	private Integer RELO_ID;
	@NotNull
	@Size(min = 1, max = 30)
	private String DESCRIPCION;
	@Size(min = 1, max = 30)
	private String IP;
	@Size(min = 1, max = 30)
	private String PUERTO_COM;
	@Size(min = 1, max = 30)
	private String VELOCIDAD_COM;
	@Size(min = 1, max = 30)
	private String MARCA;
	@Size(min = 1, max = 30)
	private String MODELO;
	@Size(min = 1, max = 30)
	private String SERIE;
	public Integer getRELO_ID() {
		return RELO_ID;
	}
	public void setRELO_ID(Integer rELO_ID) {
		RELO_ID = rELO_ID;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getPUERTO_COM() {
		return PUERTO_COM;
	}
	public void setPUERTO_COM(String pUERTO_COM) {
		PUERTO_COM = pUERTO_COM;
	}
	public String getVELOCIDAD_COM() {
		return VELOCIDAD_COM;
	}
	public void setVELOCIDAD_COM(String vELOCIDAD_COM) {
		VELOCIDAD_COM = vELOCIDAD_COM;
	}
	public String getMARCA() {
		return MARCA;
	}
	public void setMARCA(String mARCA) {
		MARCA = mARCA;
	}
	public String getMODELO() {
		return MODELO;
	}
	public void setMODELO(String mODELO) {
		MODELO = mODELO;
	}
	public String getSERIE() {
		return SERIE;
	}
	public void setSERIE(String sERIE) {
		SERIE = sERIE;
	}
	@Override
	public String toString() {
		return "RELOJ [RELO_ID=" + RELO_ID + ", DESCRIPCION=" + DESCRIPCION + ", IP=" + IP + ", PUERTO_COM="
				+ PUERTO_COM + ", VELOCIDAD_COM=" + VELOCIDAD_COM + ", MARCA=" + MARCA + ", MODELO=" + MODELO
				+ ", SERIE=" + SERIE + "]";
	}
	
}
