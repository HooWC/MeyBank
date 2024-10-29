package Models;

public class Admin {

	private int AdminID;
	private String FullName;
	private String IMG;
	private String Username;
	private String Password;
	
	
	
	public Admin() {
	}
	public Admin(int adminID, String fullName, String iMG, String username, String password) {
		AdminID = adminID;
		FullName = fullName;
		IMG = iMG;
		Username = username;
		Password = password;
	}
	public int getAdminID() {
		return AdminID;
	}
	public void setAdminID(int adminID) {
		AdminID = adminID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
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
		Password = password;
	}
	
	
}
