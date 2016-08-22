package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AyudaResultados3 extends AppCompatActivity{

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
	private TextView cuerpo12;
	private TextView cuerpo13;
	private TextView cuerpo14;
	private TextView cuerpo15;
	private TextView cuerpo16;
	private TextView cuerpo17;
	private TextView cuerpo18;
	private TextView cuerpo19;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_resultados3);
		
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
		cuerpo12 = (TextView) findViewById(R.id.cuerpo12);
		cuerpo13 = (TextView) findViewById(R.id.cuerpo13);
		cuerpo14 = (TextView) findViewById(R.id.cuerpo14);
		cuerpo15 = (TextView) findViewById(R.id.cuerpo15);
		cuerpo16 = (TextView) findViewById(R.id.cuerpo16);
		cuerpo17 = (TextView) findViewById(R.id.cuerpo17);
		cuerpo18 = (TextView) findViewById(R.id.cuerpo18);
		cuerpo19 = (TextView) findViewById(R.id.cuerpo19);
		
		String stringCuerpo1 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa el ancho de la calle a tratar en metros."; 
		String stringCuerpo2 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa la velocidad de avance del equipo en Km/h.";
		String stringCuerpo3 = "- Zona Alta (nA): Representa el número boquillas que van trabajar en la zona alta del equipo.";
		String stringCuerpo4 = "- Zona Media (nM): Representa el número boquillas que van a trabajar en la zona media del equipo.";
		String stringCuerpo5 = "- Zona Baja (nB): Representa el número boquillas que van a trabajar en la zona baja del equipo.";
		String stringCuerpo6 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa la presión (bar) a la que se va a hacer el tratamiento.";
		String stringCuerpo7 = "- Zona Alta: Representa el modelo de boquilla instalado en la zona alta del equipo (Fabricante. Modelo).";
		String stringCuerpo8 = "- Zona Media: Representa el modelo de boquilla instalado en la zona media del equipo (Fabricante. Modelo). Quitar corchetes y añadir el fabricante delante.";
		String stringCuerpo9 = "- Zona Baja: Representa el modelo de boquilla instalado en la zona baja del equipo (Fabricante. Modelo).";
		String stringCuerpo10 = "Representa el caudal aplicado por el equipo  en L/min, obtenido a partir de los datos introducidos en DOSACITRIC.";
		String stringCuerpo12 = "donde:";
		String stringCuerpo13 = "Q = Caudal de caldo aplicado por el equipo en L/min.";
		String stringCuerpo14 = "V = Volumen de aplicación, en litros de caldo aplicar por hectárea.";
		String stringCuerpo15 = "a = ancho de trabajo en m.";
		String stringCuerpo16 = "v= velocidad de avance en Km/h.";
		String stringCuerpo17 = "Este valor se ha calculado por <font color=#ff6600> DOSACITRIC </font> y representa los litros de caldo (agua + producto fitosanitario) que se han aplicado por hectárea.";
		String stringCuerpo18 = "Al presionar sobre este icono se guardan los datos de RESUMEN Y RESULTADOS III en la aplicación Descargas del propio dispositivo utilizado (Tablet o Smartphone).";
		String stringCuerpo19 = "Al presionar sobre este botón se borrarán todos los datos introducidos, en la aplicación. Recuerde que si desea guardar los datos deberá presionar el icono:";
		
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
		cuerpo12.setText(Html.fromHtml(stringCuerpo12));
		cuerpo13.setText(Html.fromHtml(stringCuerpo13));
		cuerpo14.setText(Html.fromHtml(stringCuerpo14));
		cuerpo15.setText(Html.fromHtml(stringCuerpo15));
		cuerpo16.setText(Html.fromHtml(stringCuerpo16));
		cuerpo17.setText(Html.fromHtml(stringCuerpo17));
		cuerpo18.setText(Html.fromHtml(stringCuerpo18));
		cuerpo19.setText(Html.fromHtml(stringCuerpo19));
		
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
