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
import Models.Contact;

public class api_Contact {

	static api_Admin api_admin = new api_Admin();
	static api_Account api_account = new api_Account();
	
	public static String URL()throws Exception {
		final URL url = new URL("http://localhost:5200/api/Contact/");
		return url.toString();
	}
	
	public static List<Contact> getAllContact()throws Exception{

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
		List<Contact> list = new ArrayList<>();
		for(int i = 0 ; i < array.length();i++) {
			obj = array.getJSONObject(i);
			int id = obj.getInt("contactID");
			String FullName = obj.getString("fullName");
			String Email = obj.getString("email");
			String Phone = obj.getString("phone");
			String NRIC= obj.getString("nric");
			String Content = obj.getString("content");
			boolean Handle = obj.getBoolean("handle");

			list.add(new Contact(id,FullName,Email,Phone,NRIC,Content,Handle));
		}
		
		return list;
		
	}
	
	public static void CreateContact(Contact c)throws Exception {
		
		String _url = URL();
		URL url = new URL(_url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		JSONObject obj = new JSONObject();
		obj.put("ContactID", 0);
		obj.put("FullName", c.getFullName());
		obj.put("Email", c.getEmail());
		obj.put("Phone", c.getPhone());
		obj.put("NRIC", c.getNRIC());
		obj.put("Content", c.getContent());
		obj.put("Handle", c.isHandle());
		
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

	public static void UpdateContact(Contact c)throws Exception {
		
		String url = URL()+c.getContactID();
		URL _url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		String Token = api_admin.Token();
		connection.setRequestProperty("Authorization", "Bearer " + Token);
		connection.setDoOutput(true);
		
		
		JSONObject obj = new JSONObject();
		obj.put("ContactID", c.getContactID());
		obj.put("FullName", c.getFullName());
		obj.put("Email", c.getEmail());
		obj.put("Phone", c.getPhone());
		obj.put("NRIC", c.getNRIC());
		obj.put("Content", c.getContent());
		obj.put("Handle", c.isHandle());
		
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
	
	public static Contact getContact_Byid(int id)throws Exception {

		List<Contact> list = getAllContact();
		
		Contact c = null;
		for(var i : list) {
			if(i.getContactID() == id) {
				c = i;
				break;
			}		
		}
		
		return c;
		
	}

	public static List<Contact> getContact_Admin()throws Exception {

		List<Contact> list = getAllContact();
		List<Contact> list_c = new ArrayList<>();

		for(var i : list) {
			if(i.isHandle() == false) {
				list_c.add(i);
			}		
		}
		
		return list_c;
		
	}

	
}
