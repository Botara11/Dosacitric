package com.secuest.dosacitric;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Indice extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indice);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, A_1Activity.class));

			}
		});

	//// Click to A_1Activity ////
			TextView identificacionTratamiendo = (TextView) findViewById(R.id.identificacionTratamiendo);
			identificacionTratamiendo.setClickable(true);
			identificacionTratamiendo.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(Indice.this, A_1Activity.class));

				}
			});
		
		//// Click to A_1_3Activity ////
		TextView volumendeapli = (TextView) findViewById(R.id.volumendeapli);
		volumendeapli.setClickable(true);
		volumendeapli.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, A_1_1Activity.class));

			}
		});

		//// Click to ParteB ////
		TextView partB = (TextView) findViewById(R.id.textView7);
		partB.setClickable(true);
		partB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, B_1Activity.class));

			}
		});

		//// Click to ParteC ////
		TextView partC = (TextView) findViewById(R.id.partC);
		partC.setClickable(true);
		partC.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, C_1Activity.class));

			}
		});

	}
	

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
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
		case R.id.ic_action_new:
			// app icon in action bar clicked; goto parent activity.
			SharedPreferences settings = getSharedPreferences("Guarda", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.clear();
			editor.commit();
			int selectedPosition= 0;
		      selectedPosition = settings.getInt("selectedPosition",selectedPosition);
		      
		      int selectedPosition2 = 0; 
		      selectedPosition2 = settings.getInt("spinnerSelection2", selectedPosition2);
		      
		      int selectedPosition3 = 0;
		      selectedPosition3 = settings.getInt("spinnerSelection3", selectedPosition3);
		      
		      int selectedPosition4 = 0;
		      selectedPosition4 = settings.getInt("spinnerSelection4", selectedPosition4);
		      
		      
		      System.out.println("Leer: ancho="+settings.getString("anchocalle", "")+"; "+selectedPosition +" " + selectedPosition2+" "+ selectedPosition3+" "+ selectedPosition4);
			
			startActivity(new Intent(Indice.this, A_1Activity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
