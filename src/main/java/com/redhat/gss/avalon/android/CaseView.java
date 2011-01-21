package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.redhat.gss.strata.model.Case;
import com.redhat.gss.strata.model.Comment;

public class CaseView extends Activity {

	private TableLayout caseDetail;
	private ListView caseDescription;
	private ListView caseComments;
	final String tag = "CaseView: ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.case_view);

		final Bundle extras = getIntent().getExtras();
		String caseNumber = extras.getString("caseNumber");
		Log.v(tag, "Created and recived the case number " + caseNumber);

		setTitle("Case " + caseNumber);

		final Case supportCase = new CaseController().getCase(this, caseNumber);
		final List<Map<String, String>> caseList = new ArrayList<Map<String, String>>();

		final TextView summary = (TextView) findViewById(R.id.summary);
		summary.setText(supportCase.getSummary());

		final TextView caseNumberView = (TextView) findViewById(R.id.caseNumber);
		caseNumberView.setText(supportCase.getCaseNumber());

		final TextView status = (TextView) findViewById(R.id.status);
		status.setText(supportCase.getStatus());

		final TextView severity = (TextView) findViewById(R.id.severity);
		severity.setText(supportCase.getSeverity());

		final TextView type = (TextView) findViewById(R.id.type);
		type.setText(supportCase.getType());

		final List<Map<String, String>> commentMapList = new ArrayList<Map<String, String>>();
		List<Comment> commentList = new CaseController().getAllComments(this, caseNumber);

		Comment initialComment = new Comment();
		initialComment.setText(supportCase.getDescription());
		initialComment.setPublic(true);
		commentList.add(initialComment);

		for (Comment comment : commentList) {
			Map<String, String> commentMap = CommentUtils.getMap(comment);
			commentMapList.add(commentMap);
		}

		String[] commentFields = CommentUtils.getFieldArray();
		int[] commentKeys = CommentUtils.getIdArray();

		SimpleAdapter commentAdapter = new SimpleAdapter(this, commentMapList, R.layout.comment_list_item, commentFields, commentKeys);

		caseComments = (ListView) findViewById(R.id.caseComments);
		caseComments.setAdapter(commentAdapter);
	}
}
