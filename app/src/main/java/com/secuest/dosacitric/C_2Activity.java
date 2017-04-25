package com.secuest.dosacitric;

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

public class C_2Activity extends AppCompatActivity {

	private ListView listView;
	private ParteC partec2;
	private String presionesFinal = "";
	private String entero = "a";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_2);		

		Intent c1 = getIntent();
		partec2 = (ParteC) c1.getSerializableExtra("partec1");

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		final String[] presiones = { "6 bar", "7 bar", "8 bar", "9 bar",
				"10 bar", "11 bar", "12 bar", "13 bar", "14 bar",
				"15 bar", "16 bar" };

		CustomList customList = new CustomList(this, presiones);

		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(customList);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				presionesFinal = presiones[i];
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

						partec2.rellenarC2(presionesFinal);
						Intent c2 = new Intent(C_2Activity.this, C_3Activity.class);
						c2.putExtra("partec2", partec2);
						startActivity(c2);
					}
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"SELECCIONA UNA PRESIÓN", Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_2Activity.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_2Activity.this, AyudaC_2Activity.class));
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