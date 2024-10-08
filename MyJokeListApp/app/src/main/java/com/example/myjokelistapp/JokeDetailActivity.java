package com.example.myjokelistapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_list_item);

        TextView detailTitle = findViewById(R.id.jokeTitle);
        TextView detailSetup = findViewById(R.id.jokeSetup);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView detailPunchline = findViewById(R.id.jokePunchline);

        Intent intent = getIntent();
        detailTitle.setText(intent.getStringExtra("title"));
        detailSetup.setText(intent.getStringExtra("setup"));
        detailPunchline.setText(intent.getStringExtra("punchline"));
    }
}
