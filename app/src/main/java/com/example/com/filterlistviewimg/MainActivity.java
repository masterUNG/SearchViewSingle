package com.example.com.filterlistviewimg;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] country;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        country = new String[]{" aกรรไกร", " aกระจก ", "aกระดานโต้คลื่น",
                "abกระดาษ", " abกระท่อม", " abกล่อง", " กล้องถ่ายรูป", " ก๋วยเตี๋ยว",
                "การเช่ารถ", " การซักรีด", " การเดินทาง", " ขนม,ลูกอม", " ขนมปัง", " ขนาด"
                , " ขโมย", " ขยะ", " ขวด", " ของขวัญ", " ขอบคุณ", " ของเล่น", " ขี่จักรยาน"
                , " คนขายดอกไม้", " คนขายเนื้อ", " คนเดียว,โดดเดี่ยว", " คนพิการ",
                " ครีมนวดผม", " คลื่นไส้", " ความบันเทิง", " ความร้อน", " ค่าใช้จ่าย", " ง่วงซึม", " งาน", " งานแกะสลัก"
                , " ง่าย สบายๆ", " เงิน(แร่ธาตุ)", " เงินตรา", " เงินสด", " เงียบ"};






        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < country.length; i++) {
            WorldPopulation wp = new WorldPopulation(country[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
}