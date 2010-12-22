package com.redhat.gss.avalon.android;

class GenericUtils {
	public static String sqlNull (String data) {
		if (data != null) {
			return data;
		}

		return "null";
	}
}
