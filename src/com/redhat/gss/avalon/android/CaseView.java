package com.redhat.gss.avalon.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CaseView extends Activity {

	final String tag = "CaseView: ";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.case_view);

		final Bundle extras = getIntent().getExtras();
		int caseNumber = extras.getInt("caseNumber");
		Log.v(tag, "Created and recived the case number " + caseNumber);

		setTitle("Case " + caseNumber);

		final TextView title = (TextView) findViewById(R.id.title);
		title.setText("Encrypt SSLPassword for native connectors on JBoss");

		final TextView status = (TextView) findViewById(R.id.status);
		status.setText("Waiting on Red Hat");

		final String[] comments = { "Issue Created (Severity: 2)",
				"Thanks for the reply. Yes we will wait for the 5.1.0 release." };
		final ListView commentList = (ListView) findViewById(R.id.commentList);
		commentList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, comments));
	}
}
