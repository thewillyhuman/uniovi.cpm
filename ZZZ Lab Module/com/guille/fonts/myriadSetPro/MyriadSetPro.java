package com.guille.fonts.myriadSetPro;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class MyriadSetPro {
	
	private Font Myriad_Set_Pro_Semibold;
	private Font Myriad_Set_Pro_TextItalic;
	private Font Myriad_Set_Pro_Text;
	private Font Myriad_Set_Pro_Thin;
	private Font Myriad_Set_Pro_Ultralight;
	private Font Myriad_Set_Pro_Medium;
	private Font Myriad_Set_Pro_Bold;
	
	public MyriadSetPro() {
		try {
			Myriad_Set_Pro_Semibold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_semibold.ttf"));
			Myriad_Set_Pro_TextItalic = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_text-italic.ttf"));
			Myriad_Set_Pro_Text = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_text.ttf"));
			Myriad_Set_Pro_Thin = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_thin.ttf"));
			Myriad_Set_Pro_Ultralight = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_ultralight.ttf"));
			Myriad_Set_Pro_Medium = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_medium.ttf"));
			Myriad_Set_Pro_Bold = Font.createFont(Font.TRUETYPE_FONT, new File("com/guille/fonts/myriadSetPro/myriad-set-pro_bold.ttf"));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the myriad_Set_Pro_Semibold
	 */
	public Font getMyriad_Set_Pro_Semibold() {
		return Myriad_Set_Pro_Semibold;
	}

	/**
	 * @return the myriad_Set_Pro_TextItalic
	 */
	public Font getMyriad_Set_Pro_TextItalic() {
		return Myriad_Set_Pro_TextItalic;
	}

	/**
	 * @return the myriad_Set_Pro_Text
	 */
	public Font getMyriad_Set_Pro_Text() {
		return Myriad_Set_Pro_Text;
	}

	/**
	 * @return the myriad_Set_Pro_Thin
	 */
	public Font getMyriad_Set_Pro_Thin() {
		return Myriad_Set_Pro_Thin;
	}

	/**
	 * @return the myriad_Set_Pro_Ultralight
	 */
	public Font getMyriad_Set_Pro_Ultralight() {
		return Myriad_Set_Pro_Ultralight;
	}

	/**
	 * @return the myriad_Set_Pro_Medium
	 */
	public Font getMyriad_Set_Pro_Medium() {
		return Myriad_Set_Pro_Medium;
	}
	
	/**
	 * @return the myriad_Set_Pro_Bold
	 */
	public Font getMyriad_Set_Pro_Bold() {
		return Myriad_Set_Pro_Bold;
	}

}
