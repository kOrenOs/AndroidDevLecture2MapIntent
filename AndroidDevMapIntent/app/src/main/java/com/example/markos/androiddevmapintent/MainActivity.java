package com.example.markos.androiddevmapintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findMapButtonAction(View view){
        EditText textLat = (EditText) findViewById(R.id.latitudeEditText);
        EditText textLng = (EditText) findViewById(R.id.longitudeEditText);

        double lat;
        double lng;

        try {
            lat = parseStringToDouble(textLat.getText().toString());
            lng = parseStringToDouble(textLng.getText().toString());
        }catch (NumberFormatException ex){
            Toast.makeText(getApplicationContext(), R.string.parseFormatException, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+lat+","+lng));
        startActivity(intent);
    }

    public double parseStringToDouble(String toParse){
        return Double.parseDouble(toParse);
    }
}
