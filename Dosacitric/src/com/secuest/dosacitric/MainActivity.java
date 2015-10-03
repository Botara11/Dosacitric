package com.secuest.dosacitric;

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
	int debug = 0;
	String pagina;
	private ProgressBar barra;
	private TableRow tableLay;
	private boolean DONE = false; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portada);


		final DatabaseHandler db = new DatabaseHandler(this);
		if(db.getRowCount()>0){
			debug=1;
		}
		//db.resetTables();
		barra = (ProgressBar) findViewById(R.id.progressBar1);
		tableLay = (TableRow) findViewById(R.id.tableLayout1);
		tableLay.setVisibility(View.INVISIBLE);
		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
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


				pagina = (new http()).connect("http://dosacitric.webs.upv.es/BBDD.txt");
				if(pagina == null){
				}else{
					pagina = pagina.replace(",", ".");
					String[] nuevo = pagina.split("<!-- Hosting24 Analytics Code -->");					//*****CAMBIAR CUANDO HAYA CAMBIADO EL HOSTING*****///
					pagina = nuevo[0];

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
	}

	public void check(){

		if(DONE){
			tableLay.setVisibility(View.VISIBLE);
			barra.setVisibility(View.INVISIBLE);
		}
		else{
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					check();
				}
			}, 1000);
		}

	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
