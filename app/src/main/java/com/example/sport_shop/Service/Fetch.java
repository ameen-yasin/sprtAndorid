//package com.example.sport_shop;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//
//public class Fetch {
//    private String url,activity;
//
//    public Fetch(String url, String activity){
//        this.url = url;
//        this.activity=activity;
//    }
//
//    public String getActivity() {
//        return activity;
//    }
//
//    public void setActivity(String activity) {
//        this.activity = activity;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
////    public void onLoad() {
////        if (ContextCompat.checkSelfPermission(activity+".this", Manifest.permission.INTERNET)
////                != PackageManager.PERMISSION_GRANTED) {
////
////            ActivityCompat.requestPermissions(activity.this,
////                    new String[]{Manifest.permission.INTERNET},
////                    123);
////
////        } else {
////            DownloadTextTask runner = new DownloadTextTask();
////            runner.execute(url);
////        }
////    }
//
//
//    private InputStream OpenHttpConnection(String urlString) throws IOException {
//        InputStream in = null;
//        int response = -1;
//
//        URL url = new URL(urlString);
//        URLConnection conn = url.openConnection();
//
//        if (!(conn instanceof HttpURLConnection))
//            throw new IOException("Not an HTTP connection");
//        try {
//            HttpURLConnection httpConn = (HttpURLConnection) conn;
//            httpConn.setAllowUserInteraction(false);
//            httpConn.setInstanceFollowRedirects(true);
//            httpConn.setRequestMethod("GET");
//
//            httpConn.connect();
//            Log.d("Networking:", "Ameen");
//
//            response = httpConn.getResponseCode();
//            if (response == HttpURLConnection.HTTP_OK) {
//                in = httpConn.getInputStream();
//            }
//        } catch (Exception ex) {
//            Log.d("Networking", ex.getLocalizedMessage());
//            throw new IOException("Error connecting");
//        }
//        return in;
//    }
//
//    private String DownloadText(String URL) {
//        int BUFFER_SIZE = 2000;
//        InputStream in = null;
//        try {
//            in = OpenHttpConnection(URL);
//        } catch (IOException e) {
//            Log.d("Networking", e.getLocalizedMessage());
//            return "";
//        }
//
//        InputStreamReader isr = new InputStreamReader(in);
//        int charRead;
//        String str = "";
//        char[] inputBuffer = new char[BUFFER_SIZE];
//        try {
//            while ((charRead = isr.read(inputBuffer)) > 0) {
//                //---convert the chars to a String---
//                String readString =
//                        String.copyValueOf(inputBuffer, 0, charRead);
//                str += readString;
//                inputBuffer = new char[BUFFER_SIZE];
//            }
//            in.close();
//        } catch (IOException e) {
//            Log.d("Networking", e.getLocalizedMessage());
//            return "";
//        }
//        return str;
//    }
//
//    private class DownloadTextTask extends AsyncTask<String, Void, String> {
//        @Override
//        protected String doInBackground(String... urls) {
//            return DownloadText(urls[0]);
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
////            Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
//            String[] taskListString = result.split("#");
//            for (int index = 0; index < taskListString.length; index++) {
//                String[] tasks = taskListString[index].split(",");
////                Item item = new Item(Integer.parseInt(tasks[0]), Integer.parseInt(tasks[2]), tasks[1], tasks[3]);
////                taskList.add(task);
//            }
////            EditText txtBooks = findViewById(R.id.txtBooks);
////            txtBooks.setText(result);
//        }
//    }
//}
