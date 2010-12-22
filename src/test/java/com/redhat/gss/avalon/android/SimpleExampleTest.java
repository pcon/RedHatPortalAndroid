package com.redhat.gss.avalon.android;

import java.io.File;

import junit.framework.Assert;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.testng.annotations.Test;

import com.redhat.gss.avalon.android.model.Case;

@Test
public class SimpleExampleTest {

	// TODO Why isn't maven finding this file as simply "case.xml"?
	private static final String CASE_FILE = "src/test/resources/case.xml";

	public void testCaseSerializer() {
		Serializer serializer = new Persister();
		File file = new File(CASE_FILE);

		try {
			Case kase = serializer.read(Case.class, file);
			Assert.assertTrue(kase.isClosed());
			Assert.assertEquals("00053329", kase.getCaseNumber());
			Assert.assertEquals("Jim Moran", kase.getCreatedBy());
			// Assert.assertEquals(null, kase.getCreatedDate());
			Assert.assertEquals("Case Migration", kase.getLastModifiedBy());
			// Assert.assertEquals(null, kase.getLastModifiedDate());
			Assert.assertEquals("500A0000003habjIAA", kase.getId());
			Assert.assertEquals(
					"https://api.avalon-ci.gss.redhat.com/rs/cases/00053329",
					kase.getUri());
			Assert.assertEquals("test", kase.getSummary());
			Assert.assertEquals("test", kase.getDescription());
			Assert.assertEquals("Closed", kase.getStatus());
			Assert.assertEquals("Developer Support - Application Server",
					kase.getProduct());
			Assert.assertEquals("3.0.0", kase.getVersion());
			Assert.assertEquals("Info", kase.getType());
			Assert.assertEquals("540155", kase.getAccountNumber());
			Assert.assertFalse(kase.isEscalated());
			Assert.assertEquals("Test User", kase.getContactName());
			Assert.assertEquals("Case Migration", kase.getOwner());
			Assert.assertEquals("4 (Low)", kase.getSeverity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
