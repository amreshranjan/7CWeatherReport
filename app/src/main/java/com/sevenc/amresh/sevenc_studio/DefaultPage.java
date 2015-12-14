package com.sevenc.amresh.sevenc_studio;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Amresh on 12/15/2015.
 * This class is used for showing the first activity as an appearance image for application
 */
public class DefaultPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_page);
        Thread timer=new Thread(){
            public void run()
            {
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    CheckConnectivity isConnected= new CheckConnectivity(getApplicationContext());
                    if (isConnected.isConnectingToInternet()) {
                        Intent openMain = new Intent(DefaultPage.this, MainActivity.class);
                        startActivity(openMain);
                        finish();
                    }
                    else
                    {
                        Intent openMain = new Intent(DefaultPage.this, MainActivity1.class);
                        startActivity(openMain);
                        finish();
                    }


                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        System.exit(0);
    }

}
