package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class a_1_1Activity extends Activity{
	
	private EditText anchocalle;
	private EditText distancia;
	private EditText logitudArb;
	private EditText anchuraArb;
	private EditText alturaArb;
	private Spinner genero;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_1);
		
		anchocalle = (EditText)findViewById(R.id.anchocalle);
		distancia = (EditText)findViewById(R.id.distancia);
		logitudArb = (EditText)findViewById(R.id.logitudArb);
		anchuraArb = (EditText)findViewById(R.id.anchuraArb);
		alturaArb = (EditText) findViewById(R.id.alturaArb);
		
		
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";
				try {
					revisando = "Ancho de calle";
					reemplazado = anchocalle.getText().toString().replace(',', '.');
					Double.parseDouble(reemplazado);
					
					revisando = "Distancia entre arboles";
					reemplazado = distancia.getText().toString().replace(',', '.');
					Double.parseDouble(reemplazado);
					
					revisando = "Longitud de los arboles";
					reemplazado = logitudArb.getText().toString().replace(',', '.');
					Double.parseDouble(reemplazado);
					
					revisando = "Anchura de los arboles";
					reemplazado = anchuraArb.getText().toString().replace(',', '.');
					Double.parseDouble(reemplazado);
					
					revisando = "Altura de los arboles";
					reemplazado = alturaArb.getText().toString().replace(',', '.');
					Double.parseDouble(reemplazado);
					
					revisando = "Densidad foliar del cultivo";
					int pos = genero.getSelectedItemPosition();
					if(pos==3)
						Double.parseDouble("p");
					startActivity(new Intent(a_1_1Activity.this, a_1_2Activity.class));

				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(), "Valor de "+'"'+revisando+'"'+" incorrecto", Toast.LENGTH_SHORT);
					toast.show();
				}

			}
		});
		
		Button atras = (Button) findViewById(R.id.atras);
		atras.setClickable(true);
		atras.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				//startActivity(new Intent(a_1_1Activity.this, Indice.class));
				finish();
			}
		});
		
		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(a_1_1Activity.this, Indice.class));
			}
		});
		
		genero = (Spinner) findViewById(R.id.spinner1);

		ArrayList<String> lista = new ArrayList<String>();
				lista.add("Bajo");
				lista.add("Medio");
				lista.add("Alto");
				lista.add("Seleccionar");
				ArrayAdapterMio<String> adaptador = new ArrayAdapterMio<String>(this, 
						//android.R.layout.simple_spinner_dropdown_item, lista);
						R.layout.spinner_item, lista);
				adaptador.setDropDownViewResource(R.layout.spinner_item);
				genero.setAdapter(adaptador);
				//genero.setSelection(adaptador.getCount());
				genero.setSelection(adaptador.getCount());
	}
	
	private class ArrayAdapterMio<String> extends ArrayAdapter<String> {
		
		public ArrayAdapterMio(Context context, int resource,
				List<String> objects) {
			super(context, resource, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = super.getView(position, convertView, parent);
			if (position == getCount()) {
				((TextView)v.findViewById(R.id.text1)).setText("");
				((TextView)v.findViewById(R.id.text1)).setHint((CharSequence) getItem(getCount())); //"Hint to be displayed"
			}
			return v;
		}       
		@Override
		public int getCount() {
			return super.getCount()-1; // you dont display last item. It is used as hint.
		} 
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
