package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteCursor;

public class DataHelper {
	private Context context;
	private SQLiteDatabase db;
	private SQLiteStatement insertStmt;
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "AvalonAndroid.db";
	private static final String CASE_TABLE_NAME = "case";
	private static final String CASE_TABLE_SORT_BY = "id desc";
	private static final String CASE_TABLE_DROP = "DROP TABLE IF EXISTS " + CASE_TABLE_NAME;
	private static final String[] CASE_TABLE_ROWS = new String[] { "id", "uri",	"summary", "description",
		"status", "product", "component", "version", "type", "accountNumber", "reference", "notes",
		"escalated", "contactName", "origin", "owner", "internalPriority", "internalStatus", "suppliedName",
		"suppliedPhone", "suppliedEmail", "severity", "folderNumber" };

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
		"folderNumber TEXT);";

	public DataHelper (Context context) {
		this.context = context;
		DatabaseHelper dbHelper = new DatabaseHelper(this.context);
		this.db = dbHelper.getWritableDatabase();
	}

	/**
	* @param c A cursor containing the data from the select statment.  The data is defined in the 
	*/
	private Case cursorToCase (SQLiteCursor c) {
		Case c = new Case();

		return c;		
	}

	public List<Case> selectAllCases() {
		List<Case> allCases = new ArrayList();

		SQLiteCursor = this.db.query(CASE_TABLE_NAME, CASE_TABLE_ROWS, null, null, null, null, CASE_TABLE_SORT_BY);

		return allCases;
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
