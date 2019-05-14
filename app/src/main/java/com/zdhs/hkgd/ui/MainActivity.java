package com.zdhs.hkgd.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import com.zdhs.hkgd.R;
import com.zdhs.hkgd.ui.main.MainFragment;
import com.zdhs.hkgd.ui.me.MeFragment;
import com.zdhs.hkgd.ui.news.NewsFragment;
import com.zdhs.hkgd.ui.worksheet.WorkSheetFragment;

public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment = null;
    private WorkSheetFragment workSheetFragment = null;
    private NewsFragment newsFragment = null;
    private MeFragment meFragment = null;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mainFragment = new MainFragment();
        fragmentTransaction.add(R.id.main_activity_con, mainFragment);
        fragmentTransaction.show(mainFragment);
        fragmentTransaction.commit();
    }

    private void initViews() {

        radioGroup = findViewById(R.id.rGroup_activity_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                hideFragment(fragmentTransaction);
                switch (checkedId) {
                    case R.id.rBtn_activity_main_main:
                        if (mainFragment == null) {
                            mainFragment = new MainFragment();
                            fragmentTransaction.add(R.id.main_activity_con, mainFragment);
                        } else {
                            fragmentTransaction.show(mainFragment);
                        }
                        break;
                    case R.id.rb_activity_main_work_sheet:
                        if (workSheetFragment == null) {
                            workSheetFragment = new WorkSheetFragment();
                            fragmentTransaction.add(R.id.main_activity_con, workSheetFragment);
                        } else {
                            fragmentTransaction.show(workSheetFragment);
                        }
                        break;
                    case R.id.rb_activity_main_news:
                        if (newsFragment == null) {
                            newsFragment = new NewsFragment();
                            fragmentTransaction.add(R.id.main_activity_con, newsFragment);
                        } else {
                            fragmentTransaction.show(newsFragment);
                        }
                        break;
                    case R.id.rb_activity_main_me:
                        if (meFragment == null) {
                            meFragment = new MeFragment();
                            fragmentTransaction.add(R.id.main_activity_con, meFragment);
                        } else {
                            fragmentTransaction.show(meFragment);
                        }
                        break;
                    default:
                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();
            }
        });

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (workSheetFragment != null) {
            transaction.hide(workSheetFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }
}
