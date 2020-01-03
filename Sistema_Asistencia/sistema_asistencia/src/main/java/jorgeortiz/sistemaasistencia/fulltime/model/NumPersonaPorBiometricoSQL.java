package jorgeortiz.sistemaasistencia.fulltime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "queryNumPersonaPorBiometrico",
query= "select r.relo_id,\r\n" + 
		"       descripcion,\r\n" + 
		"            (select count(distinct(e.codigo_empleado))\r\n" + 
		"             from fulltime.timbre t,\r\n" + 
		"                 fulltime.empleado e\r\n" + 
		"             where \r\n" + 
		"                  e.codigo_empleado = t.codigo_empleado \r\n" + 
		"                  and t.fecha_hora_timbre between TO_DATE(:fechaDesde, 'dd/MM/YYYY HH24:MI:ss') and TO_DATE(:fechaHasta, 'dd/MM/YYYY HH24:MI:ss')\r\n" + 
		"                  and to_number(t.codigo_reloj) = r.relo_id \r\n" + 
		"             ) numero_personas       \r\n" + 
		"from fulltime.reloj r\r\n" + 
		"order by r.relo_id", resultClass = NumPersonaPorBiometricoSQL.class
)
public class NumPersonaPorBiometricoSQL {
	
	@Id
	private Integer RELO_ID;
	
	private String DESCRIPCION;
	
	private Integer NUMERO_PERSONAS;


	public Integer getRELO_ID() {
		return RELO_ID;
	}

	public void setRELO_ID(Integer rELO_ID) {
		RELO_ID = rELO_ID;
	}

	public void setNUMERO_PERSONAS(Integer nUMERO_PERSONAS) {
		NUMERO_PERSONAS = nUMERO_PERSONAS;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	public int getNUMERO_PERSONAS() {
		return NUMERO_PERSONAS;
	}

	public void setNUMERO_PERSONAS(int nUMERO_PERSONAS) {
		NUMERO_PERSONAS = nUMERO_PERSONAS;
	}

	@Override
	public String toString() {
		return "NumPersonaPorBiometricoSQL [RELO_ID=" + RELO_ID + ", DESCRIPCION=" + DESCRIPCION
				+ ", NUMERO_PERSONAS=" + NUMERO_PERSONAS + "]";
	}
	
	
	
}
