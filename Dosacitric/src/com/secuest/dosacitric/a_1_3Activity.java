package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class a_1_3Activity extends Activity{

	private Spinner productosAplicar;
	private Spinner formaActuacion;
	private Spinner utilizaMojantes;
	private Spinner zonaCritica;
	private Spinner temperatura;
	private Spinner humedadRelativa;
	private Spinner velocidadViento;
	private Spinner tipoPulverizacion;
	private ParteA parteA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_3);


		productosAplicar = (Spinner) findViewById(R.id.productosAplicar);
		formaActuacion = (Spinner) findViewById(R.id.formaActuacion);
		utilizaMojantes = (Spinner) findViewById(R.id.utilizaMojantes);
		zonaCritica = (Spinner) findViewById(R.id.zonaCritica);
		temperatura = (Spinner) findViewById(R.id.temperatura);
		humedadRelativa = (Spinner) findViewById(R.id.humedadRelativa);
		velocidadViento = (Spinner) findViewById(R.id.velocidadViento);
		tipoPulverizacion = (Spinner) findViewById(R.id.tipoPulverizacion);

		//parteA = (ParteA) getIntent().getSerializableExtra("ParteA");

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("(1) Acaricidas");
		lista.add("(2) Fungicidas");
		lista.add("(3) Insecticidas");
		lista.add("(4) Abonos foliares");
		lista.add("(5) Fitorreguladores");
		lista.add("Seleccionar");
		ArrayAdapterMio<String> adaptador = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista);
		adaptador.setDropDownViewResource(R.layout.spinner_item);
		productosAplicar.setAdapter(adaptador);
		productosAplicar.setSelection(adaptador.getCount());


		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("(1) Por asfixia (aceite)");
		lista1.add("(2) Por contacto");
		lista1.add("(3) Por ingestión");
		lista1.add("(4) Por inhalación");
		lista1.add("(5) Translaminar");
		lista1.add("(6) Sistémicos");
		lista1.add("Seleccionar");
		ArrayAdapterMio<String> adaptador1 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista1);
		adaptador1.setDropDownViewResource(R.layout.spinner_item);
		formaActuacion.setAdapter(adaptador1);
		formaActuacion.setSelection(adaptador1.getCount());


		ArrayList<String> lista2 = new ArrayList<String>();
		lista2.add("Sí");
		lista2.add("No");
		lista2.add("Seleccionar");
		ArrayAdapterMio<String> adaptador2 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista2);
		adaptador2.setDropDownViewResource(R.layout.spinner_item);
		utilizaMojantes.setAdapter(adaptador2);
		utilizaMojantes.setSelection(adaptador2.getCount());

		ArrayList<String> lista3 = new ArrayList<String>();
		lista3.add("(1) Zona interior de la copa del árbol");
		lista3.add("(2) Zona interior y exterior de la copa del árbol");
		lista3.add("(3) Zona exterior de la copa del árbol");
		lista3.add("Seleccionar");
		ArrayAdapterMio<String> adaptador3 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista3);
		adaptador3.setDropDownViewResource(R.layout.spinner_item);
		zonaCritica.setAdapter(adaptador3);
		zonaCritica.setSelection(adaptador3.getCount());


		ArrayList<String> lista4 = new ArrayList<String>();
		lista4.add("Menos de 15 ºC");
		lista4.add("De 15 a 25 ºC");
		lista4.add("De 25 a 30 ºC");
		lista4.add("Más de 30 ºC");
		lista4.add("Seleccionar");
		ArrayAdapterMio<String> adaptador4 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista4);
		adaptador4.setDropDownViewResource(R.layout.spinner_item);
		temperatura.setAdapter(adaptador4);
		temperatura.setSelection(adaptador4.getCount());


		ArrayList<String> lista5 = new ArrayList<String>();
		lista5.add("Menor de 35% (ambiente muy seco)");
		lista5.add("Entre el 35 y 60% (ambiente normal)");
		lista5.add("Más del 60% (ambiente muy húmedo)");
		lista5.add("Lluvia");
		lista5.add("Seleccionar");
		ArrayAdapterMio<String> adaptador5 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista5);
		adaptador5.setDropDownViewResource(R.layout.spinner_item);
		humedadRelativa.setAdapter(adaptador5);
		humedadRelativa.setSelection(adaptador5.getCount());

		ArrayList<String> lista6 = new ArrayList<String>();
		lista6.add("Menor de 1 m/s (ausencia de viento)");
		lista6.add("Entre el 1 y 3 m/s (brisa suave)");
		lista6.add("Más del 3 m/s (viento)");
		lista6.add("Seleccionar");
		ArrayAdapterMio<String> adaptador6 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista6);
		adaptador6.setDropDownViewResource(R.layout.spinner_item);
		velocidadViento.setAdapter(adaptador6);
		velocidadViento.setSelection(adaptador6.getCount());


		ArrayList<String> lista7 = new ArrayList<String>();
		lista7.add("Pulverizador hidroneumático");
		lista7.add("Pistola");
		lista7.add("Seleccionar");
		ArrayAdapterMio<String> adaptador7 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista7);
		adaptador7.setDropDownViewResource(R.layout.spinner_item);
		tipoPulverizacion.setAdapter(adaptador7);
		tipoPulverizacion.setSelection(adaptador7.getCount());



		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				String revisando = "";
				String reemplazado = "";

				/*Intent i =new Intent(a_1_2Activity.this, ParteA.class);
			    //String alturaM = alturaMeseta.getText().toString();
			    //i.putExtra("alturaMeseta", alturaM);
				//startActivity(i);

				Intent i =new Intent(a_1_2Activity.this, Resultados1.class);
				i.putExtra("alturaMeseta", alturaMeseta.getText().toString());

				//Log.e("n", alturaMeseta.getText());
				startActivity(i);*/


				try {

					ParteA nuevo = new ParteA();

					Intent iii = getIntent();
					ParteA parteaa = (ParteA) iii.getSerializableExtra("partea");
					
					Log.e("didi", parteaa.toString());


					revisando = "Productos a aplicar";
					if(productosAplicar.getSelectedItemPosition()==productosAplicar.getCount())
						Double.parseDouble("p");
					float productosAplicar1 = (float) Double.parseDouble(reemplazado);

					revisando = "Forma de actuación";
					if(formaActuacion.getSelectedItemPosition()==formaActuacion.getCount())
						Double.parseDouble("p");
					float formaActuacion1 = (float) Double.parseDouble(reemplazado);

					revisando = "¿Utiliza coadyuvantes (mojantes)?";
					if(utilizaMojantes.getSelectedItemPosition()==utilizaMojantes.getCount())
						Double.parseDouble("p");
					float utilizaMojantes1 = (float) Double.parseDouble(reemplazado);
					
					revisando = "Zona crítica a tratar";
					if(zonaCritica.getSelectedItemPosition()==zonaCritica.getCount())
						Double.parseDouble("p");
					float zonaCritica1 = (float) Double.parseDouble(reemplazado);

					revisando = "Temperatura";
					if(temperatura.getSelectedItemPosition()==temperatura.getCount())
						Double.parseDouble("p");
					float temperatura1 = (float) Double.parseDouble(reemplazado);

					revisando = "Humedad relativa";
					if(humedadRelativa.getSelectedItemPosition()==humedadRelativa.getCount())
						Double.parseDouble("p");
					float humedadRelativa1 = (float) Double.parseDouble(reemplazado);

					revisando = "Velocidad del viento";
					if(velocidadViento.getSelectedItemPosition()==velocidadViento.getCount())
						Double.parseDouble("p");
					float velocidadViento1 = (float) Double.parseDouble(reemplazado);

					revisando = "Tipo de pulverizador";
					if(tipoPulverizacion.getSelectedItemPosition()==tipoPulverizacion.getCount())
						Double.parseDouble("p");
					float tipoPulverizacion1 = (float) Double.parseDouble(reemplazado);

					nuevo.rellenarA2345(productosAplicar1, formaActuacion1, utilizaMojantes1, zonaCritica1, temperatura1, humedadRelativa1, velocidadViento1, tipoPulverizacion1);
					Intent i = new Intent(a_1_3Activity.this, Resultados1.class);
					i.putExtra("partea",nuevo);
					startActivity(i);

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
				//startActivity(new Intent(a_1_2Activity.this, a_1_1Activity.class));
				finish();

			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(a_1_3Activity.this, Indice.class));
			}
		});
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



}
