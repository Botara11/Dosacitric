package com.secuest.dosacitric;

import com.secuest.dosacitric.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaResultados2 extends AppCompatActivity{

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
	private TextView cuerpo23;
	private TextView cuerpo24;
	private TextView cuerpo25;
	private TextView cuerpo26;		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_resultados2);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
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
		cuerpo23 = (TextView) findViewById(R.id.cuerpo23);
		cuerpo24 = (TextView) findViewById(R.id.cuerpo24);
		cuerpo25 = (TextView) findViewById(R.id.cuerpo25);
		cuerpo26 = (TextView) findViewById(R.id.cuerpo26);

		String stringCuerpo1 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa los litros de caldo (agua + producto fitosanitario) que se desean aplicar por hectárea."; 
		String stringCuerpo2 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa la velocidad de avance del equipo en Km/h.";
		String stringCuerpo3 = "Este valor se corresponde con el valor introducido en <font color=#ff6600> DOSACITRIC </font> y representa el ancho de la calle a tratar en metros.";
		String stringCuerpo4 = "Este valor se ha obtenido aplicando la fórmula:";
		String stringCuerpo5 = "donde:";
		String stringCuerpo6 = "Q = Caudal de caldo aplicado por el equipo en L/min";
		String stringCuerpo7 = "V = Volumen de aplicación, en litros de caldo aplicar por hectárea.";
		String stringCuerpo8 = "a = ancho de trabajo en m.";
		String stringCuerpo9 = "v= velocidad de avance en Km/h";
		String stringCuerpo10 = "- Número total de boquillas: Representa el número total de boquillas que pueden trabajar a la vez en el equipo.";
		String stringCuerpo12 = "- Zona Alta: Representa el número boquillas que se van a cerrar en la zona alta del equipo. ";
		String stringCuerpo13 = "- Zona Baja: Representa el número boquillas que se van a cerrar en la zona baja del equipo. Dichos valor se obtendrá como suma de las boquillas que se vayan a cerrar en cada zona considerando todos los sectores existentes en el equipo (por ejemplo, derecho e izquierdo).";
		String stringCuerpo14 = "- Zona Alta (nA): Representa el número boquillas que van trabajar en la zona alta del equipo.";
		String stringCuerpo15 = "- Zona Media (nM): Representa el número boquillas que van a trabajar en la zona media del equipo.";
		String stringCuerpo16 = "- Zona Baja (nB): Representa el número boquillas que van a trabajar en la zona baja del equipo.";
		String stringCuerpo17 = "- Zona Alta (%A): Representa el porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona alta del equipo (nA).";
		String stringCuerpo18 = "- Zona Media (%M): Representa el porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona media del equipo (nM).";
		String stringCuerpo19 = "- Zona Baja (%B): Representa el porcentaje de vegetación a tratar por las boquillas abiertas situadas en la zona baja del equipo (nB).";
		String stringCuerpo23 = "Al presionar sobre el icono"; 
		String stringCuerpo25 = "se guardarán en un fichero PDF,";
		String stringCuerpo26 = "en su dispositivo, todos los datos recogidos en el apartado “CR. RESUMEN Y RESULTADOS II“";
		String stringCuerpo24 = "Representa el caudal total que debe suministrar el equipo para aplicar el volumen de aplicación indicado.";

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
		cuerpo23.setText(Html.fromHtml(stringCuerpo23));
		cuerpo24.setText(Html.fromHtml(stringCuerpo24));
		cuerpo25.setText(Html.fromHtml(stringCuerpo25));
		cuerpo26.setText(Html.fromHtml(stringCuerpo26));
		
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
