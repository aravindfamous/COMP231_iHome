package com.example.comp231_ihome;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PhoneCall extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.phone);

      Button startBtn = (Button) findViewById(R.id.makeCall);
      startBtn.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         makeCall();
      }
   });

   }
   protected void makeCall() {
      Log.i("Make call", "");

      Intent phoneIntent = new Intent(Intent.ACTION_CALL);
      phoneIntent.setData(Uri.parse("tel:91-949-039-9477"));

      try {
         startActivity(phoneIntent);
         finish();
         Log.i("Finished making a call...", "");
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(PhoneCall.this, 
         "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
      }
   }
   
}

