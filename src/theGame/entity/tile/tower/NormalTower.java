package theGame.entity.tile.tower;

import java.awt.Image;

import javax.swing.ImageIcon;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

import java.util.ArrayList;


public class NormalTower extends AbstractTower implements GameTile {
	public NormalTower(int x, int y) {
		this.x = x;
		this.y = y;
		this.bulletSpeed = 2; // tuy chinh
		this.damage = 20; // tuy chinh
		this.shootingDistance = 200; // tuy chinh
		graphic();
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
		
	public void graphic() {
        ImageIcon ii = new ImageIcon("src/icon/Tower/kale1.png");
        myImage = ii.getImage();
	}
	
	@Override
	public Image getImage() {
		return this.myImage;
	}
	
	// attack enemy

	

	
}
