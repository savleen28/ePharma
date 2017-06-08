package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import Pharma.BKDatabaseUtil;
import Pharma.Patient;
import Pharma.SQLQueries;

//import com.fws.model.constants.SQLQueries;



public class PatientUtil {
	
	public static Patient generatePatient(Patient inPatient) throws SQLException {
		Connection con = null;
		CallableStatement cStmt = null;
		try {
			con = BKDatabaseUtil.getConnection();
			cStmt = con.prepareCall(SQLQueries.INSERT_PATIENT);
			cStmt.setString(1, inPatient.id);
			cStmt.setString(2, inPatient.fname);
			cStmt.setString(3, inPatient.lname);
			cStmt.setString(4, inPatient.age);
			cStmt.setString(5, inPatient.gender);
			cStmt.setString(6, inPatient.ins_no);
			cStmt.setString(7, inPatient.minor);
			
            cStmt.execute();
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			cStmt.close(); con.close();
		}
		return inPatient;
	}
	

}
