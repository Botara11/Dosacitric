package com.secuest.dosacitric;

import com.secuest.dosacitric.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaCatalogosListView extends AppCompatActivity{

	private TextView cuerpo1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_catalogoslistview);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);

		String stringCuerpo1 = "Muestra los fabricante de boquillas que disponen de menos un modelo que cumpla con los requisitos establecidos en el tratamiento. Para conocer el modelo concreto debe seleccionarse el fabricante <font color=#ff6600>(Hardi, Teejet, Albuz, …)</font>. Si no aparece ningún fabricante, esto indica que no hay ninguna boquilla que cumpla con los requisitos establecidos. La opción <font color=#ff6600>“Otras”</font> incluye los modelos de boquillas introducidos manualmente por el propio usuario.";
	
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));

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
