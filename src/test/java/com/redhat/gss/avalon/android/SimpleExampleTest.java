package com.redhat.gss.avalon.android;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.testng.annotations.Test;

@Test
public class SimpleExampleTest {

	public void testSimple() {
		System.out.println("Bout to test it");
		Serializer serializer = new Persister();
		File curent = new File(".");
		System.out.println(curent.getAbsoluteFile());

		// TODO Why isn't maven finding the test resources file correctly?
		File file = new File("src/test/resources/case.xml");
		System.out.println(file.exists());

		try {
			SimpleCase kase = serializer.read(SimpleCase.class, file);
			System.out.println("My de-ser case" + kase);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
