package com.puxiang.jumi.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nick on 15/10/26.
 */
public class RVHolder  extends RecyclerView.ViewHolder {


    private ViewHolder viewHolder;

    public RVHolder(View itemView) {
        super(itemView);
        viewHolder=ViewHolder.getViewHolder(itemView);
    }


    public ViewHolder getViewHolder() {
        return viewHolder;
    }

}
