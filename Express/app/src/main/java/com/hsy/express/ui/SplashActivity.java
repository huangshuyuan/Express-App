package com.hsy.express.ui;

import android.content.Intent;
import android.os.Handler;

import com.hsy.express.R;
import com.hsy.express.base.BaseActivity;
import com.hsy.express.utils.Utils;

public class SplashActivity extends BaseActivity {


    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setUpView() {
        goToMain();
    }

    private void goToMain() {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (Utils.isLogin()) {
                    //你需要跳转的地方的代码
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
                //                overridePendingTransition(R.anim.fade_in, android.support.design.R.anim.abc_fade_out);
            }
        }, 1500); //延迟2秒跳转
    }
}
