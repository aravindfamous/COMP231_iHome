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
import android.widget.Toast;

public class DetailActivity extends Activity implements Function {

	
	private String houseType;
	private String houseDesc;
	private String numOfRoom;
	private String price;
	private String area;
	private String address;
	private String ownerName;
	private String ownerPhone;
	private String ownerEmail;
	
	ImageView detailHTIv;
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
		
		//initial view
		detailHTIv=(ImageView) findViewById(R.id.detailIv);
		houseDescTv=(TextView) findViewById(R.id.descDetailTv);
		roomTv=(TextView) findViewById(R.id.roomDetailTv);
		priceTv=(TextView) findViewById(R.id.priceDetailTv);
		areaTv=(TextView) findViewById(R.id.areaDetailTv);
		addressTv=(TextView) findViewById(R.id.addressDetailTv);
		ownerNameTv=(TextView) findViewById(R.id.nameDetailTv);
		ownerPhoneTv=(TextView) findViewById(R.id.phoneDetailTv);
		ownerEmailTv=(TextView) findViewById(R.id.emailDetailTv);
		
		
		//retrieve info from previous activity
		
		houseType=getIntent().getStringExtra("houseType").toString(); 
		if(houseType=="House"){
			detailHTIv.setImageResource(R.drawable.pizza);
		}else if(houseType=="Apartment"){
			detailHTIv.setImageResource(R.drawable.apt);
		}else if(houseType=="Condo"){
			detailHTIv.setImageResource(R.drawable.condo);
		}
		
		houseDesc=getIntent().getStringExtra("houseDesc").toString(); 
		numOfRoom=getIntent().getStringExtra("numOfRoom").toString(); 
		price=getIntent().getStringExtra("price").toString(); 
		area=getIntent().getStringExtra("area").toString(); 
		address=getIntent().getStringExtra("address").toString(); 
		ownerName=getIntent().getStringExtra("ownerName").toString(); 
		ownerPhone=getIntent().getStringExtra("ownerPhone").toString(); 
		ownerEmail=getIntent().getStringExtra("ownerEmail").toString(); 
		
		
		//assign value into each view
		
		//--------------------testing---------------
		houseDescTv.setText(houseDesc);
		roomTv.setText(String.valueOf(numOfRoom).toString()+" room");
		priceTv.setText("at  $"+String.valueOf(price).toString());
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
		startActivity(Intent.createChooser(intent, "Email Owner By"));
		
	}

	@Override
	public void shareOnEmail() {
		
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("plain/text");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I just found this place, the information is below:\n"
				+ houseDesc+"\n"+"At "+address+"\n"+"$"+price+"\n"+"Please contact: "+ownerName+"\n"+"At "+ownerPhone+"\n"+"or"+ownerEmail);
		startActivity(Intent.createChooser(sharingIntent,"Share using"));
		
	}
	

	//set menu option userHelp selection 
	public boolean onOptionsItemSelected(MenuItem item){
		//field by ZAIFU
        Intent intent = new Intent();
        
	    switch(item.getItemId()){
	    case R.id.UserHelp:
	        intent = new Intent(DetailActivity.this,InstructionActivity.class);
	        startActivity(intent);
	        return true; 
	        
	    }
	    return false;
	}

	public void showToast(String msg){
		Toast.makeText(this, msg, 2000).show();
	}
		

}
