package theGame;
import theGame.*;

import java.awt.EventQueue;


public class Main {
	public Main() {
		mainFrame = new MyFrame();
		mainFrame.showBackground();
		mainFrame.menu();
	}
	public static MyFrame mainFrame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			mainFrame = new MyFrame();
			mainFrame.showBackground();
			mainFrame.menu();
			mainFrame.setVisible(true);
		});
		
	}
}
