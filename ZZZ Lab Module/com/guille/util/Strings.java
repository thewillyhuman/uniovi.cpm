package com.guille.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Strings {
	
	/**
	 * Deaccents all the given strings.
	 * 
	 * @param str to deaccents.
	 * @return the string provided without accents.
	 */
	public static String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

}
