package com.example.quizassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        TextView summaryTextView = findViewById(R.id.summary);
        Button submitButton = findViewById(R.id.submit_button);

        Intent intent = getIntent();
        String q1 = intent.getStringExtra("q1");
        String q2 = intent.getStringExtra("q2");
        String q3 = intent.getStringExtra("q3");
        int score = intent.getIntExtra("score", 0);

        String summaryText = "You have answered 3 questions.\n\nYou chose:\nQuestion 1: " + q1
                + "\nQuestion 2: " + q2 + "\nQuestion 3: " + q3;

        summaryTextView.setText(summaryText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent(ConfirmActivity.this, ScoreActivity.class);
                scoreIntent.putExtra("score", score);
                startActivity(scoreIntent);
            }
        });
    }
}