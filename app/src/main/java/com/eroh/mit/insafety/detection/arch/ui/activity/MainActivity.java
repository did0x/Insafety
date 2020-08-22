package com.eroh.mit.insafety.detection.arch.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.eroh.mit.insafety.detection.arch.ui.fragment.history.HistoryFragment;
import com.eroh.mit.insafety.detection.arch.ui.fragment.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.tensorflow.lite.examples.detection.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        FloatingActionButton fabCamera = findViewById(R.id.fab_camera);
        fabCamera.setOnClickListener(v -> {
            startActivity(new Intent(this, DetectorActivity.class));
        });

        bottomNav.setOnNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        boolean condition = intent.getBooleanExtra("SAVE", false);
        if (condition) {
            bottomNav.setSelectedItemId(R.id.menu_history);
        } else {
            bottomNav.setSelectedItemId(R.id.menu_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new HomeFragment())
                        .commit();
                break;
            case R.id.menu_history:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new HistoryFragment())
                        .commit();
                break;
        }
        return true;
    }
}