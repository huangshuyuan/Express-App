package com.hsy.express.config;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.hsy.greendaodemo.db.DaoMaster;
import com.hsy.greendaodemo.db.DaoSession;

/**
 * Author: syhuang
 * Date:  2017/12/26
 */

public class MyApplication extends Application {
    public static  DaoSession    daoSession;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "express.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        instance = this;
    }

    /**
     * 获取当前对象
     *
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
