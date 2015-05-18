package com.secuest.dosacitric;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultados3 extends Activity {
	
	
	private DecimalFormat df;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados3);
		
		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		TextView VolAplicacion = (TextView) findViewById(R.id.textView41);
		TextView VelAvance = (TextView) findViewById(R.id.textView39);
		
		Intent cres = getIntent();
		ParteC resultados3 = (ParteC) cres.getSerializableExtra("parteb2");
		
		//VolAplicacion.setText(String.valueOf(resultados3.VolumenApp));
		//VelAvance.setText(String.valueOf(resultados3.VelocidadAvance));
		//AnchoTrabajo.setText(String.valueOf(resultados3.AnchoTrabajo));
		
		
		DatabaseHandler db = new DatabaseHandler(this);
		//db.getCaudalAunaPresionDeBoquilla(marca, modelo, presion)
	}

}
