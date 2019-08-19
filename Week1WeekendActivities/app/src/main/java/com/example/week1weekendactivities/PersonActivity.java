package com.example.week1weekendactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class PersonActivity extends AppCompatActivity {
    EditText etFirstName, etLastName, etHeight, etWeight, etBirthday, etFavoriteFood;
    ArrayList<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        etBirthday = findViewById(R.id.etBirthday);
        etFavoriteFood = findViewById(R.id.etFavoriteFood);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.addPerson:
                personList.add(new Person(etFirstName.getText().toString(), etLastName.getText().toString(), etHeight.getText().toString(), etWeight.getText().toString(), etBirthday.getText().toString(), etFavoriteFood.getText().toString()));
                Toast.makeText(this,"A person was added",Toast.LENGTH_SHORT).show();
                etFirstName.setText("");
                etLastName.setText("");
                etHeight.setText("");
                etWeight.setText("");
                etBirthday.setText("");
                etFavoriteFood.setText("");
                break;
            case R.id.seeList:
                Intent startResult = new Intent(this, PersonResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("list", personList);
                startResult.putExtras(bundle);
                startActivity(startResult);
                break;
        }
    }

    public class Person implements Parcelable {
        private String firstName, lastName, height, weight, birthday, favoriteFood;

        public Person(String firstName, String lastName, String height, String weight, String birthday, String favoriteFood) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.height = height;
            this.weight = weight;
            this.birthday = birthday;
            this.favoriteFood = favoriteFood;
        }

        protected Person(Parcel in) {
            firstName = in.readString();
            lastName = in.readString();
            height = in.readString();
            weight = in.readString();
            birthday = in.readString();
            favoriteFood = in.readString();
        }

        public final Creator<Person> CREATOR = new Creator<Person>() {
            @Override
            public Person createFromParcel(Parcel in) {
                return new Person(in);
            }

            @Override
            public Person[] newArray(int size) {
                return new Person[size];
            }
        };

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getFavoriteFood() {
            return favoriteFood;
        }

        public void setFavoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(firstName);
            parcel.writeString(lastName);
            parcel.writeString(height);
            parcel.writeString(weight);
            parcel.writeString(birthday);
            parcel.writeString(favoriteFood);
        }
    }
}
