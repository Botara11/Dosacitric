package com.secuest.dosacitric;

import com.secuest.dosacitric.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaIndice extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo7;
	//private TextView cuerpo7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_indice);

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
		cuerpo6 = (TextView) findViewById(R.id.cuerpo66);
		cuerpo7 = (TextView) findViewById(R.id.cuerpo6);

		String stringCuerpo1 = "Al presionar sobre el título IDENTIFICACIÓN DEL TRATAMIENTO se accederá al módulo de <font color=#ff6600> DOSACITRIC </font> que permite identificar el tratamiento que se va a realizar, en concreto, en este punto se indicará la fecha, los datos de identificación de la parcela y del tratamiento, y la referencia. Ésta última es un código a introducir por el usuario de la aplicación que permitirá identificar fácilmente el tratamiento a realizar y formará parte del nombre del fichero de resultados que genera <font color=#ff6600> DOSACITRIC</font>."; 
		String stringCuerpo2 = "Al presionar sobre el título VOLUMEN DE APLICACIÓN (L/ha) se accederá al módulo de <font color=#ff6600> DOSACITRIC </font> que permite estimar el Volumen de aplicación necesario para realizar el tratamiento en función de las características del cultivo, el tipo de tratamiento, las condiciones meteorológicas y el equipo empleado.";
		String stringCuerpo3 = "Al presionar sobre el título SELECCIÓN DE BOQUILLAS se accederá al módulo de <font color=#ff6600> DOSACITRIC </font> que permite determinar la presión de trabajo y la marca y modelo de boquillas a emplear en cada una de las zonas y sectores del equipo, en función del volumen de aplicación calculado en el módulo anterior o definido directamente en ese momento.";
		String stringCuerpo4 = "Al presionar sobre el título VOLUMEN DE CALDO APLICADO (L/ha) se accederá al módulo de <font color=#ff6600> DOSACITRIC </font> que permite determinar el volumen de caldo aplicado, en función de las características del tratamiento (presión, velocidad, ancho de trabajo, boquillas instaladas en cada zona y sector del equipo).";
		String stringCuerpo5 = "Presionando sobre el icono";
		String stringCuerpo6 = "se accederá a una pantalla";
		String stringCuerpo7 = "donde se podrán dar de alta, eliminar y visualizar las boquillas propias del usuario.";

		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo7.setText(Html.fromHtml(stringCuerpo7));

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

