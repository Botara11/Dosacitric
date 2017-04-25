package com.secuest.dosacitric;

import java.util.ArrayList;

import com.secuest.dosacitric.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomArrayList extends ArrayAdapter<String> {
	
	private ArrayList<String> names;
	private Activity context;

	public CustomArrayList(Activity context, ArrayList<String> resource) {
		super(context, R.layout.c_extra, resource);
		this.context = context;
		this.names = resource;		
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View listViewItem = inflater.inflate(R.layout.c_extra, null, true);

		TextView textViewName = (TextView) listViewItem.findViewById(R.id.Name);

		textViewName.setText(names.get(position));
		
		return  listViewItem;
	}
}
