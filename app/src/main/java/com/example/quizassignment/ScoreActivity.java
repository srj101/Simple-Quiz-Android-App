package com.example.quizassignment;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        // Get the score passed from the previous activity
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        // Set up the score text view
        scoreTextView = findViewById(R.id.score);
        scoreTextView.setText("Your score is " + score + " out of 3.");

        // Set up the restart button
        restartButton = findViewById(R.id.restart_button);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the quiz
                Intent intent = new Intent(ScoreActivity.this, Question1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

