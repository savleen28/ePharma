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
import Pharma.Patient;

//import com.fws.model.request.structs.Employee;
//import com.fws.model.utils.common.GenericUtils;
//import com.fws.model.utils.employee.EmpUtil;

@Path("/patient")
public class PatientService {


	@Path("/add_patient")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	
	public Response addPatient(@HeaderParam("authorization") String authString, InputStream incomingData) {
		//Get User Id
		
		
		StringBuilder requestString = GenericUtils.readInputRequestString(incomingData);
		
		System.out.println(requestString);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String response = null;
		
		Patient inPatient = null;
		Patient outPatient = null;
				
		try {
			inPatient = mapper.readValue(requestString.toString(), Patient.class);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());

			return Response.status(500).entity("Unable to read input stream").build();
		} 
		try {

			outPatient = PatientUtil.generatePatient(inPatient);
		} catch (SQLException e1) {
			return Response.status(500).entity("Error in creating operation instance").build();
		}

		try {
			response = mapper.writer().writeValueAsString(outPatient);
		} catch (Exception e) {
			return Response.status(500).entity("Error in writing the object as string").build();
		} 
		return Response.status(200).entity(response).build();
	} 
	
}

