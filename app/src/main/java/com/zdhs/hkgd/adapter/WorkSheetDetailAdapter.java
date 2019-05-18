package com.zdhs.hkgd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.bean.WorkSheetBean;

import java.util.ArrayList;

public class WorkSheetDetailAdapter extends MyBaseAdapter<WorkSheetBean> {
    private LayoutInflater inflater;
    public WorkSheetDetailAdapter(Context context, ArrayList<WorkSheetBean> mData) {
        super(context, mData);
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected View newView(Context context, int position, ViewGroup parentView) {
        ViewHolder holderView = new ViewHolder();
        View convertView = inflater.inflate(R.layout.item_work_sheet_detail, null, false);
        holderView.sheetID = (TextView) convertView.findViewById(R.id.item_sheet_id);
        holderView.sheetState = (TextView) convertView.findViewById(R.id.item_sheet_state);
        holderView.shopName = (TextView) convertView.findViewById(R.id.item_sheet_shop_name);
        holderView.equipmentName = (TextView) convertView.findViewById(R.id.item_sheet_equ);
        holderView.priority = (RatingBar) convertView.findViewById(R.id.item_sheet_star);
        holderView.workerName = (TextView) convertView.findViewById(R.id.item_sheet_worker_name);
        holderView.workerTel = (TextView) convertView.findViewById(R.id.item_sheet_tel);
        holderView.date = (TextView) convertView.findViewById(R.id.item_sheet_date);
        convertView.setTag(holderView);
        return convertView;
    }

    @Override
    protected void bindView(Context context, View view, int position, WorkSheetBean model) {
        ViewHolder holderView = (ViewHolder) view.getTag();
        holderView.sheetID.setText(model.getSheetID());
        holderView.sheetState.setText(model.getSheetState());
        holderView.shopName.setText(model.getShopName());
        holderView.equipmentName.setText(model.getEquipmentName());
        holderView.workerName.setText(model.getWorkerName());
        holderView.workerTel.setText(model.getWorkerTel());
        holderView.date.setText(model.getDate());
        holderView.priority.setNumStars(model.getPriority());
        holderView.priority.setRating(model.getPriority());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        private TextView sheetID,sheetState,shopName,equipmentName,workerName,workerTel,date;
        private RatingBar priority;
    }
}
