package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class B_1Activity extends ActionBarActivity {

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

	public void actualizarCaudal() {
		try {
			float a = Float.parseFloat(velocidadAvance.getText().toString());
			float b = Float.parseFloat(editVolumen.getText().toString());
			float c = Float.parseFloat(editAncho.getText().toString());
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			caudalTotal.setText(df.format(a * b * c / 0.6));
			caudalSector.setText(df.format((a * b * c / 0.6) / 2));
		} catch (Exception e) {
			caudalTotal.setText("0.0");
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_1);
		seebbarr();

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		pb = new ParteB();

		volumenAplicacion = (TextView) findViewById(R.id.textView2);
		volumenCalculado = (TextView) findViewById(R.id.textView13);
		volumenAplicacionCalculado = (RadioButton) findViewById(R.id.RVolumen1);
		volumenAplicacionSiguiente = (RadioButton) findViewById(R.id.RVolumen2);
		volumenAplicacionSiguiente.setChecked(true);
		anchoTrabajo = (TextView) findViewById(R.id.TextView01);
		anchoCalculado = (TextView) findViewById(R.id.textView14);
		anchoTrabajoCalculado = (RadioButton) findViewById(R.id.RAncho1);
		anchoTrabajoSiguiente = (RadioButton) findViewById(R.id.RAncho2);
		anchoTrabajoSiguiente.setChecked(true);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvance.setText("0.99");
		velocidadAvanceSeekbar = (SeekBar) findViewById(R.id.seekBar1);

		caudalTotal = (TextView) findViewById(R.id.textView15);
		caudalSector = (TextView) findViewById(R.id.textView16);

		editAncho = (EditText) findViewById(R.id.editText1);
		editAncho.setText("0.0");
		editAncho.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				actualizarCaudal();
			}
		});
		editVolumen = (EditText) findViewById(R.id.editText3);
		editVolumen.setText("0.0");
		editVolumen.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				actualizarCaudal();
			}
		});
		editBoquillas = (EditText) findViewById(R.id.editText4);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String quien = "";
				try {

					Float vol, ancho;

					if (volumenAplicacionCalculado.isChecked()) {
						quien = "volumenAplicacionCalculado";
						vol = Float.parseFloat(volumenCalculado.getText()
								.toString());
					} else {
						quien = "volumenAplicacionSiguiente";
						vol = Float
								.parseFloat(editVolumen.getText().toString());
					}

					if (anchoTrabajoCalculado.isChecked()) {
						quien = "anchoTrabajoCalculado";
						ancho = Float.parseFloat(anchoTrabajoCalculado
								.getText().toString());
					} else {
						quien = "anchoTrabajoSiguiente";
						ancho = Float
								.parseFloat(editAncho.getText().toString());
					}
					quien = "Numero de boquillas";
					int boq = Integer.parseInt(editBoquillas.getText()
							.toString());

					pb.rellenarB1(vol, ancho, Float.parseFloat(velocidadAvance
							.getText().toString()), (float) 0.0, (float) 0.0,
							// Float.parseFloat(caudalTotal.getText().toString()),
							// Float.parseFloat(caudalSector.getText().toString()),
							boq);
					Intent b1 = new Intent(B_1Activity.this, B_2Activity.class);
					b1.putExtra("parteb1", pb);
					startActivity(b1);
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"Valor de " + '"' + quien + '"' + " incorrecto",
							Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		/*
		 * volumenAplicacionCalculado.setChecked(true);
		 * volumenAplicacionSiguiente.setChecked(false);
		 * 
		 * anchoTrabajoCalculado.setChecked(true);
		 * anchoTrabajoSiguiente.setChecked(false);
		 */

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(B_1Activity.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(B_1Activity.this, AyudaTipoTratamiento.class));
			}
		});

		/********************** TEST **********************/
		editVolumen.setText("1100");
		editAncho.setText("5.0");
		velocidadAvance.setText("1.80");
		editBoquillas.setText("24");

		/********************** TEST **********************/

	}

	public void seebbarr() {
		velocidadAvanceSeekbar = (SeekBar) findViewById(R.id.seekBar1);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvanceSeekbar.setProgress(1);
		velocidadAvanceSeekbar.incrementProgressBy(1);
		velocidadAvanceSeekbar.setMax(502);

		velocidadAvanceSeekbar
		.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			float progress_value;

			@Override
			public void onProgressChanged(SeekBar seekBar,
					int progress, boolean fromUser) {
				progress_value = (float) progress;
				velocidadAvance.setText(""
						+ (float) ((progress_value + 99) / 100));
				actualizarCaudal();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
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
				((TextView) v.findViewById(R.id.text1)).setText("");
				((TextView) v.findViewById(R.id.text1))
				.setHint((CharSequence) getItem(getCount())); // "Hint to be displayed"
			}
			return v;
		}

		@Override
		public int getCount() {
			return super.getCount() - 1; // you dont display last item. It is
			// used as hint.
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
