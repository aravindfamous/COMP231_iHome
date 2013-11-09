package com.example.comp231_ihome;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  String fontPath = "fonts/chantelli.ttf";
		  
	        // text view label
	        TextView txtLogo = (TextView) findViewById(R.id.textView1);
	 
	        // Loading Font Face
	        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
	 
	        // Applying font
	        txtLogo.setTypeface(tf);
	
	}
	
	public void startApp(View view) 
	{
	    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
	    startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
