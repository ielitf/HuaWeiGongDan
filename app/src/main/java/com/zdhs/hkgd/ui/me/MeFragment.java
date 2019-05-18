package com.zdhs.hkgd.ui.me;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zdhs.hkgd.R;
import com.zdhs.hkgd.adapter.MeItemAdapter;
import com.zdhs.hkgd.bean.MeItemBean;
import java.util.ArrayList;

public class MeFragment extends Fragment {
    private View contentView;
    private Context context;
    private ListView listView;
    private ArrayList <MeItemBean> list = new ArrayList<>();
    private MeItemAdapter adapter ;
    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_me,container,false);
        listView = contentView.findViewById(R.id.me_list);
        context = getActivity();
        list.add(new MeItemBean(R.drawable.ic_launcher,"我的工单"));
        adapter = new MeItemAdapter(context,list);
        listView.setAdapter(adapter);
        return contentView;
    }

}
