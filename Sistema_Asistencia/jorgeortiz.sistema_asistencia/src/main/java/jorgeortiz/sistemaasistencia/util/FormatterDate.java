package jorgeortiz.sistemaasistencia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterDate {
	
	public static String formatearFecha(Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String f = formatter.format(fecha);
		System.out.println("Fecha formateada: "+f);
		return f;
	}
	
	

}
