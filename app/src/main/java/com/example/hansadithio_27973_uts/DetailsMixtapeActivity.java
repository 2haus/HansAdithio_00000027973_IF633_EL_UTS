package com.example.hansadithio_27973_uts;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailsMixtapeActivity extends AppCompatActivity {
    private ImageView vvDetail;
    private TextView etJudul;
    private TextView etKeterangan;
    private TextView etUri;
    private Button btnBack;
    private Button play;
    private Button next;
    private Button prev;
    private ArrayList<SausLagu> sl = new ArrayList<>();
    private int posisi;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_item_layout);
        vvDetail = (ImageView) findViewById(R.id.vvDetail);
        etJudul = (TextView) findViewById(R.id.etJudul);
        etKeterangan = (TextView) findViewById(R.id.etKeterangan);
        etUri = (TextView) findViewById(R.id.etUri);
        play = (Button) findViewById(R.id.play);
        next = (Button) findViewById(R.id.next);
        prev = (Button) findViewById(R.id.previous);
        btnBack = (Button) findViewById(R.id.btnBack);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        sl = (ArrayList<SausLagu>) bundle.getSerializable("DetailsLagu");
        posisi = (Integer) bundle.getSerializable("PosisiLagu");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()==true){
                    mediaPlayer.pause();
                    play.setText("Pause");
                }
                else{
                    mediaPlayer.start();
                    play.setText("Play");
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                posisi++;
                if(posisi == sl.size()){
                    posisi--;
                }
                else{
                    MedPlay();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                posisi--;
                if(posisi == sl.size()){
                    posisi++;
                }
                else{
                    MedPlay();
                }
            }
        });
        MedPlay();
    }
    public void MedPlay(){
        mediaPlayer = MediaPlayer.create(this, Uri.parse(sl.get(posisi).getPlayerURI()));
        etJudul.setText(sl.get(posisi).getJudul());
        etKeterangan.setText(sl.get(posisi).getKeterangan());
        mediaPlayer.start();
    }
}
