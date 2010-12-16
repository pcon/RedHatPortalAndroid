package com.redhat.gss.avalon.android;

import junit.framework.Assert;

import org.testng.annotations.Test;

@Test
public class CaseParserTest {

	@Test(enabled = false)
	public void testSomethingSimple() {
		CaseParser caseParser = new CaseParser();
		caseParser.parse("src/test/resources/case.xml");
		Assert.assertTrue(false);
	}

}
