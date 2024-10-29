package AppDBContext;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class api_BankAccount {
	
	
	static api_Admin api_admin = new api_Admin();
	static api_Account api_account = new api_Account();
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/BankAccount/");
		return url.toString();
	}
	
	public static List<BankAccount> getAllBankAccount()throws Exception{

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
		List<BankAccount> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("bankAccountID");
			int AccountID = obj.getInt("accountID");
			String AccountType = obj.getString("accountType");
			String BankAccNo = obj.getString("bankAccNo");
			String CardNumber= obj.getString("cardNumber");
			int PinNumber = obj.getInt("pinNumber");
			double Balance = obj.getDouble("balance");
			double CardLimit = obj.getDouble("cardLimit");
			int BankAcStatus = obj.getInt("bankAcStatus");
			int AllLimit = obj.getInt("allLimit");
			boolean Change = obj.getBoolean("change");

			list.add(new BankAccount(id,AccountID,AccountType,BankAccNo,CardNumber,PinNumber,Balance,CardLimit,BankAcStatus,AllLimit,Change));
		}
		
		return list;
		
	}
	
	public static void CreateBankAccount(BankAccount bank,String type)throws Exception {
		
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = null;
		if(type.equals("admin")) {
			Token = api_admin.Token();
		}else {
			Token = api_account.Token();
		}
		
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("BankAccountID", 0);
		obj.put("AccountID", bank.getAccountID());
		obj.put("AccountType", bank.getAccountType());
		obj.put("BankAccNo", bank.getBankAccNo());
		obj.put("CardNumber", bank.getCardNumber());
		obj.put("PinNumber", bank.getPinNumber());
		obj.put("Balance", bank.getBalance());
		obj.put("CardLimit", bank.getCardLimit());
		obj.put("BankAcStatus", bank.getBankAcStatus());
		obj.put("AllLimit", bank.getAllLimit());
		obj.put("Change", bank.isChange());
		
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

	public static void UpdateBankAccountID(BankAccount bank)throws Exception {
		
		String url = URL()+bank.getBankAccountID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("BankAccountID", bank.getBankAccountID());
		obj.put("AccountID", bank.getAccountID());
		obj.put("AccountType", bank.getAccountType());
		obj.put("BankAccNo", bank.getBankAccNo());
		obj.put("CardNumber", bank.getCardNumber());
		obj.put("PinNumber", bank.getPinNumber());
		obj.put("Balance", bank.getBalance());
		obj.put("CardLimit", bank.getCardLimit());
		obj.put("BankAcStatus", bank.getBankAcStatus());
		obj.put("AllLimit", bank.getAllLimit());
		obj.put("Change", bank.isChange());
		
		String data = obj.toString();
		byte[] dataBytes = data.getBytes();
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(dataBytes);
		outputStream.close();
		
		if(connection.getResponseCode() == 204) {
			return;
		}else {
			return;
		}

		
	}
	
	public static BankAccount getBankAccount(int id)throws Exception {
		
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount bank = null;
		
		for(var i : list_bank) {
			if(i.getBankAccountID() == id) {
				bank = i;
				break;
			}
		}
			
		return bank;
		
	}
	
	public static BankAccount getBankAccount_ByBankAccount(String num)throws Exception {
		
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount bank = null;
		
		for(var i : list_bank) {
			if(i.getBankAccNo().equals(num)) {
				bank = i;
				break;
			}
		}
			
		return bank;
		
	}
	
	public static BankAccount getBankAccount_ByCardnum(String num)throws Exception {
		
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount bank = null;
		
		for(var i : list_bank) {
			if(i.getCardNumber().equals(num)) {
				bank = i;
				break;
			}
		}
			
		return bank;
		
	}


	
	public static BankAccount getBankAccount_Bydebit(String num)throws Exception {
		
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount bank = null;
		
		for(var i : list_bank) {
			if(i.getBankAccNo().equals(num)) {
				bank = i;
				break;
			}
		}
			
		return bank;
		
	}

	
	public static boolean Forget_CheckBankAccount(String cardnum,String pinnumber , String us,String password)throws Exception {
		
		api_admin.getKEY(us, password);
		List<BankAccount> bank_list = getAllBankAccount();
		boolean b = false;
		int pin = Integer.valueOf(pinnumber);
		for(var i : bank_list) {
			if(i.getCardNumber().equals(cardnum) && i.getPinNumber() == pin) {
				b = true;
				break;
			}
		}
		
		return b;
		
	}

	public static Account getAccount(String cardnum,String pinnumber , String us,String password)throws Exception {
		
		api_account.getKEY(us, password);
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount b = null;
		int pin = Integer.valueOf(pinnumber);
		for(var i : list_bank) {
			if(i.getCardNumber().equals(cardnum) && i.getPinNumber() == pin) {
				b = i;
				break;
			}
		}
		
		api_account.getKEY(us, password);
		List<Account> list_acc = api_account.getAllAccount();
		Account acc = null;
		for(var i : list_acc) {
			if(i.getAccountID() == b.getAccountID()) {
				acc = i;
				break;
			}
		}
		
		
		return acc;
		
	}
	
	public static Account getAccount_MB(String cardnum,String pinnumber , String us,String password)throws Exception {
		
		api_account.getKEY(us, password);
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount b = null;
		int pin = Integer.valueOf(pinnumber);
		for(var i : list_bank) {
			if(i.getCardNumber().equals(cardnum) && i.getPinNumber() == pin) {
				b = i;
				break;
			}
		}
		
		api_account.getKEY(us, password);
		List<Account> list_acc = api_account.getAllAccount();
		Account acc = null;
		for(var i : list_acc) {
			if(i.getAccountID() == b.getAccountID() && i.getBankType().equals("MeyBank")) {
				acc = i;
				break;
			}
		}
		
		
		return acc;
		
	}
	
	
	public static Account getAccount2(String cardnum,String pinnumber ,String type, String us,String password)throws Exception {
		
		api_account.getKEY(us, password);
		List<BankAccount> list_bank = getAllBankAccount();
		BankAccount b = null;
		int pin = Integer.valueOf(pinnumber);
		for(var i : list_bank) {
			if(i.getCardNumber().equals(cardnum) && i.getPinNumber() == pin) {
				b = i;
				break;
			}
		}
		
		api_account.getKEY(us, password);
		List<Account> list_acc = api_account.getAllAccount();
		Account acc = null;
		for(var i : list_acc) {
			if(i.getAccountID() == b.getAccountID() && i.getBankType().equals(type)) {
				acc = i;
				break;
			}
		}
		
		
		return acc;
		
	}
	
	
	public static List<BankAccount> getListBankAccount_By_AccountID(int accid)throws Exception {
	
		List<BankAccount> list_bank = getAllBankAccount();
		List<BankAccount> list = new ArrayList<>();
		
		for(var i : list_bank) {
			if(i.getAccountID() == accid) {
				list.add(i);
			}
		}
			
		return list;
		
	}
	
}
