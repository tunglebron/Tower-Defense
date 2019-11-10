package theGame.entity.enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class NormalEnemy extends Enemy{
	
	public NormalEnemy() {
		this.posX = -50;
		this.posY = 40;
		this.visible = true;
		
		damage = 50;
		blood = 50;
		speed = 2;
		defense = 50;
		award = 50;
	}
	
	@Override
	public void move() {
		if (this.posY == 40 && this.posX != 150) {
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
		if (this.posY == 540 && this.posX != 1000) {
			posX += speed;
			return;
		}
		if (this.posY == 540 && this.posX == 1000) {
			visible = false;
			finishPoint = true;
		}
	}
	
	// hien thi do hoa
    public Image loadImage() {
        ImageIcon ii = new ImageIcon("src/icon/Enemy/NormalEnemy/NormalEnemy.gif");
        return ii.getImage();        
    }
    
	public void graphic() {
		
	}
	
	// cap nhat trang thai cho cac doi tuong dong
	public void update() {
		move();
	}
	
}
