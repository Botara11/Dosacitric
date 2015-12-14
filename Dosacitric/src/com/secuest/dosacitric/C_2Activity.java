package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class C_2Activity extends ListActivity {
	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private ParteC partec2;
	ListView listView ;
	private String[] presiones2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.c_2);  
		setContentView(R.layout.catalogoslistview_layout);
		
		String[] presiones = { "6 bar", "7 bar", "8 bar", "9 bar",
				"10 bar", "11 bar", "12 bar", "13 bar", "14 bar",
				"15 bar", "16 bar" };
		presiones2 = presiones;

		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  

		for(int i=0;i<presiones.length;i++){
			datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ presiones[i]}));
		}
		
		if (mAdapter == null) {
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
		String item = presiones2[position];
		
		String ola ="ParteC2";
		Log.e("didi", ola);

		Intent c1 = getIntent();
		partec2 = (ParteC) c1.getSerializableExtra("partec1");
		partec2.rellenarC2(item);

		Intent c2 = new Intent(C_2Activity.this, C_3Activity.class);
		c2.putExtra("presion", partec2);
		startActivity(c2);
	}
	

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}


