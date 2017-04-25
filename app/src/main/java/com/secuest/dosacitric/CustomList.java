package com.secuest.dosacitric;

import com.secuest.dosacitric.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class CustomList extends ArrayAdapter<String> {

	private String[] names;
	private Activity context;

	public CustomList(Activity context, String[] names) {
		super(context, R.layout.c_extra, names);
		this.context = context;
		this.names = names;		
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View listViewItem = inflater.inflate(R.layout.c_extra, null, true);

		TextView textViewName = (TextView) listViewItem.findViewById(R.id.Name);

		textViewName.setText(names[position]);

		return  listViewItem;
	}
}
