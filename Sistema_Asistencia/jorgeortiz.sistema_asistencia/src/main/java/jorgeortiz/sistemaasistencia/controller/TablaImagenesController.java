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
import jorgeortiz.gimnasiosoliz.model.TablaImageness;

@ManagedBean
@ViewScoped
public class TablaImagenesController {

	@Inject
	private TablaImagenessDAO dao;
	
	private List<TablaImageness> imagenes;
	private DefaultStreamedContent myImage;
	
	private InputStream is;
	
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


	public DefaultStreamedContent getMyImage() {
		return myImage;
	}


	public void setMyImage(DefaultStreamedContent myImage) {
		this.myImage = myImage;
	}
	
}
