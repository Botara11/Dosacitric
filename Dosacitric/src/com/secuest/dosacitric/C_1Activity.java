package com.secuest.dosacitric;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class C_1Activity extends AppCompatActivity implements
CompoundButton.OnCheckedChangeListener{

	private TextView anchoTrabajoCalculado;
	private EditText anchoTrabajoDeseado;
	private EditText zonaAlta;
	private EditText zonaMedia;
	private EditText zonaBaja;
	private EditText velocidadAvanceDeseada;
	private ParteC partec1;
	public static final String PREFS_NAME = "Guarda";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_1);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		anchoTrabajoDeseado = (EditText) findViewById(R.id.anchoCalculadoParteC);
		anchoTrabajoDeseado.setText("0.0");
		anchoTrabajoDeseado.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		velocidadAvanceDeseada = (EditText) findViewById(R.id.editText1);
		velocidadAvanceDeseada.setText("0.0");
		velocidadAvanceDeseada.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		partec1 = new ParteC();

		anchoTrabajoCalculado = (TextView) findViewById(R.id.anchoCalleParteC);
		anchoTrabajoDeseado = (EditText) findViewById(R.id.anchoCalculadoParteC);
		anchoTrabajoDeseado.setText("0.0");

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		String ancho = settings.getString("anchocalle","");
		anchoTrabajoCalculado.setText(ancho);

		zonaAlta = (EditText) findViewById(R.id.textoZonaAlta);
		zonaMedia = (EditText) findViewById(R.id.textoZonaMedia);
		zonaBaja = (EditText) findViewById(R.id.textoZonaBaja);

		velocidadAvanceDeseada = (EditText) findViewById(R.id.editText1);
		velocidadAvanceDeseada.setText("0.0");

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";
				try {
					
					revisando = "Ancho de la calle deseado";
					reemplazado = anchoTrabajoDeseado.getText().toString().replace(',', '.');
					float ancho = (float) Double.parseDouble(reemplazado);
					if(ancho <=0){					
						reemplazado = "Ancho de la calle deseado";
						Float.parseFloat("h");
					}
					
					revisando = "Velocidad de avance deseada";
					reemplazado = velocidadAvanceDeseada.getText().toString().replace(',', '.');
					float velocidad = (float) Double.parseDouble(reemplazado);
					if(velocidad <=0 ){
						reemplazado = "Velocidad de avance deseada";
						Float.parseFloat("h");
					}

					revisando="Zona Alta";
					int zAlta = Integer.parseInt(zonaAlta.getText().toString());
					revisando="Zona Media";
					int zMedia = Integer.parseInt(zonaMedia.getText().toString());
					revisando="Zona Baja";
					int zBaja = Integer.parseInt(zonaBaja.getText().toString());

					int [] zBoquillas = {zAlta,zMedia,zBaja};

					partec1.rellenarC1(ancho, zBoquillas, velocidad);
					Intent c1 = new Intent(C_1Activity.this, C_2Activity.class);
					c1.putExtra("partec1", partec1);
					startActivity(c1);
				} catch (Exception e) {
					e.printStackTrace();
					Toast toast = Toast.makeText(getApplicationContext(),
							"Valor de " + '"' + revisando + '"' + " incorrecto",
							Toast.LENGTH_SHORT);
					toast.show();
				}
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_1Activity.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(C_1Activity.this, AyudaC_1Activity.class));
			}
		});
	}

	@Override
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		anchoTrabajoDeseado.setText(settings.getString("anchoCalleDeseado", ""));
		zonaAlta.setText(settings.getString("zonaAlta", ""));
		zonaMedia.setText(settings.getString("zonaMedia", ""));
		zonaBaja.setText(settings.getString("zonaBaja", ""));
		velocidadAvanceDeseada.setText(settings.getString("velocidadAvanceDeseada", ""));

		//System.out.println("Leer: ancho="+settings.getString("anchocalle", "")+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);

	}

	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("anchoCalleDeseado", anchoTrabajoDeseado.getText().toString());
		editor.putString("zonaAlta", zonaAlta.getText().toString());
		editor.putString("zonaMedia", zonaMedia.getText().toString());
		editor.putString("zonaBaja", zonaBaja.getText().toString());
		editor.putString("velocidadAvanceDeseada", velocidadAvanceDeseada.getText().toString());

		editor.commit();
		//System.out.println("Escribir: ancho="+anchocalle.getText().toString()+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
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

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	}
}
