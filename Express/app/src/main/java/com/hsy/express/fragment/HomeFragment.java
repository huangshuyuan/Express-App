package com.hsy.express.fragment;

import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsy.express.R;
import com.hsy.express.adapter.BannerAdapter;
import com.hsy.express.base.BaseFragment;
import com.hsy.express.ui.QueryExpressActivity;
import com.hsy.express.view.AutoPlayViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: syhuang
 * Date:  2017/12/25
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    List<Integer>     resIds;
    AutoPlayViewPager autoPlayViewPage;
    private LinearLayout numLayout;
    private ImageView    btnNumQueryImg;
    private TextView     btnNumQuery;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setUpView() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0之上使用
            //沉浸式状态栏
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        numLayout = (LinearLayout) mContentView.findViewById(R.id.num_layout);
        btnNumQueryImg = (ImageView) mContentView.findViewById(R.id.btn_num_query_img);
        btnNumQuery = (TextView) mContentView.findViewById(R.id.btn_num_query);
        numLayout.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {
        autoPlayViewPage = (AutoPlayViewPager) mContentView.findViewById(R.id.view_pager);

        initData();
        BannerAdapter bannerAdapter = new BannerAdapter(getMContext());
        bannerAdapter.update(resIds);
        autoPlayViewPage.setAdapter(bannerAdapter);

        // 以下两个方法不是必须的，因为有默认值
        autoPlayViewPage.setDirection(AutoPlayViewPager.Direction.LEFT);// 设置播放方向
        autoPlayViewPage.setCurrentItem(200); // 设置每个Item展示的时间

        autoPlayViewPage.start(); // 开始轮播
    }

    private void initData() {
        resIds = new ArrayList<>();
        // 模拟几张图片
        resIds.add(R.mipmap.img4);
        resIds.add(R.mipmap.img1);
        resIds.add(R.mipmap.img2);
        resIds.add(R.mipmap.img3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num_layout:
                startActivityWithoutExtras(QueryExpressActivity.class);
                break;
        }
    }
}
