package com.example.comp231_ihome;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import functionkit.HomeData;

public class ResultActivity extends Activity {

	String houseType;
	int numOfRoom;
	float price;
	String area;
	
	public List<HomeData> houseList;
	
	public List<HomeData> myList;
	
	String msg;
	
	private MobileServiceTable<HomeData> mToDoTable;
	
	private MobileServiceClient mClient;
	
	TextView resultTv;
	Button testBtn;
	
	ListView houseListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		houseList = new ArrayList<HomeData>();
		
		msg="start";
		
		setTitle("Result");
		
		resultTv=(TextView) findViewById(R.id.resultTv);
		
		/*houseType=getIntent().getStringExtra("housetype");
		numOfRoom=Integer.valueOf(getIntent().getStringExtra("numofroom"));
		price=Float.valueOf(getIntent().getStringExtra("price"));
		area=getIntent().getStringExtra("area");*/
		
		//resultTv.setText(houseType);
		/*populateHouselist();
		populateListView();
		listViewOnClick();*/
		
		
		//---------------start invoke query-------------------------
		try {
			mClient = new MobileServiceClient("https://homedata.azure-mobile.net/","TcJmDHPSzvSyjVmYqIJBLeesJOOXyS95",this);
			mToDoTable = mClient.getTable(HomeData.class);
			msg="client connect";
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			msg="client error";
			e1.printStackTrace();
		}
		
		mToDoTable.where().field("housetype").eq("House").and().field("numofroom").eq(1)
		.and().field("price").lt(1000.00)
		.execute(new TableQueryCallback<HomeData>(){

			@Override
			public void onCompleted(List<HomeData> result, int count,
					Exception exception, ServiceFilterResponse response) {
				// TODO Auto-generated method stub
				if(exception==null){
					msg="no exception";
					for(HomeData item:result){
						houseList.add(item);
					}
					
					resultTv.setText("We found "+String.valueOf(houseList.size())+" result");
					
					//populateHouselist();
					populateListView();
					listViewOnClick();
					
				}
				
				
			}
			
			
		});
		
		/*testBtn=(Button) findViewById(R.id.testBtn);
		testBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
		
		
		
		
		
		
		//resultTv.setText(msg);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}
	
	public void listViewOnClick() {
		
		houseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View itemView, int position,
					long id) {
				
				HomeData myHouse=houseList.get(position);
				
				Intent intent=new Intent(ResultActivity.this, DetailActivity.class);
				
				//intent.putExtra("houseType", myHouse.mHouseType); 
				intent.putExtra("houseDesc", myHouse.mHouseDesc); 
				intent.putExtra("numOfRoom", myHouse.mNumOfRoom); 
				intent.putExtra("price", myHouse.mPrice); 
				intent.putExtra("area", myHouse.mArea); 
				intent.putExtra("address", myHouse.mAddress); 
				intent.putExtra("ownerName", myHouse.mOwnerName); 
				intent.putExtra("ownerPhone", myHouse.mOwnerPhone); 
				intent.putExtra("ownerEmail", myHouse.mOwnerEmail); 
				
				startActivity(intent);
				
				
			}
			
			
			
		});
		
		
	}
	
	//add by atom
	/*private void populateHouselist() {
		//add house objects in to List
		houseList.add(new House(1, "26 feather stone rd","test1", "House", 2, 345, "Markham", "Sampate", "madalasampath@gmail.com", "6477727793"));
		houseList.add(new House(2, "adasfa","test2", "House", 2, 355, "Markham", "tony", "djaskdhasj", "asfsa"));
		houseList.add(new House(3, "adasfa","test3", "Condo", 3, 575, "Markham", "tony", "djaskdhasj", "asfsa"));
		houseList.add(new House(4, "adasfa","test4", "Condo", 4, 987, "Scarbrough", "atom", "djaskdhasj", "asfsa"));
		houseList.add(new House(5, "adasfa","test5", "Condo", 4, 157, "Scarbrough", "tony", "djaskdhasj", "asfsa"));
		houseList.add(new House(6, "adasfa","test6", "Apartment", 1, 445, "Tononto", "sheng", "djaskdhasj", "asfsa"));
		houseList.add(new House(7, "adasfa","test7", "Apartment", 1, 558, "Tononto", "sheng", "djaskdhasj", "asfsa"));
		houseList.add(new House(8, "adasfa","test8", "Basement", 1, 489, "Missisuaga", "nong", "djaskdhasj", "asfsa"));
		houseList.add(new House(9, "adasfa","test9", "Basement", 2, 437, "Missisuaga", "nong", "djaskdhasj", "asfsa"));
		
	}*/

	private void populateListView() {
		
		ArrayAdapter<HomeData> adapter=new myListAdapter();
		
		houseListView=(ListView) findViewById(R.id.houseListView);
		//resultTv.setText(String.valueOf(houseList.size()));
		houseListView.setAdapter(adapter);
		
		
		
	}
	
	
	private class myListAdapter extends ArrayAdapter<HomeData>{
		
		public myListAdapter(){
			
			super(ResultActivity.this,R.layout.house_view, houseList);
			
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View itemView=convertView;
			if(itemView==null){
				itemView=getLayoutInflater().inflate(R.layout.house_view, parent, false);
			}
			
			HomeData myHouse=houseList.get(position);
			
			ImageView houseTypeIv=(ImageView)itemView.findViewById(R.id.houseTypeIv);
			
			TextView roomTv=(TextView) itemView.findViewById(R.id.roomLvTv);
			TextView priceTv=(TextView) itemView.findViewById(R.id.priceLvTv);
			TextView addressTv=(TextView) itemView.findViewById(R.id.addressLvTv);
			TextView ownerNameTv=(TextView) itemView.findViewById(R.id.ownerNameLvTv);
			
			//assign value to each view
			if(position/2==0){
				houseTypeIv.setImageResource(R.drawable.cat);
			}else{
				houseTypeIv.setImageResource(R.drawable.pizza);
			}
			
			roomTv.setText(String.valueOf(myHouse.mNumOfRoom));
			priceTv.setText(String.valueOf(myHouse.mPrice));
			addressTv.setText(myHouse.mAddress);
			ownerNameTv.setText(myHouse.mOwnerName);
			
			return itemView;
		}
		
		
		
	}
	
	//set menu option userHelp selection 
	public boolean onOptionsItemSelected(MenuItem item){
		//field by ZAIFU
        Intent intent = new Intent();
        
	    switch(item.getItemId()){
	    case R.id.UserHelp:
	        intent = new Intent(ResultActivity.this,InstructionActivity.class);
	        startActivity(intent);
	        return true; 
	        
	    }
	    return false;
	}

	public void invokeQuery(){
		
		
		
		
	}



}
