package theGame.entity.tile.tower;

import java.awt.Image;

import javax.swing.ImageIcon;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

public class SniperTower extends AbstractTower implements GameTile {
	public SniperTower(int x, int y) {
		this.x = x;
		this.y = y;
		this.bulletSpeed = 2; // tuy chinh
		this.damage = 40; // tuy chinh
		this.shootingDistance = 400; // tuy chinh
		graphic();
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public void graphic() {
        ImageIcon ii = new ImageIcon("");
        myImage = ii.getImage(); 
	}
	
	@Override
	public Image getImage() {
		return this.myImage;
	}
	
	// attack enemy
	public void fire(int target_x, int target_y, int targetSpeed) {
		if (this.towerBullet.size() == 0) {
			towerBullet.add(new Bullet(this.x + 25, this.y - 10, this.bulletSpeed, this.damage, target_x, target_y));
			towerBullet.add(new Bullet(this.x + 25, this.y - 10, this.bulletSpeed, this.damage, target_x + targetSpeed, target_y));
		}
		
	}
	
}
