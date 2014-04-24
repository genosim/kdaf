package com.proyecto.kdaf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableRow;
import android.widget.TextView;

public class DetailDiagnosis extends Activity {

	private int posicion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			posicion = extras.getInt("posicion");
		
			Log.e("posicion", Integer.toString(posicion));
			
		}
		
		Diagnoses diagnoses = Search.listado.get(posicion);
		Log.e("DIAGNOSES", "id  "+diagnoses.getId()+
				  ", url  "+diagnoses.getUrl()+
				  ", scenario_id  "+diagnoses.getScenario_id()+
				  ", scenario_url  "+diagnoses.getScenario_url()+
				  ", service_url  "+diagnoses.getService_url()+
				  ", service_code  "+diagnoses.getService_code()+
				  ", started_at  "+diagnoses.getStarted_at()+
				  ", finished_at  "+diagnoses.getFinished_at()+
				  ", status  "+diagnoses.getStatus()
				 );
		
		
		TextView service = (TextView) findViewById(R.id.serviceDet);
		TextView scenario = (TextView) findViewById(R.id.scenarioDet);
		TextView started = (TextView) findViewById(R.id.startedDet);
		TextView finished = (TextView) findViewById(R.id.finishedDet);
		
		service.setText(diagnoses.getService_code());
		scenario.setText(diagnoses.getScenario_description());
		started.setText(diagnoses.getStarted_at());
		finished.setText(diagnoses.getFinished_at());
		
		
		TextView hyp1 = (TextView) findViewById(R.id.hyp1);
		TextView hyp2 = (TextView) findViewById(R.id.hyp2);
		TextView hyp3 = (TextView) findViewById(R.id.hyp3);
		TextView hyp4 = (TextView) findViewById(R.id.hyp4);
		
		TextView prob1 = (TextView) findViewById(R.id.prob1);
		TextView prob2 = (TextView) findViewById(R.id.prob2);
		TextView prob3 = (TextView) findViewById(R.id.prob3);
		TextView prob4 = (TextView) findViewById(R.id.prob4);
		
		
		hyp1.setText(diagnoses.getHypotheses().get(0).getType());
		prob1.setText(diagnoses.getHypotheses().get(0).getPercentage());
		
		hyp2.setText(diagnoses.getHypotheses().get(1).getType());
		prob2.setText(diagnoses.getHypotheses().get(1).getPercentage());
		
		hyp3.setText(diagnoses.getHypotheses().get(2).getType());
		prob3.setText(diagnoses.getHypotheses().get(2).getPercentage());
		
		hyp4.setText(diagnoses.getHypotheses().get(3).getType());
		prob4.setText(diagnoses.getHypotheses().get(3).getPercentage());

		
	}
}
