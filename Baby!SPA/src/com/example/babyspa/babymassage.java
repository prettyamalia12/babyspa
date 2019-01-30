package com.example.babyspa;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class babymassage extends Activity {
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.babymassage);
		
		VideoView video = (VideoView)findViewById(R.id.videoView1);
		Uri lokasiVideo = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.massage);
		
		video.setVideoURI(lokasiVideo);
		video.start();
		
	}
}
