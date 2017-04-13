package com.dearxy.listviewitemclick;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 周旭 on 2017/4/13.
 */

public class MyAdapter extends BaseAdapter {

    private static final String TAG = "TitleFragment";
    private List<String> mList;
    private LayoutInflater inflater;
    private int mSelect;   //选中项

    public MyAdapter(Context context, List<String> mList) {
        this.mList = mList;
        inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_title_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置相关数据
        String title = mList.get(position);
        holder.titleTv.setText(title);
        Log.i(TAG, "getView:     " + position + "-------->被执行了");
        if (mSelect == position) {
            Log.i(TAG, "第:   " + position + " 项被点击了");
            holder.titleTv.setEnabled(true);
            //选中项背景
            holder.titleLayout.setBackgroundColor(Color.RED);
        } else {
            holder.titleTv.setEnabled(false);
            //其他项背景
            holder.titleLayout.setBackgroundColor(Color.YELLOW);
        }
        return convertView;
    }

    //刷新方法
    public void changeSelected(int positon) {
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    private class ViewHolder {
        private LinearLayout titleLayout;
        private TextView titleTv;

        private ViewHolder(View view) {
            titleLayout = (LinearLayout) view.findViewById(R.id.title_layout);
            titleTv = (TextView) view.findViewById(R.id.title_tv);
        }
    }
}
