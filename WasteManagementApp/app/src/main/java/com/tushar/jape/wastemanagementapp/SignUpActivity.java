package com.tushar.jape.wastemanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.description;

public class SignUpActivity extends AppCompatActivity {

    Button btnSelectPlace;
    FloatingActionButton fab;
    TextInputEditText editName, editAadhar;
    TextView textView;
    ProgressDialog pDialog;
    OutputStream os;
    InputStream is;
    URL url;

    int PICKER_REQUEST = 1;
    double latitude, longitude;
    String name, aadhar;

    private static final String TAG_SUCCESS = "success";

    //TODO Change the url.
    private static String url_string = "https://api.androidhive.info/android_connect/create_product.php";
    private String email;

    JSONParser jsonParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialize();
        setClickListeners();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICKER_REQUEST && resultCode == RESULT_OK){
            Place place = PlacePicker.getPlace(data, this);

            latitude = place.getLatLng().latitude;
            longitude = place.getLatLng().longitude;

            textView.setText(place.getName());
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void initialize(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        btnSelectPlace = (Button) findViewById(R.id.btnPlace);
        textView = (TextView) findViewById(R.id.textView);

        editName = (TextInputEditText) findViewById(R.id.editName);
        editAadhar = (TextInputEditText) findViewById(R.id.editAadhar);

        latitude = Double.MAX_VALUE;
        longitude = Double.MAX_VALUE;

        jsonParser = new JSONParser();

        try {
            url = new URL(url_string);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setClickListeners(){
        btnSelectPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                Intent intent;

                try {
                    intent = builder.build(getApplicationContext());
                    startActivityForResult(intent, PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while(!valid())
                    Toast.makeText(SignUpActivity.this, "Some information is missing!", Toast.LENGTH_SHORT).show();

                new CreateNewProduct().execute();
            }
        });
    }

    private boolean valid(){
        name = editName.getText().toString();
        aadhar = editAadhar.getText().toString();

        return !(name.equals("") || aadhar.equals("") || latitude == Double.MAX_VALUE || longitude == Double.MAX_VALUE);
    }

    class CreateNewProduct extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SignUpActivity.this);
            pDialog.setMessage("Creating Product..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            try {
                JSONObject json = new JSONObject();

                //TODO Determine these tags.

                email = "tusharjape007@gmail.com";

                json.put("email", email);
                json.put("name", name);
                json.put("aadhar", aadhar);
                json.put("latitute", latitude);
                json.put("longitude", longitude);

                String message = json.toString();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setReadTimeout( 10000 /*milliseconds*/ );
                conn.setConnectTimeout( 15000 /* milliseconds */ );
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(message.getBytes().length);

                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                conn.connect();

                os = new BufferedOutputStream(conn.getOutputStream());
                os.write(message.getBytes());

                os.flush();

                is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                int success = Integer.parseInt(reader.readLine());

                Log.i("Success", Integer.toString(success));

            }
            catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}
