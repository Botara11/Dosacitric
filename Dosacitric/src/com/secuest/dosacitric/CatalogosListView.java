package com.secuest.dosacitric;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CatalogosListView extends ListActivity{

	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private ArrayList<String> mItems;
	private int mTotal;
	private int mPosition;
	private ArrayList<String> marcasAdecu ;
	private float[] inter;

	ListView listView ;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogoslistview_layout);

		// Get ListView object from xml
		listView = (ListView) findViewById(android.R.id.list);
		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

		ArrayList<String> marcas = (ArrayList<String>) getIntent().getSerializableExtra("marcas");

		inter = (float[]) getIntent().getSerializableExtra("inter");
		for (String marc:marcas){
			System.out.println(marc);
			datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ marc}));
		}

		// you only need to instantiate these the first time your fragment is
		// created; then, the method above will do the rest
		if (mAdapter == null) {
			mItems = new ArrayList<String>();
			mAdapter = new Lista_adaptador(this , R.layout.list_item_coniconos, datos){
				@Override
				public void onEntrada(Object entrada, View view) {
					if (entrada != null) {
						TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textsuperior); 
						if (texto_superior_entrada != null) 
							texto_superior_entrada.setText(((Lista_entrada) entrada).get_texto(0)); 

						ImageView imagen_entrada = (ImageView) view.findViewById(R.id.image); 
						if (imagen_entrada != null)
							imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
					}
				}
			};		

		}

		getListView().setAdapter(mAdapter);
		setListAdapter(mAdapter);
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);

		String selectedItem = ((Lista_entrada) getListAdapter().getItem(position)).get_texto(0);

		Intent res = new Intent(CatalogosListView.this, PresionesListView.class);
		res.putExtra("marca", selectedItem);
		res.putExtra("inter", inter);
		startActivity(res);
	}

}

