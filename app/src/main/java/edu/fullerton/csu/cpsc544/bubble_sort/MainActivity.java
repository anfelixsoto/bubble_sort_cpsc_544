package edu.fullerton.csu.cpsc544.bubble_sort;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.fullerton.csu.cpsc544.bubble_sort.algorithm.BubbleSort;

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
        SpannableStringBuilder content = new SpannableStringBuilder();

        Button generate_numbers = findViewById(R.id.generate_random_button);
        generate_numbers.setOnClickListener(v -> {
            GenerateRandomNumbers(nums);
        });

        BubbleSort bubbleSort = new BubbleSort();
    }

    // User input
    public void handleUserInput(View v)
    {
        TextView userInputField = findViewById(R.id.num_array);

        /* Converts rangeInput to an integer */
        //Integer range = Integer.parseInt(rangeInput.getText().toString());

        String userInput = "user input: " + userInputField.getText().toString();

        TextView view = new TextView(this);
        view.setText(userInput);

        ScrollView scroll = findViewById(R.id.scroll_view);
        scroll.addView(view);

    }

    private void GenerateRandomNumbers(List <Integer> nums)
    {
        TextView rangeInput = findViewById(R.id.range_input);
        int range = Integer.parseInt(rangeInput.getText().toString());

        nums.clear();
        Random rnd = new Random();
        for(int i = 0; i < range; i++)
            nums.add(rnd.nextInt(1000));

        SetUserInputText(nums);
    }

    private void SetUserInputText(List <Integer> nums)
    {
        TextView userInputField = findViewById(R.id.num_array);
        userInputField.setText(" ");

        SpannableStringBuilder content = new SpannableStringBuilder();
        for(int i = 0; i < nums.size(); i++)
            content.append(nums.get(i).toString()).append(i < nums.size() - 1 ? ", " : " ");

        userInputField.setText(content);
    }
}