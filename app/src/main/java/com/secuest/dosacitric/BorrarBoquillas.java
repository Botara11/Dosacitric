package com.secuest.dosacitric;

import java.util.ArrayList;

import com.secuest.dosacitric.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class BorrarBoquillas extends AppCompatActivity{

	private ListView listView;
	private String Selected = ""; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boquillaslistview_borrar);		

		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.mipmap.logo_actionbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		DatabaseHandler db = new DatabaseHandler(this);
		final ArrayList<String> boq = db.getBoquillas("Mis boquillas", 0.0, 100000.0, "p6");

		listView = (ListView) findViewById(R.id.list);
		CustomArrayList customArrayList = new CustomArrayList(this, boq);
		listView.setAdapter(customArrayList);
				
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				
				Selected = boq.get(position);
			}
		});

		Button borrar = (Button) findViewById(R.id.borrar);
		borrar.setClickable(true);
		borrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (Selected.compareTo("")!=0){
					System.out.println(Selected);
					DatabaseHandler db = new DatabaseHandler(getApplicationContext());
					db.deleteFromMisBoqui(Selected);
					startActivity(new Intent(BorrarBoquillas.this, BorrarBoquillas.class));
					finish();
				}
			}
		});
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
