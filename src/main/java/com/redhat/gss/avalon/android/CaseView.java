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

	private ListView caseDetail;
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
		Map<String, String> caseMap = CaseUtils.getMap(supportCase);
		caseList.add(caseMap);

		String[] caseFields = CaseUtils.getFieldArray();
		int[] caseKeys = CaseUtils.getIdArray();

		SimpleAdapter caseAdapter = new SimpleAdapter(this, caseList, R.layout.case_detail, caseFields, caseKeys);

		caseDetail = (ListView) findViewById(R.id.caseDetail);
		caseDetail.setAdapter(caseAdapter);

		final List<Map<String, String>> commentList = new ArrayList<Map<String, String>>();
		for (Comment comment : new CaseController().getAllComments(this, caseNumber)) {
			Map<String, String> commentMap = CommentUtils.getMap(comment);
			commentList.add(commentMap);
		}

		String[] commentFields = CommentUtils.getFieldArray();
		int[] commentKeys = CommentUtils.getIdArray();

		SimpleAdapter commentAdapter = new SimpleAdapter(this, commentList, R.layout.comment_list_item, commentFields, commentKeys);

		caseComments = (ListView) findViewById(R.id.caseComments);
		caseComments.setAdapter(commentAdapter);
	}
}
