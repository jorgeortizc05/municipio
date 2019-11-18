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

import ec.gadc.reporte.dao.mainJustDAO;
import ec.muni.nomina.model.ACC_PER;
import ec.muni.nomina.model.BJUSTIF;
import ec.muni.nomina.model.SERVIDOR;

@Path("login")
public class FotoServidorWS {

	@Inject
	private mainJustDAO mdao;
	private Date resta;
	private Date suma;
	
	@GET
	@Path("emps")
	@Produces("application/xml")
	public List <SERVIDOR> sendFoto(@QueryParam("a") String a){
		List<SERVIDOR> empleados=mdao.getEmpleadosServidor(a);
		return empleados;
	}
	
	@GET
	@Path("just")
	@Produces("application/xml")
	public List <BJUSTIF> sendbJust(@QueryParam("fecha1") String fecha1,@QueryParam("fecha2") String fecha2,@QueryParam("cod") String codigo)throws ParseException{
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
			List<BJUSTIF>justificaciones=mdao.getBjustPersona(codigo,sdate, rdate1);
			return justificaciones;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("nuloooooo");
			e.printStackTrace();
		}
		 return null;
	}
	@GET
	@Path("accper")
	@Produces("application/xml")
	public List<ACC_PER> sendAccPer(@QueryParam("fecha1") String fecha1,@QueryParam("fecha2") String fecha2,@QueryParam("cod") String codigo) throws ParseException{
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatter_send = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss");
		 try {
			 //si queres convertir un String a fecha
		 	Date date = formatter.parse(fecha1);
		 	Date date1 = formatter.parse(fecha2);
		 	//restar y sumar dias
				 	 Calendar c = Calendar.getInstance();
				     c.setTime(date);
				     c.add(Calendar.DATE, -30);
				      resta = c.getTime();
				   Calendar c1 = Calendar.getInstance();
				     c1.setTime(date1);
				     c1.add(Calendar.DATE, 30);
				      suma = c1.getTime();
			 //
			 String sDate=formatter.format(resta);
			 String rDate=formatter.format(suma);
			 	Date sdate = formatter.parse(sDate);
			 	Date rdate1 = formatter.parse(rDate);
		   
		 	System.out.println("+ / - "+resta+" "+suma);
		 	
			System.out.println("Desde rest "+fecha1+" - "+fecha2);
			System.out.println("fecha rest "+sdate+" - "+rdate1);
			List<ACC_PER>acciones=mdao.getAccPer(codigo,sdate, rdate1);
			return acciones;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("nuloooooo");
			e.printStackTrace();
		}
		
		return null;
	}
}
