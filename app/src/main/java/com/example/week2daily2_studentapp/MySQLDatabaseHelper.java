package com.example.week2daily2_studentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.week2daily2_studentapp.DatabaseConstants.DATABASE_NAME;
import static com.example.week2daily2_studentapp.DatabaseConstants.DATABASE_VERSION;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_CITY;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_DOB;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_GPA;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_MAJOR;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_MINOR;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_NAME;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_SSN;
import static com.example.week2daily2_studentapp.DatabaseConstants.FIELD_STATE;
import static com.example.week2daily2_studentapp.DatabaseConstants.TABLE_NAME;

public class MySQLDatabaseHelper extends SQLiteOpenHelper {

    public MySQLDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + FIELD_SSN + " TEXT PRIMARY KEY, "
                + FIELD_NAME + " TEXT, "
                + FIELD_MAJOR + " TEXT, "
                + FIELD_MINOR + " TEXT, "
                + FIELD_GPA + " TEXT, "
                + FIELD_DOB + " TEXT, "
                + FIELD_CITY + " TEXT, "
                + FIELD_STATE + " TEXT)";

        db.execSQL(createQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        if(student != null) {
            String name = student.getStudentName();
            String major = student.getStudentMajor();
            String minor = student.getStudentMajor();
            String gpa = student.getStudentGPA();
            String dob = student.getStudentGPA();
            String city = student.getStudentHomeCity();
            String state = student.getStudentHomeState();
            String ssn = student.getStudentSSN();

            contentValues.put(FIELD_NAME, name);
            contentValues.put(FIELD_MAJOR, major);
            contentValues.put(FIELD_MINOR, minor);
            contentValues.put(FIELD_GPA, gpa);
            contentValues.put(FIELD_DOB, dob);
            contentValues.put(FIELD_CITY, city);
            contentValues.put(FIELD_STATE, state);
            contentValues.put(FIELD_SSN, ssn);

            database.insert(TABLE_NAME, null, contentValues);
        }

    }

    public ArrayList<Student> getAllStudent() {
        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT *FROM " + TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()){
            ArrayList<Student> arrayList = new ArrayList<>();
            do{

                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String major = cursor.getString(cursor.getColumnIndex(FIELD_MAJOR));
                String minor = cursor.getString(cursor.getColumnIndex(FIELD_MINOR));
                String gpa = cursor.getString(cursor.getColumnIndex(FIELD_GPA));
                String dob = cursor.getString(cursor.getColumnIndex(FIELD_DOB));
                String city = cursor.getString(cursor.getColumnIndex(FIELD_CITY));
                String state = cursor.getString(cursor.getColumnIndex(FIELD_STATE));
                String ssn = cursor.getString(cursor.getColumnIndex(FIELD_SSN));

                arrayList.add(new Student(name, major, minor, gpa, dob, city, state, ssn));

            } while (cursor.moveToNext());
            return arrayList;
        }else {
            return null;
        }
    }

    public Student getStudent(String passedSSN) {

        Student student = null;

        if(passedSSN != null && !passedSSN.isEmpty()) {
            SQLiteDatabase database = getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_SSN + " = \"" + passedSSN + "\"";

            Cursor cursor = database.rawQuery(query, null);
            if(cursor.moveToFirst()) {

                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String major = cursor.getString(cursor.getColumnIndex(FIELD_MAJOR));
                String minor = cursor.getString(cursor.getColumnIndex(FIELD_MINOR));
                String gpa = cursor.getString(cursor.getColumnIndex(FIELD_GPA));
                String dob = cursor.getString(cursor.getColumnIndex(FIELD_DOB));
                String city = cursor.getString(cursor.getColumnIndex(FIELD_CITY));
                String state = cursor.getString(cursor.getColumnIndex(FIELD_STATE));
                String ssn = cursor.getString(cursor.getColumnIndex(FIELD_SSN));

                student = new Student(name, major, minor, gpa, dob, city, state, ssn);
            }
            cursor.close();
        }

        return student;
    }

    public int deleteStudent(String passedSSN) {
        String whereClause = FIELD_SSN + " = \"" + passedSSN + "\"";
        SQLiteDatabase database = getWritableDatabase();
        return database.delete(TABLE_NAME, whereClause, null);
    }

    public int updateStudent(Student student) {
        if(student != null){
            String whereClause = FIELD_SSN + " = \"" + student.getStudentSSN() + "\"";
            SQLiteDatabase database = getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put(FIELD_NAME, student.getStudentName());
            contentValues.put(FIELD_MAJOR, student.getStudentMajor());
            contentValues.put(FIELD_MINOR, student.getStudentMinor());
            contentValues.put(FIELD_GPA, student.getStudentGPA());
            contentValues.put(FIELD_DOB, student.getStudentDOB());
            contentValues.put(FIELD_CITY, student.getStudentHomeCity());
            contentValues.put(FIELD_STATE, student.getStudentHomeState());
            contentValues.put(FIELD_SSN, student.getStudentSSN());

            return database.update(TABLE_NAME, contentValues, whereClause, null);
        }
        return 0;
    }
}
