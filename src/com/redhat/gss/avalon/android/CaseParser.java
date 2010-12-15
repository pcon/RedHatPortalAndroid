package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import com.redhat.gss.strata.model.Case;

public class CaseParser {

	public List<Case> getAllCases() {
		Case kase = new Case();

		kase.setCaseNumber("1234");
		kase.setSummary("[1] This is a sample test kase");
		kase.setDescription("[1] This is a sample description");
		kase.setSeverity("1 (Urgent)");

		Case kase2 = new Case();

		kase2.setCaseNumber("1235");
		kase2.setSummary("[2] This is a sample test kase");
		kase2.setDescription("[2] This is a sample description");
		kase2.setSeverity("2 (High)");

		Case kase3 = new Case();

		kase3.setCaseNumber("1236");
		kase3.setSummary("[3] This is a sample test kase");
		kase3.setDescription("[3] This is a sample description");
		kase3.setSeverity("3 (Medium)");

		Case kase4 = new Case();

		kase4.setCaseNumber("1237");
		kase4.setSummary("[3] This is a sample test kase");
		kase4.setDescription("[3] This is a sample description");
		kase4.setSeverity("3 (Medium)");

		List<Case> kases = new ArrayList<Case>();
		kases.add(kase);
		kases.add(kase2);
		kases.add(kase3);
		kases.add(kase4);

		return kases;
	}

}
