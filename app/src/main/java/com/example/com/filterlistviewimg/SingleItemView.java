package com.example.com.filterlistviewimg;

/**
 * Created by com on 24/9/2558.
 */

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;
    ImageView imgflag;
    String rank;
    String country;
    String population;
    int flag;
    private Button btnPlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Get the intent from ListViewAdapter
        Intent i = getIntent();
        // Get the results of rank
        rank = i.getStringExtra("rank");
        // Get the results of country
        country = i.getStringExtra("country");
        // Get the results of population
        population = i.getStringExtra("population");
        // Get the results of flag
        flag = i.getIntExtra("flag", flag);


        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer play = MediaPlayer.create(getBaseContext(), R.raw.m);
                play.start();


            }
        });

        // Locate the TextViews in singleitemview.xml
        txtrank = (TextView) findViewById(R.id.rank);
        txtcountry = (TextView) findViewById(R.id.country);
        txtpopulation = (TextView) findViewById(R.id.population);

        // Locate the ImageView in singleitemview.xml
        imgflag = (ImageView) findViewById(R.id.flag);


        // Load the results into the TextViews
        txtrank.setText(rank);
        txtcountry.setText(country);
        txtpopulation.setText(population);

        // Load the image into the ImageView
        imgflag.setImageResource(flag);


    }
}