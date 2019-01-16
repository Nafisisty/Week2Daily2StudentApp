package com.example.week2daily2_studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.studentRecycleView);
        setRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setRecyclerView();
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, CRUDActivity.class);
        startActivity(intent);

    }

    public ArrayList<Student> listOfStudent(){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        MySQLDatabaseHelper mySQLDatabaseHelper = new MySQLDatabaseHelper(this);
        studentArrayList = mySQLDatabaseHelper.getAllStudent();

        return studentArrayList;
    }

    public void setRecyclerView(){
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listOfStudent());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
