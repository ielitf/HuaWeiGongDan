package com.zdhs.hkgd.control;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * @类 :自定义application
 */
public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication application;

    public static MyApplication getMyApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public void showToast(String msg) {
        Toast.makeText(application, msg + "", Toast.LENGTH_SHORT).show();
    }



    /**
     * 退出登录
     */
    public void reSet() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor edit = preferences.edit();
        edit.clear();
        edit.commit();
    }

    public boolean logout() {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.this);
        Editor edit = preferences.edit();
        edit.clear();
        return edit.commit();
    }

}
