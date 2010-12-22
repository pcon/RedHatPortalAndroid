package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.redhat.gss.strata.model.Case;
import com.redhat.gss.strata.model.Comment;

/**
* The datahelper class used to query items from the database for caching purposes
*
* @author Patrick Connelly <patrick@deadlypenguin.com>
* @version 1.0
*/

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
	private static final String[] CASE_TABLE_COLUMNS = new String[] { "id", "uri", "summary", "description",
		"status", "product", "component", "version", "type", "accountNumber", "reference", "notes",
		"escalated", "contactName", "origin", "owner", "internalPriority", "internalStatus", "suppliedName",
		"suppliedPhone", "suppliedEmail", "severity", "folderNumber", "alternateId", "caseNumber", "closed" };

	private static final String CASE_TABLE_CREATE = 
		"CREATE TABLE " + CASE_TABLE_NAME + " (" +
		"id TEXT, " +
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
		"caseNumber TEXT PRIMARY KEY, " + 
		"closed INTEGER);";

	private static final String COMMENT_TABLE_NAME = "comments";
	private static final String COMMENT_TABLE_ORDER_BY = "";
	private static final String COMMENT_TABLE_DROP = "DROP TABLE IF EXISTS " + COMMENT_TABLE_NAME;
	private static final String[] COMMENT_TABLE_COLUMNS = new String[] { "id", "title", "body", "uri", "public", "caseNumber" };

	private static final String COMMENT_TABLE_CREATE =
		"CREATE TABLE " + COMMENT_TABLE_NAME + " (" +
		"id TEXT PRIMARY KEY, " +
		"uri TEXT, " +
		"title TEXT, " + 
		"body TEXT, " +
		"public INTEGER, " +
		"caseNumber TEXT);";

	public DataHelper (Context context) {
		this.context = context;
		DatabaseHelper dbHelper = new DatabaseHelper(this.context);
		this.db = dbHelper.getWritableDatabase();
	}

	/**
	* Transforms a cursor from the query into a Case object
	*
	* @param cursor A cursor containing the data from the select statement.
	* @return The case generated from the cursor
	*/
	private Case cursorToCase (Cursor cursor) {
		Case c = new Case();

		for (String field: CASE_TABLE_COLUMNS) {
			int index = cursor.getColumnIndex(field);
			if (index != -1) {
				c = CaseUtils.set(c, field, cursor.getString(index));
			}
		}

		return c;		
	}

	/**
	* Transforms a cursor from the query into a Comment object
	*
	* @param cursor A cursor containing the data from the select statement.
	* @return The comment generated from the cursor
	*/
	private Comment cursorToComment (Cursor cursor) {
		Comment c = new Comment();

		for (String field: COMMENT_TABLE_COLUMNS) {
			int index = cursor.getColumnIndex(field);
			if (index != -1) {
				c = CommentUtils.set(c, field, cursor.getString(index));
			}
		}

		return c;		
	}

	/**
	* Generates the SQL insert statment for a table and it's colums
	*
	* @param table The table's name
	* @param columns The column names
	* @return The insert string
	*/
	private String generateInsert (String table, String[] columns) {
		int numCols = 0;

		String insertString = "INSERT INTO " + table + "(";

		for (String field: columns) {
			if (numCols != 0) {
				insertString = insertString + ", ";
			}

			insertString = insertString + field;

			numCols++;
		}

		insertString = insertString + ") VALUES (";

		for (int i = 0; i < numCols; i++) {
			if (i != 0) {
				insertString = insertString + ", ";
			}

			insertString = insertString + "?";
		}

		insertString = insertString + ")";

		return insertString;
	}

	/**
	* Deletes all the cases in the database
	*
	* @return If the delete was successful
	*/
	public Boolean deleteAllCases() {
		try {
			this.db.delete(CASE_TABLE_NAME, null, null);
		} catch (Exception e) {
			Log.e(LOG_NAME, "Exception caught deleting all cases '" + e.toString() + "'");
			return false;
		}

		return true;
	}

	/**
	* Inserts all the cases into the database
	*
	* @param cases A list of cases to insert
	* @return If all of the inserts happend ok
	*/
	public Boolean insertAllCases(List<Case> cases) {
		Boolean overallStatus = true;
		String insertString = generateInsert(CASE_TABLE_NAME, CASE_TABLE_COLUMNS);

		Log.v(LOG_NAME, "Using '" + insertString + "' as insert string");

		for (Case c: cases) {
			try {
				SQLiteStatement insertStmt = this.db.compileStatement(insertString);
				String[] fields = CaseUtils.getArray(c, CASE_TABLE_COLUMNS);

				if (fields != null && fields.length > 0) {
					for (int i = 0; i < fields.length; i++) {
						insertStmt.bindString(i+1, fields[i]);
					}

					insertStmt.executeInsert();
				} else {
					Log.e(LOG_NAME, "No fields returned from CaseUtils.getArray()");
				}
			} catch (Exception e) {
				Log.e(LOG_NAME, "Exception caught inserting all cases '" + e.toString() + "'");
				overallStatus = false;
			}
		}

		return overallStatus;
	}


	/**
	* Selects all the cases from the database
	*
	* @return A list of all the cases ordered by CASE_TABLE_ORDER_BY
	*/
	public List<Case> selectAllCases() {
		List<Case> allCases = new ArrayList();

		Cursor cursor = this.db.query(CASE_TABLE_NAME, CASE_TABLE_COLUMNS, null, null, null, null, CASE_TABLE_ORDER_BY);
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

	/**
	* Select all cases for a given where condition
	*
	* @param whereCondition The where condition to add to the query
	* @return The cursor for the select
	*/
	private Cursor selectAllCasesWhere(String whereCondition) {
		return this.db.query(CASE_TABLE_NAME, CASE_TABLE_COLUMNS, whereCondition, null, null, null, CASE_TABLE_ORDER_BY);
	}

	/**
	* Selects a Case object for a given case number
	*
	* @param caseNumber The case number
	* @return The Case
	*/
	public Case selectCase(String caseNumber) {
		Case c = null;
		Cursor cursor = selectAllCasesWhere("CaseNumber = " + caseNumber);

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

	/**
	* Deletes all the comments in the database
	*
	* @return If the delete was successful
	*/
	public Boolean deleteAllComments() {
		try {
			this.db.delete(COMMENT_TABLE_NAME, null, null);
		} catch (Exception e) {
			Log.e(LOG_NAME, "Exception caught deleting all comments '" + e.toString() + "'");
			return false;
		}

		return true;
	}

	/**
	* Deletes all the comments in the database
	*
	* @return If the delete was successful
	*/
	public Boolean deleteAllComments(String caseNumber) {
		try {
			String whereClause = "caseNumber = " + caseNumber;
			this.db.delete(COMMENT_TABLE_NAME, whereClause, null);
		} catch (Exception e) {
			Log.e(LOG_NAME, "Exception caught deleting all comments '" + e.toString() + "'");
			return false;
		}

		return true;
	}

	/**
	* Inserts all the comments into the database
	*
	* @param comments A list of comments to insert
	* @return If all of the inserts happend ok
	*/
	public Boolean insertAllComments(List<Comment> comments) {
		Boolean overallStatus = true;
		String insertString = generateInsert(COMMENT_TABLE_NAME, COMMENT_TABLE_COLUMNS);

		for (Comment c: comments) {
			try {
				SQLiteStatement insertStmt = this.db.compileStatement(insertString);
				String[] fields = CommentUtils.getArray(c, COMMENT_TABLE_COLUMNS);

				if (fields != null && fields.length > 0) {
					for (int i = 0; i < fields.length; i++) {
						insertStmt.bindString(i+1, fields[i]);
					}

					insertStmt.executeInsert();
				} else {
					Log.e(LOG_NAME, "No fields returned from CommentUtils.getArray()");
				}
			} catch (Exception e) {
				Log.e(LOG_NAME, "Exception caught inserting all comments '" + e.toString() + "'");
				overallStatus = false;
			}
		}

		return overallStatus;
	}

	/**
	* Select all comments for a given where condition
	*
	* @param whereCondition The where condition to add to the query
	* @return The cursor for the select
	*/
	public Cursor selectAllCommentsWhere(String whereCondition) {
		return this.db.query(COMMENT_TABLE_NAME, COMMENT_TABLE_COLUMNS, whereCondition, null, null, null, COMMENT_TABLE_ORDER_BY);
	}

	/**
	* Selects all the comments for a given caseNumber
	*
	* @param caseNumber The case number
	* @return A list of comments
	*/
	public List<Comment> selectAllComments(String caseNumber) {
		List<Comment> comments = new ArrayList<Comment>();
		Cursor cursor = selectAllCommentsWhere("CaseNumber = " + caseNumber);

		if (cursor.moveToFirst()) {
			do {
				comments.add(cursorToComment(cursor));
			} while (cursor.moveToNext());
		} else {
			Log.i(LOG_NAME, "No rows returned");
		}

		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return comments;
	}

	/**
	* This is the database helper used to create the databases and upgrade their versions
	*
	* @author Patrick Connelly <patrick@deadlypenguin.com>
	* @version 1.0
	*/
	private class DatabaseHelper extends SQLiteOpenHelper {
		/**
		* The overloaded constructor to pass set the DATABASE_NAME and DATABASE_VERSION
		*
		* @param context The context that the database is being used for
		*/
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		/**
		* On create of the object, we need to create the database
		*
		* @param db The instance of the SQLiteDatabase object
		*/
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CASE_TABLE_CREATE);
			db.execSQL(COMMENT_TABLE_CREATE);
		}

		/**
		* On upgrade we drop all tables and recreate them since the tables are only being used for cache
		*
		* @param db The instance of the SQLiteDatabase object
		* @param oldVersion The old database version
		* @param newVersion The new database version
		*/
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Database", "Upgrading database, this will drop tables and recreate.");
			db.execSQL(CASE_TABLE_DROP);
			db.execSQL(COMMENT_TABLE_DROP);
			onCreate(db);
		}
	}
}
