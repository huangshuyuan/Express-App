package com.hsy.express.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hsy.express.R;
import com.hsy.express.base.BaseActivity;
import com.hsy.express.fragment.HomeFragment;
import com.hsy.express.fragment.MeFragment;
import com.hsy.express.utils.ViewUtils;

public class MainActivity extends BaseActivity {

    private FragmentManager mFragmentManager;
    private Fragment        mCurrentFragment;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        try {
            mFragmentManager = getSupportFragmentManager();

            initDefaultFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(HomeFragment.class);
                    return true;
                case R.id.navigation_scan:
                    //扫描二维码
                    IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                    // 设置自定义扫描Activity
                    intentIntegrator.setCaptureActivity(CustomCaptureActivity.class);
                    intentIntegrator.initiateScan();
                    return false;
                case R.id.navigation_me:
                    switchFragment(MeFragment.class);
                    return true;
            }
            return false;
        }

    };

    //init the default checked fragment
    private void initDefaultFragment() {
        ViewUtils.clearAll();
        mCurrentFragment = ViewUtils.createFragment(HomeFragment.class);
        mFragmentManager.beginTransaction().add(R.id.main_content, mCurrentFragment).commit();

    }


    //切换Fragment
    private void switchFragment(Class<?> clazz) {
        Fragment to = ViewUtils.createFragment(clazz);
        if (to.isAdded()) {
            //            mFragmentManager.beginTransaction().hide(mCurrentFragment).replace(R.id.main_content, to).commitAllowingStateLoss();
            mFragmentManager.beginTransaction().hide(mCurrentFragment).show(to).commitAllowingStateLoss();
        } else {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).add(R.id.main_content, to).commitAllowingStateLoss();
        }
        mCurrentFragment = to;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (data != null) {
            // 获取解析结果
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                if (result.getContents() == null) {
                    showMessage("取消");
                } else {
                    //                Toast.makeText(this, "扫描内容:" + result.getContents(), Toast.LENGTH_LONG).show();


                    String contents = result.getContents();
                    showMessage("快递柜已打开，请尽快取走快递");

                    Log.e("contents", contents);


                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }


    }
}
