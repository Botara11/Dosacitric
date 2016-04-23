package com.secuest.dosacitric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Indice extends ActionBarActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indice);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.logo256);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		Button siguiente = (Button) findViewById(R.id.siguiente);
		siguiente.setClickable(true);
		siguiente.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, A_1Activity.class));

			}
		});
		
		ImageButton ajustes = (ImageButton) findViewById(R.id.ajustes);
		ajustes.setClickable(true);
		ajustes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, Ajustes.class));

			}
		});
		
		ImageButton ayuda = (ImageButton) findViewById(R.id.ayuda);
		ayuda.setClickable(true);
		ayuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Indice.this, AyudaIndice.class));

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
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
