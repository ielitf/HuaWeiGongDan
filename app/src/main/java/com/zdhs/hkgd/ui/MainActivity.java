package com.zdhs.hkgd.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;
import com.zdhs.hkgd.R;
import com.zdhs.hkgd.myinterface.FragmentInteractionListener;
import com.zdhs.hkgd.ui.main.MainFragment;
import com.zdhs.hkgd.ui.me.MeFragment;
import com.zdhs.hkgd.ui.news.NewsFragment;
import com.zdhs.hkgd.ui.worksheet.WorkSheetFragment;

public class MainActivity extends AppCompatActivity implements FragmentInteractionListener {
    private MainFragment mainFragment = null;
    private Fragment mContent = null;
    private WorkSheetFragment workSheetFragment = null;
    private NewsFragment newsFragment = null;
    private MeFragment meFragment = null;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    private static int position;
    private static boolean isClick = false;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mainFragment = new MainFragment();
        mContent = mainFragment;
        fragmentTransaction.add(R.id.main_activity_con, mainFragment);
        fragmentTransaction.commit();
    }

    private void initViews() {
        mainFragment = new MainFragment();
        workSheetFragment = new WorkSheetFragment();
        newsFragment = new NewsFragment();
        meFragment = new MeFragment();

        radioGroup = findViewById(R.id.rGroup_activity_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rBtn_activity_main_main:
                        switchContent(mainFragment);
                        break;
                    case R.id.rb_activity_main_work_sheet:
                        bundle = new Bundle();
                        bundle.putInt("position",position);
                        bundle.putBoolean("isClick",isClick);
                        workSheetFragment.setArguments(bundle);
                        switchContent(workSheetFragment);
                        break;
                    case R.id.rb_activity_main_news:
                        switchContent(newsFragment);
                        break;
                    case R.id.rb_activity_main_me:
                        switchContent(meFragment);
                        break;
                    default:
                        break;
                }
            }
        });

    }
    private void switchContent(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) { // 判断是否被add过
                // 隐藏当前的fragment，将 下一个fragment 添加进去
                transaction.hide(mContent).add(R.id.main_activity_con, to).commit();
            } else {
                // 隐藏当前的fragment，显示下一个fragment
                transaction.hide(mContent).show(to).commit();
            }
            mContent = to;
        }
    }

    @Override
    public void onFragmentInteraction(int position ,boolean bool) {
        this.position = position;
        isClick = bool;
        Log.d("=========","MainActivity position = :"+position);
        radioGroup.check(R.id.rb_activity_main_work_sheet);
    }
}
