package com.redhat.gss.avalon.android;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.redhat.gss.strata.model.Case;

public class CaseSAXHandler extends DefaultHandler {

	private final String LOG_TAG = "CaseParser: ";

	private Case kase;
	
	@Override
	public void startDocument() throws SAXException {
		Log.i(LOG_TAG, "Parsing case object");
		kase = null;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
	}
	
	@Override
	public void endDocument() throws SAXException {
		Log.i(LOG_TAG, "Finished parsing case object");
	}

	public Case getParsedCase() {
		return kase;
	}

}
