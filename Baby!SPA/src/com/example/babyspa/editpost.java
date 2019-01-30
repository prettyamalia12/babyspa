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

public class editpost extends Activity{ 
	 
	private String TAG = editpost.class.getName(); 
	 
	private ProgressDialog pDialog;  	
	private EditText etjudul, etisi; 
	private Button btnEdit; 
	 
	String mid; 
	String mjudul; 
	String misi; 
	 
	@Override 
	protected void onCreate(Bundle savedInstanceState) {  	 	
		super.onCreate(savedInstanceState); 
	 	setContentView(R.layout.addpost); 
	 	 
	 	etjudul = (EditText) findViewById(R.id.etjudul); 
	 	etisi = (EditText) findViewById(R.id.etisi); 

Intent iEdit = getIntent(); mid = iEdit.getStringExtra(staticbaby.postid); 
mid = iEdit.getStringExtra(staticbaby.postid); 
mjudul = iEdit.getStringExtra(staticbaby.judul); 
misi = iEdit.getStringExtra(staticbaby.isi); 
	 	 
etjudul.setText(mjudul);  	 	
etisi.setText(misi); 
	 
	 	btnEdit = (Button)findViewById(R.id.button1);  	 	
	 	btnEdit.setText("Update"); 
	 	btnEdit.setOnClickListener(new OnClickListener() { 
	 	 	  	 	 	@Override 
	 	 	public void onClick(View v) { 
	 	 	 	new SendContacts().execute(mid); 
	 	 	} 
	 	}); 
	 	 
	} 
	 
	/** 
	 * Async task class to send json  
	 */ 
	private class SendContacts extends AsyncTask<String, Void, String> { 

	 	@Override 
	 	protected void onPreExecute() {  	 	 	
	 		super.onPreExecute();  	 	 	// Showing progress dialog 
	 	 	pDialog = new ProgressDialog(editpost.this);  	 	 	
	 	 	pDialog.setMessage("Updating your data..."); 
	 	 	pDialog.setCancelable(false);  	 	 	
	 	 	pDialog.show(); 

	 	} 
	 	 
	 	@Override 
	 	protected String doInBackground(String... params) { 

	 		post postEntity = new post(); 
	 	 	postEntity.setpostid(mid); 
	 	 	postEntity.setjudul(etjudul.getText().toString()); 
	 	 	postEntity.setisi(etisi.getText().toString()); 
String result = ""; 

	 	 	try { 
	 	 		HttpHandlerbaby sj = new HttpHandlerbaby(); 
	 	 	 	JSONObject resObj = new JSONObject(sj.sendJson(HttpHandlerbaby. MYURL + 
	 	 	 			HttpHandlerbaby.UPDATE, postEntity)); 
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
*	*/ 
	 	 	if (result.equals(staticbaby.SUCCESS)) { 
	 	 	 	Toast.makeText(editpost.this, "post updated", 
Toast.LENGTH_LONG).show(); 
	 	 	 	Intent iMain = new Intent(editpost.this, postlist.class); 
	 	 	 	finish(); 
	 	 	 	startActivity(iMain); 
	 	 	} else if (result.equals(staticbaby.FAIL)) { 
	 	 	 	Toast.makeText(editpost.this, "Fail to update post", 
Toast.LENGTH_LONG).show(); 
	 	 	} 
	 	 	 
	 	} 
	 
	}
}