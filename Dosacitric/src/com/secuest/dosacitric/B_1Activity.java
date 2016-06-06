package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class B_1Activity extends AppCompatActivity implements
CompoundButton.OnCheckedChangeListener  {

	private int debug = 1;
	private TextView volumenAplicacionCalculado;
	private Switch SwitchvolumenAplicacionCalculado;
	private TextView anchoTrabajoCalculado;
	private Switch SwitchAnchoTrabajoCalculado;
	private EditText velocidadAvance;
	private EditText editAncho;
	private EditText editVolumen;
	private EditText editBoquillas;
	private TextView caudalTotal;
	private TextView caudalSector;
	private ParteB pb;
	public static final String PREFS_NAME = "Guarda";


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
		//seebbarr();

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		pb = new ParteB();

		volumenAplicacionCalculado = (TextView) findViewById(R.id.textViewVolumenAplicacionCalculado);
		SwitchvolumenAplicacionCalculado = (Switch) findViewById(R.id.switchVolumenAplicacionCalculado);

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		String VolumenApp = settings.getString("volumenApp", "");
		
		volumenAplicacionCalculado.setText(VolumenApp);

		SwitchvolumenAplicacionCalculado.setOnCheckedChangeListener(this);
		SwitchvolumenAplicacionCalculado.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				actualizarCaudal();
			}
		});

		if (VolumenApp==""){
			SwitchvolumenAplicacionCalculado.setChecked(false);
		}

		anchoTrabajoCalculado = (TextView) findViewById(R.id.textViewAnchoTrabajoCalculado);
		SwitchAnchoTrabajoCalculado= (Switch) findViewById(R.id.switchAnchoTrabajoCalculado);

		String AnchoTrabajo = settings.getString("anchocalle", "");

		anchoTrabajoCalculado.setText(AnchoTrabajo);
		
		SwitchAnchoTrabajoCalculado.setOnCheckedChangeListener(this);
		SwitchAnchoTrabajoCalculado.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				actualizarCaudal();
			}
		});

		if (AnchoTrabajo==""){
			SwitchAnchoTrabajoCalculado.setChecked(false);
		}

		velocidadAvance = (EditText) findViewById(R.id.velocidadAvance);
		
		caudalTotal = (TextView) findViewById(R.id.textView15);
		caudalSector = (TextView) findViewById(R.id.textView16);

		editAncho = (EditText) findViewById(R.id.editTextAnchoTrabajoDesesado);
		editAncho.setText("0.0");
		editAncho.addTextChangedListener(new TextWatcher() {

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
				actualizarCaudal();
			}
		});
		editVolumen = (EditText) findViewById(R.id.editTextVolumenAplicacionDeseado);
		editVolumen.setText("0.0");
		editVolumen.addTextChangedListener(new TextWatcher() {

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

					if (SwitchvolumenAplicacionCalculado.isChecked()) {
						quien = "Volumen de aplicación calculado";
						vol = Float.parseFloat(volumenAplicacionCalculado.getText()
								.toString());
					} else {
						quien = "Volumen de aplicación deseado";
						vol = Float
								.parseFloat(editVolumen.getText().toString());
					}

					if (SwitchAnchoTrabajoCalculado.isChecked()) {
						quien = "Ancho de trabajo calculado";
						ancho = Float.parseFloat(anchoTrabajoCalculado
								.getText().toString());
					} else {
						quien = "Ancho de trabajo deseado";
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

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(B_1Activity.this, Indice.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(B_1Activity.this, AyudaB_1Activity.class));
			}
		});

		/********************** TEST **********************/
		if(debug==1){
			editVolumen.setText("1100");
			editAncho.setText("5.0");
			velocidadAvance.setText("1.80");
			editBoquillas.setText("24");
		}
		/********************** TEST **********************/

	}

	/*public void seebbarr() {
		velocidadAvanceSeekbar = (SeekBar) findViewById(R.id.seekBar1);
		velocidadAvance = (TextView) findViewById(R.id.velocidadAvance);

		velocidadAvance.setFocusable(true);
		velocidadAvance.setFocusableInTouchMode(true);

		velocidadAvanceSeekbar.setProgress(1);
		velocidadAvanceSeekbar.incrementProgressBy(1);
		velocidadAvanceSeekbar.setMax(502);

		velocidadAvanceSeekbar
		.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			float progress_value;

			@Override
			public void onProgressChanged(SeekBar seekBar,
					int progress, boolean fromUser) {
				actualizarCaudal();
				progress_value = (float) progress;
				velocidadAvance.setText(""
						+ (float) ((progress_value + 99) / 100));
				actualizarCaudal();
				velocidadAvance.requestFocus();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
	}*/

	@SuppressWarnings({ "unused", "hiding" })
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
	protected void onResume(){
		super.onResume();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		editVolumen.setText(settings.getString("volumenCalculado", ""));
		editAncho.setText(settings.getString("anchoCalculado", ""));
		velocidadAvance.setText(settings.getString("velocidadAvance", ""));
		caudalTotal.setText(settings.getString("caudalTotal", ""));
		caudalSector.setText(settings.getString("caudalSector", ""));
		editBoquillas.setText(settings.getString("editBoquillas", ""));

	}

	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("volumenCalculado", editVolumen.getText().toString());
		editor.putString("anchoCalculado", editAncho.getText().toString());
		editor.putString("velocidadAvance", velocidadAvance.getText().toString());
		editor.putString("caudalTotal", caudalTotal.getText().toString());
		editor.putString("caudalSector", caudalSector.getText().toString());
		editor.putString("editBoquillas", editBoquillas.getText().toString());
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

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	}
}
