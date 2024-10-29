package Models;

public class Transaction {

	private int TransactionID;
	private int BankAccountID;
	private String TransactionType;
	private String TransactionStatus;
	private String Date;
	private String Description;
	private String Credit;
	private String Debit;
	private double Amount;
	private boolean IsIBG;
	private double SMSNotification;
	private String PhoneNumber;
	private String Email;
	private String OtherDescription;
	
	
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getOtherDescription() {
		return OtherDescription;
	}
	public void setOtherDescription(String otherDescription) {
		OtherDescription = otherDescription;
	}
	public Transaction() {
	}

	public Transaction(int transactionID, int bankAccountID, String transactionType, String transactionStatus,
			String date, String description, String credit, String debit, double amount, boolean isIBG,
			double sMSNotification, String phoneNumber, String email, String otherDescription) {
		TransactionID = transactionID;
		BankAccountID = bankAccountID;
		TransactionType = transactionType;
		TransactionStatus = transactionStatus;
		Date = date;
		Description = description;
		Credit = credit;
		Debit = debit;
		Amount = amount;
		IsIBG = isIBG;
		SMSNotification = sMSNotification;
		PhoneNumber = phoneNumber;
		Email = email;
		OtherDescription = otherDescription;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public int getBankAccountID() {
		return BankAccountID;
	}
	public void setBankAccountID(int bankAccountID) {
		BankAccountID = bankAccountID;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public String getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		TransactionStatus = transactionStatus;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	public String getDebit() {
		return Debit;
	}
	public void setDebit(String debit) {
		Debit = debit;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public boolean isIsIBG() {
		return IsIBG;
	}
	public void setIsIBG(boolean isIBG) {
		IsIBG = isIBG;
	}
	public double getSMSNotification() {
		return SMSNotification;
	}
	public void setSMSNotification(double sMSNotification) {
		SMSNotification = sMSNotification;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
}
