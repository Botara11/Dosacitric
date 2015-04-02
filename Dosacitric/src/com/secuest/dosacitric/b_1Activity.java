package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class b_1Activity extends Activity{

	private TextView volumenAplicacion;
	private RadioButton volumenAplicacionCalculado;
	private RadioButton volumenAplicacionSiguiente;
	private TextView anchoTrabajo;
	private RadioButton anchoTrabajoCalculado;
	private RadioButton anchoTrabajoSiguiente;
	private TextView velocidadAvance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partebb);

		volumenAplicacion = (TextView) findViewById(R.id.textView2);
		volumenAplicacionCalculado = (RadioButton) findViewById(R.id.textView1);
		volumenAplicacionSiguiente = (RadioButton) findViewById(R.id.textView10);
		anchoTrabajo = (TextView) findViewById(R.id.TextView01);
		anchoTrabajoCalculado= (RadioButton) findViewById(R.id.RadioButton02);
		anchoTrabajoSiguiente = (RadioButton) findViewById(R.id.RadioButton01);
		velocidadAvance = (TextView) findViewById(R.id.TextView03);



		/*volumenAplicacionCalculado.setChecked(true);
		volumenAplicacionSiguiente.setChecked(false);

		anchoTrabajoCalculado.setChecked(true);
		anchoTrabajoSiguiente.setChecked(false);*/

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
				startActivity(new Intent(b_1Activity.this, Indice.class));
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

