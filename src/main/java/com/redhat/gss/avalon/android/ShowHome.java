package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.redhat.gss.strata.model.Case;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
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
import android.widget.TableLayout;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ShowHome extends Activity {

	private ListView mainList;
	private NotificationManager nManager;
	private final String TAG = "StrataApp";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nManager.cancel(R.string.app_name);

		final CaseController cc = new CaseController();
		final List<Case> caseList = cc.getAllCases(this);

		final List<Map<String, String>> caseSummary = new ArrayList<Map<String, String>>();
		for (Case supportCase : caseList) {
			Map<String, String> map = CaseUtils.getMap(supportCase);

			String cDate = this.getString(R.string.created) + " " + map.get("createdDate");
			map.put("createdDate", cDate);

			String mDate = this.getString(R.string.updated) + " " + map.get("lastModifiedDate");
			map.put("lastModifiedDate", mDate);

			caseSummary.add(map);
		}

		//String [] fields = { "caseNumber", "summary", "status", "lastModifiedDate" };
		//int [] keys = { R.id.caseNumber, R.id.summary, R.id.status, R.id.lastModifiedDate };

		String [] fields = CaseUtils.getFieldArray();
		int[] keys = CaseUtils.getIdArray();

		SimpleAdapter adapter = new SimpleAdapter(this, caseSummary, R.layout.case_list_item, fields, keys);

		mainList = (ListView) findViewById(R.id.mainList);
		mainList.setAdapter(adapter);

		mainList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String caseNum = caseSummary.get(position).get("caseNumber").toString();
				Log.v(TAG, "you picked: " + caseNum);
				launchCaseView(caseNum);
			}
		});

	}

	protected void launchCaseView(String caseNum) {
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
			return true;
		case R.id.sort:
			sortDialog();
			return true;
		case R.id.setup:
			showSetup();
			return true;
		case R.id.refresh:
			CaseController cc = new CaseController();
			cc.refreshCaseCache(this);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showSetup() {
		Intent i = new Intent(getApplicationContext(), Preferences.class);
		startActivity(i);
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
