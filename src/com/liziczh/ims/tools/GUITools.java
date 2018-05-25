package com.liziczh.ims.tools;


import java.awt.*;

public class GUITools {
	//将窗口进行居中
	public static void center(Component c) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		int x = (kit.getScreenSize().width - c.getWidth()) / 2;
		int y = (kit.getScreenSize().height - c.getHeight()) / 2;
		c.setLocation(x, y);
	}
}
