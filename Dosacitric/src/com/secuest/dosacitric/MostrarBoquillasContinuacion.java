package com.secuest.dosacitric;

import java.util.ArrayList;

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
		ArrayList<String> datos = db.getDatosIntroMisBoquillas(modelo);
		referencia.setText(modelo);
		caudal.setText(datos.get(1));
		presion.setText(datos.get(0));

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

