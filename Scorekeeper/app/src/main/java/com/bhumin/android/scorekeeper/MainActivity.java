package com.bhumin.android.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;
    private TextView mScore1Text;
    private TextView mScore2Text;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScore1Text = findViewById(R.id.score_1);
        mScore2Text = findViewById(R.id.score_2);
        if(savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
            mScore1Text.setText(String.valueOf(mScore1));
            mScore2Text.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightmode = AppCompatDelegate.getDefaultNightMode();
        if(nightmode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.nightmode).setTitle(R.string.day);
        } else {
            menu.findItem(R.id.nightmode).setTitle(R.string.night);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nightmode) {
            int nightmode = AppCompatDelegate.getDefaultNightMode();
            if (nightmode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch(viewID) {
            case R.id.decreaseTeam1:
                mScore1--;
                mScore1Text.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScore2Text.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch(viewID) {
            case R.id.increaseTeam1:
                mScore1++;
                mScore1Text.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScore2Text.setText(String.valueOf(mScore2));
                break;
        }
    }
}
