package jorgeortiz.gimnasiosoliz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TABLA_IMAGENESS database table.
 * 
 */
@Entity
@Table(name="TABLA_IMAGENESS")
public class TablaImageness implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_IMAGEN")
	private int idImagen;
	
	

	private byte[] imagen;

	@Column(name="NOMBRE_IMAGEN")
	private String nombreImagen;
	
	@Column(name = "FECHA")
	private Date fecha;

	public TablaImageness() {
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombreImagen() {
		return this.nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}