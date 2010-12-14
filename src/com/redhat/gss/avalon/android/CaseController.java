package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import com.redhat.gss.strata.model.Case;
import com.redhat.gss.strata.model.Comment;

public class CaseController {
	public Case getCase(String caseNumber) {
		Case kase = new Case();

		kase.setCaseNumber("1234");
		kase.setSummary("[1] This is a sample test kase");
		kase.setDescription("[1] This is a sample description");
		kase.setSeverity("1 (Urgent)");
		kase.setStatus("Status goes here");
		return kase;
	}

	public List<Comment> getAllComments(String caseNumber) {
		final List<Comment> comments = new ArrayList<Comment>();

		Comment comment = new Comment();
		comment.setTitle("Comment Title");
		comment.setText("Issue Created (Severity: 2)");
		comments.add(comment);

		comment = new Comment();
		comment.setTitle("Comment Title");
		comment.setText("Thanks for the reply. Yes we will wait for the 5.1.0 release.");
		comments.add(comment);

		return comments;
	}

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

		List<Case> kases = new ArrayList<Case>();
		kases.add(kase);
		kases.add(kase2);
		kases.add(kase3);

		return kases;
	}

	public List<Comment> getComments(String caseNumber) {
		Comment com = new Comment();
		com.setCaseNumber("1234");
		com.setText("[1] Comment");

		Comment com2 = new Comment();
		com2.setCaseNumber("1234");
		com2.setText("[2] Comment");

		Comment com3 = new Comment();
		com3.setCaseNumber("1234");
		com3.setText("[3] Comment");

		List<Comment> comments = new ArrayList<Comment>();

		comments.add(com);
		comments.add(com2);
		comments.add(com3);

		return comments;
	}
}
