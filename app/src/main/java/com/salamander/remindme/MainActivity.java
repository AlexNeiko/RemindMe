package com.salamander.remindme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private Toolbar toolbar; //переменная для тулбара меню

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initToolbar(); //инициализируем меню тулбара
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
}
