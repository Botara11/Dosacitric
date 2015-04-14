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
	
	 ListView listView ;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.boquillaslistview_layout);
         
         // Get ListView object from xml
         listView = (ListView) findViewById(android.R.id.list);
		
         final ListViewItem[] items = new ListViewItem[9];
		
         
                 items[0] = new ListViewItem("Zona Alta ", CustomAdapter.TYPE_ODD);
                 items[1] = new ListViewItem("D1.5/DC35 ", CustomAdapter.TYPE_EVEN);
                 items[2] = new ListViewItem("D1/DC31 ", CustomAdapter.TYPE_EVEN);
           
                 items[3] = new ListViewItem("Zona Media ", CustomAdapter.TYPE_ODD);
                 items[4] = new ListViewItem("D3/DC56 ", CustomAdapter.TYPE_EVEN);
                 items[5] = new ListViewItem("D1.5/DC31 ", CustomAdapter.TYPE_EVEN);
           
                 items[6] = new ListViewItem("Zona Baja ", CustomAdapter.TYPE_ODD);
                 items[7] = new ListViewItem("D1/DC31 ", CustomAdapter.TYPE_EVEN);
                 items[8] = new ListViewItem("D3/DC56 ", CustomAdapter.TYPE_EVEN);
             
         
         
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
