package com.zdhs.hkgd.ui.news;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.adapter.NewsAdapter;
import com.zdhs.hkgd.data.VirtualData;
import com.zdhs.hkgd.bean.CommonBean;
import com.zdhs.hkgd.widget.NoScrollListView;

import java.util.ArrayList;

/**
 * 消息
 */
public class NewsFragment extends Fragment {
    protected View contentView;
    private Context context;
    private NoScrollListView newsListView;
    private ArrayList<CommonBean> newsList=null;
    private NewsAdapter newsAdapter;

    public NewsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_news, container, false);
        context = getActivity();
        initviews(contentView);
        newsAdapter = new NewsAdapter(context,newsList);
        newsListView.setAdapter(newsAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"正在准备中。。。",Toast.LENGTH_SHORT).show();
            }
        });
        return contentView;
    }

    private void initviews(View contentView) {
        newsListView = contentView.findViewById(R.id.new_listView);
        newsList = new ArrayList<>();
        for(int i = 0; i< VirtualData.news_title.length; i++){
            newsList.add(new CommonBean(VirtualData.news_title[i], VirtualData.news_summary[i], VirtualData.news_time[i]));
        }
    }

}
