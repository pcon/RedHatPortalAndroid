package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.util.Log;


import com.redhat.gss.strata.model.Case;

public class CaseParser {
	private static final String LOG_NAME = "CaseParser";

	public List<Case> getAllCases() {
		List<Case> kases = new ArrayList<Case>();

		try {
			Calendar cal = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
			Case kase = new Case();

			kase.setId("0001234");
			kase.setCaseNumber("0001234");
			kase.setSummary("Out of Entitlements");
			kase.setDescription("I am unable to register a new system.\nI get an out of Entitlements error when registering");
			kase.setSeverity("1 (Urgent)");
			kase.setEscalated(false);
			kase.setClosed(false);
			kase.setCreatedBy("Test Customer");
			cal.setTime(df.parse("2007-01-09T15:21:11Z"));
			kase.setCreatedDate(cal);
			kase.setLastModifiedBy("Test Technician");
			cal.setTime(df.parse("2007-07-03T12:52:04Z"));
			kase.setLastModifiedDate(cal);

			Case kase2 = new Case();

			kase2.setId("0001235");
			kase2.setCaseNumber("0001235");
			kase2.setSummary("Error installing Satellite 5.3");
			kase2.setDescription("I get an Out of Space exception when installing Satellite 5.3");
			kase2.setSeverity("2 (High)");
			kase2.setEscalated(false);
			kase2.setClosed(false);
			kase2.setCreatedBy("Test Customer");
			cal.setTime(df.parse("2008-01-09T15:21:11Z"));
			kase2.setCreatedDate(cal);
			kase2.setLastModifiedBy("Test Technician");
			cal.setTime(df.parse("2008-07-03T12:52:04Z"));
			kase2.setLastModifiedDate(cal);

			Case kase3 = new Case();

			kase3.setId("0001236");
			kase3.setCaseNumber("0001236");
			kase3.setSummary("My box got a kernel panic");
			kase3.setDescription("My box hung, please help");
			kase3.setSeverity("3 (Medium)");
			kase3.setEscalated(false);
			kase3.setClosed(false);
			kase3.setCreatedBy("Test Customer");
			cal.setTime(df.parse("2009-01-09T15:21:11Z"));
			kase3.setCreatedDate(cal);
			kase3.setLastModifiedBy("Test Technician");
			cal.setTime(df.parse("2009-07-03T12:52:04Z"));
			kase3.setLastModifiedDate(cal);

			Case kase4 = new Case();

			kase4.setId("0001237");
			kase4.setCaseNumber("0001237");
			kase4.setSummary("I need help setting up multipath");
			kase4.setDescription("Multipath is broken.  Please help me set it up");
			kase4.setSeverity("3 (Medium)");
			kase4.setEscalated(false);
			kase4.setClosed(false);
			kase4.setCreatedBy("Test Customer");
			cal.setTime(df.parse("2010-01-09T15:21:11Z"));
			kase4.setCreatedDate(cal);
			kase4.setLastModifiedBy("Test Technician");
			cal.setTime(df.parse("2010-07-03T12:52:04Z"));
			kase4.setLastModifiedDate(cal);

			kases.add(kase);
			kases.add(kase2);
			kases.add(kase3);
			kases.add(kase4);
				
		} catch (Exception e) {
			Log.e(LOG_NAME, "Got exception " + e.toString());
		}

		return kases;
	}
}
