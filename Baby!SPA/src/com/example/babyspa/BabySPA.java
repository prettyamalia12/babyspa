package com.example.babyspa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.babyspa.R;
import com.example.babyspa.BabySPA;
import com.example.babyspa.homepage;


public class BabySPA extends Activity {
    
	 @Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_baby_sp);
			
			Button loginadmin =(Button)findViewById(R.id.button1); 
			loginadmin.setOnClickListener(new click02());
			
			Button go =(Button)findViewById(R.id.go); 
			go.setOnClickListener(new click01());
			

				
	 }			
				class click01 implements Button.OnClickListener{

					@Override
					public void onClick(View arg0) {
					Intent i = new Intent(BabySPA.this,homepage.class);
					
					startActivity(i);
						
					}
				}
					
					class click02 implements Button.OnClickListener{

						@Override
						public void onClick(View arg0) {
						Intent i = new Intent(BabySPA.this,login.class);
						
						startActivity(i);
							
						}
					
				}
				}
    

