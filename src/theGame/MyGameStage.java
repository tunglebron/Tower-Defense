package theGame;

import theGame.entity.AbstractEntity;
import theGame.entity.tile.tower.*;
import theGame.entity.enemy.*;
import theGame.entity.bullet.Bullet;
import theGame.entity.NonMoving.*;
import theGame.MyFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class MyGameStage extends JPanel implements ActionListener {
	private int money = 200; // tien de mua thap
	private int score = 0; // diem so
	private int live = 500; // mang de tiep tuc choi
	private int level; // game level
	
	private Timer timer;
	private final int DELAY = 10; // delay time
	private boolean ingame = false;
	private boolean win = true;
	
	private JPanel sidePanel;
	private JButton playButton = new JButton("Next Level");
	private JButton Button1 = new JButton();
	private JButton Button2 = new JButton();
	private JButton Button3 = new JButton();
	private boolean addTower1 = false; // add Normal Tower
	private boolean addTower2 = false; // add MachineGun Tower
	private boolean addTower3 = false; // add Sniper Tower
	
	private Image[] myImage;
	public static List<Enemy> gameEnemy;
	public final List<AbstractTower> towerObjects;
	public final List<Road> road;
	
    public MyGameStage() {
        setFocusable(true); // Focus on JPanel to receive key events
        requestFocus();
            
        sidePanel = new JPanel();
        
        gameEnemy = new ArrayList<>();
        towerObjects = new ArrayList<>();
        road = new ArrayList<>();
        addTower1 = false;
        addTower2 = false;
        addTower3 = false;
        mouseAdapter();
        
        initBoard();

        initSidePanel();
    	
    	this.level = 0;
    	if (this.level != 0) this.level = 0;
          
        if (!ingame) {
        	initPlayButton();
        }
    	
    }
    
    private void initSidePanel() {
    	add(sidePanel);
    	sidePanel.setBounds(1050, 0, 230, 720);
       	sidePanel.setBackground(Color.LIGHT_GRAY);
    	
        playButton.setBounds(1165, 500, 200, 100);
    	playButton.setBorderPainted(true);
    	sidePanel.add(playButton);
    	
    	TowerButton();
    	
    	setLayout(null);
    }
    
    private void mouseAdapter() {
        addMouseListener(new MouseAdapter() {
        	public void mousePressed(MouseEvent e) {
        		System.out.println(e.getX() + "," + e.getY());
        	}
        });	
    }
    
    private void TowerButton() {
    	Button1.setIcon(new ImageIcon("src/icon/Tower/NormalTower.png"));
    	Button1.setText("Money:20 Damage:25 Speed:2");
    	Button1.setBorderPainted(false);
    	Button1.setBounds(1100, 900, 200, 100);
    	Button1.addMouseListener(new MouseAdapter() {
    		public void mouseReleased(MouseEvent e) {
    			if (addTower1 == true) {
    				if ( (e.getXOnScreen() >= 0 && e.getXOnScreen() <= 1000) && (e.getYOnScreen() >= 0 && e.getYOnScreen() <= 720) ) {	
    					int Xpos = e.getXOnScreen() - e.getXOnScreen()%50;
    					int Ypos = e.getYOnScreen() - e.getYOnScreen()%50 - 50;
    					boolean add = true;
    					for (int i = 0; i < road.size(); i++) {
    						if (road.get(i).getX() <= Xpos && 
    							road.get(i).getX() + 50 > Xpos &&
    							road.get(i).getY() <= Ypos &&
    							road.get(i).getY() + 50 > Ypos) {
    							add = false;
    							break;
    						}
    					}
    					if (add) {
    						for (int i = 0; i < towerObjects.size(); i++) {
        						if (towerObjects.get(i).getPosX() <= Xpos && 
            						towerObjects.get(i).getPosX() + 50 > Xpos &&
            						towerObjects.get(i).getPosY() <= Ypos &&
            						towerObjects.get(i).getPosY() + 50 > Ypos) {
            						add = false;
            						break;
            					}	
    						}
    					}
    					if (add) {
    						towerObjects.add(new NormalTower(Xpos,Ypos));
    						money -= 20;
    						repaint();
    					}
    					addTower1 = false;
    				}
    			}
    		}
    	});
    	Button1.addMouseMotionListener(new MouseMotionAdapter() {
    		public void mouseDragged(MouseEvent e) {
    			if (money >= 20) addTower1 = true;
    		}
    	});
    	
    	Button2.setIcon(new ImageIcon("src/icon/Tower/kuled.png"));
    	Button2.setText("Money:20 Damage:25 Speed:3");
    	Button2.setBorderPainted(false);
    	Button2.setBounds(1100, 900, 200, 100);
    	Button2.addMouseListener(new MouseAdapter() {
    		public void mouseReleased(MouseEvent e) {
    			if (addTower2 == true) {
    				if ( (e.getXOnScreen() >= 0 && e.getXOnScreen() <= 1000) && (e.getYOnScreen() >= 0 && e.getYOnScreen() <= 720) ) {
    					int Xpos = e.getXOnScreen() - e.getXOnScreen()%50;
    					int Ypos = e.getYOnScreen() - e.getYOnScreen()%50 - 50;
    					boolean add = true;
    					for (int i = 0; i < road.size(); i++) {
    						if (road.get(i).getX() <= Xpos && 
    							road.get(i).getX() + 50 > Xpos &&
    							road.get(i).getY() <= Ypos &&
    							road.get(i).getY() + 50 > Ypos) {
    							add = false;
    							break;
    						}
    					}
    					if (add) {
    						for (int i = 0; i < towerObjects.size(); i++) {
        						if (towerObjects.get(i).getPosX() <= Xpos && 
            						towerObjects.get(i).getPosX() + 50 > Xpos &&
            						towerObjects.get(i).getPosY() <= Ypos &&
            						towerObjects.get(i).getPosY() + 50 > Ypos) {
            						add = false;
            						break;
            					}	
    						}
    					}
    					if (add) {
    						towerObjects.add(new MachineGunTower(Xpos,Ypos));
    						money -= 20;
    						repaint();
    					}
    					addTower2 = false;
    				}
    			}
    		}
    	});
    	Button2.addMouseMotionListener(new MouseMotionAdapter() {
    		public void mouseDragged(MouseEvent e) {
    			if (money >= 20) addTower2 = true;
    		}
    	});
    	
    	Button3.setIcon(new ImageIcon("src/icon/Tower/SniperTower.png"));
    	Button3.setText("Money:40 Damage:40 Speed:2");
    	Button3.setBorderPainted(false);
    	Button3.setBounds(1100, 900, 200, 100);
    	Button3.addMouseListener(new MouseAdapter() {
    		public void mouseReleased(MouseEvent e) {
    			if (addTower3 == true) {
    				if ( (e.getXOnScreen() >= 0 && e.getXOnScreen() <= 1000) && (e.getYOnScreen() >= 0 && e.getYOnScreen() <= 720) ) {
    					int Xpos = e.getXOnScreen() - e.getXOnScreen()%50;
    					int Ypos = e.getYOnScreen() - e.getYOnScreen()%50 - 50;
    					boolean add = true;
    					for (int i = 0; i < road.size(); i++) {
    						if (road.get(i).getX() <= Xpos && 
    							road.get(i).getX() + 50 > Xpos &&
    							road.get(i).getY() <= Ypos &&
    							road.get(i).getY() + 50 > Ypos) {
    							add = false;
    							break;
    						}
    					}
    					if (add) {
    						for (int i = 0; i < towerObjects.size(); i++) {
        						if (towerObjects.get(i).getPosX() <= Xpos && 
            						towerObjects.get(i).getPosX() + 50 > Xpos &&
            						towerObjects.get(i).getPosY() <= Ypos &&
            						towerObjects.get(i).getPosY() + 50 > Ypos) {
            						add = false;
            						break;
            					}	
    						}
    					}
    					if (add) {
    						towerObjects.add(new SniperTower(Xpos,Ypos));
    						money -= 40;
    						repaint();
    					}
    					addTower3 = false;
    				}
    			}
    		}
    	});
    	Button3.addMouseMotionListener(new MouseMotionAdapter() {
    		public void mouseDragged(MouseEvent e) {
    			if (money >= 40) addTower3 = true;
    		}
    	});
    	
    	sidePanel.add(Button1);
    	sidePanel.add(Button2);
    	sidePanel.add(Button3);
    }
    
    private void initPlayButton() {
    	playButton.setVisible(true);
    	playButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (level == 0) {
        			playButton.setVisible(false);
        			ingame = true;
        			initGame();
    			}
    		}
    	});	
    }
    
    private void initGame() {
    	if (level == 0) this.level++;
        initEnemy();
        ingame = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    

    private void reInitPlayButton() {
    	playButton.setVisible(true);
    	playButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			playButton.setVisible(false);
    			initEnemy();	
    			timer.isRepeats();
    			ingame = true;
    		}
    	});	    	
    }

    public boolean getIngame() {
    	return this.ingame;
    }
      
    private void initBoard() {
    	myImage = new Image[5];
    	myImage[0] = loadImage("src/icon/sand2.jpg");
    	myImage[1] = loadImage("src/icon/grass1.png");
    	myImage[2] = loadImage("src/icon/Gate.png");
    	myImage[3] = loadImage("src/icon/sand.jpg");
    	myImage[4] = loadImage("src/icon/grass_TowerDefense.jpg");
    	for (int i = 0; i < 14; i++) {
    		for (int j = 0; j < 21; j++) {
    			if (MAP_SPRITES_1[i][j] == "2") {
    				road.add(new Road(j*50,i*50));
    			}
    		}
    	}  
    }
    
    private void initEnemy() {
    	if (level == 1) {
    		gameEnemy.add(new BossEnemy());
    	}
    	if (level == 2) {
    		gameEnemy.add(new BossEnemy());
    		gameEnemy.add(new NormalEnemy());
    	}
    	
    }
    
    private Image loadImage(String file) {
        ImageIcon ii = new ImageIcon(file);
        return ii.getImage();        
    }
    
    private static final String[][] MAP_SPRITES_1 = new String[][] {
    	{"1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"2","2","2","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","2","2","2", "2","2","2","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "1","1","1","1","1"},
    	{"1","1","1","2", "1","1","1","1", "2","1","1","1", "1","1","1","2", "2","2","2","2","2"},
    	{"1","1","1","2", "2","2","2","2", "2","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    	{"1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1", "1","1","1","1","1"},
    };
    
    private void drawTower(Graphics g) {
    		for (int i = 0; i < towerObjects.size(); i++) {
    			AbstractTower tower = towerObjects.get(i);
    			g.drawImage(tower.getImage(), towerObjects.get(i).getPosX(), towerObjects.get(i).getPosY(), null);
    			List<Bullet> bullet = tower.towerBullet;
    			for (int j = 0; j < bullet.size(); j++) {
    				if (bullet.get(j).isVisible() && gameEnemy.size() != 0) {
    					g.drawImage(bullet.get(j).getImage(), bullet.get(j).getX(), bullet.get(j).getY(), null);
    				}
    			}
    		}
    }
    
    private void drawMap(Graphics g) {
    	for (int i = 0; i < 14; i++) {
    		for (int j = 0; j < 21; j++) {
    			if (MAP_SPRITES_1[i][j] == "1") g.drawImage(myImage[1], j*50, i*50, null); // draw grass	
    			if (MAP_SPRITES_1[i][j] == "2") g.drawImage(Road.loadImage(), j*50, i*50, null); // draw road
    		}
    	}    	
    }
    
    private void drawEnemy(Graphics g) {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		if (gameEnemy.get(i).isVisible()) g.drawImage(gameEnemy.get(i).loadImage(), gameEnemy.get(i).getPosX(), gameEnemy.get(i).getPosY(), null);
    	}
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	drawMap(g); // draw map
    	if (win) {		
    		if (ingame && this.level < 4) {
    			drawEnemy(g); // draw enemy
    		}
    		if (this.level < 4) drawTower(g); // draw tower
    		if (this.level == 4) {
                String msg = "You win";
                Font small = new Font("Helvetica", Font.BOLD, 30);
                
                g.setColor(Color.YELLOW);
                g.setFont(small);
                g.drawString(msg, 505, 360);	
                timer.stop();
    		}
    	}
    	else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 30);
            
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, 505, 360);
    	}
    	g.drawImage(myImage[2], 20*50, 8*50, null); // draw gate
    	Toolkit.getDefaultToolkit().sync();
    }
    
    private void inGame() {
    	if (live <= 0) {
    		win = false;
    		deleteAllObjects();
    		timer.stop();
    	}
    	if (this.level == 3) this.level++;
    	if (live > 0 && gameEnemy.size() == 0 && this.level < 3 && this.level != 0) {
    		for (int i = 0; i < towerObjects.size(); i++) {
    			List<Bullet> bullet = towerObjects.get(i).towerBullet;
    			bullet.removeAll(bullet);
    		}
    		this.level++;
    		ingame = false;
    		reInitPlayButton();
    	}
    }
    
    // chi xoa het cac doi tuong khi nguoi choi thua
    public void deleteAllObjects() {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		gameEnemy.remove(i);
    	}
    	for (int i = 0; i < towerObjects.size(); i++) {
    		towerObjects.remove(i);
    	}
    }
    
    // thuc hien vong lap game
    public void actionPerformed(ActionEvent e) {
    	if (ingame) {
    		inGame();
    	
    		updateEnemy();
    	
    		updateTower();
    		   	
    		checkCollisions();
    	}
    	
    	repaint();
    }
    
    // cap nhat di chuyen cho enemy
    private void updateEnemy() {
    	for (int i = 0; i < gameEnemy.size(); i++) {
    		Enemy a = gameEnemy.get(i);
    		if (a.isVisible()) {
    			a.update();
    			if (a.finishPoint) {
    				live -= a.getDamage();
    				gameEnemy.remove(i);
    			}
    			continue;
    		} else {
    			gameEnemy.remove(i);
    		}
    	}
    }
    
    // cap nhat tower
    private void updateTower() {
    	for (int i = 0; i < towerObjects.size(); i++) {
    		towerObjects.get(i).update();
    		if (towerObjects.get(i).getTime() == 70) {
    			for (int j = 0; j < gameEnemy.size(); j++) {
    				if ( towerObjects.get(i).distane(gameEnemy.get(j).getPosX(), gameEnemy.get(j).getPosY()) <= towerObjects.get(i).getShootingDistance() && gameEnemy.get(j).getPosX() > 0) {
    					towerObjects.get(i).fire(gameEnemy.get(j).getPosX(), gameEnemy.get(j).getPosY(), gameEnemy.get(j).getSpeed());
    					break;
    				}	
    			}
    		}
    	}
    }
    
    // kiem tra xem bullet co ban trung vao enemy hay khong
    private void checkCollisions() {
    	for (int i = 0; i < towerObjects.size(); i++) {
    		List<Bullet> bullet = towerObjects.get(i).towerBullet;
    		for (int j = 0; j < bullet.size(); j++) {
    			for (int k = 0; k < gameEnemy.size(); k++) {
    				if (bullet.get(j).getBounds().intersects(gameEnemy.get(k).getBounds())) {
    					bullet.get(j).setVisible(false);
    					bullet.remove(j);
    					gameEnemy.get(k).setBlood(towerObjects.get(i).getDamage());
    					if (gameEnemy.get(k).getBlood() <= 0) {
    						money += gameEnemy.get(k).getAward();
    						gameEnemy.remove(k);
    					}
    					break;
    				}
    			}
    		}
    	}
    }
    

}
