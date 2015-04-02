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

public class A_1_2Activity extends Activity{

	private EditText alturaMeseta;
	private Spinner formaArb;
	private Spinner fechaUltima;
	private Spinner gradoPoda;
	private ParteA parteA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_2);

		alturaMeseta = (EditText) findViewById(R.id.alturaMeseta);
		formaArb = (Spinner) findViewById(R.id.formaArb);
		fechaUltima = (Spinner) findViewById(R.id.fechaultima);
		gradoPoda = (Spinner) findViewById(R.id.gradoPoda);

		//parteA = (ParteA) getIntent().getSerializableExtra("ParteA");

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Esférica (globo)");
		lista.add("Seto");
		lista.add("Seleccionar");
		ArrayAdapterMio<String> adaptador = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista);
		adaptador.setDropDownViewResource(R.layout.spinner_item);
		formaArb.setAdapter(adaptador);
		formaArb.setSelection(adaptador.getCount());


		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("Hace menos de 3 meses");
		lista1.add("Entre 3 meses y 1 año");
		lista1.add("Entre 1 año y 2 años");
		lista1.add("Hace más de 2 años");
		lista1.add("Seleccionar");
		ArrayAdapterMio<String> adaptador1 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista1);
		adaptador1.setDropDownViewResource(R.layout.spinner_item);
		fechaUltima.setAdapter(adaptador1);
		fechaUltima.setSelection(adaptador1.getCount());


		ArrayList<String> lista2 = new ArrayList<String>();
		lista2.add("Bajo");
		lista2.add("Medio");
		lista2.add("Alto");
		lista2.add("Seleccionar");
		ArrayAdapterMio<String> adaptador2 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista2);
		adaptador2.setDropDownViewResource(R.layout.spinner_item);
		gradoPoda.setAdapter(adaptador2);
		gradoPoda.setSelection(adaptador2.getCount());



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

					Intent a1 = getIntent();
					ParteA partea2 = (ParteA) a1.getSerializableExtra("partea1");

					Log.e("didi", partea2.toString());

					revisando = "Altura de la Meseta";
					reemplazado = alturaMeseta.getText().toString().replace(',', '.');
					float alturaMeseta1 = (float) Double.parseDouble(reemplazado);

					revisando = "Forma del arbol";
					if(formaArb.getSelectedItemPosition()==formaArb.getCount())
						Double.parseDouble("p");
					float formaArb1 = (float) Double.parseDouble(reemplazado);

					revisando = "Fecha de la última poda";
					if(fechaUltima.getSelectedItemPosition()==fechaUltima.getCount())
						Double.parseDouble("p");
					float fechaUltima1 = (float) Double.parseDouble(reemplazado);

					revisando = "Grado de poda";
					if(gradoPoda.getSelectedItemPosition()==gradoPoda.getCount())
						Double.parseDouble("p");
					float gradoPoda1 = (float) Double.parseDouble(reemplazado);


					nuevo.rellenarA11(alturaMeseta1, formaArb1, fechaUltima1, gradoPoda1);
					Intent a2 = new Intent(A_1_2Activity.this, A_1_3Activity.class);
					a2.putExtra("partea2",nuevo);
					startActivity(a2);

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
				startActivity(new Intent(A_1_2Activity.this, Indice.class));
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
