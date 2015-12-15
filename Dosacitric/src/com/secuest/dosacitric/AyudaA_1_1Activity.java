package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaA_1_1Activity extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo7;
	private TextView cuerpo8;
	private TextView cuerpo9;
	private TextView cuerpo10;
	private TextView cuerpo11;
	private TextView cuerpo12;
	private TextView cuerpo13;
	private TextView cuerpo14;
	private TextView cuerpo15;
	private TextView cuerpo16;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudaa_1_1activity);

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
		cuerpo7 = (TextView) findViewById(R.id.cuerpo7);
		cuerpo8 = (TextView) findViewById(R.id.cuerpo8);
		cuerpo9 = (TextView) findViewById(R.id.cuerpo9);
		cuerpo10 = (TextView) findViewById(R.id.cuerpo10);
		cuerpo11 = (TextView) findViewById(R.id.cuerpo11);
		cuerpo12 = (TextView) findViewById(R.id.cuerpo12);
		cuerpo13 = (TextView) findViewById(R.id.cuerpo13);
		cuerpo14 = (TextView) findViewById(R.id.cuerpo14);
		cuerpo15 = (TextView) findViewById(R.id.cuerpo15);
		cuerpo16 = (TextView) findViewById(R.id.cuerpo16);
		
		String stringCuerpo1 = "En este punto se deben introducir los siguientes datos:";
		String stringCuerpo2 = "<font color=#ff6600>Densidad foliar:</font> Es un índice indicativo de la frondosidad de la vegetación y se define como el cociente entre la superficie foliar y el volumen de la copa del árbol. Es una variable independiente del tamaño del árbol, considerándose:";
		String stringCuerpo3 = "- Densidad foliar alta: valor superior a 4,5 m2/m3.";
		String stringCuerpo4 = "- Densidad foliar media: entre a 3,5 y a 4,5 m2/m3.";
		String stringCuerpo5 = "- Densidad foliar baja: valor inferior a 3,5 m2/m3.";
		String stringCuerpo6 = "<font color=#ff6600>Marco de plantación:</font>";
		String stringCuerpo7 = "<font color=#ff6600>x:</font> Corresponde al ancho de la calle. ";
		String stringCuerpo8 = "<font color=#ff6600>y:</font> Corresponde a la separación entre árboles de una misma fila.";
		String stringCuerpo9 = "<font color=#ff6600>Dimensiones de los árboles.</font> Corresponde a las dimensiones:";
		String stringCuerpo10 = "<font color=#ff6600>I:</font> Largo.";
		String stringCuerpo11 = "<font color=#ff6600>II:</font> Ancho.";
		String stringCuerpo12 = "<font color=#ff6600>III:</font> Alto.";
		String stringCuerpo13 = "<font color=#ff6600>Forma del árbol:</font> Se deberá elegir entre esférica (globo) y seto.";
		String stringCuerpo14 = "<font color=#ff6600>Poda:</font>";
		String stringCuerpo15 = "<font color=#ff6600>Fecha de última poda.</font> Se deberá elegir entre: menos de tres meses, de 3 meses a un año, de un año a dos años, y más de dos años.";
		String stringCuerpo16 = "<font color=#ff6600>Grado de la poda.</font> Se deberá elegir entre: bajo, medio, y alto.";
				
				
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo7.setText(Html.fromHtml(stringCuerpo7));
		cuerpo8.setText(Html.fromHtml(stringCuerpo8));
		cuerpo9.setText(Html.fromHtml(stringCuerpo9));
		cuerpo10.setText(Html.fromHtml(stringCuerpo10));
		cuerpo11.setText(Html.fromHtml(stringCuerpo11));
		cuerpo12.setText(Html.fromHtml(stringCuerpo12));
		cuerpo13.setText(Html.fromHtml(stringCuerpo13));
		cuerpo14.setText(Html.fromHtml(stringCuerpo14));
		cuerpo15.setText(Html.fromHtml(stringCuerpo15));
		cuerpo16.setText(Html.fromHtml(stringCuerpo16));
		
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
