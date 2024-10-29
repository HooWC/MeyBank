package Models;

public class Contact {

	private int ContactID;
	private String FullName;
	private String Email;
	private String Phone;
	private String NRIC;
	private String Content;
	private boolean Handle;
	
	
	
	public Contact() {
	}
	public Contact(int contactID, String fullName, String email, String phone, String nRIC, String content,
			boolean handle) {
		ContactID = contactID;
		FullName = fullName;
		Email = email;
		Phone = phone;
		NRIC = nRIC;
		Content = content;
		Handle = handle;
	}
	public int getContactID() {
		return ContactID;
	}
	public void setContactID(int contactID) {
		ContactID = contactID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getNRIC() {
		return NRIC;
	}
	public void setNRIC(String nRIC) {
		NRIC = nRIC;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public boolean isHandle() {
		return Handle;
	}
	public void setHandle(boolean handle) {
		Handle = handle;
	}

	
}
