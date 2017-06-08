package test;

public class Hospital {
public String id;
public String name;
public String address;
public String contact;
public String email;
public String incharge;
public String active;
public String lst_updted_on;
public String lst_updted_by;


public Hospital()
{
	super();
}


public Hospital(String id, String name, String address, String contact, String email, String incharge, String active, String lst_updted_on, String lst_updted_by)
{
	this.id = id;
	this.name = name;
	this.address = address;
	this.contact = contact;
	this.email = email;
	this.incharge = incharge;
	this.active = active;
	this.lst_updted_on = lst_updted_on;
	this.lst_updted_by = lst_updted_by;
}
}
