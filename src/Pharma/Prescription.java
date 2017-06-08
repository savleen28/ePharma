package Pharma;

import java.util.List;

public class Prescription {
	public String prescriptionId;
	public String status;
	public Patient patient;
	public List<PrescriptionData> prescriptionList;
	
	public Prescription()
	{
		super();
	}
	
	public Prescription(String prescriptionId, Patient patient, String status,List<PrescriptionData> prescriptionList)
	{
		this.prescriptionId = prescriptionId;
		this.patient = patient;
		this.status = status;
		this.prescriptionList = prescriptionList;
	}
	

}
