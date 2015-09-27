package com.secuest.dosacitric;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AcercaDe_1 extends ActionBarActivity{
	
	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo7;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acercade_1);
		
		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		cuerpo6 = (TextView) findViewById(R.id.cuerpo6);
		cuerpo7 = (TextView) findViewById(R.id.cuerpo7);
		
		String stringCuerpo1 = "El objetivo de <font color=#E65F00> DOSACITRIC </font> es implementar un sistema de decisión que permita establecer al técnico de la explotación, responsable de hacer los tratamientos, el volumen de caldo a aplicar en los tratamientos fitosanitarios en cítricos, a partir de las características específicas del cultivo, del producto fitosanitario y de la plaga o enfermedad a tratar."; 
		String stringCuerpo2 = "<font color=#E65F00> DOSACITRIC </font> determina el volumen de caldo a aplicar a partir de la fórmula";
		String stringCuerpo3 = "V = TRV · I <sub>v</sub> · K";
		String stringCuerpo4 = "donde 'V' es el volumen de caldo a aplicar en L/Ha, 'l<sub>v</sub>' el índice de dosificación en L/m3 y 'K' es un coeficiente de aplicación que depende de:";
		String stringCuerpo5 = "- Las características del cultivo, incluídas volumen de la vegetación por unidad de superficie (TRV - Tree Row Volumen), densidad foliar y grado de poda.";
		String stringCuerpo6 = "- Las características de tratamiento, incluidas el tipo de plaga y el producto empleado en su control.";
		String stringCuerpo7 = "- Las condiciones metereológicas en las que se prevé hacer el tratamiento, temperatura, velocidad del viento y humedad relativa.";
		
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo7.setText(Html.fromHtml(stringCuerpo7));

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(AcercaDe_1.this, AcercaDe_2.class));
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
