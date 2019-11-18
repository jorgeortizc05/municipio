package ec.gadc.reporte.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.gadc.reporte.dao.diaReporteDAO;
import ec.gadc.reporte.dao.mainReporteDAO;
import ec.gadc.reporte.model.CIUDAD;
import ec.gadc.reporte.model.TIMBRE;

@Path("login")
public class SendRestObject {
	@Inject
	private mainReporteDAO mdao;
	@Inject
	private diaReporteDAO dao;
	private Date resta;
	private Date suma;
	
	@GET
	@Path("ciudad")
	@Produces("application/xml")
	public List<CIUDAD> sendCiudad(){
		List<CIUDAD> ciudades=mdao.getCiudades();
		for(CIUDAD c:ciudades){
			System.out.println("^^> "+c.getDESCRIPCION());
		}
		return ciudades;
	}
	@GET
	@Path("timbres")
	@Produces("application/xml")
	public List<TIMBRE> sendTimbres(@QueryParam("fecha1") String fecha1,@QueryParam("fecha2") String fecha2,@QueryParam("cod") String codigo) throws ParseException{
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		 try {
			 //si queres convertir un String a fecha
		 	Date date = formatter.parse(fecha1);
		 	Date date1 = formatter.parse(fecha2);
		 	//restar y sumar dias
				 	 Calendar c = Calendar.getInstance();
				     c.setTime(date);
				     c.add(Calendar.DATE, -10);
				      resta = c.getTime();
				   Calendar c1 = Calendar.getInstance();
				     c1.setTime(date1);
				     c1.add(Calendar.DATE, 10);
				      suma = c1.getTime();
			 //
			 String sDate=formatter.format(resta);
			 String rDate=formatter.format(suma);
			 	Date sdate = formatter.parse(sDate);
			 	Date rdate1 = formatter.parse(rDate);
		   
		 	System.out.println("+ / - "+resta+" "+suma);
		 	
			System.out.println("Desde rest "+fecha1+" - "+fecha2);
			System.out.println("fecha rest "+date+" - "+date1);
			List<TIMBRE>timbres=dao.getTimbresEmpleado(sdate, rdate1, codigo);
			return timbres;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("nuloooooo");
			e.printStackTrace();
		}
		 return null;
		
	}
}
