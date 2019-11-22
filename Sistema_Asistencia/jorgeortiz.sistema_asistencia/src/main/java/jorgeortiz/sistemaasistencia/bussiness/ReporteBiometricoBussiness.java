package jorgeortiz.sistemaasistencia.bussiness;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.BiometricoDepartamentoDAO;
import jorgeortiz.sistemaasistencia.dao.BiometricoPersonaDAO;
import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoDepartamentoSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoPersonaSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.ACC_PER;
import jorgeortiz.sistemaasistencia.util.FormatterDate;

@Stateless
public class ReporteBiometricoBussiness {
	
	@Inject
	private MainReporteDAO mdao;
	
	private BiometricoPersonaDAO bpDAO = new BiometricoPersonaDAO();
	
	private BiometricoDepartamentoDAO bdDAO = new BiometricoDepartamentoDAO();
	
	public List<BiometricoPersonaSQL> getBiometricoPersonas(String codigoBiometrico, Date fechaDesde, Date fechaHasta) throws Exception{
		
		String fd = FormatterDate.formatearFecha(fechaDesde);
		String fh = FormatterDate.formatearFecha(fechaHasta);
		
		List<BiometricoPersonaSQL> biometricoPersonas = bpDAO.getBiometricoPersonas(codigoBiometrico, fd, fh);
		
		if(!(biometricoPersonas == null)) {
			return biometricoPersonas;
		}else
			throw new Exception("No hay datos");
				
				
	}
	
	
	public List<BiometricoDepartamentoSQL> getBiometricoDepartamentos(int codigoDepartamento, Date fechaDesde, Date fechaHasta) throws Exception{
		
		String fd = FormatterDate.formatearFecha(fechaDesde);
		String fh = FormatterDate.formatearFecha(fechaHasta);
		
		List<BiometricoDepartamentoSQL> biometricoDepartamento = bdDAO.getBiometricoDepartamentos(codigoDepartamento, fd, fh);
		
		if(!(biometricoDepartamento == null)) {
			return biometricoDepartamento;
		}else
			throw new Exception("No hay datos");
				
				
	}
	
	public List<EMPLEADO> getEmpleados() throws Exception{
		List<EMPLEADO> empleados = mdao.getEmpleados();
		
		if(!(empleados == null)) {
			return empleados;
		}else
			throw new Exception("No hay datos de empleados");
	}
	

}
