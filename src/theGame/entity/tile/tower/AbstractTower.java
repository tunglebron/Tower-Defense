package theGame.entity.tile.tower;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

import java.awt.Image;
import java.awt.Rectangle;


import java.util.*;

public abstract class AbstractTower implements GameTile {
	protected int x, y;
	protected int bulletSpeed; // toc do dan
	protected int shootingDistance; // tam ban
	protected int damage; // sat thuong
	public List<Bullet> towerBullet = new ArrayList<Bullet>();
	protected Rectangle bounds; 
	protected Rectangle bulletRange;
	
	public abstract int getPosX();
	
	public abstract int getPosY();

	public List<Bullet> getBullets() {
		return towerBullet;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void update() {
		for (int i = 0; i < this.towerBullet.size(); i++) {
			this.towerBullet.get(i).move();
			/*
			this.towerBullet.get(i).checkVisible();
			*/
			if (distance( this.towerBullet.get(i).getX() , this.towerBullet.get(i).getY() ) > this.shootingDistance ) {
				this.towerBullet.get(i).setVisible(false);
			}
			
			if (!this.towerBullet.get(i).isVisible()) {
				this.towerBullet.remove(i);
			}
		}
	}
	
	private int distance(int a, int b) {
		return (int) Math.sqrt( (this.x-a)*(this.x-a) + (this.y-b)*(this.y-b) );
	}
	
	public void fire(int target_x, int target_y, int targetSpeed) {
		if (this.towerBullet.size() == 0) {
			towerBullet.add(new Bullet(this.x + 25, this.y - 10, this.bulletSpeed, this.damage, target_x, target_y));
			//towerBullet.add(new Bullet(this.x + 25, this.y - 10, this.bulletSpeed, this.damage, target_x + targetSpeed, target_y));
		}	
	}
	
	Image myImage;
	
	public abstract Image getImage();
	
	// dien tich tower chiem tren ban do
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, 50, 50);
	}
	
	// tam ban 
	public Rectangle getRange() {
		return new Rectangle(this.x - this.shootingDistance/2,this.y - this.shootingDistance/2,this.shootingDistance,this.shootingDistance);
	}
	
}
