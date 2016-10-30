package com.qst.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.fightshop.R;
import com.qst.entity.OrderDetailItemBean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class OrderDetailAdapter extends BaseAdapter{

    private LayoutInflater mLayoutInflater;
    private List<OrderDetailItemBean> mList;

    public OrderDetailAdapter(Context context,List<OrderDetailItemBean> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mList = list;
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.listview_today_orderlist_item, null);
            holder.date = (TextView) convertView.findViewById(R.id.tv_detail_date);
            holder.detail = (TextView) convertView.findViewById(R.id.tv_detail__detail);
            holder.price = (TextView) convertView.findViewById(R.id.tv_detail_price);
            convertView.setTag(holder);
     } else {
           holder = (ViewHolder) convertView.getTag();
       }
        OrderDetailItemBean bean = mList.get(position);
        holder.date.setText(bean.itemDate);
        holder.detail.setText(bean.itemDetail);
        holder.price.setText(bean.itemPrice);
        return convertView;
    }
    class ViewHolder{
        public TextView date;
        public TextView detail;
        public TextView price;
    }
}
