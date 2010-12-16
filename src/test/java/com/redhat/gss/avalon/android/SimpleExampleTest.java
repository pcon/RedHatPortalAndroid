package com.redhat.gss.avalon.android;

import java.io.File;

import junit.framework.Assert;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.testng.annotations.Test;

import com.redhat.gss.avalon.android.model.Case;

@Test
public class SimpleExampleTest {

	public void testSerializer() {
		Serializer serializer = new Persister();

		// TODO Why isn't maven finding the test resources file correctly?
		File file = new File("src/test/resources/case.xml");
		try {
			Case kase = serializer.read(Case.class, file);
			Assert.assertEquals("00053329", kase.getCaseNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
