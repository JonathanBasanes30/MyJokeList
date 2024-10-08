package com.example.myjokelistapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_list_item);

        RecyclerView jokeRecyclerView = findViewById(R.id.jokeRecyclerView);
        jokeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Joke> jokeList = new ArrayList<>();
        jokeList.add(new Joke("Joke 1", "Why did the chicken cross the road?", "To get to the other side!"));
        jokeList.add(new Joke("Joke 2", "Why don’t scientists trust atoms?", "Because they make up everything!"));

        JokeAdaptor adapter = new JokeAdaptor(jokeList, joke -> {
            Intent intent = new Intent(MainActivity.this, JokeDetailActivity.class);
            intent.putExtra("title", joke.getTitle());
            intent.putExtra("setup", joke.getSetup());
            intent.putExtra("punchline", joke.getPunchline());
            startActivity(intent);
        });

        jokeRecyclerView.setAdapter(adapter);
    }
}