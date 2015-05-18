package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BoquillasListViewParteC extends ListActivity{

	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private ArrayList<String> mItems;
	private int mTotal;
	private int mPosition;
	private String marca;
	private float[] inter;
	private String presion;

	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boquillaslistview_layoutpartec);

		//Cogemos los datos de BD
		//final String ZonaAlta =  db.getCaudalAunaPresionDeBoquilla(partec4.MarcaSeleccionada, "D4/DC33", Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
		//String ZonaMedia =  db.getCaudalAunaPresionDeBoquilla(marca, "D4/DC33", Integer.parseInt(presion.replace(" bares", "")));
		//String ZonaBaja =  db.getCaudalAunaPresionDeBoquilla(marca, "D4/DC33", Integer.parseInt(presion.replace(" bares", "")));
				
		//Integer.parseInt(presion.replace(" bares", ""))
				
		//final String ZonaAlta =  db.getModelo(partec4.MarcaSeleccionada, Integer.parseInt(partec4.PresionSeleccionada.replace(" bares", "")));
				
		//Log.e("didi", ZonaAlta);
		
		
		
		/*String PresionSeleccionada = item;

		DatabaseHandler db = new DatabaseHandler(this);
		String resultado1 =  db.getCaudalAunaPresionDeBoquilla("Teejet", "D4/DC33", Integer.parseInt(PresionSeleccionada.replace(" bares", "")));
		String resultado2 =  db.getCaudalAunaPresionDeBoquilla("Teejet", "D4/DC33", Integer.parseInt(PresionSeleccionada.replace(" bares", "")));
		String resultado3 =  db.getCaudalAunaPresionDeBoquilla("Teejet", "D4/DC33", Integer.parseInt(PresionSeleccionada.replace(" bares", "")));
		System.out.println(resultado1);

		partec4.calcularParteC();*/


		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(BoquillasListViewParteC.this, C_1Activity.class));
				finish();
			}
		});
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
		//String selectedItem = (String) getListView().getItemAtPosition(position);
		//String selectedItem = (String) getListAdapter().getItem(position);
		//text.setText("You clicked " + selectedItem + " at position " + position);
	}



}
