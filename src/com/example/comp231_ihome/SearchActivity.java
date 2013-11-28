package com.example.comp231_ihome;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchActivity extends Activity {

	
	Spinner HTSpinner;
	Spinner AreaSpinner;
	EditText numOfRoomEdt;
	TextView priceTagTv;
	
	SeekBar priceSeekbar;
	
	public float price;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		setTitle("Search");
		
		numOfRoomEdt=(EditText) findViewById(R.id.roomEdt);
		numOfRoomEdt.setText("1");
		
		
		HTSpinner=(Spinner) findViewById(R.id.houseTypeSpinner);
		AreaSpinner=(Spinner) findViewById(R.id.areaSpinner);
		
		//implement search button
		Button searchBtn=(Button) findViewById(R.id.searchBtn);
		searchBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(SearchActivity.this,ResultActivity.class);
				intent.putExtra("housetype", HTSpinner.getSelectedItem().toString());
				intent.putExtra("numofroom", numOfRoomEdt.getText());
				intent.putExtra("price", price);
				intent.putExtra("area", AreaSpinner.getSelectedItem().toString());
				startActivity(intent);
			}
			
		});
		
		priceTagTv=(TextView) findViewById(R.id.priceTagTv);
		
		//implement seekbar
		priceSeekbar = (SeekBar) findViewById(R.id.priceSeekbar);
		priceSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				price=progress;
				priceTagTv.setText(String.valueOf(price));
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

	    	
	    });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	//set menu option userHelp selection 
	public boolean onOptionsItemSelected(MenuItem item){
		//field by ZAIFU
        Intent intent = new Intent();
        
	    switch(item.getItemId()){
	    case R.id.UserHelp:
	        intent = new Intent(SearchActivity.this,InstructionActivity.class);
	        startActivity(intent);
	        return true; 
	        
	    }
	    return false;
	}
	
	

}
