package com.example.masti_java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;



public class MainActivity extends Activity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);

        OkHttpClient client = new OkHttpClient();

//        String url = "http://10.105.66.242:8080";
        String url = "http://10.105.200.129:8080";
        Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println(request);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    System.out.println(myResponse);

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Button umd = findViewById(R.id.UMD);
//
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println("app starting");
//
//        String c = "curl 10.105.66.242:8080";
//
//        try {
//            System.out.println(getRequest());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
////        try {
////            System.out.println("sending get");
////            sendGet();
////        }
////        catch (Exception e) {
////            System.out.println("unknown exception in onCreate: " + e);
////        }
////        umd.setOnClickListener(new View.OnClickListener() {
////            sendGet();
////
////        });
//
//    }
//
//    public String getRequest() {
//        StringBuffer stringBuffer = new StringBuffer("");
//        BufferedReader bufferedReader = null;
//        try {
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet httpGet = new HttpGet();
//
//            URI uri = new URI("http://sample.campfirenow.com/rooms.xml");
//            httpGet.setURI(uri);
//
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            InputStream inputStream = httpResponse.getEntity().getContent();
//            bufferedReader = new BufferedReader(new InputStreamReader(
//                    inputStream));
//
//            String readLine = bufferedReader.readLine();
//            while (readLine != null) {
//                stringBuffer.append(readLine);
//                stringBuffer.append("\n");
//                readLine = bufferedReader.readLine();
//            }
//        } catch (Exception e) {
//            System.out.println("1: " + e);
//        } finally {
//            if (bufferedReader != null) {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    System.out.println("2: " + e);
//                }
//            }
//        }
//        return stringBuffer.toString();
//    } }
//