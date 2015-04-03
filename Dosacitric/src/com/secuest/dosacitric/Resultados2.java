package com.secuest.dosacitric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resultados2 extends Activity{


	private TextView densidadFoliar;
	private TextView gradoPoda;
	private ParteA parteA;
	private String hola;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados1);
		/**** A1 ****/
		
		
		TextView densidadFoliar = (TextView) findViewById(R.id.textView23);
		TextView xAncho = (TextView) findViewById(R.id.textView41);
		TextView yDistancia = (TextView) findViewById(R.id.textView39);
		TextView volumenArbol = (TextView) findViewById(R.id.textView25);
		TextView formaArbol = (TextView) findViewById(R.id.textView26);
		TextView fechaUltimaPoda = (TextView) findViewById(R.id.textView27);
		TextView gradoPoda = (TextView) findViewById(R.id.textView28);
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
		alturaArb.setText(StringAlturaArb);//si
		alturaMeseta.setText(StringAlturaMeseta);*/

		Intent ar = getIntent();
		//Intent a1 = getIntent();

		//ParteA resultados2 = (ParteA) a1.getSerializableExtra("parteaa");
		ParteA resultados1 = (ParteA) ar.getSerializableExtra("parteaa");
		
		densidadFoliar.setText(String.valueOf(resultados1.DensidadFoliar));
		xAncho.setText(String.valueOf(resultados1.AnchoCalle));
		yDistancia.setText(String.valueOf(resultados1.DistanciaArboles));
		volumenArbol.setText(String.valueOf(resultados1.FormaArbol)); //MAL
		formaArbol.setText(String.valueOf(resultados1.FormaArbol));
		fechaUltimaPoda.setText(String.valueOf(resultados1.FechaUltimaPoda));
		gradoPoda.setText(String.valueOf(resultados1.GradoPoda));



		Log.e("didi", resultados1.DensidadFoliar+"");
		Log.e("didi", resultados1.FormaArbol+"");
		Log.e("didi", resultados1.AlturaMeseta+"");
		
		
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados2.this, B_2Activity.class));
			}
		});
		
			

		Button atras = (Button) findViewById(R.id.atras);
		atras.setClickable(true);
		atras.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				//startActivity(new Intent(a_1_2Activity.this, a_1_1Activity.class));
				finish();

			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(Resultados2.this, Indice.class));
			}
		});


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
