package com.proyecto.kdaf;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class Search extends Activity {

	private SearchAsyn diagnoses;
	private ListView listDiagnosis;
	public static ArrayList<Diagnoses> listado = new ArrayList<Diagnoses>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		listDiagnosis = (ListView) findViewById(R.id.listViewDiag);
		diagnoses = new SearchAsyn(getApplicationContext(), listDiagnosis);
		diagnoses.execute();
			
		}


}
