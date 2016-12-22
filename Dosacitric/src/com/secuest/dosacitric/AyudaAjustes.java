package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaAjustes extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_ajustes);

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

		String stringCuerpo1 = "En el apartado de ajustes se podrá generar una base de datos de las boquillas propias que quiera emplear el usuario en la aplicación <font color=#ff6600>DOSACITRIC</font>."; 
		String stringCuerpo2 = "En este apartado se introducirán los datos de las boquillas propias.";
		String stringCuerpo3 = "- Referencia: Marca, modelo y color de la boquilla.";
		String stringCuerpo4 = "- Caudal: Representa el caudal proporcionado por esa boquilla en L/min a una presión de trabajo conocida.";
		String stringCuerpo5 = "- Presión: Representa la presión en bar a la que debe trabajar la boquilla para obtenerse el caudal indicado en el punto anterior.";
		String stringCuerpo6 = "En este apartado se podrá eliminar una boquilla incluida anteriormente en la base de datos de boquillas elaborada por el propio usuario.";
		String stringCuerpo7 = "En este apartado se podrá visualizar la referencia de las boquillas que forman parte de la base de datos elaborada por el propio usuario.";

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
