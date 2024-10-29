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

public class api_User {

	public static String tokem_id = null;
	public static String token_Password = null;
	public static api_Admin api_admin = new api_Admin();
	public static api_Account api_account = new api_Account();
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/User/");
		return url.toString();
	}
	
	public static List<User> getAllUser()throws Exception{

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
		List<User> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int UserID = obj.getInt("userID");
			String FullName = obj.getString("fullName");
			String IMG = obj.getString("img");
			String NRIC = obj.getString("nric");
			int Age = obj.getInt("age");
			String BirthDate = obj.getString("birthDate");
			String Gender = obj.getString("gender");
			String BankType = obj.getString("email");
			boolean Active = obj.getBoolean("active");

			list.add(new User(UserID,FullName,IMG,NRIC,Age,BirthDate,Gender,BankType,Active));
		}
		
		return list;
		
	}
	
	public static void CreateUser(User user)throws Exception {
		
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("UserID", 0);
		obj.put("FullName", user.getFullName());
		obj.put("IMG", user.getIMG());
		obj.put("NRIC", user.getNRIC());
		obj.put("Age", user.getAge());
		obj.put("BirthDate", user.getBirthDate());
		obj.put("Gender", user.getGender());
		obj.put("Email", user.getEmail());
		obj.put("Active", user.isActive());
		
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

	public static void UpdateAccount(User user)throws Exception {
		
		String url = URL()+user.getUserID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("UserID", user.getUserID());
		obj.put("FullName", user.getFullName());
		obj.put("IMG", user.getIMG());
		obj.put("NRIC", user.getNRIC());
		obj.put("Age", user.getAge());
		obj.put("BirthDate", user.getBirthDate());
		obj.put("Gender", user.getGender());
		obj.put("Email", user.getEmail());
		obj.put("Active", user.isActive());
		
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

	public static User getUser_By_Email(String email,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			api_account.getKEY(us, password);
		}

		List<User> user_list = getAllUser();
		
		User user = null;
		for(var i : user_list) {
			if(i.getEmail().equals(email)) {
				user = i;
				break;
			}		
		}
		
		return user;
		
	}
	
	public static User getUser_By_ID(int id,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			api_account.getKEY(us, password);
		}

		List<User> user_list = getAllUser();
		
		User user = null;
		for(var i : user_list) {
			if(i.getUserID() == id) {
				user = i;
				break;
			}		
		}
		
		return user;
		
	}
	
	public static User getUser_By_ID2(int id)throws Exception {

		List<User> user_list = getAllUser();
		
		User user = null;
		for(var i : user_list) {
			if(i.getUserID() == id) {
				user = i;
				break;
			}		
		}
		
		return user;
		
	}
	
	public static List<User> getUser_list(String value)throws Exception {

		List<User> user_list = getAllUser();
		List<User> user_list2 = new ArrayList<>();

		
		for(var i : user_list) {
			if(i.getFullName().contains(value)) {
				user_list2.add(i);
			}		
		}
		
		return user_list2;
		
	}

	
	
	public static boolean Checking_By_Email(String email,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			api_account.getKEY(us, password);
		}

		List<User> user_list = getAllUser();
		
		boolean b = false;
		for(var i : user_list) {
			if(i.getEmail().equals(email)) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}
	
	public static boolean Checking_By_NRIC(String NRIC,String us,String password,String type)throws Exception {
		
		if(type.equals("admin"))
			api_admin.getKEY(us, password);
		else if(type.equals("account")) {
			api_account.getKEY(us, password);
		}

		List<User> user_list = getAllUser();
		
		boolean b = false;
		for(var i : user_list) {
			if(i.getNRIC().equals(NRIC)) {
				b = true;
				break;
			}		
		}
		
		return b;
		
	}
	
}
