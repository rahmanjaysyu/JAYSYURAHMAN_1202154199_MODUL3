package com.example.android.jaysyurahman_1202154199_modul3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jaysyurahman on 25/02/2018.
 */

public class Detail extends AppCompatActivity {
    private Button btnNambah, btnKurang;
    private ImageView progress, lblImg;
    private TextView lblJudul, lblDesk, lblStat;
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnNambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        progress = findViewById(R.id.imgIsi);

        lblJudul = findViewById(R.id.lblJudul);
        lblDesk = findViewById(R.id.lblDeskripsi);
        lblImg = findViewById(R.id.lblImg);
        lblStat = findViewById(R.id.lblStatus);

        Intent in = getIntent();
        String title=in.getStringExtra("etitle");
        String description=in.getStringExtra("edesc");
        if(description.length()<1){description="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ut tincidunt dui. Etiam et tincidunt dolor. Phasellus eu rhoncus sem. Suspendisse laoreet dolor eu nisi dictum congue id ut ipsum. Etiam sagittis sodales urna. Sed condimentum arcu at pretium laoreet. Nam venenatis leo sit amet sodales malesuada. Morbi quis convallis lorem, quis malesuada elit. Integer suscipit mauris et ex finibus, id aliquam nisi maximus. Quisque lacinia suscipit ipsum, in posuere elit eleifend vel. Vestibulum vehicula, est ac interdum tristique, elit odio volutpat ex, eu eleifend erat dolor a mauris.\nInterdum et malesuada fames ac ante ipsum primis in faucibus. Nunc sagittis sagittis orci, a mollis justo ultrices id. Vestibulum a neque eget magna ultricies posuere eget ut sem. Nunc egestas vestibulum metus. Praesent et mi quis dolor pellentesque mattis quis eu turpis. Nunc convallis quis elit vitae ornare. Sed venenatis sed lorem eget posuere. Nam lobortis diam dui, et sollicitudin velit faucibus quis. Donec sit amet neque non diam aliquam imperdiet.\n";}
        int imgRes = in.getIntExtra("eimg",0);

        setTitle(title);
        lblJudul.setText(title);
        lblDesk.setText(description);
        lblImg.setImageResource(imgRes);

        btnNambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambah();
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurang();
            }
        });
    }


    public void tambah(){
        status();
        if(level==4){
            Toast.makeText(this,"Air sudah Penuh",Toast.LENGTH_SHORT).show();return;}
        progress.setImageLevel(++level);
    }

    public void kurang(){
        status();
        if(level==0){Toast.makeText(this,"Air telah Kosong",Toast.LENGTH_SHORT).show();return;}
        progress.setImageLevel(--level);
    }

    public void status(){
        lblStat.setText(""+level+"L");
    }
}
