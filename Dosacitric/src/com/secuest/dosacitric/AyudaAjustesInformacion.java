package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AyudaAjustesInformacion extends AppCompatActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;
	private TextView cuerpo7;
	private TextView cuerpo8;
	private TextView cuerpo9;
	private TextView cuerpo10;
	private TextView cuerpo11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_ajustes_informacion);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		cuerpo6 = (TextView) findViewById(R.id.cuerpo6);
		cuerpo7 = (TextView) findViewById(R.id.cuerpo7);
		cuerpo8 = (TextView) findViewById(R.id.cuerpo8);
		cuerpo9 = (TextView) findViewById(R.id.cuerpo9);
		cuerpo10 = (TextView) findViewById(R.id.cuerpo10);
		cuerpo11 = (TextView) findViewById(R.id.cuerpo11);

		String stringCuerpo1 = "El objetivo de <font color=#ff6600> DOSACITRIC </font> es implementar un sistema de decisión que permita establecer al técnico de la explotación, responsable de hacer los tratamientos, el volumen de caldo a aplicar en los tratamientos fitosanitarios en cítricos, a partir de las características específicas del cultivo, del producto fitosanitario y de la plaga o enfermedad a tratar."; 
		String stringCuerpo2 = "<font color=#ff6600> DOSACITRIC </font> determina el volumen de caldo a aplicar a partir de la fórmula";
		String stringCuerpo3 = "V = TRV · I <sub>v</sub> · K";
		String stringCuerpo4 = "donde 'V' es el volumen de caldo a aplicar en L/Ha, 'l<sub>v</sub>' el índice de dosificación en L/m3 y 'K' es un coeficiente de aplicación que depende de:";
		String stringCuerpo5 = "- Las características del cultivo, incluídas volumen de la vegetación por unidad de superficie (TRV - Tree Row Volumen), densidad foliar y grado de poda.";
		String stringCuerpo6 = "- Las características de tratamiento, incluidas el tipo de plaga y el producto empleado en su control.";
		String stringCuerpo7 = "- Las condiciones metereológicas en las que se prevé hacer el tratamiento, temperatura, velocidad del viento y humedad relativa.";
		String stringCuerpo8 = "<font color=#ff6600> DOSACITRIC </font> se ha elaborado a partir de los resultados obtenidos en los proyectos de investigación PULVERXACT<sup>1</sup> y OPTIDOSA<sup>2</sup>, llevados a cabo por el grupo de investigación de la Unidad de Mecanización y Tecnología Agraria de la Universidad Politécnica de Valencia."; 
		String stringCuerpo9 = "<i> (1)Proyecto PULVERXACT. Implementación de un sistema de decisión de la dosis de producto fitosanitario en tratamientos de plantaciones (frutales, viñedo y cítricos). Contrato AGL 2002-04260-C04. Organismo financiador Ministerio de Ciencia y Tecnología.</i>";
		String stringCuerpo10 = "<i>(2)Proyecto OPTIDOSA. Reducción del uso de producto fitosanitarios en cultivos arbóreos. Optimización de la dosis de aplicación en cítricos, frutales y vid. Contrato AGL 2007-66093-C04. Organismo financiador Ministerio de Educación y Ciencia.</i>";
		String stringCuerpo11 = "Elaborada por :)";

		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		cuerpo7.setText(Html.fromHtml(stringCuerpo7));
		cuerpo8.setText(Html.fromHtml(stringCuerpo8));
		cuerpo9.setText(Html.fromHtml(stringCuerpo9));
		cuerpo10.setText(Html.fromHtml(stringCuerpo10));
		cuerpo11.setText(Html.fromHtml(stringCuerpo11));

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
