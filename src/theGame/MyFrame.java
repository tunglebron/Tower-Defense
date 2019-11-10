package theGame;

import theGame.MyPanel;
import java.util.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.*;

public class MyFrame extends JFrame{
	public static JLabel headerLabel;
	public static JLabel statusLabel;
	private static MyPanel panelBackground;
	private static MyGameStage panelGameStage;
	
	public MyFrame() {
		initUI();
	}
	
	private void initUI() {

        setTitle("Tower Defense");
        setSize(1280,720);
        setResizable(false);
        
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);
        
        addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent windowEvent) {
        		System.exit(0);
        	}
        });
        
        add(headerLabel);
        add(statusLabel);
		setVisible(true);

    }
	
	public void showBackground() {        
		panelBackground = new MyPanel("src/icon/MenuBg.png");
        add(panelBackground);
        panelBackground.setVisible(true);
        
        showGameStartButton();
        
        pack();
	}
	
	private void showGameStartButton() {
		JButton startButton = new JButton(new ImageIcon("src/icon/Start Defense Button.png"));
		startButton.setBounds(535, 500,210, 48);
		startButton.setBorderPainted(true);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBackground.setVisible(false);
		        panelGameStage = new MyGameStage();
		        add(panelGameStage);
		        panelGameStage.setVisible(true);
				
				remove(panelBackground);
			}
		});
		panelBackground.add(startButton);
		panelBackground.setLayout(null);
		
		setVisible(true);
	}
	
	public void menu() {
		MyFrame f1 = this;
		final JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		final JMenu aboutMenu = new JMenu("About");
		
		// item in File
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");
		JMenuItem highScore = new JMenuItem("High Score");
		highScore.setActionCommand("High Score");
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.setActionCommand("New Game");
		
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int output = JOptionPane.showConfirmDialog(f1,"New Game?","New Game",JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					// dong lenh khoi tao man game moi
					panelBackground.setVisible(false);
			        panelGameStage = new MyGameStage();
			        add(panelGameStage);
			        panelGameStage.setVisible(true);
					
					remove(panelBackground);
				}
			}
		});
		
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int output = JOptionPane.showConfirmDialog(f1,"Do you want to exit?","Quit Game",JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
			}
		});
		
		highScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(f1, "HighScore");
			}
		});
			
	    //add item to menu
		fileMenu.add(newGame);
		fileMenu.addSeparator();
		fileMenu.add(highScore);
	    fileMenu.addSeparator();
	    fileMenu.add(exitMenuItem);
	    
	    // add menu to menu bar
	    menuBar.add(fileMenu);
	    menuBar.add(aboutMenu);
	    
	    setJMenuBar(menuBar);
	    setVisible(true);
	}
}
