package ec.gadc.reporte.view;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.model.DefaultStreamedContent;

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
import ec.gadc.reporte.model.CARGO;
import ec.gadc.reporte.model.DEPARTAMENTO;
import ec.gadc.reporte.model.EMPLEADO;
import ec.gadc.reporte.model.SERVIDOR;
import ec.gadc.reporte.model.TIMBRE;
import ec.muni.nomina.model.ACC_PER;
import ec.muni.nomina.model.BJUSTIF;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
@Named
@ViewScoped
public class paramReportController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private mainReporteDAO mdao;
	@Inject
	private diaReporteDAO dao;
	private List<TIMBRE> timbres;
	private String biometrico;
	private List<EMPLEADO> empleados;
	private List<DEPARTAMENTO> departamentos;
	private List<CARGO> cargos;
	private Date fecha1;
	private Date fechaWS1;
	private Date fecha2;
	private Date fechaWS2;
	private String nombre_pdf;
	private String tiempo1;
	private String tiempo2;
	private String nom_dept;
	private Integer filtro_dep;
	private DefaultStreamedContent myImage;
	private List <SERVIDOR> employee;
	private List <BJUSTIF> justificaciones;
	private List <ACC_PER> acciones;
	private InputStream is;
	@PostConstruct
	public void init(){
		empleados=mdao.getEmpleados();
		departamentos=mdao.getDepartamentos();
		cargos=mdao.getCargos();
	}
	public void getRestServidor(String cedula) throws ParseException{
		myImage=new DefaultStreamedContent();
		ClientConfig clientConfig = new DefaultClientConfig();
		// Create Client based on Config
	      Client client = Client.create(clientConfig);
	      WebResource webResource = client.resource("http://localhost:8080/nominaMunicipio/srv/login/emps?a="+cedula);
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
//	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
//	         System.out.println("Error: "+error);
	          return;
	      }
	      GenericType<List<SERVIDOR>> generic = new GenericType<List<SERVIDOR>>() {};
