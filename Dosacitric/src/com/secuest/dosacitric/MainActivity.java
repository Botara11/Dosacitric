package com.secuest.dosacitric;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
	int debug = 0;
	String pagina;
	private ProgressBar barra;
	private TableRow tableLay;
	private boolean DONE = false; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portada);
		
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		final DatabaseHandler db = new DatabaseHandler(this);
		/*System.out.println("GEEEETTTT COUNT DB ="+db.getRowCount());
		if(db.getRowCount()>0){
			debug=1;
		}
		 */
		//db.resetTables();
		barra = (ProgressBar) findViewById(R.id.progressBar1);
		tableLay = (TableRow) findViewById(R.id.tableLayout1);
		tableLay.setVisibility(View.INVISIBLE);
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(MainActivity.this, Indice.class));
				//startActivity(new Intent(MainActivity.this, NewIngresarBoquillas.class));

			}
		});
		/*
		pdfCreator pdf = new pdfCreator();
		//pdf.dibujarTabla("");
		pdf.insertarMarca("Tejeet");
		pdf.insertarPresion("7 bares");
		pdf.insertarZonas("Zona alta:   YUH765   809JKJJ   89866hsh");
		pdf.insertarZonas("Zona media:  YUH765   UUMMs   89866hsh");
		pdf.insertarZonas("Zona baja:   809JKJJ   89866hsh");
		pdf.insertarPresion("8 bares");
		pdf.insertarZonas("Zona alta:    89866hsh");
		pdf.insertarZonas("Zona media:   809JKJJ");
		pdf.insertarZonas("Zona baja:   809JKJJ   89866hsh");
		pdf.insertarMarca("ROCKA");
		pdf.insertarPresion("9 bares");
		pdf.insertarZonas("Zona alta:   YUH765   809JKJJ   89866hsh");
		pdf.insertarZonas("Zona media:  YUH765   UUMMs   89866hsh");
		pdf.insertarZonas("Zona baja:   809JKJJ   89866hsh");
		pdf.finish_document("aaaaaaaa");
		 */
		//Para omitir la carga:

		if (debug==1){
			tableLay.setVisibility(View.VISIBLE);
			barra.setVisibility(View.INVISIBLE);
		}else{
			new Thread(new Runnable() {
				public void run() {
					boolean DESCARGAR = false;
					long tiempo = (new java.util.Date()).getTime();
					RWFile ds = new RWFile();
					String readDate = ds.read(".date");
					if (readDate==null || db.getRowCount()<=0){
						ds.write(".date", tiempo + "");
						System.out.println("readDate = NULL");
						DESCARGAR = true;
					} else {
						System.out.println("el float parseado="+Long.parseLong(readDate));
						long resta = tiempo - (Long.parseLong(readDate));
						if (resta > 1209600000) {  // una semana 1209600000  ;  un minuto 60000
							DESCARGAR = true;
							ds.write(".date", tiempo + "");
							System.out.println("readDate =" + tiempo + "\n"
									+ "la resta="
									+ resta);
						} else {
							System.out
							.println("No ha pasado el suficiente tiempo readDate="
									+ readDate
									+ " la resta="
									+ resta
									+ "\nahora=" + tiempo);
							DONE = true;
						}
					}

					pagina = (new http()).connect("http://dosacitric.webs.upv.es/BBDD.txt");
					if(pagina == null){
						System.out.println("pagina descargada es NULL");
					}else if(DESCARGAR){
						db.resetTables();
						pagina = pagina.replace(",", ".");
						String[] nuevo = pagina.split("<!-- Hosting24 Analytics Code -->");					//*****CAMBIAR CUANDO HAYA CAMBIADO EL HOSTING*****///
						pagina = nuevo[0];
						System.out.println(pagina);

						String[] boquillas = pagina.split("\n");
						for(int i=0;i<boquillas.length;i++){ 
							String[] boq = boquillas[i].split("%%%");

							//HAY DATOS QUE ESTAN VACIOS "" ASI QUE NO SE PUEDE HACER DOUBLE.PARSEDOUBLE()
							Double k = Double.parseDouble(boq[4])/java.lang.Math.pow(10.0,0.5);
							//MARCA - MODELO - DIAMETRO(puede no haber) - CAUDAL
							double dia;
							if(boq[2].compareTo("")!=0){
								dia = Double.parseDouble(boq[2]);
							}else 
								dia = 0.0;
							//System.out.println(boq[1] + " "+boq[4]+"/("+boq[4]+"^0,5) = " +k);
							db.addBoquilla(boq[0],boq[1],dia,Double.parseDouble(boq[4]),k*java.lang.Math.pow(6.0,0.5),
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
						}

						DONE=true;
					}
				}
			}).start();    
			check();

		}
		/*
									// diamet,caudal
		db.addBoquilla("NIKE", "zapas", null, null, 0.1, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		db.addBoquilla("NIKE", "camisa", null, null, 0.2, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		db.addBoquilla("NIKE", "corba", null, null, 0.3, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		db.addBoquilla("NIKE", "boli", null, null, 0.4, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		db.addBoquilla("NIKE", "tele", null, null, 0.5, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		db.addBoquilla("NIKE", "nuevo", null, null, 0.1, 0.2, 0.3, 0.4, 0.5,
				0.6, 0.7, 0.8, 0.9, 1.0, 1.2);
		 */

	}

	public void check(){
		System.out.println("Entra en Check");

		if(DONE){
			System.out.println("CHECK DONE");

			tableLay.setVisibility(View.VISIBLE);
			barra.setVisibility(View.INVISIBLE);
		}
		else{

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					check();
					System.out.println("Lanza check");
				}
			}, 1000);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

}
