package Models;

public class Account {

	private int AccountID;
	private int UserID;
	private String Username;
	private String Password;
	private String AccountStatus;
	private int LoginLimit;
	private String VerifyWord;
	private String BankType;
	private String LoginTime;
	
	
	
	public Account() {

	}
	public Account(int accountID, int userID, String username, String password, String accountStatus, int loginLimit,
			String verifyWord, String bankType, String loginTime) {
		AccountID = accountID;
		UserID = userID;
		Username = username;
		Password = password;
		AccountStatus = accountStatus;
		LoginLimit = loginLimit;
		VerifyWord = verifyWord;
		BankType = bankType;
		LoginTime = loginTime;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
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
	public String getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}
	public int getLoginLimit() {
		return LoginLimit;
	}
	public void setLoginLimit(int loginLimit) {
		LoginLimit = loginLimit;
	}
	public String getVerifyWord() {
		return VerifyWord;
	}
	public void setVerifyWord(String verifyWord) {
		VerifyWord = verifyWord;
	}
	public String getBankType() {
		return BankType;
	}
	public void setBankType(String bankType) {
		BankType = bankType;
	}
	public String getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(String loginTime) {
		LoginTime = loginTime;
	}
	
}
