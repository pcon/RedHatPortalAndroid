package com.redhat.gss.avalon.android;

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
			c.setEscalated((Boolean)(value)); 
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
			c.setClosed((Boolean)(value)); 
		} else {
			Log.e(LOG_NAME, "Unknown field '"+field+"'");
		}

		return c;
	}
}
