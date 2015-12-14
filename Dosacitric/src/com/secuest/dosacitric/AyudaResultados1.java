package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class AyudaResultados1 extends ActionBarActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_resultados1);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);

		String stringCuerpo1 = "Aquí se mostrará un resumen de la información introducida en el puntos 0, 1, 2 y 3, y se indicará el <font color=#E65F00> volumen de aplición </font> recomendado en esas condiciones de trabajo.";
		String stringCuerpo2 = "Al presionar sobre este icono se guardan los datos de “RESUMEN Y RESULTADOS I” en la aplicación “Descargas” del propio dispositivo utilizado (Tablet o Smartphone).";

		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));

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
