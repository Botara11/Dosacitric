package com.secuest.dosacitric;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class C_1Activity extends ActionBarActivity implements
CompoundButton.OnCheckedChangeListener{

	private TextView anchoTrabajoCalculado;
	private EditText anchoTrabajoDeseado;
	private Switch SwitchAnchoTrabajoCalculado;
	private Switch SwitchAnchoTrabajoDeseado;
	private EditText zonaAlta;
	private EditText zonaMedia;
	private EditText zonaBaja;	
	private TextView velocidadAvanceCalculada;
	private EditText velocidadAvanceDeseada;
	private Switch SwitchVelocidadAvanceCalculada;
	private Switch SwitchVelocidadAvanceDeseada;
	private ParteC partec1;
	public static final String PREFS_NAME = "Guarda";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_1);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		anchoTrabajoDeseado = (EditText) findViewById(R.id.anchoCalculadoParteC);
		anchoTrabajoDeseado.setText("0.0");
		anchoTrabajoDeseado.addTextChangedListener(new TextWatcher() {

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

		velocidadAvanceDeseada = (EditText) findViewById(R.id.editText1);
		velocidadAvanceDeseada.setText("0.0");
		velocidadAvanceDeseada.addTextChangedListener(new TextWatcher() {

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

		anchoTrabajoCalculado = (TextView) findViewById(R.id.anchoCalleParteC);
		anchoTrabajoDeseado = (EditText) findViewById(R.id.anchoCalculadoParteC);
		SwitchAnchoTrabajoCalculado = (Switch) findViewById(R.id.switchAnchoTrabajoCalculado);
		SwitchAnchoTrabajoCalculado.setOnCheckedChangeListener(this);
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		String ancho = settings.getString("anchocalle","");
		anchoTrabajoCalculado.setText(ancho);


		SwitchAnchoTrabajoCalculado.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(SwitchAnchoTrabajoCalculado.isChecked() == true){
					SwitchAnchoTrabajoDeseado.setChecked(false);
				}else{

					SwitchAnchoTrabajoDeseado.setChecked(true);
				}

			}
		});

		SwitchAnchoTrabajoDeseado = (Switch) findViewById(R.id.switchAnchoTrabajoDeseado);
		SwitchAnchoTrabajoDeseado.setOnCheckedChangeListener(this);
		SwitchAnchoTrabajoDeseado.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(SwitchAnchoTrabajoDeseado.isChecked() == true){
					SwitchAnchoTrabajoCalculado.setChecked(false);
				}else{
					SwitchAnchoTrabajoCalculado.setChecked(true);
				}

			}
		});
		if (ancho==""){
			SwitchAnchoTrabajoCalculado.setChecked(false);
			SwitchAnchoTrabajoDeseado.setChecked(true);
		}else{
			SwitchAnchoTrabajoCalculado.setChecked(true);
			SwitchAnchoTrabajoDeseado.setChecked(false);
		}


		zonaAlta = (EditText) findViewById(R.id.textoZonaAlta);
		zonaMedia = (EditText) findViewById(R.id.textoZonaMedia);
		zonaBaja = (EditText) findViewById(R.id.textoZonaBaja);
		velocidadAvanceCalculada = (TextView) findViewById(R.id.velocidadAvance);
		velocidadAvanceDeseada = (EditText) findViewById(R.id.editText1);
		SwitchVelocidadAvanceCalculada = (Switch) findViewById(R.id.switchVelocidadAvanceCalculada);

		settings = getSharedPreferences(PREFS_NAME, 0);
		String velocidadAvance = settings.getString("velocidadAvance","");
		velocidadAvanceCalculada.setText(velocidadAvance);


		SwitchVelocidadAvanceCalculada.setOnCheckedChangeListener(this);
		SwitchVelocidadAvanceCalculada.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(SwitchVelocidadAvanceCalculada.isChecked() == true){
					SwitchVelocidadAvanceDeseada.setChecked(false);
				}else{
					SwitchVelocidadAvanceDeseada.setChecked(true);
				}
			}
		});

		SwitchVelocidadAvanceDeseada = (Switch) findViewById(R.id.switchVelocidadAvanceDeseada);
		SwitchVelocidadAvanceDeseada.setOnCheckedChangeListener(this);
		SwitchVelocidadAvanceDeseada.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(SwitchVelocidadAvanceDeseada.isChecked() == true){
					SwitchVelocidadAvanceCalculada.setChecked(false);
				}else{
					SwitchVelocidadAvanceCalculada.setChecked(true);
				}
			}
		});
		if (velocidadAvance==""){
			SwitchVelocidadAvanceCalculada.setChecked(false);
			SwitchVelocidadAvanceDeseada.setChecked(true);
		}else{
			SwitchVelocidadAvanceCalculada.setChecked(true);
			SwitchVelocidadAvanceDeseada.setChecked(false);
		}
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

					if (SwitchAnchoTrabajoCalculado.isChecked()) {
						quien = "Ancho de la calle calculado";
						ancho = Float.parseFloat(anchoTrabajoCalculado.getText()
								.toString());
					} else {
						quien = "Ancho de la calle deseado";
						ancho = Float
								.parseFloat(anchoTrabajoDeseado.getText().toString());
					}

					if (SwitchVelocidadAvanceCalculada.isChecked()) {
						quien = "Velocidad de avance calculada";
						velocidad = Float.parseFloat(velocidadAvanceCalculada
								.getText().toString());
					} else {
						quien = "Velocidad de avance deseada";
						velocidad = Float
								.parseFloat(velocidadAvanceDeseada.getText().toString());
					}

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
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.switchAnchoTrabajoCalculado:
			Log.i("switch_compat", isChecked + "");
			break;
		case R.id.switchAnchoTrabajoDeseado:
			Log.i("switch_compat2", isChecked + "");
			break;
		}

	}

}
