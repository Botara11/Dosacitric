package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

public class C_1Activity extends Activity {

	private TextView anchoCalle;
	private TextView anchoCalleCalculado;
	private RadioButton RanchoCalle;
	private RadioButton RanchoCalleCalculado;
	private EditText zonaAlta;
	private EditText zonaMedia;
	private EditText zonaBaja;	
	private TextView velocidadAvance;
	private TextView velocidadAvanceCalculado;
	private RadioButton RvelocidadAvance;
	private RadioButton RvelocidadAvanceCalculado;
	private EditText editAncho;
	private EditText editVelocidad;
	private ParteC partec1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_1);
		
		editAncho = (EditText) findViewById(R.id.anchoCalculadoParteC);
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
			}
		});
		
		editVelocidad = (EditText) findViewById(R.id.editText1);
		editVelocidad.setText("0.0");
		editVelocidad.addTextChangedListener(new TextWatcher() {

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
			}
		});
		
		partec1 = new ParteC();

		anchoCalle = (TextView) findViewById(R.id.anchoCalleParteC);
		anchoCalleCalculado = (EditText) findViewById(R.id.anchoCalculadoParteC);
		RanchoCalle= (RadioButton) findViewById(R.id.RAncho1);
		RanchoCalleCalculado = (RadioButton) findViewById(R.id.RAncho2);
		RanchoCalleCalculado.setChecked(true);
		zonaAlta = (EditText) findViewById(R.id.textoZonaAlta);
		zonaMedia = (EditText) findViewById(R.id.textoZonaMedia);
		zonaBaja = (EditText) findViewById(R.id.textoZonaBaja);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvanceCalculado = (EditText) findViewById(R.id.editText1);
		RvelocidadAvance= (RadioButton) findViewById(R.id.RVelocidad1);
		RvelocidadAvanceCalculado = (RadioButton) findViewById(R.id.RVelocidad2);
		RvelocidadAvanceCalculado.setChecked(true);


		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String quien = "";
				try {

					Float ancho, velocidad;
					
					quien="Zona Alta";
					int zAlta = Integer.parseInt(zonaAlta.getText().toString());
					quien="Zona Media";
					int zMedia = Integer.parseInt(zonaMedia.getText().toString());
					quien="Zona Baja";
					int zBaja = Integer.parseInt(zonaBaja.getText().toString());
					
					int [] zBoquillas = {zAlta,zMedia,zBaja};

					if (RanchoCalle.isChecked()) {
						quien = "Ancho de la calle";
						ancho = Float.parseFloat(anchoCalle.getText()
								.toString());
					} else {
						quien = "Ancho de la calle calculado";
						ancho = Float
								.parseFloat(anchoCalleCalculado.getText().toString());
					}

					if (RvelocidadAvance.isChecked()) {
						quien = "Velocidad de avance";
						velocidad = Float.parseFloat(velocidadAvance
								.getText().toString());
					} else {
						quien = "Velocidad de avance calculada";
						velocidad = Float
								.parseFloat(velocidadAvanceCalculado.getText().toString());
					}
					
					String ola ="ParteC1";
					Log.e("didi", ola);
					
					
					partec1.rellenarC1(ancho, zBoquillas, velocidad);
					Intent c1 = new Intent(C_1Activity.this, C_2Activity.class);
					c1.putExtra("partec1", partec1);
					startActivity(c1);
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"Valor de " + '"' + quien + '"' + " incorrecto",
							Toast.LENGTH_SHORT);
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
				//startActivity(new Intent(C_1Activity.this, BoquillasListView.class));
				finish();
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(C_1Activity.this, Indice.class));
			}
		});


	}
}
