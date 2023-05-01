package com.example.quizassignment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question1Activity extends AppCompatActivity {

    private int score = 0;
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
        setContentView(R.layout.question1);

        // Initialize views
        questionTextView = findViewById(R.id.question1_text_view);
        questionRadioGroup = findViewById(R.id.question1_radio_group);
        option1RadioButton = findViewById(R.id.question1_option1_radio_button);
        option2RadioButton = findViewById(R.id.question1_option2_radio_button);
        option3RadioButton = findViewById(R.id.question1_option3_radio_button);
        option4RadioButton = findViewById(R.id.question1_option4_radio_button);
        nextButton = findViewById(R.id.next_button1);


        // Set click listener for next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if an option is selected
                int selectedOptionId = questionRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    // Check if selected option is correct
                    if (selectedOptionId == R.id.question1_option1_radio_button) {
                        score++;
                    }

                    RadioButton radioButton = findViewById(selectedOptionId);
                    String selectedOption = radioButton.getText().toString();

                    // Move to next question
                    Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("q1", selectedOption);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
