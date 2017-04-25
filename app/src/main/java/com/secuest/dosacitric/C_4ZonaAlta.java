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

public class C_4ZonaAlta extends AppCompatActivity {

	private ListView listView;
	private ParteC partec4;
	private String boquillaZonaAlta= "";
	private String entero = "a";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);
		
		Intent c3 = getIntent();
		partec4 = (ParteC) c3.getSerializableExtra("partec3");

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);		

		DatabaseHandler db = new DatabaseHandler(this);

		final ArrayList<String> modelosZ1 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bar", "")));

		CustomArrayList customArrayList = new CustomArrayList(this, modelosZ1);

		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(customArrayList);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				boquillaZonaAlta= modelosZ1.get(i);
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
						
						partec4.rellenarC4(boquillaZonaAlta);
						Intent c4Alta = new Intent(C_4ZonaAlta.this, C_4ZonaMedia.class);
						c4Alta.putExtra("modeloZonaAlta", partec4);
						startActivity(c4Alta);
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
				startActivity(new Intent(C_4ZonaAlta.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_4ZonaAlta.this, AyudaC_4ZonaAlta.class));
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
