package com.zdhs.hkgd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zdhs.hkgd.R;
import com.zdhs.hkgd.bean.CommonBean;
import java.util.ArrayList;

public class WorkSheetAdapter extends MyBaseAdapter<CommonBean> {
    private LayoutInflater inflater;
    public WorkSheetAdapter(Context context, ArrayList<CommonBean> mData) {
        super(context, mData);
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected View newView(Context context, int position, ViewGroup parentView) {
        ViewHolder holderView = new ViewHolder();
        View convertView = inflater.inflate(R.layout.item_main_work_sheet, null, false);
        holderView.sheet_title = (TextView) convertView.findViewById(R.id.item_sheet_title);
        holderView.sheet_num = (TextView) convertView.findViewById(R.id.item_sheet_num);
        holderView.sheetIcon = (ImageView) convertView.findViewById(R.id.item_sheet_img);
        convertView.setTag(holderView);
        return convertView;
    }

    @Override
    protected void bindView(Context context, View view, int position, CommonBean model) {
        ViewHolder holderView = (ViewHolder) view.getTag();
        holderView.sheet_title.setText(model.getTitle());
        holderView.sheet_num.setText(model.getNum()+"");
        holderView.sheetIcon.setImageResource(model.getIcon());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        private TextView sheet_title;
        private ImageView sheetIcon;
        private TextView sheet_num;
    }
}
