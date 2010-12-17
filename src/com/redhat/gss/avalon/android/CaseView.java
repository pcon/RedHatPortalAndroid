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

		final Case supportCase = new CaseController().getCase(this, caseNumber);

		final TextView title = (TextView) findViewById(R.id.title);
		title.setText(supportCase.getDescription());

		final TextView status = (TextView) findViewById(R.id.status);
		status.setText(supportCase.getStatus());

		final TextView owner = (TextView) findViewById(R.id.owner);
		owner.setText(supportCase.getOwner());

		final TextView severity = (TextView) findViewById(R.id.severity);
		severity.setText(supportCase.getSeverity());

		final List<String> comments = new ArrayList<String>();
		for (Comment comment : new CaseController().getAllComments(caseNumber)) {
			comments.add(comment.getText());
		}

		Collections.reverse(comments);

		final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, comments);
		// aa.getView(position, convertView, parent);

		final ListView commentList = (ListView) findViewById(R.id.commentList);
		commentList.setAdapter(aa);
	}
}
