package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class AyudaA_1Activity extends ActionBarActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudaa_1activity);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		
		String stringCuerpo1 = " En este punto se deben introducir los siguientes datos:";
		String stringCuerpo2 = "- <font color=#E65F00>Fecha:</font> Fecha del tratamiento en formato libre.";
		String stringCuerpo3 = "- <font color=#E65F00>Identificación de la parcela:</font> Término municipal, polígono y parcela o cualquier otro sistema de identificación de la parcela.";
		String stringCuerpo4 = "- <font color=#E65F00>Identificación del tratamiento:</font> Descripción del tratamiento a realizar.";
		String stringCuerpo5 = "- <font color=#E65F00>Referencia:</font> Código de identificación del tratamiento en formato libre.";

		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));

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
