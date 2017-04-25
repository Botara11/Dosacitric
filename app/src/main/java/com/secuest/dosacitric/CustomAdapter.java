package com.secuest.dosacitric;

import com.secuest.dosacitric.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressLint("InflateParams")
@SuppressWarnings("rawtypes")
public class CustomAdapter extends ArrayAdapter {
	public static final int TYPE_ODD = 0;
	public static final int TYPE_EVEN = 1;
	public static final int TYPE_SELECTED = 2;
	public static final int TYPE_DESELECTED = 3;
	private ListViewItem[] objects;

	@Override
	public int getViewTypeCount() {
		return 4;
	}
	@Override
	public int getItemViewType(int position) {
		return objects[position].getType();
	}
	@SuppressWarnings("unchecked")
	public CustomAdapter(Context context, int resource, ListViewItem[] objects) {
		super(context, resource, objects);
		this.objects = objects;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		ListViewItem listViewItem = objects[position];
		int listViewItemType = getItemViewType(position);
		if (convertView == null) {
			if (listViewItemType == TYPE_EVEN) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.siniconoslistview_layout , null);
			} else if (listViewItemType == TYPE_ODD) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.zonaslistview , null);
			} else if(listViewItemType == TYPE_SELECTED){
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.seleccionado_layout , null);
			}else if(listViewItemType == TYPE_DESELECTED){
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.seleccionado_layout , null);
			}
			TextView textView = (TextView) convertView.findViewById(R.id.textsuperior);
			viewHolder = new ViewHolder(textView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.getText().setText(listViewItem.getText());
		return convertView;
	}
	
	public void toggleSelected(Integer integer) {
	}
}