package com.secuest.dosacitric;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados1 extends AppCompatActivity{

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
	private TextView m3Arbol;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultados1);

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		
		fechaDiaResultados1 = (TextView) findViewById(R.id.fechaMesResultados1);
		fechaMesResultados1 = (TextView) findViewById(R.id.fechaDiaResultados1);
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
		m3Arbol = (TextView) findViewById(R.id.textView42);

		Intent aR = getIntent();
		ParteA resultadosA3 = (ParteA) aR.getSerializableExtra("partea3");
		resultadosA3.calcularParteA();
		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);

		String[] fech = settings.getString("fecha", "").split("-");

		fechaDiaResultados1.setText(String.valueOf(fech[0]));
		fechaMesResultados1.setText(String.valueOf(fech[1]));
		fechaAnoResultados1.setText(String.valueOf(fech[2]));
		idParcelaResultados1.setText(String.valueOf(settings.getString("idparcela", "")));
		idTratamientoResultados1.setText(String.valueOf(settings.getString("idtratamiento", "")));
		referenciaResultados1.setText(String.valueOf(settings.getString("referencia", "")));

		if (resultadosA3.IndiceDensidadFoliar == 0){
			densidadFoliar.setText("Baja");
		}
		else if (resultadosA3.IndiceDensidadFoliar == 1){
			densidadFoliar.setText("Media");
		}
		else {
			densidadFoliar.setText("Alta");
		}

		xAncho.setText(String.format("%.2f", resultadosA3.AnchoCalle));
		yDistancia.setText(String.format("%.2f", resultadosA3.DistanciaArboles));
		volumenArbol.setText(String.format("%.2f", resultadosA3.VolumenArbol));
		
		if (resultadosA3.IndiceFormaArbol == 0) {
			formaArbol.setText("Esférica");
		}
		else{
			formaArbol.setText("Seto");
		}

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

		if (resultadosA3.IndiceGradoPoda == 0){
			gradoPoda.setText("Bajo");
		}
		else if (resultadosA3.IndiceGradoPoda == 1){
			gradoPoda.setText("Medio");
		}
		else {
			gradoPoda.setText("Alto");
		}

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

		if (resultadosA3.IndiceMojantes == 0){
			utilizaMojantes.setText("Sí");
		}
		else {
			utilizaMojantes.setText("No");
		}

		if (resultadosA3.IndiceZonaCriticaTratar == 0){
			zonaCriticaATratar.setText("Interior");
		}
		else if (resultadosA3.IndiceZonaCriticaTratar == 1){
			zonaCriticaATratar.setText("Interior y exterior");
		}
		if (resultadosA3.IndiceZonaCriticaTratar == 2){
			zonaCriticaATratar.setText("Exterior");
		}

		if (resultadosA3.IndiceTemperatura == 0){
			temperatura.setText("< 15 ºC");
		}
		else if (resultadosA3.IndiceTemperatura == 1){
			temperatura.setText("De 15 a 25 ºC");
		}
		else {
			temperatura.setText("De 25 a 30 ºC");
		}

		if (resultadosA3.IndiceHumedad == 0){
			humedadRelativa.setText("< 35% (muy seco)");
		}
		else if (resultadosA3.IndiceHumedad == 1){
			humedadRelativa.setText("35-60% (normal)");
		}
		else {
			humedadRelativa.setText("> 60% (muy húmedo)");
		}

		if (resultadosA3.VelocidadViento == 1){
			velocidadViento.setText("< 1m/s (sin viento)");
		}
		else {
			velocidadViento.setText("1-3 m/s (brisa suave)");
		}

		if (resultadosA3.TipoPulverizador == 1){
			tipoPulverizador.setText("Pulv. hidroneumático");
		}
		else {
			tipoPulverizador.setText("Pistola");
		}

		String auxiliar = resultadosA3.VolumenAppLHA+"";
		L_Ha.setText(auxiliar);
		m3Arbol.setText(Html.fromHtml("m<sup>3</sup>/árbol"));

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, B_1Activity.class));
			}
		});

		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Resultados1.this, AyudaResultados1.class));
				//finish();
			}
		});

		ImageButton printer = (ImageButton) findViewById(R.id.printer);
		printer.setClickable(true);

		printer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pdfCreator mypdf = new pdfCreator();
				RWFile rw = new RWFile();
				SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
				if(!settings.getString("fecha", "").equals("")){
					String A = ""+
							"A. IDENTIFICACI&Oacute;N DEL TRATAMIENTO<tipo>1<n>"+
							"Fecha: "+settings.getString("fecha", "")+"<tipo>3<n>"+
							"Identificaci&oacute;n de la parcela: "+settings.getString("idparcela", "")+"<tipo>3<n>"+
							"Identificaci&oacute;n del tratamiento: "+settings.getString("idtratamiento", "")+"<tipo>3<n>"+
							"Refer&eacute;ncia: "+settings.getString("referencia", "")+"<tipo>3";
					rw.write("A", A);
					mypdf.readFile("A");
				}
				String B = "B. VOLUMEN DE APLICACI&Oacute;N<tipo>1<n>"+
						"B.1 Caracter&iacute;sticas del cultivo<tipo>2<n>"+
						"Densidad foliar del &aacute;rbol: "+densidadFoliar.getText().toString()+"<tipo>3<n>"+
						"Marco de plantaci&oacute;n: "+xAncho.getText().toString()+" m x "+yDistancia.getText().toString()+" m<tipo>3<n>"+
						"Volumen del &aacute;rbol: "+volumenArbol.getText().toString()+" "+ Html.fromHtml("m<sup>3</sup>/árbol")+"<tipo>3<n>"+
						"Forma del &aacute;rbol: "+formaArbol.getText().toString()+"<tipo>3<n>"+
						"Fecha de la &uacute;ltima poda: "+fechaUltimaPoda.getText().toString()+"<tipo>3<n>"+
						"Grado de poda: "+gradoPoda.getText().toString()+"<tipo>3<n>"+
						"B.2 Tipo de tratamiento<tipo>2<n>"+
						"Productos a aplicar: "+productosAplicar.getText().toString()+"<tipo>3<n>"+
						"Forma de actuaci&oacute;n: "+formaActuacion.getText().toString()+"<tipo>3<n>"+
						"Utiliza coadyuvantes (mojantes)?: "+utilizaMojantes.getText().toString()+"<tipo>3<n>"+
						"Zona cr&iacute;tica a tratar: "+zonaCriticaATratar.getText().toString()+"<tipo>3<n>"+
						"B.3 Condiciones meteorol&oacute;gicas<tipo>2<n>"+
						"Temperatura: "+temperatura.getText().toString()+"<tipo>3<n>"+
						"Humedad relativa: "+humedadRelativa.getText().toString()+"<tipo>3<n>"+
						"Velocidad del viento: "+velocidadViento.getText().toString()+"<tipo>3<n>"+
						"B.4 Equipo empleado<tipo>2<n>"+
						"Tipo de pulverizador: "+tipoPulverizador.getText().toString()+"<tipo>3<n>"+
						"B.5 Volumen de aplicaci&oacute;n <tipo>2<n>"+
						L_Ha.getText().toString()+" L/ha<tipo>3";
				rw.write("B", B);
				mypdf.readFile("B");
				//Calendar cal = Calendar.getInstance();
				String referencia = settings.getString("referencia", "");
				mypdf.finish_document("DosacitricB"+referencia, getApplicationContext());
				//mypdf.finish_document("Dosacitric_B"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));
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


	@Override
	protected void onResume(){
		super.onResume();		
	}


	@Override
	protected void onPause(){
		super.onPause(); 

		SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();

		editor.putString("volumenApp", L_Ha.getText().toString());
		editor.commit();
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
