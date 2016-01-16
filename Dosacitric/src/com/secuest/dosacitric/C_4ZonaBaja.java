package com.secuest.dosacitric;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class C_4ZonaBaja extends AppCompatActivity  {
	Button siguiente;
	ListView listView;
	ArrayAdapter<String> adapter;
	ListViewItem[] items;

	private ParteC partec6;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		findViewsById();

		Intent c5 = getIntent();
		partec6 = (ParteC) c5.getSerializableExtra("modeloZonaMedia");

		DatabaseHandler db = new DatabaseHandler(this);

		ArrayList<String> modelosZ2 = db.getModelo(partec6.MarcaSeleccionada,
				Integer.parseInt(partec6.PresionSeleccionada.replace(" bar", "")));

		items = new ListViewItem[3+modelosZ2.size()];

		int contador=0;
		items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<modelosZ2.size();i++){
			items[++contador] = new ListViewItem(modelosZ2.get(i), CustomAdapter.TYPE_EVEN);
		}

		String[] lv_arr = new String[modelosZ2.size()];
		lv_arr = modelosZ2.toArray(lv_arr);
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_item_con_arrow, lv_arr);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setAdapter(adapter);
		

	}

	private void findViewsById() {
		listView = (ListView) findViewById(android.R.id.list);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				SparseBooleanArray checked = listView.getCheckedItemPositions();
				ArrayList<String> selectedItems3 = new ArrayList<String>();
				//String item = "";
				for (int i = 0; i < checked.size(); i++) {
					// Item position in adapter
					position = checked.keyAt(i);
					// Add sport if it is checked i.e.) == TRUE!
					if (checked.valueAt(i))
						selectedItems3.add(adapter.getItem(position));

				}

				Intent c5 = getIntent();
				partec6 = (ParteC) c5.getSerializableExtra("modeloZonaMedia");
				partec6.rellenarC6(selectedItems3);

				Intent c6 = new Intent(C_4ZonaBaja.this, Resultados3.class);
				c6.putExtra("modeloZonaBaja", partec6);
				startActivity(c6);
				
			}
		});
	}

	class milista extends ListFragment{

		public milista(Context context) {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onListItemClick(ListView list, View view, int position, long id) {
			super.onListItemClick(list, view, position, id);

			SparseBooleanArray checked = listView.getCheckedItemPositions();
			ArrayList<String> selectedItems3 = new ArrayList<String>();
			//String item = "";
			for (int i = 0; i < checked.size(); i++) {
				// Item position in adapter
				position = checked.keyAt(i);
				// Add sport if it is checked i.e.) == TRUE!
				if (checked.valueAt(i))
					selectedItems3.add(adapter.getItem(position));

			}

			Intent c5 = getIntent();
			partec6 = (ParteC) c5.getSerializableExtra("modeloZonaMedia");
			partec6.rellenarC6(selectedItems3);

			//Intent c6 = new Intent(this, Resultados3.class);
			//c6.putExtra("modeloZonaBaja", partec6);
			//startActivity(c6);
		}
	}
	
	

	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
