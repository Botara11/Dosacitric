package com.secuest.dosacitric;

import java.text.DecimalFormat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class B_2Activity extends AppCompatActivity{

	private int debug = 0;
	private EditText zonaAltaCerradas;
	private EditText zonaBajaCerradas;
	private EditText zonaAltaAbiertas;
	private EditText zonaMediaAbiertas;
	private EditText zonaBajaAbiertas;
	private EditText zonaAltaPorcentaje;
	private EditText zonaMediaPorcentaje;
	private EditText zonaBajaPorcentaje;
	private TextView zonaAltaIntervaloCaudal;
	private TextView zonaMediaIntervaloCaudal;
	private TextView zonaBajaIntervaloCaudal;
	private TextView variacionCaudalTextView;
	private SeekBar variacionCaudalSeekbar;
	private ParteB parteb2;
	private DecimalFormat df;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_2);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		Intent b2 = getIntent();
		parteb2 = (ParteB) b2.getSerializableExtra("parteb1");

		zonaAltaCerradas = (EditText) findViewById(R.id.zonaAltaCerradas);
		zonaBajaCerradas = (EditText) findViewById(R.id.zonaBajaCerradas);

		zonaAltaAbiertas = (EditText) findViewById(R.id.zonaAltaAbiertas);
		zonaMediaAbiertas = (EditText) findViewById(R.id.zonaMediaAbiertas);
		zonaBajaAbiertas = (EditText) findViewById(R.id.zonaBajaAbiertas);

		zonaAltaPorcentaje = (EditText) findViewById(R.id.zonaAltaPorcentaje);
		zonaMediaPorcentaje = (EditText) findViewById(R.id.zonaMediaPorcentanje);
		zonaBajaPorcentaje = (EditText) findViewById(R.id.zonaBajaPorcentaje);

		zonaAltaIntervaloCaudal = (TextView) findViewById(R.id.zonaAltaIntervaloCaudal);
		zonaMediaIntervaloCaudal = (TextView) findViewById(R.id.zonaMediaIntervaloCaudal);
		zonaBajaIntervaloCaudal = (TextView) findViewById(R.id.zonaBajaIntervaloCaudal);

		variacionCaudalTextView = (TextView) findViewById(R.id.variacionCaudalTextView);
		variacionCaudalSeekbar = (SeekBar) findViewById(R.id.variacionCaudalSeekBar);
		variacionCaudalTextView.setText("3");
		variacionCaudalSeekbar.setProgress(3);

		seebbarr();

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String quien = "";
				String opt = "";
				try{
					quien="zonaAltaCerradas";
					int zAltaCerr = Integer.parseInt(zonaAltaCerradas.getText().toString());
					quien="zonaBajaCerradas";
					int zBajaCerr = Integer.parseInt(zonaBajaCerradas.getText().toString());

					int [] zCerr = {zAltaCerr,zBajaCerr};

					quien="zonaAltaAbiertas";
					int zAltaAb = Integer.parseInt(zonaAltaAbiertas.getText().toString());
					quien="zonaMediaAbiertas";
					int zMediaAb = Integer.parseInt(zonaMediaAbiertas.getText().toString());
					quien="zonaBajaAbiertas";
					int zBajaAb = Integer.parseInt(zonaBajaAbiertas.getText().toString());

					int aux = parteb2.getNumTotBoq() - zBajaCerr - zAltaCerr;

					if (aux != (zAltaAb + zMediaAb + zBajaAb)){
						quien = "Boquillas";
						opt = " Comprobar Boquillas Totales - Cerra = Abiertas";
						Float.parseFloat("h");
					}

					int [] zAbi = {zAltaAb,zMediaAb,zBajaAb}; 

					quien="zonaAltaPorcentaje";
					float zonaAltaPor = Float.parseFloat(zonaAltaPorcentaje.getText().toString());
					quien="zonaMediaPorcentaje";
					float zonaMediaPor = Float.parseFloat(zonaMediaPorcentaje.getText().toString());
					quien="zonaBajaPorcentaje";
					float zonaBajaPor = Float.parseFloat(zonaBajaPorcentaje.getText().toString());

					float [] zPorcentaje = {zonaAltaPor,zonaMediaPor,zonaBajaPor};

					if ((zonaAltaPor + zonaMediaPor + zonaBajaPor) != 100){
						quien = "Porcentaje";
						opt = "Comprobar que la suma de porcentajes es igual a 100%";
						Float.parseFloat("h");
					}

					quien="variacionCaudal";
					float variacionCaud = Float.parseFloat(variacionCaudalTextView.getText().toString());

					parteb2.rellenarB2(zCerr, zAbi, zPorcentaje, variacionCaud);
					parteb2.calcularParteB();

					Intent b2 = new Intent(B_2Activity.this, Resultados2.class);
					b2.putExtra("parteb2",parteb2);
					startActivity(b2);

				}catch(Exception e){
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(), "Valor de "+'"'+quien+'"'+" incorrecto. "+opt, Toast.LENGTH_SHORT);
					toast.show();
				}

			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(B_2Activity.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(B_2Activity.this, AyudaB_2Activity.class));
			}
		});

		/********************** TEST **********************/
		if(debug == 1){
			zonaAltaCerradas.setText("0");
			zonaBajaCerradas.setText("0");

			zonaAltaAbiertas.setText("6");
			zonaMediaAbiertas.setText("10");
			zonaBajaAbiertas.setText("8");

			zonaAltaPorcentaje.setText("30");
			zonaMediaPorcentaje.setText("50");
			zonaBajaPorcentaje.setText("20");


			variacionCaudalTextView.setText("3");
			variacionCaudalSeekbar.setProgress(3);

			calcularB();
		}
		/********************** TEST **********************/

	}

	private void calcularB() {
		try{
			@SuppressWarnings("unused")
			String quien ="";
			quien="zonaAltaCerradas";
			int zAltaCerr = Integer.parseInt(zonaAltaCerradas.getText().toString());
			quien="zonaBajaCerradas";
			int zBajaCerr = Integer.parseInt(zonaBajaCerradas.getText().toString());

			int [] zCerr = {zAltaCerr,zBajaCerr};

			quien="zonaAltaAbiertas";
			int zAltaAb = Integer.parseInt(zonaAltaAbiertas.getText().toString());
			quien="zonaMediaAbiertas";
			int zMediaAb = Integer.parseInt(zonaMediaAbiertas.getText().toString());
			quien="zonaBajaAbiertas";
			int zBajaAb = Integer.parseInt(zonaBajaAbiertas.getText().toString());

			int aux = parteb2.getNumTotBoq() - zBajaCerr - zAltaCerr;

			if (aux != (zAltaAb + zMediaAb + zBajaAb)){
				quien = "Boquillas";
				Float.parseFloat("h");
			}

			int [] zAbi = {zAltaAb,zMediaAb,zBajaAb}; 

			quien="zonaAltaPorcentaje";
			float zonaAltaPor = Float.parseFloat(zonaAltaPorcentaje.getText().toString());
			quien="zonaMediaPorcentaje";
			float zonaMediaPor = Float.parseFloat(zonaMediaPorcentaje.getText().toString());
			quien="zonaBajaPorcentaje";
			float zonaBajaPor = Float.parseFloat(zonaBajaPorcentaje.getText().toString());
			float [] zPorcentaje = {zonaAltaPor,zonaMediaPor,zonaBajaPor};

			quien="variacionCaudal";
			float variacionCaud = Float.parseFloat(variacionCaudalTextView.getText().toString());
			parteb2.rellenarB2(zCerr, zAbi, zPorcentaje, variacionCaud);

			parteb2.calcularParteB();

			float[] inter = parteb2.IntervaloCaudalAdmisible;
			
			zonaAltaIntervaloCaudal.setText(df.format(inter[0])+"-"+df.format(inter[1]));
			zonaMediaIntervaloCaudal.setText(df.format(inter[2])+"-"+df.format(inter[3]));
			zonaBajaIntervaloCaudal.setText(df.format(inter[4])+"-"+df.format(inter[5]));

		}catch(Exception e){
			e.printStackTrace();
			Log.e("DIDI", 
					e+"");
		}

	}

	public void seebbarr( ){

		variacionCaudalSeekbar = (SeekBar) findViewById(R.id.variacionCaudalSeekBar);
		//variacionCaudalTextView = (TextView) findViewById(R.id.variacionCaudalTextView);
		variacionCaudalSeekbar.setProgress(0);
		variacionCaudalSeekbar.incrementProgressBy(1);
		variacionCaudalSeekbar.setMax(10);
		variacionCaudalTextView.setFocusable(true);
		variacionCaudalTextView.setFocusableInTouchMode(true);

		variacionCaudalSeekbar.setOnSeekBarChangeListener(
				new SeekBar.OnSeekBarChangeListener() {

					@SuppressWarnings("unused")
					int progress_value;
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						progress_value = progress;
						variacionCaudalTextView.setText("" + progress);
						calcularB();
						variacionCaudalTextView.requestFocus();
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				}
				);

	}

	@Override
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		zonaAltaCerradas.setText(settings.getString("zonaAltaCerradas", ""));
		zonaBajaCerradas.setText(settings.getString("zonaBajaCerradas", ""));
		zonaAltaAbiertas.setText(settings.getString("zonaAltaAbiertas", ""));
		zonaMediaAbiertas.setText(settings.getString("zonaMediaAbiertas", ""));
		zonaBajaAbiertas.setText(settings.getString("zonaBajaAbiertas", ""));
		zonaAltaPorcentaje.setText(settings.getString("zonaAltaPorcentaje", ""));
		zonaMediaPorcentaje.setText(settings.getString("zonaMediaPorcentaje", ""));
		zonaBajaPorcentaje.setText(settings.getString("zonaBajaPorcentaje", ""));
		variacionCaudalTextView.setText(settings.getString("variacionCaudalTextView", ""));

	}


	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("zonaAltaCerradas", zonaAltaCerradas.getText().toString());
		editor.putString("zonaBajaCerradas", zonaBajaCerradas.getText().toString());
		editor.putString("zonaAltaAbiertas", zonaAltaAbiertas.getText().toString());
		editor.putString("zonaMediaAbiertas", zonaMediaAbiertas.getText().toString());
		editor.putString("zonaBajaAbiertas", zonaBajaAbiertas.getText().toString());
		editor.putString("zonaAltaPorcentaje", zonaAltaPorcentaje.getText().toString());
		editor.putString("zonaMediaPorcentaje", zonaMediaPorcentaje.getText().toString());
		editor.putString("zonaBajaPorcentaje", zonaBajaPorcentaje.getText().toString());
		editor.putString("variacionCaudalTextView", variacionCaudalTextView.getText().toString());

		editor.commit();

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


}

