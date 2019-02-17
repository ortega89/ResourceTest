package com.ortega.resources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Main {

	private static ImagePanel imgPanel;
	private static PathBox path;
	private static JButton loadFile;
	private static JButton loadStream;
	private static JFrame frame;

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JFrame("Show picture");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		imgPanel = new ImagePanel(640, 480);		
		JPanel loader = new JPanel(new BorderLayout());
		
		path = new PathBox("hero.jpg", "onion.jpg", "owl.jpg");
		loadFile = new JButton("Load file");
		loadStream = new JButton("Load resource as stream");
		
		loadFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String filePath = (String) path.getSelectedItem();
					File f = new File(filePath);
					BufferedImage img = ImageIO.read(f);
					imgPanel.setImage(img);
					imgPanel.repaint();
				} catch (Exception ex) {
					error(ex);
				}
			}
		});
		
		loadStream.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String resourcePath = (String) path.getSelectedItem();
					InputStream is = getClass().getResourceAsStream(resourcePath);
					BufferedImage img = ImageIO.read(is);
					imgPanel.setImage(img);
					imgPanel.repaint();
				} catch (Exception ex) {
					error(ex);
				}
			}
		});
		
		loader.add(path, BorderLayout.NORTH);
		loader.add(loadFile, BorderLayout.WEST);
		loader.add(loadStream, BorderLayout.EAST);
		
		frame.add(imgPanel, BorderLayout.CENTER);
		frame.add(loader, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected static void error(Exception ex) {
		JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
	}
	
	
}
