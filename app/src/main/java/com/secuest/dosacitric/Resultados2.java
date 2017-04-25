package com.secuest.dosacitric;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import com.secuest.dosacitric.R;

import android.content.Context;
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

public class Resultados2 extends AppCompatActivity {

	private TextView VolAplicacion;
	private TextView VelAvance;
	private TextView AnchoTrabajo;
	private TextView CaudalLiqTotal;
	private TextView NumTotalBoq;
	private TextView BoqCerrAlta;
	private TextView BoqCerrBaja;
	private TextView BoqAbiAlta;
	private TextView BoqAbiMedia;
	private TextView BoqAbiBaja;
	private TextView VegetaAlta;
	private TextView VegetaMedia;
	private TextView VegetaBaja;
	private TextView VarCaudalAdmisible;
	private TextView CaudalLiqAlta;
	private TextView CaudalLiqMedia;
	private TextView CaudalLiqBaja;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados2);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRENCH);
		DecimalFormat d = (DecimalFormat) nf;
		d.setMaximumFractionDigits(0);

		DecimalFormat di = (DecimalFormat) nf;
		di.setMaximumFractionDigits(1);
		
		DecimalFormat df = (DecimalFormat) nf;
		df.setMaximumFractionDigits(2);

		VolAplicacion = (TextView) findViewById(R.id.textView41);

		VelAvance = (TextView) findViewById(R.id.textView39);
		AnchoTrabajo = (TextView) findViewById(R.id.textView40);
		CaudalLiqTotal = (TextView) findViewById(R.id.textView42);
		NumTotalBoq = (TextView) findViewById(R.id.textView27);
		
		BoqCerrAlta = (TextView) findViewById(R.id.textView29);
		BoqCerrBaja = (TextView) findViewById(R.id.textView30);

		BoqAbiAlta = (TextView) findViewById(R.id.textView31);
		BoqAbiMedia = (TextView) findViewById(R.id.textView32);
		BoqAbiBaja = (TextView) findViewById(R.id.textView33);

		VegetaAlta = (TextView) findViewById(R.id.textView34);
		VegetaMedia = (TextView) findViewById(R.id.textView35);
		VegetaBaja = (TextView) findViewById(R.id.textView36);

		VarCaudalAdmisible = (TextView) findViewById(R.id.textView392);

		CaudalLiqAlta = (TextView) findViewById(R.id.textView512);
		CaudalLiqMedia = (TextView) findViewById(R.id.textView522);
		CaudalLiqBaja = (TextView) findViewById(R.id.textView532);

		Intent bres = getIntent();
		ParteB resultados1 = (ParteB) bres.getSerializableExtra("parteb2");

		VolAplicacion.setText(String.valueOf(d
				.format(resultados1.VolumenApp)));
		VelAvance.setText(String.valueOf(di
				.format(resultados1.VelocidadAvance)));
		AnchoTrabajo.setText(String.valueOf(di
				.format(resultados1.AnchoTrabajo)));
		CaudalLiqTotal.setText(String.valueOf(di
				.format(resultados1.CaudalLiquidoTotal)));
		NumTotalBoq.setText(String.valueOf(resultados1.NumeroTotalBoquillas));
		
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

		VegetaAlta.setText(String.valueOf(d
				.format(resultados1.PorcentajeVegetacion[0])
				+ " %"));
		VegetaMedia.setText(String.valueOf(d
				.format(resultados1.PorcentajeVegetacion[1])
				+ " %"));
		VegetaBaja.setText(String.valueOf(di
				.format(resultados1.PorcentajeVegetacion[2])
				+ " %"));

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
						"Discos", "Otros", "Mis boquillas" };
				String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
						"p12", "p13", "p14", "p15", "p16" };

				System.out.println("Inter Z1:"+inter[0]+" , "+inter[1]);
				System.out.println("Inter Z2:"+inter[2]+" , "+inter[3]);
				System.out.println("Inter Z3:"+inter[4]+" , "+inter[5]);

				ArrayList<String> marcasAdecu = new ArrayList<String>();
				bucleDentro: for (String mar : marcas) {
					System.out.println();System.out.println();
					System.out.println("\n\nMarca: "+mar);
					for (String pres : presiones) {
						System.out.println("Presion: "+pres);

						ArrayList<String> boquillasZ1 = db.getBoquillas(mar,
								inter[0], inter[1], pres);
						ArrayList<String> boquillasZ2 = db.getBoquillas(mar,
								inter[2], inter[3], pres);
						ArrayList<String> boquillasZ3 = db.getBoquillas(mar,
								inter[4], inter[5], pres);
						System.out.println("--Check_z1:"+boquillasZ1.toString()+" z2:"+boquillasZ2.toString()+" z3:"+
								boquillasZ3.toString());

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
				
				if (marcasAdecu.size()==0){
					Intent res = new Intent(Resultados2.this,
							NoHayBoquillas.class);
					startActivity(res);

				}else{
					Intent res = new Intent(Resultados2.this,
							CatalogosListView.class);
					res.putExtra("marcas", marcasAdecu);
					res.putExtra("inter", inter);
					startActivity(res);}
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

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados2.this, AyudaResultados2.class));
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
							"Fecha: "+settings.getString("fecha", "")+"<tipo>2<n>"+
							"Identificaci&oacute;n de la parcela: "+settings.getString("idparcela", "")+"<tipo>2<n>"+
							"Identificaci&oacute;n del tratamiento: "+settings.getString("idtratamiento", "")+"<tipo>2<n>"+
							"Referencia: "+settings.getString("referencia", "")+"<tipo>2";
					rw.write("A", A);
					mypdf.readFile("A");
				}
				String C = ""+
						"C. REGULACI&Oacute;N DEL PULVERIZADOR<tipo>1<n>"+
						" HIDRONEUM&Aacute;TICO (TURBO)<tipo>4<n>"+
						"Volumen de aplicaci&oacute;n (V): "+Resultados2.this.VolAplicacion.getText().toString()+" L/ha<tipo>2<n>"+
						"Velocidad de avance deseada (v): "+Resultados2.this.VelAvance.getText().toString()+" Km/h<tipo>2<n>"+
						"Ancho de trabajo (a): "+Resultados2.this.AnchoTrabajo.getText().toString()+" m<tipo>2<n>"+
						"Caracter&iacute;sticas del sistema hidr&aacute;ulico del equipo:<tipo>2<n>"+
						"          Caudal l&iacute;quido total: "+Resultados2.this.CaudalLiqTotal.getText().toString()+" L/min<tipo>2<n>"+
						"          Nº total boquillas del equipo: "+Resultados2.this.NumTotalBoq.getText().toString()+"<tipo>2<n>"+
						"          N&uacute;mero de boquillas que deben cerrarse por zona:<tipo>2<n> "+
						"                    Zona Alta: "+Resultados2.this.BoqCerrAlta.getText().toString()+"<tipo>2<n> "+
						"                    Zona Baja: "+Resultados2.this.BoqCerrBaja.getText().toString()+"<tipo>2<n>"+
						"          N&uacute;mero boquillas abiertas por zona:<tipo>2<n> "+
						"                    Zona Alta (nA): "+Resultados2.this.BoqAbiAlta.getText().toString()+"<tipo>2<n> "+
						"                    Zona Media (nM): "+Resultados2.this.BoqAbiMedia.getText().toString()+"<tipo>2<n> "+
						"                    Zona Baja (nB): "+Resultados2.this.BoqAbiBaja.getText().toString()+"<tipo>2<n>"+
						"          Porcentaje de vegetaci&oacute;n a pulverizar por zona:<tipo>2<n>"+
						"                    Zona Alta (A%): "+Resultados2.this.VegetaAlta.getText().toString()+" <tipo>2<n>"+
						"                    Zona Media (M%): "+Resultados2.this.VegetaMedia.getText().toString()+" <tipo>2<n>"+
						"                    Zona Baja (B%): "+Resultados2.this.VegetaBaja.getText().toString()+" <tipo>2<n>"+
						"          Variaci&oacute;n de caudal admisible: "+Resultados2.this.VarCaudalAdmisible.getText().toString()+" <tipo>2<n>"+
						"          Intervalo de caudales admisibles por boquilla de cada zona:<tipo>2<n>"+
						"                    Zona Alta (qA): "+Resultados2.this.CaudalLiqAlta.getText().toString()+" L/min<tipo>2<n>"+
						"                    Zona Media (qM): "+Resultados2.this.CaudalLiqMedia.getText().toString()+" L/min<tipo>2<n>"+
						"                    Zona Baja (qB): "+Resultados2.this.CaudalLiqBaja.getText().toString()+" L/min<tipo>2";
				rw.write("C", C);
				mypdf.readFile("C");
				DatabaseHandler db = new DatabaseHandler(
						getApplicationContext());

				String[] marcas = { "Teejet", "Hardi", "Albuz", "Lechler",
						"Discos", "Otros", "Mis boquillas" };
				String[] presiones = { "p6", "p7", "p8", "p9", "p10", "p11",
						"p12", "p13", "p14", "p15", "p16" };
				String[] presionesString = { "Presión: 6 bar", "Presión: 7 bar", "Presión: 8 bar", "Presión: 9 bar",
						"Presión: 10 bar", "Presión: 11 bar",
						"Presión: 12 bar", "Presión: 13 bar", "Presión: 14 bar", "Presión: 15 bar", "Presión: 16 bar" };
				int posicionArray = 0;

				ArrayList<String> marcasAdecu = new ArrayList<String>();

				for (String mar : marcas) {
					System.out.println();System.out.println();
					System.out.println("Marca: "+mar);
					int marcaPrimera = 0;
					for (String pres : presiones) {
						System.out.println("Presion: "+pres);
						ArrayList<String> boquillasZ1 = db.getBoquillas(mar,
								inter[0], inter[1], pres);
						ArrayList<String> boquillasZ2 = db.getBoquillas(mar,
								inter[2], inter[3], pres);
						ArrayList<String> boquillasZ3 = db.getBoquillas(mar,
								inter[4], inter[5], pres);
						System.out.println("--Check_z1:"+boquillasZ1.toString()+" z2:"+boquillasZ2.toString()+" z3:"+
								boquillasZ3.toString());
						if (boquillasZ1 != null && boquillasZ2 != null
								&& boquillasZ3 != null) {
							if (boquillasZ1.size() > 0
									&& boquillasZ2.size() > 0
									&& boquillasZ3.size() > 0) {
								System.out.println("z1=" + boquillasZ1.size()
								+ " z2=" + boquillasZ2.size() + " z3="
								+ boquillasZ3.size());
								if(marcaPrimera==0){
									mypdf.insertarMarca(mar.toUpperCase());
									marcaPrimera=1;}
								posicionArray = Arrays.asList(presiones).indexOf(pres);
								mypdf.insertarPresion(presionesString[posicionArray]);

								String boquillaDezona = "Zona alta:   ";
								for (int u=0;u<boquillasZ1.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ1.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								if (boquillaDezona.compareTo("            ")!=0)
									mypdf.insertarZonas(boquillaDezona);
								boquillaDezona = "Zona media:   ";
								for (int u=0;u<boquillasZ2.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ2.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								if (boquillaDezona.compareTo("            ")!=0)
									mypdf.insertarZonas(boquillaDezona);
								boquillaDezona = "Zona baja:   ";
								for (int u=0;u<boquillasZ3.size();u++){
									boquillaDezona=boquillaDezona+boquillasZ3.get(u)+ "   ";
									if(u%3==0 && u!=0){
										mypdf.insertarZonas(boquillaDezona);
										boquillaDezona = "            ";
									}
								}
								if (boquillaDezona.compareTo("            ")!=0)
									mypdf.insertarZonas(boquillaDezona);
								// Se muestran
								marcasAdecu.add(mar);
								//continue bucleDentro;
							}
						}
					}

				}
				//Calendar cal = Calendar.getInstance();
				//mypdf.finish_document("Dosacitric_C"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR), getApplicationContext());
				//Calendar cal = Calendar.getInstance();
				String referencia = settings.getString("referencia", "");
				mypdf.finish_document("DosacitricC"+referencia, getApplicationContext());
				//mypdf.finish_document("Dosacitric_C"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));

				Toast toast = Toast.makeText(getApplicationContext(), "El PDF será guardado en DESCARGAS", Toast.LENGTH_SHORT);
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