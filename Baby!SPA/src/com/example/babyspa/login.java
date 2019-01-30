package com.example.babyspa;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends Activity{
	String pasw ;
    String nama;
    String namaku ="vivi";
    String pswd ="vivi";
    EditText name;
    EditText pass,tampil;
/** Called when the activity is first created. */
   
@Override
    public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.login);
           name = (EditText)findViewById(R.id.uname);
           pass = (EditText)findViewById(R.id.pw);
           Button submit = (Button)findViewById(R.id.login);
           submit.setOnClickListener(new click());
           }
           @SuppressLint("ShowToast")
           class click implements Button.OnClickListener{
           @SuppressLint("ShowToast")
           public void onClick(View v){
           nama = name.getText().toString();
           pasw = pass.getText().toString();
           if((pasw.equals(pswd))&&(nama.equals(namaku))){
                  Toast.makeText(getApplicationContext(),"Welcome, Admin vivi" ,31).show();
                  Intent i = new Intent(login.this, postlist.class);
                  startActivity(i);
           }	else
                  Toast.makeText(getApplicationContext(),"Sorry, username and password are wrong",23).show();
                  name.setText("");
                  pass.setText("");
           }
           }
    }
	


