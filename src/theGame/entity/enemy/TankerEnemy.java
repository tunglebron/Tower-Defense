package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TankerEnemy extends Enemy{
	
	public TankerEnemy(int x) {
		posX = x;
		this.posY = 50;
		this.visible = true;
		
		damage = 75;
		blood = 250;
		speed = 1;
		defense = 10;
		award = 20;
	}
	
	public void move() {
		if (this.posY == 50 && this.posX != 155) {
			posX += speed;
			return;
		}
		if (this.posX == 155 && this.posY != 600) {
			posY += speed;
			return;
		}
		if (this.posY == 600 && this.posX != 410) {
			posX += speed;
			return;
		}
		if (this.posX == 410 && this.posY != 200) {
			posY -= speed;
			return;
		}
		if (this.posY == 200 && this.posX != 760) {
			posX += speed;
			return;
		}
		if (this.posX == 760 && this.posY != 550) {
			posY += speed;
			return;
		}
		if (this.posY == 550 && this.posX != 1000) {
			posX += speed;
			return;
		}
		if (this.posY == 550 && this.posX == 1000) {
			visible = false;
			finishPoint = true;
		}					
	}
	
	// hien thi do hoa
    public Image loadImage() {
    	ImageIcon ii;
    	if (this.posX == 155 || this.posX== 760) {
        	ii = new ImageIcon("src/icon/Enemy/TankerEnemy/TankerEnemy_walk_down.gif");
        	return ii.getImage();
    	}
    	if (this.posX == 410) {
        	ii = new ImageIcon("src/icon/Enemy/TankerEnemy/TankerEnemy_walk_up.gif");
        	return ii.getImage();	
    	}
    	
    	ii = new ImageIcon("src/icon/Enemy/TankerEnemy/TankerEnemy_walk.gif");
        return ii.getImage();        
    }
    
	public void graphic() {
		
	}
	
	// cap nhat trang thai cho cac doi tuong dong
	public void update() {
		move();
	}
	
}