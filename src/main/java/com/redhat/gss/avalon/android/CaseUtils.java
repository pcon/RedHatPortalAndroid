package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.util.Log;

import com.redhat.gss.strata.model.Case;

public class CaseUtils {
	private static final String LOG_NAME = "CaseUtils";
	
	/** 
	 * Gets a map of case fields to their Id
	 *
	 * @return The {@link Map } of data
	 */
	public static Map<String, Integer> getFieldToIdMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", R.id.id);
		map.put("uri", R.id.uri);
		map.put("summary", R.id.summary);
		map.put("description", R.id.description);
		map.put("status", R.id.status);
		map.put("product", R.id.product);
		map.put("component", R.id.component);
		map.put("version", R.id.version);
		map.put("type", R.id.type);
		map.put("accountNumber", R.id.accountNumber);
		map.put("reference", R.id.reference);
		map.put("notes", R.id.notes);
		map.put("contactName", R.id.contactName);
		map.put("origin", R.id.origin);
		map.put("owner", R.id.owner);
		map.put("internalPriority", R.id.internalPriority);
		map.put("internalStatus", R.id.internalStatus);
		map.put("suppliedName", R.id.suppliedName);
		map.put("suppliedPhone", R.id.suppliedPhone);
		map.put("suppliedEmail", R.id.suppliedEmail);
		map.put("severity", R.id.severity);
		map.put("folderNumber", R.id.folderNumber);
		map.put("alternateId", R.id.alternateId);
		map.put("caseNumber", R.id.caseNumber);
		map.put("createdBy", R.id.createdBy);
		map.put("lastModifiedBy", R.id.lastModifiedBy);
		map.put("escalated", R.id.escalated);
		map.put("closed", R.id.closed);
		map.put("createdDate", R.id.createdDate);
		map.put("lastModifiedDate", R.id.lastModifiedDate);
		return map;
	}

	/**
	 * Gets an array of field names
	 *
	 * @return The field names
	 */
	public static String[] getFieldArray() {
		Map<String, Integer> map = getFieldToIdMap();
		return map.keySet().toArray(new String[0]);
	}

	/**
	 * Gets an array of Ids
	 *
	 * @return The ids
	 */
	public static int[] getIdArray() {
		Map<String, Integer> map = getFieldToIdMap();
		int[] array = new int[map.size()];
		Integer[] intArray = map.values().toArray(new Integer[0]);

		for (int i=0; i < map.size(); i++) {
			array[i] = intArray[i].intValue();
		}

		return array;
	}

	/**
	 * Sets the specified field on a case
	 *
	 * @param c The case to populate
	 * @param field The field to populate
	 * @param value The data to put in the field
	 * @return The case
	 */
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
		} else if (field.equals("createdBy")) {
			c.setCreatedBy((String)(value));
		} else if (field.equals("createdDate")) {
			try {
				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
				cal.setTime(df.parse((String)(value)));
				c.setCreatedDate(cal);
			} catch (Exception e) {
				Log.e(LOG_NAME, "Error parsing date " + e.toString());
			}
		} else if (field.equals("lastModifiedBy")) {
			c.setLastModifiedBy((String)(value));
		} else if (field.equals("lastModifiedDate")) {
			try {
				Calendar cal = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
				cal.setTime(df.parse((String)(value)));
				c.setLastModifiedDate(cal);
			} catch (Exception e) {
				Log.e(LOG_NAME, "Error parsing date " + e.toString());
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
			} else if (field.equals("createdBy")) {
				dataSet.add(GenericUtils.sqlNull(c.getCreatedBy()));
			} else if (field.equals("createdDate")) {
				Calendar cal = c.getCreatedDate();
				if (cal == null) {
					dataSet.add(GenericUtils.sqlNull(null));
				} else {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
					dataSet.add(GenericUtils.sqlNull(df.format(cal.getTime())));
				}
			} else if (field.equals("lastModifiedBy")) {
				dataSet.add(GenericUtils.sqlNull(c.getLastModifiedBy()));
			} else if (field.equals("lastModifiedDate")) {
				Calendar cal = c.getLastModifiedDate();
				if (cal == null) {
					dataSet.add(GenericUtils.sqlNull(null));
				} else {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
					dataSet.add(GenericUtils.sqlNull(df.format(cal.getTime())));
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

	/**
	* Returns an map of keys to their data value
	*
	* @param c The case to use
	* @return An map of the data
	*/
	public static Map<String, String> getMap(Case c) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", c.getId());
		map.put("uri", c.getUri());
		map.put("summary", c.getSummary());
		map.put("description", c.getDescription());
		map.put("status", c.getStatus());
		map.put("product", c.getProduct());
		map.put("component", c.getComponent());
		map.put("version", c.getVersion());
		map.put("type", c.getType());
		map.put("accountNumber", c.getAccountNumber());
		map.put("reference", c.getReference());
		map.put("notes", c.getNotes());
		map.put("contactName", c.getContactName());
		map.put("origin", c.getOrigin());
		map.put("owner", c.getOwner());
		map.put("internalPriority", c.getInternalPriority());
		map.put("internalStatus", c.getInternalStatus());
		map.put("suppliedName", c.getSuppliedName());
		map.put("suppliedPhone", c.getSuppliedPhone());
		map.put("suppliedEmail", c.getSuppliedEmail());
		map.put("severity", c.getSeverity());
		map.put("folderNumber", c.getFolderNumber());
		map.put("alternateId", c.getAlternateId());
		map.put("caseNumber", c.getCaseNumber());
		map.put("createdBy", c.getCreatedBy());
		map.put("lastModifiedBy", c.getLastModifiedBy());

		if (c.isEscalated()) {
			map.put("escalated", "1");
		} else {
			map.put("escalated", "0");
		}
		if (c.isClosed()) {
			map.put("closed", "1");
		} else {
			map.put("closed", "0");
		}

		Calendar createdCal = c.getCreatedDate();
		if (createdCal == null) {
			map.put("createdDate", null);
		} else {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			map.put("createdDate", df.format(createdCal.getTime()));
		}

		Calendar modifiedCal = c.getLastModifiedDate();
		if (modifiedCal == null) {
			map.put("lastModifiedDate", null);
		} else {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			map.put("lastModifiedDate", df.format(modifiedCal.getTime()));
		}

		return map;
	}
}
