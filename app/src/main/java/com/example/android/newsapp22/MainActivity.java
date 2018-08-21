package com.example.android.newsapp22;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        tabLayout.addTab(tabLayout.newTab().setText("Hungary"));
        tabLayout.addTab(tabLayout.newTab().setText("Turkey"));
        tabLayout.addTab(tabLayout.newTab().setText("Slovakia"));
        tabLayout.addTab(tabLayout.newTab().setText("Russia"));
        tabLayout.addTab(tabLayout.newTab().setText("Austria"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.getTabAt(0).setIcon(R.drawable.flag_hu);
        tabLayout.getTabAt(1).setIcon(R.drawable.flag_tr);
        tabLayout.getTabAt(2).setIcon(R.drawable.flag_sk);
        tabLayout.getTabAt(3).setIcon(R.drawable.flag_ru);
        tabLayout.getTabAt(4).setIcon(R.drawable.flag_at);
    }
}



