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

public class AyudaTipoTratamiento extends ActionBarActivity{
	
	private TextView cuerpo1;
	private TextView cuerpo2;
	private TextView cuerpo3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ayuda_tipo_tratamiento);
		
		cuerpo1 = (TextView) findViewById(R.id.cuerpo1);
		cuerpo2 = (TextView) findViewById(R.id.cuerpo2);
		cuerpo3 = (TextView) findViewById(R.id.cuerpo3);
		
		String stringCuerpo1 = "Se elegirá el producto que se vaya a aplicar entre: <i>acaricidas (1), fungicidas (2), insecticidas (3), abonos foliares (4) y fitorreguladores (5)</i>. Si se van a aplicar dos o más productos en el mismo tratamiendo, se elegirá aquella opción que tenga menor número entre paréntesis.";
		String stringCuerpo2 = "Se seleccionará la forma de actuación de un producto entre: <i>por asfixia - aceites (1), por contacto (2), por ingestión (3), por inhalación (4), producto con acción traslaminar (5) y producto sistémico (6)</i>. Si se van a aplicar dos o más productos en el mismo tratamiento, se elegirá aquella opción que tenga menor número entre paréntesis. La forma de actuación de un producto se puede obtener directamente leyendo la etiqueta del envase o de las páginas del Instituto Valenciano de Investigaciones Agrarias (IVIA) o del Ministerio de Agricultura, Alimentación y Medio Ambiente.";
		String stringCuerpo3 = "En este punto hay que especificar la zona objetivo del tratamiento, es decir, la zona del árbol donde se ubica la plaga o enfermedad a tratar. Las opciones son: <i>zona interior (1), zona interior y exterior (2) y zona exterior (3)</i>. Si se van a tratar dos o más plagas o enfermedades, se eligirá aquella opción que tenga menor número entre paréntesis.";
		
		cuerpo1.setText(Html.fromHtml(stringCuerpo1));
		cuerpo2.setText(Html.fromHtml(stringCuerpo2));
		cuerpo3.setText(Html.fromHtml(stringCuerpo3));

		Button atras = (Button) findViewById(R.id.atras);
		atras.setClickable(true);
		atras.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				//startActivity(new Intent(AyudaTipoTratamiento.this, A_1_3Activity.class));
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
