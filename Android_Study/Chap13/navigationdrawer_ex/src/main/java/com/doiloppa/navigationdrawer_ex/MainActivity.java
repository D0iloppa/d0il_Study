package com.doiloppa.navigationdrawer_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.main_drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(getApplicationContext(),"Open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(getApplicationContext(),"Close",Toast.LENGTH_SHORT).show();
            }
        };

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        View header_View = navigationView.getHeaderView(0);
        ImageView imageView = header_View.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"이미지를 클릭",Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.nav_camera){
                    Toast.makeText(getApplicationContext(),"Camera",Toast.LENGTH_SHORT).show();
                }else if(id==R.id.nav_gallery){
                    Toast.makeText(getApplicationContext(),"Gallery",Toast.LENGTH_SHORT).show();
                }else if(id==R.id.nav_slideshow){
                    Toast.makeText(getApplicationContext(),"SlideShow",Toast.LENGTH_SHORT).show();
                }else if(id==R.id.nav_manage){
                    Toast.makeText(getApplicationContext(),"Tools",Toast.LENGTH_SHORT).show();
                }else if(id==R.id.mav_share){
                    Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT).show();
                }else if(id==R.id.mav_send){
                    Toast.makeText(getApplicationContext(),"Send",Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }


    }
}
