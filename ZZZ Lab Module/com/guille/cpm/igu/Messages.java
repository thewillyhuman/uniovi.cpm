package com.guille.cpm.igu;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.guille.util.Strings;

public class Messages {
	
	private static final String BUNDLE_NAME = "com.guille.cpm.files.ResourceBundle_en_US"; //$NON-NLS-1$
	private static final String BUNDLE_NAME_LOCAL = "com.guille.cpm.files.ResourceBundle";

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static Locale localization = Locale.getDefault();

	private Messages() {
	}

	public static String getString(String key) {
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME_LOCAL, localization);
		try {
			return Strings.deAccent(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			System.out.println("**** MISSING KEY **** " + key);
			return '!' + key + '!';
		}
	}
}
