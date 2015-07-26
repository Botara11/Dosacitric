package com.secuest.dosacitric;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableRow;


public class MainActivity extends ActionBarActivity {
	int debug = 1;
	String pagina;
	private ProgressBar barra;
	private TableRow tableLay;
	private boolean DONE = false; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portada);


		final DatabaseHandler db = new DatabaseHandler(this);
		db.resetTables();
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

			}
		});
		
		//Para omitir la carga:
		if (debug==1){
		tableLay.setVisibility(View.VISIBLE);
		barra.setVisibility(View.INVISIBLE);
		}else{
		new Thread(new Runnable() {
			public void run() {


				pagina = (new http()).connect("http://secuest.comuf.com/dosacitric/BBDD.html");
				if(pagina == null){
				}else{
					pagina = pagina.replace(",", ".");
					String[] nuevo = pagina.split("<!-- Hosting24 Analytics Code -->");					//*****CAMBIAR CUANDO HAYA CAMBIADO EL HOSTING*****///
					pagina = nuevo[0];
					//System.out.println(pagina);

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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

}
