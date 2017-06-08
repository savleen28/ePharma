package Pharma;

public class Status {
	public String patient_first_name;
	public String patient_lastname;
	public String medicine_name;
	public String status;
	
	public Status(){
		super();
	}
	
	public Status(String patient_first_name, String patient_lastname, String medicine_name, String status){
		this.patient_first_name = patient_first_name;
		this.patient_lastname = patient_lastname;
		this.medicine_name = medicine_name;
		this.status = status;
	}

}
