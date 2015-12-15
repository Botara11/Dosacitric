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
	private TextView cuerpo7;
	private TextView cuerpo8;

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
		cuerpo7 = (TextView) findViewById(R.id.cuerpo7);
		cuerpo8 = (TextView) findViewById(R.id.cuerpo8);
		
		String stringCuerpo1 = "Este valor se corresponde con el ancho de trabajo obtenido por <font color=#ff6600>DOSACITRIC</font> a partir de los datos introducidos previamente. Si se desea mantener este valor como dato, llevar el botón desplazable a la posición “SI”. Si se desea introducir un valor diferente de ancho de trabajo, llevar el botón desplazable a la opción “NO” e introducir el <font color=#ff6600> ancho de la calle deseado</font> en la casilla inferior. Cabe indicar que el ancho trabajo, en cualquier caso, debe ser el ancho de la calle a tratar."; 
		String stringCuerpo2 = "En este apartado deben indicarse el número total de boquillas que hay abiertas en la <font color=#ff6600> Zona Alta (nA), Media (nM) y Baja (nB)</font> del equipo.";
		String stringCuerpo3 = "Este valor se corresponde con el valor obtenido por  <font color=#ff6600>DOSACITRIC</font> a partir de los datos introducidos previamente. Si se desea mantener este valor como dato, llevar el botón desplazable a la posición “SI”. Si se desea introducir un valor diferente de velocidad de avance, llevar el botón desplazable a la opción “NO” e introducir <font color=#ff6600> la velocidad de avance deseada </font> en la casilla inferior.";
		String stringCuerpo4 = "En este punto debe seleccionarse la presión a la que se desea realizar el tratamiento, pulsando sobre el valor elegido <font color=#ff6600> (6 bar, 7 bar, …, 16 bar)</font>.";
		String stringCuerpo5 = "En este punto debe seleccionarse el fabricante de las boquillas que se van a  utilizar en el tratamiento, pulsando sobre el valor elegido <font color=#ff6600>(Teejet, Albuz, …, Otras)</font>.";
		String stringCuerpo6 = "En este punto debe seleccionarse el modelo de boquilla utilizada en el pulverizador en la zona alta.";
		String stringCuerpo7 = "En este punto debe seleccionarse el modelo de boquilla utilizada en el pulverizador en la zona media.";
		String stringCuerpo8 = "En este punto debe seleccionarse el modelo de boquilla utilizada en el pulverizador en la zona baja.";
		
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo7.setText(Html.fromHtml(stringCuerpo7));
		cuerpo8.setText(Html.fromHtml(stringCuerpo8));
		
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
