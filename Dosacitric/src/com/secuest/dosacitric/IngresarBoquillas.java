package com.secuest.dosacitric;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngresarBoquillas extends AppCompatActivity {

	private EditText ireferencia;
	private EditText caudal;
	private EditText presion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingresar_boquillas);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		ireferencia = (EditText) findViewById(R.id.editText2);
		caudal = (EditText) findViewById(R.id.editText4);
		presion = (EditText) findViewById(R.id.editText3);

		Button siguiente = (Button) findViewById(R.id.botonIngresar);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				String reemplazado = "";
				String quien = "";
				int existe = 0;
				try{
					quien="Caudal";
					reemplazado = caudal.getText().toString().replace(',', '.');
					Double dob_caudal = Double.parseDouble(reemplazado);
					quien="Presion";
					reemplazado = presion.getText().toString().replace(',', '.');
					Double dob_presion = Double.parseDouble(reemplazado);

					DatabaseHandler db = new DatabaseHandler(getApplicationContext());

					existe = db.existeBoquillaMisBoquillas(ireferencia.getText().toString());
					if (existe != 0){
						@SuppressWarnings("unused")
						Double auxialiar = Double.parseDouble("");
					}
					double k = dob_caudal/java.lang.Math.pow(dob_presion,0.5);
					db.addBoquillaMisBoqui(ireferencia.getText().toString(),0.0,(double)dob_caudal,
							k*java.lang.Math.pow(6.0,0.5),
							k*java.lang.Math.pow(7.0,0.5),
							k*java.lang.Math.pow(8.0,0.5),
							k*java.lang.Math.pow(9.0,0.5),
							k*java.lang.Math.pow(10.0,0.5),
							k*java.lang.Math.pow(11.0,0.5),
							k*java.lang.Math.pow(12.0,0.5),
							k*java.lang.Math.pow(13.0,0.5),
							k*java.lang.Math.pow(14.0,0.5),
							k*java.lang.Math.pow(15.0,0.5),
							k*java.lang.Math.pow(16.0,0.5),
							1);
					db.addBoquillaValoresInsertados(ireferencia.getText().toString(), dob_caudal, dob_presion);
					//db.mostrarTodo("MIS BOQUILLAS");
					Toast toast = Toast.makeText(getApplicationContext(), "Boquilla ingresada correctamente", Toast.LENGTH_SHORT);
					toast.show();
					finish();

				} catch (Exception e) {
					e.printStackTrace();
					Toast toast;
					if (existe == 0)
						toast = Toast.makeText(getApplicationContext(), "Valor de "+'"'+quien+'"'+" incorrecto", Toast.LENGTH_SHORT);
					else
						toast = Toast.makeText(getApplicationContext(), "La referencia ya existe en la base de datos", Toast.LENGTH_SHORT);
					
						
					toast.show();
				}
			}
		});
	}

	@Override
	protected void onResume(){
		super.onResume();

	}

	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("referencia", ireferencia.getText().toString());
		editor.putString("caudal", caudal.getText().toString());
		editor.putString("presion", presion.getText().toString());
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
			return onOptionsItemSelected(item);
		}
	}

}
