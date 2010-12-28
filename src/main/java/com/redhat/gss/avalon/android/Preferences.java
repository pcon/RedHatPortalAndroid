package com.redhat.gss.avalon.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceClickListener;

public class Preferences extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.preferences);
	}

	public String getUsername(Context c) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
		return prefs.getString("usernamePref", "YAR");
	}
}
