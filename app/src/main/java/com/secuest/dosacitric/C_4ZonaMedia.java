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

public class C_4ZonaMedia extends AppCompatActivity{
	
	private ListView listView;
	private ParteC partec5;
	private String boquillaZonaMedia= "";
	private String entero = "a";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);
		
		Intent c4 = getIntent();
		partec5 = (ParteC) c4.getSerializableExtra("modeloZonaAlta");
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
	
		DatabaseHandler db = new DatabaseHandler(this);

		final ArrayList<String> modelosZ2 = db.getModelo(partec5.MarcaSeleccionada,
				Integer.parseInt(partec5.PresionSeleccionada.replace(" bar", "")));
		
		CustomArrayList customArrayList = new CustomArrayList(this, modelosZ2);

		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(customArrayList);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				boquillaZonaMedia= modelosZ2.get(i);
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
						
						partec5.rellenarC5(boquillaZonaMedia);
						Intent c4Media = new Intent(C_4ZonaMedia.this, C_4ZonaBaja.class);
						c4Media.putExtra("modeloZonaMedia", partec5);
						startActivity(c4Media);
					}
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"SELECCIONA UNA BOQUILLA", Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_4ZonaMedia.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_4ZonaMedia.this, AyudaC_4ZonaMedia.class));
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
