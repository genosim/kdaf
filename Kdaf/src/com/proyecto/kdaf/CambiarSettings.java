package com.proyecto.kdaf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CambiarSettings extends Activity {
	
	public static final String ARCHIVO_PREFS = "myPrefs";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_settings);
		
		// creamos un editor para poder acceder a las shared preferences
        SharedPreferences settings = getSharedPreferences(ARCHIVO_PREFS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = settings.edit();
        
        
        final EditText user = (EditText)findViewById(R.id.modificarUser);
        final EditText pass = (EditText)findViewById(R.id.modificarPass);
               	
		Button modificar = (Button)findViewById(R.id.modificar);
		modificar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("user", user.getText().toString());
				Log.e("pass", pass.getText().toString());
				
				
				if ((user.getText().toString().matches("")) || (pass.getText().toString().matches("")))
					Toast.makeText(getApplicationContext(),"You did not enter a username or password", Toast.LENGTH_SHORT).show();
				else{
					
						editor.putString("username", user.getText().toString());
		                editor.putString("password", pass.getText().toString());
		                // guarda los cambios
		                editor.commit();
		               
						
		                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);		                
						startActivity(intent);
						finish();
					
				}
				
				
			}
			
		});
		
	}
	


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intent = new Intent(getApplicationContext(),MenuActivity.class);		                
		startActivity(intent);
		//finish();
	}
	
	
}
