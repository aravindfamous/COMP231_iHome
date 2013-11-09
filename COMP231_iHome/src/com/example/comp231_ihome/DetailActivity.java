package com.example.comp231_ihome;


import functionkit.Function;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity implements Function {

	
	private String houseType;
	private String houseDesc;
	private int numOfRoom;
	private float price;
	private String area;
	private String address;
	private String ownerName;
	private String ownerPhone;
	private String ownerEmail;
	
	ImageView houseTypeIv;
	TextView houseDescTv;
	TextView roomTv;
	TextView priceTv;
	TextView areaTv;
	TextView addressTv;
	TextView ownerNameTv;
	TextView ownerPhoneTv;
	TextView ownerEmailTv;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		setTitle("Detail");
		
		//retrieve info from previous activity
		houseType=getIntent().getExtras().getString("houseType").toString(); 
		houseDesc=getIntent().getExtras().getString("houseDesc").toString(); 
		numOfRoom=getIntent().getExtras().getInt("numOfRoom"); 
		price=getIntent().getExtras().getFloat("price"); 
		area=getIntent().getExtras().getString("area").toString(); 
		address=getIntent().getExtras().getString("address").toString(); 
		ownerName=getIntent().getExtras().getString("ownerName").toString(); 
		ownerPhone=getIntent().getExtras().getString("ownerPhone").toString(); 
		ownerEmail=getIntent().getExtras().getString("ownerEmail").toString(); 
		
		
		//initial view
		houseTypeIv=(ImageView) findViewById(R.id.houseTypeIv);
		houseDescTv=(TextView) findViewById(R.id.descDetailTv);
		roomTv=(TextView) findViewById(R.id.roomDetailTv);
		priceTv=(TextView) findViewById(R.id.priceDetailTv);
		areaTv=(TextView) findViewById(R.id.areaDetailTv);
		addressTv=(TextView) findViewById(R.id.addressDetailTv);
		ownerNameTv=(TextView) findViewById(R.id.nameDetailTv);
		ownerPhoneTv=(TextView) findViewById(R.id.phoneDetailTv);
		ownerEmailTv=(TextView) findViewById(R.id.emailDetailTv);
		
		//assign value into each view
		/*if(houseType=="House"){
			houseTypeIv.setImageResource(R.drawable.cat);
		}else{
			houseTypeIv.setImageResource(R.drawable.pizza);
		}*/
		houseDescTv.setText(houseDesc);
		roomTv.setText(String.valueOf(numOfRoom).toString());
		priceTv.setText(String.valueOf(price).toString());
		areaTv.setText(area);
		addressTv.setText(address);
		ownerNameTv.setText(ownerName);
		ownerPhoneTv.setText(ownerPhone);
		ownerEmailTv.setText(ownerEmail);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}
	
	//Event add by SN
	public void openGoogleMap(View view){
		openGoogleMap(address+" "+area);
	}

	public void dialOwner(View view){
		dialOwner(ownerPhone);
	}
	
	public void emailOwner(View view){
		emailOwner(ownerEmail);
	}
	
	public void shareByFB(View view){//did not dicede yet
		openGoogleMap(address);
	}
	
	public void shareByTwitter(View view){//did not dicede yet
		openGoogleMap(address);
	}
	
	public void shareByMsg(View view){//did not dicede yet
		openGoogleMap(address);
	}
	
	public void shareByEmail(View view){
		shareOnEmail();
	}

	
	
	@Override
	public void openGoogleMap(String address) {
		
		String uri = "geo:0,0?q="+address;
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
		intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		startActivity(intent);
	}


	@Override
	public void dialOwner(String OwnerPhone) {
		
		try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+OwnerPhone));
            startActivity(callIntent);
        } catch (ActivityNotFoundException activityException) {
            Log.e("Calling a Phone Number", "Call failed", activityException);
        }
		
	}

	@Override
	public void emailOwner(String OwnerEmail) {
		
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("plain/text");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] {OwnerEmail});
		intent.putExtra(Intent.EXTRA_SUBJECT, "Consult for house rental");
		intent.putExtra(Intent.EXTRA_TEXT, "I am interest in this property.\n");
		startActivity(Intent.createChooser(intent, ""));
		
	}

	@Override
	public void shareOnFacebook(String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shareOnTwitter(String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shareOnEmail() {
		
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("plain/text");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I am interest in this property.\n");
		startActivity(Intent.createChooser(sharingIntent,"Share using"));
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
        /*Intent intent = new Intent();
        
	    switch(item.getItemId()){
	    case R.id.UserHelp:
	        intent = new Intent(DetailActivity.this,InstructionActivity.class);
	        startActivity(intent);
	        return true; 
	        
	    }*/
		
	    return false;
	}

		
		

}
