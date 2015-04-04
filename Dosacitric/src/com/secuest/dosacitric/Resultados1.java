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

public class Resultados1 extends Activity{


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
		TextView productosAplicar = (TextView) findViewById(R.id.textView29);
		TextView formaActuacion = (TextView) findViewById(R.id.textView30);
		TextView utilizaMojantes = (TextView) findViewById(R.id.textView31);
		TextView zonaCriticaATratar = (TextView) findViewById(R.id.textView32);
		TextView temperatura = (TextView) findViewById(R.id.textView33);
		TextView humedadRelativa = (TextView) findViewById(R.id.textView34);
		TextView velocidadViento = (TextView) findViewById(R.id.textView35);
		TextView tipoPulverizador = (TextView) findViewById(R.id.textView36);
		TextView L_Ha = (TextView) findViewById(R.id.textView37);
		TextView L_Hg = (TextView) findViewById(R.id.textView38);
		

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

		Intent aR = getIntent();
		//Intent a1 = getIntent();
		//Intent a2 = getIntent();
		//Intent a1 = getIntent();
		//ParteA resultadosA1 = (ParteA) aR.getSerializableExtra("partea1");
		//ParteA resultadosA2 = (ParteA) aR.getSerializableExtra("partea2");
		ParteA resultadosA3 = (ParteA) aR.getSerializableExtra("partea3");
		
		densidadFoliar.setText(String.valueOf(resultadosA3.DensidadFoliar));
		xAncho.setText(String.valueOf(resultadosA3.AnchoCalle));
		yDistancia.setText(String.valueOf(resultadosA3.DistanciaArboles));
		volumenArbol.setText(String.valueOf(resultadosA3.FormaArbol)); //MAL
		formaArbol.setText(String.valueOf(resultadosA3.FormaArbol));
		fechaUltimaPoda.setText(String.valueOf(resultadosA3.FechaUltimaPoda));
		gradoPoda.setText(String.valueOf(resultadosA3.GradoPoda));
		productosAplicar.setText(String.valueOf(resultadosA3.ProductosAplicar));
		formaActuacion.setText(String.valueOf(resultadosA3.FormaActuacion));
		utilizaMojantes.setText(String.valueOf(resultadosA3.Mojantes));
		zonaCriticaATratar.setText(String.valueOf(resultadosA3.ZonaCriticaTratar));
		temperatura.setText(String.valueOf(resultadosA3.Temperatura));
		humedadRelativa.setText(String.valueOf(resultadosA3.Humedad));
		velocidadViento.setText(String.valueOf(resultadosA3.VelocidadViento));
		tipoPulverizador.setText(String.valueOf(resultadosA3.TipoPulverizador));
		L_Ha.setText(String.valueOf(resultadosA3.AnchoCalle));
		L_Hg.setText(String.valueOf(resultadosA3.DistanciaArboles));

		


		Log.e("didi", resultadosA3.DensidadFoliar+"");
		Log.e("didi", resultadosA3.FormaArbol+"");
		Log.e("didi", resultadosA3.AlturaMeseta+"");
		
		
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, B_1Activity.class));
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
				startActivity(new Intent(Resultados1.this, Indice.class));
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
