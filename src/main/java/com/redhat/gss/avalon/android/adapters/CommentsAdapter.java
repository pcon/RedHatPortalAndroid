package com.redhat.gss.avalon.android.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.redhat.gss.avalon.android.R;
import com.redhat.gss.strata.model.Comment;

public class CommentsAdapter extends BaseAdapter {
	private Context context;
	private List<Comment> comments;

	public CommentsAdapter(Context context, List<Comment> comments) {
		this.context = context;
		this.comments = comments;
	}

	public int getCount() {
		return comments.size();
	}

	public Object getItem(int index) {
		return comments.get(index);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup viewGroup) {

		Comment entry = comments.get(position);

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.comments_layout, null);
		}

		TextView tvComment = (TextView) convertView.findViewById(R.id.comment);
		tvComment.setText("Foobar");

		return convertView;

	}
}
