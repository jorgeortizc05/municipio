package jorgeortiz.sistemaasistencia.util;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
public class Resources {
	@Produces
	@PersistenceContext(unitName = "fulltime")
	private EntityManager emF;
	
	@Produces
	@PersistenceContext(unitName = "nomina")
	private EntityManager emN;
	
	@Produces
	@PersistenceContext(unitName = "gym")
	private EntityManager emG;
	   
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
	   return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	   
	@Produces
	@RequestScoped
	 public FacesContext produceFacesContext() {
	   return FacesContext.getCurrentInstance();
	 }
}
