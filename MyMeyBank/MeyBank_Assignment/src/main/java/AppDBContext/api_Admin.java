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
import org.mindrot.jbcrypt.BCrypt;

import Models.Account;
import Models.Admin;
import Models.BankAccount;

public class api_Admin {

	public static String tokem_id = null;
	public static String token_Password = null;
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/Admin/");
		return url.toString();
	}
	
	public static void getKEY(String id , String Password) {
		tokem_id = id;
		token_Password = Password;
	}

	public static String Token()throws Exception {
		
		URL _url = new URL("http://localhost:5200/api/AdminToken");
		
		HttpURLConnection connection = null;
		
		connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		JSONObject obj = new JSONObject();
		obj.put("Username", tokem_id);
		obj.put("Password", token_Password);
		
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

	public static List<Admin> getAllAdmin()throws Exception{
		
		JSONObject obj = new JSONObject();
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		String Token = Token();
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
		List<Admin> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("adminID");
			String fullname = obj.getString("fullName");
			String img = obj.getString("img");
			String username = obj.getString("username");
			String password = obj.getString("password");

			list.add(new Admin(id,fullname,img,username,password));
		}
		
		return list;
		
	}
	
	public static void CreateAdmin(Admin admin)throws Exception {

		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("AdminID", 0);
		obj.put("FullName", admin.getFullName());
		obj.put("IMG", admin.getIMG());
		obj.put("Username", admin.getUsername());
		obj.put("Password", admin.getPassword());
		
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
	
	public static void UpdateAccount(Admin admin)throws Exception {
		
		String url = URL()+admin.getAdminID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("AdminID", admin.getAdminID());
		obj.put("FullName", admin.getFullName());
		obj.put("IMG", admin.getIMG());
		obj.put("Username", admin.getUsername());
		obj.put("Password", admin.getPassword());
		
		String data = obj.toString();
		byte[] dataBytes = data.getBytes();
		
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(dataBytes);
		outputStream.close();
		
		System.out.println(connection.getResponseCode() == 204);
		
		if(connection.getResponseCode() == 204) {
			return;
		}else {
			return;
		}
		
		
	}
	
	
	public static Admin getAdmin(String username,String password)throws Exception {
		
		List<Admin> list_admin = getAllAdmin();
		Admin admin = null;
		
		for(var i : list_admin) {
			if(i.getUsername().equals(username) && BCrypt.checkpw(password, i.getPassword())) {
				admin = i;
				break;
			}
		}
			
		return admin;
		
	}

	public static List<Admin> getAdmin_list(int id)throws Exception {
		
		List<Admin> list_admin = getAllAdmin();
		List<Admin> list_admin2 = new ArrayList<>();
		
		for(var i : list_admin) {
			if(i.getAdminID()!=id) {
				list_admin2.add(i);
			}
		}
			
		return list_admin2;
		
	}

	
	public static boolean getAdmin_CheckFullname(String fullname)throws Exception {
		
		List<Admin> list_admin = getAllAdmin();
		boolean b = false;
		
		for(var i : list_admin) {
			if(i.getFullName().equals(fullname)) {
				b = true;
				break;
			}
		}
			
		return b;
		
	}

	public static boolean getAdmin__Checkid(String username)throws Exception {
	
	List<Admin> list_admin = getAllAdmin();
	boolean b = false;
	
	for(var i : list_admin) {
		if(i.getUsername().equals(username)) {
			b = true;
			break;
		}
	}
		
	return b;
	
}

	public static boolean getAdmin__Checkpassword(String password)throws Exception {
	
	List<Admin> list_admin = getAllAdmin();
	boolean b = false;
	
	for(var i : list_admin) {
		if(BCrypt.checkpw(password, i.getPassword())) {
			b = true;
			break;
		}		
	}
		
	return b;
	
}

	
}