//	      System.out.println("Output from Server1 .... \n");
	      this.setEmployee(response.getEntity(generic));
	      for(SERVIDOR c:this.getEmployee()){
	    	  System.out.println(">>>>>>>>>>>>>>>>>> JORGE ORTIZ >>>>>>>>>>>>>>>>>>>");
	    	  System.out.println(">>>>>>>>>>>>>>>>>> "+c.getPRIMER_NOMBRE());
	    	  System.out.println(">>>>>>>>>>>>>>>>>> "+c.getSEGUNDO_NOMBRE());
	    	  System.out.println(">>>>>>>>>>>>>>>>>> "+c.getCEDULA());
	    	  this.setIs(new ByteArrayInputStream((byte[]) c.getNUEVA_FOTO()));
	    	  this.setMyImage(new DefaultStreamedContent(this.getIs(), "image/png"));
	      }
	      
	     this.getRestBJustificaciones(cedula);
	}
	
	
	/*
	 * public List<SERVIDOR> getRestServidor1(String cedula) throws ParseException{
	 * List<SERVIDOR> aux = new ArrayList<SERVIDOR>(); myImage=new
	 * DefaultStreamedContent(); ClientConfig clientConfig = new
	 * DefaultClientConfig(); // Create Client based on Config Client client =
	 * Client.create(clientConfig); WebResource webResource =
	 * client.resource("http://localhost:8080/nominaMunicipio/srv/login/emps?a="+
	 * cedula); Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
	 * .header("content-type", MediaType.APPLICATION_XML); ClientResponse response =
	 * builder.get(ClientResponse.class); // Status 200 is successful. if
	 * (response.getStatus() != 200) { //
	 * System.out.println("Failed with HTTP Error code: " + response.getStatus());
	 * String error= response.getEntity(String.class); //
	 * System.out.println("Error: "+error); return null; }
	 * GenericType<List<SERVIDOR>> generic = new GenericType<List<SERVIDOR>>() {};
	 * // System.out.println("Output from Server1 .... \n"); aux =
	 * response.getEntity(generic); for(SERVIDOR c: aux){
	 * System.out.println(">>>>>>>>>>>>>>>>>> MI METODO >>>>>>>>>>>>>>>>>>>");
	 * System.out.println(">>>>>>>>>>>>>>>>>> "+c.getPRIMER_NOMBRE());
	 * System.out.println(">>>>>>>>>>>>>>>>>> "+c.getSEGUNDO_NOMBRE());
	 * System.out.println(">>>>>>>>>>>>>>>>>> "+c.getCEDULA()); }
	 * 
	 * return aux; }
	 */
	
	/*public String enviarFullTime() {
		List<SERVIDOR> aux = new ArrayList<SERVIDOR>();
		SERVIDOR auxs = new SERVIDOR();
		
		EMPLEADO auxe = new EMPLEADO();
		try {
			aux = getRestServidor1("0103198628");
			auxs = aux.get(0);
			auxe.setEMPL_ID(10000);
			auxe.setNOMBRE(auxs.getPRIMER_NOMBRE());
			auxe.setAPELLIDO(auxs.getAPELLIDO_PATERNO()+" "+auxs.getAPELLIDO_MATERNO());
			auxe.setCIUD_ID(2);
			if(auxs.getSEXO().equals("M")) {
				auxe.setSEXO(1);
			}
			else {
				auxe.setSEXO(2);
			}
			
			auxe.setHORAS_TRABAJA(0);
			auxe.setCEDULA(auxs.getCEDULA());
			auxe.setDEPA_ID(1018);
			auxe.setCORREO("rrhh@cuenca.gob.ec");
			auxe.setFECHA_NACIMIENTO(auxs.getFECHA_NACIMIENTO());
			auxe.setID(auxs.getBIOMETRICO()); //Codigo del reloj biometrico
			auxe.setCARG_ID(2002);
			auxe.setESTADO(5);
			auxe.setESTADO_CIVIL(8); //
			auxe.setDGCO_ID(1);
			
			System.out.println("EMPLEADO>>>>>>>>>>>>");
			System.out.println(auxe);
			mdao.insertEmpleado(auxe);
			
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}*/
	
	public void getRestBJustificaciones(String cedula) throws ParseException {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 String f1=formatter.format(this.getFecha1());
		 String f2=formatter.format(this.getFecha2());
			 

		ClientConfig clientConfig = new DefaultClientConfig();
		// Create Client based on Config
	      Client client = Client.create(clientConfig);
	      WebResource webResource = client.resource("http://localhost:8080/nominaMunicipio/srv/login/just?fecha1="+f1+"&fecha2="+f2+"&cod="+cedula);
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
//	         System.out.println("Error: "+error);
	          return;
	      }
	      GenericType<List<BJUSTIF>> generic = new GenericType<List<BJUSTIF>>() {};
	      System.out.println("Output from Server2 .... \n");
	      this.setJustificaciones(response.getEntity(generic));
