package com.guille.fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class SansSerifFont {

	private Font SF_UI_Display_Black;
	private Font SF_UI_Display_Bold;
	private Font SF_UI_Display_Heavy;
	private Font SF_UI_Display_Light;
	private Font SF_UI_Display_Medium;
	private Font SF_UI_Display_Regular;
	private Font SF_UI_Display_Semibold;
	private Font SF_UI_Display_Thin;
	private Font SF_UI_Display_Ultralight;
	// -- End Display, start Text.
	private Font SF_UI_Text_Bold;
	private Font SF_UI_Text_BoldItalic;
	private Font SF_UI_Text_Heavy;
	private Font SF_UI_Text_HeavyItalic;
	private Font SF_UI_Text_Light;
	private Font SF_UI_Text_LightItalic;
	private Font SF_UI_Text_Medium;
	private Font SF_UI_Text_MediumItalic;
	private Font SF_UI_Text_Regular;
	private Font SF_UI_Text_RegularItalic;
	private Font SF_UI_Text_Semibold;
	private Font SF_UI_Text_SemiboldItalic;

	public SansSerifFont() {
		try {
			// First block for Display Sub-Type.
			SF_UI_Display_Black = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Black.otf"));
			SF_UI_Display_Bold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Bold.otf"));
			SF_UI_Display_Heavy = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Heavy.otf"));
			SF_UI_Display_Light = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Light.otf"));
			SF_UI_Display_Medium = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Medium.otf"));
			SF_UI_Display_Regular = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Regular.otf"));
			SF_UI_Display_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Semibold.otf"));
			SF_UI_Display_Thin = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Thin.otf"));
			SF_UI_Display_Ultralight = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Display-Ultralight.otf"));

			// First block for Display Sub-Type.
			SF_UI_Text_Bold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Bold.otf"));
			SF_UI_Text_BoldItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-BoldItalic.otf"));
			SF_UI_Text_Heavy = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Heavy.otf"));
			SF_UI_Text_HeavyItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-HeavyItalic.otf"));
			SF_UI_Text_Light = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Light.otf"));
			SF_UI_Text_LightItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-LightItalic.otf"));
			SF_UI_Text_Medium = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Medium.otf"));
			SF_UI_Text_MediumItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-MediumItalic.otf"));
			SF_UI_Text_Regular = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Regular.otf"));
			SF_UI_Text_RegularItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-RegularItalic.otf"));
			SF_UI_Text_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-Semibold.otf"));
			SF_UI_Text_SemiboldItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/SF-UI-Text-SemiboldItalic.otf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the sF_UI_Display_Black
	 */
	public Font getSF_UI_Display_Black() {
		return SF_UI_Display_Black;
	}

	/**
	 * @return the sF_UI_Display_Bold
	 */
	public Font getSF_UI_Display_Bold() {
		return SF_UI_Display_Bold;
	}

	/**
	 * @return the sF_UI_Display_Heavy
	 */
	public Font getSF_UI_Display_Heavy() {
		return SF_UI_Display_Heavy;
	}

	/**
	 * @return the sF_UI_Display_Light
	 */
	public Font getSF_UI_Display_Light() {
		return SF_UI_Display_Light;
	}

	/**
	 * @return the sF_UI_Display_Medium
	 */
	public Font getSF_UI_Display_Medium() {
		return SF_UI_Display_Medium;
	}

	/**
	 * @return the sF_UI_Display_Regular
	 */
	public Font getSF_UI_Display_Regular() {
		return SF_UI_Display_Regular;
	}

	/**
	 * @return the sF_UI_Display_Semibold
	 */
	public Font getSF_UI_Display_Semibold() {
		return SF_UI_Display_Semibold;
	}

	/**
	 * @return the sF_UI_Display_Thin
	 */
	public Font getSF_UI_Display_Thin() {
		return SF_UI_Display_Thin;
	}

	/**
	 * @return the sF_UI_Display_Ultraligth
	 */
	public Font getSF_UI_Display_Ultralight() {
		return SF_UI_Display_Ultralight;
	}

	/**
	 * @return the sF_UI_Text_Bold
	 */
	public Font getSF_UI_Text_Bold() {
		return SF_UI_Text_Bold;
	}

	/**
	 * @return the sF_UI_Text_BoldItalic
	 */
	public Font getSF_UI_Text_BoldItalic() {
		return SF_UI_Text_BoldItalic;
	}

	/**
	 * @return the sF_UI_Text_Heavy
	 */
	public Font getSF_UI_Text_Heavy() {
		return SF_UI_Text_Heavy;
	}

	/**
	 * @return the sF_UI_Text_HeavyItalic
	 */
	public Font getSF_UI_Text_HeavyItalic() {
		return SF_UI_Text_HeavyItalic;
	}

	/**
	 * @return the sF_UI_Text_Light
	 */
	public Font getSF_UI_Text_Light() {
		return SF_UI_Text_Light;
	}

	/**
	 * @return the sF_UI_Text_LightItalic
	 */
	public Font getSF_UI_Text_LightItalic() {
		return SF_UI_Text_LightItalic;
	}

	/**
	 * @return the sF_UI_Text_Medium
	 */
	public Font getSF_UI_Text_Medium() {
		return SF_UI_Text_Medium;
	}

	/**
	 * @return the sF_UI_Text_MediumItalic
	 */
	public Font getSF_UI_Text_MediumItalic() {
		return SF_UI_Text_MediumItalic;
	}

	/**
	 * @return the sF_UI_Text_Regular
	 */
	public Font getSF_UI_Text_Regular() {
		return SF_UI_Text_Regular;
	}

	/**
	 * @return the sF_UI_Text_RegularItalic
	 */
	public Font getSF_UI_Text_RegularItalic() {
		return SF_UI_Text_RegularItalic;
	}

	/**
	 * @return the sF_UI_Text_Semibold
	 */
	public Font getSF_UI_Text_Semibold() {
		return SF_UI_Text_Semibold;
	}

	/**
	 * @return the sF_UI_Text_SemiboldItalic
	 */
	public Font getSF_UI_Text_SemiboldItalic() {
		return SF_UI_Text_SemiboldItalic;
	}
}
