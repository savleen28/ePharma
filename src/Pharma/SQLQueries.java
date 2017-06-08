package Pharma;

public class SQLQueries {

		
		public static final String INSERT_HOSPITAL =
				"INSERT INTO SAVLEEN.HOSPITAL(HOSPITAL_ID,HOSPITAL_NAME,ADDRESS,CONTACT_NO,EMAIL,HEAD,ACTIVE,LST_UPDTED_ON,LST_UPDTED_BY) VALUES(?,?,?,?,?,?,?,?,?)";
		
		public static final String INSERT_MEDICINE = 
				"INSERT INTO SAVLEEN.MEDICINES(MEDICINE_ID, MEDICINE_NAME, QUANTITY, EXPIRY_DATE) VALUES(?,?,?,?)";
		
		public static final String INSERT_PRESCRIBED_MEDICINES =
				"INSERT INTO SAVLEEN.PRESCRIBED_MEDICINES(MEDICINE_ID,FREQUENCY,DURATION) VALUES(?,?,?)";
		
		public static final String INSERT_PATIENTS_MONITORED =
				" INSERT INTO savleen.PATIENTS_MONITORED (PATIENT_ID,ID,STATUS,DATE) VALUES(?,?,?,?)";
		
	   /* public static final String GET_MEDICINE_COUNT =
			"select count(*) from savleen.medicine_master where medicine_name =?";*/
	    
	    public static final String GET_PATIENT_ID =
	    		"select patient_id from savleen.patient where patient_first_name = ? and patient_lastname = ? and address = ?";
	    
	    public static final String INSERT_PATIENT =
	    		"insert into savleen.patient ( patient_id, patient_first_name,patient_lastname,patient_age,gender,ins_no,minor,ins_company,address)  values (?,?,?,?,?,?,?,?,?)";
	    
	    public static final String INSERT_PRESCRIPTION_MASTER =
	    		"insert into savleen.prescription (prescription_id, patient_id,date,status) values(?, ?,now(),\"recivied\")";
	    
	    public static final String INSERT_PRESCRIPTION_DETAILS = 
	    		"insert into savleen.prescription_details(prescription_id,medicine_id,frequency,duration) values(?,?,?,?)";
	    
	    public static final String GET_MEDICINE_ID =
	    		"select medicine_id from savleen.medicine_master where medicine_name = ?";
	    
	    public static final String GET_MEDICINE_COUNT =
	    		"select quantity from savleen.medicine_master where medicine_name = ?";
	    
	    public static final String GET_STATUS_DETAILS =
	    		"select p.patient_first_name,p.patient_lastname,m.medicine_name,pr.status from savleen.patient p, savleen.prescription_details pd, savleen.prescription pr, savleen.medicine_master m where p.patient_id = pr.patient_id and pd.prescription_id = pr.prescription_id and pr.status = ? and m.medicine_id = pd.medicine_id";
}




