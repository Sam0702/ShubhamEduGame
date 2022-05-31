package com.jc897407.ShubhamEduApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jc897407.ShubhamEduApp.adapter.ScoreAdapter;
import com.jc897407.ShubhamEduApp.helper.DBHelper;
import com.jc897407.ShubhamEduApp.model.User;

public class ScoreActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        dbHelper = new DBHelper(this);
        RecyclerView scoreRecyclerView = findViewById(R.id.scoreRecyclerView);
        scoreRecyclerView.setAdapter(new ScoreAdapter(User.loadUsers(dbHelper)));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.score){
            Intent intent = new Intent(this, ScoreActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.setting){
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}