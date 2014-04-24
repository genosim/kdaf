package com.proyecto.kdaf;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class MyArrayDiagnoses extends ArrayAdapter<Diagnoses> {

	
	private final Context context;
    private final ArrayList<Diagnoses> values;
    
    public MyArrayDiagnoses(Context context, ArrayList<Diagnoses> values) {
    	// constructor
        super(context, R.layout.row_search, values);
        this.context = context;
        this.values = values;
	}


    public View getView(final int position, View convertView, ViewGroup parent) 
    {
        // obtenemos el layout
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        //rowlist --> cada una de las lineas de la lista
        
        View rowView = inflater.inflate(R.layout.row_search, parent, false);
        TextView tvservice = (TextView) rowView.findViewById(R.id.service);
        TextView tvscenario = (TextView) rowView.findViewById(R.id.scenario);
        TextView tvstarted = (TextView) rowView.findViewById(R.id.started_date);
        TextView tvfinished = (TextView) rowView.findViewById(R.id.finished_date);
        
       
		
        // fijamos los valores de texto
        tvservice.setText(values.get(position).getService_code());
        tvscenario.setText(values.get(position).getScenario_description());
        tvstarted.setText(values.get(position).getStarted_at());
        tvfinished.setText(values.get(position).getFinished_at());
    
        
        
        
        
        return rowView;
    }


}
