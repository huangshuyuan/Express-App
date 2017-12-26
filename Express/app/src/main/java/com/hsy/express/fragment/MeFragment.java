package com.hsy.express.fragment;

import android.view.View;
import android.widget.TextView;

import com.hsy.express.R;
import com.hsy.express.base.BaseFragment;
import com.hsy.express.sqlbean.User;
import com.hsy.express.ui.LoginActivity;
import com.hsy.express.utils.AppConfig;
import com.hsy.greendaodemo.db.UserDao;

import java.util.List;

import static com.hsy.express.config.MyApplication.daoSession;

/**
 * Author: syhuang
 * Date:  2017/12/25
 */

public class MeFragment extends BaseFragment implements View.OnClickListener {
    private TextView phoneText;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void setUpView() {
        phoneText = (TextView) mContentView.findViewById(R.id.phone_text);
        mContentView.findViewById(R.id.btn_exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exit:
                AppConfig.getInstance().putBoolean("isLogin", false);
                getActivity().finish();
                startActivityWithoutExtras(LoginActivity.class);

                break;
        }
    }

    @Override
    protected void setUpData() {
        long id = AppConfig.getInstance().getLong("id", 0l);
        UserDao userDao = daoSession.getUserDao();

        List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.eq(id)).list();
        if (userList.size() == 1) {
            User user = userList.get(0);
            String phone = user.getPhone();
            String temp = phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4);
            phoneText.setText(temp);

        }

    }
}
