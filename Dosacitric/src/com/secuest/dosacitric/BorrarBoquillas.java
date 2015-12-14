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

public class BorrarBoquillas extends ListActivity implements
OnClickListener{
	Button siguiente;
	ListView listView;
	ArrayAdapter<String> adapter;
	ListViewItem[] items;
	String Selected; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.boquillaslistview_borrar);
		setContentView(R.layout.boquillaslistview_borrar);
		Selected = "";
		listView = (ListView) findViewById(android.R.id.list);

		Button borrar = (Button) findViewById(R.id.siguiente);
		borrar.setClickable(true);
		borrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Selected.compareTo("")!=0){
					System.out.println(Selected);
					DatabaseHandler db = new DatabaseHandler(getApplicationContext());
					db.deleteFromMisBoqui(Selected);
					startActivity(new Intent(BorrarBoquillas.this, BorrarBoquillas.class));
					finish();
				}
				
			}
		});

		DatabaseHandler db = new DatabaseHandler(this);

		ArrayList<String> boq = db.getBoquillas("MIS BOQUILLAS", 0.0, 100.0, "p6");
		String[] lv_arr = new String[boq.size()];
		lv_arr = boq.toArray(lv_arr);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice, lv_arr);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setAdapter(adapter);
		
	}
	

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);

		SparseBooleanArray checked = listView.getCheckedItemPositions();
		ArrayList<String> selectedItems = new ArrayList<String>();
		
		Selected = adapter.getItem(position);
		System.out.println(position+" "+adapter.getItem(position));
		for (int i = 0; i < checked.size(); i++) {
			// Item position in adapter
			position = checked.keyAt(i);
			// Add sport if it is checked i.e.) == TRUE!
			if (checked.valueAt(i))
				selectedItems.add(adapter.getItem(position));
			//item = (String) getListAdapter().getItem(position);
			
		}

		
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inf)late the menu; this adds items to the action bar if it is present.
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
