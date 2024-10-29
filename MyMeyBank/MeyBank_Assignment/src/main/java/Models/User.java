package Models;

public class User {

	private int UserID;
	private String FullName;
	private String IMG;
	private String NRIC;
	private int Age;
	private String BirthDate;
	private String Gender;
	private String Email;
	private boolean Active;
	
	
	
	public User(int userID, String fullName, String iMG, String nRIC, int age, String birthDate, String gender,
			String email, boolean active) {
		UserID = userID;
		FullName = fullName;
		IMG = iMG;
		NRIC = nRIC;
		Age = age;
		BirthDate = birthDate;
		Gender = gender;
		Email = email;
		Active = active;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public User() {
	}

	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
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
	public String getNRIC() {
		return NRIC;
	}
	public void setNRIC(String nRIC) {
		NRIC = nRIC;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
