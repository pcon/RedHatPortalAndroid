package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.redhat.gss.strata.model.Case;

public class CaseUtils {
	private static final String LOG_NAME = "CaseUtils";

	public static Case set(Case c, String field, Object value) {
		if (field.equals("id")) {
			c.setId((String)(value)); 
		} else if (field.equals("uri")) {
			c.setUri((String)(value)); 
		} else if (field.equals("summary")) {
			c.setSummary((String)(value)); 
		} else if (field.equals("description")) {
			c.setDescription((String)(value)); 
		} else if (field.equals("status")) {
			c.setStatus((String)(value));
		} else if (field.equals("product")) {
			c.setProduct((String)(value)); 
		} else if (field.equals("component")) {
			c.setComponent((String)(value)); 
		} else if (field.equals("version")) {
			c.setVersion((String)(value)); 
		} else if (field.equals("type")) {
			c.setType((String)(value)); 
		} else if (field.equals("accountNumber")) {
			c.setAccountNumber((String)(value)); 
		} else if (field.equals("reference")) {
			c.setReference((String)(value)); 
		} else if (field.equals("notes")) {
			c.setNotes((String)(value)); 
		} else if (field.equals("escalated")) {
			String v = (String)(value);
			if (v.equals("1") || v.toLowerCase().equals("true") || v.toLowerCase().equals("t")) {
				c.setEscalated(true);
			} else {
				c.setEscalated(false);
			}
		} else if (field.equals("contactName")) {
			c.setContactName((String)(value)); 
		} else if (field.equals("origin")) {
			c.setOrigin((String)(value)); 
		} else if (field.equals("owner")) {
			c.setOwner((String)(value)); 
		} else if (field.equals("internalPriority")) {
			c.setInternalPriority((String)(value)); 
		} else if (field.equals("internalStatus")) {
			c.setInternalStatus((String)(value)); 
		} else if (field.equals("suppliedName")) {
			c.setSuppliedName((String)(value)); 
		} else if (field.equals("suppliedPhone")) {
			c.setSuppliedPhone((String)(value)); 
		} else if (field.equals("suppliedEmail")) {
			c.setSuppliedEmail((String)(value)); 
		} else if (field.equals("severity")) {
			c.setSeverity((String)(value)); 
		} else if (field.equals("folderNumber")) {
			c.setFolderNumber((String)(value)); 
		} else if (field.equals("alternateId")) {
			c.setAlternateId((String)(value)); 
		} else if (field.equals("caseNumber")) {
			c.setCaseNumber((String)(value)); 
		} else if (field.equals("closed")) {
			String v = (String)(value);
			if (v.equals("1") || v.toLowerCase().equals("true") || v.toLowerCase().equals("t")) {
				c.setClosed(true); 
			} else {
				c.setClosed(false);
			}
		} else {
			Log.e(LOG_NAME, "Unknown field '"+field+"'");
		}

		return c;
	}

	/**
	* Returns an array Strings in the order specified
	*
	* @param c The case to use
	* @param fields The fields in the order to return
	* @return An array of the data
	*/
	public static String[] getArray(Case c, String[] fields) {
		List<String> dataSet = new ArrayList<String>();

		for (String field: fields) {
			Log.d(LOG_NAME, "Got field '" + field + "'");
			if (field.equals("id")) {
				dataSet.add(GenericUtils.sqlNull(c.getId())); 
			} else if (field.equals("uri")) {
				dataSet.add(GenericUtils.sqlNull(c.getUri())); 
			} else if (field.equals("summary")) {
				Log.d(LOG_NAME, "Adding '" + c.getSummary() + "' to dataSet");
				dataSet.add(GenericUtils.sqlNull(c.getSummary())); 
			} else if (field.equals("description")) {
				dataSet.add(GenericUtils.sqlNull(c.getDescription())); 
			} else if (field.equals("status")) {
				dataSet.add(GenericUtils.sqlNull(c.getStatus()));
			} else if (field.equals("product")) {
				dataSet.add(GenericUtils.sqlNull(c.getProduct())); 
			} else if (field.equals("component")) {
				dataSet.add(GenericUtils.sqlNull(c.getComponent())); 
			} else if (field.equals("version")) {
				dataSet.add(GenericUtils.sqlNull(c.getVersion())); 
			} else if (field.equals("type")) {
				dataSet.add(GenericUtils.sqlNull(c.getType())); 
			} else if (field.equals("accountNumber")) {
				dataSet.add(GenericUtils.sqlNull(c.getAccountNumber())); 
			} else if (field.equals("reference")) {
				dataSet.add(GenericUtils.sqlNull(c.getReference())); 
			} else if (field.equals("notes")) {
				dataSet.add(GenericUtils.sqlNull(c.getNotes())); 
			} else if (field.equals("escalated")) {
				if (c.isEscalated()) {
					dataSet.add("1");
				} else {
					dataSet.add("0");
				}
			} else if (field.equals("contactName")) {
				dataSet.add(GenericUtils.sqlNull(c.getContactName())); 
			} else if (field.equals("origin")) {
				dataSet.add(GenericUtils.sqlNull(c.getOrigin())); 
			} else if (field.equals("owner")) {
				dataSet.add(GenericUtils.sqlNull(c.getOwner())); 
			} else if (field.equals("internalPriority")) {
				dataSet.add(GenericUtils.sqlNull(c.getInternalPriority())); 
			} else if (field.equals("internalStatus")) {
				dataSet.add(GenericUtils.sqlNull(c.getInternalStatus())); 
			} else if (field.equals("suppliedName")) {
				dataSet.add(GenericUtils.sqlNull(c.getSuppliedName())); 
			} else if (field.equals("suppliedPhone")) {
				dataSet.add(GenericUtils.sqlNull(c.getSuppliedPhone())); 
			} else if (field.equals("suppliedEmail")) {
				dataSet.add(GenericUtils.sqlNull(c.getSuppliedEmail())); 
			} else if (field.equals("severity")) {
				dataSet.add(GenericUtils.sqlNull(c.getSeverity())); 
			} else if (field.equals("folderNumber")) {
				dataSet.add(GenericUtils.sqlNull(c.getFolderNumber())); 
			} else if (field.equals("alternateId")) {
				dataSet.add(GenericUtils.sqlNull(c.getAlternateId())); 
			} else if (field.equals("caseNumber")) {
				dataSet.add(GenericUtils.sqlNull(c.getCaseNumber())); 
			} else if (field.equals("closed")) {
				if (c.isClosed()) {
					dataSet.add("1");
				} else {
					dataSet.add("0");
				}
			} else {
				Log.e(LOG_NAME, "Unknown field '"+field+"'");
				dataSet.add("null");
			}
		}

		if (dataSet == null || dataSet.size() == 0) {
			Log.e(LOG_NAME, "dataSet is null or size == 0");
			return null;
		}

		Log.d(LOG_NAME, "dataSet.size() = " + dataSet.size());

		return dataSet.toArray(new String[0]);
	}
}
