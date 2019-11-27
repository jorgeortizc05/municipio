package jorgeortiz.sistemaasistencia.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import jorgeortiz.sistemaasistencia.dao.TablaImagenessDAO;
import oracle.sql.BLOB;
import jorgeortiz.gimnasiosoliz.model.TablaImageness;

@ManagedBean
@ViewScoped
public class TablaImagenesController {

	@Inject
	private TablaImagenessDAO dao;
	
	private List<TablaImageness> imagenes;
	private StreamedContent myImage = null;
	
	
	@PostConstruct
	public void init() {
		imagenes = dao.getImagenes();
	}
	
	
	public String mostrarImagenes() {
		return null;
	}


	public List<TablaImageness> getImagenes() {
		return imagenes;
	}


	public void setImagenes(List<TablaImageness> imagenes) {
		this.imagenes = imagenes;
	}


	public StreamedContent getMyImage() {
		return myImage;
	}


	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}

	
	


	
	
	
}
