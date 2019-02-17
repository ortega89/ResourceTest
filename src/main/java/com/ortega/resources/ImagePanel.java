package com.ortega.resources;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage img;

	public ImagePanel(int w, int h) {
		setPreferredSize(new Dimension(w, h));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
}
