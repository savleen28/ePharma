package Pharma;

public class PrescriptionData {
	public String medicineName;
	public int frequency;
	public int duration;
	public String status;
	public String prescription_id;
	
	public PrescriptionData()
	{
		super();
	}

	
	public PrescriptionData(String medicineName,int frequency,int duration, String status,String prescription_id)
	{
		this.medicineName = medicineName;
		this.frequency = frequency;
		this.duration = duration;
		this.status = status;
		this.prescription_id = prescription_id;
	}
}
