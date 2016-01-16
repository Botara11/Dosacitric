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

public class C_3Activity extends ListActivity{
	private com.secuest.dosacitric.Lista_adaptador mAdapter;
	private String[] marcas2;
	private ParteC partec3;
	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogoslistview_layout);

		String[] marcas = { "Teejet", "Albuz", "Hardi", "Discos", "Mis boquillas" };
		marcas2=marcas;
		
		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  


		for(int i=0;i<marcas.length;i++){
			datos.add(new Lista_entrada(R.drawable.arrow,1,new String[]{ marcas[i]}));
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
		String item = marcas2[position];

		String ola ="ParteC3";
		Log.e("didi", ola);

		Intent c2 = getIntent();
		partec3 = (ParteC) c2.getSerializableExtra("presion");
		partec3.rellenarC3(item);

		Intent c3 = new Intent(C_3Activity.this, C_4ZonaAlta.class);
		c3.putExtra("marcas", partec3);
		startActivity(c3);
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
