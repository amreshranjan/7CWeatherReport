package com.sevenc.amresh.sevenc_studio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Amresh on 12/15/2015.
 */
public class DetailActivity extends AppCompatActivity{
    Weather SelectedParcel;
    ImageView ParcelImage;
    TextView DataRowOneLeftText,DataRowOneRightText, DataRowTwoLeftText,DataRowTwoRightText, DataRowThreeLeftText,DataRowThreeRightText;
    Bundle mBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        System.out.println("Inside Detail page!!!");
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        mBundle = getIntent().getExtras();
        ParcelImage = (ImageView) findViewById(R.id.ivParcelImage);
        DataRowOneLeftText=(TextView)findViewById(R.id.tvDataRowOneLeftText);
        DataRowOneRightText=(TextView)findViewById(R.id.tvDataRowOneRightText);
        DataRowTwoLeftText=(TextView)findViewById(R.id.tvDataRowTwoLeftText);
        DataRowTwoRightText=(TextView)findViewById(R.id.tvDataRowTwoRightText);
        DataRowThreeLeftText=(TextView)findViewById(R.id.tvDataRowThreeLeftText);
        DataRowThreeRightText=(TextView)findViewById(R.id.tvDataRowThreeRightText);
        DataRowOneRightText=(TextView)findViewById(R.id.tvDataRowOneRightText);
        DataRowTwoLeftText=(TextView)findViewById(R.id.tvDataRowTwoLeftText);
        DataRowTwoRightText=(TextView)findViewById(R.id.tvDataRowTwoRightText);
        DataRowThreeLeftText=(TextView)findViewById(R.id.tvDataRowThreeLeftText);
        DataRowThreeRightText=(TextView)findViewById(R.id.tvDataRowThreeRightText);

        DataRowOneLeftText.setText(mBundle.getString("date"));
        DataRowOneRightText.setText(mBundle.getString("precipMM"));
        DataRowTwoLeftText.setText(mBundle.getString("tempMaxC"));
        DataRowTwoRightText.setText(mBundle.getString("tempMaxF"));
        DataRowThreeLeftText.setText(mBundle.getString("tempMinC"));
        DataRowThreeRightText.setText(mBundle.getString("weatherCode"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_search) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


    /*public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.btnLink:
                Intent inte = new Intent(Intent.ACTION_VIEW);
           *//*     if (SelectedParcel.getLink() != null) {
                    inte.setData(Uri.parse(SelectedParcel.getLink()));
                } else {
                    inte.setData(Uri.parse("http://theporter.in"));
                }*//*
                startActivity(inte);

                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnShare:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                *//*String shareBody = SelectedParcel.getName()+"\n"
                        + SelectedParcel.getPhone()+"\n"
                        + SelectedParcel.getLink()+"\n";*//*

                *//*sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, SelectedParcel.getName());
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);*//*
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.btnSMS:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);

                break;


        }
    }*/
}
