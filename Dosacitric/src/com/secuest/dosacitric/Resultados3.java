package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Resultados3 extends Activity {

	private ParteC partec7;
	private DecimalFormat df;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados3);

		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		Intent c6 = getIntent();
		partec7 = (ParteC) c6.getSerializableExtra("modeloZonaBaja");

		DatabaseHandler db = new DatabaseHandler(this);

		//Log.e("didi", partec7.ModeloZonaAltaSeleccionado.toString());

		//String[] lv_arr = new String[partec7.ModeloZonaAltaSeleccionado.size()];
		//lv_arr = partec7.ModeloZonaAltaSeleccionado.toArray(lv_arr);

		//Log.e("didi", Arrays.toString(lv_arr));

		String resultmodeloZonaAlta = partec7.ModeloZonaAltaSeleccionado.get(0);
		String resultmodeloZonaMedia = partec7.ModeloZonaMediaSeleccionado.get(0);
		String resultmodeloZonaBaja = partec7.ModeloZonaBajaSeleccionado.get(0);

		Log.e("didi", resultmodeloZonaAlta);
		Log.e("didi", resultmodeloZonaMedia);
		Log.e("didi", resultmodeloZonaBaja);

		String modeloZonaAlta = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaAlta, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bares", "")));

		String modeloZonaMedia = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaMedia, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bares", "")));

		String modeloZonaBaja = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaBaja, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bares", "")));


		Log.e("didi", modeloZonaAlta);
		Log.e("didi", modeloZonaMedia);
		Log.e("didi", modeloZonaBaja);
		
		Float ValorZonaAlta = Float.parseFloat(modeloZonaAlta);
		Float ValorZonaMedia = Float.parseFloat(modeloZonaMedia);
		Float ValorZonaBaja = Float.parseFloat(modeloZonaBaja);
		
		System.out.print(ValorZonaAlta);	
		System.out.print(ValorZonaMedia);	
		System.out.print(ValorZonaBaja);	
		
		partec7.calcularParteC(ValorZonaAlta, ValorZonaMedia, ValorZonaBaja);
		
		System.out.print(partec7.VolumenCaldoAplicado);		

		TextView VolAplicacion = (TextView) findViewById(R.id.textView41);
		TextView VelAvance = (TextView) findViewById(R.id.textView39);

		Intent cres = getIntent();
		ParteC resultados3 = (ParteC) cres.getSerializableExtra("parteb2");

		//VolAplicacion.setText(String.valueOf(resultados3.VolumenApp));
		//VelAvance.setText(String.valueOf(resultados3.VelocidadAvance));
		//AnchoTrabajo.setText(String.valueOf(resultados3.AnchoTrabajo));


		//DatabaseHandler db = new DatabaseHandler(this);
		//db.getCaudalAunaPresionDeBoquilla(marca, modelo, presion)


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
				startActivity(new Intent(Resultados3.this, Indice.class));
			}
		});

	}
}
