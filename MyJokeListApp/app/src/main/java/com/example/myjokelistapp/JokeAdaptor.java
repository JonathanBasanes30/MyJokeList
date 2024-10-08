package com.example.myjokelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JokeAdaptor extends RecyclerView.Adapter<JokeAdaptor.JokeViewHolder> {

    private final List<Joke> jokeList;
    private final OnJokeClickListener jokeClickListener;

    // Interface for handling clicks
    public interface OnJokeClickListener {
        void onJokeClick(Joke joke);
    }

    // Constructor to initialize the joke list and click listener
    public JokeAdaptor(List<Joke> jokeList, OnJokeClickListener jokeClickListener) {
        this.jokeList = jokeList;
        this.jokeClickListener = jokeClickListener;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.joke_list_item, parent, false);
        return new JokeViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        // Get the joke object at the current position
        Joke joke = jokeList.get(position);

        // Set the title and setup in the ViewHolder's TextViews
        holder.jokeTitle.setText(joke.getTitle());
        holder.jokeSetup.setText(joke.getSetup());

        // Handle the click on each joke item
        holder.itemView.setOnClickListener(v -> jokeClickListener.onJokeClick(joke));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return jokeList.size();
    }

    // ViewHolder class for holding the joke views
    public static class JokeViewHolder extends RecyclerView.ViewHolder {
        TextView jokeTitle, jokeSetup;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            jokeTitle = itemView.findViewById(R.id.jokeTitle);
            jokeSetup = itemView.findViewById(R.id.jokeSetup);
        }
    }
}

