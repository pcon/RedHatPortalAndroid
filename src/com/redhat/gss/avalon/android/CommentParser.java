package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import com.redhat.gss.strata.model.Comment;

public class CommentParser {
	public List<Comment> getAllComments(String caseNumber) {
		Comment c = new Comment();
		c.setId(caseNumber + "-1");
		c.setTitle("Comment Title [1] [" + caseNumber + "]");
		c.setText("Comment body comment body comment body\n Next line goes here\n" + caseNumber);
		c.setPublic(true);
		c.setCaseNumber(caseNumber);

		Comment c2 = new Comment();
		c2.setId(caseNumber + "-2");
		c2.setTitle("Comment Title [2] [" + caseNumber + "]");
		c2.setText("Comment body comment body comment body\n Next line goes here\n" + caseNumber);
		c2.setPublic(true);
		c2.setCaseNumber(caseNumber);

		Comment c3 = new Comment();
		c3.setId(caseNumber + "-3");
		c3.setTitle("Comment Title [3] [" + caseNumber + "]");
		c3.setText("Comment body comment body comment body\n Next line goes here\n" + caseNumber);
		c3.setPublic(true);
		c3.setCaseNumber(caseNumber);


		List<Comment> comments = new ArrayList<Comment>();
		comments.add(c);
		comments.add(c2);
		comments.add(c3);
			
		return comments;
	}
}
