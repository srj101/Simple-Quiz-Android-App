package com.example.quizassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question2Activity extends AppCompatActivity {
    private int score;

    private TextView questionTextView;
    private RadioGroup questionRadioGroup;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private RadioButton option4RadioButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2);

        // Initialize views
        questionTextView = findViewById(R.id.question2_text_view);
        questionRadioGroup = findViewById(R.id.question2_radio_group);
        option1RadioButton = findViewById(R.id.question2_option1_radio_button);
        option2RadioButton = findViewById(R.id.question2_option2_radio_button);
        option3RadioButton = findViewById(R.id.question2_option3_radio_button);
        option4RadioButton = findViewById(R.id.question2_option4_radio_button);
        nextButton = findViewById(R.id.next_button2);

        Intent intent = getIntent();
        String q1 = intent.getStringExtra("q1");
        score = intent.getIntExtra("score",0);


        // Set click listener for Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check user's answer and update score
                int selectedId = questionRadioGroup.getCheckedRadioButtonId();
                if (selectedId == option1RadioButton.getId()) {
                    score += 1;
                }

                RadioButton radioButton = findViewById(selectedId);
                String selectedOption = radioButton.getText().toString();

                // Start next activity
                Intent intent = new Intent(Question2Activity.this, Question3Activity.class);
                intent.putExtra("score", score);
                intent.putExtra("q2", selectedOption);
                intent.putExtra("q1", q1);
                startActivity(intent);
            }
        });
    }
}
