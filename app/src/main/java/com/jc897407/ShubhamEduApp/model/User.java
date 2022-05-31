package com.jc897407.ShubhamEduApp.model;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.jc897407.ShubhamEduApp.helper.DBHelper;

import java.util.ArrayList;

public class User {
    private final String username;
    private final String duration;
    private final String level;
    private final String date;
    private final String score;

    public User(String username, String duration, String level, String date, String score) {
        this.username = username;
        this.duration = duration;
        this.level = level;
        this.date = date;
        this.score = score;
    }
    // getter methods

    public String getUsername() {
        return username;
    }

    public String getDuration() {
        return duration;
    }

    public String getLevel() {
        return level;
    }

    public String getDate() {
        return date;
    }

    public String getScore() {
        return score;
    }


    @SuppressLint("Range")
    public static ArrayList<User> loadUsers(DBHelper dbHelper){
        ArrayList<User> users = new ArrayList<>();
        if (dbHelper != null){
            Cursor cursor = dbHelper.getAllPlayers();
            if (cursor != null && cursor.getCount() > 0) {

                cursor.moveToFirst();
                do {
                    String username = cursor.getString(cursor.getColumnIndex(DBHelper.USERNAME_COL));
                    String score = cursor.getString(cursor.getColumnIndex(DBHelper.SCORE_COL));
                    String duration = cursor.getString(cursor.getColumnIndex(DBHelper.DURATION_COL));
                    String level = cursor.getString(cursor.getColumnIndex(DBHelper.LEVEL_COL));
                    String date = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_COL));
                    //add one user object into users
                    users.add(new User(username, duration, level, date, score));
                } while (cursor.moveToNext());
                dbHelper.close();
            }
        }
        return users;
    }
}
