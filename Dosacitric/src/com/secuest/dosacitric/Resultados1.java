package com.secuest.dosacitric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados1 extends ActionBarActivity{


	private ParteA parteA;
	private String hola;
	
	private TextView fechaDiaResultados1;
	private TextView fechaMesResultados1;
	private TextView fechaAnoResultados1;
	private TextView idParcelaResultados1;
	private TextView idTratamientoResultados1;
	private TextView referenciaResultados1;
	private TextView densidadFoliar;
	private TextView xAncho;
	private TextView yDistancia; 
	private TextView volumenArbol;
	private TextView formaArbol; 
	private TextView fechaUltimaPoda; 
	private TextView gradoPoda ;
	private TextView productosAplicar;
	private TextView formaActuacion;
	private TextView utilizaMojantes; 
	private TextView zonaCriticaATratar;
	private TextView temperatura;
	private TextView humedadRelativa; 
	private TextView velocidadViento;
	private TextView tipoPulverizador;
	private TextView L_Ha ;
	private TextView L_Hg;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados1);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);		
		fechaDiaResultados1 = (TextView) findViewById(R.id.fechaDiaResultados1);
		 fechaMesResultados1 = (TextView) findViewById(R.id.fechaMesResultados1);
		 fechaAnoResultados1 = (TextView) findViewById(R.id.fechaAnoResultados1);
		 idParcelaResultados1 = (TextView) findViewById(R.id.idParcelaResultados1);
		 idTratamientoResultados1 = (TextView) findViewById(R.id.idTratamientoResultados1);
		 referenciaResultados1 = (TextView) findViewById(R.id.referenciaResultados1);

		/**** A1 ****/


		 densidadFoliar = (TextView) findViewById(R.id.textView23);
		 xAncho = (TextView) findViewById(R.id.textView41);
		 yDistancia = (TextView) findViewById(R.id.textView39);
		 volumenArbol = (TextView) findViewById(R.id.textView25);
		 formaArbol = (TextView) findViewById(R.id.textView26);
		 fechaUltimaPoda = (TextView) findViewById(R.id.textView27);
		 gradoPoda = (TextView) findViewById(R.id.textView28);
		 productosAplicar = (TextView) findViewById(R.id.textView29);
		 formaActuacion = (TextView) findViewById(R.id.textView30);
		 utilizaMojantes = (TextView) findViewById(R.id.textView31);
		 zonaCriticaATratar = (TextView) findViewById(R.id.textView32);
		 temperatura = (TextView) findViewById(R.id.textView33);
		 humedadRelativa = (TextView) findViewById(R.id.textView34);
		 velocidadViento = (TextView) findViewById(R.id.textView35);
		 tipoPulverizador = (TextView) findViewById(R.id.textView36);
		 L_Ha = (TextView) findViewById(R.id.textView37);
		 L_Hg = (TextView) findViewById(R.id.textView38);

		
		
		//Intent i = getIntent();
		// Receiving the Data
		/*String StringAnchocalle = i.getStringExtra("anchocalle");
		String StringDistancia = i.getStringExtra("distancia");
		String StringLongitudArb = i.getStringExtra("longitudArb");
		String StringAnchuraArb = i.getStringExtra("anchuraArb");
		String StringAlturaArb = i.getStringExtra("alturaArb");
		String StringAlturaMeseta = i.getStringExtra("alturaMeseta");
		Log.e("Resultados 1", StringAnchocalle + "." + StringDistancia 
				+ "." + StringLongitudArb + "." + StringAnchuraArb
				+ "." + StringAlturaArb+ "." + StringAlturaMeseta);

		// Displaying Received data
		anchocalle.setText(StringAnchocalle);
		distancia.setText(StringDistancia);
		longitudArb.setText(StringLongitudArb);
		anchuraArb.setText(StringAnchuraArb);
		alturaArb.setText(StringAlturaArb);
		alturaMeseta.setText(StringAlturaMeseta);*/

		Intent aR = getIntent();
		ParteA resultadosA3 = (ParteA) aR.getSerializableExtra("partea3");
		resultadosA3.calcularParteA();

		System.out.println(resultadosA3.day);
		System.out.println(resultadosA3.month);
		System.out.println(resultadosA3.year);
		System.out.println(resultadosA3.idParcela);
		System.out.println(resultadosA3.idTratamiento);
		System.out.println(resultadosA3.Referencia);
		//System.out.println(resultadosA3.AlturaMeseta);
		System.out.println(resultadosA3.AnchoCalle);
		System.out.println(resultadosA3.AnchuraArboles);
		System.out.println("Densidad Foliar" + resultadosA3.DensidadFoliar);
		System.out.println(resultadosA3.DistanciaArboles);
		System.out.println("Fecha Última Poda" + resultadosA3.FechaUltimaPoda);
		System.out.println("Forma Actuación" + resultadosA3.FormaActuacion);
		System.out.println("Forma Arbol" + resultadosA3.FormaArbol);
		System.out.println("Grado de Poda" + resultadosA3.GradoPoda);
		System.out.println("Humedad" + resultadosA3.Humedad);
		System.out.println(resultadosA3.LongitudArboles);
		System.out.println("Utiliza Mojantes" + resultadosA3.Mojantes);
		System.out.println("Productos Aplicar" + resultadosA3.ProductosAplicar);
		System.out.println("Temperatura" + resultadosA3.Temperatura);
		System.out.println("Tipo de Pulverizador" + resultadosA3.TipoPulverizador);
		System.out.println("Velocidad de Viento" + resultadosA3.VelocidadViento);
		System.out.println(resultadosA3.VolumenArbol);
		System.out.println("Zona Crítica" + resultadosA3.ZonaCriticaTratar);
		System.out.println(resultadosA3.VolumenAppLHA);

		fechaDiaResultados1.setText(String.valueOf(resultadosA3.day));
		fechaMesResultados1.setText(String.valueOf(resultadosA3.month));
		fechaAnoResultados1.setText(String.valueOf(resultadosA3.year));
		idParcelaResultados1.setText(String.valueOf(resultadosA3.idParcela));
		idTratamientoResultados1.setText(String.valueOf(resultadosA3.idTratamiento));
		referenciaResultados1.setText(String.valueOf(resultadosA3.Referencia));

		if (resultadosA3.IndiceDensidadFoliar == 0){
			densidadFoliar.setText("Baja");
		}
		else if (resultadosA3.IndiceDensidadFoliar == 1){
			densidadFoliar.setText("Media");
		}
		else {
			densidadFoliar.setText("Alta");
		}

		//densidadFoliar.setText(String.valueOf(resultadosA3.DensidadFoliar));
		xAncho.setText(String.valueOf(resultadosA3.AnchoCalle));
		yDistancia.setText(String.valueOf(resultadosA3.DistanciaArboles));
		volumenArbol.setText(String.valueOf(resultadosA3.VolumenArbol));

		if (resultadosA3.IndiceFormaArbol == 0) {
			formaArbol.setText("Esférica");
		}
		else{
			formaArbol.setText("Seto");
		}
		//formaArbol.setText(String.valueOf(resultadosA3.FormaArbol));

		if (resultadosA3.IndiceFechaUltimaPoda == 0){
			fechaUltimaPoda.setText("< 3 meses");
		}
		else if (resultadosA3.IndiceFechaUltimaPoda == 1){
			fechaUltimaPoda.setText("3 - 12 meses");
		}
		else if (resultadosA3.IndiceFechaUltimaPoda == 2){
			fechaUltimaPoda.setText("1 - 2 años");
		}
		else{
			fechaUltimaPoda.setText("> 2 años");
		}
		//fechaUltimaPoda.setText(String.valueOf(resultadosA3.FechaUltimaPoda));

		if (resultadosA3.IndiceGradoPoda == 0){
			gradoPoda.setText("Bajo");
		}
		else if (resultadosA3.IndiceGradoPoda == 1){
			gradoPoda.setText("Medio");
		}
		else {
			gradoPoda.setText("Alto");
		}
		//gradoPoda.setText(String.valueOf(resultadosA3.GradoPoda));

		if (resultadosA3.IndiceProductosAplicar == 0){
			productosAplicar.setText("Acaricidas");
		}
		else if (resultadosA3.IndiceProductosAplicar == 1){
			productosAplicar.setText("Fungicidas");
		}
		else if (resultadosA3.IndiceProductosAplicar == 2){
			productosAplicar.setText("Insecticidas");
		}
		else if (resultadosA3.IndiceProductosAplicar == 3){
			productosAplicar.setText("Abonos foliares");
		}
		else {
			productosAplicar.setText("Fitorreguladores");
		}
		//productosAplicar.setText(String.valueOf(resultadosA3.ProductosAplicar));

		if (resultadosA3.IndiceFormaActuacion == 0){
			formaActuacion.setText("Por asfixia (aceite)");
		}
		else if (resultadosA3.IndiceFormaActuacion == 1){
			formaActuacion.setText("Por contacto");
		}
		else if (resultadosA3.IndiceFormaActuacion == 2){
			formaActuacion.setText("Por ingestión");
		}
		else if (resultadosA3.IndiceFormaActuacion == 3){
			formaActuacion.setText("Por inhalación");
		}
		else if (resultadosA3.IndiceFormaActuacion == 4){
			formaActuacion.setText("Traslaminar");
		}
		else {
			formaActuacion.setText("Sistémicos");
		}
		//formaActuacion.setText(String.valueOf(resultadosA3.FormaActuacion));

		if (resultadosA3.IndiceMojantes == 0){
			utilizaMojantes.setText("Sí");
		}
		else {
			utilizaMojantes.setText("No");
		}
		//utilizaMojantes.setText(String.valueOf(resultadosA3.Mojantes));


		if (resultadosA3.IndiceZonaCriticaTratar == 0){
			zonaCriticaATratar.setText("Interior");
		}
		else if (resultadosA3.IndiceZonaCriticaTratar == 1){
			zonaCriticaATratar.setText("Interior y exterior");
		}
		if (resultadosA3.IndiceZonaCriticaTratar == 2){
			zonaCriticaATratar.setText("Exterior");
		}
		//zonaCriticaATratar.setText(String.valueOf(resultadosA3.ZonaCriticaTratar));

		if (resultadosA3.IndiceTemperatura == 0){
			temperatura.setText("< 15 ºC");
		}
		else if (resultadosA3.IndiceTemperatura == 1){
			temperatura.setText("De 15 a 25 ºC");
		}
		else {
			temperatura.setText("De 25 a 30 ºC");
		}
		//temperatura.setText(String.valueOf(resultadosA3.Temperatura));

		if (resultadosA3.IndiceHumedad == 0){
			humedadRelativa.setText("< 35% (muy seco)");
		}
		else if (resultadosA3.IndiceHumedad == 1){
			humedadRelativa.setText("35-60% (normal)");
		}
		else {
			humedadRelativa.setText("> 60% (muy húmedo)");
		}
		//humedadRelativa.setText(String.valueOf(resultadosA3.Humedad));

		if (resultadosA3.VelocidadViento == 1){
			velocidadViento.setText("< 1m/s (sin viento)");
		}
		else {
			velocidadViento.setText("1-3 m/s (brisa suave)");
		}
		//velocidadViento.setText(String.valueOf(resultadosA3.VelocidadViento));

		if (resultadosA3.TipoPulverizador == 1){
			tipoPulverizador.setText("Pulv. hidroneumático");
		}
		else {
			tipoPulverizador.setText("Pistola");
		}
		//tipoPulverizador.setText(String.valueOf(resultadosA3.TipoPulverizador));

		L_Ha.setText(String.valueOf(resultadosA3.VolumenAppLHA));
		//L_Hg.setText(String.valueOf(resultadosA3.VolumenAppLHG));

		Log.e("didi", resultadosA3.DensidadFoliar+"");
		Log.e("didi", resultadosA3.FormaArbol+"");
		//Log.e("didi", resultadosA3.AlturaMeseta+"");

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, B_1Activity.class));
			}
		});

		ImageButton acercaDe = (ImageButton) findViewById(R.id.acercaDe);
		acercaDe.setClickable(true);
		acercaDe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, AcercaDe_1.class));
				finish();
			}
		});

		ImageButton printer = (ImageButton) findViewById(R.id.printer);
		printer.setClickable(true);
		printer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RWFile rw = new RWFile();
				String A = ""+
						"A IDENTIFICACI&Oacute;N DEL TRATAMIENTO<tipo>1<n>"+
						"Fecha "+fechaDiaResultados1.getText().toString()+"/"+fechaMesResultados1.getText().toString()+"/"+fechaAnoResultados1.getText().toString()+"<tipo>3<n>"+
						"Identificaci&oacute;n de la parcela "+idParcelaResultados1.getText().toString()+"<tipo>3<n>"+
						"Identificaci&oacute;n del tratamiento +"+idTratamientoResultados1.getText().toString()+"+<tipo>3<n>"+
						"Refer&eacute;ncia "+referenciaResultados1.getText().toString()+"<tipo>3";
				rw.write("A", A);
				String B = "B VOLUMEN DE APLICACICI&Oacute;N<tipo>1<n>"+
						"B.1 Caracter&iacute;sticas del cultivo<tipo>2<n>"+
						"Densidad foliar del &aacute;rbol "+densidadFoliar.getText().toString()+"<tipo>3<n>"+
						"Marco de plantaci&oacute;n "+xAncho.getText().toString()+" m x "+yDistancia.getText().toString()+" m<tipo>3<n>"+
						"Volumen del &aacute;rbol "+volumenArbol.getText().toString()+"<tipo>3<n>"+
						"Forma del &aacute;rbol "+formaArbol.getText().toString()+"<tipo>3<n>"+
						"Fecha de la &uacute;ltima poda "+fechaUltimaPoda.getText().toString()+"<tipo>3<n>"+
						"Grado de poda "+gradoPoda.getText().toString()+"<tipo>3<n>"+
						"B.2 Tipo de tratamiento<tipo>2<n>"+
						"Productos a aplicar "+productosAplicar.getText().toString()+"<tipo>3<n>"+
						"Forma de actuaci&oacute;n "+formaActuacion.getText().toString()+"<tipo>3<n>"+
						"Utiliza coadyuvantes (mojantes)? "+utilizaMojantes.getText().toString()+"<tipo>3<n>"+
						"Zona cr&iacute;tica a tratar "+zonaCriticaATratar.getText().toString()+"<tipo>3<n>"+
						"B.3 Condiciones meteorol&oacute;gicas<tipo>2<n>"+
						"Temperatura "+temperatura.getText().toString()+"<tipo>3<n>"+
						"Humedad relativa "+humedadRelativa.getText().toString()+"<tipo>3<n>"+
						"Velocidad del viento "+velocidadViento.getText().toString()+"<tipo>3<n>"+
						"B.4 Equipo empleado<tipo>2<n>"+
						"Tipo de pulverizador "+tipoPulverizador.getText().toString()+"<tipo>3<n>"+
						"B.5 Volumen de aplicaci&oacute;n <tipo>2<n>"+
						L_Ha.getText().toString()+"L/ha<tipo>3";
				rw.write("B", B);
				pdfCreator mypdf = new pdfCreator();
				mypdf.crearAyB();
				Toast toast = Toast.makeText(getApplicationContext(), "El PDF sera guardado en DESCARGAS", Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
		Button indice = (Button) findViewById(R.id.indice);
		indice.setClickable(true);
		indice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, Indice.class));
			}
		});
	}

	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
