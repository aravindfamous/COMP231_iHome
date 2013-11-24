package com.example.comp231_ihome;

import functionkit.ImageAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.ViewPager;

public class InstructionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instruction);
		
		//set user guideline image image
		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
	    ImageAdapter adapter = new ImageAdapter(this);
	    viewPager.setAdapter(adapter);
	    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.instruction, menu);
		return true;
	}

	//set menu option GoBackMain selection 
		public boolean onOptionsItemSelected(MenuItem item){
			//field by ZAIFU
	        Intent intent = new Intent();
	        
		    switch(item.getItemId()){
		    case R.id.GoBackMain:
		        intent = new Intent(InstructionActivity.this,MainActivity.class);
		        startActivity(intent);
		        return true; 
		        
		    }
		    return false;
		}
}
