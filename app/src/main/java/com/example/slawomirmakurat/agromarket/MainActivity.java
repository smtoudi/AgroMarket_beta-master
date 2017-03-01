package com.example.slawomirmakurat.agromarket;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.slawomirmakurat.agromarket.drawer.Action_my_ads;
import com.example.slawomirmakurat.agromarket.drawer.Action_my_favorite;
import com.example.slawomirmakurat.agromarket.drawer.Action_navig;
import com.example.slawomirmakurat.agromarket.drawer.Lav;
import com.example.slawomirmakurat.agromarket.drawer.Nav_add_frend;
import com.example.slawomirmakurat.agromarket.drawer.Nav_settings;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private ViewPager viewPager;
    private DrawerLayout drawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Poniższe 2 linijki ustawiają Toolbar jako systemy ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.content_main);
        viewPager.setAdapter(new MaterialPagerAdapter(this, getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
//
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // znikający FAB
//        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
//        p.setBehavior(new ScrollAwareFABBehavior(ontext, attrs, int defStyleAttr));
//        fab.setLayoutParams(p);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.some_action, Snackbar.LENGTH_LONG).setAction(R.string.undo, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
            }
        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Poniższe 3 linijku kodu ustawiają "burger icon" w naszym ActionBar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //ustawiamy obiekt implementujący interface NavigationView.OnNavigationItemSelectedListener
        navigationView.setNavigationItemSelectedListener(this);

        // Pobieramy zasób typu BitmapDrawable i pobieramy z niego bitmapę
        Bitmap bitmap = ((BitmapDrawable) getDrawable(R.drawable.avatar_default)).getBitmap();

        // Tworzymy obiekt typu RoundedBitmapDrawable przy użyciu naszej bitmapy i ustawiamy jego
        // kształt (za pomocą kanału alpha czyli przezroczystości) na okgrągły
        RoundedBitmapDrawable avatar = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        avatar.setCircular(true);

        // Wyświetlamy okrągły avatar użytkownika w ImageView pobiranym z layoutu nagłówka w naszym NavigationView
        ImageView avatarView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.avatar);
    avatarView.setImageDrawable(avatar);
}

    /**
     * Metoda onBackPressed() wykonywana jest po wciśnięciu prez użytkownika przycisku "wstecz".
     * Sprawdzamy czy drawer jest otwarty. Jeśli jest otwarty, zamykamy go i kończymy działanie metody,
     * w przeciwnym wypadku kierujemy akcję do metody w klasie po której dziedziczy ta aktywność.
     */
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /**
     * Wyświetlamy menu w ActionBarze
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toolbar, menu);
        return true;
    }

    /**
     * Przechwytujemy kliknięcia w menu ActionBar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Snackbar.make(drawer, R.string.some_settings, Snackbar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Przechwytujemy kliknięcia w naszej nawigacji.
     * Jest to implementacja interfejsu NavigationView.OnNavigationItemSelectedListener
     */

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent i = new  Intent(this, MainActivity.class);
            startActivity(i);
        }

        if (id == R.id.action_navig) {
            Intent i = new  Intent(this, Action_navig.class);
            startActivity(i);
        }

        if (id == R.id.nav_add_frend) {
            Intent i = new  Intent(this, Nav_add_frend.class);
            startActivity(i);
        }
        if (id == R.id.action_message) {
            Intent i = new  Intent(this, Action_navig.class);
            startActivity(i);
        }

        if (id == R.id.action_my_ads) {
            Intent i = new  Intent(this, Action_my_ads.class);
            startActivity(i);
        }

        if (id == R.id.action_my_favprite) {
            Intent i = new  Intent(this, Action_my_favorite.class);
            startActivity(i);
        }

        if (id == R.id.action_lav) {
            Intent i = new  Intent(this, Lav.class);
            startActivity(i);
        }

        if (id == R.id.action_add_ad) {
            Intent i = new  Intent(this, Action_my_ads.class);
            startActivity(i);
        }

        if (id == R.id.nav_settings) {
            Intent i = new  Intent(this, Nav_settings.class);
            startActivity(i);
        }


       DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
