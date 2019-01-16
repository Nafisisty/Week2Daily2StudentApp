package com.example.week2daily2_studentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CRUDActivity extends AppCompatActivity {

    EditText nameEditText, majorEditText, minorEditText, gpaEditText, dobEditText, cityEditText, stateEditText, ssnEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        nameEditText = findViewById(R.id.nameEditTextId);
        majorEditText = findViewById(R.id.majorEditTextId);
        minorEditText = findViewById(R.id.minorEditTextId);
        gpaEditText = findViewById(R.id.gpaEditTextId);
        dobEditText = findViewById(R.id.dobEditTextId);
        cityEditText = findViewById(R.id.cityEditTextId);
        stateEditText = findViewById(R.id.stateEditTextId);
        ssnEditText = findViewById(R.id.ssnEditTextId);
    }

    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String major = majorEditText.getText().toString();
        String minor = minorEditText.getText().toString();
        String gpa = gpaEditText.getText().toString();
        String dob = dobEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String state = stateEditText.getText().toString();
        String ssn = ssnEditText.getText().toString();

        Student aStudent;

        switch (view.getId()){
            case R.id.addButtonId : {
                if(ssnEditText.getText() != null && !ssnEditText.getText().toString().isEmpty()){

                    aStudent = new Student(name, major, minor, gpa, dob, city, state, ssn);
                    MySQLDatabaseHelper mySQLDatabaseHelper = new MySQLDatabaseHelper(this);
                    mySQLDatabaseHelper.addStudent(aStudent);
                    Toast.makeText(this, "Successfully Added The Student", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.editButtonId : {
                if(ssnEditText.getText() != null && !ssnEditText.getText().toString().isEmpty()){

                    aStudent = new Student(name, major, minor, gpa, dob, city, state, ssn);
                    MySQLDatabaseHelper mySQLDatabaseHelper = new MySQLDatabaseHelper(this);
                    mySQLDatabaseHelper.updateStudent(aStudent);
                    Toast.makeText(this, "Successfully Updated The Student", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.deleteButtonId : {
                if(ssnEditText.getText() != null && !ssnEditText.getText().toString().isEmpty()){

                    MySQLDatabaseHelper mySQLDatabaseHelper = new MySQLDatabaseHelper(this);
                    int deleted = mySQLDatabaseHelper.deleteStudent(ssnEditText.getText().toString());

                    if(deleted == 1) {
                        Toast.makeText(this, "Successfully Deleted The Student", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "Delete Failed!!! Check The SSN", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            }
            case R.id.viewButtonId : {

                if(ssnEditText.getText() != null && !ssnEditText.getText().toString().isEmpty()){

                    aStudent = new Student();
                    MySQLDatabaseHelper mySQLDatabaseHelper = new MySQLDatabaseHelper(this);
                    aStudent = mySQLDatabaseHelper.getStudent(ssnEditText.getText().toString());

                    if(aStudent != null) {
                        nameEditText.setText(aStudent.getStudentName());
                        majorEditText.setText(aStudent.getStudentMajor());
                        minorEditText.setText(aStudent.getStudentMinor());
                        gpaEditText.setText(aStudent.getStudentGPA());
                        dobEditText.setText(aStudent.getStudentDOB());
                        cityEditText.setText(aStudent.getStudentHomeCity());
                        stateEditText.setText(aStudent.getStudentHomeState());
                        ssnEditText.setText(aStudent.getStudentSSN());

                        Toast.makeText(this, "Successfully Retrieved The Student", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this, "There is no student of this SSN", Toast.LENGTH_SHORT).show();

                    }
                }
                break;

            }
        }

    }

}
