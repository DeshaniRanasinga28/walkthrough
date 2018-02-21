package com.newsalerts.ef;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.newsalerts.ef.adapter.ImagePagerAdapter;
import com.newsalerts.ef.fragment.IntroContentFragment;
import com.newsalerts.ef.walkthrought.R;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements IntroContentFragment.IndicatorVisibilityListener {

    private ViewPager viewPager;
    private ImagePagerAdapter adapter;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.pager);

        adapter = new ImagePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangeVisibility(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        indicator.setViewPager(viewPager);
    }

    @Override
    public void onChangeVisibility(int position) {
        if(position == 4){
            indicator.setVisibility(View.GONE);
        }else{
            indicator.setVisibility(View.VISIBLE);
        }

    }
}
