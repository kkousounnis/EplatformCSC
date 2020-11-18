package Main;

public class User {
	private String Username;
	private String Password;
	private  String CardIdnumber;
	private  String Email ;
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password; 
	}
	
	
	public void setPassword(String password) {
		Password=password;
	}
	public void setCardIdnumber(String cardidnumber) {
		CardIdnumber=cardidnumber;
	}
	public String getCardIdnumber() {
		return CardIdnumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
