package ir.plusteam.jalse8;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class NetworkUtilities {


    public interface DownloadFileListener
    {
        void PublishProgress(long downloadedSize, int fileLength);
    }

    /**
     *
     * <p>
     *   check network is available or not <br/>
     *   internet connection is not matter,for check internet connection refer to IsInternetConnected() Method in this class
     * </p>
     * @param context
     * @return returns true if a network is available
     */
    public boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    /**
     * ICMP(ping to any Address)
     * <p>
     *     to run this method you need to this permission:<br/>
     *     android.permission.INTERNET
     * </p>
     * @param hostAddress
     * @return
     */
    public boolean Ping(String hostAddress,int countOfRequest,int expectingResponseValue) throws IOException, InterruptedException {

        Process ipProcess = Runtime.getRuntime().exec("/system/bin/ping -c "+countOfRequest+" "+hostAddress);
        int     exitValue = ipProcess.waitFor();
        return (exitValue == expectingResponseValue);
    }

    /**
     *ICMP(ping to any Address with one request)
     * <p>
     *     to run this method you need to this permission:<br/>
     *     android.permission.INTERNET
     * </p>
     * @param Address
     * @return
     */
    public boolean Ping(String Address) throws IOException, InterruptedException {
        return Ping(Address,1,0);
    }


    /**
     * you can download any file with it by 64KB Blocks
     * @param urlToDownload file Url
     * @param saveLocation physical memory to save file on it
     * @param downloadFileListener downloaf file events
     * @return downloaded File
     */
    public File DownloadFile(String urlToDownload,String saveLocation,DownloadFileListener downloadFileListener) throws IOException {
        File file = new File(saveLocation);

        //the file going to be replaced if the file is existed
        if (file.canWrite() && file.exists())
            file.delete();

        URL url = new URL(urlToDownload);
        URLConnection connection = url.openConnection();
        connection.connect();
        // this will be useful so that you can show a typical 0-100% progress bar
        int fileLength = connection.getContentLength();

        // download the file
        InputStream input = new BufferedInputStream(connection.getInputStream());

        OutputStream output = new FileOutputStream(saveLocation);

        //the blocks of stream are 64KB
        int SixtyFourKB=64*1024;
        byte data[] = new byte[SixtyFourKB];
        long total = 0;
        int count;
        while ((count = input.read(data)) != -1) {
            total += count;
            output.write(data, 0, count);

            //if you need display progress bar or something its good
            if(downloadFileListener!=null)
                downloadFileListener.PublishProgress(total,fileLength);
        }

        output.flush();
        output.close();
        input.close();

        return new File(saveLocation);
    }

    public ReturnedData HttpGetConnection(String urlAddress) throws IOException {

        URL url=new URL(urlAddress);
        HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        ReturnedData data=new ReturnedData();
        data.setResponseCode(responseCode);
        data.setContent(response.toString());
        return data;
    }

    /*
    post data to any address you want
     */
    public String PostHttpData(String urlAddress, ContentValues contentValues) throws IOException, JSONException {

        //make query string
        boolean isNotFirst=false;
        String data ="";
        for (String key :contentValues.keySet())
        {
            if(isNotFirst)
                data+="&";
            data+=URLEncoder.encode(key, "UTF-8")
                    + "=" + URLEncoder.encode(contentValues.getAsString(key), "UTF-8");
            isNotFirst=true;
        }

        //make network objects
        //convert to url type and open the connection
        URL url = new URL(urlAddress);
        HttpURLConnection client = (HttpURLConnection) url.openConnection();
        BufferedReader reader=null;

        //a flag to remember us dont run this code at first time,the var must be true in end of loop
        client.setRequestMethod("POST");
        client.setDoOutput(true);

        //set query string is poured in data var
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write( data );
        writer.flush();

        // Get the server response

        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;

        // Read Server Response
        while((line = reader.readLine()) != null)
        {
            // Append server response in string
            sb.append(line + "\n");
        }
        return sb.toString();
    }
}
