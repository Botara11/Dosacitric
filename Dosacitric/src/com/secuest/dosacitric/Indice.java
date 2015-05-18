package com.secuest.dosacitric;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
				System.out.println("CLICK");
				startActivity(new Intent(Indice.this, A_1_1Activity.class));

			}
		});

		//// Click to A_1_3Activity ////
		TextView volumendeapli = (TextView) findViewById(R.id.volumendeapli);
		volumendeapli.setClickable(true);
		volumendeapli.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(Indice.this, A_1_3Activity.class));

			}
		});

		//// Click to ParteB ////
		TextView partB = (TextView) findViewById(R.id.textView7);
		partB.setClickable(true);
		partB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(Indice.this, B_1Activity.class));

			}
		});

		//// Click to ParteC ////
		TextView partC = (TextView) findViewById(R.id.partC);
		partC.setClickable(true);
		partC.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CLICK");
				startActivity(new Intent(Indice.this, C_1Activity.class));

			}
		});

	}
}
