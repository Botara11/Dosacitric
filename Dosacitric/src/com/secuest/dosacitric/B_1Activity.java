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
import android.widget.TextView;
import android.widget.Toast;

public class B_1Activity extends AppCompatActivity implements
CompoundButton.OnCheckedChangeListener  {

	private int debug = 0;
	private DecimalFormat df;
	private TextView volumenAplicacionCalculado;
	private EditText editVolumen;
	private TextView anchoTrabajoCalculado;
	private EditText editAncho;
	private EditText velocidadAvance;
	private TextView caudalTotal;
	private TextView caudalSector;
	private EditText editBoquillas;
	private ParteB pb;
	public static final String PREFS_NAME = "Guarda";


	public void actualizarCaudal() {
		try {
			float b = Float.parseFloat(editVolumen.getText().toString());
			float c = Float.parseFloat(editAncho.getText().toString());
			float a = Float.parseFloat(velocidadAvance.getText().toString());

			df = new DecimalFormat();
			df.setMaximumFractionDigits(1);

			caudalTotal.setText(df.format(a * b * c / 0.6));
			caudalSector.setText(df.format((a * b * c / 0.6) / 2));
		} catch (Exception e) {
			caudalTotal.setText("0.0");
			caudalSector.setText("0.0");
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_1);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		pb = new ParteB();

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		String VolumenApp = settings.getString("volumenApp", "");
		String AnchoTrabajo = settings.getString("anchocalle", "");

		volumenAplicacionCalculado = (TextView) findViewById(R.id.textViewVolumenAplicacionCalculado);
		volumenAplicacionCalculado.setText(VolumenApp);

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

		anchoTrabajoCalculado = (TextView) findViewById(R.id.textViewAnchoTrabajoCalculado);
		anchoTrabajoCalculado.setText(AnchoTrabajo);

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

		velocidadAvance = (EditText) findViewById(R.id.velocidadAvance);
		velocidadAvance.setText("0.0");
		velocidadAvance.addTextChangedListener(new TextWatcher() {

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
		
		caudalTotal = (TextView) findViewById(R.id.textView15);
		caudalSector = (TextView) findViewById(R.id.textView16);
		editBoquillas = (EditText) findViewById(R.id.editText4);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String revisando = "";
				String reemplazado = "";
				try {

					revisando = "Volumen de aplicación deseado";
					reemplazado = editVolumen.getText().toString().replace(',', '.');
					float volumenDeseado = (float) Double.parseDouble(reemplazado);
					if(volumenDeseado <=0){					
						reemplazado = "Volumen de aplicación deseado";
						Float.parseFloat("h");
					}

					revisando = "Ancho de trabajo deseado";
					reemplazado = editAncho.getText().toString().replace(',', '.');
					float anchoDeseado = (float) Double.parseDouble(reemplazado);
					if(anchoDeseado <=0){					
						reemplazado = "Ancho de trabajo deseado";
						Float.parseFloat("h");
					}

					revisando = "Velocidad de avance deseada ";
					reemplazado = velocidadAvance.getText().toString().replace(',', '.');
					float velAvance = (float) Double.parseDouble(reemplazado);
					if (velAvance < 1 || velAvance > 6){					
						reemplazado = "Velocidad de avance deseada ";
						Float.parseFloat("h");
					}

					revisando = "Numero de boquillas";
					int boq = Integer.parseInt(editBoquillas.getText()
							.toString());

					pb.rellenarB1(volumenDeseado, anchoDeseado, velAvance, (float) 0.0, (float) 0.0, boq);
					Intent b1 = new Intent(B_1Activity.this, B_2Activity.class);
					b1.putExtra("parteb1", pb);
					startActivity(b1);
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
