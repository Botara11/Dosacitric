package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AyudaB_1Activity extends AppCompatActivity{
	
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudab_1activity);
		
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
		
		
		String stringCuerpo1 = "El <font color=#ff6600> Volumen de aplicación calculado </font> se corresponde con el valor obtenido por <font color=#ff6600> DOSACITRIC </font> para el volumen de aplicación."; 
		String stringCuerpo13 = "El <font color=#ff6600> Volumen de aplicación deseado </font> es el valor que va a utilizar <font color=#ff6600> DOSACITRIC </font> para hacer los cálculos. El usuario puede optar por introducir el valor calculado por <font color=#ff6600> DOSACITRIC </font> u otro valor.";
		String stringCuerpo2 = "El <font color=#ff6600> Ancho de trabajo calculado </font> se corresponde con el valor obtenido por <font color=#ff6600> DOSACITRIC </font> a partir de los datos introducidos previamente."; 
		String stringCuerpo14 = "El <font color=#ff6600> Ancho de trabajo deseado </font> es el valor que va a utilizar <font color=#ff6600> DOSACITRIC </font> para hacer los cálculos. Se corresponde con el ancho de la calle a tratar. El usuario puede optar por introducir el valor calculado por <font color=#ff6600> DOSACITRIC </font> u otro valor.";
		String stringCuerpo3 = "En esta casilla se debe indicar la velocidad de avance a la que se desea realizar el tratamiento en km/h. Dicho valor se ha acotado entre 1 y 6 km/h, considerando el tipo de cultivo y equipo a emplear para realizar el tratamiento.";
		String stringCuerpo4 = "Dentro de este apartado <font color=#ff6600> DOSACITRIC </font> nos mostrará:";
		String stringCuerpo5 = "- El<font color=#ff6600> caudal de líquido total</font> que debe aplicar el equipo en L/min, obtenido a partir de la fórmula:";
		String stringCuerpo6 = "donde:";
		String stringCuerpo7 = "Q = Caudal de caldo aplicado por el equipo en L/min";
		String stringCuerpo8 = "V = Volumen de aplicación, en litros de caldo a aplicar por hectárea";
		String stringCuerpo9 = "a = Ancho de trabajo del equipo en metros";
		String stringCuerpo10 = "v= Velocidad de avance del equipo en Km/h";
		String stringCuerpo11 = "- El<font color=#ff6600> caudal de líquido por sector</font> que debe aplicar el equipo en L/min.";
		String stringCuerpo12 = "- El<font color=#ff6600> número total de boquillas del equipo</font>. En este campo debe introducirse el número total de boquillas que pueden trabajar a la vez en el equipo.";
		
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
