package jorgeortiz.sistemaasistencia.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import jorgeortiz.sistemaasistencia.dao.SesionReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.USUARIOS;

@ManagedBean
@SessionScoped
public class SesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private SesionReporteDAO dao;
	private String usuario;
	private String pass;
	private USUARIOS USUARIO;
	private boolean estado;

	@PostConstruct
	public void init() {
		estado = true; // el h:form se renderiza cuando esta en true
	}

	public void verificarLogin(ActionEvent actionEvent) throws IOException {
		try {
			USUARIO = dao.getLoginU(this.getUsuario(), this.getPass());
			if (USUARIO != null) {
				this.setEstado(true);
				addMessage("Bienvenido " + USUARIO.getUSUARIO());
				FacesContext.getCurrentInstance().getExternalContext().redirect("reportes.xhtml");

			}
		} catch (Exception e) {
			addMessage("Usuario o clave incorrecta!!");
		}
		addMessage("Error en el inicio de sesión");

	}

	public void closeSesion() throws IOException {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "/inicio.xhtml");
		} catch (Exception e) {
			addMessage("no logueado");
		}

	}

	private void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);

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

}
