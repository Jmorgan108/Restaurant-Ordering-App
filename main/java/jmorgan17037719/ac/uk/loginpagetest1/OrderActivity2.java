package jmorgan17037719.ac.uk.loginpagetest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OrderActivity2 extends AppCompatActivity {

    EditText textOrder;
    Button sendOrderButton;
    Button returnHome;
    EditText tableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        returnHome = (Button) findViewById(R.id.buttonReturnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent returnIntent = new Intent(OrderActivity2.this, HomeScreenActivity.class);
                startActivity(returnIntent);
            }
        });

        textOrder = (EditText) findViewById(R.id.textOrder);
        tableNumber = (EditText) findViewById(R.id.tableNumber);
        sendOrderButton = (Button)findViewById(R.id.buttonSendOrder);
        sendOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject postData = new JSONObject();
                try {
                    postData.put("Table Number", tableNumber.getText().toString());
                    postData.put("Order", textOrder.getText().toString());

                    new SendOrderDetails().execute("https://webhook.site/4efa5382-d2aa-4d2f-8c45-97e9b5f439cb", postData.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private static class SendOrderDetails extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            Log.e("TAG", params[0]);
            Log.e("TAG", params[1]);
            String data = "";

            HttpURLConnection httpURLConnection = null;
            try {

                httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes("PostData=" + params[1]);
                wr.flush();
                wr.close();

                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(in);

                int inputStreamData = inputStreamReader.read();
                while (inputStreamData != -1) {
                    char current = (char) inputStreamData;
                    inputStreamData = inputStreamReader.read();
                    data += current;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }

            Log.e("TAG", data);
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
        }
    }
}




