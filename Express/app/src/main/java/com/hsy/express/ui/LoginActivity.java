package com.hsy.express.ui;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.hsy.express.R;
import com.hsy.express.base.BaseActivity;
import com.hsy.express.sqlbean.User;
import com.hsy.express.utils.AppConfig;
import com.hsy.express.utils.Utils;
import com.hsy.greendaodemo.db.UserDao;

import java.util.List;

import static com.hsy.express.config.MyApplication.daoSession;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private AutoCompleteTextView textPhone;
    private TextView             btnForget;


    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_login;
    }

    @Override
    protected void setUpView() {

        textPhone = (AutoCompleteTextView) findViewById(R.id.text_phone);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
        btnForget = (TextView) findViewById(R.id.btn_forget);
        btnForget.setOnClickListener(this);
    }

    private EditText getTextPwd() {
        return (EditText) findViewById(R.id.text_pwd);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_forget:
                startActivityWithoutExtras(FindPswActivity.class);
                break;
            case R.id.btn_register:
                startActivityWithoutExtras(RegisterActivity.class);
                break;
        }
    }

    private void login() {
        String phone = textPhone.getText().toString();
        if (Utils.isEmpty(phone)) {
            showMessage("手机号不能为空");
            return;
        }
        if (!Utils.isPhone(phone)) {
            showMessage("手机号格式不正确");
            return;
        }

        String psw = getTextPwd().getText().toString();
        if (Utils.isEmpty(psw)) {
            showMessage("密码不能为空");
            return;
        }
        if (psw.length() < 4 || psw.length() > 8) {
            showMessage("密码长度4-8");
            return;
        }

        UserDao userDao = daoSession.getUserDao();

        List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Phone.eq(phone)).list();
        if (userList.size() > 0) {
            if (userList.size() == 1) {
                User user = userList.get(0);
                if (user.getPassowrd().equals(psw)) {
                    showMessage("登录成功！");
                    startActivityWithoutExtras(MainActivity.class);
                    AppConfig.getInstance().putBoolean("isLogin", true);
                    AppConfig.getInstance().putLong("id", user.getId());
                    finish();
                } else {
                    showMessage("密码错误！");
                }
            }

            return;
        } else {
            showMessage("用户不存在！");
        }
    }
}
