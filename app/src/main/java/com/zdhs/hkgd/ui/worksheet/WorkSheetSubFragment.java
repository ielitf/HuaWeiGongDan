package com.zdhs.hkgd.ui.worksheet;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.adapter.WorkSheetDetailAdapter;
import com.zdhs.hkgd.data.VirtualData;
import com.zdhs.hkgd.bean.WorkSheetBean;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkSheetSubFragment extends Fragment {
    private View contentView;
    private Context context;
    private ListView newsListView;
    private ArrayList<WorkSheetBean> sheetList=null;
    private WorkSheetDetailAdapter sheetDetailAdapter;
    public WorkSheetSubFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_sub_work_sheet,container,false);

        context = getActivity();
        initviews(contentView);
        sheetDetailAdapter = new WorkSheetDetailAdapter(context,sheetList);
        newsListView.setAdapter(sheetDetailAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,SheetDetailActivity.class);
                startActivity(intent);
            }
        });

        return contentView;
    }
    private void initviews(View contentView) {
        newsListView = contentView.findViewById(R.id.work_sheet_sub_listView);
        sheetList = new ArrayList<>();
        for(int i = 0; i< VirtualData.sheet_detail_id.length; i++){
            sheetList.add(new WorkSheetBean(VirtualData.sheet_detail_id[i], VirtualData.sheet_detail_State[i], VirtualData.sheet_detail_shopName[i]
                    , VirtualData.sheet_detail_equipmentName[i], VirtualData.priority[i], VirtualData.sheet_detail_workerName[i]
                    , VirtualData.sheet_detail_workerTel[i], VirtualData.sheet_detail_date[i]));
        }
    }
}
