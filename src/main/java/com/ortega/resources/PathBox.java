package com.ortega.resources;

import javax.swing.JComboBox;

public class PathBox extends JComboBox<String> {

	private static final long serialVersionUID = 1L;

	public PathBox(String... names) {
		super(preparePaths(names));
		setEditable(true);
		setMaximumRowCount(12);
	}

	private static String[] preparePaths(String[] names) {
		String[] paths = new String[names.length * 2];
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			int j = i * 2;
			paths[j] = "/com/ortega/resources/"+name;
			paths[j+1] = "src/main/resources/com/ortega/resources/"+name;
		}
		return paths;
	}
}
