package com.zdhs.hkgd.ui.worksheet;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.myinterface.FragmentInteractionListener;
import com.zdhs.hkgd.ui.me.MeFragment;
import com.zdhs.hkgd.widget.SmartTab.SmartTabLayout;
import com.zdhs.hkgd.widget.SmartTab.UtilsV4.v4.FragmentPagerItem;
import com.zdhs.hkgd.widget.SmartTab.UtilsV4.v4.FragmentPagerItemAdapter;
import com.zdhs.hkgd.widget.SmartTab.UtilsV4.v4.FragmentPagerItems;

/**
 * 工单
 */
public class WorkSheetFragment extends Fragment{
    protected View contentView;
    private Context context;
    private SearchView searchView;
    private ListView textListView;
    private TextView work_sheet_sum_num;
    private String[] searchStrs = {"aaa", "bbb", "ccc", "airsaid"};
    private String[] stateTitles = {"全部", "待接单", "待预约","待维修","已完成"};//标题内容
    private String[] titles = new String[5];
    private String type;
    private ViewGroup tab;//导航条
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    private static  int position = 0;
    private static  int getPosition = 0;
    private static  int myPosition = 0;
    private static boolean isClick = false;
    private Handler handler = new Handler() {

        // 处理消息
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            switch (msg.what) {
                case 1:
                    if(myPosition == getPosition){
                        position = getPosition;
                    }else{
                        position = myPosition;
                    }
                    break;
                default:
                    break;
            }
            viewPager.setCurrentItem(position);
        }

    };
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            myPosition = viewPager.getCurrentItem();
            return;
        }else{  // 在最前端显示 相当于调用了onResume();
            //网络数据刷新
            getPosition = getArguments().getInt("position",0);
//                isClick = getArguments().getBoolean("isClick",false);
            Log.d("=========","WorkSheetFragment onHiddenChanged position = :"+position);
            handler.sendEmptyMessage(1);

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_work_sheet, container, false);
        context = getActivity();
        initviews(contentView);
        FragmentPagerItems pages = new FragmentPagerItems(context);
        titles = stateTitles;
        pages.add(FragmentPagerItem.of(titles[0], WorkSheetSubFragment.class));
        pages.add(FragmentPagerItem.of(titles[1], WorkSheetSubFragment.class));
        pages.add(FragmentPagerItem.of(titles[2], WorkSheetSubFragment.class));
        pages.add(FragmentPagerItem.of(titles[3], WorkSheetSubFragment.class));
        pages.add(FragmentPagerItem.of(titles[4], WorkSheetSubFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        getPosition = getArguments().getInt("position",0);
//        isClick = getArguments().getBoolean("isClick",false);
        viewPagerTab.setViewPager(viewPager);
        viewPager.setCurrentItem(0);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("=========","开始搜索了");
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
//                if (!TextUtils.isEmpty(newText)){
//                    textListView.setFilterText(newText);
//                }else{
//                    textListView.clearTextFilter();
//                }
                return false;
            }
        });
        return contentView;
    }

    private void initviews(View contentView) {
        work_sheet_sum_num = contentView.findViewById(R.id.work_sheet_sum_num);
        tab = contentView.findViewById(R.id.tab);
        viewPager = contentView.findViewById(R.id.work_sheet_viewpager);
        searchView = contentView.findViewById(R.id.search_bar);
        textListView = contentView.findViewById(R.id.listView);
        textListView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, searchStrs));
        textListView.setTextFilterEnabled(true);
        tab.addView(LayoutInflater.from(context).inflate(R.layout.tab_top_layout, tab, false));
        viewPagerTab = contentView.findViewById(R.id.viewpagertab);
    }
}
