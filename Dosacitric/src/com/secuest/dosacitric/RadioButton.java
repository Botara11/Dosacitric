package com.secuest.dosacitric;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButton extends Activity {

	private RadioGroup radioSexGroup;
	private RadioGroup radioGroup;
	private RadioButton radioSexButton; 

	@Override
	public void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.b_1);

		addListenerOnButton();

	}

	public void addListenerOnButton() {

		radioSexGroup = (RadioGroup) findViewById(R.id.radioVolumen);
		radioGroup = (RadioGroup) findViewById(R.id.radioAncho);
	}

	public void onClick(View v) {

		// get selected radio button from radioGroup
		int selectedId = radioSexGroup.getCheckedRadioButtonId();
		int selectedId2 = radioGroup.getCheckedRadioButtonId();

		// find the radiobutton by returned id
		//radioSexButton = (RadioButton) findViewById(selectedId);

	}



}
