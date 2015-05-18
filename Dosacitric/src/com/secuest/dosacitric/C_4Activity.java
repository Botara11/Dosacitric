package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class C_4Activity extends ListActivity{

	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_4);  

		// Get ListView object from xml
		listView = (ListView) findViewById(android.R.id.list);

		Intent c3 = getIntent();
		final ParteC partec4 = (ParteC) c3.getSerializableExtra("marcas");
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		ArrayList<String> modelosZ1 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String> modelosZ2 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		ArrayList<String>  modelosZ3 = db.getModelo(partec4.MarcaSeleccionada,
				Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));

		final ListViewItem[] items = new ListViewItem[3+modelosZ1.size()+modelosZ2.size()+modelosZ3.size()];
		
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
				listView.setAdapter(customAdapter);
		
			
				Button siguiente = (Button) findViewById(R.id.siguiente);
				siguiente.setClickable(true);
				siguiente.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
			
						//partec4.rellenarC4(item);

						Intent c4 = new Intent(C_4Activity.this, Resultados3.class);
						c4.putExtra("modelos", partec4);
						startActivity(c4);
					}		
				});

		}
}


