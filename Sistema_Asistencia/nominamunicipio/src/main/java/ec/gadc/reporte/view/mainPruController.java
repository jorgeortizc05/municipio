package ec.gadc.reporte.view;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DefaultStreamedContent;

import ec.gadc.reporte.dao.ServidorCargoDAO;
import ec.gadc.reporte.dao.mainJustDAO;
import ec.muni.nomina.model.BJUSTIF;
import ec.muni.nomina.model.SERVIDOR;
import ec.muni.nomina.model.ServidorCargo;
@ManagedBean
@SessionScoped
public class mainPruController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private mainJustDAO mdao;
	
	private ServidorCargoDAO servcDAO = new ServidorCargoDAO();
	
	private List<BJUSTIF> justificaciones;
	private List<SERVIDOR> empleados;
	private SERVIDOR empleado;
	
	private ServidorCargo servidorCargo = new ServidorCargo();
	private List<ServidorCargo> servidorCargos;
	
	private byte[] foto;
	private DefaultStreamedContent myImage;
	
	public void checkBJust()throws NullPointerException{
		
		this.setJustificaciones(mdao.getBjust());
		if(!this.getJustificaciones().equals(null)){
			for(BJUSTIF b:this.getJustificaciones()){
				System.out.println(">> "+b.getOBSERVACIONES());
				System.out.println(">/ "+b.getSER_CODIGO());
			}
			System.out.println("Tamanio de bjust: "+this.getJustificaciones().size());
		}else System.out.println("Valores nulos");
	}
	
	
	  public String servidorCargo() { 
		 servcDAO.getServidor(200);
		 return null;
	  }
	 
	
public void checkServidor()throws NullPointerException{
		try{
		this.setEmpleados(mdao.getServidor("0103198628"));
		if(!this.getEmpleados().equals(null)){
			for(SERVIDOR b:this.getEmpleados()){
				System.out.println(">> "+b.getAPELLIDO_MATERNO());
				System.out.println(">/ "+b.getCEDULA());
				System.out.println(">/ "+b.getPRIMER_NOMBRE());
				System.out.println(">+"+b.getFOTOGRAFIA());
				System.out.println(">+"+b.getNUEVA_FOTO());
				System.out.println(">+"+b.getHOJA_VIDA());
				//this.setFoto(b.getNUEVA_FOTO());
				InputStream is = new ByteArrayInputStream((byte[]) b.getNUEVA_FOTO());
				this.setMyImage(new DefaultStreamedContent(is, "image/png"));
				  System.out.println("Imagen1 "+this.getMyImage().getName());
		      }
			
		      System.out.println("Imagen "+this.getMyImage().getName());
		      System.out.println("Imagen "+this.getMyImage());
		      System.out.println("Imagen "+this.getMyImage().toString());
			System.out.println("Tamanio de Servidor: "+this.getEmpleados().size());
		}else System.out.println("Valores nulos");
		}catch(Exception e){
		System.out.println("mal hecho jajajaj");
		}
	}
	
	

	public List<BJUSTIF> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(List<BJUSTIF> justificaciones) {
		this.justificaciones = justificaciones;
	}
	public List<SERVIDOR> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<SERVIDOR> empleados) {
		this.empleados = empleados;
	}
	public SERVIDOR getEmpleado() {
		return empleado;
	}
	public void setEmpleado(SERVIDOR empleado) {
		this.empleado = empleado;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public DefaultStreamedContent getMyImage() {
		return myImage;
	}
	public void setMyImage(DefaultStreamedContent myImage) {
		this.myImage = myImage;
	}
	
	
	

}
