package in.technicalkeeda.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    public class downloadTask extends AsyncTask<String,Void,String>{

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpsURLConnection httpsURLConnection=null;


            URLConnection urlConnection =null;
            try {
                url=new URL(urls[0]);

                try {
                    urlConnection= url.openConnection();
                    InputStream in=urlConnection.getInputStream();
                    InputStreamReader reader= new InputStreamReader(in);
                    int data=reader.read();
                    while(data!=-1){
                        char current= (char)data;
                        result+=current;
                        data=reader.read();
                    }
                    textView.setText(result);
                    return  result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

       /* @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject=new JSONObject(result);
                int d=jsonObject.getInt("userId");



                textView.setText((int) d);

            } catch (JSONException e) {
                e.printStackTrace();
                textView.setText("something went wrong please check your internet connection ");
            }

        }*/
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView=findViewById(R.id.textview);
       // downloadTask task =new downloadTask();
        String result= null;

        // result = task.execute("https://jsonplaceholder.typicode.com/todos/1").get();
       result ="{\n" +
               "\"type\": \"FeatureCollection\",\n" +
               "\"metadata\": {\n" +
               "\"generated\": 1574312700000,\n" +
               "\"url\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10\",\n" +
               "\"title\": \"USGS Earthquakes\",\n" +
               "\"status\": 200,\n" +
               "\"api\": \"1.8.1\",\n" +
               "\"limit\": 10,\n" +
               "\"offset\": 1,\n" +
               "\"count\": 10\n" +
               "},\n" +
               "\"features\": [\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 7.2,\n" +
               "\"place\": \"88km N of Yelizovo, Russia\",\n" +
               "\"time\": 1454124312220,\n" +
               "\"updated\": 1539812932814,\n" +
               "\"tz\": 720,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us20004vvx\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us20004vvx&format=geojson\",\n" +
               "\"felt\": 3,\n" +
               "\"cdi\": 3.4,\n" +
               "\"mmi\": 5.8,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 799,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"20004vvx\",\n" +
               "\"ids\": \",gcmt20160130032510,at00o1qxho,pt16030050,us20004vvx,gcmt20160130032512,atlas20160130032512,\",\n" +
               "\"sources\": \",gcmt,at,pt,us,gcmt,atlas,\",\n" +
               "\"types\": \",associate,cap,dyfi,finite-fault,general-text,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 0.958,\n" +
               "\"rms\": 1.19,\n" +
               "\"gap\": 17,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 7.2 - 88km N of Yelizovo, Russia\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "158.5463,\n" +
               "53.9776,\n" +
               "177\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us20004vvx\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.1,\n" +
               "\"place\": \"94km SSE of Taron, Papua New Guinea\",\n" +
               "\"time\": 1453777820750,\n" +
               "\"updated\": 1478815803221,\n" +
               "\"tz\": 600,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us20004uks\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us20004uks&format=geojson\",\n" +
               "\"felt\": null,\n" +
               "\"cdi\": null,\n" +
               "\"mmi\": 4.1,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 572,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"20004uks\",\n" +
               "\"ids\": \",gcmt20160126031023,us20004uks,gcmt20160126031020,\",\n" +
               "\"sources\": \",gcmt,us,gcmt,\",\n" +
               "\"types\": \",associate,cap,geoserve,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 1.537,\n" +
               "\"rms\": 0.74,\n" +
               "\"gap\": 25,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.1 - 94km SSE of Taron, Papua New Guinea\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "153.2454,\n" +
               "-5.2952,\n" +
               "26\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us20004uks\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.3,\n" +
               "\"place\": \"50km NNE of Al Hoceima, Morocco\",\n" +
               "\"time\": 1453695722730,\n" +
               "\"updated\": 1507756883299,\n" +
               "\"tz\": 0,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004gy9\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004gy9&format=geojson\",\n" +
               "\"felt\": 117,\n" +
               "\"cdi\": 7.2,\n" +
               "\"mmi\": 5.3,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 0,\n" +
               "\"sig\": 695,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004gy9\",\n" +
               "\"ids\": \",gcmt20160125042203,us10004gy9,gcmt20160125042202,atlas20160125042202,\",\n" +
               "\"sources\": \",gcmt,us,gcmt,atlas,\",\n" +
               "\"types\": \",associate,cap,dyfi,geoserve,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 2.201,\n" +
               "\"rms\": 0.92,\n" +
               "\"gap\": 20,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.3 - 50km NNE of Al Hoceima, Morocco\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "-3.6818,\n" +
               "35.6493,\n" +
               "12\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004gy9\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 7.1,\n" +
               "\"place\": \"86km E of Old Iliamna, Alaska\",\n" +
               "\"time\": 1453631430230,\n" +
               "\"updated\": 1558419847696,\n" +
               "\"tz\": -540,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004gqp\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004gqp&format=geojson\",\n" +
               "\"felt\": 1816,\n" +
               "\"cdi\": 7.2,\n" +
               "\"mmi\": 6.5,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 1496,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004gqp\",\n" +
               "\"ids\": \",ak12496371,at00o1gd6r,us10004gqp,ak01613v15nv,atlas20160124103030,atlas20160124103029,\",\n" +
               "\"sources\": \",ak,at,us,ak,atlas,atlas,\",\n" +
               "\"types\": \",associate,cap,dyfi,finite-fault,general-text,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,trump-origin,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 0.72,\n" +
               "\"rms\": 2.11,\n" +
               "\"gap\": 19,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 7.1 - 86km E of Old Iliamna, Alaska\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "-153.4051,\n" +
               "59.6363,\n" +
               "129\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004gqp\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.6,\n" +
               "\"place\": \"215km SW of Tomatlan, Mexico\",\n" +
               "\"time\": 1453399617650,\n" +
               "\"updated\": 1478815764127,\n" +
               "\"tz\": -420,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004g4l\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004g4l&format=geojson\",\n" +
               "\"felt\": 11,\n" +
               "\"cdi\": 2.7,\n" +
               "\"mmi\": 3.92,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 673,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004g4l\",\n" +
               "\"ids\": \",gcmt20160121180659,at00o1bebo,pt16021050,us10004g4l,gcmt20160121180657,\",\n" +
               "\"sources\": \",gcmt,at,pt,us,gcmt,\",\n" +
               "\"types\": \",associate,cap,dyfi,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 2.413,\n" +
               "\"rms\": 0.98,\n" +
               "\"gap\": 74,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.6 - 215km SW of Tomatlan, Mexico\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "-106.9337,\n" +
               "18.8239,\n" +
               "10\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004g4l\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.7,\n" +
               "\"place\": \"52km SE of Shizunai, Japan\",\n" +
               "\"time\": 1452741933640,\n" +
               "\"updated\": 1507756815178,\n" +
               "\"tz\": 540,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004ebx\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004ebx&format=geojson\",\n" +
               "\"felt\": 51,\n" +
               "\"cdi\": 5.8,\n" +
               "\"mmi\": 5.8,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 720,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004ebx\",\n" +
               "\"ids\": \",us10004ebx,gcmt20160114032534,pt16014050,at00o0xauk,gcmt20160114032533,atlas20160114032533,\",\n" +
               "\"sources\": \",us,gcmt,pt,at,gcmt,atlas,\",\n" +
               "\"types\": \",associate,cap,dyfi,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 0.281,\n" +
               "\"rms\": 0.98,\n" +
               "\"gap\": 22,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.7 - 52km SE of Shizunai, Japan\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "142.781,\n" +
               "41.9723,\n" +
               "46\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004ebx\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.1,\n" +
               "\"place\": \"12km WNW of Charagua, Bolivia\",\n" +
               "\"time\": 1452741928270,\n" +
               "\"updated\": 1478815697357,\n" +
               "\"tz\": -240,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004ebw\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004ebw&format=geojson\",\n" +
               "\"felt\": 3,\n" +
               "\"cdi\": 2.2,\n" +
               "\"mmi\": 2.21,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 0,\n" +
               "\"sig\": 573,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004ebw\",\n" +
               "\"ids\": \",us10004ebw,gcmt20160114032528,\",\n" +
               "\"sources\": \",us,gcmt,\",\n" +
               "\"types\": \",cap,dyfi,geoserve,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 5.492,\n" +
               "\"rms\": 1.04,\n" +
               "\"gap\": 16,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.1 - 12km WNW of Charagua, Bolivia\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "-63.3288,\n" +
               "-19.7597,\n" +
               "582.56\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004ebw\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.2,\n" +
               "\"place\": \"74km NW of Rumoi, Japan\",\n" +
               "\"time\": 1452532083920,\n" +
               "\"updated\": 1478815677682,\n" +
               "\"tz\": 540,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004djn\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004djn&format=geojson\",\n" +
               "\"felt\": 8,\n" +
               "\"cdi\": 3.4,\n" +
               "\"mmi\": 3.74,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 0,\n" +
               "\"sig\": 594,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004djn\",\n" +
               "\"ids\": \",us10004djn,gcmt20160111170803,\",\n" +
               "\"sources\": \",us,gcmt,\",\n" +
               "\"types\": \",cap,dyfi,geoserve,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 1.139,\n" +
               "\"rms\": 0.96,\n" +
               "\"gap\": 33,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.2 - 74km NW of Rumoi, Japan\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "141.0867,\n" +
               "44.4761,\n" +
               "238.81\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004djn\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6.5,\n" +
               "\"place\": \"227km SE of Sarangani, Philippines\",\n" +
               "\"time\": 1452530285900,\n" +
               "\"updated\": 1507756804527,\n" +
               "\"tz\": 480,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004dj5\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004dj5&format=geojson\",\n" +
               "\"felt\": 1,\n" +
               "\"cdi\": 2.7,\n" +
               "\"mmi\": 7.5,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 1,\n" +
               "\"sig\": 650,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004dj5\",\n" +
               "\"ids\": \",gcmt20160111163807,at00o0srjp,pt16011050,us10004dj5,gcmt20160111163805,atlas20160111163805,\",\n" +
               "\"sources\": \",gcmt,at,pt,us,gcmt,atlas,\",\n" +
               "\"types\": \",associate,cap,dyfi,geoserve,impact-link,impact-text,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,tectonic-summary,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 3.144,\n" +
               "\"rms\": 0.72,\n" +
               "\"gap\": 22,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.5 - 227km SE of Sarangani, Philippines\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "126.8621,\n" +
               "3.8965,\n" +
               "13\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004dj5\"\n" +
               "},\n" +
               "{\n" +
               "\"type\": \"Feature\",\n" +
               "\"properties\": {\n" +
               "\"mag\": 6,\n" +
               "\"place\": \"Pacific-Antarctic Ridge\",\n" +
               "\"time\": 1451986454620,\n" +
               "\"updated\": 1478815631921,\n" +
               "\"tz\": -540,\n" +
               "\"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us10004bgk\",\n" +
               "\"detail\": \"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us10004bgk&format=geojson\",\n" +
               "\"felt\": 0,\n" +
               "\"cdi\": 1,\n" +
               "\"mmi\": 0,\n" +
               "\"alert\": \"green\",\n" +
               "\"status\": \"reviewed\",\n" +
               "\"tsunami\": 0,\n" +
               "\"sig\": 554,\n" +
               "\"net\": \"us\",\n" +
               "\"code\": \"10004bgk\",\n" +
               "\"ids\": \",gcmt20160105093415,us10004bgk,gcmt20160105093414,\",\n" +
               "\"sources\": \",gcmt,us,gcmt,\",\n" +
               "\"types\": \",associate,cap,dyfi,geoserve,losspager,moment-tensor,nearby-cities,origin,phase-data,shakemap,\",\n" +
               "\"nst\": null,\n" +
               "\"dmin\": 30.75,\n" +
               "\"rms\": 0.67,\n" +
               "\"gap\": 71,\n" +
               "\"magType\": \"mww\",\n" +
               "\"type\": \"earthquake\",\n" +
               "\"title\": \"M 6.0 - Pacific-Antarctic Ridge\"\n" +
               "},\n" +
               "\"geometry\": {\n" +
               "\"type\": \"Point\",\n" +
               "\"coordinates\": [\n" +
               "-136.2603,\n" +
               "-54.2906,\n" +
               "10\n" +
               "]\n" +
               "},\n" +
               "\"id\": \"us10004bgk\"\n" +
               "}\n" +
               "],\n" +
               "\"bbox\": [\n" +
               "-153.4051,\n" +
               "-54.2906,\n" +
               "10,\n" +
               "158.5463,\n" +
               "59.6363,\n" +
               "582.56\n" +
               "]\n" +
               "}";
        Log.i("msg->", result);

        try {
            JSONObject jsonObject=new JSONObject(result);
            String string=jsonObject.getString("type");



            textView.setText(string);

        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText("something went wrong please check your internet connection ");
        }


       // textView.setText(result);

    }
}
