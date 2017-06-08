package Pharma;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;


import Pharma.PrescriptionUtil;

@Path("/prescription/")
public class PrescriptionService {
	
	@Path("/add_prescription")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	
public Response addPrescription(@HeaderParam("authorization") String authString, InputStream incomingData) {
		
		
		
		StringBuilder requestString = GenericUtils.readInputRequestString(incomingData);
		
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String response = null;
		
		Prescription inPrescription = null;
		
		System.out.println(requestString.toString());
		try {
			inPrescription = mapper.readValue(requestString.toString(), Prescription.class);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());

			return Response.status(500).entity("Unable to read input stream").build();
		} 
		try {

			PrescriptionUtil.createPrescription(inPrescription);
		} catch (SQLException e1) {
			return Response.status(500).entity("Error in creating operation instance").build();
		}

		return Response.status(200).entity(response).build();
	} 
	
	
	@Path("/get_status")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	
public Response getStatus(@HeaderParam("authorization") String authString, @PathParam("status1") String status) { // what is a path param??
		
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String response = null;
		
		List<Status> inStatus = null;
		
		
		try {

			inStatus = PrescriptionUtil.getStatusDetails(status);
		} catch (SQLException e1) {
			return Response.status(500).entity("Error in creating operation instance").build();
		}
		
		try {
			response = mapper.writer().writeValueAsString(inStatus);
		} catch (Exception e) {
			return Response.status(500).entity("Error in writing the object as string").build();
		}

		return Response.status(200).entity(response).build();
	} 
}



