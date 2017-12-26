package com.hsy.express.ui;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.hsy.express.R;
import com.hsy.express.base.BaseActivity;
import com.hsy.express.sqlbean.User;
import com.hsy.express.utils.Utils;
import com.hsy.greendaodemo.db.UserDao;

import java.util.List;

import static com.hsy.express.config.MyApplication.daoSession;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private AutoCompleteTextView textPhone;
    private TextView             title;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_register;
    }

    @Override
    protected void setUpView() {
        textPhone = (AutoCompleteTextView) findViewById(R.id.text_phone);
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        title = (TextView) findViewById(R.id.title);
        title.setText(getString(R.string.register));
    }

    private EditText getTextPwd() {
        return (EditText) findViewById(R.id.text_pwd);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_register:
                register();

                break;
        }
    }

    private void register() {
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
            showMessage("该账号已注册，请重新输入！");
            return;
        }
        User user = new User();
        user.setPhone(phone);
        user.setPassowrd(psw);
        userDao.insert(user);
        showMessage("注册成功！");
        finish();
    }
}
