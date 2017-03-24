package com.liuhonghao.com.trainlife.activity;


import com.liuhonghao.com.trainlife.PrimeFragment.AgainSeeFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.ChoiceThemeFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.HistoryFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.MyBMoneyFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.MyCareFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.MySaveFragment;
import com.liuhonghao.com.trainlife.PrimeFragment.ShouYeFragment;
import android.liuhonghao.com.trainlife.R;
import com.liuhonghao.com.trainlife.base.BaseFragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.liuhonghao.com.trainlife.R.id.fl_main;


public class MainActivity extends AppCompatActivity {


    /*Toolbar toolbar;

    TabLayout tbLayout;

    ViewPager viewPager;

    LinearLayout contentMain;

    FloatingActionButton fab;
    private List<BaseFragment> fragments;
    private CommunityViewPagerAdapter adapter;
    private FragmentManager manager;
    private ImageView ivmore;
    private DrawerLayout dr;
    private NavigationView navigationView;
    private View headerView;*/
    private List<BaseFragment> fragments;
    private NavigationView navigationView;
    private int position;
    private View headerView;
    private Fragment countfragment;
    private DrawerLayout dr;
    private ImageView ivmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        dr= (DrawerLayout) findViewById(R.id.dr_layout);
         ivmore = (ImageView) findViewById(R.id.iv_more);

       /*
        toolbar= (Toolbar) findViewById(toolbar);
        tbLayout= (TabLayout) findViewById(R.id.tb_layout);
        viewPager= (ViewPager) findViewById(R.id.view_pager);
        contentMain= (LinearLayout) findViewById(R.id.content_main);
        fab= (FloatingActionButton) findViewById(fab);
        ivmore= (ImageView) findViewById(R.id.iv_more);
         dr = (DrawerLayout) findViewById(R.id.dr_layout);
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        initLister();
        iniData();*/

        initFragmenr();
        initLister();



    }



   private void initLister() {
         headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "我是头", Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main:
                        position=0;
                     break;
                    case R.id.see:
                        position=1;
                     break;
                    case R.id.save:
                        position=2;
                     break;
                    case R.id.hostory:
                        position=3;
                     break;
                    case R.id.guanzhu:
                        position=4;
                     break;
                    case R.id.money:
                        position=5;
                     break;
                    case R.id.theme:
                        position=6;
                     break;
                }
                Fragment currentFragment = fragments.get(position);
                SwitchFragment(currentFragment);
                return true;
            }
        });
      /* ivmore.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dr.openDrawer(Gravity.LEFT);
           }
       });*/
       SwitchFragment(fragments.get(0));
    }

    private void SwitchFragment(Fragment currentFragment) {
        if(countfragment!=currentFragment){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(!currentFragment.isAdded()){
                if(countfragment!=null){
                    ft.hide(countfragment);
                }
                ft.add(fl_main,currentFragment);

            }else {
                if(countfragment!=null){
                    ft.hide(countfragment);
                }
                ft.show(currentFragment);
            }
            countfragment=currentFragment;
            ft.commit();

        }
    }

   /* private void iniData() {
        initFragmenr();
        manager = getSupportFragmentManager();
        adapter = new CommunityViewPagerAdapter(manager, fragments);
        viewPager.setAdapter(adapter);
        //将tablayout和viewpager关联
        tbLayout.setupWithViewPager(viewPager);
        //设置tab的模式
        tbLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }*/

    private void initFragmenr() {
        fragments = new ArrayList<>();
        fragments.add(new ShouYeFragment());//0
        fragments.add(new AgainSeeFragment());//1
        fragments.add(new MySaveFragment());
        fragments.add(new HistoryFragment());
        fragments.add(new MyCareFragment());
        fragments.add(new MyBMoneyFragment());
        fragments.add(new ChoiceThemeFragment());
    }

}
