package com.secuest.dosacitric;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class AyudaA_1_3Activity extends ActionBarActivity{

	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;
	private TextView cuerpo4;
	private TextView cuerpo5;
	private TextView cuerpo6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayudaa_1_3activity);

		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		cuerpo4 = (TextView) findViewById(R.id.cuerpo4);
		cuerpo5 = (TextView) findViewById(R.id.cuerpo5);
		cuerpo6 = (TextView) findViewById(R.id.cuerpo6);
		
		String stringCuerpo1 = "- <font color=#E65F00>Producto a aplicar:</font> Se elegirá el producto que se vaya a aplicar entre: <i>acaricidas (1), fungicidas (2), insecticidas (3), abonos foliares (4) y fitorreguladores (5)</i>. Si se van a aplicar dos o más productos en el mismo tratamiendo, se elegirá aquella opción que tenga menor número entre paréntesis.";
		String stringCuerpo2 = "- <font color=#E65F00>Forma de actuación:</font> Se seleccionará la forma de actuación de un producto entre: <i>por asfixia - aceites (1), por contacto (2), por ingestión (3), por inhalación (4), producto con acción traslaminar (5) y producto sistémico (6)</i>. Si se van a aplicar dos o más productos en el mismo tratamiento, se elegirá aquella opción que tenga menor número entre paréntesis. La forma de actuación de un producto se puede obtener directamente leyendo la etiqueta del envase o de las páginas del Instituto Valenciano de Investigaciones Agrarias (IVIA) o del Ministerio de Agricultura, Alimentación y Medio Ambiente.";
		String stringCuerpo3 = "<i><font color=#E65F00>La forma de actuación de un producto</font> se puede obtener directamente leyendo la etiqueta del envase o de las páginas web del Instituto Valenciano de Investigaciones agrarias (IVIA) o del Ministerio de Agricultura, Alimentación y Medio Ambiente.<i>";
		String stringCuerpo4 = "- <font color=#E65F00>Zona crítica a tratar:</font> En este punto hay que especificar la zona objetivo del tratamiento, es decir, la zona del árbol donde se ubica la plaga o enfermedad a tratar. Las opciones son: <i>zona interior (1), zona interior y exterior (2) y zona exterior (3)</i>. Si se van a tratar dos o más plagas o enfermedades, se eligirá aquella opción que tenga menor número entre paréntesis.";
		String stringCuerpo5 = "Se indicará la <i><font color=#E65F00>temperatura ambiente, humedad relativa y velocidad del viento</font><i>, eligiendo uno de los intervalos establecidos. Si la temperatura es superior a 30ºC, llueve, o la velocidad del viento es superior a 3 m/s, se recomienda no realizar el tratamiento, por tanto, la aplicación mostrará una alerta en la hoja de resultados (R) y no proporcionará resultado del Volumen de aplicación recomendado.";
		String stringCuerpo6 = "En este apartado se deberá elegir entre <i>pulverizador hidroneumático (turbo) o aplicador de alto caudal (pistola)<i>.";
				
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));
		cuerpo4.setText(Html.fromHtml(stringCuerpo4));
		cuerpo5.setText(Html.fromHtml(stringCuerpo5));
		cuerpo6.setText(Html.fromHtml(stringCuerpo6));
		
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
