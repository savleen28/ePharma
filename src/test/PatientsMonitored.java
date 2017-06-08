package test;

public class PatientsMonitored {
	public String patient_id;
	public int id;
	public String status;
	public String date;
	
	public PatientsMonitored()
	{
		super();
	}

	public PatientsMonitored(String patient_id,int id, String status, String date)
	{
		this.patient_id = patient_id;
		this.id = id;
		this.status = status;
		this.date = date;
	}
}
