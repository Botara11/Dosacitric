package com.secuest.dosacitric;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MostrarBoquillasContinuacion extends ActionBarActivity{

	private TextView referencia;
	private TextView caudal;
	private TextView presion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mostrar_boquillas_continuacion);


		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);	

		referencia = (TextView) findViewById(R.id.referenciaTextView);
		caudal = (TextView) findViewById(R.id.caudalTextView);
		presion = (TextView) findViewById(R.id.presionTextView);

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		String stringReferencia = settings.getString("ireferncia", "");
		String stringCaudal = settings.getString("caudal", "");
		String stringPresion = settings.getString("presion", "");

		referencia.setText(String.valueOf(stringReferencia));
		caudal.setText(String.valueOf(stringCaudal));
		presion.setText(String.valueOf(stringPresion));

	}

	@Override
	protected void onResume(){
		super.onResume();
	}


	@Override
	protected void onPause(){
		super.onPause(); 
	}


	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

