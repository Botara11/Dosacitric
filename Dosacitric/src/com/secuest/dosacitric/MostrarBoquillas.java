package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MostrarBoquillas extends ListActivity {

	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private ArrayList<String> presionesAdecu;

	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boquillaslistview_ingresadas);

		// Get ListView object from xml
		listView = (ListView) findViewById(android.R.id.list);

		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

		//Lista que va a contener las marcas y dentro de cada una las presiones que correspondan
		presionesAdecu = new ArrayList<String>();

		DatabaseHandler db = new DatabaseHandler(
				getApplicationContext());
		presionesAdecu = db.getBoquillas("MIS BOQUILLAS", 0.0, 100.0, "p6");
		for(int i=0;i<presionesAdecu.size();i++){
			//String caudal_s = db.getCaudalAunaPresionDeBoquilla("MIS BOQUILLAS", modelo, 10);
			ArrayList<String> datos2 = db.getDatosIntroMisBoquillas(presionesAdecu.get(i));
			//caudal.setText(datos.get(1));
			//presion.setText(datos.get(0));
			datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ presionesAdecu.get(i) +"  ("+
			datos2.get(1)+ "L/min a "+datos2.get(0)+" bar)" }));
		}

		// you only need to instantiate these the first time your fragment is
		// created; then, the method above will do the rest
		if (mAdapter == null) {
			mAdapter = new Lista_adaptador(this , R.layout.list_item_coniconos, datos){
				@Override
				public void onEntrada(Object entrada, View view) {
					if (entrada != null) {
						TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textsuperior); 
						if (texto_superior_entrada != null) 
							texto_superior_entrada.setText(((Lista_entrada) entrada).get_texto(0)); 
					}
				}
			};		

		}

		getListView().setAdapter(mAdapter);
		setListAdapter(mAdapter);

		Button salir = (Button) findViewById(R.id.siguiente);
		salir.setClickable(true);
		salir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
/*
		String selectedItem = ((Lista_entrada) getListAdapter().getItem(position)).get_texto(0);
		Intent res = new Intent(MostrarBoquillas.this, MostrarBoquillasContinuacion.class);
		res.putExtra("modelo", selectedItem);
		startActivity(res);
*/
	}
}

