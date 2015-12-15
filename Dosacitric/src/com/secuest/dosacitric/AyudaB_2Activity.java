package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaB_2Activity extends AppCompatActivity{
	
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudab_2activity);
		
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
		
		String stringCuerpo1 = "En este apartado deben indicarse el número total de boquillas que deben cerrarse en la <font color=#ff6600>Zona Alta</font> del equipo y en la <font color=#ff6600>Zona Baja</font> del equipo. Dichos valores se obtendrán como suma de las boquillas que haya que cerrar en cada zona considerando todos los sectores existentes en el equipo (por ejemplo, derecho e izquierdo). ";
		String stringCuerpo2 = "Para determinar el número de boquillas que hay que cerrar conviene poner el equipo en marcha dentro de la calle para observar que boquillas no pulverizan sobre la zona a tratar. ";
		String stringCuerpo3 = "En este apartado deben indicarse el número total de boquillas que deben permanecer abiertas en la <font color=#ff6600>Zona Alta (nA), Media (nM) y Baja (nB)</font> del equipo. Para determinar dichos valores hay que considerar la forma del árbol y que las boquillas asignadas a cada zona deberán tratar la zona del cultivo establecida por nosotros en el apartado <font color=#ff6600>porcentaje de vegetación a pulverizar por zona</font>.";
		String stringCuerpo4 = "<font color=#ff6600> A% </font> = Porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona alta del equipo (nA).";
		String stringCuerpo5 = "<font color=#ff6600> M% </font> = Porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona media del equipo (nM).";
		String stringCuerpo6 = "<font color=#ff6600> B% </font> = Porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona baja del equipo (nB).";
		String stringCuerpo7 = "A la hora de introducir los datos hay que considerar que la suma de los tres porcentajes (A%, M% y B%) debe ser obligatoriamente 100%.";
		String stringCuerpo8 = "Utilizando el botón desplazable, se deberá indicar la variación máxima de caudal admisible a la hora de hacer el tratamiento. Hay que tener en cuenta que:";
		String stringCuerpo9 = "- Una variación en el caudal implica una variación en igual porcentaje en el volumen de aplicación.";
		String stringCuerpo10 = "- A mayor variación de caudal mayor será el número de boquillas que se podrán emplear para realizar el tratamiento. ";
		String stringCuerpo11 = "<font color=#ff6600> DOSACITRIC </font> permite seleccionar una variación de caudal máxima del 10%.";
		String stringCuerpo12 = "En este apartado <font color=#ff6600> DOSACITRIC </font> muestra el intervalo de caudales elegido por el usuario de cara a seleccionar las boquillas a colocar en cada zona del equipo y su presión de trabajo.";
		
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
