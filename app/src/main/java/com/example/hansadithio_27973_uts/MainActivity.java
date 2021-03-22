package com.example.hansadithio_27973_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvDaftarSongs;
    DaftarLaguAdapter mAdapter;
    LinkedList<SausLagu> daftarLagu = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isiDaftarLagu();
        rvDaftarSongs = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarLaguAdapter(this, daftarLagu);
        rvDaftarSongs.setAdapter(mAdapter);
        rvDaftarSongs.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarLagu(){
        daftarLagu.add(new SausLagu("Ash Like Snow","Ash Like Show by the briliant green", "android.resource://" + getPackageName() + "/"  + R.raw.ashlikesnow));
        daftarLagu.add(new SausLagu("Believe","Believe by Folder5", "android.resource://" + getPackageName() + "/"  + R.raw.believe));
        daftarLagu.add(new SausLagu("Blue Bird","Blue Bird by Ikimono Gakari", "android.resource://" + getPackageName() + "/"  + R.raw.bluebird));
        daftarLagu.add(new SausLagu("IZANAGI","IZANAGI by Sakuramen feat.Hideya Tadawa", "android.resource://" + getPackageName() + "/"  + R.raw.izanagi));
        daftarLagu.add(new SausLagu("Justifaiz Remix","", "android.resource://" + getPackageName() + "/"  + R.raw.justifaiz_remix));
        daftarLagu.add(new SausLagu("Kaibutsu","Kaibutsu by Ayaka/YOASOBI", "android.resource://" + getPackageName() + "/"  + R.raw.kaibutsu));
        daftarLagu.add(new SausLagu("Kamen Rider Kuuga","", "android.resource://" + getPackageName() + "/"  + R.raw.kamen_rider_kuuga_opening_remix));
        daftarLagu.add(new SausLagu("NEXT LEVEL","", "android.resource://" + getPackageName() + "/"  + R.raw.next_level));
        daftarLagu.add(new SausLagu("Next New World","", "android.resource://" + getPackageName() + "/"  + R.raw.next_new_world));
        daftarLagu.add(new SausLagu("Traitor's Requiem","", "android.resource://" + getPackageName() + "/"  + R.raw.traitors_requiem));
    }
}