package Pharma;

public class Patient {
	public String id;
	public String fname;
	public String lname;
	public String age;
	public String gender;
	public String ins_no;
	public String minor;
	public String ins_company;
	public String address;

	public Patient() {
		super();
	}

	public Patient(String id,String fname,String lname, String minor, String age, String gender, String ins_no,String ins_company, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.ins_no = ins_no;
		this.minor = minor;
		this.ins_company = ins_company;
		this.address = address;

	}
}
