package com.redhat.gss.avalon.android;

import java.util.ArrayList;
import java.util.List;

import com.redhat.gss.strata.model.Comment;

public class CommentParser {
	public List<Comment> getAllComments(String caseNumber) {
		Comment c = new Comment();
		c.setId(caseNumber + "-1");
		c.setTitle("Comment Title [1] [" + caseNumber + "]");
		c.setText("It appears that is it currently impossible to have multiple kickstarts for the same IP range (eg: present a RHEL3 and a RHEL4 kickstart to the same set of IP's).");
		c.setPublic(true);
		c.setCaseNumber(caseNumber);

		Comment c2 = new Comment();
		c2.setId(caseNumber + "-2");
		c2.setTitle("Comment Title [2] [" + caseNumber + "]");
		c2.setText("Any updates?\n\nthanks,\nRobert");
		c2.setPublic(true);
		c2.setCaseNumber(caseNumber);

		Comment c3 = new Comment();
		c3.setId(caseNumber + "-3");
		c3.setTitle("Comment Title [3] [" + caseNumber + "]");
		c3.setText("Please do the following\n\necho '1' > /proc/sys/fixit\necho \"sys.fixit = 1\"\n\nThen reboot the system.");
		c3.setPublic(true);
		c3.setCaseNumber(caseNumber);


		List<Comment> comments = new ArrayList<Comment>();
		comments.add(c);
		comments.add(c2);
		comments.add(c3);
			
		return comments;
	}
}
