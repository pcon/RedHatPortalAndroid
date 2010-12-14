package com.redhat.gss.avalon.android.adapters;

import java.util.List;

import com.redhat.gss.strata.model.Comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		return null;
	}
}
