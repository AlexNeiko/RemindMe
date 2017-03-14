package com.salamander.remindme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.salamander.remindme.adapter.TabsPagerFragmentAdapter;


public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT =R.layout.activity_main; //выносим в константу нужное активити.

    private Toolbar toolbar; //переменная для тулбара меню
    private DrawerLayout drawerLayout;
    private ViewPager viewPager; //переменная верхнего, горизонтальног меню


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppDelault); //в стилях создали свою тему и тут прописываем ее для активити
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        
        initToolbar(); //инициализируем меню тулбара
        initNavigationView(); //инцициализируем метод для пунктов меню navigationbar
        initTabs();



    }

    //метод создания меню тулбара
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar); //присваиваем тулбар
        toolbar.setTitle(R.string.app_name); //title
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { //слушатель по нажатию меню
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.nemu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout); //подключаемся к верхнему меню
        tabLayout.setupWithViewPager(viewPager);

    }

    //метод инициализации пунктов меню navigationbar
    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); //получаем наш слой с меню

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }
        });
    }

    private void showNotificationTab() {
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
}
