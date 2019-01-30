package com.example.babyspa;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class Adapterbaby extends BaseAdapter { 
	 
	private static ArrayList<post> postEntity; 
	private LayoutInflater mInflater; 
	 
	public Adapterbaby(Context context, ArrayList<post> con) { 
		postEntity = con; 
	 	mInflater = LayoutInflater.from(context); 
	} 
	 
	@Override 
	public int getCount() { 
	 	return postEntity.size(); 
	} 

	@Override 
	public Object getItem(int position) { 
	 	return postEntity.get(position); 
	} 

	@Override 
	public long getItemId(int position) {  	 	
		return position; 
	} 
@Override 
public View getView(int position, View convertView, ViewGroup parent) {  	
	ViewHolder mHolder; 
	 
	// Initiate view holder  	
	if (convertView == null) { 
	 	convertView = mInflater.inflate(R.layout.hasilpost, null);  	 	
	 	mHolder = new ViewHolder(); 
	 	mHolder.tvjudul = (TextView) convertView.findViewById(R.id.textViewtitle);  	 	
	 	mHolder.tvisi = (TextView) convertView.findViewById(R.id.textViewisi); 
	 	 	convertView.setTag(mHolder); 
	 	} 
else { 
	 	 	mHolder = (ViewHolder)convertView.getTag(); 
	 	} 
	 	 
	 	// set view content 
	 	mHolder.tvjudul.setText(postEntity.get(position).getjudul());  	 	
	 	mHolder.tvisi.setText(postEntity.get(position).getisi());  	 	
	 	 
	 	return convertView; 
	} 
	static class ViewHolder{
		TextView tvjudul;
		TextView tvisi;
	}
	 

} 

