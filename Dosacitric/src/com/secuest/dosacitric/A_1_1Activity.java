package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class A_1_1Activity extends Activity{
	private int debug = 1;
	private Spinner densidadFoliar;
	private EditText anchocalle;
	private EditText distancia;
	private EditText longitudArb;
	private EditText anchuraArb;
	private EditText alturaArb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_1);

		densidadFoliar = (Spinner) findViewById(R.id.densidadFoliar);
		anchocalle = (EditText) findViewById(R.id.anchocalle);
		distancia = (EditText) findViewById(R.id.distancia);
		longitudArb = (EditText) findViewById(R.id.longitudArb);
		anchuraArb = (EditText) findViewById(R.id.anchuraArb);
		alturaArb = (EditText) findViewById(R.id.alturaArb);

		if (debug==1){
		//PONIENDO VALORES PARA DEBUG
		anchocalle.setText("6");
		distancia.setText("6");
		longitudArb.setText("6");
		anchuraArb.setText("6");
		alturaArb.setText("6");
		}
		
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";

				/*Intent i =new Intent(a_1_1Activity.this, a_1_2Activity.class);
				//String anchoc = anchocalle.getText().toString();
				//String dist = distancia.getText().toString();
				//String longitudA = longitudArb.getText().toString();
				//String anchuraA = anchuraArb.getText().toString();
			    //String alturaA = alturaArb.getText().toString();
				i.putExtra("anchocalle", anchocalle.getText().toString());
				i.putExtra("distancia", distancia.getText().toString());
				i.putExtra("longitudArb", longitudArb.getText().toString());
				i.putExtra("anchuraArb", anchuraArb.getText().toString());
				i.putExtra("alturaArb", alturaArb.getText().toString());

				Log.e("n", anchocalle.getText()+"."+ distancia.getText()+"."
						+ longitudArb.getText()+"."+ anchuraArb.getText()
						+"."+ alturaArb.getText());
				startActivity(i);*/	

				try {

					revisando = "Densidad foliar del cultivo";
					Float densidadFoliar1 = (float) 999.999;
					int den = densidadFoliar.getSelectedItemPosition();
					switch(den){

					case 0: densidadFoliar1=(float) 0.9;
					break;
					case 1: densidadFoliar1=(float) 1.00;
					break;
					case 2: densidadFoliar1=(float) 1.15;
					break;
					case 3:  Double.parseDouble("p");
					break;
					}
					String ola = (String)densidadFoliar.getItemAtPosition(densidadFoliar.getSelectedItemPosition());

					Log.e("didi", ola+" densidadFoliar A_1_1");

					/*revisando = "Densidad foliar del cultivo";
					if(densidadFoliar.getSelectedItemPosition()==densidadFoliar.getCount())
						Double.parseDouble("p");
					float densidadFoliar1 = (float) Double.parseDouble(reemplazado);*/

					revisando = "Ancho de calle";
					reemplazado = anchocalle.getText().toString().replace(',', '.');
					float anchocalle1 = (float) Double.parseDouble(reemplazado);

					revisando = "Distancia entre arboles";
					reemplazado = distancia.getText().toString().replace(',', '.');
					float distancia1 = (float) Double.parseDouble(reemplazado);

					revisando = "Longitud de los arboles";
					reemplazado = longitudArb.getText().toString().replace(',', '.');
					float longitudArb1 = (float) Double.parseDouble(reemplazado);

					revisando = "Anchura de los arboles";
					reemplazado = anchuraArb.getText().toString().replace(',', '.');
					float anchuraArb1 = (float) Double.parseDouble(reemplazado);

					revisando = "Altura de los arboles";
					reemplazado = alturaArb.getText().toString().replace(',', '.');
					float alturaArb1 = (float) Double.parseDouble(reemplazado);

					Intent a = getIntent();
					ParteA nuevo = (ParteA) a.getSerializableExtra("partea");
					
					nuevo.rellenarA1(densidadFoliar1, anchocalle1, distancia1, longitudArb1, anchuraArb1, alturaArb1, den);
					Intent a1 = new Intent(A_1_1Activity.this,A_1_2Activity.class);
					a1.putExtra("partea1",nuevo);
					startActivity(a1);

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
				startActivity(new Intent(A_1_1Activity.this, Indice.class));
			}
		});

		ImageButton ayuda1 = (ImageButton) findViewById(R.id.ayuda1);
		ayuda1.setClickable(true);
		ayuda1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(A_1_1Activity.this, Ayuda.class));
			}
		});

		ImageButton ayuda2 = (ImageButton) findViewById(R.id.ayuda2);
		ayuda2.setClickable(true);
		ayuda2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(A_1_1Activity.this, Ayuda.class));
			}
		});

		densidadFoliar = (Spinner) findViewById(R.id.densidadFoliar);

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Bajo");
		lista.add("Medio");
		lista.add("Alto");
		lista.add("Seleccionar");
		ArrayAdapterMio<String> adaptador = new ArrayAdapterMio<String>(this, 
				//android.R.layout.simple_spinner_dropdown_item, lista);
				R.layout.spinner_item, lista);
		adaptador.setDropDownViewResource(R.layout.spinner_item);
		densidadFoliar.setAdapter(adaptador);
		//genero.setSelection(adaptador.getCount());
		densidadFoliar.setSelection(adaptador.getCount());
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
