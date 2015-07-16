package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class C_3Activity extends ListActivity{
	
	private ParteC partec3;
	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_3);  

		String[] marcas = { "Teejet", "Albuz", "Hardi", "Discos",
		"Otras" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, marcas);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		
		String ola ="ParteC3";
		Log.e("didi", ola);
		
		Intent c2 = getIntent();
		partec3 = (ParteC) c2.getSerializableExtra("presion");
		partec3.rellenarC3(item);
		
		Intent c3 = new Intent(C_3Activity.this, C_4ZonaAlta.class);
		c3.putExtra("marcas", partec3);
		startActivity(c3);
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

	
}
