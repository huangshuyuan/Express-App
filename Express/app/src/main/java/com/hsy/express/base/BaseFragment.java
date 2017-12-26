package com.hsy.express.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hsy.express.R;


/**
 * Created by syhuang on 2017/7/4.
 */

public abstract class BaseFragment extends Fragment {

    public View       mContentView;
    private Context    mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(setLayoutResourceID(), container, false);//setContentView(inflater, container);
        mContext = getContext().getApplicationContext();
        init();
        setUpView();
        setUpData();
        return mContentView;
    }

    protected abstract int setLayoutResourceID();

    /**
     * initialize before  setUpView and  setUpData
     */
    protected void init() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected abstract void setUpView();

    protected abstract void setUpData();

    protected <T extends View> T $(int id) {
        return (T) mContentView.findViewById(id);
    }


    protected View getContentView() {
        return mContentView;
    }

    public Context getMContext() {
        return mContext;
    }

    public void refresh() {
    }

    /**
     * 基本的彈框
     *
     * @param message
     */
    public void showMessage(String message) {
        try {
            Toast.makeText(getMContext(), message, Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e) {
            e.printStackTrace();

        }
    }

    protected void startActivityWithoutExtras(Class<?> clazz) {
        Intent intent = new Intent(getMContext(), clazz);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_right_in,
                R.anim.slide_left_out);
    }

    protected void startActivityWithExtras(Class<?> clazz, Bundle extras) {
        Intent intent = new Intent(getMContext(), clazz);
        intent.putExtras(extras);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_right_in,
                R.anim.slide_left_out);
    }
}
