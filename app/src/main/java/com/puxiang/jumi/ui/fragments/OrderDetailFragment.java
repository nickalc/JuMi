package com.puxiang.jumi.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.puxiang.jumi.R;

public class OrderDetailFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    public static OrderDetailFragment newInstance(int position) {
        OrderDetailFragment f = new OrderDetailFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView = inflater.inflate(R.layout.fragment_order_detail, container, false);

       // ProgressBarCircular progressBarCircular = (ProgressBarCircular) rootView.findViewById(R.id.progress);
       // FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabButton);


        return rootView;
    }
}