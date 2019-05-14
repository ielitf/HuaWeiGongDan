package com.zdhs.hkgd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.entity.CommonBean;

import java.util.ArrayList;

public class NewsAdapter extends MyBaseAdapter<CommonBean> {
    private LayoutInflater inflater;
    public NewsAdapter(Context context, ArrayList<CommonBean> mData) {
        super(context, mData);
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected View newView(Context context, int position, ViewGroup parentView) {
        ViewHolder holderView = new ViewHolder();
        View convertView = inflater.inflate(R.layout.item_main_newst, null, false);
        holderView.news_title = (TextView) convertView.findViewById(R.id.item_news_title);
        holderView.news_time = (TextView) convertView.findViewById(R.id.item_news_time);
        holderView.news_summary = (TextView)convertView.findViewById(R.id.item_news_summary);
        convertView.setTag(holderView);
        return convertView;
    }

    @Override
    protected void bindView(Context context, View view, int position, CommonBean model) {
        ViewHolder holderView = (ViewHolder) view.getTag();
        holderView.news_title.setText(model.getTitle());
        holderView.news_time.setText(model.getTime());
        holderView.news_summary.setText(model.getSummary());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        private TextView news_title,news_time,news_summary;
    }
}
