package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class C_4bActivity extends ListActivity implements OnClickListener{

	Button button;
	ListView listView;
	ArrayAdapter<String> adapter1;
	ArrayAdapter<String> adapter2;
	ArrayAdapter<String> adapter3;
	private ParteC partec4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4b);  
		
		Intent c3 = getIntent();
		ParteC partec4 = (ParteC) c3.getSerializableExtra("marcas");
				
		// Get ListView object from xml
		//listView = (ListView) findViewById(android.R.id.list);
		
		findViewsById();
		DatabaseHandler db = new DatabaseHandler(this);		
		
		ArrayList<String> modelosZ1 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String> modelosZ2 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String>  modelosZ3 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, modelosZ1);
		adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, modelosZ2);
		adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, modelosZ3);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter1);
        //listView.setAdapter(adapter2);
        //listView.setAdapter(adapter3);
        
        //button.setOnClickListener(this);
		
		//final ListViewItem[] items = new ListViewItem[1+modelosZ1.size()];//+modelosZ2.size()+modelosZ3.size()];
		
		//Los anadimos a la listView
				/*int contador=0;
				items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ1.size();i++){
					items[++contador] = new ListViewItem(modelosZ1.get(i), CustomAdapter.TYPE_EVEN);
				}
				/*items[++contador] = new ListViewItem("Zona Media ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ2.size();i++){
					items[++contador] = new ListViewItem(modelosZ2.get(i), CustomAdapter.TYPE_EVEN);
				}
				items[++contador] = new ListViewItem("Zona Baja ", CustomAdapter.TYPE_ODD);
				for(int i=0;i<modelosZ3.size();i++){
					items[++contador] = new ListViewItem(modelosZ3.get(i), CustomAdapter.TYPE_EVEN);
				}*/

				//CustomAdapter customAdapter = new CustomAdapter(this, R.id.textsuperior, items);
				//listView.setAdapter(customAdapter);
		
			
        		//Button siguiente = (Button) findViewById(R.id.siguiente);
				//siguiente.setClickable(true);
				//siguiente.setOnClickListener(this); 
					/*@Override
					public void onClick(View v) {
			
						//partec4.rellenarC4(item);

						Intent c4 = new Intent(C_4bActivity.this, Resultados3.class);
						c4.putExtra("modelos", partec4);
						startActivity(c4);
					}		
				});*/

		}
	
	
	private void findViewsById() {
		listView = (ListView) findViewById(android.R.id.list);
        //button = (Button) findViewById(R.id.testbutton);
	}

	@Override
	public void onClick(View v) {
		SparseBooleanArray checked = listView.getCheckedItemPositions();
        ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i)){
                selectedItems.add(adapter1.getItem(position));
                //selectedItems.add(adapter2.getItem(position));
                //selectedItems.add(adapter3.getItem(position));
            }
		
    }
        String[] outputStrArr = new String[selectedItems.size()];
        
        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }
                
        Intent intent = new Intent(getApplicationContext(),
        		Resultados3.class);
        
        /*partec4.rellenarC4(selectedItems);
        
        Intent c4 = new Intent(C_4bActivity.this, Resultados3.class);
		c4.putExtra("modelos", partec4);
		startActivity(c4);*/
        
        //String ola = c3.PresionSeleccionada;
		//Log.e("didi", ola);
 
        // Create a bundle object
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", outputStrArr);
 
        // Add the bundle to the intent.
        intent.putExtras(b);
        partec4.rellenarC4(selectedItems);
 
        // start the ResultActivity
        startActivity(intent);
	}
}


