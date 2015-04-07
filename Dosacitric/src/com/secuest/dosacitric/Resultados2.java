package com.secuest.dosacitric;

import java.text.DecimalFormat;

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

	private DecimalFormat df;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados2_1);
		
		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		TextView VolAplicacion = (TextView) findViewById(R.id.textView41);
		
		TextView VelAvance = (TextView) findViewById(R.id.textView39); 
		TextView AnchoTrabajo = (TextView) findViewById(R.id.textView40);
		TextView CaudalLiqTotal = (TextView) findViewById(R.id.textView42);
		TextView NumTotalBoq = (TextView) findViewById(R.id.textView27);
		TextView NumBoqPorSector = (TextView) findViewById(R.id.textView28);
		
		TextView BoqCerrAlta = (TextView) findViewById(R.id.textView29);
		TextView BoqCerrBaja = (TextView) findViewById(R.id.textView30);
		
		TextView BoqAbiAlta = (TextView) findViewById(R.id.textView31);
		TextView BoqAbiMedia = (TextView) findViewById(R.id.textView32);
		TextView BoqAbiBaja = (TextView) findViewById(R.id.textView33);
		
		TextView VegetaAlta = (TextView) findViewById(R.id.textView34);
		TextView VegetaMedia = (TextView) findViewById(R.id.textView35);
		TextView VegetaBaja = (TextView) findViewById(R.id.textView36);
		
		TextView CaudalLiqSector = (TextView) findViewById(R.id.textView412);
		TextView VarCaudalAdmisible = (TextView) findViewById(R.id.textView392);
		
		TextView CaudalLiqAlta = (TextView) findViewById(R.id.textView512);
		TextView CaudalLiqMedia = (TextView) findViewById(R.id.textView522);
		TextView CaudalLiqBaja = (TextView) findViewById(R.id.textView532);
		
		Intent bres = getIntent();
		ParteB resultados1 = (ParteB) bres.getSerializableExtra("parteb2");
		
		VolAplicacion.setText(String.valueOf(resultados1.VolumenApp));
		VelAvance.setText(String.valueOf(resultados1.VelocidadAvance));
		AnchoTrabajo.setText(String.valueOf(resultados1.AnchoTrabajo));
		CaudalLiqTotal.setText(String.valueOf(df.format(resultados1.CaudalLiquidoTotal)));
		NumTotalBoq.setText(String.valueOf(resultados1.NumeroTotalBoquillas));
		NumBoqPorSector.setText(String.valueOf(resultados1.NumeroBoquillasSector));
		
		BoqCerrAlta.setText(String.valueOf(resultados1.NumeroBoquillasCerradas[0]));
		BoqCerrBaja.setText(String.valueOf(resultados1.NumeroBoquillasCerradas[1]));
		
		BoqAbiAlta.setText(String.valueOf(resultados1.NumeroBoquillasAbiertas[0]));
		BoqAbiMedia.setText(String.valueOf(resultados1.NumeroBoquillasAbiertas[1]));
		BoqAbiBaja.setText(String.valueOf(resultados1.NumeroBoquillasAbiertas[2]));
		
		VegetaAlta.setText(String.valueOf(resultados1.PorcentajeVegetacion[0])+" %");
		VegetaMedia.setText(String.valueOf(resultados1.PorcentajeVegetacion[1])+" %");
		VegetaBaja.setText(String.valueOf(resultados1.PorcentajeVegetacion[2])+" %");
		
		CaudalLiqSector.setText(String.valueOf(df.format(resultados1.CaudalLiquidoSector)));
		VarCaudalAdmisible.setText(String.valueOf((int)resultados1.VariacionCaudalAdmisible*100)+" %");

		float[] inter = resultados1.IntervaloCaudalAdmisible;
		CaudalLiqAlta.setText(df.format(inter[0])+"-"+df.format(inter[1]));
		CaudalLiqMedia.setText(df.format(inter[2])+"-"+df.format(inter[3]));
		CaudalLiqBaja.setText(df.format(inter[4])+"-"+df.format(inter[5]));
		
		
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
