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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class BoquillasListView extends AppCompatActivity{
	
	private String marca;
	private float[] inter;
	private String presion;

	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boquillaslistview_layout);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		
		// Get ListView object from xml
		listView = (ListView) findViewById(R.id.list);

		marca = (String) getIntent().getStringExtra("marca");
		inter = (float[]) getIntent().getSerializableExtra("inter");
		presion = (String) getIntent().getStringExtra("presion");

		DatabaseHandler db = new DatabaseHandler(
				getApplicationContext());
		//Cogemos los datos de BD
		ArrayList<String> boquillasZ1 = db.getBoquillas(marca,
				inter[0], inter[1], presion);
		System.out.println("BUSCANDO z1: "+marca+" "+presion+" entre_" +inter[0] +" y "+inter[1]);
		ArrayList<String> boquillasZ2 = db.getBoquillas(marca,
				inter[2], inter[3], presion);
		ArrayList<String> boquillasZ3 = db.getBoquillas(marca,
				inter[4], inter[5], presion);
		
		final ListViewItem[] items = new ListViewItem[3+boquillasZ1.size()+boquillasZ2.size()+boquillasZ3.size()];

		//Los anadimos a la listView
		int contador=0;
		items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<boquillasZ1.size();i++){
			items[++contador] = new ListViewItem(boquillasZ1.get(i), CustomAdapter.TYPE_EVEN);
		}
		items[++contador] = new ListViewItem("Zona Media ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<boquillasZ2.size();i++){
			items[++contador] = new ListViewItem(boquillasZ2.get(i), CustomAdapter.TYPE_EVEN);
		}
		items[++contador] = new ListViewItem("Zona Baja ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<boquillasZ3.size();i++){
			items[++contador] = new ListViewItem(boquillasZ3.get(i), CustomAdapter.TYPE_EVEN);
		}

		CustomAdapter customAdapter = new CustomAdapter(this, R.id.textsuperior, items);
		listView.setAdapter(customAdapter);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(BoquillasListView.this, C_1Activity.class));
				finish();
			}
		});
		
		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(BoquillasListView.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(BoquillasListView.this, AyudaBoquillasListView.class));
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
