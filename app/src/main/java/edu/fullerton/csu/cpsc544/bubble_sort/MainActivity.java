package edu.fullerton.csu.cpsc544.bubble_sort;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order_type), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List <Integer> nums = new ArrayList<>();
        GenerateRandomNumbers(nums);
        SpannableStringBuilder content = new SpannableStringBuilder();

        for(Integer i : nums)
            content.append(i.toString()).append(" ");
        TextView view = findViewById(R.id.output_view);
        view.setText(content);


    }

    // User input
    public void handleUserInput(View v){
        TextView rangeInput = findViewById(R.id.range_input);
        TextView userInputField = findViewById(R.id.num_array);

        /* Converts rangeInput to an integer */
        //Integer range = Integer.parseInt(rangeInput.getText().toString());

        String userInput = "range: " + rangeInput.getText().toString() +
                "\nuser input: "
                + userInputField.getText().toString();

        // for testing: checking if button causes input to be recorded
        TextView temp = findViewById(R.id.output_view);
        temp.setText(userInput);
    }

    private void GenerateRandomNumbers(List <Integer> nums)
    {
        Random rnd = new Random();
        for(int i = 0; i < 8; i++)
            nums.add(rnd.nextInt(1000));
        //Collections.shuffle(nums);
    }
}