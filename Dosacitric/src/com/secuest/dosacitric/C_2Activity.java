package com.secuest.dosacitric;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class C_2Activity extends ListActivity {

	private ParteC partec2;
	ListView listView ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_2);  

		String[] presiones = { "6 bares", "7 bares", "8 bares", "9 bares",
				"10 bares", "11 bares", "12 bares", "13 bares", "14 bares",
				"15 bares", "16 bares" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, presiones);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView list, View view, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		
		String ola ="ParteC2";
		Log.e("didi", ola);

		Intent c1 = getIntent();
		partec2 = (ParteC) c1.getSerializableExtra("partec1");
		partec2.rellenarC2(item);

		Intent c2 = new Intent(C_2Activity.this, C_3Activity.class);
		c2.putExtra("presion", partec2);
		startActivity(c2);
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


