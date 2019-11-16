package theGame.entity.enemy;

import theGame.entity.GameEntity;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public abstract class Enemy implements GameEntity{
	protected int posX;
	protected int posY;
	protected int blood;
	protected int speed;
	protected int defense;
	protected int award;
	protected int damage;
	protected boolean visible;
	public boolean finishPoint = false;
	

	protected Enemy() {
		
	}

	@Override
	public final int getPosX() {
		return posX;
	}

	protected final void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public final int getPosY() {
		return posY;
	}

	protected final void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getBlood() {
		return this.blood;
	}
	
	public int getAward() {
		return this.award;
	}
	
	public void setBlood(int getShot) {
		int temp = this.defense - getShot;
		if (temp > 0) temp = 0;
		this.blood = this.blood + temp;
	}
	
	abstract public Image loadImage();
	
	public void move() {
		
	}
	
    public Rectangle getBounds() {
        return new Rectangle(posX, posY, 40, 40);
    }

}
