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

public class PresionesListView extends AppCompatActivity{

	private ListView listView ;
	private float[] inter;
	private String marca;
	private ArrayList<String> presionesAdecu;
	private String presionesPasar= "";
	private String entero = "a";	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presioneslistview_layout);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);		

		marca = (String) getIntent().getSerializableExtra("marca");
		inter = (float[]) getIntent().getSerializableExtra("inter");
		
		final String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
				"p12", "p13", "p14", "p15", "p16" };

		//Lista que va a contener las marcas y dentro de cada una las presiones que correspondan
		presionesAdecu = new ArrayList<String>();

		DatabaseHandler db = new DatabaseHandler(getApplicationContext());

		for (String pres : presiones) {
			ArrayList<String> boquillasZ1 = db.getBoquillas(marca,
					inter[0], inter[1], pres);
			ArrayList<String> boquillasZ2 = db.getBoquillas(marca,
					inter[2], inter[3], pres);
			ArrayList<String> boquillasZ3 = db.getBoquillas(marca,
					inter[4], inter[5], pres);
			if (boquillasZ1 != null && boquillasZ2 != null
					&& boquillasZ3 != null) {
				if (boquillasZ1.size() > 0
						&& boquillasZ2.size() > 0
						&& boquillasZ3.size() > 0) {
					/* Se muestran
					System.out.println("z1=" + boquillasZ1.size()
					+ " z2=" + boquillasZ2.size() + " z3="
					+ boquillasZ3.size() + "pres:" + pres + " marca:" + marca);										
					
					System.out.println("ANTES z1: "+marca+" "
					+pres+" entre_" +inter[0] +" y "+inter[1]);
					
					System.out.println("MARCAS MOSTRADAS: "+marca+" ");*/
		
					presionesAdecu.add(pres.substring(1)+" bar");
				}
			}
		}

		CustomArrayList customArrayList = new CustomArrayList(this, presionesAdecu);

		// Get ListView object from xml
		listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(customArrayList);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				presionesPasar= presionesAdecu.get(i).replace(" bar", "");
				presionesPasar="p"+presionesPasar;
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

						Intent res = new Intent(PresionesListView.this, BoquillasListView.class);
						res.putExtra("presion", presionesPasar);
						res.putExtra("marca", marca);
						res.putExtra("inter", inter);
						startActivity(res);
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
				startActivity(new Intent(PresionesListView.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(PresionesListView.this, AyudaPresionesListView.class));
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
