package com.puxiang.jumi.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.puxiang.jumi.R;
import com.puxiang.jumi.bean.OrderListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by nick on 2015/10/25.
 */

public class MyOrderRecyclerAdapter extends RecyclerView.Adapter<MyOrderRecyclerAdapter.ViewHolder>{

    //当前显示的数据
    private List<OrderListItem> mNewsList = new ArrayList<OrderListItem>();

    public void setmDrawble(Drawable mDrawble) {
        if (this.mDrawble == null) {
            this.mDrawble = mDrawble;
        }
    }

    private Drawable mDrawble;
    private Context mContext;

    public List<OrderListItem> getmNewsList() {
        return mNewsList;
    }

    public MyOrderRecyclerAdapter(Context context){
        this(context,null);
    }


    public MyOrderRecyclerAdapter(Context context, List<OrderListItem> myDataset){
        this.mContext = context;
        mNewsList = myDataset != null ? myDataset : new ArrayList<OrderListItem>();
        Random random = new Random();
        int i = random.nextInt(4);
        setmDrawble(context.getResources().getDrawable(getImageId(i)));
    }

    /**
     * 添加新闻列表
     * @param news 要添加的新闻列表
     */
    public void addNews(List<OrderListItem> news){
        mNewsList.addAll(news);
        Log.i("LIXU", "adapter" + mNewsList.size());
    }

    private int getImageId(int id){
        int num = id % 4;
        switch (num){
            case 0:
                return R.mipmap.index_img;
            case 1:
                return R.mipmap.index_img;
            case 2:
                return R.mipmap.index_img;
            case 3:
                return R.mipmap.index_img;
        }
        return R.mipmap.index_img;
    }

    /**
     * 创建ViewHolder
     * @param viewGroup 父View
     * @param i 位置
     * @return 返回得到的ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order_recyclerview,
                viewGroup,false);
        TextView titleTextView = (TextView) v.findViewById(R.id.titleTextView);
        TextView dateTextView = (TextView) v.findViewById(R.id.dateTextView);
        TextView orderPrice = (TextView) v.findViewById(R.id.orderPrice);
        TextView orderStatus = (TextView) v.findViewById(R.id.orderStatus);
        ImageView titleImageView = (ImageView) v.findViewById(R.id.titleImageView);
        titleImageView.setImageDrawable(mDrawble);
        return new ViewHolder(v,titleTextView,dateTextView,titleImageView,orderPrice,orderStatus);
    }

    /**
     * 将数据绑定到ViewHolder
     * @param viewHolder    要绑定的ViewHolder
     * @param i             ViewHolder的位置
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTitleTextView.setText(mNewsList.get(i).getTitle());

        viewHolder.mDateTextView.setText(mNewsList.get(i).getDate());
        viewHolder.mOrderPrice.setText(mNewsList.get(i).getPrice());
        String status = mNewsList.get(i).getStatus();
        if (status.equals("1")){
            status = "未完成";
            viewHolder.mOrderStatus.setTextColor(mContext.getResources().getColor(R.color.awesome_orange));
        }else{
            status = "订单完成";
            viewHolder.mOrderStatus.setTextColor(mContext.getResources().getColor(R.color.secondary_text));
        }
        viewHolder.mOrderStatus.setText(status);
        viewHolder.bindData(mNewsList.get(i));
    }

    @Override
    public int getItemCount() {
        if (mNewsList != null) {
            return mNewsList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View mView;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mTitleImageView;
        private TextView mOrderPrice;
        private TextView mOrderStatus;
        private OrderListItem mOrderListItem;

        public ViewHolder(View v){
            super(v);
        }

        public ViewHolder(View v,TextView titleTextView,TextView dateTextView,ImageView imageView,TextView orderPrice,TextView orderStatus){
            this(v);
            v.setOnClickListener(this);
            mTitleTextView = titleTextView;
            mDateTextView = dateTextView;
            mTitleImageView = imageView;
            mOrderPrice = orderPrice;
            mOrderStatus = orderStatus;
            mView = v;
        }


        /**
         * 将新闻列表绑定至ViewHolder
         * @param orderListItem     新闻列表
         */
        public void bindData(OrderListItem orderListItem){
            mTitleTextView.setText(orderListItem.getTitle());

            mDateTextView.setText(orderListItem.getDate());

            mOrderPrice.setText(orderListItem.getPrice());
            //图片随机分配
//            mTitleImageView.setImageDrawable();
            mOrderListItem = orderListItem;
        }

        @Override
        public void onClick(View view) {
            Log.e("TAG","点击==========>");

        }
    }
}