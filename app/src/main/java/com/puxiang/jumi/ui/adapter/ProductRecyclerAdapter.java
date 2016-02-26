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
public class ProductRecyclerAdapter extends AutoRVAdapter {

    private Context context;

    public ProductRecyclerAdapter(Context context, List<OrderListItem> list) {
        super(context, list);
        this.context = context;
    }

    @Override
    public int onCreateViewLayoutID(int viewType) {
        return R.layout.item_product_recyclerview;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        OrderListItem item=(OrderListItem) list.get(position);
        holder.getTextView(R.id.prodName).setText(item.getTitle());
        holder.getTextView(R.id.oldProdPriceView).setText(item.getContent());
        holder.getTextView(R.id.salesNums).setText(item.getStatus());
        holder.getTextView(R.id.prodPriceView).setText(item.getPrice());

        holder.getImageView(R.id.prodImageView).setImageDrawable(context.getResources().getDrawable(R.mipmap.index_img));

        holder.getConvertView().findViewById(R.id.item_order_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }
}