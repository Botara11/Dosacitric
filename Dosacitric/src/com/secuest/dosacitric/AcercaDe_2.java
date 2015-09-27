package com.secuest.dosacitric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AcercaDe_2 extends ActionBarActivity{
	
	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	//private TextView cuerpo4;
	//private TextView cuerpo5;
	//private TextView cuerpo6;
	//private TextView cuerpo7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acercade_2);
		
		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		//cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		//cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		//cuerpo6 = (TextView) findViewById(R.id.cuerpo6);
		//cuerpo7 = (TextView) findViewById(R.id.cuerpo7);
		
		String stringCuerpo1 = "<font color=#E65F00> DOSACITRIC </font> se ha elaborado a partir de los resultados obtenidos en los proyectos de investigación PULVERXACT<sup>1</sup> y OPTIDOSA<sup>2</sup>, llevados a cabo por el grupo de investigación de la Unidad de Mecanización y Tecnología Agraria de la Universidad Politécnica de Valencia."; 
		String stringCuerpo2 = "<i> (1)Proyecto PULVERXACT. Implementación de un sistema de decisión de la dosis de producto fitosanitario en tratamientos de plantaciones (frutales, viñedo y cítricos). Contrato AGL 2002-04260-C04. Organismo financiador Ministerio de Ciencia y Tecnología.</i>";
		String stringCuerpo3 = "<i>(2)Proyecto OPTIDOSA. Reducción del uso de producto fitosanitarios en cultivos arbóreos. Optimización de la dosis de aplicación en cítricos, frutales y vid. Contrato AGL 2007-66093-C04. Organismo financiador Ministerio de Educación y Ciencia.</i>";
		//String stringCuerpo4 = "donde 'V' es el volumen de caldo a aplicar en L/Ha, 'l<sub>v</sub>' el índice de dosificación en L/m3 y 'K' es un coeficiente de aplicación que depende de:";
		//String stringCuerpo5 = "- Las características del cultivo, incluídas volumen de la vegetación por unidad de superficie (TRV - Tree Row Volumen), densidad foliar y grado de poda.";
		//String stringCuerpo6 = "- Las características de tratamiento, incluidas el tipo de plaga y el producto empleado en su control.";
		//String stringCuerpo7 = "- Las condiciones metereológicas en las que se prevé hacer el tratamiento, temperatura, velocidad del viento y humedad relativa.";
		
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		//cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		//cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		//cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		//cuerpo7.setText(Html.fromHtml(stringCuerpo7));

		Button anterior = (Button) findViewById(R.id.anterior);
		anterior.setClickable(true);
		anterior.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(AcercaDe_2.this, AcercaDe_1.class));
				finish();
			}
		});
		
		Button volver = (Button) findViewById(R.id.volver);
		volver.setClickable(true);
		volver.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				//startActivity(new Intent(AcercaDe_2.this, Resultados1.class));
				finish();
			}
		});

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
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

}
