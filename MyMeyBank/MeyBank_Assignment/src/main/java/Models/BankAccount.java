package Models;

public class BankAccount {

	private int BankAccountID;
	private int AccountID;
	private String AccountType;
	private String BankAccNo;
	private String CardNumber;
	private int PinNumber;
	private double Balance;
	private double CardLimit;
	private int BankAcStatus;
	private double AllLimit;
	private boolean Change;
	


	public BankAccount(int bankAccountID, int accountID, String accountType, String bankAccNo, String cardNumber,
			int pinNumber, double balance, double cardLimit, int bankAcStatus, double allLimit, boolean change) {
		BankAccountID = bankAccountID;
		AccountID = accountID;
		AccountType = accountType;
		BankAccNo = bankAccNo;
		CardNumber = cardNumber;
		PinNumber = pinNumber;
		Balance = balance;
		CardLimit = cardLimit;
		BankAcStatus = bankAcStatus;
		AllLimit = allLimit;
		Change = change;
	}

	public boolean isChange() {
		return Change;
	}

	public void setChange(boolean change) {
		Change = change;
	}

	public double getAllLimit() {
		return AllLimit;
	}

	public void setAllLimit(double allLimit) {
		AllLimit = allLimit;
	}

	public BankAccount() {
	}

	public int getBankAccountID() {
		return BankAccountID;
	}
	public void setBankAccountID(int bankAccountID) {
		BankAccountID = bankAccountID;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getBankAccNo() {
		return BankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		BankAccNo = bankAccNo;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public int getPinNumber() {
		return PinNumber;
	}
	public void setPinNumber(int pinNumber) {
		PinNumber = pinNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public double getCardLimit() {
		return CardLimit;
	}
	public void setCardLimit(double cardLimit) {
		CardLimit = cardLimit;
	}
	public int getBankAcStatus() {
		return BankAcStatus;
	}
	public void setBankAcStatus(int bankAcStatus) {
		BankAcStatus = bankAcStatus;
	}
	
}
