package com.secuest.dosacitric;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Resultados3 extends AppCompatActivity {

	private ParteC partec7;
	private DecimalFormat df;
	//private DecimalFormat di;
	private TextView AnchoDeTrabajo;
	private TextView VelocidadDeAvance;
	private TextView BoquillaZonaAlta;
	private TextView BoquillaZonaMedia;
	private TextView BoquillaZonaBaja;
	private TextView Presion;
	private TextView Marca;
	private TextView Marca2;
	private TextView Marca3;
	private TextView EleccionBoquillaZonaAlta;
	private TextView EleccionBoquillaZonaMedia;
	private TextView EleccionBoquillaZonaBaja;
	private TextView VolumenCaldoAplicado;
	private TextView CaudalLiqTotal;
	public static final String PREFS_NAME = "Guarda";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados3);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		
		/**** Dar formato a la salida de Resultados2 ****/		
		
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRENCH);
		DecimalFormat di = (DecimalFormat) nf;
		di.setMaximumFractionDigits(1);

		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		Intent c6 = getIntent();
		partec7 = (ParteC) c6.getSerializableExtra("modeloZonaBaja");

		DatabaseHandler db = new DatabaseHandler(this);

		//String[] lv_arr = new String[partec7.ModeloZonaAltaSeleccionado.size()];
		//lv_arr = partec7.ModeloZonaAltaSeleccionado.toArray(lv_arr);

		String resultmodeloZonaAlta = partec7.ModeloZonaAltaSeleccionado;
		String resultmodeloZonaMedia = partec7.ModeloZonaMediaSeleccionado;
		String resultmodeloZonaBaja = partec7.ModeloZonaBajaSeleccionado;

		String modeloZonaAlta = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaAlta, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bar", "")));

		String modeloZonaMedia = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaMedia, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bar", "")));

		String modeloZonaBaja = db.getCaudalAunaPresionDeBoquilla(
				partec7.MarcaSeleccionada,  resultmodeloZonaBaja, 
				Integer.parseInt(partec7.PresionSeleccionada.replace(" bar", "")));		
		
		Float ValorZonaAlta = Float.parseFloat(modeloZonaAlta);
		Float ValorZonaMedia = Float.parseFloat(modeloZonaMedia);
		Float ValorZonaBaja = Float.parseFloat(modeloZonaBaja);

		partec7.calcularParteC(ValorZonaAlta, ValorZonaMedia, ValorZonaBaja);

		AnchoDeTrabajo = (TextView) findViewById(R.id.AnchoTrabajoTextView);
		VelocidadDeAvance = (TextView) findViewById(R.id.VelocidadAvanceTextView);
		BoquillaZonaAlta = (TextView) findViewById(R.id.BoquillaZAltaTextView);
		BoquillaZonaMedia = (TextView) findViewById(R.id.BoquillaZMediaTextView);
		BoquillaZonaBaja = (TextView) findViewById(R.id.BoquillaZBajaTextView);
		Presion = (TextView) findViewById(R.id.PresionTextView);
		Marca = (TextView) findViewById(R.id.MarcaTextView);
		Marca2 = (TextView) findViewById(R.id.MarcaTextView2);
		Marca3 = (TextView) findViewById(R.id.MarcaTextView3);
		EleccionBoquillaZonaAlta = (TextView) findViewById(R.id.BoquillaEleccionZAltaTextView);
		EleccionBoquillaZonaMedia = (TextView) findViewById(R.id.BoquillaEleccionZMediaTextView);
		EleccionBoquillaZonaBaja = (TextView) findViewById(R.id.BoquillaEleccionZBajaTextView);
		VolumenCaldoAplicado = (TextView)findViewById(R.id.textView37);
		CaudalLiqTotal = (TextView)findViewById(R.id.CaudalLiqTotalTextView);
		
		AnchoDeTrabajo.setText(String.valueOf(di.format(partec7.AnchoCalle)));
		VelocidadDeAvance.setText(String.valueOf(di.format(partec7.VelocidadAvance)));
		BoquillaZonaAlta.setText(String.valueOf(partec7.NumeroBoquillasZona[0]));
		BoquillaZonaMedia.setText(String.valueOf(partec7.NumeroBoquillasZona[1]));
		BoquillaZonaBaja.setText(String.valueOf(partec7.NumeroBoquillasZona[2]));
		Presion.setText(String.valueOf(String.valueOf(partec7.PresionSeleccionada)));
		Marca.setText(String.valueOf(partec7.MarcaSeleccionada)+".");
		Marca2.setText(String.valueOf(partec7.MarcaSeleccionada)+".");
		Marca3.setText(String.valueOf(partec7.MarcaSeleccionada)+".");
		EleccionBoquillaZonaAlta.setText(String.valueOf(partec7.ModeloZonaAltaSeleccionado));
		EleccionBoquillaZonaMedia.setText(String.valueOf(partec7.ModeloZonaMediaSeleccionado));
		EleccionBoquillaZonaBaja.setText(String.valueOf(partec7.ModeloZonaBajaSeleccionado));
		VolumenCaldoAplicado.setText(String.valueOf(partec7.VolumenCaldoAplicado));
		CaudalLiqTotal.setText(String.valueOf(di.format(partec7.CaudalTotal)));

		Button nuevoTratamiento = (Button) findViewById(R.id.nuevoTratamiento);
		nuevoTratamiento.setClickable(true);
		nuevoTratamiento.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				@SuppressWarnings("unused")
				AlertDialog alert = new AlertDialog.Builder(Resultados3.this)
			    .setTitle("Nuevo tratamiento")
			    .setMessage("¿Realmente quiere borrar todos los datos introducidos en DOSACITRIC?")
			    .setNegativeButton("No", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // do nothing
			        }
			     })
			    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 

						SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
						SharedPreferences.Editor editor = settings.edit();
						editor.clear();
						editor.commit();
						
						startActivity(new Intent(Resultados3.this, Indice.class));
						finish();
			        }
			     })
			    
			    .setIcon(android.R.drawable.ic_delete)
			     .show();
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
		
		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados3.this, AyudaResultados3.class));
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
						"A. IDENTIFICACI&Oacute;N DEL TRATAMIENTO<tipo>1<n>"+
						"Fecha: "+settings.getString("fecha", "")+"<tipo>2<n>"+
						"Identificaci&oacute;n de la parcela: "+settings.getString("idparcela", "")+"<tipo>2<n>"+
						"Identificaci&oacute;n del tratamiento: "+settings.getString("idtratamiento", "")+"<tipo>2<n>"+
						"Referencia: "+settings.getString("referencia", "")+"<tipo>2";
					rw.write("A", A);
					mypdf.readFile("A");
				}
				String D = ""+
						"D. DETERMINACI&Oacute;N DEL VOLUMEN<tipo>1<n>"+
						"   DE CALDO APLICADO<tipo>4<n>"+
						"Ancho de trabajo: "+AnchoDeTrabajo.getText().toString()+" m<tipo>2<n>"+
						"Velocidad de avance: "+VelocidadDeAvance.getText().toString()+" Km/h<tipo>2<n>"+
						"Caracter&iacute;sticas del sistema hidr&aacute;ulico del equipo: "+"<tipo>2<n>"+
						"          N&uacute;mero de boquillas abiertas por zona:<tipo>2<n> "+
						"                    Zona Alta (nA): "+BoquillaZonaAlta.getText().toString()+"<tipo>2<n> "+
						"                    Zona Media (nM): "+BoquillaZonaMedia.getText().toString()+"<tipo>2<n> "+
						"                    Zona Baja (nB): "+BoquillaZonaBaja.getText().toString()+"<tipo>2<n> "+
						"          Presi&oacute;n seleccionada: "+Presion.getText().toString()+"<tipo>2<n> "+
						"          Boquillas seleccionadas:<tipo>2<n> "+
						"                    Zona Alta: "+Marca.getText().toString()+""+EleccionBoquillaZonaAlta.getText().toString()+"<tipo>2<n> "+
						"                    Zona Media: "+Marca.getText().toString()+""+EleccionBoquillaZonaMedia.getText().toString()+"<tipo>2<n> "+
						"                    Zona Baja: "+Marca.getText().toString()+""+EleccionBoquillaZonaBaja.getText().toString()+"<tipo>2<n> "+
						"          Caudal de l&iacute;quido total del equipo (Q): "+CaudalLiqTotal.getText().toString()+" L/min<tipo>2<n> "+
						"VOLUMEN DE CALDO APLICADO (V): "+VolumenCaldoAplicado.getText().toString()+" L/ha<tipo>1";
				//"Marca seleccionada: "+Marca.getText().toString()+"<tipo>3<n> "+
				rw.write("D", D);
				mypdf.readFile("D");			

				//Calendar cal = Calendar.getInstance();
				String referencia = settings.getString("referencia", "");
				mypdf.finish_document("DosacitricD"+referencia, getApplicationContext());
				//mypdf.finish_document("Dosacitric_D"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));
				
				Toast toast = Toast.makeText(getApplicationContext(), "El PDF será guardado en DESCARGAS", Toast.LENGTH_SHORT);
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