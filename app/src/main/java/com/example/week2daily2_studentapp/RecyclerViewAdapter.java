package com.example.week2daily2_studentapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Student> studentArrayList;

    public RecyclerViewAdapter(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int postion) {

        Student student = studentArrayList.get(postion);

        if(student != null){
            String name = student.getStudentName();
            String dob = student.getStudentDOB();
            String city = student.getStudentHomeCity();
            String state = student.getStudentHomeState();
            String ssn = student.getStudentSSN();

            viewHolder.nameTextView.setText(name);
            viewHolder.dobTextView.setText(dob);
            viewHolder.cityTextView.setText(city);
            viewHolder.stateTextView.setText(state);
            viewHolder.ssnTextView.setText(ssn);
        }
    }

    @Override
    public int getItemCount() {
        return studentArrayList != null ? studentArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, dobTextView, cityTextView, stateTextView, ssnTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextViewId);
            dobTextView = itemView.findViewById(R.id.dobTextViewId);
            cityTextView = itemView.findViewById(R.id.cityTextViewId);
            stateTextView = itemView.findViewById(R.id.stateTextViewId);
            ssnTextView = itemView.findViewById(R.id.ssnTextViewId);
        }
    }
}