//	      for(BJUSTIF c:this.getJustificaciones()){
//	    	 System.out.println(""+c.getOBSERVACIONES());
//	    	 System.out.println(""+c.getSER_CODIGO());
//	    	 System.out.println(""+c.getFECHA());
//	      }
	      
	      System.out.println("fiiiinnnn");
	      this.checkACC_PER(cedula);
	      
	}
	public void checkACC_PER(String cedula) throws ParseException{
		 System.out.println("CEDULAAACC > "+cedula);
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 String f1=formatter.format(this.getFecha1());
		 String f2=formatter.format(this.getFecha2());
		 
		 
		// Create Client based on Config
		 ClientConfig clientConfig = new DefaultClientConfig();
	      Client client = Client.create(clientConfig);
	      WebResource webResource = client.resource("http://localhost:8080/nominaMunicipio/srv/login/accper?fecha1="+f1+"&fecha2="+f2+"&cod="+cedula);
	      Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
	              .header("content-type", MediaType.APPLICATION_XML);
	      ClientResponse response = builder.get(ClientResponse.class);
	      // Status 200 is successful.
	      if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	          return;
	      }
	  
	      GenericType<List<ACC_PER>> generic = new GenericType<List<ACC_PER>>() {
	          // No thing
	      };
	      
	      System.out.println("Output from Server .... \n");
	      this.setAcciones(response.getEntity(generic));
	      for(ACC_PER b:this.getAcciones()){
	    		System.out.println(">>... "+b.getSER_CODIGO());
				System.out.println(">> "+b.getACCION());
				System.out.println(">> "+b.getFECHA_VIGENCIA());
				System.out.println(">>... "+b.getEXPLICACION());
	      }
	
		System.out.println("termino...");
		

	}
	public String checkNombresYapellidosServidor(Integer cod_servidor){
		System.out.println("tamanio > "+this.getEmployee().size()+" cod_servidor "+cod_servidor);
		for(SERVIDOR s:this.getEmployee()){
			System.out.println("SERVIDOR > "+s.getCODIGO());
			if(s.getCODIGO().equals(cod_servidor)){
				String n=s.getAPELLIDO_PATERNO()+" "+s.getAPELLIDO_MATERNO()+" "+s.getPRIMER_NOMBRE()+" "+s.getSEGUNDO_NOMBRE();
				return n;
			}
		}
		return "Sin código servidor";
	}
	public String checkCargo(Integer cod_servidor){
		String aux=null;
		for(SERVIDOR s:this.getEmployee()){
			if(s.getCODIGO().equals(cod_servidor)){
				aux=s.getCEDULA();
				break;
			}
		}
		Integer cargo=null;
		for(EMPLEADO e:this.getEmpleados()){
			if(e.getCEDULA().equals(aux)){
				cargo=e.getCARG_ID();
			}
		}
		
		for(CARGO c:this.getCargos()){
			if(c.getCARG_ID().equals(cargo)){
				return c.getDESCRIPCION();
			}
		}
		return "Sin cargo";
	}
	public String checkMotivoPermiso(){
		for(ACC_PER a:this.getAcciones()){
			if(a.getACCION().equals("LSM")){
				return "AP LICENCIA CON MATERNIDAD";
			}
			if(a.getACCION().equals("LSP")){
				return "AP LICENCIA CON PATERNIDAD";
			}
			if(a.getACCION().equals("VAC")){
				return "AP VACACIONES";
			}
			if(a.getACCION().equals("CAP")){
				return "CAPACITACION";
			}
			if(a.getACCION().equals("LSL")){
				return "LICENCIA CON REMUNERACION";
			}
			if(a.getACCION().equals("LSS")){
				return "LICENCIA SIN REMUNERACION";
			}
			if(a.getACCION().equals("Z")){
				return "OTRAS";
			}
			if(a.getACCION().equals("DCS")){
				return "DECLARAR EN COMISION DE SERVICIO";
			}
			if(a.getACCION().equals("CCR")){
				return "COMISION DE SERVICIOS CON REMUNERACION";
			}
			if(a.getACCION().equals("CSR")){
				return "COMISION DE SERVICIOS SIN REMUNERACION";
			}
		}
		return "Sin decode";
	}
	
	public void checkBiometrico(ActionEvent actionEvent) throws ParseException{
		this.setAcciones(null);
		this.setJustificaciones(null);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			  boolean band=false;
			  System.out.println("bioooooo");
			  if(!df.format(this.getFecha1()).equals(null)|| !df.format(this.getFecha2()).equals(null) || !this.getBiometrico().isEmpty()){
				  System.out.println("1");
				  for(EMPLEADO e:this.getEmpleados()){
					  if(e.getCODIGO_EMPLEADO().equals(this.getBiometrico())){
						  band=true;
						  break;
					  }
				  }
				  if(band==true){
					  if(this.getTiempo1().isEmpty() || this.getTiempo1().isEmpty() ){
						  
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  05.00.00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  23.50.00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						 this.setTimbres(dao.getTimbresEmpleado(date, date1,this.getBiometrico()));
						 this.setNombre_pdf(this.checkRazonSocialEmpApellido(this.getBiometrico())+" "+this.checkRazonSocialEmpNombre(this.getBiometrico()));
						 this.setNom_dept(dao.getDepartamento(this.getBiometrico()));
						 String cedula=this.checkCedulaEmpleado(this.getBiometrico());
						 if (!cedula.equals(null)){
							 this.getRestServidor(cedula);
						 }else System.out.println("SIn cedulaaaa");
					  }else
					  if(!this.getTiempo1().isEmpty() && !this.getTiempo2().isEmpty() ){
						  System.out.println("3");
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  "+this.getTiempo1()+".00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  "+this.getTiempo2()+".00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						 this.setTimbres(dao.getTimbresEmpleado(date, date1,this.getBiometrico()));
						 this.setNombre_pdf(this.checkRazonSocialEmpApellido(this.getBiometrico())+" "+this.checkRazonSocialEmpNombre(this.getBiometrico()));
						 this.setNom_dept(dao.getDepartamento(this.getBiometrico()));
						 String cedula=this.checkCedulaEmpleado(this.getBiometrico());
						 if (!cedula.equals(null)){
							 this.getRestServidor(cedula);
						 }else System.out.println("SIn cedulaaaa");
					  }else addMessage("Tiempos mal inttroducidos");
				  }else addMessage("Código de biométrico no encontrado");
			  }else addMessage("Datos mal introducidos!");
			  
		  }catch(NullPointerException ex){
			 throw ex;
		  } catch (ParseException e1) {
			// TODO Auto-generated catch block
			  throw e1;
		}
		  //this.setBiometrico("");
		  System.out.println("salioooo");
		  this.setFecha1(null);
		  this.setFecha2(null);
		  this.setTiempo1("");
		  this.setTiempo2("");
	}
	public void checkDepartamento(ActionEvent actionEvent) throws IOException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			  if(!this.getFecha1().equals(null) || !this.getFecha2().equals("")){
				  if(!this.getFiltro_dep().equals(null)){
					  if(this.getTiempo1().isEmpty() || this.getTiempo1().isEmpty() ){
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  05.00.00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  23.50.00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						 this.setTimbres(mdao.getTimbresDepartamento(date, date1,this.getFiltro_dep()));
						 this.setNombre_pdf(this.checkDepartamentoParam(this.filtro_dep));
					  }else
						  if(!this.getTiempo1().isEmpty() && !this.getTiempo2().isEmpty() ){
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  "+this.getTiempo1()+".00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  "+this.getTiempo2()+".00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						  this.setTimbres(mdao.getTimbresDepartamento(date, date1,this.getFiltro_dep()));
						 this.setNombre_pdf(this.checkDepartamentoParam(this.filtro_dep));
					  }else addMessage("Tiempos mal inttroducido");
				  }else addMessage("Datos mal ingresado");
			  }else addMessage("Datos mal introducido!");
			  
		  }catch(NullPointerException ex){
			  addMessage("Datos mal introducido!!");
		  } catch (ParseException e1) {
			// TODO Auto-generated catch block
			  addMessage("Datos mal introducido!!");
		}
		 this.filtro_dep=null;
		  this.setFecha1(null);
		  this.setFecha2(null);
		  this.setTiempo1("");
		  this.setTiempo2("");
	}
	
	public void checkEmpleado(ActionEvent actionEvent) throws IOException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		  try {
			  if(!this.getFecha1().equals(null) || !this.getFecha2().equals("")){
				  if(!this.getFiltro_dep().equals(null)){
					  if(this.getTiempo1().isEmpty() || this.getTiempo1().isEmpty() ){
						  System.out.println("Entro 1");
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  05.00.00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  23.50.00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						 this.setTimbres(dao.getTimbresEmpleado(date, date1,this.getFiltro_dep()+""));
						 this.setNombre_pdf(this.checkRazonSocialEmpApellido(this.getFiltro_dep()+"")+" "+this.checkRazonSocialEmpNombre(this.getFiltro_dep()+""));
						 this.setNom_dept(dao.getDepartamento(this.getFiltro_dep()+""));
					  }else
						  if(!this.getTiempo1().isEmpty() && !this.getTiempo2().isEmpty() ){
							  System.out.println("Entro 2");
						  String fecha1 = df.format(this.getFecha1());
						  fecha1 = fecha1+"  "+this.getTiempo1()+".00 a";
						  String fecha2 = df.format(this.getFecha2());
						  fecha2 = fecha2+"  "+this.getTiempo2()+".00 a";
						  Date date = formatter_send.parse(fecha1);
						  Date date1 = formatter_send.parse(fecha2);
						  this.setTimbres(dao.getTimbresEmpleado(date, date1,this.getFiltro_dep()+""));
						  this.setNombre_pdf(this.checkRazonSocialEmpApellido(this.getFiltro_dep()+"")+" "+this.checkRazonSocialEmpNombre(this.getFiltro_dep()+""));
						  this.setNom_dept(dao.getDepartamento(this.getFiltro_dep()+""));
					  }else addMessage("Tiempos mal introducido");
				  }else addMessage("Datos mal ingresado");
			  }else addMessage("Datos mal introducido!");
			  
		  }catch(NullPointerException ex){
			  addMessage("Datos mal introducido!!");
		  } catch (ParseException e1) {
			// TODO Auto-generated catch block
			  addMessage("Datos mal introducido!!");
		}
		 this.filtro_dep=null;
		  this.setFecha1(null);
		  this.setFecha2(null);
		  this.setTiempo1("");
		  this.setTiempo2("");
	}
	
	protected muestraOptionMenu[] mostrarMenuDep;
	
	
	public muestraOptionMenu[] sendDepartamentos(){
		int cont=0;
		mostrarMenuDep=new muestraOptionMenu[this.getDepartamentos().size()];
		for(DEPARTAMENTO de:this.getDepartamentos()){
			mostrarMenuDep[cont]=new muestraOptionMenu(de.getDESCRIPCION(),de.getDEPA_ID());
			cont++;
		}
		return mostrarMenuDep;
	}
	public String checkTiempo(Date fecha) throws ParseException{
		if(fecha!=null){
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 Date dates = fecha;
			return formatter.format(dates);
		}else return "sin fecha";
		
		
	}
	public String checkCedulaEmpleado(String cod_bio){
		for(EMPLEADO e:this.getEmpleados()){
			if(e.getCODIGO_EMPLEADO().equals(cod_bio)){
				return e.getCEDULA();
			}
		}
		return null;
		
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
	public String checkDepartamentoParam(Integer cod_dep){
		for(DEPARTAMENTO d:this.getDepartamentos()){
			if(d.getDEPA_ID().equals(cod_dep)){
				return d.getDESCRIPCION();
			}
		}
		return "Sin departamento";
//		String a=dao.getDepartamento(cod_bio);
//		if(a==null){
//			return "Sin departamento";
//		}else return a;
		
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

	
	public diaReporteDAO getDao() {
		return dao;
	}
	public void setDao(diaReporteDAO dao) {
		this.dao = dao;
	}
	public List<TIMBRE> getTimbres() {
		return timbres;
	}
	public void setTimbres(List<TIMBRE> timbres) {
		this.timbres = timbres;
	}
	
	public String getBiometrico() {
		return biometrico;
	}
	public void setBiometrico(String biometrico) {
		this.biometrico = biometrico;
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


	public String getNombre_pdf() {
		return nombre_pdf;
	}


	public void setNombre_pdf(String nombre_pdf) {
		this.nombre_pdf = nombre_pdf;
	}


	public String getTiempo1() {
		return tiempo1;
	}


	public void setTiempo1(String tiempo1) {
		this.tiempo1 = tiempo1;
	}


	public String getTiempo2() {
		return tiempo2;
	}


	public void setTiempo2(String tiempo2) {
		this.tiempo2 = tiempo2;
	}


	public Integer getFiltro_dep() {
		return filtro_dep;
	}


	public void setFiltro_dep(Integer filtro_dep) {
		this.filtro_dep = filtro_dep;
	}


	public muestraOptionMenu[] getMostrarMenuDep() {
		return mostrarMenuDep;
	}


	public void setMostrarMenuDep(muestraOptionMenu[] mostrarMenuDep) {
		this.mostrarMenuDep = mostrarMenuDep;
	}


	public String getNom_dept() {
		return nom_dept;
	}


	public void setNom_dept(String nom_dept) {
		this.nom_dept = nom_dept;
	}
	public DefaultStreamedContent getMyImage() {
		return myImage;
	}
	public void setMyImage(DefaultStreamedContent myImage) {
		this.myImage = myImage;
	}

	public List<SERVIDOR> getEmployee() {
		return employee;
	}

	public void setEmployee(List<SERVIDOR> employee) {
		this.employee = employee;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public List<BJUSTIF> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(List<BJUSTIF> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public Date getFechaWS1() {
		return fechaWS1;
	}

	public void setFechaWS1(Date fechaWS1) {
		this.fechaWS1 = fechaWS1;
	}

	public Date getFechaWS2() {
		return fechaWS2;
	}

	public void setFechaWS2(Date fechaWS2) {
		this.fechaWS2 = fechaWS2;
	}
	public List<ACC_PER> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<ACC_PER> acciones) {
		this.acciones = acciones;
	}
	public List<CARGO> getCargos() {
		return cargos;
	}
	public void setCargos(List<CARGO> cargos) {
		this.cargos = cargos;
	}



	
	
	

}
