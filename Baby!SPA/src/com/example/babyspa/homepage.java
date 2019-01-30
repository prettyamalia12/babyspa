package com.example.babyspa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.example.babyspa.R;
import com.example.babyspa.homepage;


public class homepage extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		
		ImageButton whatisbabyspa =(ImageButton)findViewById(R.id.imageButton2); 
		whatisbabyspa.setOnClickListener(new klik1());
		
		ImageButton whatarethebenefits =(ImageButton)findViewById(R.id.btnBack1); 
		whatarethebenefits.setOnClickListener(new klik2());
		
		ImageButton knowmore =(ImageButton)findViewById(R.id.imageButton3); 
		knowmore.setOnClickListener(new klik3());
		
		ImageButton massage =(ImageButton)findViewById(R.id.imageButton1); 
		massage.setOnClickListener(new klik4());
		


			
 }			
	class klik1 implements ImageButton.OnClickListener{

		@Override
		public void onClick(View arg0) {
		Intent i = new Intent(homepage.this,whatisbabyspa.class);
		
		startActivity(i);
			
		}
		
	}

class klik2 implements ImageButton.OnClickListener{

	@Override
	public void onClick(View arg0) {
	Intent i = new Intent(homepage.this,whatarethebenefits.class);
	
	startActivity(i);
		
	}
	

}
class klik3 implements ImageButton.OnClickListener{

	@Override
	public void onClick(View arg0) {
	Intent i = new Intent(homepage.this,knowmore.class);

	startActivity(i);
		
	}
}
	
	class klik4 implements ImageButton.OnClickListener{

		@Override
		public void onClick(View arg0) {
		Intent i = new Intent(homepage.this,babymassage.class);
		
		startActivity(i);
			
		}
		
	
}
	
}

	