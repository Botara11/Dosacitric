package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.List;

import com.secuest.dosacitric.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class A_1_1Activity extends AppCompatActivity{

	private Spinner densidadFoliar;
	private EditText anchocalle;
	private EditText distancia;
	private EditText longitudArb;
	private EditText anchuraArb;
	private EditText alturaArb;
	private Spinner formaArb;
	private Spinner fechaUltima;
	private Spinner gradoPoda;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1_1);

		//Funciona

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		densidadFoliar = (Spinner) findViewById(R.id.densidadFoliar);
		anchocalle = (EditText) findViewById(R.id.anchocalle);
		distancia = (EditText) findViewById(R.id.distancia);
		longitudArb = (EditText) findViewById(R.id.longitudArb);
		anchuraArb = (EditText) findViewById(R.id.anchuraArb);
		alturaArb = (EditText) findViewById(R.id.alturaArb);
		formaArb = (Spinner) findViewById(R.id.formaArb);
		fechaUltima = (Spinner) findViewById(R.id.fechaultima);
		gradoPoda = (Spinner) findViewById(R.id.gradoPoda);

		ArrayList<String> lista0 = new ArrayList<String>();
		lista0.add("Esférica (globo)");
		lista0.add("Seto");
		lista0.add("Seleccionar");
		ArrayAdapterMio<String> adaptador0 = new ArrayAdapterMio<String>(this, 
				R.layout.spinner_item, lista0);
		adaptador0.setDropDownViewResource(R.layout.spinner_item);
		formaArb.setAdapter(adaptador0);
		formaArb.setSelection(adaptador0.getCount());

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

				try {

					revisando = "Densidad foliar del árbol";
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

					/*revisando = "Altura de la Meseta";
					reemplazado = alturaMeseta.getText().toString().replace(',', '.');
					float alturaMeseta1 = (float) Double.parseDouble(reemplazado);*/

					revisando = "Forma del arbol";
					float formaArb1 = (float) 999.999;
					int form = formaArb.getSelectedItemPosition();
					switch(form){

					case 0: formaArb1=(float) 1.00;
					break;
					case 1: formaArb1=(float) 1.00;
					break;
					case 2:  Double.parseDouble("p");
					break;
					}

					revisando = "Fecha última poda";
					float fechaUltima1 = (float) 999.999;
					int fech = fechaUltima.getSelectedItemPosition();
					switch(fech){

					case 0: fechaUltima1=(float) 0.95;
					break;
					case 1: fechaUltima1=(float) 1.00;
					break;
					case 2: fechaUltima1=(float) 1.075;
					break;
					case 3: fechaUltima1=(float) 1.15;
					break;
					case 4:  Double.parseDouble("p");
					break;
					}

					revisando = "Grado de la poda";
					float gradoPoda1 = (float) 999.999;
					int gra = gradoPoda.getSelectedItemPosition();
					switch(gra){

					case 0: gradoPoda1=(float) 1.05;
					break;
					case 1: gradoPoda1=(float) 1.00;
					break;
					case 2: gradoPoda1=(float) 0.95;
					break;
					case 3:  Double.parseDouble("p");
					break;
					}

					Intent a = getIntent();
					ParteA nuevo = (ParteA) a.getSerializableExtra("partea");
					if(nuevo== null){
						nuevo = new ParteA();
						System.out.println("ParteA NULL");
					}
					nuevo.rellenarA1(densidadFoliar1, anchocalle1, distancia1, longitudArb1, anchuraArb1, alturaArb1, den,/*alturaMeseta1,*/formaArb1, fechaUltima1, gradoPoda1, form, gra, fech);
					Intent a1 = new Intent(A_1_1Activity.this,A_1_3Activity.class);
					a1.putExtra("partea1",nuevo);
					startActivity(a1);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
					Toast toast = Toast.makeText(getApplicationContext(), "Valor de "+'"'+revisando+'"'+" incorrecto", Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(A_1_1Activity.this, Indice.class));
				finish();
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(A_1_1Activity.this, AyudaA_1_1Activity.class));
			}
		});

		densidadFoliar = (Spinner) findViewById(R.id.densidadFoliar);

		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Baja");
		lista.add("Media");
		lista.add("Alta");
		lista.add("Seleccionar");
		ArrayAdapterMio<String> adaptador = new ArrayAdapterMio<String>(this, 
				//android.R.layout.simple_spinner_dropdown_item, lista);
				R.layout.spinner_item, lista);
		adaptador.setDropDownViewResource(R.layout.spinner_item);
		densidadFoliar.setAdapter(adaptador);
		//genero.setSelection(adaptador.getCount());
		densidadFoliar.setSelection(adaptador.getCount());
	}

	@SuppressWarnings("hiding")
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
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		int selectedPosition= densidadFoliar.getAdapter().getCount();
		selectedPosition = settings.getInt("selectedPosition",selectedPosition);
		densidadFoliar.setSelection(selectedPosition);

		int selectedPosition2 = formaArb.getAdapter().getCount(); 
		selectedPosition2 = settings.getInt("spinnerSelection2", selectedPosition2);
		formaArb.setSelection(selectedPosition2);

		int selectedPosition3 = fechaUltima.getAdapter().getCount();
		selectedPosition3 = settings.getInt("spinnerSelection3", selectedPosition3);
		fechaUltima.setSelection(selectedPosition3);

		int selectedPosition4 = gradoPoda.getAdapter().getCount();
		selectedPosition4 = settings.getInt("spinnerSelection4", selectedPosition4);
		gradoPoda.setSelection(selectedPosition4);

		anchocalle.setText(settings.getString("anchocalle", ""));
		distancia.setText(settings.getString("distanciaArboles", ""));
		longitudArb.setText(settings.getString("longitudArboles", ""));
		anchuraArb.setText(settings.getString("anchuraArboles", ""));
		alturaArb.setText(settings.getString("alturaArboles", ""));

	}

	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		int selectedPosition = densidadFoliar.getSelectedItemPosition();
		editor.putInt("selectedPosition", selectedPosition);
		int selectedPosition2 = formaArb.getSelectedItemPosition();
		editor.putInt("spinnerSelection2", selectedPosition2);
		int selectedPosition3 = fechaUltima.getSelectedItemPosition();
		editor.putInt("spinnerSelection3", selectedPosition3);
		int selectedPosition4 = gradoPoda.getSelectedItemPosition();
		editor.putInt("spinnerSelection4", selectedPosition4);

		editor.putString("anchocalle", anchocalle.getText().toString());
		editor.putString("distanciaArboles", distancia.getText().toString());
		editor.putString("longitudArboles", longitudArb.getText().toString());
		editor.putString("anchuraArboles", anchuraArb.getText().toString());
		editor.putString("alturaArboles", alturaArb.getText().toString());
		editor.commit();

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