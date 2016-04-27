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
    String[] rank;
    String[] country;
    String[] population;
    int[] flag;

    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Generate sample data
        rank = new String[]{"  gunting", " kaca", " papan luncur air", " kertas", " arnab", " kotak", " kamera"
                , " mee", " sewa kerata", " kain kotor", " perjalanan", " gula-gula", " roti", " saiz"
                , " kecurian", " sampah", "  botol", "  hadiah", " kamu", " mainan ", " mengayuh basikal", " penjual bunga"
                , " penjual daging", " sendirian", " kurang upaya", " perapi", " rasa mual",
                "  hiburan", "  haba", " harga", " kepeningan", " bekerja", " ukiran", " senang", " perak", " mata wang",
                " wang tunai", " sunyi"};

        country = new String[]{" aกรรไกร", " aกระจก ", "aกระดานโต้คลื่น",
                "abกระดาษ", " abกระท่อม", " abกล่อง", " กล้องถ่ายรูป", " ก๋วยเตี๋ยว",
                "การเช่ารถ", " การซักรีด", " การเดินทาง", " ขนม,ลูกอม", " ขนมปัง", " ขนาด"
                , " ขโมย", " ขยะ", " ขวด", " ของขวัญ", " ขอบคุณ", " ของเล่น", " ขี่จักรยาน"
                , " คนขายดอกไม้", " คนขายเนื้อ", " คนเดียว,โดดเดี่ยว", " คนพิการ",
                " ครีมนวดผม", " คลื่นไส้", " ความบันเทิง", " ความร้อน", " ค่าใช้จ่าย", " ง่วงซึม", " งาน", " งานแกะสลัก"
                , " ง่าย สบายๆ", " เงิน(แร่ธาตุ)", " เงินตรา", " เงินสด", " เงียบ"};

        population = new String[]{"  ฆูนติง", " กาจา",
                " ปาปัน ลูนจูร์ อายัร", " เกอร์ตัส", " อัรนับ", " กอต๊อก ",
                " คาเมรา", " มี", " เซวา เกอ-ราตา", " กายน์ กอตอร์",
                " เปอร์จาลันนัน", " ฆูลอ ฆูลอ", " โรตี", " ไซส์", " เกอ-จูรียัน ", " ซัมปะห์", " บอตอล"
                , " ฮาดียะห์", " กามู", " มัยนัน", " เมอ-งูายูห์ บาสิกัล", " เปินจูวัล บูงา", " เปินจูวัล ดาฆิง"
                , " ซืนดีรียัน", " กูรัง อูปายา", " เปอ ราปี", " ราซา มูวัล"
                , " ฮีบูรัน", " ฮาบา", " ฮัรฆา", " เกอ-เปอนีงัน", " เบอ-เกอร์จา", " อูกีรัน", " เซอ-นัง", " เปรัก",
                " มาตา วัง", " วังตูนัย", " ซูยี"

        };

        flag = new int[]{R.drawable.z1, R.drawable.z2,
                R.drawable.z3, R.drawable.z4,
                R.drawable.z5, R.drawable.z6, R.drawable.z7,
                R.drawable.z8, R.drawable.z10, R.drawable.z11, R.drawable.z12
                , R.drawable.z13, R.drawable.z14, R.drawable.z15, R.drawable.z16
                , R.drawable.z17, R.drawable.z18, R.drawable.z19, R.drawable.z20, R.drawable.z21
                , R.drawable.z22, R.drawable.z23, R.drawable.z24, R.drawable.z25, R.drawable.z26
                , R.drawable.z27, R.drawable.z28, R.drawable.z29, R.drawable.z30, R.drawable.z31
                , R.drawable.z32, R.drawable.z33, R.drawable.z34, R.drawable.z35
                , R.drawable.z36, R.drawable.z37, R.drawable.z38, R.drawable.z39};


        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < rank.length; i++) {
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