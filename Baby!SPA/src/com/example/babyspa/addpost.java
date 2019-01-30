package com.example.babyspa;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class addpost extends Activity {
	
	private String TAG = addpost.class.getSimpleName(); 
	 
 	private ProgressDialog pDialog;  	
 	private EditText etjudul, etisi; 
 	private Button btnAdd; 
 	 
 	@Override 
 	protected void onCreate(Bundle savedInstanceState) {  	 	
 		super.onCreate(savedInstanceState); 
 	 	setContentView(R.layout.addpost); 
 	 	 
 	 	etjudul = (EditText) findViewById(R.id.etjudul);  	 	
 	 	etisi = (EditText) findViewById(R.id.etisi); 
 	 	 
 	 	btnAdd = (Button) findViewById(R.id.button1); 
 	 	btnAdd.setOnClickListener(new OnClickListener() { 
 	 	 	 
 	 	 	 
 	 	 	public void onClick(View v) { 
 	 	 	 	new SendContacts().execute(); 
 	 	 	} 
 	 	}); 
 	 	 
 	} 
 	 
 	/** 
 * Async task class to send json  
 */ 
private class SendContacts extends AsyncTask<Void, Void, String> { 
@Override 
protected void onPreExecute() {  	super.onPreExecute();  	 	// Showing progress dialog 
 	 	pDialog = new ProgressDialog(addpost.this);  	 	
 	 	pDialog.setMessage("Adding your data..."); 
 	 	pDialog.setCancelable(false); 
 	 	pDialog.show(); 
 
 	 	} 
 	 	 
 	 	@Override 
 	 	protected String doInBackground(Void... params) { 
 
 	 	 	post post = new post();  	 	 	
 	 	 	post.setjudul(etjudul.getText().toString());  	 	 	
 	 	 	post.setisi(etisi.getText().toString()); 
 	 	 	 
 	 	 	String result = ""; 
 	 	 	 
 	 	 	try { 
 	 	 	 	HttpHandlerbaby sj = new HttpHandlerbaby(); 
    JSONObject resObj = new JSONObject(sj.sendJson(HttpHandlerbaby. MYURL + 
    		HttpHandlerbaby.INSERT, post)); 
 	 	 	 	JSONArray resArr = resObj.getJSONArray(staticbaby.POSTS); 
 	 	 	 	result = resArr.getString(0); 
 	 	 	} catch (JSONException e) { 
 	 	 	 	Log.i(TAG, "JSON parse error " + e.getMessage()); 
 	 	 	} 
 	 	 	 
 	 	 	return result; 
 	 	} 
 	 	 
 	 	@Override 
 	 	protected void onPostExecute(String result) {  	 	 	
 	 		super.onPostExecute(result);  	 	 	// Dismiss the progress dialog  	 	 	
 	 		if (pDialog.isShowing()) 
 	 	 	 	pDialog.dismiss(); 
 
Log.d(TAG, result); 
/** 
*	Show insert information 
*	*/ if (result.equals(staticbaby.SUCCESS)) { 
 	Toast.makeText(addpost.this, "post added", 
Toast.LENGTH_LONG).show(); 
 	 	 	 	Intent iMain = new Intent(addpost.this, postlist.class); 
 	 	 	 	finish(); 
 	 	 	 	startActivity(iMain); 
 	 	 	} else if (result.equals(staticbaby.FAIL)) { 
 	 	 	 	Toast.makeText(addpost.this, "Fail to add post", 
Toast.LENGTH_LONG).show(); 
 	 	 	} 
 	 	 	  	 	} 
 	 
 	} 
} 

