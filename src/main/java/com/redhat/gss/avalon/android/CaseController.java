package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.redhat.gss.strata.model.Case;
import com.redhat.gss.strata.model.Comment;

/**
 * Provides access to domain objects related to support cases.
 * 
 * @author Patrick Connelly
 * 
 */
public class CaseController {

	public Case getCase(Context context, String caseNumber) {
		DataHelper helper = new DataHelper(context);

		Case kase = helper.selectCase(caseNumber);

		if (kase == null) {
			// Just a place holder
			CaseParser cp = new CaseParser();
			List<Case> caseList = cp.getAllCases();
			kase = caseList.get(0);
		}

		return kase;
	}

	public List<Comment> getAllComments(Context context, String caseNumber) {
		DataHelper helper = new DataHelper(context);
		List<Comment> commentList = helper.selectAllComments(caseNumber);

		if (commentList.isEmpty()) {
			CommentParser cp = new CommentParser();
			commentList = cp.getAllComments(caseNumber);
			helper.insertAllComments(commentList);
		}

		return commentList;
	}

	public void refreshCommentCache(Context context, String caseNumber) {
		DataHelper helper = new DataHelper(context);
		helper.deleteAllComments(caseNumber);

		CommentParser cp = new CommentParser();
		List<Comment> commentList = cp.getAllComments(caseNumber);
		helper.insertAllComments(commentList);
	}

	public void refreshCaseCache(Context context) {
		DataHelper helper = new DataHelper(context);
		helper.deleteAllCases();

		CaseParser cp = new CaseParser();
		List<Case> caseList = cp.getAllCases();
		helper.insertAllCases(caseList);
	}

	public List<Case> getAllCases(Context context) {
		DataHelper helper = new DataHelper(context);
		List<Case> caseList = helper.selectAllCases();

		if (caseList.isEmpty()) {
			CaseParser cp = new CaseParser();
			caseList = cp.getAllCases();
			helper.insertAllCases(caseList);
		}

		return caseList;
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
