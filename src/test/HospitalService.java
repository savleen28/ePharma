package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import Pharma.GenericUtils;

@Path("/hospital")
public class HospitalService {
	@Path("/add_hospital")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	
	public Response addHospital(@HeaderParam("authorization") String authString, InputStream incomingData) {
		
		
		
		StringBuilder requestString = GenericUtils.readInputRequestString(incomingData);
		
		System.out.println(requestString);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String response = null;
		
		Hospital inHospital = null;
		Hospital outHospital = null;
				
		try {
			inHospital = mapper.readValue(requestString.toString(), Hospital.class);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());

			return Response.status(500).entity("Unable to read input stream").build();
		} 
		try {

			outHospital = HospitalUtil.generateHospital(inHospital);
		} catch (SQLException e1) {
			return Response.status(500).entity("Error in creating operation instance").build();
		}

		try {
			response = mapper.writer().writeValueAsString(outHospital);
		} catch (Exception e) {
			return Response.status(500).entity("Error in writing the object as string").build();
		} 
		return Response.status(200).entity(response).build();
	} 

}
