package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados3 extends ActionBarActivity {

	private ParteC partec7;
	private DecimalFormat df;
	private TextView AnchoDeTrabajo;
	private TextView VelocidadDeAvance;
	private TextView BoquillaZonaAlta;
	private TextView BoquillaZonaMedia;
	private TextView BoquillaZonaBaja;
	private TextView Presion;
	private TextView Marca;
	private TextView EleccionBoquillaZonaAlta;
	private TextView EleccionBoquillaZonaMedia;
	private TextView EleccionBoquillaZonaBaja;
	private TextView VolumenCaldoAplicado;
	public static final String PREFS_NAME = "Guarda";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados3);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

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

		
		AnchoDeTrabajo = (TextView) findViewById(R.id.AnchoTrabajoTextView);
		VelocidadDeAvance = (TextView) findViewById(R.id.VelocidadAvanceTextView);
		BoquillaZonaAlta = (TextView) findViewById(R.id.BoquillaZAltaTextView);
		BoquillaZonaMedia = (TextView) findViewById(R.id.BoquillaZMediaTextView);
		BoquillaZonaBaja = (TextView) findViewById(R.id.BoquillaZBajaTextView);
		Presion = (TextView) findViewById(R.id.PresionTextView);
		Marca = (TextView) findViewById(R.id.MarcaTextView);
		EleccionBoquillaZonaAlta = (TextView) findViewById(R.id.BoquillaEleccionZAltaTextView);
		EleccionBoquillaZonaMedia = (TextView) findViewById(R.id.BoquillaEleccionZMediaTextView);
		EleccionBoquillaZonaBaja = (TextView) findViewById(R.id.BoquillaEleccionZBajaTextView);
		VolumenCaldoAplicado = (TextView)findViewById(R.id.VolumenCaldoTextView);

		AnchoDeTrabajo.setText(String.valueOf(partec7.AnchoCalle));
		VelocidadDeAvance.setText(String.valueOf(partec7.VelocidadAvance));
		BoquillaZonaAlta.setText(String.valueOf(partec7.NumeroBoquillasZona[0]));
		BoquillaZonaMedia.setText(String.valueOf(partec7.NumeroBoquillasZona[1]));
		BoquillaZonaBaja.setText(String.valueOf(partec7.NumeroBoquillasZona[2]));
		Presion.setText(String.valueOf(String.valueOf(partec7.PresionSeleccionada)));;
		Marca.setText(String.valueOf(partec7.MarcaSeleccionada));;
		EleccionBoquillaZonaAlta.setText(String.valueOf(partec7.ModeloZonaAltaSeleccionado));;
		EleccionBoquillaZonaMedia.setText(String.valueOf(partec7.ModeloZonaMediaSeleccionado));;
		EleccionBoquillaZonaBaja.setText(String.valueOf(partec7.ModeloZonaBajaSeleccionado));;
		VolumenCaldoAplicado.setText(String.valueOf(partec7.VolumenCaldoAplicado));;

		Button nuevoTratamiento = (Button) findViewById(R.id.nuevoTratamiento);
		nuevoTratamiento.setClickable(true);
		nuevoTratamiento.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = settings.edit();
				editor.clear();
				editor.commit();
				
				startActivity(new Intent(Resultados3.this, Indice.class));
				finish();
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados3.this, Indice.class));
			}
		});
		
		

		
		ImageButton printer = (ImageButton) findViewById(R.id.printer);
		printer.setClickable(true);
		printer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RWFile rw = new RWFile(); 
				pdfCreator mypdf = new pdfCreator();
				SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
				if(!settings.getString("fecha", "").equals("")){
					String A = ""+
						"A IDENTIFICACI&Oacute;N DEL TRATAMIENTO<tipo>1<n>"+
						"Fecha "+settings.getString("fecha", "")+"<tipo>3<n>"+
						"Identificaci&oacute;n de la parcela "+settings.getString("idparcela", "")+"<tipo>3<n>"+
						"Identificaci&oacute;n del tratamiento +"+settings.getString("idtratamiento", "")+"+<tipo>3<n>"+
						"Refer&eacute;ncia "+settings.getString("referencia", "")+"<tipo>3";
					rw.write("A", A);
					mypdf.readFile("A");
				}
				String D = ""+
						"D. Determinaci&oacute;n del volumen de caldo aplicado <tipo>1<n>"+
						"Ancho de trabajo "+AnchoDeTrabajo.getText().toString()+" m<tipo>3<n>"+
						"Velocidad de avance "+VelocidadDeAvance.getText().toString()+" km/h<tipo>3<n>"+
						"Caracter&iacute;sticas del sistema hidr&aacute;ulico del equipo "+"<tipo>2<n>"+
						"Num. de boquillas por zona<tipo>3<n>"+
						"    Zona Alta(nA)"+BoquillaZonaAlta.getText().toString()+"<tipo>3<n> "+
						"    Zona Media(nM)"+BoquillaZonaMedia.getText().toString()+"<tipo>3<n> "+
						"    Zona Baja(nB)"+BoquillaZonaBaja.getText().toString()+"<tipo>3<n> "+
						"Presi&oacute;n seleccionada "+Presion.getText().toString()+" bares<tipo>3<n> "+
						"Marca seleccionada "+Marca.getText().toString()+"<tipo>3<n> "+
						"Elecci&oacute;n del modelo de boquilla<tipo>2<n> "+
						"    Zona Alta "+EleccionBoquillaZonaAlta.getText().toString()+"<tipo>3<n> "+
						"    Zona Media "+EleccionBoquillaZonaMedia.getText().toString()+"<tipo>3<n> "+
						"    Zona Baja "+EleccionBoquillaZonaBaja.getText().toString()+"<tipo>3<n> "+
						"Caracter&iacute;sticas del caudal <tipo>2<n> "+
						"Volumen de caldo aplicado "+VolumenCaldoAplicado.getText().toString()+" L/ha<tipo>3";
				
				rw.write("D", D);
				mypdf.readFile("D");

				Calendar cal = Calendar.getInstance();
				mypdf.finish_document("Dosacitric_D"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));
				
				Toast toast = Toast.makeText(getApplicationContext(), "El PDF sera guardado en DESCARGAS", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
	
	
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

}
