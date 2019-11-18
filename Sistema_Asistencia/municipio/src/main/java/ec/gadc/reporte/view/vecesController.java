package ec.gadc.reporte.view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
public class vecesController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private mainReporteDAO mdao;
	@Inject
	private diaReporteDAO dao;
	private List<EMPLEADO> empleados;
	private List<DEPARTAMENTO> departamentos;
	private List<TIMBRE> timbres;
	private String nombre_pdf;
	private String [][] array=null;
	private List<TIMBRE>listaLimpia;
	private Date fecha1;
	private Date fecha2;
	
	@PostConstruct
	public void init(){
		empleados=mdao.getEmpleados();
		departamentos=mdao.getDepartamentos();
		
	}
	
	public void checkPeriodoVeces(ActionEvent actionEvent)throws IOException, ParseException{
		System.out.println("Maicoly Guerrero");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy");
//		String dateInString = "01/02/2017";
//		String dateInString1 = "28/02/2017";
		try{
			  String fecha1 = df.format(this.getFecha1());
			  fecha1 = fecha1+"  05.00.00 a";
			  String fecha2 = df.format(this.getFecha2());
			  fecha2 = fecha2+"  23.50.00 a";
			  Date date = formatter_send.parse(fecha1);
			  Date date1 = formatter_send.parse(fecha2);
			this.setTimbres(mdao.getTimbresPeriodoVeces(date,date1));
//			for(TIMBRE t:this.getTimbres()){
//				System.out.println("COD> "+t.getCODIGO_EMPLEADO());
//			}
			List ar = new ArrayList();
			listaLimpia = new ArrayList();
			 Map<String, TIMBRE> mapPersonas = new HashMap<String, TIMBRE>(this.getTimbres().size());
			 int cont1=0;
			 for(TIMBRE p : this.getTimbres()) {
				 mapPersonas.put(p.getCODIGO_EMPLEADO(), p);
				 cont1++;
			 }
//			 System.out.println("cont a >>>> +"+cont1);
			 cont1=0;
			 for(Entry<String, TIMBRE> p : mapPersonas.entrySet()) {
				 listaLimpia.add(p.getValue());
//				 System.out.println(p.getValue());
				 cont1++;
				 }
//				 System.out.println("cont d> "+cont1);
				 
//			System.out.println("TImbres a>>>> +"+cont1);
			
			this.setNombre_pdf("REPORTE DE NUMERO DE VECES TIMBRADAS");
			String aux;
			String aux1="";
			int cont=0;
			System.out.println("Entrando a for "+this.getTimbres().size());
			array=new String[this.getListaLimpia().size()+1][2];
			int cont11=0;
			for(TIMBRE t:this.getTimbres()){
				aux=t.getCODIGO_EMPLEADO();
				if(!aux.equals(aux1)){
					array[cont11][0]=aux1;
					array[cont11][1]=cont+"";
					cont11=cont11+1;
					cont=0;
				}
				array[0][0]=null;
				cont=cont+1;
				aux1=t.getCODIGO_EMPLEADO();
			}
			array[cont11][0]=aux1;
			array[cont11][1]=cont+"";
//			for(int i=0;i<this.array.length;i++){
//				System.out.println(array[i][0]+" "+array[i][1]);
//			}
			addMessage("Hecho!!");
		}catch(NullPointerException e){
			addMessage("Error global");
			throw e;
		}
	}
	public String nroVecesMarcadas(String cod_emp){
		for(int i=1;i<this.array.length;i++){
			if(array[i][0]==cod_emp){
				return array[i][1];
			}
		}
		return "CERO";
	}
	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	
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
			
//			String a=dao.getRazonSocialEmpApellido(cod_bio);
//			if(a==null){
//				return "Sin nombre";
//			}else return a;
		
		}
		public String checkRazonSocialEmpNombre(String cod_bio){
			for(EMPLEADO e:this.getEmpleados()){
				if(e.getCODIGO_EMPLEADO().equals(cod_bio)){
					return e.getAPELLIDO();
				}
			}
			return "Sin apellido";
			
//			String a=dao.getRazonSocialEmpNombre(cod_bio);
//			if(a==null){
//				return "Sin apellido";
//			}else return a;
			
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
//			String a=dao.getDepartamento(cod_bio);
//			if(a==null){
//				return "Sin departamento";
//			}else return a;
			
		}
	public List<EMPLEADO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EMPLEADO> empleados) {
		this.empleados = empleados;
	}

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

	public String getNombre_pdf() {
		return nombre_pdf;
	}

	public void setNombre_pdf(String nombre_pdf) {
		this.nombre_pdf = nombre_pdf;
	}

	public String[][] getArray() {
		return array;
	}

	public void setArray(String[][] array) {
		this.array = array;
	}

	public List<TIMBRE> getListaLimpia() {
		return listaLimpia;
	}

	public void setListaLimpia(List<TIMBRE> listaLimpia) {
		this.listaLimpia = listaLimpia;
	}

	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}



	
	
	
}
