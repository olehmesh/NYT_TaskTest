package com.olehmesh.nyt_tasktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.olehmesh.nyt_tasktest.adapters.AdapterViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    AdapterViewPager mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createTabs();
    }




    private void createTabs() {

        mAdapter = new AdapterViewPager(getSupportFragmentManager());

        TabFragment mailed = new TabFragment();
        mailed.addTabTitle("most emailed");
        mAdapter.addFragment(mailed, mailed.getNameTab());

        TabFragment shared = new TabFragment();
        shared.addTabTitle("most shared");
        mAdapter.addFragment(shared, shared.getNameTab());

        TabFragment viewed = new TabFragment();
        viewed.addTabTitle("most viewed");
        mAdapter.addFragment(viewed, viewed.getNameTab());

        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorites_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {
                startActivity(new Intent(this, SavedActivity.class));
                break;
            }
        }
        return false;
    }
}
