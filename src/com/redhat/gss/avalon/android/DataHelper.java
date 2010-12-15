package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.redhat.gss.strata.model.Case;

public class DataHelper {
	private Context context;
	private SQLiteDatabase db;
	private SQLiteStatement insertStmt;
	
	private static final String LOG_NAME = "DataHelper";

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "AvalonAndroid.db";
	private static final String CASE_TABLE_NAME = "supportCases";
	private static final String CASE_TABLE_ORDER_BY = "id desc";
	private static final String CASE_TABLE_DROP = "DROP TABLE IF EXISTS " + CASE_TABLE_NAME;
	private static final String[] CASE_TABLE_ROWS = new String[] { "id", "uri", "summary", "description",
		"status", "product", "component", "version", "type", "accountNumber", "reference", "notes",
		"escalated", "contactName", "origin", "owner", "internalPriority", "internalStatus", "suppliedName",
		"suppliedPhone", "suppliedEmail", "severity", "folderNumber", "alternateId", "caseNumber", "closed" };

	private static final String CASE_TABLE_CREATE = 
		"CREATE TABLE " + CASE_TABLE_NAME + " (" +
		"id TEXT PRIMARY KEY, " +
		"uri TEXT, " +
		"summary TEXT, " +
		"description TEXT, " +
		"status TEXT, " +
		"product TEXT, " +
		"component TEXT, " +
		"version TEXT, " +
		"type TEXT, " +
		"accountNumber TEXT, " +
		"reference TEXT, " +
		"notes TEXT, " +
		"escalated INTEGER, " +
		"contactName TEXT, " +
		"origin TEXT, " +
		"owner TEXT, " +
		"internalPriority TEXT, " +
		"internalStatus TEXT, " +
		"suppliedName TEXT, " +
		"suppliedPhone TEXT, " +
		"suppliedEmail TEXT, " +
		"severity TEXT, " +
		"folderNumber TEXT, " +
		"alternateId TEXT, " +
		"caseNumber TEXT, " + 
		"closed INTEGER);";

	public DataHelper (Context context) {
		this.context = context;
		DatabaseHelper dbHelper = new DatabaseHelper(this.context);
		this.db = dbHelper.getWritableDatabase();
	}

	/**
	* @param c A cursor containing the data from the select statment.  The data is defined in the 
	*/
	private Case cursorToCase (Cursor cursor) {
		Case c = new Case();

		for (String field: CASE_TABLE_ROWS) {
			int index = cursor.getColumnIndex(field);
			if (index != -1) {
				c = CaseUtils.set(c, field, cursor.getString(index));
			}
		}

		return c;		
	}

	public List<Case> selectAllCases() {
		List<Case> allCases = new ArrayList();

		Cursor cursor = this.db.query(CASE_TABLE_NAME, CASE_TABLE_ROWS, null, null, null, null, CASE_TABLE_ORDER_BY);
		if (cursor.moveToFirst()) {
			Log.v(LOG_NAME, "Returned " + cursor.getCount() + " rows");
			do {
				allCases.add(cursorToCase(cursor));
			} while (cursor.moveToNext());
		} else {
			Log.i(LOG_NAME, "No rows returned");
		}

		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return allCases;
	}

	public Case selectCase(String caseNumber) {
		Case c = null;

		Cursor cursor = this.db.query(CASE_TABLE_NAME, CASE_TABLE_ROWS, "CaseNumber = " + caseNumber, null, null, null, CASE_TABLE_ORDER_BY, "1");
		if (cursor.moveToFirst()) {
			c = cursorToCase(cursor);
		} else {
			Log.i(LOG_NAME, "No rows returned");
		}

		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return c;
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CASE_TABLE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Database", "Upgrading database, this will drop tables and recreate.");
			db.execSQL(CASE_TABLE_DROP);
			onCreate(db);
		}
	}
}
