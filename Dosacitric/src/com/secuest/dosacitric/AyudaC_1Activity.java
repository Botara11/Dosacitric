package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaC_1Activity extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudac_1activity);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		cuerpo6 = (TextView) findViewById(R.id.cuerpo6);
		cuerpo9 = (TextView) findViewById(R.id.cuerpo9);


		String stringCuerpo1 = "El <font color=#ff6600> Ancho de la calle calculado </font> se corresponde con el valor obtenido por <font color=#ff6600>DOSACITRIC</font> a partir de los datos introducidos previamente.";
		String stringCuerpo9 = "El <font color=#ff6600> Ancho de la calle deseado </font> es el valor que va a utilizar <font color=#ff6600>DOSACITRIC</font> para hacer los cálculos. Se corresponde con el ancho de la calle a tratar. El usuario puede optar por introducir el valor calculado por <font color=#ff6600>DOSACITRIC</font> u otro valor.";
		String stringCuerpo2 = "En este apartado deben indicarse el número total de boquillas que hay abiertas en la <font color=#ff6600> Zona Alta (nA), Media (nM) y Baja (nB)</font> del equipo.";
		String stringCuerpo3 = "En esta casilla se debe indicar <font color=#ff6600> la velocidad de avance </font> a la que se desea realizar el tratamiento en Km/h. ";
		String stringCuerpo4 = "En este punto debe seleccionarse la presión a la que se desea realizar el tratamiento, pulsando sobre el valor elegido <font color=#ff6600> (6 bar, 7 bar, …, 16 bar)</font>.";
		String stringCuerpo5 = "En este punto debe seleccionarse el fabricante de las boquillas que se van a  utilizar en el tratamiento, pulsando sobre el valor elegido <font color=#ff6600>(Teejet, Albuz, …, Mis boquillas)</font>.";
		String stringCuerpo6 = "En este punto debe seleccionarse el modelo de boquilla utilizada en el pulverizador en la <font color=#ff6600>Zona Alta</font>, <font color=#ff6600>Zona Media</font> y <font color=#ff6600>Zona Baja</font>.";


		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo9.setText(Html.fromHtml(stringCuerpo9));

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
