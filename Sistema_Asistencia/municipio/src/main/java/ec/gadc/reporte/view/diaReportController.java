package ec.gadc.reporte.view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

import ec.gadc.reporte.dao.diaReporteDAO;
import ec.gadc.reporte.dao.mainReporteDAO;
import ec.gadc.reporte.model.DEPARTAMENTO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.TIMBRE;
@ManagedBean
@ViewScoped
public class diaReportController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private sesionController sesionController;
	@Inject
	private diaReporteDAO dao;
	@Inject
	private mainReporteDAO mdao;
	@Inject
	private mainReporteDAO daoMain;
	private List<EMPLEADO> empleados;
	private List<DEPARTAMENTO> departamentos;
	private List<TIMBRE> timbres;
	private List<TIMBRE> timbresTemp;
	private List<TIMBRE> timbresAtrasado;
	private List<EMPLEADO> emps_sin_timbres;
	private ExcelOptions excelOpt;
	private PDFOptions pdfOpt;
	private String nombre_pdf;
	
	@PostConstruct
	public void init(){
		empleados=mdao.getEmpleados();
		departamentos=mdao.getDepartamentos();
	}
	public void checkTodoDia(ActionEvent actionEvent) throws IOException{
		this.setNombre_pdf("REPORTE DE TIMBRES DEL DIA");
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//	        String dateInString = "03/03/2017";

	        try {

//	            Date date = formatter.parse(dateInString);
	            Date myDate = new Date();
	            SimpleDateFormat fecha_actual=new SimpleDateFormat("dd/MM/yyyy");
	            String date_new=fecha_actual.format(myDate);
	            Date date_send=formatter.parse(date_new);
	           // System.out.println(date);
	         
	           // System.out.println("fecha pers> "+formatter.format(date));
//	            this.setTimbres(dao.getTimbres(date));
	            this.setTimbres(dao.getTimbres(date_send));
	       
	            if(!this.getTimbres().isEmpty()){
//	            	for(TIMBRE t:this.getTimbres()){
//	            		System.out.println("cod_em > "+t.getCODIGO_EMPLEADO());
//	            		System.out.println("fecha_tim > "+t.getFECHA_HORA_TIMBRE());
//	            	}
		            addMessage(this.getTimbres().size()+" Registros en este día!!");
	            }else addMessage(" No hay registros");
	            	if(this.getTimbres().equals(null))addMessage(" Nada que actualizar!!");

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			//Aquí colocas tu objeto tipo Date
//			 Date myDate = new Date();
//
//			 //Aquí obtienes el formato que deseas
//			 System.out.println("fecha actual"+new SimpleDateFormat("dd/MM/yyyy").format(myDate));
//			
	}
	public void checkTempranoManiana(ActionEvent actionEvent) throws IOException{
		this.setNombre_pdf("REPORTE DE TIMBRES - EMPLEADOS PUNTUALES");
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			
			Date dates = new Date();
			String fecha_dia=formatter.format(dates);
			String fecha_dia1=fecha_dia+" 05.00.00 a";
			String fecha_dia2=fecha_dia+" 08.00.00 a";
			
			String fecha_dia3="16/02/2017 05.00.00 a";
			String fecha_dia4="15/03/2017 23.00.00 a";
			
			Date date = formatter_send.parse(fecha_dia1);
			Date date1 = formatter_send.parse(fecha_dia2);
			this.setTimbresTemp(dao.getTimbresTemp(date,date1));
			 if(!this.getTimbresTemp().isEmpty()){
//	            	for(TIMBRE t:this.getTimbres()){
//	            		System.out.println("cod_em > "+t.getCODIGO_EMPLEADO());
//	            		System.out.println("fecha_tim > "+t.getFECHA_HORA_TIMBRE());
//	            	}
		            addMessage(this.getTimbresTemp().size()+" Registros en este día temp!!");
	            }else addMessage(" No hay registros temp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void checkTardeManiana(ActionEvent actionEvent) throws IOException{
		this.setNombre_pdf("REPORTE DE TIMBRES DEL DIA - EMPLEADOS ATRASADOS");
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			Date dates = new Date();
			String fecha_dia=formatter.format(dates);
			String fecha_dia1=fecha_dia+" 08.10.00 a";
			String fecha_dia2=fecha_dia+" 10.00.00 a";
			
			String fecha_dia3="20/02/2017 08.01.00 a";
			String fecha_dia4="20/02/2017 11.00.00 a";
			
			Date date = formatter_send.parse(fecha_dia1);
			Date date1 = formatter_send.parse(fecha_dia2);
			this.setTimbresAtrasado(dao.getTimbresTemp(date,date1));
			 if(!this.getTimbresAtrasado().isEmpty()){
				 
				 
//	            	for(TIMBRE t:this.getTimbres()){
//	            		System.out.println("cod_em > "+t.getCODIGO_EMPLEADO());
//	            		System.out.println("fecha_tim > "+t.getFECHA_HORA_TIMBRE());
//	            	}
		            addMessage(this.getTimbresAtrasado().size()+" Registros en este día temp!!");
	            }else addMessage(" No hay registros temp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkNoHanTimbrado(ActionEvent actionEvent) throws IOException{
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			Date dates = new Date();
			String fecha_dia=formatter.format(dates);
			String fecha_dia1=fecha_dia+" 05.00.00 a";
			String fecha_dia2=fecha_dia+" 11.00.00 a";
			 System.out.println("f1> "+fecha_dia1);
			 System.out.println("f1> "+fecha_dia2);
			 
//			String fecha_dia3="20/02/2017 06.00.00 a";
//			String fecha_dia4="20/02/2017 20.00.00 a";
			
			Date date = formatter_send.parse(fecha_dia1);
			Date date1 = formatter_send.parse(fecha_dia2);
			this.setEmps_sin_timbres(dao.getNoHanTimbrado(date,date1));
			int cont=0;
			 if(!this.getEmps_sin_timbres().isEmpty()){
//	            	for(EMPLEADO t:this.getEmps_sin_timbres()){
//	            		System.out.println("cod_em > "+t.getCODIGO_EMPLEADO());
//	            		System.out.println("apellidos>>> "+t.getAPELLIDO());
//	            		System.out.println("nombres > "+t.getNOMBRE());
//	            		cont++;
//	            	}
//	            	System.out.println("total no timbran "+cont);
		            addMessage(this.getEmps_sin_timbres().size()+" Registros en este día temp!!");
	            }else addMessage(" No hay registros temp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	
	}
	public String checkTiempo(Date fecha) throws ParseException{
		if(fecha!=null){
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 Date dates = fecha;
			return formatter.format(dates);
		}else return "sin fecha";
		
		
	}
	
	public String checkRazonSocialEmpApellido(String cod_bio){
		//System.out.println("checkCOD >"+cod_bio);
		for(EMPLEADO e:this.getEmpleados()){
			if(e.getCODIGO_EMPLEADO().equals(cod_bio)){
				return e.getNOMBRE();
			}
		}
		return  "Sin nombre";
		
//		String a=dao.getRazonSocialEmpApellido(cod_bio);
//		if(a==null){
//			return "Sin nombre";
//		}else return a;
	
	}
	public String checkRazonSocialEmpNombre(String cod_bio){
		for(EMPLEADO e:this.getEmpleados()){
			if(e.getCODIGO_EMPLEADO().equals(cod_bio)){
				return e.getAPELLIDO();
			}
		}
		return "Sin apellido";
		
//		String a=dao.getRazonSocialEmpNombre(cod_bio);
//		if(a==null){
//			return "Sin apellido";
//		}else return a;
		
	}
	public String checkDepartamento(String cod_bio){
		Integer aux=0;
		for(EMPLEADO e:this.getEmpleados()){
				if(e.getCODIGO_EMPLEADO().equals(cod_bio)){
					aux=e.getDEPA_ID();
				}
		}
		for(DEPARTAMENTO d:this.getDepartamentos()){
			if(d.getDEPA_ID().equals(aux)){
				return d.getDESCRIPCION();
			}
		}
		return "Sin departamento";
//		String a=dao.getDepartamento(cod_bio);
//		if(a==null){
//			return "Sin departamento";
//		}else return a;
		
	}
	
	 public void postProcessXLS(Object document) {
	        HSSFWorkbook wb = (HSSFWorkbook) document;
	        HSSFSheet sheet = wb.getSheetAt(0);
	        HSSFRow header = sheet.getRow(0);
	         
	        HSSFCellStyle cellStyle = wb.createCellStyle();  
	        cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
	        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	         
	        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
	            HSSFCell cell = header.getCell(i);
	            cell.setCellValue(cell.getStringCellValue().toUpperCase());
	            cell.setCellStyle(cellStyle);
	            sheet.autoSizeColumn(i);
	        }
	    }
	 public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
	        Document pdf = (Document) document;
	        pdf.open();
	        pdf.setPageSize(PageSize.A4);	  	       
	        pdf.setPageCount(1000000);
	        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "alcpdf.png";
	        
	        pdf.add(Image.getInstance(logo));
	        pdf.add(new Paragraph(this.getNombre_pdf(),FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, new Color(0, 0, 0))));
	        SimpleDateFormat formato = new SimpleDateFormat("d MMMM yyyy HH:mm:ss");

	        pdf.add(new Phrase("Fecha: " + formato.format(new Date())));
	        
	        
	 }


	 


//	public ArrayList getEmpleados() {
//		return empleados;
//	}
//	public void setEmpleados(ArrayList empleados) {
//		this.empleados = empleados;
//	}
	public List<DEPARTAMENTO> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<DEPARTAMENTO> departamentos) {
		this.departamentos = departamentos;
	}
	public List<TIMBRE> getTimbres() {
		return timbres;
	}


	public void setTimbres(List<TIMBRE> timbres) {
		this.timbres = timbres;
	}
	public List<TIMBRE> getTimbresTemp() {
		return timbresTemp;
	}
	public void setTimbresTemp(List<TIMBRE> timbresTemp) {
		this.timbresTemp = timbresTemp;
	}
	public List<TIMBRE> getTimbresAtrasado() {
		return timbresAtrasado;
	}
	public void setTimbresAtrasado(List<TIMBRE> timbresAtrasado) {
		this.timbresAtrasado = timbresAtrasado;
	}
	public List<EMPLEADO> getEmps_sin_timbres() {
		return emps_sin_timbres;
	}
	public void setEmps_sin_timbres(List<EMPLEADO> emps_sin_timbres) {
		this.emps_sin_timbres = emps_sin_timbres;
	}
	public List<EMPLEADO> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EMPLEADO> empleados) {
		this.empleados = empleados;
	}
	public String getNombre_pdf() {
		return nombre_pdf;
	}
	public void setNombre_pdf(String nombre_pdf) {
		this.nombre_pdf = nombre_pdf;
	}
	
	

}
