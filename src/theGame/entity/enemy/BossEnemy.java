package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BossEnemy extends Enemy{
	
	public BossEnemy() {
		posX = -200;
		this.posY = 35;
		this.visible = true;
		
		damage = 100;
		blood = 200;
		speed = 1;
		defense = 20;
		award = 150;
	}
	
	public void move() {
		if (this.posY == 35 && this.posX != 150) {
			posX += speed;
			return;
		}
		if (this.posX == 150 && this.posY != 590) {
			posY += speed;
			return;
		}
		if (this.posY == 590 && this.posX != 400) {
			posX += speed;
			return;
		}
		if (this.posX == 400 && this.posY != 190) {
			posY -= speed;
			return;
		}
		if (this.posY == 190 && this.posX != 750) {
			posX += speed;
			return;
		}
		if (this.posX == 750 && this.posY != 540) {
			posY += speed;
			return;
		}
		if (this.posY == 540 && this.posX != 970) {
			posX += speed;
			return;
		}
		if (this.posY == 540 && this.posX == 970) {
			visible = false;
			finishPoint = true;
		}		
	}
	
	// hien thi do hoa
    public Image loadImage() {
        ImageIcon ii;
        if (this.posX == 150 || this.posX == 750) {
        	ii = new ImageIcon("src/icon/Enemy/BossEnemy/BossEnemy-walkDown.gif");
        	return ii.getImage();
        }
        if (this.posX == 400) {
        	ii = new ImageIcon("src/icon/Enemy/BossEnemy/BossEnemy-walkUp.gif");
        	return ii.getImage();
        }
        if (this.posX >= 952) {
        	ii = new ImageIcon("src/icon/Enemy/BossEnemy/BossEnemy_attack.gif");
        	return ii.getImage();
        }
        
        ii = new ImageIcon("src/icon/Enemy/BossEnemy/BossEnemy_walk.gif");
        return ii.getImage();        
    }
    
	public void graphic() {
		
	}
	
	// cap nhat trang thai cho cac doi tuong dong
	public void update() {
		move();
	}
	
}