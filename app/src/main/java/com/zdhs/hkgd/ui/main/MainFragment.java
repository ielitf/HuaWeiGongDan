package com.zdhs.hkgd.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.adapter.NewsAdapter;
import com.zdhs.hkgd.adapter.WorkSheetAdapter;
import com.zdhs.hkgd.data.VirtualData;
import com.zdhs.hkgd.entity.CommonBean;
import com.zdhs.hkgd.widget.NoScrollGridView;
import com.zdhs.hkgd.widget.NoScrollListView;

import java.util.ArrayList;

/**
 * 首页
 */
public class MainFragment extends Fragment {
    protected View contentView;
    private Context context;
    private NoScrollGridView workSheetView;
    private NoScrollListView newsView;
    private WorkSheetAdapter sheetAdapter;
    private NewsAdapter newsAdapter;
    private ArrayList<CommonBean> sheetList=null;
    private ArrayList<CommonBean> newsList=null;

    public MainFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        initviews(contentView);
        sheetAdapter = new WorkSheetAdapter(context,sheetList);
        workSheetView.setAdapter(sheetAdapter);
        newsAdapter = new NewsAdapter(context,newsList);
        newsView.setAdapter(newsAdapter);
        workSheetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"正在准备中。。。",Toast.LENGTH_SHORT).show();
            }
        });
        newsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"正在准备中。。。",Toast.LENGTH_SHORT).show();
            }
        });
        return contentView;
    }

    private void initviews(View contentView) {
        workSheetView = contentView.findViewById(R.id.sheet_gView);
        newsView = contentView.findViewById(R.id.new_listView);
        sheetList = new ArrayList<>();
        for(int i = 0; i< VirtualData.sheet_num.length; i++){
            sheetList.add(new CommonBean(VirtualData.sheet_num[i], VirtualData.sheet_icon[i], VirtualData.sheet_title[i]));
        }
        newsList = new ArrayList<>();
        for(int i = 0; i< VirtualData.news_title.length; i++){
            newsList.add(new CommonBean(VirtualData.news_title[i], VirtualData.news_summary[i], VirtualData.news_time[i]));
        }
    }
}
