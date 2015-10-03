package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
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

	}

	private void findViewsById() {
		listView = (ListView) findViewById(android.R.id.list);
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);

		SparseBooleanArray checked = listView.getCheckedItemPositions();
		ArrayList<String> selectedItems2 = new ArrayList<String>();
		//String item = "";
		for (int i = 0; i < checked.size(); i++) {
			// Item position in adapter
			position = checked.keyAt(i);
			// Add sport if it is checked i.e.) == TRUE!
			if (checked.valueAt(i))
				selectedItems2.add(adapter.getItem(position));
			//item = (String) getListAdapter().getItem(position);

		}

		Intent c4 = getIntent();
		partec5 = (ParteC) c4.getSerializableExtra("modeloZonaAlta");
		partec5.rellenarC5(selectedItems2);

		Intent c5 = new Intent(this, C_4ZonaBaja.class);
		c5.putExtra("modeloZonaMedia", partec5);
		startActivity(c5);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {

	}

}
