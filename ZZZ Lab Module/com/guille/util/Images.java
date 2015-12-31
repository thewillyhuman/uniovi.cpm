package com.guille.util;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Images {
	
	/**
	 * Given a component a the path of the image will compute the resized image for that specific component.
	 * 
	 * @param comp where the image is going to be placed.
	 * @param picture to set.
	 * @return an ImagaIcon that has the same size as the component given.
	 */
	public static ImageIcon resize(Component comp, String picture) {
		ImageIcon imageIcon = new ImageIcon(picture); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(comp.getWidth(), comp.getHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		return imageIcon;
	}

}
