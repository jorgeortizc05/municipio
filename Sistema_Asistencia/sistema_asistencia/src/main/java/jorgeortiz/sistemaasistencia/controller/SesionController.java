package jorgeortiz.sistemaasistencia.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.bussiness.SessionBussiness;
import jorgeortiz.sistemaasistencia.fulltime.model.USUARIOS;
import jorgeortiz.sistemaasistencia.nomina.model.SERVIDOR;

@ManagedBean
@SessionScoped
public class SesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SessionBussiness seBuss;
	
	private String usuario;
	private String pass;
	private USUARIOS USUARIO;
	private SERVIDOR newServidor;
	private boolean estado;

	@PostConstruct
	public void init() {
		estado = false; // el h:form se renderiza cuando esta en true
	}

	public String verificarLogin() throws IOException {
		try {
			newServidor = seBuss.getServidorLogin(getUsuario(), getPass());
			System.out.println(newServidor);
			if (newServidor != null) {
				estado = true;
				System.out.println(estado);
				addMessage("Bienvenido " + newServidor.getPRIMER_NOMBRE());
				//FacesContext.getCurrentInstance().getExternalContext().redirect("escritorio.xhtml");
				return "reporte_biometrico?faces-redirect=true";
			}else {
				addMessage("Usuario o clave incorrecta!!");
			}
		} catch (Exception e) {
			addMessage("Usuario o clave incorrecta!!");
		}
		addMessage("Error en el inicio de sesión");
		
		return null;

	}
	
	public String salir() throws IOException {
		estado = false;
		usuario = "";
		pass = "";
		return "login?faces-redirect=true";
		

	}

	public void closeSesion() throws IOException {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
		} catch (Exception e) {
			addMessage("no logueado");
		}

	}

	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public USUARIOS getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(USUARIOS uSUARIO) {
		USUARIO = uSUARIO;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
