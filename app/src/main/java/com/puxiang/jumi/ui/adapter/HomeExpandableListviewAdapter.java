package com.puxiang.jumi.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.puxiang.jumi.R;

import java.util.List;
import java.util.Map;

//自定义的ExpandListAdapter
public class HomeExpandableListviewAdapter extends BaseExpandableListAdapter {
	private Context context;
	List<Map<String, Object>> groups;
	List<List<Map<String, Object>>> childs;
	private boolean mIsLoadingChild;
	Handler bookHandler;
	ItemViewHolder holder;
	
	public class ItemViewHolder {
		public TextView prodName;
		public TextView prodDesc;
		public ImageView titleImg;
	}

	public HomeExpandableListviewAdapter(Context context,
										 List<Map<String, Object>> groups,
										 List<List<Map<String, Object>>> childs) {
		this.groups = groups;
		this.childs = childs;
		this.context = context;
	}


	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childs.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	// 获取二级列表的View对象
	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		final ItemViewHolder holder;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// 获取二级列表对应的布局文件, 并将其各元素设置相应的属性
			convertView = layoutInflater.inflate(R.layout.item_home_expandlistview_child, null);
			holder = new ItemViewHolder();
			this.holder = holder;
			convertView.setTag(holder);
			holder.titleImg = (ImageView) convertView.findViewById(R.id.titleImageView);
			holder.prodName = (TextView) convertView.findViewById(R.id.text_problem);
			holder.prodDesc = (TextView) convertView.findViewById(R.id.text_desc);
		} else {
			holder = (ItemViewHolder) convertView.getTag();
			resetViewHolder(holder);
		}

		holder.prodName.setText((String) childs.get(groupPosition).get(childPosition).get("titleProb"));
		holder.prodDesc.setText((String) childs.get(groupPosition).get(childPosition).get("tetleDesc"));

		return convertView;
	}
	
	
	

	@Override
	public int getChildrenCount(int groupPosition) {
		return childs.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return groups.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	// 获取一级列表View对象
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		 if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// 获取一级列表布局文件,设置相应元素属性
			convertView = layoutInflater.inflate(R.layout.item_home_expandlistview_group, null);
		 }
		final TextView title = (TextView) convertView.findViewById(R.id.titleTextView);
		final TextView more = (TextView) convertView.findViewById(R.id.textmore);

		title.setText((String) groups.get(groupPosition).get("title"));
		more.setText((String) groups.get(groupPosition).get("more"));
		
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}
	
	protected void resetViewHolder(ItemViewHolder viewHolder)
	{

	}
	

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	

	
}
