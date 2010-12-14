package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.redhat.gss.strata.model.Case;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ShowHome extends Activity {

	private ListView mainList;
	private final String TAG = "StrataApp";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final CaseController cc = new CaseController();
		final List<Case> caseList = cc.getAllCases();

		final List<Map<String, ?>> caseSummary = new ArrayList<Map<String, ?>>();
		for (Case supportCase : caseList) {
			final Map<String, Object> map = new HashMap<String, Object>();
			map.put("caseNumber", supportCase.getCaseNumber());
			map.put("caseTitle", supportCase.getDescription());
			caseSummary.add(map);
		}

		mainList = (ListView) findViewById(R.id.mainList);
		mainList.setAdapter(new SimpleAdapter(this, caseSummary, android.R.layout.simple_list_item_2, new String[] {
				"caseNumber", "caseTitle" }, new int[] { android.R.id.text1, android.R.id.text2 }));

		mainList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				int caseNum = Integer.parseInt(caseSummary.get(position).get("caseNumber").toString());
				Log.v(TAG, "you picked: " + caseNum);
				launchCaseView(caseNum);
			}
		});

	}

	protected void launchCaseView(int caseNum) {
		Intent i = new Intent(getApplicationContext(), CaseView.class);
		i.putExtra("caseNumber", caseNum);
		startActivityForResult(i, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			aboutDialog();
		case R.id.sort:
			sortDialog();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void sortDialog() {
		final CharSequence[] items = { "Case Number", "Creation Date", "Foo" };
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Sort case list by");
		builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Toast.makeText(getApplicationContext(), items[item],
				// Toast.LENGTH_SHORT).show();
			}
		});
		builder.setPositiveButton(R.string.okay, null);
		builder.setNegativeButton("Cancel", null);
		AlertDialog alert = builder.create();
		alert.show();
	}

	private void aboutDialog() {
		android.app.AlertDialog.Builder dialog = new AlertDialog.Builder(ShowHome.this);
		dialog.setTitle(R.string.about_title);
		dialog.setMessage(R.string.about_message);
		dialog.setPositiveButton(R.string.okay, null);
		dialog.show();
	}
}