package theGame.entity.tile.tower;

import java.awt.Image;

import javax.swing.ImageIcon;

import theGame.entity.tile.GameTile;
import theGame.entity.enemy.Enemy;
import theGame.entity.bullet.Bullet;

public class MachineGunTower extends AbstractTower implements GameTile {
	public MachineGunTower(int x, int y) {
		this.x = x;
		this.y = y;
		this.bulletSpeed = 3; // tuy chinh
		this.damage = 20; // tuy chinh
		this.shootingDistance = 100; // tuy chinh
		graphic();
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public void graphic() {
		// bo sung anh
        ImageIcon ii = new ImageIcon("src/icon/Tower/kuled.png");
        myImage = ii.getImage(); 
	}
	
	@Override
	public Image getImage() {
		return this.myImage;
	}
	
	// attack enemy

	
	

	
}
