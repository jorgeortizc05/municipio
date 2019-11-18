package ec.gadc.reporte.main;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.primefaces.model.DefaultStreamedContent;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import ec.gadc.reporte.model.SERVIDOR;

public class main {
	
	public static void main(String[] args) {
		
		String descripcion = "GESTION";
		String sentencia = ("SELECT dep.depa_id as codigo, dep.descripcion FROM departamento dep WHERE dep.descripcion LIKE '%"+descripcion+"%'");
		System.out.println(sentencia);
		
	}



}
