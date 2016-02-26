package com.puxiang.jumi.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Author:  nick
 * Email:   nickdevp@gmail.com
 * Date:    16/2/1 15:08.
 * Description:
 */
abstract class PullToRefreshBaseListFragment<T extends PullToRefreshBase<? extends AbsListView>> extends ListFragment {

    private T mPullToRefreshListView;

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = super.onCreateView(inflater, container, savedInstanceState);

        ListView lv = (ListView) layout.findViewById(android.R.id.list);
        ViewGroup parent = (ViewGroup) lv.getParent();

        // Remove ListView and add PullToRefreshListView in its place
        int lvIndex = parent.indexOfChild(lv);
        parent.removeViewAt(lvIndex);
        mPullToRefreshListView = onCreatePullToRefreshListView(inflater, savedInstanceState);
        parent.addView(mPullToRefreshListView, lvIndex, lv.getLayoutParams());

        return layout;
    }

    /**
     * @return The {@link PullToRefreshBase} attached to this ListFragment.
     */
    public final T getPullToRefreshListView() {
        return mPullToRefreshListView;
    }

    /**
     * Returns the {@link PullToRefreshBase} which will replace the ListView
     * created from ListFragment. You should override this method if you wish to
     * customise the {@link PullToRefreshBase} from the default.
     *
     * @param inflater - LayoutInflater which can be used to inflate from XML.
     * @param savedInstanceState - Bundle passed through from
     *            {@link ListFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)
     *            onCreateView(...)}
     * @return The {@link PullToRefreshBase} which will replace the ListView.
     */
    protected abstract T onCreatePullToRefreshListView(LayoutInflater inflater, Bundle savedInstanceState);

}
