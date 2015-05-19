package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
	
}
