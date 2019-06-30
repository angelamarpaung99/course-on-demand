package com.example.courseondemand;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;


public class HomeNotActive extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

//        Switch switchActive = (Switch)findViewById(R.id.switchActive1);
//        String status = switchActive.getText().toString();
//        Toast.makeText(getApplicationContext(), "Switch : "+ status, Toast.LENGTH_LONG).show();

        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_fund:
                            selectedFragment = new FundFragment();
                            break;
                        case R.id.nav_orders:
                            selectedFragment = new OrdersFragment();
                            break;
                        case R.id.nav_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_notactive, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
