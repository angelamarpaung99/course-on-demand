package com.example.courseondemand;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.courseondemand.home_fragment_list.OrderAccepted;
import com.example.courseondemand.home_fragment_list.OrderResponse;
import com.google.android.gms.nearby.connection.Connections;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class HomeNotActive extends AppCompatActivity {

    private ArrayList<OrderAccepted> mOrder = new ArrayList<>();
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);



        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginMentor.class));
        }



        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment());
        transaction.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = new HomeFragment();

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_fund:
                            selectedFragment = new BalanceFragment();
                            break;
                        case R.id.nav_orders:
                            selectedFragment = new OrdersFragment();
                            Intent intent = getIntent();
                            if (intent.hasExtra("acceptedOrders")){
                                ArrayList<OrderAccepted> mOrder = getIntent().getParcelableArrayListExtra("orderlist");

                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("orderlist", mOrder);
                                selectedFragment.setArguments(bundle);
                            }
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
