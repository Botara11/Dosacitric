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
	private float[] inter;
	private ArrayList<String> presionesAdecu;
	private String marca ;
	
	 ListView listView ;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.presioneslistview_layout);
         
         // Get ListView object from xml
         listView = (ListView) findViewById(android.R.id.list);
		
		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
		
		marca = (String) getIntent().getSerializableExtra("marca");
		inter = (float[]) getIntent().getSerializableExtra("inter");


		/*******************************************************************/
		/*********************** PROCESAR PRESIONES ************************/
		/*******************************************************************/
		
		
		
		String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
				"p12", "p13", "p14", "p15", "p16" };

		//Lista que va a contener las marcas y dentro de cada una las presiones que correspondan
		presionesAdecu = new ArrayList<String>();

		DatabaseHandler db = new DatabaseHandler(
				getApplicationContext());
		
			for (String pres : presiones) {
				ArrayList<String> boquillasZ1 = db.getBoquillas(marca,
						inter[0], inter[1], pres);
				ArrayList<String> boquillasZ2 = db.getBoquillas(marca,
						inter[2], inter[3], pres);
				ArrayList<String> boquillasZ3 = db.getBoquillas(marca,
						inter[4], inter[5], pres);
				if (boquillasZ1 != null && boquillasZ2 != null
						&& boquillasZ3 != null) {
					if (boquillasZ1.size() > 0
							&& boquillasZ2.size() > 0
							&& boquillasZ3.size() > 0) {
						System.out.println("z1=" + boquillasZ1.size()
								+ " z2=" + boquillasZ2.size() + " z3="
								+ boquillasZ3.size());
						// Se muestran
						presionesAdecu.add(pres);
					}
				}
			
		}
		for(int i=0;i<presionesAdecu.size();i++){
			datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ presionesAdecu.get(i).replace("p", "")+" bares"}));
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

             Intent res = new Intent(PresionesListView.this, BoquillasListView.class);
				res.putExtra("presion", presionesAdecu.get(position));
				res.putExtra("inter", inter);
				res.putExtra("marca", marca);
				startActivity(res);
         }
}
