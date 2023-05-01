package com.example.quizassignment;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Question3Activity extends AppCompatActivity {

    private int score;
    private String q1;
    private  String q2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3);

        // get score from previous activity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        q1 = intent.getStringExtra("q1");
        q2 = intent.getStringExtra("q2");

        // set up radio group and button
        RadioGroup radioGroup = findViewById(R.id.question3_radio_group);
        Button nextButton = findViewById(R.id.next_button2);

        // set up on click listener for next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button id
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // check if answer is correct
                if (selectedId == R.id.question3_option2_radio_button) {
                    score++;
                }

                RadioButton radioButton = findViewById(selectedId);
                String selectedOption = radioButton.getText().toString();

                // navigate to confirm screen
                Intent intent = new Intent(Question3Activity.this, ConfirmActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("q1", q1);
                intent.putExtra("q2", q2);
                intent.putExtra("q3", selectedOption);
                startActivity(intent);
                finish();
            }
        });
    }
}
