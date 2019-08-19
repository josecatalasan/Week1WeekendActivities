package com.example.week1weekendactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonResultActivity extends AppCompatActivity {
    TextView tvResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_result);

        tvResultView = findViewById(R.id.tvResultList);
        ArrayList<PersonActivity.Person> resultList = getIntent().getExtras().getParcelableArrayList("list");
        String result = "";

        for(PersonActivity.Person person : resultList) {
            result += String.format("%s %s is %s tall and weighs %s. They were born on %s and likes to eat %s.\n", person.getFirstName(), person.getLastName(), person.getHeight(), person.getHeight(), person.getBirthday(), person.getFavoriteFood());
        }
        tvResultView.setText(result);
    }
}
