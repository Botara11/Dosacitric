package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados2 extends ActionBarActivity {

	private DecimalFormat df;
	private TextView VolAplicacion;
	private TextView VelAvance;
	private TextView AnchoTrabajo;
	private TextView CaudalLiqTotal;
	private TextView NumTotalBoq;
	private TextView NumBoqPorSector;
	private TextView BoqCerrAlta;
	private TextView BoqCerrBaja;
	private TextView BoqAbiAlta;
	private TextView BoqAbiMedia;
	private TextView BoqAbiBaja;
	private TextView VegetaAlta;
	private TextView VegetaMedia;
	private TextView VegetaBaja;
	private TextView CaudalLiqSector;
	private TextView VarCaudalAdmisible;
	private TextView CaudalLiqAlta;
	private TextView CaudalLiqMedia;
	private TextView CaudalLiqBaja;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados2);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		 VolAplicacion = (TextView) findViewById(R.id.textView41);

		 VelAvance = (TextView) findViewById(R.id.textView39);
		 AnchoTrabajo = (TextView) findViewById(R.id.textView40);
		 CaudalLiqTotal = (TextView) findViewById(R.id.textView42);
		 NumTotalBoq = (TextView) findViewById(R.id.textView27);
		 NumBoqPorSector = (TextView) findViewById(R.id.textView28);

		 BoqCerrAlta = (TextView) findViewById(R.id.textView29);
		 BoqCerrBaja = (TextView) findViewById(R.id.textView30);

		 BoqAbiAlta = (TextView) findViewById(R.id.textView31);
		 BoqAbiMedia = (TextView) findViewById(R.id.textView32);
		 BoqAbiBaja = (TextView) findViewById(R.id.textView33);

		 VegetaAlta = (TextView) findViewById(R.id.textView34);
		 VegetaMedia = (TextView) findViewById(R.id.textView35);
		 VegetaBaja = (TextView) findViewById(R.id.textView36);

		 CaudalLiqSector = (TextView) findViewById(R.id.textView412);
		 VarCaudalAdmisible = (TextView) findViewById(R.id.textView392);

		 CaudalLiqAlta = (TextView) findViewById(R.id.textView512);
		 CaudalLiqMedia = (TextView) findViewById(R.id.textView522);
		 CaudalLiqBaja = (TextView) findViewById(R.id.textView532);

		Intent bres = getIntent();
		ParteB resultados1 = (ParteB) bres.getSerializableExtra("parteb2");

		VolAplicacion.setText(String.valueOf(resultados1.VolumenApp));
		VelAvance.setText(String.valueOf(resultados1.VelocidadAvance));
		AnchoTrabajo.setText(String.valueOf(resultados1.AnchoTrabajo));
		CaudalLiqTotal.setText(String.valueOf(df
				.format(resultados1.CaudalLiquidoTotal)));
		NumTotalBoq.setText(String.valueOf(resultados1.NumeroTotalBoquillas));
		NumBoqPorSector.setText(String
				.valueOf(resultados1.NumeroBoquillasSector));

		BoqCerrAlta.setText(String
				.valueOf(resultados1.NumeroBoquillasCerradas[0]));
		BoqCerrBaja.setText(String
				.valueOf(resultados1.NumeroBoquillasCerradas[1]));

		BoqAbiAlta.setText(String
				.valueOf(resultados1.NumeroBoquillasAbiertas[0]));
		BoqAbiMedia.setText(String
				.valueOf(resultados1.NumeroBoquillasAbiertas[1]));
		BoqAbiBaja.setText(String
				.valueOf(resultados1.NumeroBoquillasAbiertas[2]));

		VegetaAlta.setText(String.valueOf(resultados1.PorcentajeVegetacion[0])
				+ " %");
		VegetaMedia.setText(String.valueOf(resultados1.PorcentajeVegetacion[1])
				+ " %");
		VegetaBaja.setText(String.valueOf(resultados1.PorcentajeVegetacion[2])
				+ " %");

		CaudalLiqSector.setText(String.valueOf(df
				.format(resultados1.CaudalLiquidoSector)));
		VarCaudalAdmisible.setText(String
				.valueOf((int) (resultados1.VariacionCaudalAdmisible * 100))
				+ " %");


		final float[] inter = resultados1.IntervaloCaudalAdmisible;
		CaudalLiqAlta.setText(df.format(inter[0]) + "-" + df.format(inter[1]));
		CaudalLiqMedia.setText(df.format(inter[2]) + "-" + df.format(inter[3]));
		CaudalLiqBaja.setText(df.format(inter[4]) + "-" + df.format(inter[5]));

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				DatabaseHandler db = new DatabaseHandler(
						getApplicationContext());

				String[] marcas = { "Teejet", "Hardi", "Albuz", "Lechler",
						"Discos", "Otros" };
				String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
						"p12", "p13", "p14", "p15", "p16" };

				ArrayList<String> marcasAdecu = new ArrayList<String>();

				bucleDentro: for (String mar : marcas) {
					for (String pres : presiones) {
						ArrayList<String> boquillasZ1 = db.getBoquillas(mar,
								inter[0], inter[1], pres);
						ArrayList<String> boquillasZ2 = db.getBoquillas(mar,
								inter[2], inter[3], pres);
						ArrayList<String> boquillasZ3 = db.getBoquillas(mar,
								inter[4], inter[5], pres);
						if (boquillasZ1 != null && boquillasZ2 != null
								&& boquillasZ3 != null) {
							if (boquillasZ1.size() > 0
									&& boquillasZ2.size() > 0
									&& boquillasZ3.size() > 0) {
								System.out.println("z1=" + boquillasZ1.size()
										+ " z2=" + boquillasZ2.size() + " z3="
										+ boquillasZ3.size());
								// Se muestran
								marcasAdecu.add(mar);
								continue bucleDentro;
							}
						}
					}
				}
				/*
				 * System.out.println("El numero de boquillas encontrad: "+
				 * boquillasZ1.size()); for(int i=0;i<boquillasZ1.size();i++)
				 * System.out.println(boquillasZ1.get(i));
				 */
				Intent res = new Intent(Resultados2.this,
						CatalogosListView.class);
				res.putExtra("marcas", marcasAdecu);
				res.putExtra("inter", inter);
				startActivity(res);
			}
		});

		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados2.this, Indice.class));
			}
		});

		ImageButton acercaDe = (ImageButton) findViewById(R.id.acercaDe);
		acercaDe.setClickable(true);
		acercaDe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados2.this, AcercaDe_1.class));
				finish();
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
				String C = ""+
						"C. REGULACI&Oacute;N DEL PULVERIZADOR HIDRONEUM&Aacute;TICO (TURBO)<tipo>1<n>"+
						"Volumen de aplicaci&oacute;n (V) "+Resultados2.this.VolAplicacion.getText().toString()+" L/Ha<tipo>3<n>"+
						"Velocidad de avance deseada "+Resultados2.this.VelAvance.getText().toString()+" km/h<tipo>3<n>"+
						"Ancho de trabajo (a)"+Resultados2.this.AnchoTrabajo.getText().toString()+"+ m<tipo>3<n>"+
						"Caudal l&iacute;quido total "+Resultados2.this.CaudalLiqTotal.getText().toString()+"L/min<tipo>3<n>"+
						"Caracterl&iacute;sticas del sistema hidrl&aacute;ulico del equipo<tipo>3<n>"+
						"- N� total boquillas "+Resultados2.this.NumTotalBoq.getText().toString()+"<tipo>3<n>"+
						"- N� boquillas desponibles/sector "+Resultados2.this.NumBoqPorSector.getText().toString()+"+<tipo>3<n>"+
						"Boquillas a cerrar por zona<tipo>2<n>"+
						"Zona Alta (nA)"+Resultados2.this.BoqCerrAlta.getText().toString()+"<tipo>3<n> "+
						"Zona Baja (nA)"+Resultados2.this.BoqCerrBaja.getText().toString()+"<tipo>3<n> "+
						"N&uacute;mero boquillas abiertas por zona<tipo>2<n>"+
						"Zona Alta (nA)"+Resultados2.this.BoqAbiAlta.getText().toString()+"<tipo>3<n> "+
						"Zona Media (nA)"+Resultados2.this.BoqAbiMedia.getText().toString()+"<tipo>3<n> "+
						"Zona Baja (nA)"+Resultados2.this.BoqAbiBaja.getText().toString()+"<tipo>3<n> "+
						"Porcentaje de vegetaci&oacute;n a pulverizar por zona<tipo>2<n>"+
						"Zona Alta (A%)"+Resultados2.this.VegetaAlta.getText().toString()+" %<tipo>3<n>"+
						"Zona Media (A%)"+Resultados2.this.VegetaMedia.getText().toString()+" %<tipo>3<n>"+
						"Zona Baja (A%)"+Resultados2.this.VegetaBaja.getText().toString()+" %<tipo>3<n>"+
						"Caracterl&iacute;sticas del cauda<tipo>2<n>"+
						"Caudal l&iacute;quido por sector"+Resultados2.this.CaudalLiqSector.getText().toString()+" L/min<tipo>3<n>"+
						"Variaci&oacute;n de caudal admisible"+Resultados2.this.VarCaudalAdmisible.getText().toString()+" %<tipo>3<n>"+
						"Caudal l&iacute;quido por boquilla<tipo>2<n>"+
						"Zona Alta (nA)"+Resultados2.this.CaudalLiqAlta.getText().toString()+" L/min<tipo>3<n>"+
						"Zona Media (nA)"+Resultados2.this.CaudalLiqMedia.getText().toString()+" L/min<tipo>3<n>"+
						"Zona Baja (nA)"+Resultados2.this.CaudalLiqBaja.getText().toString()+" L/min<tipo>3";
				rw.write("C", C);
				mypdf.readFile("C");
				DatabaseHandler db = new DatabaseHandler(
						getApplicationContext());

				String[] marcas = { "Teejet", "Hardi", "Albuz", "Lechler",
						"Discos", "Otros" };
				String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
						"p12", "p13", "p14", "p15", "p16" };

				ArrayList<String> marcasAdecu = new ArrayList<String>();

				bucleDentro: for (String mar : marcas) {
					int marcaPrimera = 0;
					for (String pres : presiones) {
						ArrayList<String> boquillasZ1 = db.getBoquillas(mar,
								inter[0], inter[1], pres);
						ArrayList<String> boquillasZ2 = db.getBoquillas(mar,
								inter[2], inter[3], pres);
						ArrayList<String> boquillasZ3 = db.getBoquillas(mar,
								inter[4], inter[5], pres);
						if (boquillasZ1 != null && boquillasZ2 != null
								&& boquillasZ3 != null) {
							if (boquillasZ1.size() > 0
									&& boquillasZ2.size() > 0
									&& boquillasZ3.size() > 0) {
								System.out.println("z1=" + boquillasZ1.size()
										+ " z2=" + boquillasZ2.size() + " z3="
										+ boquillasZ3.size());
								if(marcaPrimera==0){
									mypdf.insertarMarca(mar);
									marcaPrimera=1;}
								mypdf.insertarPresion(pres);

								String boquillaDezona = "Zona alta:   ";
								for (int u=0;u<boquillasZ1.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ1.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								
								mypdf.insertarZonas(boquillaDezona);
								boquillaDezona = "Zona media:   ";
								for (int u=0;u<boquillasZ2.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ2.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								mypdf.insertarZonas(boquillaDezona);
								boquillaDezona = "Zona baja:   ";
								for (int u=0;u<boquillasZ3.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ3.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								mypdf.insertarZonas(boquillaDezona);
								// Se muestran
								marcasAdecu.add(mar);
								continue bucleDentro;
							}
						}
					}
					
				}
				Calendar cal = Calendar.getInstance();
				mypdf.finish_document("Dosacitric_C"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));

				Toast toast = Toast.makeText(getApplicationContext(), "El PDF sera guardado en DESCARGAS", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
