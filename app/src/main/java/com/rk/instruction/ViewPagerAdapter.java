package com.rk.instruction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIDs;

    public ViewPagerAdapter(Context context, int[] datas){
        mImageIDs = datas;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageIDs.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = createImageView(mContext, position);
        container.addView(mImageView);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


    private ImageView createImageView(Context mContext, int position) {
        RoundImageView imageview = new RoundImageView(mContext);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        imageview.setLayoutParams(layoutParams);
        imageview.setImageResource(mImageIDs[position]);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageview;
    }
}
