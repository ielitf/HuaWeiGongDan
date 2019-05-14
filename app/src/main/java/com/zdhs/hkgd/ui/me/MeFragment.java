package com.zdhs.hkgd.ui.me;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdhs.hkgd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private View contentView;
    private Context context;
    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_me,container,false);

        context = getActivity();
        return contentView;
    }

}
