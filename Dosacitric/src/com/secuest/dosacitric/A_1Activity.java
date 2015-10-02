package com.secuest.dosacitric;

import java.security.Guard;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class A_1Activity extends ActionBarActivity{

	private int debug = 0;
	private TextView fecha;
	private EditText idparcela;
	private EditText idtratamiento;
	private EditText referencia;

	private int year;
	private int month;
	private int day;

	static final int DATE_PICKER_ID = 1111; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1);

		Context guarda = getApplicationContext();
		SharedPreferences preferencias = guarda.getSharedPreferences("Guarda", Context.MODE_PRIVATE);		

		fecha = (TextView) findViewById(R.id.fecha);
		idparcela = (EditText) findViewById(R.id.idParcela);
		idtratamiento = (EditText) findViewById(R.id.idTratamiento);
		referencia = (EditText) findViewById(R.id.referencia);

		if (debug==1){
			//fecha.setText("6");
			idparcela.setText("6");
			idtratamiento.setText("6");
			referencia.setText("6");
		}

		final Calendar c = Calendar.getInstance();
		year  = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day   = c.get(Calendar.DAY_OF_MONTH);


		fecha.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// On button click show datepicker dialog 
				showDialog(DATE_PICKER_ID);
			}
		});

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";

				try {

					revisando = "Fecha";
					if (fecha.getText().toString().compareTo("")==0){
						Double.parseDouble("peta");
					}

					revisando = "Identificación de parcela";
					reemplazado = idparcela.getText().toString().replace(',', '.');
					String idparcela1 = reemplazado;

					revisando = "Identificación del tratamiento";
					reemplazado = idtratamiento.getText().toString().replace(',', '.');
					String idtratamiento1 = reemplazado;

					revisando = "Referencia";
					reemplazado = referencia.getText().toString().replace(',', '.');
					String referencia1 = reemplazado;

					ParteA nuevoA = new ParteA();

					nuevoA.rellenarA(day,month,year, idparcela1, idtratamiento1, referencia1);
					Intent a = new Intent(A_1Activity.this,A_1_1Activity.class);
					a.putExtra("partea",nuevoA);
					startActivity(a);

					Log.e("didi", String.valueOf(nuevoA.day));
					Log.e("didi", String.valueOf(nuevoA.month));
					Log.e("didi", String.valueOf(nuevoA.year));
					Log.e("didi", nuevoA.idParcela);
					Log.e("didi", nuevoA.idTratamiento);
					Log.e("didi", nuevoA.Referencia);


				} catch (Exception e) {
					e.printStackTrace();
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
				System.out.println("CLICK");
				startActivity(new Intent(A_1Activity.this, Indice.class));
			}
		});

		/*Intent RegresoA_1_1 = getIntent();
		ParteA objetoRegresoA_1_1 = (ParteA) 
				RegresoA_1_1.getSerializableExtra("parteA");
		if(objetoRegresoA_1_1 != null){
			//asignar a cada editText el valor que tenia

			TextView msgto = (TextView)findViewById(R.id.idParcela);
			msgto.setText(objetoRegresoA_1_1.idParcela);

			TextView msgto2 = (TextView)findViewById(R.id.idTratamiento);
			msgto2.setText(objetoRegresoA_1_1.idTratamiento);

			TextView msgto3 = (TextView)findViewById(R.id.referencia);
			msgto3.setText(objetoRegresoA_1_1.Referencia);

			//TextView msgto4 = (TextView)findViewById(R.id.fecha);
			//msgto.setText(objetoRegresoA_1_1.day);


			//objetoRegresoA_1_1.idParcela.setText("text you want to display");


			Intent Aprincipal = new Intent(A_1Activity.this, A_1_1Activity.class);
			Aprincipal.putExtra("PartePrincipal",objetoRegresoA_1_1);
			startActivity(Aprincipal);
		}

		//objetoRegresoA_1_1.rellenarA1(densidadFoliarAtras, anchocalleAtras, distanciaArbAtras, longitudArbAtras, anchuraArbAtras, alturaArbAtras, /*alturaMeseta1,*///formaArbAtras, fechaUltimaAtras, gradoPodaAtras/*, formAtras, gradAtras, fechAtras*/);
		//Intent A_1 = new Intent(A_1Activity.this,A_1_1Activity.class);
		//A_1.putExtra("parteIdir",objetoRegresoA_1_1);
		//startActivity(A_1);

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
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		fecha.setText(settings.getString("fecha", ""));
		idparcela.setText(settings.getString("idparcela", ""));
		idtratamiento.setText(settings.getString("idtratamiento", ""));
		referencia.setText(settings.getString("referencia", ""));

		//System.out.println("Leer: ancho="+settings.getString("anchocalle", "")+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);

	}


	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("fecha", fecha.getText().toString());
		editor.putString("idparcela", idparcela.getText().toString());
		editor.putString("idtratamiento", idtratamiento.getText().toString());
		editor.putString("referencia", referencia.getText().toString());

		// Commit the edits!
		editor.commit();
		//System.out.println("Escribir: ancho="+anchocalle.getText().toString()+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);

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
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_PICKER_ID:

			// open datepicker dialog. 
			// set date picker for current date 
			// add pickerListener listner to date picker
			return new DatePickerDialog(this, pickerListener, year, month,day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {

			year  = selectedYear;
			month = selectedMonth;
			day   = selectedDay;

			// Show selected date 
			fecha.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};

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
