package com.proyecto.kdaf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SearchAsyn extends AsyncTask<Void, Void, Void> {

//	public ArrayList<Diagnoses> listado = new ArrayList<Diagnoses>();
	private Context context;
	private ListView listview;

	public SearchAsyn(Context cont, ListView listv){
		super();
		context = cont;
		listview = listv;
	}
	

	@Override
	protected Void doInBackground(Void... params) {
		
		BufferedReader reader;
		Date fecha_ini, fecha_fin;
		try {
			
			
			URL webURL = new URL("http://81.45.23.75:8000/diagnoses/expanded/");
			HttpURLConnection http = (HttpURLConnection)webURL.openConnection();
			http.setRequestMethod("GET");
			
			String basicAuth = "Basic " + new String(Base64.encode("admin:admin".getBytes(),Base64.NO_WRAP ));
			http.setRequestProperty ("Authorization", basicAuth);
			http.setRequestProperty("Accept", "application/json");
			
			
			
			http.connect();
			if(http.getResponseCode() != http.HTTP_OK)
				Log.e("errorDIAGNOSES", "error");
			else{
				InputStream is = (InputStream) http.getContent();
				reader = new BufferedReader(new InputStreamReader(is));
				
				String line = null;
				String resultado = new String();
				while ((line = reader.readLine()) != null){
					Log.e("diagnoses", line + "\n");
					resultado += line;
					
				}

				try {
					JSONObject respJSON = new JSONObject(resultado);
					
					JSONArray jArray = respJSON.getJSONArray("results");

					System.out.println("*****JARRAY*****"+jArray.length());
					for(int i=0;i<jArray.length();i++){

						

						 JSONObject json_data = jArray.getJSONObject(i);
						 Diagnoses myDiagnoses = new Diagnoses();
						 myDiagnoses.setId(json_data.getString("id"));
						 myDiagnoses.setUrl(json_data.getString("url"));
						 myDiagnoses.setScenario_id(json_data.getString("scenario_id"));
						 myDiagnoses.setScenario_url(json_data.getString("scenario_url"));
						 myDiagnoses.setService_url(json_data.getString("service_url"));
						 
						 JSONObject scenarioDict = new JSONObject(json_data.getString("scenario"));
						 myDiagnoses.setScenario_description(scenarioDict.getString("description"));
						 
						 JSONObject serviceDict = new JSONObject(json_data.getString("service"));
						 myDiagnoses.setService_description(serviceDict.getString("description"));
						 myDiagnoses.setService_code(json_data.getString("service_code"));
						 
						 fecha_ini = new Date();
						 try {
							 fecha_ini = toDate(json_data.getString("started_at"));
						 } catch (ParseException e) {
							// TODO Auto-generated catch block
						   	 e.printStackTrace();
						 }
						 
						 //Log.e("fecha",fecha.toString());
						 
						 myDiagnoses.setStarted_at(fecha_ini.toString());

						 fecha_fin = new Date();
						 try {
							 fecha_fin = toDate(json_data.getString("finished_at"));
						 } catch (ParseException e) {
							// TODO Auto-generated catch block
						   	 e.printStackTrace();
						 }
						 
						 //Log.e("fecha",fecha.toString());
						 
 
						 myDiagnoses.setFinished_at(fecha_fin.toString());
						 myDiagnoses.setStatus(json_data.getString("status"));
						 
						 JSONArray hypothesesArray = json_data.getJSONArray("hypotheses");
						 
						 for(int j=0;j < hypothesesArray.length();j++)
		                    {
		                        JSONObject hypothesesObj = hypothesesArray.getJSONObject(j);

		                        Hypotheses hypotheses = new Hypotheses();
		                        hypotheses.setPercentage(hypothesesObj.getString("percentage"));
		                        hypotheses.setId(hypothesesObj.getString("id"));
		                        hypotheses.setType(hypothesesObj.getString("type"));
		                        hypotheses.setValue(hypothesesObj.getString("value"));
		                        hypotheses.setProbability(hypothesesObj.getString("probability"));
		    
		                        myDiagnoses.anadirHypotheses(hypotheses);

		                    }
						 
						 Search.listado.add(myDiagnoses);
						 
						 Log.e("DIAGNOSES", "id  "+json_data.getString("id")+
						  ", url  "+json_data.getString("url")+
						  ", scenario_id  "+json_data.getString("scenario_id")+
						  ", scenario_url  "+json_data.getString("scenario_url")+
						  ", service_url  "+json_data.getString("service_url")+
						  ", service_code  "+json_data.getString("service_code")+
						  ", started_at  "+json_data.getString("started_at")+
						  ", finished_at  "+json_data.getString("finished_at")+
						  ", status  "+json_data.getString("status")
						 );

					}
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/** Transform ISO 8601 string to Date. */
    public Date toDate(String iso8601string)
            throws ParseException {
        
        String s = iso8601string.replace("Z", "+00:00");
        try {
            s = s.substring(0, 22) + s.substring(23);
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid length", 0);
        }
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
        
        return date;
    }
    
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		MyArrayDiagnoses adapter = new MyArrayDiagnoses(context, Search.listado);
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(context,"ha pulsado la opcion "+arg2, Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(context, DetailDiagnosis.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("posicion", arg2);
				
				context.startActivity(intent);
			}
		});
		
	}


}
