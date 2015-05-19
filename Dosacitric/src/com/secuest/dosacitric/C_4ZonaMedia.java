package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class C_4ZonaMedia extends ListActivity implements
OnClickListener {
	Button siguiente;
	ListView listView;
	ArrayAdapter<String> adapter;
	ListViewItem[] items;
	
	private ParteC partec5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);

		findViewsById();

		Intent c4 = getIntent();
		partec5 = (ParteC) c4.getSerializableExtra("modeloZonaAlta");
		
		//Log.e("didi",partec5.MarcaSeleccionada);
		
		//Bundle b = getIntent().getExtras();

		DatabaseHandler db = new DatabaseHandler(this);

		ArrayList<String> modelosZ2 = db.getModelo(partec5.MarcaSeleccionada,
				Integer.parseInt(partec5.PresionSeleccionada.replace(" bares", "")));

		items = new ListViewItem[3+modelosZ2.size()];

		int contador=0;
		items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<modelosZ2.size();i++){
			items[++contador] = new ListViewItem(modelosZ2.get(i), CustomAdapter.TYPE_EVEN);
		}

		String[] lv_arr = new String[modelosZ2.size()];
		lv_arr = modelosZ2.toArray(lv_arr);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice, lv_arr);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setAdapter(adapter);

		siguiente.setOnClickListener(this);
	}

	private void findViewsById() {
		listView = (ListView) findViewById(android.R.id.list);
		siguiente = (Button) findViewById(R.id.siguiente);
	}

	public void onClick(View v) {
		SparseBooleanArray checked = listView.getCheckedItemPositions();
		ArrayList<String> selectedItems2 = new ArrayList<String>();
		//String item = "";
		for (int i = 0; i < checked.size(); i++) {
			// Item position in adapter
			int position = checked.keyAt(i);
			// Add sport if it is checked i.e.) == TRUE!
			if (checked.valueAt(i))
				selectedItems2.add(adapter.getItem(position));
			//item = (String) getListAdapter().getItem(position);

		}


		String[] outputStrArr = new String[selectedItems2.size()];

		for (int i = 0; i < selectedItems2.size(); i++) {
			outputStrArr[i] = selectedItems2.get(i);
		}

		/*Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent c3 = getIntent();
				ParteC partec4 = (ParteC) c3.getSerializableExtra("marcas");

				partec4.rellenarC4("hola");

				Intent c4 = new Intent(C_4ZonaAlta.this, Resultados3.class);
				c4.putExtra("modelos", partec4);
				startActivity(c4);
			}		
		});*/
		
		Intent c4 = getIntent();
		partec5 = (ParteC) c4.getSerializableExtra("modeloZonaAlta");
		partec5.rellenarC5(selectedItems2);
		
		Log.e("didi",selectedItems2.get(0));
		
		Intent c5 = new Intent(this, C_4ZonaBaja.class);
		c5.putExtra("modeloZonaMedia", partec5);
		startActivity(c5);

		/*Intent zonaMedia = new Intent(getApplicationContext(),
				Resultados3.class);

		// Create a bundle object
		Bundle b = new Bundle();
		b.putStringArray("selectedItems", outputStrArr);

		Log.e("didi",selectedItems.get(0));

		// Add the bundle to the intent.
		zonaMedia.putExtras(b);

		// start the ResultActivity
		startActivity(zonaMedia));*/
	}

}
