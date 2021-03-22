package com.example.hansadithio_27973_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    private TextView NIM, nama, kelas, Referensi, Teman;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        NIM = findViewById(R.id.StudentNIM);
        nama = findViewById(R.id.StudentName);
        kelas = findViewById(R.id.StudentClass);
        Referensi = findViewById(R.id.Referensi);
        Teman = findViewById(R.id.Teman);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}
