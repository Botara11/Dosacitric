package com.secuest.dosacitric;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class A_1_3Activity extends ActionBarActivity{

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
		
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

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
		lista6.add("Entre 1 y 3 m/s (brisa suave)");
		lista6.add("Más de 3 m/s (viento)");
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

					Intent a2 = getIntent();
					ParteA partea3 = (ParteA) a2.getSerializableExtra("partea1");
					
					Log.e("didi", Float.toString(partea3.DensidadFoliar));
					Log.e("didi", Float.toString(partea3.AnchoCalle));
					Log.e("didi", Float.toString(partea3.DistanciaArboles));
					Log.e("didi", Float.toString(partea3.LongitudArboles));
					Log.e("didi", Float.toString(partea3.AnchuraArboles));
					Log.e("didi", Float.toString(partea3.AlturaArboles));
					Log.e("didi", Float.toString(partea3.FormaArbol));
					Log.e("didi", Float.toString(partea3.FechaUltimaPoda));
					Log.e("didi", Float.toString(partea3.GradoPoda));

					Log.e("didi", partea3.toString());

					revisando = "Productos a aplicar";
					Float productosAplicar1 = (float) 999.999;
					int pro = productosAplicar.getSelectedItemPosition();
					switch(pro){

					case 0: productosAplicar1=(float) 1.05;
					break;
					case 1: productosAplicar1=(float) 1.05;
					break;
					case 2: productosAplicar1=(float) 1.00;
					break;
					case 3: productosAplicar1=(float) 0.95;
					break;
					case 4: productosAplicar1=(float) 0.95;
					break;
					case 5: Double.parseDouble("p");
					break;
					}

					revisando = "Forma de actuación";
					Float formaActuacion1 = (float) 999.999;
					int form = formaActuacion.getSelectedItemPosition();
					switch(form){

					case 0: formaActuacion1=(float) 1.05;
					break;
					case 1: formaActuacion1=(float) 1.00;
					break;
					case 2: formaActuacion1=(float) 1.00;
					break;
					case 3: formaActuacion1=(float) 1.00;
					break;
					case 4: formaActuacion1=(float) 0.95;
					break;
					case 5: formaActuacion1=(float) 0.85;
					break;
					case 6: Double.parseDouble("p");
					break;
					}

					revisando = "¿Utiliza coadyuvantes (mojantes)";
					Float utilizaMojantes1 = (float) 999.999;
					int uti = utilizaMojantes.getSelectedItemPosition();
					switch(uti){

					case 0: utilizaMojantes1=(float) 1.00;
					break;
					case 1: utilizaMojantes1=(float) 1.05;
					break;
					case 2: Double.parseDouble("p");
					break;
					}

					revisando = "Zona crítica a tratar";
					Float zonaCritica1 = (float) 999.999;
					int zon = zonaCritica.getSelectedItemPosition();
					switch(zon){

					case 0: zonaCritica1=(float) 3.00;
					break;
					case 1: zonaCritica1=(float) 3.00;
					break;
					case 2: zonaCritica1=(float) 1.00;
					break;
					case 3: Double.parseDouble("p");
					break;
					}

					revisando = "Temperatura";
					Float temperatura1 = (float) 999.999;
					int temp = temperatura.getSelectedItemPosition();
					switch(temp){

					case 0: temperatura1=(float) 1.00;
					break;
					case 1: temperatura1=(float) 1.025;
					break;
					case 2: temperatura1=(float) 1.05;
					break;
					case 3: Double.parseDouble("p");
					break;
					case 4: Double.parseDouble("p");
					break;
					}
					

					revisando = "Humedad relativa";
					Float humedadRelativa1 = (float) 999.999;
					int hum = humedadRelativa.getSelectedItemPosition();
					switch(hum){

					case 0: humedadRelativa1=(float) 1.05;
					break;
					case 1: humedadRelativa1=(float) 1.00;
					break;
					case 2: humedadRelativa1=(float) 0.97;
					break;
					case 3: Double.parseDouble("p");
					break;
					case 4: Double.parseDouble("p");
					break;
					}

					revisando = "Velocidad del viento";
					Float velocidadViento1 = (float) 999.999;
					int vel = velocidadViento.getSelectedItemPosition();
					switch(vel){

					case 0: velocidadViento1=(float) 1.00;
					break;
					case 1: velocidadViento1=(float) 1.05;
					break;
					case 2: Double.parseDouble("p");
					break;
					}

					revisando = "Tipo de pulverizador";
					Float tipoPulverizacion1 = (float) 999.999;
					int tip = tipoPulverizacion.getSelectedItemPosition();
					switch(tip){

					case 0: tipoPulverizacion1=(float) 1.00;
					break;
					case 1: tipoPulverizacion1=(float) 1.80;
					break;
					case 2: Double.parseDouble("p");
					break;
					}

					partea3.rellenarA2345(productosAplicar1, formaActuacion1, utilizaMojantes1, zonaCritica1, temperatura1, humedadRelativa1, velocidadViento1, tipoPulverizacion1, pro, form, zon, uti, temp, hum);
					partea3.calcularParteA();
					System.out.println("VolumenAppLHA  "+partea3.VolumenAppLHA);
					Intent a3 = new Intent(A_1_3Activity.this, Resultados1.class);
					a3.putExtra("partea3",partea3);
					startActivity(a3);

				} catch (Exception e) {
					e.printStackTrace();
					int temp = temperatura.getSelectedItemPosition();
					int hum = humedadRelativa.getSelectedItemPosition();
					int vel = velocidadViento.getSelectedItemPosition();
					if(temp == 3 ){
						Toast toast = Toast.makeText(getApplicationContext(), "ERROR: NO SE PUEDE APLICAR EL TRATAMIENTO CON TANTA TEMPERATURA", Toast.LENGTH_SHORT);
						toast.show();
					}else
						if(hum == 3 ){
						Toast toast = Toast.makeText(getApplicationContext(), "ERROR: NO SE PUEDE APLICAR EL TRATAMIENTO CON LLUVIA", Toast.LENGTH_SHORT);
						toast.show();
					}else 
						if(vel == 2 ){
						Toast toast = Toast.makeText(getApplicationContext(), "ERROR: NO SE PUEDE APLICAR EL TRATAMIENTO CON TANTO VIENTO", Toast.LENGTH_SHORT);
						toast.show();}
					else{
					Toast toast = Toast.makeText(getApplicationContext(), "Valor de "+'"'+revisando+'"'+" incorrecto", Toast.LENGTH_SHORT);
					toast.show();
					}
				}

			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(A_1_3Activity.this, AyudaTipoTratamiento.class));
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(A_1_3Activity.this, Indice.class));
				finish();

			}
		});

	}

	@Override
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		
	      int productosAplicarPosition = productosAplicar.getAdapter().getCount();
	      productosAplicarPosition = settings.getInt("productosAplicarSpinner",productosAplicarPosition);
	      productosAplicar.setSelection(productosAplicarPosition);
	      
	      int formaActuacionPosition = formaActuacion.getAdapter().getCount(); 
	      formaActuacionPosition = settings.getInt("formaActuacionSpinner", formaActuacionPosition);
	      formaActuacion.setSelection(formaActuacionPosition);
	      
	      int utilizaMojantesPosition = utilizaMojantes.getAdapter().getCount();
	      utilizaMojantesPosition = settings.getInt("utilizaMojantesSpinner", utilizaMojantesPosition);
	      utilizaMojantes.setSelection(utilizaMojantesPosition);
	      
	      int zonaCriticaPosition = zonaCritica.getAdapter().getCount();
	      zonaCriticaPosition = settings.getInt("zonaCriticaSpinner", zonaCriticaPosition);
	      zonaCritica.setSelection(zonaCriticaPosition);
	      
	      int temperaturaPosition = temperatura.getAdapter().getCount();
	      temperaturaPosition = settings.getInt("temperaturaSpinner", temperaturaPosition);
	      temperatura.setSelection(temperaturaPosition);
	      
	      int humedadRelativaPosition = humedadRelativa.getAdapter().getCount();
	      humedadRelativaPosition = settings.getInt("humedadRelativaSpinner", humedadRelativaPosition);
	      humedadRelativa.setSelection(humedadRelativaPosition);
	      
	      int velocidadVientoPosition = velocidadViento.getAdapter().getCount();
	      velocidadVientoPosition = settings.getInt("velocidadVientoSpinner", velocidadVientoPosition);
	      velocidadViento.setSelection(velocidadVientoPosition);
	      
	      int tipoPulverizacionPosition = tipoPulverizacion.getAdapter().getCount();
	      tipoPulverizacionPosition = settings.getInt("tipoPulverizacionSpinner", tipoPulverizacionPosition);
	      tipoPulverizacion.setSelection(tipoPulverizacionPosition);
	      
	      //System.out.println("Leer: ancho="+settings.getString("anchocalle", "")+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);
		
	}
	
	
	@Override
	protected void onPause(){
		  super.onPause(); 
		  
		  SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
	      SharedPreferences.Editor editor = settings.edit();
	      
	      int productosAplicarPosition = productosAplicar.getSelectedItemPosition();
	      editor.putInt("productosAplicarSpinner", productosAplicarPosition);
	      
	      int formaActuacionPosition = formaActuacion.getSelectedItemPosition();
	      editor.putInt("formaActuacionSpinner", formaActuacionPosition);
	      
	      int utilizaMojantesPosition = utilizaMojantes.getSelectedItemPosition();
	      editor.putInt("utilizaMojantesSpinner", utilizaMojantesPosition);
	      
	      int zonaCriticaPosition = zonaCritica.getSelectedItemPosition();
	      editor.putInt("zonaCriticaSpinner", zonaCriticaPosition);
	      
	      int temperaturaPosition = temperatura.getSelectedItemPosition();
	      editor.putInt("temperaturaSpinner", temperaturaPosition);
	      
	      int humedadRelativaPosition = humedadRelativa.getSelectedItemPosition();
	      editor.putInt("humedadRelativaSpinner", humedadRelativaPosition);
	      
	      int velocidadVientoPosition = velocidadViento.getSelectedItemPosition();
	      editor.putInt("velocidadVientoSpinner", velocidadVientoPosition);
	      
	      int tipoPulverizacionPosition = tipoPulverizacion.getSelectedItemPosition();
	      editor.putInt("tipoPulverizacionSpinner", tipoPulverizacionPosition);
	      
	      // Commit the edits!
	      editor.commit();
	      //System.out.println("Escribir: ancho="+anchocalle.getText().toString()+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);

	}
	
	
	public void onSaveInstanceState(Bundle state) {
		super.onSaveInstanceState(state);
		// Save UI state changes to the savedInstanceState.
		// This bundle will be passed to onCreate if the process is
		// killed and restarted.
		super.onSaveInstanceState(state);
		//state.putInt("spinnerIndex", pro);
		
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Restore UI state from the savedInstanceState.
		// This bundle has also been passed to onCreate.
		//Log.v(tag, "Inside of onRestoreInstanceState");
		

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
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}



}
