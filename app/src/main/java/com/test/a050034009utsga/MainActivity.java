package com.test.a050034009utsga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new TitikLokasiSekarangFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnItemSelectedListener(this);
    }
    private boolean loadFragment(TitikLokasiSekarangFragment fragmentActivity) {
        Class<? extends Fragment> fragment = null;
        if (fragment != null) {
            int commit = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragmentActivity)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new MapsFragment();
                break;
            case R.id.search:
                fragment = new search_menu();
                break;
            case R.id.favorite_menu:
                fragment = new TitikLokasiSekarangFragment();
                break;

        }
        return loadFragment((TitikLokasiSekarangFragment) fragment);
    }
}