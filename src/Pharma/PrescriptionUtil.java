package Pharma;



import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.UUID;

import javax.naming.NamingException;

import Pharma.BKDatabaseUtil;
import Pharma.Patient;
import Pharma.Prescription;
import Pharma.PrescriptionData;
import Pharma.SQLQueries;
import Pharma.UtilExceptions;



//import com.mysql.cj.jdbc.PreparedStatement;

public class PrescriptionUtil {
	
		public static int getMedicineCount(String medicineName) throws SQLException {
			Connection con = null;
			PreparedStatement cStmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				con = BKDatabaseUtil.getConnection();
				cStmt = con.prepareStatement(SQLQueries.GET_MEDICINE_COUNT);
				cStmt.setString(1, medicineName);
				rs = cStmt.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}
				
				
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				cStmt.close(); 
				con.close();
			}
			return count;

	}
		
		
		
		public static String getPatientId(Patient inPatient) throws SQLException {
			Connection con = null;
			PreparedStatement cStmt = null;
			ResultSet rs = null;
			String pat_id = null;
			try {
				con = BKDatabaseUtil.getConnection();
				cStmt = con.prepareStatement(SQLQueries.GET_PATIENT_ID);
				cStmt.setString(1, inPatient.fname);
				cStmt.setString(2, inPatient.lname);
				cStmt.setString(3, inPatient.address);
				rs = cStmt.executeQuery();
				while (rs.next()) {
					pat_id = rs.getString(1);
				}
				
				
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				cStmt.close(); 
				con.close();
			}
			return pat_id;

	}
		
		
		public static String getMedicineId(String  medicine_name) throws SQLException {
			Connection con = null;
			PreparedStatement cStmt = null;
			ResultSet rs = null;
			String med_id = null;
			try {
				con = BKDatabaseUtil.getConnection();
				cStmt = con.prepareStatement(SQLQueries.GET_MEDICINE_ID);
				cStmt.setString(1, medicine_name);
				rs = cStmt.executeQuery();
				while (rs.next()) {
					med_id = rs.getString(1);
				}
				
				
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				cStmt.close(); 
				con.close();
			}
			return med_id;

	}
		
		public static void addPatient(Patient inPatient) throws SQLException {
			
			//PrescriptionUtil pu = new PrescriptionUtil();
			
			Connection con = null;
			CallableStatement cStmt = null;
			try {
				con = BKDatabaseUtil.getConnection();
				cStmt = con.prepareCall(SQLQueries.INSERT_PATIENT);
				cStmt.setString(1, UUID.randomUUID().toString());
				cStmt.setString(2, inPatient.fname);
				cStmt.setString(3, inPatient.lname);
				cStmt.setString(4, inPatient.age);
				cStmt.setString(5, inPatient.gender);
				cStmt.setString(6, inPatient.ins_no);
				cStmt.setString(7, inPatient.minor);
				cStmt.setString(8, inPatient.ins_company);
				cStmt.setString(9, inPatient.address);
			
	            cStmt.execute();
				
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				cStmt.close(); con.close();
			}
		}
		
public static String addPrescriptionMaster(Prescription inPrescription) throws SQLException {
			
			//PrescriptionUtil pu = new PrescriptionUtil();
			
			Connection con = null;
			CallableStatement cStmt = null;
			String prescriptionId = UUID.randomUUID().toString();
			try {
				con = BKDatabaseUtil.getConnection();
				cStmt = con.prepareCall(SQLQueries.INSERT_PRESCRIPTION_MASTER);
				cStmt.setString(1, prescriptionId);
				cStmt.setString(2, inPrescription.patient.id);
			
				
	            cStmt.execute();
				
			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				cStmt.close(); con.close();
			}
			
			return prescriptionId;
		}
			
			
			public static void addPrescriptionDetails(String prescription_id, String medicineId, PrescriptionData inPrescriptionData) throws SQLException {
				Connection con = null;
				CallableStatement cStmt = null;
				try {
					
					con = BKDatabaseUtil.getConnection();
					cStmt = con.prepareCall(SQLQueries.INSERT_PRESCRIPTION_DETAILS);
					cStmt.setString(1, prescription_id);
					cStmt.setString(2, medicineId);
					cStmt.setInt(3, inPrescriptionData.frequency);
					cStmt.setInt(4, inPrescriptionData.duration);
					
		            cStmt.execute();
					
				} catch (SQLException | NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					cStmt.close(); con.close();
				}
				
	}
			public static void updatestatus(String status, String patent_id) throws SQLException {
				Connection con = null;
				CallableStatement cStmt = null;
				try {
					
					con = BKDatabaseUtil.getConnection();
					cStmt = con.prepareCall(SQLQueries.UPDATE_STATUS);
					cStmt.setString(1, status);
					cStmt.setString(2, patent_id);
					
					
		            cStmt.execute();
					
				} catch (SQLException | NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					cStmt.close(); con.close();
				}
				
	}
			
			
			public static List<Status> getStatusDetails(String status) throws SQLException {
				List<Status> statuses = new ArrayList<Status>();
				Connection con = null;
				PreparedStatement cStmt = null;
				ResultSet rs = null;
				
				try {
					con = BKDatabaseUtil.getConnection();
					cStmt = con.prepareStatement(SQLQueries.GET_STATUS_DETAILS);
					cStmt.setString(1, status);
					rs = cStmt.executeQuery();
					while (rs.next()) {
						String patient_first_name = rs.getString(1);
						String patient_lastname = rs.getString(2);
						String medicine_id = rs.getString(3);
						String status1 = rs.getString(4);
						
						Status s = new Status(patient_first_name,patient_lastname, medicine_id,status1);
						statuses.add(s);
						
					}
					
					
				} catch (SQLException | NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					cStmt.close(); 
					con.close();
				}
				
            return statuses;
		}
			
			
				
			public static void createPrescription(Prescription inPrescription) throws SQLException // change the return type
, UtilExceptions

			
			{
				
				String patId = getPatientId(inPrescription.patient);
				if(patId == null){
					addPatient(inPrescription.patient);
					patId = getPatientId(inPrescription.patient);
				}
				inPrescription.patient.id = patId;
				
				String prescriptionId = addPrescriptionMaster(inPrescription);
				inPrescription.prescriptionId = prescriptionId;
				
				for (PrescriptionData rowItem: inPrescription.prescriptionList) {
					String medId = getMedicineId(rowItem.medicineName);
					if(medId == null)
					{
					
						throw new UtilExceptions("medicine not available!!");
					}
					else{
						int med_count = 0;
						med_count = rowItem.duration * rowItem.frequency;
						if(getMedicineCount(rowItem.medicineName) < med_count){
							
							throw new UtilExceptions("not enough medicine!!");
							
						}
						else{
						
					addPrescriptionDetails(prescriptionId, medId, rowItem);
					}
					}
				}
				
			}
		
}



	
	
	
	