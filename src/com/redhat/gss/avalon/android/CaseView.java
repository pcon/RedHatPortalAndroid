package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.redhat.gss.strata.model.Case;
import com.redhat.gss.strata.model.Comment;

public class CaseView extends Activity {

	final String tag = "CaseView: ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.case_view);

		final Bundle extras = getIntent().getExtras();
		String caseNumber = extras.getString("caseNumber");
		Log.v(tag, "Created and recived the case number " + caseNumber);

		setTitle("Case " + caseNumber);

		final Case supportCase = new CaseController().getCase(caseNumber);

		final TextView title = (TextView) findViewById(R.id.title);
		title.setText(supportCase.getDescription());

		final TextView status = (TextView) findViewById(R.id.status);
		status.setText(supportCase.getStatus());

		final List<String> comments = new ArrayList<String>();
		for (Comment comment : new CaseController().getAllComments(caseNumber)) {
			comments.add(comment.getText());
		}

		final ListView commentList = (ListView) findViewById(R.id.commentList);
		commentList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comments));
	}
}
