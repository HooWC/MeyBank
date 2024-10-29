package AppDBContext;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import Models.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class api_Account {

	
	static api_Admin api_admin = new api_Admin();
	public static String Account_id = null;
	public static String Account_Password = null;
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/Account/");
		return url.toString();
	}
	
	public static void getKEY(String id , String Password) {
		Account_id = id;
		Account_Password = Password;
	}

	public static String Token()throws Exception {
		URL _url = new URL("http://localhost:5200/api/AccountToken/");
		HttpURLConnection connection = null;
		
		connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		JSONObject obj = new JSONObject();
		obj.put("Username", Account_id);
		obj.put("Password", Account_Password);
		
		String data = obj.toString();
		
        byte[] dataBytes = data.getBytes();
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(dataBytes);
        outputStream.close();
        
        if(connection.getResponseCode() != 400) {
        	InputStream inputStream = connection.getInputStream();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	        StringBuilder result = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            result.append(line);
	        }
	        
	        String Token = result.toString();
	        return Token;
		}
        
        return null;
        
        
	}

	public static List<Account> getAllAccount()throws Exception{

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
		List<Account> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("accountID");
			int CustomerID = obj.getInt("userID");
			String Username = obj.getString("username");
			String Password = obj.getString("password");
			String UserStatus = obj.getString("accountStatus");
			int LoginLimit = obj.getInt("loginLimit");
			String Verifyimage = obj.getString("verifyWord");
			String BankType = obj.getString("bankType");
			String LoginTime = obj.getString("loginTime");

			list.add(new Account(id,CustomerID,Username,Password,UserStatus,LoginLimit,Verifyimage,BankType,LoginTime));
		}
		
		return list;
		
	}
	
	public static void CreateAccount(Account acc)throws Exception {
		
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("AccountID", 0);
		obj.put("UserID", acc.getUserID());
		obj.put("Username", acc.getUsername());
		obj.put("Password", acc.getPassword());
		obj.put("AccountStatus", acc.getAccountStatus());
		obj.put("LoginLimit", acc.getLoginLimit());
		obj.put("VerifyWord", acc.getVerifyWord());
		obj.put("BankType", acc.getBankType());
		obj.put("LoginTime", acc.getLoginTime());
		
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

	public static void UpdateAccount(Account acc,String type)throws Exception {
		
		String url = URL()+acc.getAccountID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = null;
		if(type.equals("admin")) {
			Token = api_admin.Token();
		}else {
			Token = Token();
		}
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("AccountID", acc.getAccountID());
		obj.put("UserID", acc.getUserID());
		obj.put("Username", acc.getUsername());
		obj.put("Password", acc.getPassword());
		obj.put("AccountStatus", acc.getAccountStatus());
		obj.put("LoginLimit", acc.getLoginLimit());
		obj.put("VerifyWord", acc.getVerifyWord());
		obj.put("BankType", acc.getBankType());
		obj.put("LoginTime", acc.getLoginTime());
		
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
	
	public static Account getAccount_By_username_pass(String username,String pass,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getUsername().equals(username) && i.getPassword().equals(pass)) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}
	
	public static Account getAccount(int id,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getAccountID() == id) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}

	public static Account getAccount_MB(int id,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getAccountID() == id && i.getBankType().equals("MeyBank")) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}

	
	public static Account getAccount_Byid(int id)throws Exception {
		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getAccountID() == id) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}

	public static List<Account> getAllAccount_MB()throws Exception {

		List<Account> Account_list = getAllAccount();
		List<Account> Account_list2 = new ArrayList<>();
		
		for(var i : Account_list) {
			if(i.getBankType().equals("MeyBank")) {
				Account_list2.add(i);
			}		
		}
		
		return Account_list2;
		
	}

	
	public static boolean Checking_By_username(String username,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		boolean b = false;
		for(var i : Account_list) {
			if(i.getUsername().equals(username)) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}
	
	public static boolean Checking_By_username2(String username)throws Exception {

		List<Account> Account_list = getAllAccount();
		
		boolean b = false;
		for(var i : Account_list) {
			if(i.getUsername().equals(username) && i.getBankType().equals("MeyBank")) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}
	
	public static boolean Checking_V(String Ver)throws Exception {

		List<Account> Account_list = getAllAccount();
		
		boolean b = false;
		for(var i : Account_list) {
			if(i.getVerifyWord().equals(Ver)) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}
	
	
	public static boolean Checking_By_password(String pass,String us,String password,String type)throws Exception {
	
	if(type.equals("admin"))
		api_admin.getKEY(us, password);
	else if(type.equals("account")) {
		getKEY(us, password);
	}

	List<Account> Account_list = getAllAccount();
	
	boolean b = false;
	for(var i : Account_list) {
		if(BCrypt.checkpw(pass, i.getPassword())) {
			b = true;
			break;
		}		
	}
	
	return b;
	
}

	public static boolean Checking_By_password2(String pass)throws Exception {


		List<Account> Account_list = getAllAccount();
		
		boolean b = false;
		for(var i : Account_list) {
			if(BCrypt.checkpw(pass, i.getPassword())) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}

	
	public static boolean Checking_Account_Login(String userid,String pass,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		boolean b = false;
		for(var i : Account_list) {
			if(i.getUsername().equals(userid) && BCrypt.checkpw(pass, i.getPassword())) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}

	public static Account Get_Account_username(String userid,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getUsername().equals(userid) && i.getAccountStatus().equals("active")) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}

	public static Account Get_Account_Login(String userid,String pass,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			getKEY(us, password);
		}

		List<Account> Account_list = getAllAccount();
		
		Account acc = null;
		for(var i : Account_list) {
			if(i.getUsername().equals(userid) && BCrypt.checkpw(pass, i.getPassword())) {
				acc = i;
				break;
			}		
		}
		
		return acc;
		
	}

	public static boolean Checking_By_ver(String ver,String us,String password,String type)throws Exception {
	
	if(type.equals("admin"))
		api_admin.getKEY(us, password);
	else if(type.equals("account")) {
		getKEY(us, password);
	}

	List<Account> Account_list = getAllAccount();
	
	boolean b = false;
	for(var i : Account_list) {
		if(i.getVerifyWord().equals(ver)) {
			b = true;
			break;
		}		
	}
	
	return b;
	
}

	
}
