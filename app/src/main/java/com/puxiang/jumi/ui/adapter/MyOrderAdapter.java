package com.puxiang.jumi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.puxiang.jumi.R;
import com.puxiang.jumi.bean.OrderListItem;
import com.puxiang.jumi.ui.OrderDetailActivity;

import java.util.List;

/**
 * Created by nick on 15/10/26.
 */
public class MyOrderAdapter extends AutoRVAdapter {

    private Context context;

    public MyOrderAdapter(Context context, List<OrderListItem> list) {
        super(context, list);
        this.context = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_order_recyclerview;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        OrderListItem item=(OrderListItem) list.get(position);
        holder.getTextView(R.id.titleTextView).setText(item.getTitle());
        holder.getTextView(R.id.dateTextView).setText(item.getDate());

        String status = item.getStatus();
        if (status.equals("1")){
            status = "未完成";
            holder.getTextView(R.id.orderStatus).setTextColor(context.getResources().getColor(R.color.awesome_orange));
        }else{
            status = "订单完成";
            holder.getTextView(R.id.orderStatus).setTextColor(context.getResources().getColor(R.color.awesome_gray));
        }
        holder.getTextView(R.id.orderStatus).setText(status);


        holder.getTextView(R.id.orderPrice).setText(item.getPrice());

        holder.getImageView(R.id.titleImageView).setImageDrawable(context.getResources().getDrawable(R.mipmap.index_img));

        holder.getConvertView().findViewById(R.id.item_order_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "点击事件"+position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, OrderDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }
}