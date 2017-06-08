package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import Pharma.BKDatabaseUtil;
import Pharma.SQLQueries;

public class PrescriptionUtil {
	public static PrescribedMedicines generatePrescribedMedicines(PrescribedMedicines inPrescribedMedicines) throws SQLException {
		Connection con = null;
		CallableStatement cStmt = null;
		try {
			con = BKDatabaseUtil.getConnection();
			cStmt = con.prepareCall(SQLQueries.INSERT_PRESCRIBED_MEDICINES);
			cStmt.setString(1, inPrescribedMedicines.medicine_id);
			cStmt.setString(2, inPrescribedMedicines.frequency);
			cStmt.setString(3, inPrescribedMedicines.duration);
			cStmt.execute();
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			cStmt.close(); con.close();
		}
		return inPrescribedMedicines;

}
	
	public static PatientsMonitored generatePatientsMonitored(PatientsMonitored inPatientsMonitored) throws SQLException {
		Connection con = null;
		CallableStatement cStmt = null;
		try {
			con = BKDatabaseUtil.getConnection();
			cStmt = con.prepareCall(SQLQueries.INSERT_PATIENTS_MONITORED);
			cStmt.setString(1, inPatientsMonitored.patient_id);
			cStmt.setInt(2, inPatientsMonitored.id);
			cStmt.setString(3, inPatientsMonitored.status);
			cStmt.setString(4, inPatientsMonitored.date);
			cStmt.execute();
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			cStmt.close(); con.close();
		}
		return inPatientsMonitored;

}
}
