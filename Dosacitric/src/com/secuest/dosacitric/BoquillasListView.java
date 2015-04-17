package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BoquillasListView extends ListActivity{

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
         setContentView(R.layout.boquillaslistview_layout);
         
         // Get ListView object from xml
         listView = (ListView) findViewById(android.R.id.list);
		
         marca = (String) getIntent().getStringExtra("marca");
  		inter = (float[]) getIntent().getSerializableExtra("inter");
 		presion = (String) getIntent().getStringExtra("presion");

        
 		DatabaseHandler db = new DatabaseHandler(
				getApplicationContext());
 		//Cogemos los datos de BD
 		ArrayList<String> boquillasZ1 = db.getBoquillas(marca,
				inter[0], inter[1], presion);
 		ArrayList<String> boquillasZ2 = db.getBoquillas(marca,
				inter[2], inter[3], presion);
		ArrayList<String> boquillasZ3 = db.getBoquillas(marca,
				inter[4], inter[5], presion);
		
		
        final ListViewItem[] items = new ListViewItem[3+boquillasZ1.size()+boquillasZ2.size()+boquillasZ3.size()];

        
        
		//Los anadimos a la listView
 		int contador=0;
 		items[contador] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
 		for(int i=0;i<boquillasZ1.size();i++){
            items[++contador] = new ListViewItem(boquillasZ1.get(i), CustomAdapter.TYPE_EVEN);
 		}
 		items[++contador] = new ListViewItem("Zona Media ", CustomAdapter.TYPE_ODD);
 		for(int i=0;i<boquillasZ2.size();i++){
            items[++contador] = new ListViewItem(boquillasZ2.get(i), CustomAdapter.TYPE_EVEN);
 		}
 		items[++contador] = new ListViewItem("Zona Baja ", CustomAdapter.TYPE_ODD);
 		for(int i=0;i<boquillasZ3.size();i++){
            items[++contador] = new ListViewItem(boquillasZ3.get(i), CustomAdapter.TYPE_EVEN);
 		}
         
         
         CustomAdapter customAdapter = new CustomAdapter(this, R.id.textsuperior, items);
         listView.setAdapter(customAdapter);
         
	}
     
     @Override
         protected void onListItemClick(ListView list, View view, int position, long id) {
             super.onListItemClick(list, view, position, id);
             //String selectedItem = (String) getListView().getItemAtPosition(position);
             //String selectedItem = (String) getListAdapter().getItem(position);
             //text.setText("You clicked " + selectedItem + " at position " + position);
         }
     
}
