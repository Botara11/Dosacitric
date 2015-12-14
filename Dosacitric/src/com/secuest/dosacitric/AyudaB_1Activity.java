package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class AyudaB_1Activity extends ActionBarActivity{
	
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
		setContentView(R.layout.ayudab_1activity);
		
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
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
		
		String stringCuerpo1 = "Este valor se corresponde con el valor obtenido por <font color=#E65F00> DOSACITRIC </font> para el volumen de aplicación. Si se desea mantener este valor como dato, llevar el botón desplazable a la posición “SI”. Si se desea introducir un valor diferente de volumen de aplicación (litros de caldo aplicar por hectárea), llevar el botón desplazable a la opción “NO” e introducir el <font color=#E65F00> volumen de aplicación deseado </font> en la casilla inferior.";
		String stringCuerpo2 = "Este valor se corresponde con el valor obtenido por <font color=#E65F00> DOSACITRIC </font> a partir de los datos introducidos previamente. Si se desea mantener este valor como dato, llevar el botón desplazable a la posición “SI”. Si se desea introducir un valor diferente de ancho de trabajo, llevar el botón desplazable a la opción “NO” e introducir el <font color=#E65F00> ancho de trabajo deseado </font> en la casilla inferior. Cabe indicar que el ancho trabajo, en cualquier caso, debe ser el ancho de la calle a tratar.";
		String stringCuerpo3 = "En esta casilla se debe indicar la velocidad de avance a la que se desea realizar el tratamiento en km/h. Dicho valor se ha acotado entre 1 y 6 km/h, considerando el tipo de cultivo y equipo a emplear para realizar el tratamiento. Para seleccionar la velocidad, desplazar el botón azul hacia la derecha o hacia la izquierda hasta obtener la velocidad de avance deseada.";
		String stringCuerpo4 = "Dentro de este apartado <font color=#E65F00> DOSACITRIC </font> nos mostrará:";
		String stringCuerpo5 = "- El<font color=#E65F00> caudal de líquido total</font> que debe aplicar el equipo en L/min, obtenido a partir de la fórmula:";
		String stringCuerpo6 = "donde:";
		String stringCuerpo7 = "Q = Caudal de caldo aplicado por el equipo en L/min";
		String stringCuerpo8 = "V = Volumen de aplicación, en litros de caldo aplicar por hectárea.";
		String stringCuerpo9 = "a = ancho de trabajo en m.";
		String stringCuerpo10 = "v= velocidad de avance en Km/h";
		String stringCuerpo11 = "- El<font color=#E65F00> caudal de líquido por sector</font> que debe aplicar el equipo en L/min.";
		String stringCuerpo12 = "- El<font color=#E65F00> número total de boquillas del equipo</font>. En este campo debe introducirse el número total de boquillas que pueden trabajar a la vez en el equipo.";
		
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
