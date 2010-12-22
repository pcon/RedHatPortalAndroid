package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.redhat.gss.strata.model.Comment;

public class CommentUtils {
	private static final String LOG_NAME = "CommentUtils";

	/**
	* Sets the specified field on a comment
	*
	* @param c The comment to populate
	* @param field The field to populate
	* @param value The data to put in the field
	* @return The comment
	*/
	public static Comment set(Comment c, String field, Object value) {
		if (field.equals("id")) {
			c.setId((String)(value)); 
		} else if (field.equals("title")) {
			c.setTitle((String)(value)); 
		} else if (field.equals("body")) {
			c.setText((String)(value)); 
		} else if (field.equals("public")) {
			if (value.equals("1") || value.equals("true") || value.equals("t")) {
				c.setPublic(true); 
			} else {
				c.setPublic(false);
			}
		} else if (field.equals("uri")) {
			c.setUri((String)(value)); 
		} else if (field.equals("caseNumber")) {
			c.setCaseNumber((String)(value)); 
		} else {
			Log.e(LOG_NAME, "Unknown field '"+field+"'");
		}

		return c;
	}

	/**
	* Returns an array Strings in the order specified
	*
	* @param c The comment to use
	* @param fields The fields in the order to return
	* @return An array of the data
	*/
	public static String[] getArray(Comment c, String[] fields) {
		List<String> dataSet = new ArrayList<String>();

		for (String field: fields) {
			if (field.equals("id")) {
				dataSet.add(GenericUtils.sqlNull(c.getId()));
			} else if (field.equals("title")) {
				dataSet.add(GenericUtils.sqlNull(c.getTitle()));
			} else if (field.equals("body")) {
				dataSet.add(GenericUtils.sqlNull(c.getText()));
			} else if (field.equals("public")) {
				if (c.isPublic()) {
					dataSet.add("1");
				} else {
					dataSet.add("0");
				}
			} else if (field.equals("uri")) {
				dataSet.add(GenericUtils.sqlNull(c.getUri()));
			} else if (field.equals("caseNumber")) {
				dataSet.add(GenericUtils.sqlNull(c.getCaseNumber()));
			} else {
				Log.e(LOG_NAME, "Unknown field '"+field+"'");
				dataSet.add(null);
			}
		}

		if (dataSet == null || dataSet.size() == 0) {
			return null;
		}

		return dataSet.toArray(new String[0]);
	}
}
