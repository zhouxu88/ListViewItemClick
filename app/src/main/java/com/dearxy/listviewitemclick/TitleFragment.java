package com.dearxy.listviewitemclick;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {

    private static final String TAG = "TitleFragment";
    private ListView titleLv;
    private List<String> mList;
    private MyAdapter mAdapter;


    public TitleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);

        titleLv = (ListView) view.findViewById(R.id.titles_lv);
        initListView();
        return view;
    }

    //初始化ListView
    private void initListView() {
        mList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mList.add("商品" + i);
        }
        mAdapter = new MyAdapter(getActivity(), mList);
        titleLv.setAdapter(mAdapter);
        titleLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "第:   " + position + " 项被点击了");
                mAdapter.changeSelected(position);
                EventBus.getDefault().post("第" + position + "项详情");
            }
        });
    }
}
