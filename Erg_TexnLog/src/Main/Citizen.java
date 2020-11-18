package Main;

public class Citizen extends User {
	public Citizen() {
		super();
	}
	
	private String Firstname;
	private String Lastname;
	private String Fathersname;
	private String Mothersname;
	private String Birth;	
	private String Amka;
	private String Afm;
	private String Streetaddress;
	private String Phonenumber;
	
	
	
	
	
	
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public void setFathersname(String fathersname) {
		Fathersname=fathersname;
	}
	public String getFathersname() {
		return Fathersname;
	}
	public String getMothersname() {
		return Mothersname;
	}
	public void setMothersname(String mothersname) {
		Mothersname = mothersname;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getAmka() {
		return Amka;
	}
	public void setAmka(String amka) {
		Amka = amka;
	}
	public void setAfm(String afm) {
		Afm=afm;
	}
	public String getAfm() {
		return Afm;
	}
	public String getStreetaddress() {
		return Streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		Streetaddress = streetaddress;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber=phonenumber;
	}
	public String  getPhonenumber() {
		return Phonenumber;
	}

}
