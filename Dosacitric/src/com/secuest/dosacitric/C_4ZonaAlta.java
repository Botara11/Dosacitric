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

public class C_4ZonaAlta extends ListActivity implements
OnClickListener {
	Button siguiente;
	ListView listView;
	ArrayAdapter<String> adapter;
	ListViewItem[] items;

	private ParteC partec4;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);

		findViewsById();

		Intent c3 = getIntent();
		ParteC partec4 = (ParteC) c3.getSerializableExtra("marcas");

		DatabaseHandler db = new DatabaseHandler(this);

		ArrayList<String> modelosZ1 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bar", "")));

		items = new ListViewItem[3+modelosZ1.size()];

		int contador=0;
		items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
		for(int i=0;i<modelosZ1.size();i++){
			items[++contador] = new ListViewItem(modelosZ1.get(i), CustomAdapter.TYPE_EVEN);
		}

		String[] lv_arr = new String[modelosZ1.size()];
		lv_arr = modelosZ1.toArray(lv_arr);
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
		ArrayList<String> selectedItems = new ArrayList<String>();
		//String item = "";
		for (int i = 0; i < checked.size(); i++) {
			// Item position in adapter
			position = checked.keyAt(i);
			// Add sport if it is checked i.e.) == TRUE!
			if (checked.valueAt(i))
				selectedItems.add(adapter.getItem(position));
			//item = (String) getListAdapter().getItem(position);

		}

		Intent c3 = getIntent();
		partec4 = (ParteC) c3.getSerializableExtra("marcas");
		partec4.rellenarC4(selectedItems);

		Intent c4 = new Intent(this, C_4ZonaMedia.class);
		c4.putExtra("modeloZonaAlta", partec4);
		startActivity(c4);
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
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {

	}

}
