package AppDBContext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.Account;
import Models.BankAccount;
import Models.Transaction;

public class api_Transaction {
	static api_Admin api_admin = new api_Admin();
	static api_Account api_account = new api_Account();
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/Transaction/");
		return url.toString();
	}
	
	public static List<Transaction> getAllTransaction()throws Exception{

		JSONObject obj = new JSONObject();
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		String Token = api_account.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.connect();
		
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder result = new StringBuilder();
		String line;
		while((line=reader.readLine()) != null) {
			result.append(line);
		}
		
		reader.close();
		JSONArray array = new JSONArray(result.toString());
		List<Transaction> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("transactionID");
			int BankAccountID = obj.getInt("bankAccountID");
			String TransactionType = obj.getString("transactionType");
			String TransactionStatus = obj.getString("transactionStatus");
			String Date= obj.getString("date");
			String Description = obj.getString("description");
			String Credit = obj.getString("credit");
			String Debit = obj.getString("debit");
			double Amount = obj.getDouble("amount");
			boolean IsIBG = obj.getBoolean("isIBG");
			double SMSNotification = obj.getDouble("smsNotification");
			String PhoneNumber = obj.getString("phoneNumber");
			String Email = obj.getString("email");
			String OtherDescription = obj.getString("otherDescription");

			list.add(new Transaction(id,BankAccountID,TransactionType,TransactionStatus,Date,Description,Credit,Debit,Amount,
					IsIBG,SMSNotification,PhoneNumber,Email,OtherDescription));
		}
		
		return list;
		
	}
	
	public static List<Transaction> getAllTransaction2()throws Exception{

		JSONObject obj = new JSONObject();
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.connect();
		
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder result = new StringBuilder();
		String line;
		while((line=reader.readLine()) != null) {
			result.append(line);
		}
		
		reader.close();
		JSONArray array = new JSONArray(result.toString());
		List<Transaction> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("transactionID");
			int BankAccountID = obj.getInt("bankAccountID");
			String TransactionType = obj.getString("transactionType");
			String TransactionStatus = obj.getString("transactionStatus");
			String Date= obj.getString("date");
			String Description = obj.getString("description");
			String Credit = obj.getString("credit");
			String Debit = obj.getString("debit");
			double Amount = obj.getDouble("amount");
			boolean IsIBG = obj.getBoolean("isIBG");
			double SMSNotification = obj.getDouble("smsNotification");
			String PhoneNumber = obj.getString("phoneNumber");
			String Email = obj.getString("email");
			String OtherDescription = obj.getString("otherDescription");

			list.add(new Transaction(id,BankAccountID,TransactionType,TransactionStatus,Date,Description,Credit,Debit,Amount,
					IsIBG,SMSNotification,PhoneNumber,Email,OtherDescription));
		}
		
		return list;
		
	}
	
	
	public static void CreateTransaction(Transaction tr)throws Exception {
		
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_account.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("TransactionID", 0);
		obj.put("BankAccountID", tr.getBankAccountID());
		obj.put("TransactionType", tr.getTransactionType());
		obj.put("TransactionStatus", tr.getTransactionStatus());
		obj.put("Date", tr.getDate());
		obj.put("Description", tr.getDescription());
		obj.put("Credit", tr.getCredit());
		obj.put("Debit", tr.getDebit());
		obj.put("Amount", tr.getAmount());
		obj.put("IsIBG", tr.isIsIBG());
		obj.put("SMSNotification", tr.getSMSNotification());
		obj.put("PhoneNumber", tr.getPhoneNumber());
		obj.put("Email", tr.getEmail());
		obj.put("OtherDescription", tr.getOtherDescription());
		
		String data = obj.toString();
		byte[] dataBytes = data.getBytes();
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(dataBytes);
		outputStream.close();
		
		if(connection.getResponseCode() == 201) {
			return;
		}else {
			return;
		}
		
	}

	public static void UpdateTransaction(Transaction tr)throws Exception {
		
		String url = URL()+tr.getTransactionID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("TransactionID", tr.getTransactionID());
		obj.put("BankAccountID", tr.getBankAccountID());
		obj.put("TransactionType", tr.getTransactionType());
		obj.put("TransactionStatus", tr.getTransactionStatus());
		obj.put("Date", tr.getDate());
		obj.put("Description", tr.getDescription());
		obj.put("Credit", tr.getCredit());
		obj.put("Debit", tr.getDebit());
		obj.put("Amount", tr.getAmount());
		obj.put("IsIBG", tr.isIsIBG());
		obj.put("SMSNotification", tr.getSMSNotification());
		obj.put("PhoneNumber", tr.getPhoneNumber());
		obj.put("Email", tr.getEmail());
		obj.put("OtherDescription", tr.getOtherDescription());
		
		String data = obj.toString();
		byte[] dataBytes = data.getBytes();
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(dataBytes);
		outputStream.close();
		
		System.out.println(connection.getResponseCode());
		if(connection.getResponseCode() == 204) {
			return;
		}else {
			return;
		}

		
		
	}

	public static Transaction getBankAccount_ByCardnum(String date,String des, String cre)throws Exception {
		
		List<Transaction> list_tr = getAllTransaction();
		Transaction tr = null;
		
		for(var i : list_tr) {
			if(i.getDate().equals(date) && i.getDescription().equals(des) && i.getCredit().equals(cre) ) {
				tr = i;
				break;
			}
		}
			
		return tr;
		
	}
	
	public static Transaction gettr_Byid(int id)throws Exception {
		
		List<Transaction> list_tr = getAllTransaction();
		Transaction tr = null;
		
		for(var i : list_tr) {
			if(i.getTransactionID() == id ) {
				tr = i;
				break;
			}
		}
			
		return tr;
		
	}
	
	public static Transaction gettr_Byid2(int id)throws Exception {
		
		List<Transaction> list_tr = getAllTransaction2();
		Transaction tr = null;
		
		for(var i : list_tr) {
			if(i.getTransactionID() == id ) {
				tr = i;
				break;
			}
		}
			
		return tr;
		
	}
	
	
	public static List<Transaction> getBankAccount_ByList(String debit,String date,String name, String pass)throws Exception {
		
		api_account.getKEY(name, pass);
		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String da = i.getDate();
			String time = da.substring(0, 10);
			if(date.equals(time) && i.getDebit().equals(debit) && (i.getTransactionType().equals("MB Other Account") || i.getTransactionType().equals("IBG Transfer")) && i.getTransactionStatus().equals("true") && i.isIsIBG() == true) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID(int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getBankAccountID() == id && i.getTransactionStatus().equals("true") && i.isIsIBG() == true) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Own(int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getBankAccountID() == id && i.getTransactionType().equals("Transfer Own Account") && i.getTransactionStatus().equals("true")) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_IBG(int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getBankAccountID() == id && i.getTransactionType().equals("IBG Transfer") && i.isIsIBG() == true && i.getTransactionStatus().equals("true")) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Payment(int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getBankAccountID() == id && i.getTransactionType().equals("Payment Transfer") && i.getTransactionStatus().equals("true")) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Other(int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getBankAccountID() == id && i.getTransactionType().equals("MB Other Account") && i.getTransactionStatus().equals("true")) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getIBG()throws Exception {

		List<Transaction> list_tr = getAllTransaction2();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.isIsIBG() == false && i.getTransactionType().equals("IBG Transfer") && i.getTransactionStatus().equals("true")) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_All()throws Exception {

		List<Transaction> list_tr = getAllTransaction2();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			if(i.getTransactionStatus().equals("true") && i.isIsIBG() == true &&  (i.getTransactionType().equals("IBG Transfer") || i.getTransactionType().equals("MB Other Account"))) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Select(String year,String month,int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String month1 = i.getDate().substring(5, 7);
			String year1 = i.getDate().substring(0, 4);
			if(i.getBankAccountID() == id && i.getTransactionStatus().equals("true") && i.isIsIBG() == true &&
					month1.equals(month) && year.equals(year)) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Own_Select(String year,String month,int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String month1 = i.getDate().substring(5, 7);
			String year1 = i.getDate().substring(0, 4);
			if(i.getBankAccountID() == id && i.getTransactionType().equals("Transfer Own Account") && i.getTransactionStatus().equals("true") &&
					month1.equals(month) && year.equals(year)) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_IBG_Select(String year,String month,int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String month1 = i.getDate().substring(5, 7);
			String year1 = i.getDate().substring(0, 4);
			if(i.getBankAccountID() == id && i.getTransactionType().equals("IBG Transfer") && i.isIsIBG() == true && i.getTransactionStatus().equals("true") && 
					month1.equals(month) && year.equals(year)) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Payment_Select(String year,String month,int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String month1 = i.getDate().substring(5, 7);
			String year1 = i.getDate().substring(0, 4);
			if(i.getBankAccountID() == id && i.getTransactionType().equals("Payment Transfer") && i.getTransactionStatus().equals("true") && 
					month1.equals(month) && year.equals(year)) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	public static List<Transaction> getBankAccount_ByBankAccountID_Other_Select(String year,String month,int id)throws Exception {

		List<Transaction> list_tr = getAllTransaction();
		List<Transaction> tr = new ArrayList<>();
		
		for(var i : list_tr) {
			String month1 = i.getDate().substring(5, 7);
			String year1 = i.getDate().substring(0, 4);
			if(i.getBankAccountID() == id && i.getTransactionType().equals("MB Other Account") && i.getTransactionStatus().equals("true") && 
					month1.equals(month) && year.equals(year)) {
				tr.add(i);
			}
		}
			
		return tr;
		
	}
	
	

}
