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

public class A_1Activity extends Activity{

	private EditText fecha;
	private EditText idparcela;
	private EditText idtratamiento;
	private EditText referencia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_1);

		fecha = (EditText) findViewById(R.id.fecha);
		idparcela = (EditText) findViewById(R.id.idParcela);
		idtratamiento = (EditText) findViewById(R.id.idTratamiento);
		referencia = (EditText) findViewById(R.id.referencia);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";

				try {

					revisando = "Fecha";
					reemplazado = fecha.getText().toString().replace(',', '.');
					float fecha1 = (float) Double.parseDouble(reemplazado);

					revisando = "Identificación de parcela";
					reemplazado = idparcela.getText().toString().replace(',', '.');
					float idparcela1 = (float) Double.parseDouble(reemplazado);

					revisando = "Identificación del tratamiento";
					reemplazado = idtratamiento.getText().toString().replace(',', '.');
					float idtratamiento1 = (float) Double.parseDouble(reemplazado);

					revisando = "Referencia";
					reemplazado = referencia.getText().toString().replace(',', '.');
					float referencia1 = (float) Double.parseDouble(reemplazado);

					ParteA nuevoA = new ParteA();

					nuevoA.rellenarA(fecha1, idparcela1, idtratamiento1, referencia1);
					Intent a = new Intent(A_1Activity.this,A_1_1Activity.class);
					a.putExtra("partea",nuevoA);
					startActivity(a);

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
				startActivity(new Intent(A_1Activity.this, Indice.class));
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
