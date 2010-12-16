package com.redhat.gss.avalon.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import android.util.Log;

import com.redhat.gss.strata.model.Case;

/**
 * This class implements a StAX parser for support domain objects.
 * 
 * @author Brian Dill
 * 
 */
public class CaseParser {

	private final String LOG_TAG = "CaseParser: ";

	private SAXParserFactory parserFactory;

	public CaseParser() {
		parserFactory = SAXParserFactory.newInstance();
	}

	/**
	 * TODO Perhaps this should throw an exception instead of logging and
	 * returning?
	 * 
	 * @param uri
	 */
	public void parse(String uri) {
		SAXParser parser = null;
		try {
			parser = parserFactory.newSAXParser();
			CaseSAXHandler caseHandler = new CaseSAXHandler();
			parser.parse(uri, caseHandler);
			
		} catch (ParserConfigurationException e) {
			Log.e(LOG_TAG, "Could not configure parser", e);
			return;
		} catch (SAXException e) {
			Log.e(LOG_TAG, "Encountered SAX error", e);
			return;
		} catch (IOException e) {
			Log.e(LOG_TAG, "Encountered IO error", e);
			return;
		}
	}

	/**
	 * Test method.
	 * 
	 * @return a fake list of cases
	 */
	public List<Case> getAllCases() {
		Log.i(LOG_TAG, "Generating fake list of cases");

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

	public static void parseForReal(String[] args) {

	}

}
