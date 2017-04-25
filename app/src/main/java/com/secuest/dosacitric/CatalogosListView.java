package com.secuest.dosacitric;

import java.util.ArrayList;

import com.secuest.dosacitric.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class CatalogosListView extends AppCompatActivity{

	private ListView listView;
	private float[] inter;
	private String marcasPasar= "";
	private String entero = "a";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogoslistview_layout);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		@SuppressWarnings("unchecked")
		final ArrayList<String> marcas = (ArrayList<String>) getIntent().getSerializableExtra("marcas");

		inter = (float[]) getIntent().getSerializableExtra("inter");

		CustomArrayList customArrayList = new CustomArrayList(this, marcas);
		
		// Get ListView object from xml
		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(customArrayList);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				
				marcasPasar= marcas.get(i);
				entero = "1";
			}
		});

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {

					int foo = Integer.parseInt(entero.trim());
					if (foo == 1){

						Intent res = new Intent(CatalogosListView.this, PresionesListView.class);
						res.putExtra("marca", marcasPasar);
						res.putExtra("inter", inter);
						startActivity(res);
					}
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"SELECCIONA UNA MARCA", Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CatalogosListView.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CatalogosListView.this, AyudaCatalogosListView.class));
			}
		});
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