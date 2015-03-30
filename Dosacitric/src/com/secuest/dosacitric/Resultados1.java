package com.secuest.dosacitric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Resultados1 extends Activity{
	
	private ParteA parteA;
	private String hola;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parteb2);
		/**** A1 ****/
		/*TextView anchocalle = (TextView) findViewById(R.id.anchocalle);	        
		TextView distancia = (TextView)findViewById(R.id.distancia);
		TextView longitudArb = (TextView)findViewById(R.id.longitudArb);
		TextView anchuraArb = (TextView)findViewById(R.id.anchuraArb);
		TextView alturaArb = (TextView) findViewById(R.id.alturaArb);

		TextView alturaMeseta = (TextView) findViewById(R.id.alturaMeseta);*/

		//Intent i = getIntent();
		// Receiving the Data
		/*String StringAnchocalle = i.getStringExtra("anchocalle");
		String StringDistancia = i.getStringExtra("distancia");
		String StringLongitudArb = i.getStringExtra("longitudArb");
		String StringAnchuraArb = i.getStringExtra("anchuraArb");
		String StringAlturaArb = i.getStringExtra("alturaArb");
		String StringAlturaMeseta = i.getStringExtra("alturaMeseta");
		Log.e("Resultados 1", StringAnchocalle + "." + StringDistancia 
				+ "." + StringLongitudArb + "." + StringAnchuraArb
				+ "." + StringAlturaArb+ "." + StringAlturaMeseta);

		// Displaying Received data
		anchocalle.setText(StringAnchocalle);
		distancia.setText(StringDistancia);
		longitudArb.setText(StringLongitudArb);
		anchuraArb.setText(StringAnchuraArb);
		alturaArb.setText(StringAlturaArb);
		alturaMeseta.setText(StringAlturaMeseta);*/
		
		Intent i = getIntent();
		
		ParteA parteA = (ParteA) i.getSerializableExtra("partea");
		
		Log.e("Resultados 1", "hola");
		
	

	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}



	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
