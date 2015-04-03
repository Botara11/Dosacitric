package com.secuest.dosacitric;

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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

public class B_2Activity extends Activity{


	private EditText zonaAltaCerradas;
	private EditText zonaBajaCerradas;
	private EditText zonaAltaAbiertas;
	private EditText zonaMediaAbiertas;
	private EditText zonaBajaAbiertas;
	private EditText zonaAltaPorcentaje;
	private EditText zonaMediaPorcentaje;
	private EditText zonaBajaPorcentaje;
	private TextView zonaAltaIntervaloCaudal;
	private TextView zonaMediaIntervaloCaudal;
	private TextView zonaBajaIntervaloCaudal;
	private TextView variacionCaudalTextView;
	private SeekBar variacionCaudalSeekbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_2);
		seebbarr();

		zonaAltaCerradas = (EditText) findViewById(R.id.zonaAltaCerradas);
		zonaBajaCerradas = (EditText) findViewById(R.id.zonaBajaCerradas);
		zonaAltaAbiertas = (EditText) findViewById(R.id.zonaAltaAbiertas);
		zonaMediaAbiertas = (EditText) findViewById(R.id.zonaMediaAbiertas);
		zonaBajaAbiertas = (EditText) findViewById(R.id.zonaBajaAbiertas);
		zonaAltaPorcentaje = (EditText) findViewById(R.id.zonaAltaPorcentaje);
		zonaMediaPorcentaje = (EditText) findViewById(R.id.zonaMediaPorcentanje);
		zonaBajaPorcentaje = (EditText) findViewById(R.id.zonaBajaPorcentaje);
		zonaAltaIntervaloCaudal = (TextView) findViewById(R.id.zonaAltaIntervaloCaudal);
		zonaMediaIntervaloCaudal = (TextView) findViewById(R.id.zonaMediaIntervaloCaudal);
		zonaBajaIntervaloCaudal = (TextView) findViewById(R.id.zonaBajaIntervaloCaudal);
		variacionCaudalTextView = (TextView) findViewById(R.id.variacionCaudalTextView);
		variacionCaudalSeekbar = (SeekBar) findViewById(R.id.variacionCaudalSeekBar);
		
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(B_2Activity.this, Resultados2.class));
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
				startActivity(new Intent(B_2Activity.this, Indice.class));
			}
		});
	}

	public void seebbarr( ){
		variacionCaudalSeekbar = (SeekBar) findViewById(R.id.variacionCaudalSeekBar);
		variacionCaudalTextView = (TextView) findViewById(R.id.variacionCaudalTextView);
		variacionCaudalSeekbar.setProgress(0);
		variacionCaudalSeekbar.incrementProgressBy(1);
		variacionCaudalSeekbar.setMax(5);

		variacionCaudalSeekbar.setOnSeekBarChangeListener(
				new SeekBar.OnSeekBarChangeListener() {

					int progress_value;
					@Override
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						progress_value = progress;
						variacionCaudalTextView.setText("" + progress);
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

