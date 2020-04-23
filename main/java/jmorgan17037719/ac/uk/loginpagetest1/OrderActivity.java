//package jmorgan17037719.ac.uk.loginpagetest1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class OrderActivity extends AppCompatActivity {
//
//    //private RequestQueue MyRequestQueue;
//    RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
//    EditText textOrder;
//    Button sendOrderButton;
//    EditText tableNumber;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order);
//
//        tableNumber = (EditText) findViewById(R.id.tableNumber);
//        textOrder = (EditText) findViewById(R.id.textOrder);
//        sendOrderButton = (Button) findViewById(R.id.buttonSendOrder);
//
//        sendOrderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data = "{" + "\"Table No: \"" + tableNumber.getText().toString() +
//                        "\"Order: \"" + "\"" + textOrder.getText().toString() +
//                        "}";
//                Submit(data);
//            }
//        });
//    }
//
//    private void Submit(String data)
//    {
//        final String saveData= data;
//        String URL="https://webhook.site/4efa5382-d2aa-4d2f-8c45-97e9b5f439cb";
//
//       // MyRequestQueue = Volley.newRequestQueue(OrderActivity.this);
//        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject objres=new JSONObject(response);
//                    Toast.makeText(OrderActivity.this,objres.toString(),Toast.LENGTH_LONG).show();
//
//
//                } catch (JSONException e) {
//                    Toast.makeText(OrderActivity.this,"Server Error",Toast.LENGTH_LONG).show();
//
//                }
//            }
//        }, new Response.ErrorListener() { //Create an error listener to handle errors
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(OrderActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//
//            @Override
//            protected Map<String, String> getParams()
//            {
//                Map<String, String>  params = new HashMap<String, String>();
//                params.put("Table No", "Order");
//
//
//                return params;
//            }
//        };
//
//        MyRequestQueue.add(MyStringRequest);
//    }
//
//}
