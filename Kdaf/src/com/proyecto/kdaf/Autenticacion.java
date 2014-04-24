package com.proyecto.kdaf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Autenticacion extends AsyncTask<String, Void, Void> {

	JSONObject respJSON;
	
	protected Void doInBackground(String... params) {
		BufferedReader reader;
		
		try {
			
			
			URL webURL = new URL("http://81.45.23.75:8000/");
			HttpURLConnection http = (HttpURLConnection)webURL.openConnection();
			http.setRequestMethod("GET");
			
			//String basicAuth = "Basic " + new String(Base64.encode("admin:admin".getBytes(),Base64.NO_WRAP ));
			http.setRequestProperty ("Authorization", params[0]);
			http.setRequestProperty("Accept", "application/json");
			
			
			
			http.connect();
			if(http.getResponseCode() != http.HTTP_OK)
				Log.e("error", "error");
			else{
				InputStream is = (InputStream) http.getContent();
				reader = new BufferedReader(new InputStreamReader(is));
				
				String line = null;
				String resultado = new String();
				while ((line = reader.readLine()) != null){
					Log.e("resultado", line + "\n");
					resultado += line;
					
				}
				//MenuActivity.respJSON = new JSONObject(resultado);
//				String services = respJSON.getString("services");
//				Log.e("json",services);
//				
//				String scenarios = respJSON.getString("scenarios");
//				Log.e("json",scenarios);
//				
//				String diagnoses = respJSON.getString("diagnoses");
//				Log.e("json",diagnoses);
				try {
					MenuActivity.respJSON = new JSONObject(resultado);
//					respJSON = new JSONObject(resultado);
//					String services = respJSON.getString("services");
//					Log.e("json",services);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return null;
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		
	}

	

}
