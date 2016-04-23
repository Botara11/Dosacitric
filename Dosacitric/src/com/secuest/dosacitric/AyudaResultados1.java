package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaResultados1 extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_resultados1);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);

		String stringCuerpo1 = "Se muestra un resumen de la información introducida en los puntos 0, 1, 2 y 3, y se indicará el <font color=#ff6600> volumen de aplicación </font> recomendado en esas condiciones de trabajo.";
		String stringCuerpo2 = "Al presionar sobre este icono";
		String stringCuerpo3 = "se guardan los datos de “RESUMEN Y RESULTADOS I” en la aplicación “Descargas” del propio dispositivo utilizado (Tablet o Smartphone).";
		
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
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

