package theGame;

import theGame.MyPanel;
import java.util.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.*;

public class MyFrame extends JFrame{
	private static MyPanel panelBackground;
	private static MyGameStage panelGameStage;
	
	public MyFrame() {
		initUI();
	}
	
	private void initUI() {
        setTitle("Tower Defense");
        setSize(1280,720);
        setResizable(false);
       
        addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent windowEvent) {
        		System.exit(0);
        	}
        });
        //pack();
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
		startButton.setBounds(553, 460,180, 55);
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
	
	public void showSound()
	{
		try {
			// Open an audio input stream.
			URL url = this.getClass().getClassLoader().getResource("sound/sound.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			clip.addLineListener(new LineListener()
			{
				@Override
				public void update(LineEvent event)
				{
					if (event.getType() == LineEvent.Type.STOP)
						clip.close();
				}
			});
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);

			clip.start();

			clip.loop(Clip.LOOP_CONTINUOUSLY); // chay vo tan

		} catch (UnsupportedAudioFileException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.err.println(e.getMessage());
		} 
	}
	
	public void showSound2(boolean play) throws Exception {
		URL url = this.getClass().getClassLoader().getResource("sound/sound.wav");
		Clip clip = AudioSystem.getClip();
		// getAudioInputStream() also accepts a File or InputStream
		AudioInputStream ais = AudioSystem.getAudioInputStream( url );
		clip.open(ais);
		if (play) clip.loop(Clip.LOOP_CONTINUOUSLY);
		if (!play) clip.close();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// A GUI element to prevent the Clip's daemon Thread 
				// from terminating at the end of the main()
				//JOptionPane.showMessageDialog(null, "Close to exit!");
			}
		});
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
		JMenuItem sound = new JMenuItem("Sound");
		sound.setActionCommand("Sound");
		
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int output = JOptionPane.showConfirmDialog(f1,"New Game?","New Game",JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					// dong lenh khoi tao man game moi
					panelBackground.setVisible(false);
					if (panelGameStage != null) {
						panelGameStage.setVisible(false);
					}
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
		
		sound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int output = JOptionPane.showConfirmDialog(f1,"Do you want to play background music?","Play Music",JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					try {
						showSound2(true);
					} catch (Exception e) {
						System.out.println("Cannot Play Music");
					}
				}
				if (output == JOptionPane.NO_OPTION) {
					try {
						showSound2(false);
					} catch (Exception e) {
						System.out.println("Cannot Stop Music");
					}
				}
			}
		});
			
	    //add item to menu
		fileMenu.add(newGame);
		fileMenu.addSeparator();
		fileMenu.add(sound);
		fileMenu.addSeparator();
		fileMenu.add(highScore);
	    fileMenu.addSeparator();
	    fileMenu.add(exitMenuItem);
	    fileMenu.addSeparator();
	    
	    // add menu to menu bar
	    menuBar.add(fileMenu);
	    menuBar.add(aboutMenu);
	    
	    setJMenuBar(menuBar);
	    setVisible(true);
	}
}
