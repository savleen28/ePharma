package test;

public class PrescribedMedicines {
	public String medicine_id;
	public String frequency;
	public String duration;
	
	
	public PrescribedMedicines()
	{
		super();
	}
	
	public PrescribedMedicines(String medicine_id, String frequency, String duration)
	{
		this.medicine_id = medicine_id;
		this.frequency = frequency;
		this.duration = duration;
	}
}
