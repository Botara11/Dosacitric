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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class B_1Activity extends Activity{

	private TextView volumenAplicacion;
	private TextView volumenCalculado;
	private RadioButton volumenAplicacionCalculado;
	private RadioButton volumenAplicacionSiguiente;
	private TextView anchoTrabajo;
	private TextView anchoCalculado;
	private RadioButton anchoTrabajoCalculado;
	private RadioButton anchoTrabajoSiguiente;
	private TextView velocidadAvance;
	private SeekBar velocidadAvanceSeekbar;
	private EditText editAncho;
	private EditText editVolumen;
	private EditText editBoquillas;
	private TextView caudalTotal;
	private TextView caudalSector;
	private ParteB pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_1);
		seebbarr();
		

		volumenAplicacion = (TextView) findViewById(R.id.textView2);
		volumenCalculado = (TextView) findViewById(R.id.textView13);
		volumenAplicacionCalculado = (RadioButton) findViewById(R.id.RVolumen1);
		volumenAplicacionSiguiente = (RadioButton) findViewById(R.id.RVolumen2);
		anchoTrabajo = (TextView) findViewById(R.id.TextView01);
		anchoCalculado = (TextView) findViewById(R.id.textView14);
		anchoTrabajoCalculado= (RadioButton) findViewById(R.id.RAncho1);
		anchoTrabajoSiguiente = (RadioButton) findViewById(R.id.RAncho2);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvanceSeekbar = (SeekBar) findViewById(R.id.seekBar1);
		
		
		caudalTotal = (TextView) findViewById(R.id.textView15);
		caudalSector = (TextView) findViewById(R.id.textView16);
		
		editAncho = (EditText) findViewById(R.id.editText1);
		editVolumen = (EditText) findViewById(R.id.editText3);
		editBoquillas = (EditText) findViewById(R.id.editText4);
				

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Float vol, ancho;
				
				if(volumenAplicacionCalculado.isChecked()){
					vol = Float.parseFloat(volumenCalculado.toString());
				}else{
					vol = Float.parseFloat(editVolumen.toString());
				}
				
				if(anchoTrabajoCalculado.isChecked()){
					ancho = Float.parseFloat(anchoTrabajoCalculado.toString());
				}else{
					ancho = Float.parseFloat(editAncho.toString());
				}
				
				pb.rellenarB1(vol,ancho,
						Float.parseFloat(velocidadAvance.toString()),
						
						Float.parseFloat(caudalTotal.toString()),
						Float.parseFloat(caudalSector.toString()),
						
						Integer.parseInt(editBoquillas.toString()));
				Intent a3 = new Intent(B_1Activity.this, B_2Activity.class);
				a3.putExtra("parteb1",pb);
				startActivity(a3);
			}
		});


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
				startActivity(new Intent(B_1Activity.this, Indice.class));
			}
		});
	}

	public void seebbarr( ){
		velocidadAvanceSeekbar = (SeekBar) findViewById(R.id.seekBar1);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvanceSeekbar.setProgress(2);
		velocidadAvanceSeekbar.incrementProgressBy(2);
		velocidadAvanceSeekbar.setMax(6);

		velocidadAvanceSeekbar.setOnSeekBarChangeListener(
				new SeekBar.OnSeekBarChangeListener() {

					int progress_value;
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						progress_value = progress;
						velocidadAvance.setText("" + progress);
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
					}

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
					}
				}
				);

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

