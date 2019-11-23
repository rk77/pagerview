package com.rk.instruction;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private static final String TAG = FullscreenActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private TextView mPageNumTextView;

    private static final int[] IMAGES = new int[]{
            R.drawable.introduce_1,
            R.drawable.introduce_2,
            R.drawable.introduce_3,
            R.drawable.introduce_4,
            R.drawable.introduce_5,
            R.drawable.introduce_6,
            R.drawable.introduce_7,
            R.drawable.introduce_8,
            R.drawable.post_1,
            R.drawable.post_2,
            R.drawable.post_3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mViewPager = findViewById(R.id.view_pager);
        mPageNumTextView = findViewById(R.id.page_number);

        mViewPager.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        ViewPagerAdapter vpa = new ViewPagerAdapter(this, IMAGES);
        mViewPager.setAdapter(vpa);
        mViewPager.setPageMargin(40);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPageNumTextView.setText(position + 1 + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
