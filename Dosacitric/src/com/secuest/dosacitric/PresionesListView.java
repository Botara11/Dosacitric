package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PresionesListView extends ListActivity{
	
	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private ArrayList<String> mItems;
	private int mTotal;
	private int mPosition;
	
	 ListView listView ;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.presioneslistview_layout);
         
         // Get ListView object from xml
         listView = (ListView) findViewById(android.R.id.list);
		
		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

		datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "1 bar"}));
		datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "2 bares"}));
		datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "3 bares"}));
		datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "4 bares"}));
		datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "5 bares"}));
		//datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ "Otros"}));
		
		
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
								  
								//TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textinferior); 
								//if (texto_inferior_entrada != null)
									//texto_inferior_entrada.setText(((Lista_entrada) entrada).get_texto(1)); 

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
             //String selectedItem = (String) getListView().getItemAtPosition(position);
             //String selectedItem = (String) getListAdapter().getItem(position);
             //text.setText("You clicked " + selectedItem + " at position " + position);
             startActivity(new Intent(PresionesListView.this, BoquillasListView.class));
         }
}
