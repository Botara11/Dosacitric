package com.secuest.dosacitric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MostrarBoquillasContinuacion extends AppCompatActivity{

	private TextView referencia;
	private TextView caudal;
	private TextView presion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mostrar_boquillas_continuacion);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);	

		referencia = (TextView) findViewById(R.id.referenciaTextView);
		caudal = (TextView) findViewById(R.id.caudalTextView);
		presion = (TextView) findViewById(R.id.presionTextView);

		
		Intent c5 = getIntent();
		String modelo = c5.getStringExtra("modelo");
		DatabaseHandler db = new DatabaseHandler(this);
		String caudal_s = db.getCaudalAunaPresionDeBoquilla("MIS BOQUILLAS", modelo, 10);
		referencia.setText(modelo);
		caudal.setText(caudal_s);
		presion.setText("10");

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

