package com.secuest.dosacitric;

import java.util.ArrayList;

import android.R.string;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class C_4bbActivity extends ListActivity implements OnClickListener{

	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_1);  

		// Get ListView object from xml
		//listView = (ListView) findViewById(android.R.id.list);
		
		//ListView lv = (ListView) findViewById(android.R.id.list);

		Intent c3 = getIntent();
		final ParteC partec4 = (ParteC) c3.getSerializableExtra("marcas");
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		ArrayList<String> modelosZ1 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String> modelosZ2 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String>  modelosZ3 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		
		
		String[] lv_arr = new String[modelosZ1.size()];
		lv_arr = modelosZ1.toArray(lv_arr);
		setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,
                android.R.id.text1, lv_arr));
		String[] lv_arr1 = new String[modelosZ2.size()];
		lv_arr = modelosZ2.toArray(lv_arr1);
		setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,
                android.R.id.text1, lv_arr1));
		ListView listView = getListView();
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		final ListViewItem[] items = new ListViewItem[3+modelosZ1.size()+modelosZ2.size()+modelosZ3.size()];
		
		setListAdapter(getListAdapter());
		
		//Los anadimos a la listView
				int contador=0;
				items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ1.size();i++){
					items[++contador] = new ListViewItem(modelosZ1.get(i), CustomAdapter.TYPE_EVEN);
				}
				items[++contador] = new ListViewItem("Zona Media ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ2.size();i++){
					items[++contador] = new ListViewItem(modelosZ2.get(i), CustomAdapter.TYPE_EVEN);
				}
				items[++contador] = new ListViewItem("Zona Baja ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ3.size();i++){
					items[++contador] = new ListViewItem(modelosZ3.get(i), CustomAdapter.TYPE_EVEN);
				}

				CustomAdapter customAdapter = new CustomAdapter(this, R.id.textsuperior, items);
				//listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				//lv.setAdapter(customAdapter);
		
			
				Button siguiente = (Button) findViewById(R.id.siguiente);
				siguiente.setClickable(true);
				siguiente.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
			
						//partec4.rellenarC4(item);

						Intent c4 = new Intent(C_4bbActivity.this, Resultados3.class);
						c4.putExtra("modelos", partec4);
						startActivity(c4);
					}		
				});

		}

	@Override
	public void onClick(View v) {
	
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


