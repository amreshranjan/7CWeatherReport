package com.sevenc.amresh.sevenc_studio;
 import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

        import org.apache.http.HttpEntity;
        import org.apache.http.HttpResponse;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.params.BasicHttpParams;
        import org.apache.http.util.EntityUtils;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    GridView listView;
    ArrayList<Weather> weatherList =null;
    static String Data=null;
    ArrayList<String> listDate = new ArrayList<String>();
    ArrayList<Integer> listImage = new ArrayList<Integer>();
    ArrayList<String> listTemp = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        listView = (GridView) findViewById(R.id.list);

        weatherList= new ArrayList<Weather>();
        new AsyncProductstask().execute("http://api.worldweatheronline.com/free/v1/weather.ashx?q=bangalore&format=json&num_of_days=5&key=329c87ezzdxyx73v8wahx9cm");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_assignment, menu);
        menu.findItem(R.id.action_month);
        return true;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class AsyncProductstask extends AsyncTask<String, Void, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params) {
            DefaultHttpClient   httpclient = new DefaultHttpClient(new BasicHttpParams());
            HttpPost httppost = new HttpPost(params[0]);
            httppost.setHeader("Content-type", "application/json");
            try {
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                Data= EntityUtils.toString(entity);
                JSONObject jObj=new JSONObject(Data);
                JSONObject jobjdata= jObj.getJSONObject("data");
                JSONArray whetherList = jobjdata.getJSONArray("weather");

                for(int i=0; i<whetherList.length(); i++)
                {
                    Weather obj_weather=new Weather();
                    JSONObject jRealObj= whetherList.getJSONObject(i);
                    obj_weather.setDate(jRealObj.getString("date"));
                    obj_weather.setPrecipMM(jRealObj.getString("precipMM"));
                    obj_weather.setTempMaxC(jRealObj.getString("tempMaxC"));
                    obj_weather.setTempMaxF(jRealObj.getString("tempMaxF"));
                    obj_weather.setTempMinC(jRealObj.getString("tempMinC"));
                    obj_weather.setTempMinF(jRealObj.getString("tempMinF"));
                    obj_weather.setWeatherCode(jRealObj.getString("weatherCode"));
                    obj_weather.setWinddir16Point(jRealObj.getString("winddir16Point"));
                    obj_weather.setWinddirDegree(jRealObj.getString("winddirDegree"));
                    obj_weather.setWinddirection(jRealObj.getString("winddirection"));
                    obj_weather.setWindspeedKmph(jRealObj.getString("windspeedKmph"));
                    obj_weather.setWindspeedMiles(jRealObj.getString("windspeedMiles"));
                    JSONArray weatherDesArray = jRealObj.getJSONArray("weatherDesc");
                    List<WeatherDescription> wd_list= new ArrayList<WeatherDescription>();
                    for(int iterator=0;iterator<weatherDesArray.length();iterator++)
                    {
                        JSONObject jRealWObj= weatherDesArray.getJSONObject(iterator);
                        wd_list.add(new WeatherDescription(jRealWObj.getString("value")));

                    }
                    obj_weather.setWeatherDesc(wd_list);
                    weatherList.add(obj_weather);


                }
                return true;


            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            for (Weather temp:weatherList
                 ) {
                listDate.add(temp.date);
                listTemp.add(temp.getWeatherDesc().get(0).value);
                //listImage.add(temp.getWeatherDesc().get(0).value);
                if(temp.getWeatherDesc().get(0).value.equalsIgnoreCase("sunny")) {
                    listImage.add(R.drawable.sunny);
                }else{
                        listImage.add(R.drawable.sunny_intervals);
                }
                }
            listView.setAdapter(new CustomAdapter(MainActivity.this, listDate,listTemp,listImage,weatherList));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    // ListView Clicked item index
                    int itemPosition = position;
                    Weather mObj = ((CustomAdapter)(parent.getAdapter())).getList().get(position);
                    // ListView Clicked item value
                    String itemValue = (String) listView.getItemAtPosition(position);
                    Bundle bundle = new Bundle();
                    bundle.putString("date",mObj.getDate());
                    bundle.putString("precipMM",mObj.getPrecipMM());
                    bundle.putString("tempMaxC",mObj.getTempMaxC());
                    bundle.putString("tempMaxF",mObj.getTempMaxF());
                    bundle.putString("tempMinC",mObj.getTempMinC());
                    bundle.putString("tempMinF",mObj.getTempMinF());
                    bundle.putString("weatherCode",mObj.getWeatherCode());
                    // Show Alert
                    Intent DetailIntent=new Intent(MainActivity.this,DetailActivity.class);
                    DetailIntent.putExtras(bundle);
                    startActivity(DetailIntent);
                }

            });
            }

    }


}



    //@Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//        // TODO Auto-generated method stub
//        Products selectedProduct = ((JSON_Data)parent.getAdapter()).getItem(position);
//        Intent i = new Intent();
//        Bundle b = new Bundle();
//        b.putParcelable("CHOOS", selectedProduct);
//        i.putExtras(b);
//        i.setClass(this, Content.class);
//        startActivity(i);
//        this.finish();
//    }



